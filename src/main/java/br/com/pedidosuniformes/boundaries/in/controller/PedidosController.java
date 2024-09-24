package br.com.pedidosuniformes.boundaries.in.controller;

import br.com.pedidosuniformes.boundaries.in.controller.dto.PedidoRequest;
import br.com.pedidosuniformes.boundaries.in.controller.dto.PedidoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {

    @PostMapping
    public ResponseEntity<PedidoResponse> criarPedido(@RequestBody PedidoRequest pedidoRequest) {

        return null;
    }

    @GetMapping
    public ResponseEntity<List<PedidoResponse>> obterTodosPedidos() {

        return null;
    }

    // Método GET para obter um pedido por ID
    @GetMapping("/{pedidoId}")
    public ResponseEntity<PedidoResponse> obterPedidoPorId(@PathVariable Long pedidoId) {

        return null;
    }

    // Método PATCH para atualizar parcialmente um pedido
    @PatchMapping("/{pedidoId}")
    public ResponseEntity<PedidoResponse> atualizarPedidoParcial(@PathVariable Long id,
                                                                 @RequestBody PedidoRequest pedidoRequest) {
        return null;
    }

}