package com.api.backend.controller;

import com.api.backend.dto.OrderDto;
import com.api.backend.dto.ResponseDto;
import com.api.backend.entity.Order;
import com.api.backend.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/get")
    public ResponseDto<?> getOrder(){
        return ResponseDto.builder()
                .status(true)
                .content(orderService.getAll()).build();
    }

    @PostMapping("/save")
    public ResponseDto<?> save(@RequestBody OrderDto dto){
        orderService.save(dto);
        return ResponseDto
                .builder()
                .status(true)
                .message("Traitement effectué")
                .build();
    }
}
