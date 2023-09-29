package com.example.demo.controllers;

import com.example.demo.model.Cita;
import com.example.demo.services.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/citas")
public class CitaController {

    private final CitaService citaService;

    @Autowired
    public CitaController(CitaService citaService) {

        this.citaService = citaService;
    }

    @GetMapping
    public ResponseEntity <List<Cita>> obtenerTodasLasCitas(){
        List<Cita> citas = citaService.obtenerTodasLasCitas();
        return new ResponseEntity<>(citas, HttpStatus.OK);
    }
    // Obtener una cita por id
    @GetMapping("/{id}")
    public ResponseEntity<Cita> obtenerCitaPorId(@PathVariable Long id){
        Cita cita = citaService.obtenerCitaPorId(id);
        return new ResponseEntity<>(cita, HttpStatus.OK) ;
    }

    //Crear una nueva cita
    @PostMapping
    public ResponseEntity<Cita> guardarCita(@RequestBody Cita cita) {
        try {
            Cita nuevaCita = citaService.guardarCita(cita);
            return new ResponseEntity<>(nuevaCita, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("{id}/confirmar")
    public ResponseEntity<Void> confirmarCita(@PathVariable Long id){
        try{
            citaService.confirmarCita(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/{id}/cancelar")
    public ResponseEntity<Void> cancelarCita(@PathVariable Long id){
        try{
            citaService.cancelarCita(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Borrar una cita
    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> borrarCita(@PathVariable Long id){
        citaService.borrarCita(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }

}
