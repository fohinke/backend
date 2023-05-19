package com.api.backend.service;

import com.api.backend.dto.OrderDto;
import com.api.backend.entity.Order;

import java.util.List;

public interface OrderService {

    void save(OrderDto orderDto);
    void saveAll(List<OrderDto> orders);

    Order getOrderById(Long orderId);

    List<Order> getAll();
}
