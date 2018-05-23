package com.tavv.springbootapi.service.impl;

import com.tavv.springbootapi.domain.Order;
import com.tavv.springbootapi.dto.OrderDto;
import com.tavv.springbootapi.mapper.OrderMapper;
import com.tavv.springbootapi.repository.OrderRepository;
import com.tavv.springbootapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service("orderServiceImpl")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper mapper;

    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;


    @Override
    @Transactional(readOnly = false)
    public OrderDto save(OrderDto dto) {
        if(dto.getOrderDate() == null){
            dto.setOrderDate(new Date());
        }
        Order order = mapper.convertToEntity(dto);
        order = orderRepository.save(order);
        fireOrderCreatedEvent(order);
        return mapper.convertToDto(order);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(OrderDto dto) {
        orderRepository.delete(mapper.convertToEntity(dto));
    }

    @Override
    public OrderDto findByProductIdAndPaid(String id, boolean isPaid) {
        Order order = orderRepository.findByProductIdAndPaid(id, isPaid);
        return mapper.convertToDto(order);
    }

    private void fireOrderCreatedEvent(Order order) {
        kafkaTemplate.send("order", order.getId() + "created", order);
    }
}
