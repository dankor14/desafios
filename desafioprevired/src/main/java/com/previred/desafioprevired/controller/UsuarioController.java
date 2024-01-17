package com.previred.desafioprevired.controller;

import com.previred.desafioprevired.model.Usuario;
import com.previred.desafioprevired.services.SecurityService;
import com.previred.desafioprevired.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private SecurityService securityService;

    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario getUsuarioById(@PathVariable Long id) {
        return usuarioService.getUsuarioById(id);
    }

    @PostMapping
    public void crearUsuario(@Valid @RequestBody Usuario usuario) {
        usuarioService.guardarUsuario(usuario);
    }

    @PutMapping("/{id}")
    public void actualizarUsuario(@PathVariable Long id, @Valid @RequestBody Usuario nuevoUsuario) {
        usuarioService.actualizarUsuario(id, nuevoUsuario);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
    }

    @GetMapping("/me")
    public String obtenerNombreUsuarioAutenticado() {
        return securityService.obtenerNombreUsuarioAutenticado();
    }
}
