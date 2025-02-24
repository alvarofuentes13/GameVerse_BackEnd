package com.trabajoFinal.GameVerseBackEnd.repositories;

import com.trabajoFinal.GameVerseBackEnd.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
