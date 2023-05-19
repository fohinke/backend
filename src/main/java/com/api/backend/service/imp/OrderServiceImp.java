package com.api.backend.service.imp;

import com.api.backend.dto.OrderDto;
import com.api.backend.entity.Order;
import com.api.backend.entity.OrderContent;
import com.api.backend.entity.Status;
import com.api.backend.repository.OrderRespository;
import com.api.backend.service.MenuService;
import com.api.backend.service.OrderService;
import com.api.backend.service.TableService;
import com.api.backend.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImp implements OrderService {

    private OrderRespository respository;
    private TableService tableService;
    private UsersService usersService;
    private MenuService menuService;

    @Override
    public void save(OrderDto orderDto) {

        Order order = getBuild(orderDto);
        respository.save(order);
    }

    @Override
    public void saveAll(List<OrderDto> orders) {
        respository.saveAll(orders
                .stream()
                .map(orderDto -> getBuild(orderDto))
                .toList());
    }

    @Override
    public Order getOrderById(Long orderId) {
        return respository.findAllById(orderId).orElseThrow();
    }

    @Override
    public List<Order> getAll() {
        List<Order> all = respository.findAll();
        //all.remove(0);
        return all;
    }


    private Order getBuild(OrderDto orderDto) {
        return Order
                .builder()
                .description(orderDto.getDescription())
                .status(Status.PENDING)
                .table(tableService.getTableById(orderDto.getIdTable()))
                .user(usersService.getUserById(orderDto.getIdUser()))
                .orderContents(orderDto
                        .getOrderContentDtos()
                        .stream()
                        .map(orderContentDto -> OrderContent
                                .builder()
                                .price(orderContentDto.getPrice())
                                .menu(menuService.getMenuById(orderContentDto.getIdMenu()))
                                .description(orderContentDto.getDescription())
                                .build())
                        .toList())
                .build();
    }
}
