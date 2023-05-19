package com.api.backend.dto;

import com.api.backend.entity.OrderContent;
import com.api.backend.entity.Status;
import com.api.backend.entity.Table;
import com.api.backend.entity.Users;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDto {

    private Status status;

    private String description;

    private List<OrderContentDto> orderContentDtos;

    private Long idUser;

    private Long idTable;

}
