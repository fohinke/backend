package com.api.backend;

import com.api.backend.entity.Classes;
import com.api.backend.entity.Level;
import com.api.backend.repository.ClasseRepository;
import com.api.backend.repository.LevelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner CommandLineRunnerBean(LevelRepository levelRepository,
                                                   ClasseRepository classeRepository) {
        return (args) -> {

            Level level1 = Level.builder()
                    .id(1L)
                    .name("1er Annee")
                    .build();

            Level level2 = Level.builder()
                    .id(2L)
                    .name("2eme Annee")
                    .build();
            levelRepository.save(level1);

            levelRepository.saveAll(List.of(level1,level2));

            Classes classe1 = Classes
                    .builder()
                    .id(1L)
                    .name("1er Annee")
                    .level(levelRepository.findById(1L).get())
                    .build();

            Classes classe2 = Classes
                    .builder()
                    .id(2L)
                    .name("2eme Annee")
                    .level(levelRepository.findById(2L).get())
                    .build();

            classeRepository.saveAll(List.of(classe1, classe2));
        };
    }
}
