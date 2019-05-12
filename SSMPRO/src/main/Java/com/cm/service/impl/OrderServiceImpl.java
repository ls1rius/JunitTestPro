package com.cm.service.impl;

import com.cm.dao.IOrderDao;
import com.cm.entity.Order;
import com.cm.service.IOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("orderService")
public class OrderServiceImpl implements IOrderService{

    @Resource
    private IOrderDao orderDao;

    public String createAnOrder(Order order){
        orderDao.createAnOrder(order);
        return new String("success");
    }

    @Override
    public Integer getInsertOrderId() {
        return orderDao.getInsertOrderId();
    }

    @Override
    public String finishAnOrder(long orderId, long finishUserId) {
        orderDao.finishAnOrder(orderId,finishUserId);
        return new String("success");

    }


}
