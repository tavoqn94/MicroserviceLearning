package com.tavv.springbootapi.mapper;

import com.tavv.springbootapi.domain.Order;
import com.tavv.springbootapi.dto.OrderDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface OrderMapper {

    List<Order> convertToEntities(List<OrderDto> dtos);

    List<OrderDto> convertToDtos(List<Order> entities);

    Order convertToEntity(OrderDto dto);

    OrderDto convertToDto(Order entity);

}
