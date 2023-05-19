package com.api.backend.service.imp;

import com.api.backend.entity.Table;
import com.api.backend.repository.TableRespository;
import com.api.backend.service.TableService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TableServiceImp implements TableService {
    private final TableRespository respository;
    @Override
    public Table getTableById(Long iTable) {
        return respository.findById(iTable).orElseThrow();
    }
}
