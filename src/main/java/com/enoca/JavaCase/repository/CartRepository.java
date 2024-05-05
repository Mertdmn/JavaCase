package com.enoca.JavaCase.repository;

import com.enoca.JavaCase.repository.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {

}
