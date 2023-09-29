package com.example.demo.repository;

import com.example.demo.model.Pago;
import com.example.demo.model.Usuario;
import org.apache.juli.logging.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Aquí no necesitamos escribir ningún método.
    // JpaRepository ya nos proporciona métodos CRUD básicos.

    // Este método es para buscar a un usuario por su email.
    Optional<Usuario> findByEmail(String email);

}
