package com.example.demo.Exceptions;



//Utilizaré @ControllerAdvice para manejar las excepciones de manera centralizada en lugar de manejarlas en cada método del controlador.
//Esto permitira tener un código más limpio en los controladores y un lugar central donde manejar cómo se
//responden las diferentes excepciones.

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CitaFechaEnPasadoException.class)
    public ResponseEntity<String> HandleFechaEnPasado(CitaFechaEnPasadoException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoEncontradaException.class)
    public ResponseEntity<String> HandleCitaNoEncontrada(NoEncontradaException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CitaYaExistenteException.class)
    public ResponseEntity<String> HandleCitaYaExistente(CitaYaExistenteException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EventoNoEncontradoException.class)
    public ResponseEntity<String> HandleEventoNoEncontrado(EventoNoEncontradoException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UsuarioNoEncontradoException.class)
    public ResponseEntity<String> HandlerEventoNoEncontrado(UsuarioNoEncontradoException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}