package com.example.demo.controllers;

import com.example.demo.model.Pago;
import com.example.demo.services.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    private final PagoService pagoService;

    @Autowired
    public PagoController(PagoService pagoService){
        this.pagoService = pagoService;
    }

    @GetMapping
    public ResponseEntity<List<Pago>> obtenerTodosLosPagos(){
    List<Pago> pagos = pagoService.obtenerTodosLosPagos();
    return new ResponseEntity<>(pagos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pago> obtenerPagoPorId(@PathVariable Long id){
        Optional<Pago>  pagoOptional = pagoService.obtenerPagoPorId(id);
        if (pagoOptional.isPresent()){
            return new ResponseEntity<>(pagoOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Pago> guardarPago(@RequestBody Pago pago){
        Pago nuevoPago = pagoService.guardarPago(pago);
        return new ResponseEntity<>(nuevoPago, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarPago(@PathVariable Long id){
        pagoService.borrarPago(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
