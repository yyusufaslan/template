package com.template.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Email
    @Column(nullable = false)
    public String email;

    @Column(nullable = false)
    private boolean emailVerified = false;

    @JsonIgnore
    public String password;

    @JsonIgnore
    public String confirmPassword;

    @Column(nullable = false)
    public String username;

    public String firstName;

    public String lastName;

    public String profilePicture;

    public String projects;

    public String headline;

    public String vanityName;

    @NotNull
    @Enumerated(EnumType.STRING)
    private AuthProvider provider;

    private String providerId;
}
