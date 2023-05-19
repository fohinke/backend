package com.api.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity(name = "commande")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Status status;

    private String description;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<OrderContent> orderContents;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties(value = {"orders"})
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "table_id")
    private Table table;

}
