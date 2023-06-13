/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen.interciclo_Pillco.service;

import com.examen.interciclo_Pillco.model.Empleado;
import com.examen.interciclo_Pillco.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class EmpleadoServicelmpl extends GenericServiceImpl<Empleado,Integer> implements GenericService<Empleado,Integer> {
@Autowired
EmpleadoRepository empleadoRepository;
    @Override
    public CrudRepository<Empleado, Integer> getDao() {
return empleadoRepository;
    }
    
}
