package com.enoca.JavaCase.repository;

import com.enoca.JavaCase.repository.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
