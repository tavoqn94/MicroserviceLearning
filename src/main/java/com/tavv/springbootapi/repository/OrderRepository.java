package com.tavv.springbootapi.repository;

import com.tavv.springbootapi.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {

    @Query("{id : ?0, isPaid : ?1}")
    Order findByProductIdAndPaid(String productId, boolean isPaid);
}
