package com.api.backend.dto;

import com.api.backend.entity.Menu;
import com.api.backend.entity.Order;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderContentDto {

    private double price;

    private String description;

    private Long idMenu;
    private Long idOrder;
}
