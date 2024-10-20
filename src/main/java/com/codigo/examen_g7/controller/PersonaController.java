package com.codigo.examen_g7.controller;

import com.codigo.examen_g7.entity.PersonaEntity;
import com.codigo.examen_g7.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas/v1")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @PostMapping("/crear")
    public ResponseEntity<PersonaEntity> crearPersona(@RequestBody PersonaEntity persona){

        PersonaEntity nuevaPersona = personaService.crearPersona(persona);
        return new ResponseEntity<>(nuevaPersona, HttpStatus.CREATED);
    }

    @GetMapping("/buscarTodos")
    public ResponseEntity<List<PersonaEntity>> buscarTodos(){
        List<PersonaEntity> personas = personaService.buscarTodos();
        return new ResponseEntity<>(personas, HttpStatus.OK);
    }

    @GetMapping("/buscarPersona/{numeroDocumento}")
    public ResponseEntity<PersonaEntity> buscarPersonaPorNumeroDocumento(@PathVariable String numeroDocumento){

        PersonaEntity persona = personaService.buscarPersonaPorNumeroDocumento(numeroDocumento);
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
        public ResponseEntity<PersonaEntity> actualizarPersona(@PathVariable Long id, @RequestBody PersonaEntity persona){
        PersonaEntity personaActualizada = personaService.actualizarPersona(id, persona);
        return new ResponseEntity<>(personaActualizada, HttpStatus.OK);
        }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarPersona(@PathVariable Long id){
        personaService.eliminarPersona(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }







}
