package com.trabajoFinal.GustavioBackEnd.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "name")
    private String name;

    @Column(nullable = false)
    private String password;

    @CreationTimestamp
    private LocalDateTime fechaRegistro;

    private String avatar;

    private String biografia;

    @OneToMany(mappedBy = "usuario")
    private Set<Review> reviews;

    @OneToMany(mappedBy = "usuario")
    private Set<Lista> listas;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "seguidores",
            joinColumns = @JoinColumn(name = "seguido_id"),
            inverseJoinColumns = @JoinColumn(name = "seguidor_id")
    )
    @JsonManagedReference
    private Set<Usuario> seguidores = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
