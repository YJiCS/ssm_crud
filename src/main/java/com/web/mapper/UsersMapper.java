package com.web.mapper;

import com.web.bean.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsersMapper {
    List<Users> selAllUsers();
    Users selUser(@Param("userNo") String userNo, @Param("userPwd") String userPwd);
    int insUser(Users users);
    int delUserByUserNo(String userNo);
//    int updUser();
}
