package com.tavv.springbootapi.mapper;

import com.tavv.springbootapi.domain.Product;
import com.tavv.springbootapi.dto.ProductDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface ProductMapper {

    List<Product> convertToEntities(List<ProductDto> dtos);

    List<ProductDto> convertToDtos(List<Product> entities);

    Product convertToEntity(ProductDto dto);

    ProductDto convertToDto(Product entity);
}
