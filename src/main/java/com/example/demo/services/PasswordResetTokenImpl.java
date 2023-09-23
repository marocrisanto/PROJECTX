package com.example.demo.services;

import com.example.demo.model.Usuario;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "password_reset_tokens")
public class PasswordResetTokenImpl implements PasswordResetTokenService{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "token")
    private String token;

    @OneToOne(targetEntity = Usuario.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "usuario_id")
    private Usuario usuario;

    @Column(name = "expiry_date")
    private Date expiryDate;

    public PasswordResetTokenImpl(String token, Usuario usuario) {
        this.token = token;
        this.usuario = usuario;
        this.expiryDate = calculateExpiryDate();
    }

    public PasswordResetTokenImpl() {}

    private Date calculateExpiryDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR, 24); // el token expira en 24 horas
        return cal.getTime();
    }

    @Override
    public Usuario getUsuario() {
        return usuario;
    }

    @Override
    public Date getExpiryDate() {
        return expiryDate;
    }
}

