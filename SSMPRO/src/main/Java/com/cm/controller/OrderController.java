package com.cm.controller;

import com.cm.entity.Order;
import com.cm.service.IOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

@CrossOrigin(origins = "*",maxAge = 3600)
@Controller
@RequestMapping(value = "/order")
@ResponseBody
public class OrderController {


    @Resource(name="orderService")
    private IOrderService orderService;

    @RequestMapping(value="/createAnOrder", method = RequestMethod.POST)
    public Object createAnOrder(@RequestBody HashMap<String, Object> mp){
        long userId = Long.valueOf((Integer)mp.get("userId"));
        String username = (String)mp.get("username");
        long productId = Long.valueOf((Integer)mp.get("productId"));
        String productName = (String)mp.get("productName");
        int productCount = Integer.valueOf((Integer)mp.get("productCount"));

        HashMap<String, Object>ans = new HashMap<>();
        Order order = new Order(userId,username,productId,productName,productCount);

        ans.put("state",orderService.createAnOrder(order));
        ans.put("orderId",orderService.getInsertOrderId());
        return ans;
    }

    @RequestMapping(value = "/finishAnOrder",method = RequestMethod.PUT)
    public Object finishAnOrder(@RequestBody HashMap<String, Object>mp){

        HashMap<String, Object>ans = new HashMap<>();
        long finishUserId = Long.valueOf((Integer)mp.get("finishUserId"));
        long orderId = Long.valueOf((Integer)mp.get("orderId"));
        ans.put("state",orderService.finishAnOrder(orderId,finishUserId));
        return ans;

    }
}
