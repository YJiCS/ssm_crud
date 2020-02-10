package com.web.service;

import com.web.bean.Users;

import java.util.List;


public interface UsersService {
    public Users login(String userNo,String userPwd);
    public List<Users> selAllUsers();
}
