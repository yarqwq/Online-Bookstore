package com.web.bookshop.controller;

import com.web.bookshop.model.Order;
import com.web.bookshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public String createOrder(Order order, Model model) {
        orderService.addOrder(order);
        // Add any additional data to the model
        model.addAttribute("message", "Order created successfully");
        return "order-success"; // Return the view name for successful order creation
    }

    @PutMapping("/{orderId}")
    public String updateOrder(@PathVariable String orderId, Order order, Model model) {
        Order existingOrder = orderService.getOrderById(orderId);
        if (existingOrder == null) {
            // Add any error message to the model
            model.addAttribute("error", "Order not found");
            return "order-error"; // Return the view name for order not found error
        }
        order.setId(orderId);
        orderService.updateOrder(order);
        // Add any additional data to the model
        model.addAttribute("message", "Order updated successfully");
        return "order-success"; // Return the view name for successful order update
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable String orderId) {
        Order existingOrder = orderService.getOrderById(orderId);
        if (existingOrder == null) {
            return ResponseEntity.notFound().build();
        }
        orderService.deleteOrder(orderId);
        return ResponseEntity.ok("Order deleted successfully");
    }

    @GetMapping("/{orderId}")
    public String getOrderById(@PathVariable String orderId, Model model) {
        Order order = orderService.getOrderById(orderId);
        if (order == null) {
            // Add any error message to the model
            model.addAttribute("error", "Order not found");
            return "order-error"; // Return the view name for order not found error
        }
        // Add the order to the model
        model.addAttribute("order", order);
        return "order-details"; // Return the view name for order details
    }

    @GetMapping("/orders")
    public String getAllOrders(Model model) {
        List<Order> orders = orderService.getAllOrders();
        // Add the list of orders to the model
        model.addAttribute("orders", orders);
        return "orders"; // Return the view name for order list
    }

}