package com.example.accessingdatajpa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import java.util.Set;
import java.util.HashSet;

@Entity
public class Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "platforms")
    private Set<Post> posts;

    // No-arg constructor for JPA
    protected Platform() {
        this.posts = new HashSet<>();
    }

    // Constructor that initializes all instance variables
    public Platform(Long id, String name, Set<Post> posts) {
        this.id = id;
        this.name = name;
        this.posts = posts != null ? posts : new HashSet<>();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }
}
