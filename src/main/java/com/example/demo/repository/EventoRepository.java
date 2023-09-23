package com.example.demo.repository;

import com.example.demo.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
    // Aquí no necesitamos escribir ningún método.
    // JpaRepository ya nos proporciona métodos CRUD básicos.
}
