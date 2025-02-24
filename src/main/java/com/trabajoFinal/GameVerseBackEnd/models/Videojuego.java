package com.trabajoFinal.GameVerseBackEnd.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "videojuego")
public class Videojuego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;
    private String desarrollador;
    private LocalDateTime fechaLanzamiento;
    private String genero;

    @ElementCollection
    private List<String> plataformas = new ArrayList<>();

    private String descripcion;
    private String portada;

    @OneToMany(mappedBy = "videojuego", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    @ManyToMany(mappedBy = "videojuegos")
    private List<Lista> listas = new ArrayList<>();

    public Videojuego() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
}
