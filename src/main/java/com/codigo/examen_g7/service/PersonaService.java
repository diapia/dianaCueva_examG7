package com.codigo.examen_g7.service;

import com.codigo.examen_g7.entity.PersonaEntity;

import java.util.List;
import java.util.Optional;

public interface PersonaService {

    PersonaEntity crearPersona(PersonaEntity persona);

    List<PersonaEntity> buscarTodos();

    PersonaEntity buscarPersonaPorNumeroDocumento(String numeroDocumento);

    PersonaEntity actualizarPersona(Long id, PersonaEntity persona);

    void eliminarPersona(Long id);
}
