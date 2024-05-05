package com.enoca.JavaCase.repository;

import com.enoca.JavaCase.repository.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {
    List<CartItem> findByCartId(Long id);
    Optional<CartItem> findByCartIdAndProductId(Long cartId, Long productId);
}
