package com.example.demo.services;

import com.example.demo.model.Fotografia;
import com.example.demo.model.Pago;
import com.example.demo.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PagoServiceImpl implements PagoService{

    //Inyectamos fotografiaRepository usando Autowired para usar las operaciones CRUD del repositorio
    @Autowired
    private final PagoRepository pagoRepository;

    public PagoServiceImpl(PagoRepository pagoRepository){
        this.pagoRepository = pagoRepository;
    }

    @Override
    public List<Pago> obtenerTodosLosPagos() {
        return pagoRepository.findAll();
    }
    @Override
    public Optional<Pago> obtenerPagoPorId(Long id){
        return pagoRepository.findById(id);
    }

    @Override
    public Pago guardarPago(Pago pago){
        return pagoRepository.save(pago);
    }

    @Override
    public void borrarPago(Long id){
        pagoRepository.deleteById(id);
    }

}
