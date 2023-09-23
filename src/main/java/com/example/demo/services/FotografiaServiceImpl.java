package com.example.demo.services;

import com.example.demo.model.Factura;
import com.example.demo.model.Fotografia;
import com.example.demo.repository.FacturaRepository;
import com.example.demo.repository.FotografiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FotografiaServiceImpl implements FotografiaService{

    //Inyectamos fotografiaRepository usando Autowired para usar las operaciones CRUD del repositorio
    private final FotografiaRepository fotografiaRepository;

    @Autowired
    public FotografiaServiceImpl(FotografiaRepository fotografiaRepository) {
        this.fotografiaRepository = fotografiaRepository;
    }

    @Override
    public List<Fotografia> obtenerTodasLasFotografias() {
        return fotografiaRepository.findAll();
    }
    @Override
    public Optional<Fotografia> obtenerFotografiaPorId(Long id){
        return fotografiaRepository.findById(id);
        }

    @Override
    public Fotografia guardarFotografia(Fotografia fotografia){
        return fotografiaRepository.save(fotografia);
        }

    @Override
    public void borrarFotografia(Long id){
        fotografiaRepository.deleteById(id);
        }
}
