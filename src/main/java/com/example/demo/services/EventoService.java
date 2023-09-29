package com.example.demo.services;

import com.example.demo.model.Evento;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface EventoService {
    List<Evento> obtenerTodosLosEventos(); //Obtener todas los eventos de las bases de datos

    Evento obtenerEventoPorId(Long id);
    /* La razón para usar Optional aquí es para manejar de manera más elegante y segura los casos en que un evento con un
    ID específico no pueda ser encontrada. Optional es una clase contenedora que puede o no contener un valor.
    Si el valor está presente, Optional.get() devolverá el valor, de lo contrario, se puede manejar la ausencia de valor
    de manera adecuada. */
    Evento guardarEvento(Evento evento);  //Guarda o actualiza un evento en la base de datos
    void borrarEvento(Long id);           //Elimina un evento de la base de datos utilizando su identificador.

}
