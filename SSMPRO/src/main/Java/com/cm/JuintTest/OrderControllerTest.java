package com.cm.JuintTest;

import com.cm.entity.Order;
import com.cm.service.IOrderService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class OrderControllerTest {

    @Resource(name = "orderService")
    private IOrderService orderService;

    @Test
    public void testCreateAnOrder(){
        Order order = new Order(1,"root",1,"包子",999);
        Assert.assertEquals("创建订单部分测试失败","success", orderService.createAnOrder(order));
    }

    @Test
    public void testFinishAnOrder(){

        testCreateAnOrder();
        Assert.assertEquals("完成订单部分测试失败","success", orderService.finishAnOrder(orderService.getInsertOrderId(),1));

    }




}