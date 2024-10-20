package com.codigo.examen_g7.repository;

import com.codigo.examen_g7.entity.PersonaEntity;
import com.codigo.examen_g7.enums.EstadoPersona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonaRepository extends JpaRepository<PersonaEntity, Long> {


    Optional<PersonaEntity> findByNumeroDocumento(String numeroDocumento);

    List<PersonaEntity> findByEstado(EstadoPersona estado);
}
