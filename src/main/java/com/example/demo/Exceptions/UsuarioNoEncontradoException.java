package com.example.demo.Exceptions;

public class UsuarioNoEncontradoException extends RuntimeException{
    public UsuarioNoEncontradoException(String message){
        super(message);
    }
}
