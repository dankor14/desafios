package com.previred.desafioprevired.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name = "EstadoTarea")
public class EstadoTarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del estado no puede estar en blanco")
    @Size(max = 50, message = "El nombre del estado no puede tener más de 50 caracteres")
    @Column(name = "nombre")
    private String nombre;
}
