package com.previred.desafioprevired.services;

import com.previred.desafioprevired.model.Tarea;

import java.util.List;

public interface TareaService {
    List<Tarea> getAllTareas();
    Tarea getTareaById(Long id);
    void guardarTarea(Tarea tarea);
    void actualizarTarea(Long id, Tarea nuevaTarea);
    void eliminarTarea(Long id);
    List<Tarea> getAllTareasByUsuario(String username);
}
