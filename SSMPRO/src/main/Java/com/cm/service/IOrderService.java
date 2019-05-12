package com.cm.service;

import com.cm.entity.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service("orderService")
public interface IOrderService {

    String createAnOrder(@Param("order") Order order);

    Integer  getInsertOrderId();

    String finishAnOrder(@Param("orderId") long orderId,
                       @Param("finishUserId") long finishUserId
    );
}
