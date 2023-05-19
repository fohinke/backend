package com.api.backend.repository;

import com.api.backend.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MenuRespository extends JpaRepository<Menu, Long> {

    Optional<Menu> findById(Long menuId);
}
