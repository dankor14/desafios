package com.previred.desafioprevired.repository;

import com.previred.desafioprevired.model.EstadoTarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoTareaRepository extends JpaRepository<EstadoTarea, Long> {

}
