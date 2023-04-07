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
@Entity(name = "annnee_scolaire")
@Table(name = "annnee_scolaire", uniqueConstraints = @UniqueConstraint(name = "libelle_unique", columnNames = "name"))
@Builder
public class SchoolYear {

    @Id
    @SequenceGenerator(
            name = "annee_sequence",
            sequenceName = "annee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "annee_sequence"
    )
    @Column(name = "id", updatable = false)
    private Long id;
    private String name;

    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties(value = "schoolYear", allowSetters = true)
    private List<StudentRegistration> studentRegistrations = new ArrayList<>();
}
