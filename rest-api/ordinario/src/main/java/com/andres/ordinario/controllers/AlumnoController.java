package com.andres.ordinario.controllers;

import com.andres.ordinario.models.dto.AlumnoDto;
import com.andres.ordinario.services.SoapClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/alumnos")
@RequiredArgsConstructor
public class AlumnoController {

    private final SoapClientService soap;

    @PostMapping
    public String inscribir(@RequestBody AlumnoDto dto) {
        return soap.inscribirAlumno(dto.matricula, dto.curp, dto.nombre, dto.apellido, dto.email);
    }

    @GetMapping("/{matricula}")
    public String consultar(@PathVariable String matricula) {
        return soap.consultarAlumno(matricula);
    }

    @PutMapping("/{matricula}")
    public String editar(@PathVariable String matricula, @RequestBody AlumnoDto dto) {
        return soap.editarAlumno(matricula, dto.nombre, dto.apellido, dto.email, dto.estatus);
    }

    @DeleteMapping("/{matricula}")
    public String eliminar(@PathVariable String matricula) {
        return soap.eliminarAlumno(matricula);
    }
}
