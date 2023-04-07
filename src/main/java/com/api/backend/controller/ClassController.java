package com.api.backend.controller;

import com.api.backend.dto.ResponseDto;
import com.api.backend.entity.Classes;
import com.api.backend.service.ClasseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/classe")
@AllArgsConstructor
public class ClassController {

    private final ClasseService classeService;

    @GetMapping("/get")
    public ResponseEntity<ResponseDto<List<Classes>>> getClasse(){
        List<Classes> classes = classeService.getClasse();
        ResponseDto responseDto = ResponseDto
                .builder()
                .status(true)
                .content(classes)
                .message("success")
                .build();

        return ResponseEntity.ok().body(responseDto);
    }
}
