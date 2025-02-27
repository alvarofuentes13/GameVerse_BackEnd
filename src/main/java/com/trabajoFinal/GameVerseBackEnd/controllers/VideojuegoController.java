package com.trabajoFinal.GameVerseBackEnd.controllers;

import com.trabajoFinal.GameVerseBackEnd.models.Videojuego;
import com.trabajoFinal.GameVerseBackEnd.services.VideojuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/videojuegos")
public class VideojuegoController {

    @Autowired
    private VideojuegoService videojuegoService;

    @GetMapping
    public List<Videojuego> getAllVideojuegos() {
        return videojuegoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Videojuego> getVideojuegoById(@PathVariable Long id) {
        Videojuego videojuego = videojuegoService.findById(id);
        return videojuego != null ? ResponseEntity.ok(videojuego) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Videojuego createVideojuego(@RequestBody Videojuego videojuego) {
        return videojuegoService.save(videojuego);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVideojuego(@PathVariable Long id) {
        videojuegoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
