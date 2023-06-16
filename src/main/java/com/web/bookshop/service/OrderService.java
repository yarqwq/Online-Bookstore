package com.web.bookshop.service;

import com.web.bookshop.dao.OrderDao;
import com.web.bookshop.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderDao orderDao;

    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void addOrder(Order order) {
        orderDao.createOrder(order);
    }

    public void updateOrder(Order order) {
        orderDao.updateOrder(order);
    }

    public void deleteOrder(String orderId) {
        orderDao.deleteOrder(orderId);
    }

    public Order getOrderById(String orderId) {
        return orderDao.findById(orderId);
    }

    public List<Order> getAllOrders() {
        return orderDao.findAllOrders();
    }
}