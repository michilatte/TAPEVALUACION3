/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tap.m5b.evaluacion3m5b.service;

import com.tap.m5b.evaluacion3m5b.model.Profesor;
import com.tap.m5b.evaluacion3m5b.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class ProfesorServiceImpl extends GenericServiceImpl<Profesor, Long> implements GenericService<Profesor, Long>{

    @Autowired
    ProfesorRepository profesorRepository;
    
    @Override
    public CrudRepository<Profesor, Long> getDao() {
        return profesorRepository;
    }
    
}
