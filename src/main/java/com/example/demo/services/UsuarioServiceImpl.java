package com.example.demo.services;

import com.example.demo.model.Usuario;
import com.example.demo.repository.PasswordRepository;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

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
}
