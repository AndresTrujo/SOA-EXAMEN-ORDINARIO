package com.andres.ordinario.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andres.ordinario.models.CalificacionModel;

public interface ICalificacionRepository extends JpaRepository<CalificacionModel, Long> {
    List<CalificacionModel> findByMatriculaAlumno(String matriculaAlumno);
}
