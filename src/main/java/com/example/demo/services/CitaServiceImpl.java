package com.example.demo.services;

import com.example.demo.Exceptions.CitaFechaEnPasadoException;
import com.example.demo.Exceptions.CitaNoEncontradaException;
import com.example.demo.Exceptions.CitaYaExistenteException;
import com.example.demo.model.Cita;
import com.example.demo.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service //Usamos la anotación @Service para la implementación para que Spring lo reconozca como un bean y
// pueda realizar la inyección de dependencias.
public class CitaServiceImpl implements CitaService {

    @Autowired
    //Inyectamos CitaRepository usando Autowired para usar las operaciones CRUD del repositorio en nuestro servicio.
    private CitaRepository citaRepository;


    @Override
    public List<Cita> obtenerTodasLasCitas() {
        return citaRepository.findAll();
    }

    @Override
    public Cita obtenerCitaPorId(Long id) {
        return citaRepository.findById(id).orElseThrow(() -> new CitaNoEncontradaException("Cita no encontrada con id: " + id));

    }

    @Override
    public Cita guardarCita(Cita cita) {
        // Validar que la fecha y la hora de la cita no están en el pasado
        if (cita.getFechaHora().isBefore(LocalDateTime.now())) {
            throw new CitaFechaEnPasadoException("Fecha incorrecta, no puede estar en el pasado");
        }
        // Validar que la cita no se sobreponga con otras citas
        List<Cita> citasExistentes = citaRepository.findAll();
        for (Cita citaExistente: citasExistentes){
            if (citaExistente.getFechaHora().equals(cita.getFechaHora())){
                throw new CitaYaExistenteException("Ya existe una cita en esta fecha y hora");
            }
        }
        return citaRepository.save(cita);
    }

    @Override
    public void borrarCita(Long id) {

        citaRepository.deleteById(id);
    }

    @Override
    public void confirmarCita(Long id) {
        Cita cita = citaRepository.findById(id).orElseThrow(() -> new CitaNoEncontradaException("Cita no encontrada con id: "+ id));
        cita.setConfirmada(true);
        citaRepository.save(cita);
    }

    @Override
    public void cancelarCita(Long id) throws Exception{
        Cita cita = citaRepository.findById(id).orElseThrow(()-> new CitaNoEncontradaException("Cita no encontrada con id: "+ id));
        cita.setCancelada(true);
        citaRepository.save(cita);
    }
}
