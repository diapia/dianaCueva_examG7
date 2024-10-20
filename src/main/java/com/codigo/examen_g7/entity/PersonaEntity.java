package com.codigo.examen_g7.entity;

import com.codigo.examen_g7.enums.EstadoPersona;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="personas")
@Getter
@Setter
public class PersonaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellidos;
    private String numeroDocumento;

    @Enumerated(EnumType.STRING)
    private EstadoPersona estado;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "direccion_id", referencedColumnName = "id")
    private DireccionEntity direccion;

    @JsonManagedReference
    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    private List<PedidoEntity> pedidos;
}
