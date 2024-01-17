package com.previred.desafioprevired.services;

import com.previred.desafioprevired.model.EstadoTarea;

import java.util.List;

public interface EstadoTareaService {
    List<EstadoTarea> getAllEstadosTarea();
    EstadoTarea getEstadoTareaById(Long id);
    void guardarEstadoTarea(EstadoTarea estadoTarea);
    void actualizarEstadoTarea(Long id, EstadoTarea nuevoEstadoTarea);
    void eliminarEstadoTarea(Long id);
}
