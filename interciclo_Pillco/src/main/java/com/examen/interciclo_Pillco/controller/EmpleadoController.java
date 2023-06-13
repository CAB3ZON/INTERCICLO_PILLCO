/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen.interciclo_Pillco.controller;

import com.examen.interciclo_Pillco.model.Empleado;
import com.examen.interciclo_Pillco.service.EmpleadoServicelmpl;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("/empleado")
public class EmpleadoController {
    @Autowired
    EmpleadoServicelmpl empleadoService;
    
    
    @Operation(summary = "Se obtiene la lista de Empleados")
    @GetMapping("/listar")
    public ResponseEntity<List<Empleado>> listaEmpleado() {
        return new ResponseEntity<>(empleadoService.findByAll(), HttpStatus.OK);
    }

    @Operation(summary = "Debe enviar los campos del empleado")
    @PostMapping("/crear")
    public ResponseEntity<Empleado> crearPersona(@RequestBody Empleado u) {
        
        
        
        double x=u.getDias_trabajo()*15;
        
        if (u.getDias_trabajo()>=30) {
            u.setSueldo(x+x*0.5);
        }else{
        if (u.getDias_trabajo()>=20) {
            u.setSueldo(x+x*0.2);
        }else{
            u.setSueldo(x);
        }
        }
        
        
        
        return new ResponseEntity<>(empleadoService.save(u), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Empleado> actualizarPersona(@PathVariable Integer id, @RequestBody Empleado u) {
        Empleado empleado = empleadoService.findById(id);
        if (empleado != null) {
            try {
                empleado.setApellido(u.getApellido());
                empleado.setDias_trabajo(u.getDias_trabajo());
                empleado.setDireccion(u.getDireccion());
                empleado.setFecha_nacimiento(u.getFecha_nacimiento());
                empleado.setNombre(u.getNombre());
                empleado.setObservacion(u.getObservacion());
                empleado.setSueldo(u.getSueldo());
                empleado.setTelefono(u.getTelefono());
                return new ResponseEntity<>(empleadoService.save(empleado), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Empleado> eliminarPersona(@PathVariable Integer id) {
        empleadoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
    
}
