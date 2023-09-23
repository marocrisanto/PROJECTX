package com.example.demo.services;

import com.example.demo.model.Factura;
import com.example.demo.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaServiceImpl implements FacturaService{

    //Inyectamos FacturaRepository usando Autowired para usar las operaciones CRUD del repositorio
    private final FacturaRepository facturaRepository;

    @Autowired
    public FacturaServiceImpl(FacturaRepository facturaRepository){
        this.facturaRepository = facturaRepository;
    }

    @Override
    public List<Factura>obtenerTodasLasFacturas(){
        return facturaRepository.findAll();
    }

    @Override
    public Optional<Factura>obtenerFacturaPorId(Long id){
        return facturaRepository.findById(id);
    }

    @Override
    public Factura guardarFactura(Factura factura){
        return facturaRepository.save(factura);
    }

    @Override
    public void borrarFactura(Long id){
        facturaRepository.deleteById(id);
    }

}
