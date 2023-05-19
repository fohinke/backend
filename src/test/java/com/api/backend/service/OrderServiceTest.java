package com.api.backend.service;

import com.api.backend.entity.Order;
import com.api.backend.entity.OrderContent;
import com.api.backend.entity.Status;
import com.api.backend.repository.MenuRespository;
import com.api.backend.repository.OrderRespository;
import com.api.backend.repository.TableRespository;
import com.api.backend.repository.UsersRepository;
import com.api.backend.service.imp.OrderServiceImp;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    OrderRespository orderRespository;

    @InjectMocks
    OrderServiceImp orderServiceImp;

    @BeforeEach
    public void setup() {
        System.out.println("@BeforeEach OrderService2Test");
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAll(){
        System.out.println("**--- Test OrderService executed ---**");

        List<Order> orders = new ArrayList<>();

        orders.add(com.api.backend.entity.Order
                .builder()
                .id(1L)
                .status(Status.PENDING)
                .description("test1")
                .build());

        orders.add(com.api.backend.entity.Order
                .builder()
                .id(2L)
                .status(Status.PENDING)
                .description("test2")
                .build());

        when(orderRespository.findAll()).thenReturn(orders);

        List<Order> all = orderServiceImp.getAll();

        assertEquals(2, all.size());

        verify(orderRespository, times(1)).findAll();
    }

    @Test
    public void testSave(){

    }

    @AfterAll
    public static void afterAllTest(){
        System.out.println("**--- Test OrderService End ---**");
    }
}
