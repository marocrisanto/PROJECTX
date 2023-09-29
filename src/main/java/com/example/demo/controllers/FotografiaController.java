package com.example.demo.controllers;

import com.example.demo.model.Fotografia;
import com.example.demo.services.FotografiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fotografias")
public class FotografiaController {

    private final FotografiaService fotografiaService;

    @Autowired
    public FotografiaController(FotografiaService fotografiaService){
        this.fotografiaService = fotografiaService;
    }

    @GetMapping
    public ResponseEntity<List<Fotografia>> obtenerTodasLasFotografias(){
        List<Fotografia> fotografias = fotografiaService.obtenerTodasLasFotografias();
        return new ResponseEntity<>(fotografias, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fotografia> obtenerFacturaPorId(@PathVariable Long id){
        Optional<Fotografia> fotografiaOptional = fotografiaService.obtenerFotografiaPorId(id);
        if (fotografiaOptional.isPresent()){
            return new ResponseEntity<>(fotografiaOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fotografia> guardarFotografia(@PathVariable Long id, @RequestBody Fotografia fotografia) {
        fotografiaService.guardarFotografia(fotografia);
        fotografia.setId(id);
        Fotografia nuevaFotografia = fotografiaService.guardarFotografia(fotografia);
        return new ResponseEntity<>(nuevaFotografia, HttpStatus.OK);
    }

    public ResponseEntity<Void> borrarFotografia(@PathVariable Long id){
        fotografiaService.borrarFotografia(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}


