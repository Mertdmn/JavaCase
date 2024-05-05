package com.enoca.JavaCase.service;

import com.enoca.JavaCase.dto.request.CartUpdateDto;
import com.enoca.JavaCase.repository.CartItemRepository;
import com.enoca.JavaCase.repository.CartRepository;
import com.enoca.JavaCase.repository.ProductRepository;
import com.enoca.JavaCase.repository.entity.Cart;
import com.enoca.JavaCase.repository.entity.CartItem;
import com.enoca.JavaCase.repository.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final CartItemRepository cartItemRepository;

    public Optional<Cart> getCart(Long cartId) {
        Optional<Cart> cart=cartRepository.findById(cartId);
        return cart;
    }

    public void emptyCart(Long customerId) {
        Cart cart=Cart.builder()
                .totalPrice(0.0)
                .customerId(customerId)
                .build();
        cartRepository.save(cart);
    }

    public void updateCart(Long cartId, CartUpdateDto dto) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new IllegalArgumentException("Cart not found with id: " + cartId));

        List<CartItem> cartItems = cartItemRepository.findByCartId(cartId);
        if (cartItems.isEmpty()) {
            throw new IllegalArgumentException("Cart items not found with cart id: " + cartId);
        }

        Optional<Product> product = productRepository.findById(cartItems.get(0).getProductId());
        if (product.isEmpty()) {
            if (product.isPresent()) {
                double productPrice = product.get().getPrice();
                int oldAmount = cartItems.stream().mapToInt(CartItem::getAmount).sum();
                double oldTotalPrice = cart.getTotalPrice();

                double newTotalPrice = oldTotalPrice + (productPrice * oldAmount);

                newTotalPrice += productPrice * dto.getAmount();

                cart.setTotalPrice(newTotalPrice);
                cartRepository.save(cart);

                for (CartItem cartItem : cartItems) {
                    cartItem.setAmount(dto.getAmount());
                    cartItemRepository.save(cartItem);
                }
            } else {
                throw new IllegalArgumentException("Product not found with id: " + cartItems.get(0).getProductId());
            }
        }else{
            List<CartItem> cartItems2 = cartItemRepository.findByCartId(cartId);
            Optional<Product> product2 = productRepository.findById(cartItems2.get(0).getProductId());
            double productPrice = product2.get().getPrice();
            int oldAmount = cartItems2.stream().mapToInt(CartItem::getAmount).sum();
            double oldTotalPrice = cart.getTotalPrice();

            double newTotalPrice = oldTotalPrice - (productPrice * oldAmount);

            newTotalPrice += productPrice * dto.getAmount();

            cart.setTotalPrice(newTotalPrice);
            cartRepository.save(cart);

            for (CartItem cartItem2 : cartItems) {
                cartItem2.setAmount(dto.getAmount());
                cartItemRepository.save(cartItem2);
            }
        }
    }

}

