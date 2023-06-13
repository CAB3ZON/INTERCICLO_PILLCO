/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen.interciclo_Pillco.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author USUARIO
 */
@Data
@Entity
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private int id_empleado;
    
      //  @Size(min = 1, max = 45, message = "El apellido debe tener entre 1 y 45 caracteres")
    // @NotBlank(message = "El apellido no puede estar en blanco")
    @Column(name = "apellido")
    private String apellido;
        
        //@Size(min = 1, max = 45, message = "El nombre debe tener entre 1 y 45 caracteres")
     // @NotBlank(message = "El nombre no puede estar en blanco")
    @Column(name = "nombre")
    private String nombre;
    
       // @Size(min = 1, max = 15, message = "El telefono debe tener entre 1 y 15 caracteres")
      // @NotBlank(message = "El telefono no puede estar en blanco")
    @Column(name = "telefono")
    private String telefono;
    
       // @Size(min = 1, max = 45, message = "La direccion debe tener entre 1 y 45 caracteres")
      // @NotBlank(message = "La direccion no puede estar en blanco")
    @Column(name = "direccion")
    private String direccion;
    
         //@NotBlank(message = "La fecha no puede estar en blanco")
     @Column(name = "fecha_nacimiento")
    private Date fecha_nacimiento;
     
          // @Size(min = 1, max = 45, message = "La observacion debe tener entre 1 y 45 caracteres")
         // @NotBlank(message = "La observacion no puede estar en blanco")
     @Column(name = "observacion")
    private String observacion;
     
          // @NotBlank(message = "Los dias de trabajo no puede estar en blanco")
     @Column(name = "dias_trabajo")
    private int dias_trabajo;
     
            //@NotBlank(message = "La observacion no puede estar en blanco")
     @Column(name = "sueldo")
    private double sueldo;
}
