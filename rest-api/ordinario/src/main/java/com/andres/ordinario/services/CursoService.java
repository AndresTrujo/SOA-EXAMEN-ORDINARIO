package com.andres.ordinario.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.andres.ordinario.models.CursoModel;
import com.andres.ordinario.repositories.ICursoRepository;

@Service
public class CursoService {

    private final ICursoRepository repo;

    public CursoService(ICursoRepository repo) {
        this.repo = repo;
    }

    // Registrar o actualizar curso
    public CursoModel save(CursoModel curso) {
        return repo.save(curso);
    }

    // Consultar por ID
    public Optional<CursoModel> findById(Long id) {
        return repo.findById(id);
    }

    // Eliminar por ID
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    // Eliminar por nombre
    public Long deleteByNombre(String nombre) {
        return repo.deleteByNombre(nombre);
    }

    // Eliminar por fecha de inicio
    public Long deleteByFechaInicio(LocalDateTime fechaInicio) {
        return repo.deleteByFechaInicio(fechaInicio);
    }
}
