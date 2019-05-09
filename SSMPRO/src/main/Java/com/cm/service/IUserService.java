package com.cm.service;

import com.cm.entity.User;
import org.apache.ibatis.annotations.Param;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface IUserService {

    User selectUser(@Param("id") long userId);

    ArrayList<User> selectUserByUsername(@Param("username") String username);

    User checkUserByUsername(@Param("username") String username);
}