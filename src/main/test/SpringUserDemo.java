import com.web.bean.Users;
import com.web.mapper.UsersMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class SpringUserDemo {
    @Autowired
    UsersMapper usersMapper;
    @Test
    public void selAllUsers(){
        System.out.println(usersMapper);
        List<Users> users = usersMapper.selAllUsers();
        System.out.println(users);
    }

    @Test
    public void selUser(){
        Users users = usersMapper.selUser("2", "222");
        System.out.println(users);
    }

    @Test
    public void insUser(){
        Users users =new Users();
        users.setUserNo(7);
        users.setUserName("7");
        users.setUserPwd("777");
        int i = usersMapper.insUser(users);
        System.out.println(i);
    }

    @Test
    public void delUserByUserNo(){
        int i = usersMapper.delUserByUserNo("7");
        System.out.println(i);
    }
}
