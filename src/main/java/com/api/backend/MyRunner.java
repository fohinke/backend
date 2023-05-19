package com.api.backend;

import com.api.backend.entity.*;
import com.api.backend.repository.MenuRespository;
import com.api.backend.repository.OrderRespository;
import com.api.backend.repository.TableRespository;
import com.api.backend.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class MyRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);
    private final OrderRespository orderRespository;
    private final TableRespository tableRespository;
    private final MenuRespository menuRespository;
    private final UsersRepository usersRepository;

    @Override
    public void run(String... args) throws Exception {

        //save table
        tableRespository.save(Table
                .builder()
                        .id(1L)
                        .name("Table1")
                .build());

        //save Menu
        menuRespository.save(Menu
                .builder()
                        .id(1L)
                        .price(12)
                        .name("Salade")
                        .descriptions("Bon plat")
                .build());

        //save User
        Users users = new Users();
        users.setId(1L);
        users.setEmail("test@test.gn");
        users.setRoles("ADMIN");
        users.setPassword("azzzee");
        users.setFirst_name("Amad");
        users.setLast_name("Douno");
        usersRepository.save(users);

        //Save Order
        Table table = tableRespository.findById(1L).get();
        Users usersSave= usersRepository.findById(1L).get();

        List<Order> orders= new ArrayList<>();
        orders.add(com.api.backend.entity.Order
                .builder()
                .id(1L)
                .status(Status.PENDING)
                        .table(table)
                        .user(usersSave)
                .description("test1")
                .build());

        orders.add(com.api.backend.entity.Order
                .builder()
                .id(2L)
                        .table(table)
                        .user(usersSave)
                .status(Status.PENDING)
                .description("test2")
                .build());

        orderRespository.saveAll(orders);
    }
}
