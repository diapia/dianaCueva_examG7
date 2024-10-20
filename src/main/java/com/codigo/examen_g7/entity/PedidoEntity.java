package com.codigo.examen_g7.entity;

import com.codigo.examen_g7.enums.EstadoPedido;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pedidos")
@Getter
@Setter
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private Integer cantidad;
    @Enumerated(EnumType.STRING)
    private EstadoPedido estado;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "persona_id", referencedColumnName = "id", nullable = false)
    private PersonaEntity persona;
}
