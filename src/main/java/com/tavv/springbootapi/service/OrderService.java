package com.tavv.springbootapi.service;

import com.tavv.springbootapi.dto.OrderDto;

public interface OrderService {
    OrderDto save(OrderDto dto);

    void delete(OrderDto dto);

    OrderDto findByProductIdAndPaid(String id, boolean isPaid);
}
