package com.enoca.JavaCase.controller;

import com.enoca.JavaCase.dto.request.ProductSaveDto;
import com.enoca.JavaCase.dto.request.ProductUpdateDto;
import com.enoca.JavaCase.repository.entity.Product;
import com.enoca.JavaCase.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    @GetMapping("/get")
    public ResponseEntity<Optional<Product>> getProduct(Long productId){
        Optional<Product> product=productService.getProduct(productId);
        return ResponseEntity.ok(product);
    }
    @PostMapping("/create")
    public ResponseEntity<Void> createProduct(ProductSaveDto dto){
        productService.createProduct(dto);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/update")
    public ResponseEntity<Void> updateProduct(Long productId, ProductUpdateDto dto){
        productService.updateProduct(productId,dto);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/delete")
    public ResponseEntity<Void> deleteProduct(Long productId){
        productService.deleteProduct(productId);
        return ResponseEntity.ok().build();
    }
}
