package com.example.demo.services;

import com.example.demo.model.Usuario;
import com.example.demo.repository.PasswordRepository;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PasswordRepository passwordResetTokenRepository;

    @Override
    public List<Usuario> obtenerTodosLosUsuarios(){
     return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> obtenerUsuarioPorId(Long id){
        return usuarioRepository.findById(id);
    }


    public Usuario guardarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    @Override
    public void borrarUsuario(Long id){
        usuarioRepository.deleteById(id);
    }

    @Override
    public Optional<Usuario> obtenerUsuarioPorEmail(String email){
        return usuarioRepository.findByEmail(email);
    }

    @Override
    public boolean confirmarRegistro(String token) {
        Optional<Usuario> usuario = usuarioRepository.findByConfirmationToken(token);
        if (usuario.isEmpty()) {
            // no se encontro ningun usuario con el token proporcionado
            return false;
        }
        Usuario usuarioAconfirmar = usuario.get();
        usuarioAconfirmar.setEnabled(true);
        usuarioAconfirmar.setConfirmationToken(null);
        usuarioRepository.save(usuarioAconfirmar);
        return true;
    }


    @Override
    @Transactional
    public void crearPasswordResetTokenParaUsuario(Usuario usuario, String token) {
        PasswordResetTokenImpl myToken = new PasswordResetTokenImpl(token, usuario);
        passwordResetTokenRepository.save(myToken);
    }

    @Override
    @Transactional
    public String validarPasswordResetToken(Long id, String token, String password){
        PasswordResetTokenImpl passToken = passwordResetTokenRepository.findByToken(token);
        if ((passToken == null) || (!Objects.equals(passToken.getUsuario().getId(), id))){
            return "token invalido";
        }
        Calendar cal = Calendar.getInstance();
        if ((passToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
            return "expired";
        }

        Usuario usuario = passToken.getUsuario();
        // cambiar la contraseña en memoria
        usuario.setPassword(passwordEncoder.encode(password));
        // guardar el cambio de contraseña en la base de datos
        usuarioRepository.save(usuario);
        // eliminar el token de restablecimiento de contraseña
        passwordResetTokenRepository.delete(passToken);
        return "success";
    }

    @Override
    @Transactional
    public void cambiarUsuarioPassword(Usuario usuario, String password){
        usuario.setPassword(passwordEncoder.encode(password));
        usuarioRepository.save(usuario);
    }
}
