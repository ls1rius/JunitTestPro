package com.cm.dao;

import com.cm.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface IUserDao {
    User selectUser(@Param("id")long id);

    ArrayList<User> selectUserByUsername(@Param("username") String username);

    User checkUserByUsername(@Param("username") String username);

}