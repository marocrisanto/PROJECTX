package com.example.demo.services;

import com.example.demo.Exceptions.CitaNoEncontradaException;
import com.example.demo.model.Cita;

import java.util.List;

public interface CitaService {
    List<Cita> obtenerTodasLasCitas(); //Obtener todas las citas de las bases de datos
    Cita obtenerCitaPorId(Long id) throws CitaNoEncontradaException;

    Cita guardarCita(Cita cita) throws Exception;      //Guarda o actualiza una cita en la base de datos
    void borrarCita(Long id);         //Elimina una cita de la base de datos utilizando su identificador.

    void confirmarCita(Long id) throws Exception;

    void cancelarCita(Long id) throws Exception;
}
