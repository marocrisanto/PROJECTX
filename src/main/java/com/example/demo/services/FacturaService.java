package com.example.demo.services;

import com.example.demo.model.Factura;

import java.util.List;
import java.util.Optional;

public interface FacturaService {

    List<Factura>obtenerTodasLasFacturas(); //Obtener todas las facturas de las bases de datos

    Optional<Factura>obtenerFacturaPorId(Long id);

    Factura guardarFactura(Factura factura); //Guarda o actualiza una factura en la base de datos

    void borrarFactura(Long id); //Elimina una factura de la base de datos utilizando su identificador.

}
