package com.tavv.springbootapi.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tavv.springbootapi.Common.JsonDateDeSerializer;
import com.tavv.springbootapi.Common.JsonDateSerializer;

import java.util.Date;

@JsonAutoDetect
public class OrderDto {

    private String productId;
    private String userId;
    private double price;
    private boolean isPaid;
    private Date orderDate;

    public OrderDto(String productId, String userId, double price, boolean isPaid, Date orderDate) {
        this.productId = productId;
        this.userId = userId;
        this.price = price;
        this.isPaid = isPaid;
        this.orderDate = orderDate;
    }

    public OrderDto() {
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    public Date getOrderDate() {
        return orderDate;
    }

    @JsonDeserialize(using = JsonDateDeSerializer.class)
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
