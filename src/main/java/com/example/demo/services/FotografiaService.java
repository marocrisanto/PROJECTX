package com.example.demo.services;

import com.example.demo.model.Fotografia;

import java.util.List;
import java.util.Optional;

public interface FotografiaService {

    List<Fotografia> obtenerTodasLasFotografias();

    Optional<Fotografia> obtenerFotografiaPorId(Long id);

    Fotografia guardarFotografia(Fotografia fotografia);

    void borrarFotografia(Long id);

}
