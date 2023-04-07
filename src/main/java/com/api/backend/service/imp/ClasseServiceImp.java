package com.api.backend.service.imp;

import com.api.backend.entity.Classes;
import com.api.backend.repository.ClasseRepository;
import com.api.backend.service.ClasseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClasseServiceImp implements ClasseService {

    private final ClasseRepository repository;

    @Override
    public List<Classes> getClasse() {
        return repository.findAll();
    }
}
