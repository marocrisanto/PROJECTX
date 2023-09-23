package com.example.demo.repository;

import com.example.demo.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {
    // Aquí no necesitamos escribir ningún método.
    // JpaRepository ya nos proporciona métodos CRUD básicos.
}
