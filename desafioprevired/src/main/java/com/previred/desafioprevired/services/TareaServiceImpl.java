package com.previred.desafioprevired.services;

import com.previred.desafioprevired.model.Tarea;
import com.previred.desafioprevired.model.Usuario;
import com.previred.desafioprevired.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TareaServiceImpl implements TareaService   {

    @Autowired
    private TareaRepository tareaRepository;

    @Autowired
    private UsuarioService usuarioService;
    @Override
    public List<Tarea> getAllTareas() {
        return tareaRepository.findAll();
    }

    @Override
    public Tarea getTareaById(Long id) {
        return tareaRepository.findById(id).orElse(null);
    }

    @Override
    public void guardarTarea(Tarea tarea) {
        tareaRepository.save(tarea);
    }

    @Override
    public void actualizarTarea(Long id, Tarea nuevaTarea) {
        Tarea tareaExistente = tareaRepository.findById(id).orElse(null);
        if (tareaExistente != null) {
            tareaExistente.setTitulo(nuevaTarea.getTitulo());
            tareaExistente.setDescripcion(nuevaTarea.getDescripcion());
            tareaExistente.setUsuario(nuevaTarea.getUsuario());
            tareaExistente.setEstado(nuevaTarea.getEstado());
            tareaRepository.save(tareaExistente);
        }
    }

    @Override
    public void eliminarTarea(Long id) {
        tareaRepository.deleteById(id);
    }

    @Override
    public List<Tarea> getAllTareasByUsuario(String username) {
        Usuario usuario = usuarioService.getUsuarioByUsername(username);
        if (usuario != null) {
            return tareaRepository.findAllByUsuario(usuario);
        }
        return Collections.emptyList();
    }
}
