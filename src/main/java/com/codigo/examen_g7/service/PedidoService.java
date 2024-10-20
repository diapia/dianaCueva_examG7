package com.codigo.examen_g7.service;

import com.codigo.examen_g7.entity.PedidoEntity;
import com.codigo.examen_g7.enums.EstadoPedido;

import java.util.List;
import java.util.Optional;

public interface PedidoService {

    PedidoEntity crearPedido(PedidoEntity pedido);

    List<PedidoEntity> buscarTodos(EstadoPedido estado);

    Optional<PedidoEntity> buscarPedidoPorId(Long id);

    PedidoEntity actualizarPedido(Long id, PedidoEntity pedido);

    void eliminarPedido(Long id);

}
