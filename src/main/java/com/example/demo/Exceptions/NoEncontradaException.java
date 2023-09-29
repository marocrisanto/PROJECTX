package com.example.demo.Exceptions;

public class CitaNoEncontradaException extends RuntimeException{
    public CitaNoEncontradaException(String message){
        super(message);
    }
}
