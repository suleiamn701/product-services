package com.micro.productservice.service;

import com.micro.productservice.dto.ProductRequest;
import com.micro.productservice.dto.ProductResponse;
import com.micro.productservice.model.Product;
import com.micro.productservice.repository.ProductRepostory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {


    private final ProductRepostory productRepostory;


    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepostory.save(product);
        log.info("product {} is saved ", product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepostory.findAll();

       return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return  ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
