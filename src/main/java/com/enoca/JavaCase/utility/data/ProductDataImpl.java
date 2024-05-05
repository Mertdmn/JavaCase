package com.enoca.JavaCase.utility.data;

import com.enoca.JavaCase.repository.ProductRepository;
import com.enoca.JavaCase.repository.entity.Product;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductDataImpl {

    private final ProductRepository productRepository;



    @PostConstruct
    public void createSampleProducts() {
        List<Product> products = new ArrayList<>();
        Product product1=Product.builder()
                .name("t-shirt")
                .price(250.0)
                .model("oversize")
                .brand("mavi")
                .barcode("23192319391")
                .build();
        Product product2=Product.builder()
                .name("gömlek")
                .price(500.0)
                .model("keten")
                .brand("haki")
                .barcode("23192319392")
                .build();
        productRepository.saveAll(products);

        Product product3=Product.builder()
                .name("pantolon")
                .price(800.0)
                .model("kot")
                .brand("siyah")
                .barcode("23192319393")
                .build();
        productRepository.saveAll(products);

        Product product4=Product.builder()
                .name("ceket")
                .price(900.0)
                .model("blazer")
                .brand("petrol")
                .barcode("23192319394")
                .build();
        productRepository.saveAll(products);

        Product product5=Product.builder()
                .name("elbise")
                .price(1500.0)
                .model("kadife")
                .brand("mürdüm")
                .barcode("23192319395")
                .build();
        productRepository.saveAll(products);


        Product product6=Product.builder()
                .name("şapka")
                .price(200.0)
                .model("fötr")
                .brand("gri")
                .barcode("23192319396")
                .build();
        productRepository.saveAll(products);

        Product product7=Product.builder()
                .name("mont")
                .price(2000.0)
                .model("mevsimlik")
                .brand("sarı")
                .barcode("23192319397")
                .build();
        productRepository.saveAll(products);

        Product product8=Product.builder()
                .name("şort")
                .price(400.0)
                .model("kapri")
                .brand("mor")
                .barcode("23192319398")
                .build();
        productRepository.saveAll(products);

        Product product9=Product.builder()
                .name("etek")
                .price(750.0)
                .model("balon")
                .brand("lila")
                .barcode("23192319399")
                .build();
        productRepository.saveAll(products);

        Product product10=Product.builder()
                .name("bileklik")
                .price(300.0)
                .model("çelik")
                .brand("gümüş")
                .barcode("231923193100")
                .build();
        products=List.of(product1,product2,product3,product4,product5,product6,product7,product8,product9,product10);
        productRepository.saveAll(products);
    }
}


