package com.api.backend.service.imp;

import com.api.backend.entity.OrderContent;
import com.api.backend.repository.OrderContentRespository;
import com.api.backend.service.OrderContentService;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class OrderContentServiceImp implements OrderContentService {

    private OrderContentRespository respository;


    @Override
    public void save(OrderContent orderContent) {
        respository.save(orderContent);
    }

    @Override
    public void saveAll(List<OrderContent> orderContents) {
        respository.saveAll(orderContents);
    }
}
