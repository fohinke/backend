package com.api.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "detail_commande")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderContent {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private double price;

    private String description;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    @JsonIgnoreProperties(value = {"orderContents"})
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "menu_id", nullable = false)
    private Menu menu;
}
