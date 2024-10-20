package com.codigo.examen_g7.controller;

import com.codigo.examen_g7.entity.PedidoEntity;
import com.codigo.examen_g7.entity.PersonaEntity;
import com.codigo.examen_g7.enums.EstadoPedido;
import com.codigo.examen_g7.service.PedidoService;
import com.codigo.examen_g7.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos/v1")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;


    @PostMapping("/crearPedido")
    public ResponseEntity<PedidoEntity> crearPedido(@RequestBody PedidoEntity pedido) {
        return new ResponseEntity<>(pedidoService.crearPedido(pedido), HttpStatus.CREATED);
    }

    @GetMapping("/buscarTodos/{estado}")
    public ResponseEntity<List<PedidoEntity>> buscarTodos(@PathVariable EstadoPedido estado) {
            return new ResponseEntity<>(pedidoService.buscarTodos(estado), HttpStatus.OK);
    }




    @PutMapping("/actualizarPedido/{id}")
    public ResponseEntity<PedidoEntity> actualizarPedido(@PathVariable Long id, @RequestBody PedidoEntity pedido) {
        PedidoEntity pedidoActualizado = pedidoService.actualizarPedido(id, pedido);
        return new ResponseEntity<>(pedidoActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/eliminarPedido/{id}")
    public ResponseEntity<Void> eliminarPedido(@PathVariable Long id) {
        pedidoService.eliminarPedido(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
