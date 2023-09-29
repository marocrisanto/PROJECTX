package com.example.demo.services;

import com.example.demo.model.Pago;
import com.example.demo.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    List<Usuario> obtenerTodosLosUsuarios();

    Optional<Usuario> obtenerUsuarioPorId(Long id) throws Exception;

    Usuario guardarUsuario(Usuario usuario);

    void borrarUsuario(Long id);

    Optional<Usuario> obtenerUsuarioPorEmail(String email);
}
