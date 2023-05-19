package com.api.backend.service;

import com.api.backend.entity.OrderContent;

import java.util.List;

public interface OrderContentService {
    void save(OrderContent orderContent);
    void saveAll(List<OrderContent> orderContents);
}
