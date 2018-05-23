package com.tavv.springbootapi.service.impl;

import com.tavv.springbootapi.domain.Product;
import com.tavv.springbootapi.dto.ProductDto;
import com.tavv.springbootapi.mapper.ProductMapper;
import com.tavv.springbootapi.repository.ProductRepository;
import com.tavv.springbootapi.service.ProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service(value = "productServiceImpl")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper mapper;

    @Override
    @Transactional(readOnly = false)
    public ProductDto save(ProductDto dto) {
        dto.setCreateDate(new Date());
        Product product = mapper.convertToEntity(dto);
        product = productRepository.save(product);
        return mapper.convertToDto(product);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(ProductDto dto) {
        productRepository.delete(mapper.convertToEntity(dto));
    }

    @Override
    public ProductDto findOne(ProductDto dto) {
        String productId = dto.getId();
        if(StringUtils.isNotBlank(productId)){
            Optional<Product> result = productRepository.findById(productId);
            return mapper.convertToDto(result.get());
        }
        return null;
    }

    @Override
    public List<ProductDto> findAll() {
        return mapper.convertToDtos(productRepository.findAll());
    }

    @Override
    public List<ProductDto> findProductPaidByUser(String userId) {
        return null;
    }
}
