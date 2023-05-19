package com.api.backend.service;

import com.api.backend.entity.Menu;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MenuService {

    List<Menu> getMenus();
    Menu getMenuById(Long id);
}
