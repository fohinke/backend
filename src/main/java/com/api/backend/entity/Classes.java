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
@Entity(name = "classes")
@Builder
public class Classes {

    @Id
    @SequenceGenerator(
            name = "classes_sequence",
            sequenceName = "classes_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "classes_sequence"
    )
    @Column(name = "id", updatable = false)
    private Long id;
    private String name;

    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties(value = "classes", allowSetters = true)
    private List<StudentRegistration> studentRegistrations = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "level_id",
            referencedColumnName = "id",
            nullable = false, updatable = false)
    @JsonIgnoreProperties(value = {"classes"})
    private Level level;
}
