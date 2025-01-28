package com.trabajoFinal.GustavioBackEnd.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Videojuego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String desarrollador;
    private LocalDateTime fechaLanzamiento;
    private String genero;
    private List<String> plataforma;
    private String descripcion;
    private String portada;

    @OneToMany(mappedBy = "videojuego", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    @ManyToMany(mappedBy = "videojuegos")
    private List<Lista> listas = new ArrayList<>();

}
