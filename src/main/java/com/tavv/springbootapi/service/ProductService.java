package com.tavv.springbootapi.service;

import com.tavv.springbootapi.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto save(ProductDto dto);

    void delete(ProductDto dto);

    ProductDto findOne(ProductDto dto);

    List<ProductDto> findAll();

    List<ProductDto> findProductPaidByUser(String userId);

}
