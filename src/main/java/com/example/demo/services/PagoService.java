package com.example.demo.services;

import com.example.demo.model.Pago;
import com.example.demo.model.Pago;

import java.util.List;
import java.util.Optional;

public interface PagoService {

    List<Pago> obtenerTodosLosPagos();

    Optional<Pago> obtenerPagoPorId(Long id);

    Pago guardarPago(Pago Pago);

    void borrarPago(Long id);


}
