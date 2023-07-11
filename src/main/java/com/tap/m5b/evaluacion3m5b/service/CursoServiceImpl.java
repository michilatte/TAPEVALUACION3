/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tap.m5b.evaluacion3m5b.service;

import com.tap.m5b.evaluacion3m5b.model.Curso;
import com.tap.m5b.evaluacion3m5b.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class CursoServiceImpl extends GenericServiceImpl<Curso, Long> implements GenericService<Curso, Long>{

    @Autowired
    CursoRepository cursoRepository;
    
    @Override
    public CrudRepository<Curso, Long> getDao() {
        return cursoRepository;
    }
    
}
