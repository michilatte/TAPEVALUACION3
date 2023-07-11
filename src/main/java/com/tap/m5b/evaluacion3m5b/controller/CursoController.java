/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tap.m5b.evaluacion3m5b.controller;

import com.tap.m5b.evaluacion3m5b.model.Curso;
import com.tap.m5b.evaluacion3m5b.service.CursoServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
@RequestMapping("/api/curso")
public class CursoController {

    @Autowired
    CursoServiceImpl cursoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Curso>> listarCursos() {
        return new ResponseEntity<>(cursoService.findByAll(), 
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Curso> crearCurso(
            @RequestBody Curso c) {
        return new ResponseEntity<>(cursoService.save(c), 
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Curso> actualizarCurso(@PathVariable Long id, @RequestBody Curso c) {
        Curso cursoEncontrado = cursoService.findById(id);
        if (cursoEncontrado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                cursoEncontrado.setNombre(c.getNombre());
                cursoEncontrado.setNivel(c.getNivel());
                cursoEncontrado.setDescripcion(c.getDescripcion());
                return new ResponseEntity<>(cursoService.save(c), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Curso> eliminarCurso(@PathVariable Long id) {
        cursoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
