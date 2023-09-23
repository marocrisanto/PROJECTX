package com.example.demo.repository;

import com.example.demo.model.Fotografia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FotografiaRepository extends JpaRepository<Fotografia, Long> {
    // Aquí no necesitamos escribir ningún método.
    // JpaRepository ya nos proporciona métodos CRUD básicos.
}
