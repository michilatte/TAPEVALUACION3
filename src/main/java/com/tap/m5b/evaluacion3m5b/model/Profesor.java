/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tap.m5b.evaluacion3m5b.model;

import java.util.List;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author USUARIO
 */
@Data
@Document(collection = "Profesores")
public class Profesor {
    @Id
    private Long prod_id;
    private String nombre;
    private String telefono;
    private String direccion;
    
    //RELACION CON CURSOS
    private List<Curso> listaCursos;
    private Depto depto;
    
}
