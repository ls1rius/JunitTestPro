package com.cm.dao;

import com.cm.entity.Order;
import org.apache.ibatis.annotations.Param;

public interface IOrderDao {

    void createAnOrder(@Param("order") Order order);

    Integer  getInsertOrderId();

    void finishAnOrder(@Param("orderId") long orderId,
                       @Param("finishUserId") long finishUserId
    );
}
