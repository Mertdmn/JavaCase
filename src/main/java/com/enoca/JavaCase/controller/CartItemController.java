package com.enoca.JavaCase.controller;

import com.enoca.JavaCase.service.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart-item")
public class CartItemController {
    private final CartItemService cartItemService;

    @PostMapping("/add-product-to-cart")
    public ResponseEntity<Void> addProductToCart(Long cartId, Long productId, Integer amount){
        cartItemService.addProductToCart(cartId,productId,amount);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/remove-product-to-cart")
    public ResponseEntity<Void> removeProductFromCart(Long cartId,Long productIds,Integer amount) throws Exception {
        cartItemService.removeProductFromCart(cartId,productIds,amount);
        return ResponseEntity.ok().build();
    }
}
