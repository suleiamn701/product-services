package com.micro.productservice.repository;

import com.micro.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepostory extends MongoRepository<Product, String> {
}
