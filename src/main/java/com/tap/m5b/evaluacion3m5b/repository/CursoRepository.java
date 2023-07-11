/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tap.m5b.evaluacion3m5b.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.tap.m5b.evaluacion3m5b.model.Curso;
/**
 *
 * @author USUARIO
 */
public interface CursoRepository extends MongoRepository<Curso, Long>{
}
