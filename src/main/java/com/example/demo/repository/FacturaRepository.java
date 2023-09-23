package com.example.demo.repository;

import com.example.demo.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {
    // Aquí no necesitamos escribir ningún método.
    // JpaRepository ya nos proporciona métodos CRUD básicos.
}
