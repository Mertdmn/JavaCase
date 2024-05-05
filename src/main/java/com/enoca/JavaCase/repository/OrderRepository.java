package com.enoca.JavaCase.repository;

import com.enoca.JavaCase.repository.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findAllByCustomerId(Long customerId);
    Order findByOrderCode(String orderCode);
}

