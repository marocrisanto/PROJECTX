package com.example.demo.repository;

import com.example.demo.services.PasswordResetTokenImpl;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordRepository extends JpaRepository<PasswordResetTokenImpl, Long> {

    PasswordResetTokenImpl findByToken(String token);

    void delete(PasswordResetTokenImpl passToken);
}
