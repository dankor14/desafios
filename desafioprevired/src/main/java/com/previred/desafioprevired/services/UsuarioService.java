package com.previred.desafioprevired.services;

import com.previred.desafioprevired.model.Usuario;

import java.util.List;

public interface UsuarioService {

    public List<Usuario> getAllUsuarios();
    public Usuario getUsuarioById(Long id);
    public void guardarUsuario(Usuario usuario);
    public void actualizarUsuario(Long id, Usuario nuevoUsuario);
    public void eliminarUsuario(Long id);
    Usuario getUsuarioByUsername(String username);
}
