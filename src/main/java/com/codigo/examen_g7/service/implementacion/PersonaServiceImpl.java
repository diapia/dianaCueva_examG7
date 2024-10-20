package com.codigo.examen_g7.service.implementacion;

import com.codigo.examen_g7.entity.PersonaEntity;
import com.codigo.examen_g7.enums.EstadoPersona;
import com.codigo.examen_g7.repository.PersonaRepository;
import com.codigo.examen_g7.service.PersonaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;



    @Override
    public PersonaEntity crearPersona(PersonaEntity persona) {
        return personaRepository.save(persona);
    }

    @Override
    public List<PersonaEntity> buscarTodos() {
        return personaRepository.findByEstado(EstadoPersona.ACTIVO);
    }

    @Override
    public PersonaEntity buscarPersonaPorNumeroDocumento(String numeroDocumento) {
        return personaRepository.findByNumeroDocumento(numeroDocumento)
                .orElseThrow(() -> new EntityNotFoundException("Persona no encontrada con el documento: " + numeroDocumento));
    }



    @Override
    public PersonaEntity actualizarPersona(Long id, PersonaEntity persona) {

        PersonaEntity personaExistente = personaRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Error Persona no encontrada con el id: "+id));
        personaExistente.setNombre(persona.getNombre());
        personaExistente.setApellidos(persona.getApellidos());
        personaExistente.setNumeroDocumento(persona.getNumeroDocumento());
        personaExistente.setDireccion(persona.getDireccion());
        personaExistente.setEstado(persona.getEstado());
        personaExistente.setPedidos(persona.getPedidos());
        return personaRepository.save(personaExistente);
    }

    @Override
    public void eliminarPersona(Long id) {

        PersonaEntity persona = personaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Persona no encontrada con el id: " + id));
        persona.setEstado(EstadoPersona.INACTIVO);
        personaRepository.save(persona);

    }
}
