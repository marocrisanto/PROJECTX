package com.example.demo.services;

import com.example.demo.model.Usuario;

import java.util.Date;

public interface PasswordResetTokenService {
    Usuario getUsuario();

    Date getExpiryDate();
}
