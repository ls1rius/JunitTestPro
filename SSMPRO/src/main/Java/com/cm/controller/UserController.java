package com.cm.controller;
import com.cm.entity.User;
import com.cm.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;


@CrossOrigin(origins = "*",maxAge = 3600)
@Controller
@RequestMapping(value = "/user")
@ResponseBody
public class UserController {

    @Resource(name="userService")
    private IUserService userService;

    @RequestMapping(value="/checkUserByUsername", method = RequestMethod.POST)
    public Object checkUserByUsername(String username){
        HashMap<String,Object>mp = new HashMap<>();
        User res = userService.checkUserByUsername(username);

        mp.put("isExist",res==null?false:true);
        return mp;
    }
}
