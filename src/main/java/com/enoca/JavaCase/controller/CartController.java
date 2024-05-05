package com.enoca.JavaCase.controller;

import com.enoca.JavaCase.dto.request.CartUpdateDto;
import com.enoca.JavaCase.repository.entity.Cart;
import com.enoca.JavaCase.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;
    @GetMapping("/get")
    public ResponseEntity<Optional<Cart>> getProduct(Long cartId){
        Optional<Cart> cart=cartService.getCart(cartId);
        return ResponseEntity.ok(cart);
    }
    @PostMapping("/empty")
    public ResponseEntity<Void> emptyCart(Long customerId){
        cartService.emptyCart(customerId);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/update")
    public ResponseEntity<Void> updateCart(Long cartId, CartUpdateDto dto){
        cartService.updateCart(cartId,dto);
        return ResponseEntity.ok().build();
    }
}
