package com.enoca.JavaCase.service;

import com.enoca.JavaCase.repository.CartItemRepository;
import com.enoca.JavaCase.repository.CartRepository;
import com.enoca.JavaCase.repository.ProductRepository;
import com.enoca.JavaCase.repository.entity.Cart;
import com.enoca.JavaCase.repository.entity.CartItem;
import com.enoca.JavaCase.repository.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartItemService {
    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;
    private final ProductService productService;
    private final ProductRepository productRepository;

    public void addProductToCart(Long cartId,Long productId,Integer amount) {
//        Optional<CartItem> cartItem=cartItemRepository.findById(cartId);
        CartItem cartItem1= CartItem.builder()
                .cartId(cartId)
                .productId(productId)
                .amount(amount)
                .build();
//        cart=cartRepository.findById(cartId);
        Optional<Product> product=productRepository.findById(productId);
        Optional<Cart> cart=Optional.ofNullable(Cart.builder()
                .id(cartId)
                .totalPrice(product.get().getPrice() * amount)
                .build());
        cartItemRepository.save(cartItem1);
        cartRepository.save(cart.get());
    }

    public void removeProductFromCart(Long cartId, Long productId, Integer amount) throws Exception {
        Optional<Cart> optionalCart = cartRepository.findById(cartId);
        if (optionalCart.isEmpty()) {
            throw new Exception("Cart not found with id: " + cartId);
        }
        Cart cart = optionalCart.get();

        Optional<CartItem> optionalCartItem = cartItemRepository.findByCartIdAndProductId(cartId, productId);
        if (optionalCartItem.isEmpty()) {
            throw new Exception("CartItem not found in cart with id: " + productId);
        }
        CartItem cartItem = optionalCartItem.get();

        if (cartItem.getAmount() < amount) {
            throw new Exception("Not enough quantity in cart for product with id: " + productId);
        }

        int newAmount = cartItem.getAmount() - amount;
        cartItem.setAmount(newAmount);
        cartItemRepository.save(cartItem);

        double totalPrice = cart.getTotalPrice() - (amount * productService.getProductPrice(productId));
        cart.setTotalPrice(totalPrice);
        cartRepository.save(cart);

    }
}
