package com.tavv.springbootapi.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tavv.springbootapi.Common.JsonDateDeSerializer;
import com.tavv.springbootapi.Common.JsonDateSerializer;

import java.util.Date;

@JsonAutoDetect
public class ProductDto {

    private String id;
    private String productName;
    private String image;
    private String description;
    private double price;
    private Date createDate;
    private OrderDto orderDto;

    public ProductDto(String id, String productName, String image, String description, double price, Date createDate, OrderDto orderDto) {
        this.id = id;
        this.productName = productName;
        this.image = image;
        this.description = description;
        this.price = price;
        this.createDate = createDate;
        this.orderDto = orderDto;
    }

    public ProductDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    public Date getCreateDate() {
        return createDate;
    }

    @JsonDeserialize(using = JsonDateDeSerializer.class)
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public OrderDto getOrderDto() {
        return orderDto;
    }

    public void setOrderDto(OrderDto orderDto) {
        this.orderDto = orderDto;
    }
}
