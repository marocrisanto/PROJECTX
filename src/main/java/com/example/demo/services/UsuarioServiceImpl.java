package com.example.demo.services;

import com.example.demo.Exceptions.NoEncontradaException;
import com.example.demo.Exceptions.UsuarioNoEncontradoException;
import com.example.demo.model.Usuario;
import com.example.demo.repository.PasswordRepository;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {



    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public List<Usuario> obtenerTodosLosUsuarios(){
     return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> obtenerUsuarioPorId(Long id) throws Exception {
        Optional<Usuario> usuarioARetornar = usuarioRepository.findById(id);
        if (usuarioARetornar.isPresent()){
            return usuarioARetornar;
        } else {
            throw new UsuarioNoEncontradoException("Usuario no encontrado con el id " + id);
        }
    }


    public Usuario guardarUsuario(Usuario usuario){
        Usuario usuarioAregresar = usuarioRepository.save(usuario);
        return usuarioAregresar;
    }

    @Override
    public void borrarUsuario(Long id){
        usuarioRepository.deleteById(id);
    }

    @Override
    public Optional<Usuario> obtenerUsuarioPorEmail(String email){
        return usuarioRepository.findByEmail(email);
    }

}
