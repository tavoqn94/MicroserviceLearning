package com.tavv.springbootapi.repository;

import com.tavv.springbootapi.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    @Query("{userId: ?0}")
    List<Product> findProductPaidByUser(String userId);
}
