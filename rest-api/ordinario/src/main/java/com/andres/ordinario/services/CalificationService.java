package com.andres.ordinario.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.andres.ordinario.models.CalificacionModel;
import com.andres.ordinario.repositories.ICalificacionRepository;

@Service
public class CalificationService {
    private final ICalificacionRepository repo;

    public CalificationService(ICalificacionRepository repo) {
        this.repo = repo;
    }

    public List<CalificacionModel> findAll() {
        return repo.findAll();
    }

    public Optional<CalificacionModel> findById(Long id) {
        return repo.findById(id);
    }

    public CalificacionModel save(CalificacionModel m) {
        return repo.save(m);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    public java.util.Optional<CalificacionModel> updateById(Long id, CalificacionModel updated) {
        return repo.findById(id).map(existing -> {
            updated.setId(id);
            return repo.save(updated);
        });
    }

    public List<CalificacionModel> findByMatriculaAlumno(String matricula) {
        return repo.findByMatriculaAlumno(matricula);
    }

}
