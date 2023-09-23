package com.example.demo.services;

import com.example.demo.model.Pago;
import com.example.demo.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    List<Usuario> obtenerTodosLosUsuarios();

    Optional<Usuario> obtenerUsuarioPorId(Long id);

    Usuario guardarUsuario(Usuario usuario);

    void borrarUsuario(Long id);

    Optional<Usuario> obtenerUsuarioPorEmail(String email);

    boolean confirmarRegistro(String token);

    void crearPasswordResetTokenParaUsuario(Usuario usuario, String token); // permite crear un token para resetear la contraseña de un usuario.

    String validarPasswordResetToken(Long id, String token, String password); // permite validar el token para resetear la contraseña.

    void cambiarUsuarioPassword(Usuario usuario, String password); // permite cambiar la contraseña de un usuario.

}
