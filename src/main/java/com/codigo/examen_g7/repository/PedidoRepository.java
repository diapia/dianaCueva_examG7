package com.codigo.examen_g7.repository;

import com.codigo.examen_g7.entity.PedidoEntity;
import com.codigo.examen_g7.entity.PersonaEntity;
import com.codigo.examen_g7.enums.EstadoPedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {


    List<PedidoEntity> findByEstado(EstadoPedido estado);
}
