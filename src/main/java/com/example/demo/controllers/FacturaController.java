package com.example.demo.controllers;

import com.example.demo.model.Evento;
import com.example.demo.model.Factura;
import com.example.demo.services.EventoService;
import com.example.demo.services.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {

    private final FacturaService facturaService;

    @Autowired
    public FacturaController(FacturaService facturaService){
        this.facturaService = facturaService;
    }

    @GetMapping
    public ResponseEntity<List<Factura>> obtenerTodosLasFacturas(){
        List<Factura> facturas = facturaService.obtenerTodasLasFacturas();
        return new ResponseEntity<>(facturas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Factura> obtenerFacturaPorId(@PathVariable Long id){
        Optional<Factura> facturaOptional = facturaService.obtenerFacturaPorId(id);
        if (facturaOptional.isPresent()){
            return new ResponseEntity<>(facturaOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Factura> actualizarFactura(@PathVariable Long id, @RequestBody Factura factura) {
        facturaService.obtenerFacturaPorId(id); // Esto lanzará una excepción si la factura no existe
        factura.setId(id);
        Factura facturaActualizada = facturaService.guardarFactura(factura);
        return new ResponseEntity<>(facturaActualizada, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarFactura(@PathVariable Long id) {
        facturaService.borrarFactura(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
