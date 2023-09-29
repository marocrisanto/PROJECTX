package com.example.demo.controllers;


import com.example.demo.model.Evento;
import com.example.demo.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {

    private final EventoService eventoService;

    @Autowired
    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @GetMapping
    public ResponseEntity<List<Evento>> obtenerTodosLosEventos(){
        List<Evento> eventos = eventoService.obtenerTodosLosEventos();
        return new ResponseEntity<>(eventos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> obtenerEventoporId(@PathVariable Long id){
        Evento evento = eventoService.obtenerEventoPorId(id);
        return new ResponseEntity<>(evento, HttpStatus.OK);
    }

    //Crear un nuevo Evento
    @PostMapping
    public ResponseEntity<Evento> guardarEvento(@RequestBody Evento evento){
        Evento nuevoEvento = eventoService.guardarEvento(evento);
        return new ResponseEntity<>(nuevoEvento, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarEvento(@PathVariable Long id){
        eventoService.borrarEvento(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
