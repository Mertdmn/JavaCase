package com.enoca.JavaCase.service;

import com.enoca.JavaCase.dto.request.ProductSaveDto;
import com.enoca.JavaCase.dto.request.ProductUpdateDto;
import com.enoca.JavaCase.repository.ProductRepository;
import com.enoca.JavaCase.repository.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Optional<Product> getProduct(Long productId) {
        Optional<Product> product=productRepository.findById(productId);
        return product;
    }
    public Double getProductPrice(Long productId){
        Optional<Product> product=productRepository.findById(productId);
        return product.get().getPrice();
    }

    public void createProduct(ProductSaveDto dto) {
        Product product=Product.builder()
                .price(dto.getPrice())
                .model(dto.getModel())
                .brand(dto.getBrand())
                .barcode(dto.getBarcode())
                .name(dto.getName())
                .build();
        productRepository.save(product);
    }

    public void updateProduct(Long productId, ProductUpdateDto dto) {
        Optional<Product> product=productRepository.findById(productId);
        product= Optional.ofNullable(Product.builder()
                .id(productId)
                .name(dto.getName())
                .barcode(dto.getBarcode())
                .brand(dto.getBrand())
                .model(dto.getModel())
                .price(dto.getPrice())
                .build());
        productRepository.save(product.get());
    }

    public void deleteProduct(Long productId) {
        Optional<Product> product=productRepository.findById(productId);
        productRepository.delete(product.get());
    }
}

