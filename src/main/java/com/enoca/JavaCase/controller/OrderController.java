package com.enoca.JavaCase.controller;

import com.enoca.JavaCase.repository.entity.Order;
import com.enoca.JavaCase.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    @PostMapping("/place-order")
    public ResponseEntity<Order> placeOrder(@RequestBody @Valid Long customerId, Long cartId){
        Order order =  orderService.placeOrder(customerId,cartId);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/get-all-orders-for-customers")
    public ResponseEntity<List<Order>> getAllOrdersForCustomerId(Long customerId){
        List<Order> orders = orderService.getAllOrdersForCustomerId(customerId);
        return ResponseEntity.ok(orders);
    }
    @GetMapping("/get-order-for-code")
    public ResponseEntity<Order> getOrderForCode(String orderCode){
        Order order=orderService.getOrderForCode(orderCode);
        return ResponseEntity.ok(order);
    }

}
