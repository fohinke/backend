package com.api.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name = "niveau")
@Table(name = "niveau", uniqueConstraints = @UniqueConstraint(name = "libelle_unique", columnNames = "name"))
@Builder
public class Level {

    @Id
    @SequenceGenerator(
            name = "level_sequence",
            sequenceName = "level_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "level_sequence"
    )
    @Column(name = "id", updatable = false)
    private Long id;
    private String name;

    @OneToMany( cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "level", allowSetters = true)
    private List<Classes> classes = new ArrayList<>();
}
