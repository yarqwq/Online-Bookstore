package com.web.bookshop.model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private String id;
    private LocalDateTime orderTime;
    private double price;
    private boolean state;
    private User user;
    private List<OrderItem> orderItems;

    // 构造函数
    public Order(String id, LocalDateTime orderTime, double price, boolean state, User user, List<OrderItem> orderItems) {
        this.id = id;
        this.orderTime = orderTime;
        this.price = price;
        this.state = state;
        this.user = user;
        this.orderItems = orderItems;
    }

    public Order() {

    }

    // Getter和Setter方法

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    // 其他方法

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        price = calculateprice();
    }

    public void removeOrderItem(OrderItem orderItem) {
        orderItems.remove(orderItem);
        price = calculateprice();
    }
    private double calculateprice() {
        double total = 0.0;
        for (OrderItem orderItem : orderItems) {
            total += orderItem.getPrice() * orderItem.getQuantity();
        }
        return total;
    }
}