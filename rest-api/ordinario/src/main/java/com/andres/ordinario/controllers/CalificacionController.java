package com.andres.ordinario.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andres.ordinario.models.CalificacionModel;
import com.andres.ordinario.services.CalificationService;

@RestController
@RequestMapping("/api/calificaciones")
@CrossOrigin(origins = "*")
public class CalificacionController {

    private final CalificationService service;

    public CalificacionController(CalificationService service) {
        this.service = service;
    }

    // Guardar nueva calificación (POST)
    @PostMapping
    public CalificacionModel registrarCalificacion(@RequestBody CalificacionModel nuevaCalificacion) {
        return service.save(nuevaCalificacion);
    }

    // Obtener todas las calificaciones (GET)
    @GetMapping
    public List<CalificacionModel> obtenerTodas() {
        return service.findAll();
    }

    // Obtener calificaciones de un alumno específico (GET)
    @GetMapping("/alumno/{matricula}")
    public List<CalificacionModel> obtenerPorAlumno(@PathVariable String matricula) {
        return service.findByMatriculaAlumno(matricula);
    }

}
