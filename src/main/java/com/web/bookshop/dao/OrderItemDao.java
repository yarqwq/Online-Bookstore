package com.web.bookshop.dao;

import com.web.bookshop.model.OrderItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderItemDao {
    @Select("SELECT * FROM orderitem WHERE order_id = #{orderId}")
    List<OrderItem> findByOrderId(String orderId);
}