package com.previred.desafioprevired.repository;

import com.previred.desafioprevired.model.Tarea;
import com.previred.desafioprevired.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {

    List<Tarea> findAllByUsuario(Usuario usuario);

}
