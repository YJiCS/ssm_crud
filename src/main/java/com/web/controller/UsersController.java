package com.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.web.bean.Users;
import com.web.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.security.pkcs11.Secmod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UsersController {
    @Resource
    private UsersService usersService;

    @RequestMapping("login")
    public String login(String userNo, String userPwd, HttpServletRequest req){
        Users users = usersService.login(userNo, userPwd);
        if (users!=null){
            req.getSession().setAttribute("user",users);
            return "redirect:/pages/main.jsp";
        }else{
            return "redirect:/pages/login.jsp";
        }
    }

    @RequestMapping("selAllUsers")
    public String selAllUsers(HttpServletRequest req,
                              @RequestParam(defaultValue = "1") Integer page,
                              Model model){
        //引入PageHelper分页插件
        //在查询之前调用，传入页码以及每页数据量
        PageHelper.startPage(page,3);
        List<Users> users = usersService.selAllUsers();
        //使用PageInfo包装查询后的结果，只需将PageInfo穿个页面即可
        //封装了详细的分页信息，包括查询出来的数据，传入连续显示的页码数
        PageInfo pageInfo =new PageInfo(users,3);//"5"指连续显示的页码数
        model.addAttribute("pageInfo",pageInfo);
//        req.setAttribute("users",users);
        return "forward:/pages/main.jsp";
    }


}
