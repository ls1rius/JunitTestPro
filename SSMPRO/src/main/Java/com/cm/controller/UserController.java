package com.cm.controller;
import com.cm.entity.User;
import com.cm.service.IUserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;


@CrossOrigin(origins = "*",maxAge = 3600)
@Controller
@RequestMapping(value = "/user")
@ResponseBody
public class UserController {

    private Log log = LogFactory.getLog(this.getClass());

    @Resource(name="userService")
    private IUserService userService;

    @RequestMapping(value="/checkUserByUsername", method = RequestMethod.POST)
    public Object checkUserByUsername(@RequestBody HashMap<String, Object>mp){
        String username = (String)mp.get("username");
        HashMap<String, Object>ans = new HashMap<>();
        User res = userService.checkUserByUsername(username);
        ans.put("username",username);
        ans.put("isExist",res==null?false:true);
        return ans;
    }
}
