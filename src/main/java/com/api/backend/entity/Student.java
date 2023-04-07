package com.api.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name = "eleve")
@Table(name = "eleve", uniqueConstraints = @UniqueConstraint(name = "libelle_unique", columnNames = "matricule"))
@Builder
public class Student {

    @Id
    @SequenceGenerator(
            name = "eleve_sequence",
            sequenceName = "eleve_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "eleve_sequence"
    )
    @Column(name = "id", updatable = false)
    private Long id;
    private String matricule;
    private String name;
    @Column(name = "first_name")
    private String firstName;
    private LocalDate dateOfBirth;

    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties(value = "student", allowSetters = true)
    private List<StudentRegistration> studentRegistrations = new ArrayList<>();
}
