import com.github.pagehelper.PageInfo;
import com.web.bean.Users;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:springmvc.xml"})
public class MVCUserDemo {
    //传入springmvc的ioc
    @Autowired
    WebApplicationContext context;
    //虚拟MVC请求，获取处理结果。
    private MockMvc mockMvc;

    @Before
    public void initMockMVC(){
        mockMvc=MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void mvcSelAllUsers() throws Exception {
        //模拟请求拿到返回值（不理解为什么“MockMvcRequestBuilders.get("/selAllUsers")”中的地址要加'/'）
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/selAllUsers").param("page", "1"))
                .andReturn();
        //请求成功之后，请求域中会有pageInfo，我们可以在页面取出pageInfo的数据
        MockHttpServletRequest request= mvcResult.getRequest();

        PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
        System.out.println("当前页码"+pageInfo.getPageNum());
        System.out.println("总页码"+pageInfo.getPages());
        System.out.println("总记录数"+pageInfo.getTotal());
        System.out.println("在页面需要连续显示的页码");
        int[] num=pageInfo.getNavigatepageNums();
        for (int i :
                num) {
            System.out.println(i);
        }
//        获取pageInfo中的数据
        List<Users> list = pageInfo.getList();
        for (Users users:
             list) {
            System.out.println("Name"+users.getUserName());
        }
    }

}
