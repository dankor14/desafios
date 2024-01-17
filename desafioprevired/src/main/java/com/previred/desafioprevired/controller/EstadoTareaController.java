package com.previred.desafioprevired.controller;

import com.previred.desafioprevired.model.EstadoTarea;
import com.previred.desafioprevired.services.EstadoTareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/estados")
public class EstadoTareaController {

    @Autowired
    private EstadoTareaService estadoTareaService;

    @GetMapping
    public List<EstadoTarea> getAllEstados() {
        return estadoTareaService.getAllEstadosTarea();
    }

    @GetMapping("/{id}")
    public EstadoTarea getEstadoById(@PathVariable Long id) {
        return estadoTareaService.getEstadoTareaById(id);
    }

    @PostMapping
    public void crearEstado(@Valid @RequestBody EstadoTarea estadoTarea) {
        estadoTareaService.guardarEstadoTarea(estadoTarea);
    }

    @PutMapping("/{id}")
    public void actualizarEstado(@PathVariable Long id, @Valid @RequestBody EstadoTarea nuevoEstadoTarea) {
        estadoTareaService.actualizarEstadoTarea(id, nuevoEstadoTarea);
    }

    @DeleteMapping("/{id}")
    public void eliminarEstado(@PathVariable Long id) {
        estadoTareaService.eliminarEstadoTarea(id);
    }
}
