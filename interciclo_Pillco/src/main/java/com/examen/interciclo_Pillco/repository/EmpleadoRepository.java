/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.examen.interciclo_Pillco.repository;


import com.examen.interciclo_Pillco.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author USUARIO
 */
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
    
    @Query(value = "Select * from persona u where u.nombre_per = :nombre_per", nativeQuery = true)
    public Empleado buscarPersona(String nombre);

}
