/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tap.m5b.evaluacion3m5b.controller;

import com.tap.m5b.evaluacion3m5b.model.Profesor;
import com.tap.m5b.evaluacion3m5b.service.ProfesorServiceImpl;
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
@RequestMapping("/api/profesor")
public class ProfesorController {

    @Autowired
    ProfesorServiceImpl cursoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Profesor>> listarProfesores() {
        return new ResponseEntity<>(cursoService.findByAll(), 
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Profesor> crearProfesor(
            @RequestBody Profesor c) {
        return new ResponseEntity<>(cursoService.save(c), 
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Profesor> actualizarProfesor(@PathVariable Long id, @RequestBody Profesor c) {
        Profesor cursoEncontrado = cursoService.findById(id);
        if (cursoEncontrado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                cursoEncontrado.setNombre(c.getNombre());
                cursoEncontrado.setTelefono(c.getTelefono());
                cursoEncontrado.setDireccion(c.getDireccion());
                return new ResponseEntity<>(cursoService.save(c), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Profesor> eliminarProfesor(@PathVariable Long id) {
        cursoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
