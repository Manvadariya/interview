package com.shipmnt.interview.restapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table()
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "name and email are required")
    private String name;

    @Email(message = "email is not correct")
    @NotBlank(message = "name and email are required")
    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserConnection> sentRequests  = new HashSet<>();


    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserConnection> receiveRequests  = new HashSet<>();


    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "name and email are required") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "name and email are required") String name) {
        this.name = name;
    }

    public @Email(message = "email is not correct") @NotBlank(message = "name and email are required") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "email is not correct") @NotBlank(message = "name and email are required") String email) {
        this.email = email;
    }

    public Set<UserConnection> getSentRequests() {
        return sentRequests;
    }

    public void setSentRequests(Set<UserConnection> sentRequests) {
        this.sentRequests = sentRequests;
    }

    public Set<UserConnection> getReceiveRequests() {
        return receiveRequests;
    }

    public void setReceiveRequests(Set<UserConnection> receiveRequests) {
        this.receiveRequests = receiveRequests;
    }
}