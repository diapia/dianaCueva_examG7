package com.codigo.examen_g7.service.implementacion;

import com.codigo.examen_g7.entity.PedidoEntity;
import com.codigo.examen_g7.entity.PersonaEntity;
import com.codigo.examen_g7.enums.EstadoPedido;
import com.codigo.examen_g7.repository.PedidoRepository;
import com.codigo.examen_g7.repository.PersonaRepository;
import com.codigo.examen_g7.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PersonaRepository personaRepository;


    @Override
    public PedidoEntity crearPedido(PedidoEntity pedido) {
        return pedidoRepository.save(pedido);
    }



    @Override
    public List<PedidoEntity> buscarTodos(EstadoPedido estado) {
        return pedidoRepository.findByEstado(estado);
    }

    @Override
    public Optional<PedidoEntity> buscarPedidoPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    @Override
    public PedidoEntity actualizarPedido(Long id, PedidoEntity pedido) {

        PedidoEntity pedidoExistente = pedidoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Pedido no encontrado"));

        // Actualizar los campos del pedido
        pedidoExistente.setDescripcion(pedido.getDescripcion());
        pedidoExistente.setCantidad(pedido.getCantidad());
        pedidoExistente.setEstado(pedido.getEstado());


        if (pedido.getPersona() != null) {
            PersonaEntity persona = personaRepository.findById(pedido.getPersona().getId())
                    .orElseThrow(() -> new NoSuchElementException("Persona no encontrada"));
            pedidoExistente.setPersona(persona);
        }

        return pedidoRepository.save(pedidoExistente);



    }

    @Override
    public void eliminarPedido(Long id) {

        PedidoEntity pedido = pedidoRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Error pedido no encontrado"));
        pedido.setEstado((EstadoPedido.ELIMINADO));
        pedidoRepository.save(pedido);

    }
}
