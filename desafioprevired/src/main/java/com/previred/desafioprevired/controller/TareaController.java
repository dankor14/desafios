package com.previred.desafioprevired.controller;

import com.previred.desafioprevired.model.Tarea;
import com.previred.desafioprevired.model.Usuario;
import com.previred.desafioprevired.services.SecurityService;
import com.previred.desafioprevired.services.TareaService;
import com.previred.desafioprevired.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private SecurityService securityService;

    @GetMapping
    public List<Tarea> getAllTareas(HttpServletRequest request) {
        String username = securityService.obtenerNombreUsuarioAutenticado();
        return tareaService.getAllTareasByUsuario(username);
    }

    @GetMapping("/{id}")
    public Tarea getTareaById(@PathVariable Long id) {
        return tareaService.getTareaById(id);
    }

    @PostMapping
    public void crearTarea(@Valid @RequestBody Tarea tarea, HttpServletRequest request) {
        String username = securityService.obtenerNombreUsuarioAutenticado();
        Usuario usuario = usuarioService.getUsuarioByUsername(username);
        tarea.setUsuario(usuario);
        tareaService.guardarTarea(tarea);
    }

    @PutMapping("/{id}")
    public void actualizarTarea(@PathVariable Long id, @Valid @RequestBody Tarea nuevaTarea) {
        tareaService.actualizarTarea(id, nuevaTarea);
    }

    @DeleteMapping("/{id}")
    public void eliminarTarea(@PathVariable Long id) {
        tareaService.eliminarTarea(id);
    }
}
