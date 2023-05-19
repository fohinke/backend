package com.api.backend.service.imp;

import com.api.backend.entity.Menu;
import com.api.backend.repository.MenuRespository;
import com.api.backend.service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MenuServiceImp implements MenuService {

    private final MenuRespository respository;

    @Override
    public List<Menu> getMenus() {
        return respository.findAll();
    }

    @Override
    public Menu getMenuById(Long id) {
        return respository.findById(id).orElseThrow();
    }
}
