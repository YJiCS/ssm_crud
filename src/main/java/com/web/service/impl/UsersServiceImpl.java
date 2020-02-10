package com.web.service.impl;

import com.web.bean.Users;
import com.web.mapper.UsersMapper;
import com.web.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    UsersMapper usersMapper;

    @Override
    public Users login(String userNo,String userPwd) {
        Users users = usersMapper.selUser(userNo, userPwd);
        return users;
    }

    @Override
    public List<Users> selAllUsers() {
        List<Users> users = usersMapper.selAllUsers();
        return users;
    }
}
