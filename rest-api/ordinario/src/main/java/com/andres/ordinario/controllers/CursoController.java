package com.andres.ordinario.controllers;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.andres.ordinario.models.CursoModel;
import com.andres.ordinario.services.CursoService;

@RestController
@RequestMapping("/api/cursos")
@CrossOrigin(origins = "*")
public class CursoController {

    private final CursoService service;

    public CursoController(CursoService service) {
        this.service = service;
    }

    // Registrar curso
    @PostMapping
    public CursoModel registrar(@RequestBody CursoModel curso) {
        return service.save(curso);
    }

    // Consultar por ID
    @GetMapping("/{id}")
    public Optional<CursoModel> obtenerPorId(@PathVariable Long id) {
        return service.findById(id);
    }

    // Eliminar por ID
    @DeleteMapping("/{id}")
    public String eliminarPorId(@PathVariable Long id) {
        service.deleteById(id);
        return "Curso con ID " + id + " eliminado.";
    }

    // Eliminar por nombre
    @DeleteMapping("/nombre/{nombre}")
    public String eliminarPorNombre(@PathVariable String nombre) {
        Long count = service.deleteByNombre(nombre);
        return count + " curso(s) eliminados con nombre: " + nombre;
    }

    // Eliminar por fecha de inicio (ISO string → LocalDateTime)
    @DeleteMapping("/fecha-inicio/{fecha}")
    public String eliminarPorFecha(@PathVariable String fecha) {

        LocalDateTime parsed = LocalDateTime.parse(fecha);

        Long count = service.deleteByFechaInicio(parsed);

        return count + " curso(s) eliminados con fechaInicio: " + fecha;
    }
}
