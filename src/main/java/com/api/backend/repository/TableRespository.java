package com.api.backend.repository;

import com.api.backend.entity.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRespository extends JpaRepository<Table, Long> {
}
