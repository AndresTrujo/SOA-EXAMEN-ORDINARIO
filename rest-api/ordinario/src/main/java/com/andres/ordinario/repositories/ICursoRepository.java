package com.andres.ordinario.repositories;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andres.ordinario.models.CursoModel;

@Repository
public interface ICursoRepository extends JpaRepository<CursoModel, Long> {

    // Eliminar por nombre (retorna número de filas eliminadas)
    Long deleteByNombre(String nombre);

    // Eliminar por fecha de inicio
    Long deleteByFechaInicio(LocalDateTime fechaInicio);
}
