/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tap.m5b.evaluacion3m5b.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author USUARIO
 */
@Data
@Document(collection = "Deptos")
public class Depto {
    @Id
    private Long depto_id;
    private String nombre;
    private String director;
    private String descripcion;
    
}
