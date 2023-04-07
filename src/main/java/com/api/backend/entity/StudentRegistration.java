package com.api.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name = "inscriptions")
@Builder
public class StudentRegistration {

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id",
            referencedColumnName = "id",
            nullable = false, updatable = false)
    @JsonIgnoreProperties(value = {"studentRegistrations"})
    private Student student;

    private boolean status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "classes_id",
            referencedColumnName = "id",
            nullable = false, updatable = false)
    @JsonIgnoreProperties(value = {"studentRegistrations"})
    private Classes classes;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "schoolYear_id",
            referencedColumnName = "id",
            nullable = false, updatable = false)
    @JsonIgnoreProperties(value = {"studentRegistrations"})
    private SchoolYear schoolYear;

}
