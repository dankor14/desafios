package com.previred.desafioprevired.services;

import com.previred.desafioprevired.model.EstadoTarea;
import com.previred.desafioprevired.repository.EstadoTareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoTareaServiceImpl implements EstadoTareaService{
    @Autowired
    private EstadoTareaRepository estadoTareaRepository;

    @Override
    public List<EstadoTarea> getAllEstadosTarea() {
        return estadoTareaRepository.findAll();
    }

    @Override
    public EstadoTarea getEstadoTareaById(Long id) {
        return estadoTareaRepository.findById(id).orElse(null);
    }

    @Override
    public void guardarEstadoTarea(EstadoTarea estadoTarea) {
        estadoTareaRepository.save(estadoTarea);
    }

    @Override
    public void actualizarEstadoTarea(Long id, EstadoTarea nuevoEstadoTarea) {
        EstadoTarea estadoTareaExistente = estadoTareaRepository.findById(id).orElse(null);
        if (estadoTareaExistente != null) {
            estadoTareaExistente.setNombre(nuevoEstadoTarea.getNombre());
            estadoTareaRepository.save(estadoTareaExistente);
        }
    }

    @Override
    public void eliminarEstadoTarea(Long id) {
        estadoTareaRepository.deleteById(id);
    }
}
