package com.trabajoFinal.GameVerseBackEnd.repositories;

import com.trabajoFinal.GameVerseBackEnd.models.Videojuego;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideojuegoRepository extends JpaRepository<Videojuego, Long> {
}
