package com.api.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode
@Entity(name = "Users")
@Table(name = "users", uniqueConstraints = @UniqueConstraint(name = "users_email_unique", columnNames = "email"))
public class Users {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "user_sequence"
    )
    @Column(name = "id", updatable = false)
    private Long id;
    @Column(name = "first_name", nullable = false)
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "roles", nullable = false)
    private String Roles;

    @ToString.Exclude
    @Column(name = "password", nullable = false, columnDefinition = "text")
    private String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = {"user"})
    private List<Order> orders;


}