package com.api.backend.repository;

import com.api.backend.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRespository extends JpaRepository<Order, Long> {
    Optional<Order> findAllById(Long id);
}
