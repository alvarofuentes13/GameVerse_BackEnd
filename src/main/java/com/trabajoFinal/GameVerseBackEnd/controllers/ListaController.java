package com.trabajoFinal.GameVerseBackEnd.controllers;

import com.trabajoFinal.GameVerseBackEnd.models.Lista;
import com.trabajoFinal.GameVerseBackEnd.services.ListaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/listas")
public class ListaController {

    @Autowired
    private ListaService listaService;

    @GetMapping
    public List<Lista> getAllListas() {
        return listaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lista> getListaById(@PathVariable Long id) {
        Lista lista = listaService.findById(id);
        return lista != null ? ResponseEntity.ok(lista) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Lista createLista(@RequestBody Lista lista) {
        return listaService.save(lista);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLista(@PathVariable Long id) {
        listaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
