package com.api.backend.repository;

import com.api.backend.entity.OrderContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderContentRespository extends JpaRepository<OrderContent, Long> {
}
