package com.example.demo.services;

import com.example.demo.Exceptions.NoEncontradaException;
import com.example.demo.model.Evento;
import com.example.demo.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EventoServiceImpl implements EventoService {

    //Inyectamos EventoRepository usando Autowired para usar las operaciones CRUD del repositorio
    private final EventoRepository eventoRepository;

    @Autowired
    public EventoServiceImpl(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    @Override
    public List<Evento> obtenerTodosLosEventos(){
        return eventoRepository.findAll();
    }

    @Override
    public Evento obtenerEventoPorId(Long id) {
        return eventoRepository.findById(id).orElseThrow(() -> new NoEncontradaException("Evento no encontrado" + id));
    }

    @Override
    public Evento guardarEvento(Evento evento) {

        return eventoRepository.save(evento);
    }

    @Override
    public void borrarEvento(Long id) {

        eventoRepository.deleteById(id);
    }

}
