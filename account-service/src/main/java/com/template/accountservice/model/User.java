package com.template.accountservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public UUID id;

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

    private UserStatus status;

}
