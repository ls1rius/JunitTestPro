package com.cm.service.impl;

import com.cm.dao.IUserDao;
import com.cm.entity.User;
import com.cm.service.IUserService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    public User selectUser(long userId) {
        return this.userDao.selectUser(userId);
    }

    public ArrayList<User> selectUserByUsername(String username){
        return this.userDao.selectUserByUsername(username);
    }

    public User checkUserByUsername(String username){
        return this.userDao.checkUserByUsername(username);
    }

}
