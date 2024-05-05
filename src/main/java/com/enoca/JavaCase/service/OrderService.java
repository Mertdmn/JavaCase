package com.enoca.JavaCase.service;

import com.enoca.JavaCase.repository.CartRepository;
import com.enoca.JavaCase.repository.OrderRepository;
import com.enoca.JavaCase.repository.entity.Cart;
import com.enoca.JavaCase.repository.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    public Order placeOrder(Long customerId, Long cartId){
        Optional<Cart> cart=cartRepository.findById(cartId);
        Order order = Order.builder()
                .customerId(customerId)
                .totalPrice(cart.get().getTotalPrice())
                .build();
        return orderRepository.save(order);
    }


    public List<Order> getAllOrdersForCustomerId(Long customerId) {
        return orderRepository.findAllByCustomerId(customerId);
    }

    public Order getOrderForCode(String orderCode) {
        return orderRepository.findByOrderCode(orderCode);
    }
}
