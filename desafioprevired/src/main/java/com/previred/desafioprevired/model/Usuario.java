package com.previred.desafioprevired.model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@ToString
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar en blanco")
    @Size(max = 50, message = "El nombre no puede tener más de 50 caracteres")
    @Column(name = "nombre")
    private String nombre;

    @NotBlank(message = "El email no puede estar en blanco")
    @Email(message = "Formato de email incorrecto")
    @Size(max = 100, message = "El email no puede tener más de 100 caracteres")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "La contraseña no puede estar en blanco")
    @Size(max = 100, message = "La contraseña no puede tener más de 100 caracteres")
    @Column(name = "password")
    private String password;
}
