package br.com.pedidosuniformes.boundaries.in.controller;

import br.com.pedidosuniformes.boundaries.in.controller.dto.PedidoRequest;
import br.com.pedidosuniformes.boundaries.in.controller.dto.PedidoResponse;
import br.com.pedidosuniformes.services.PedidosService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@AllArgsConstructor
@RestController
@RequestMapping("/pedidos")
public class PedidosController {

    private final PedidosService service;

    @PostMapping
    public ResponseEntity<PedidoResponse> criarPedido(@RequestBody PedidoRequest pedidoRequest) {
        PedidoResponse response = service.postPedido(pedidoRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<PedidoResponse>> obterTodosPedidos() {
        List<PedidoResponse> response = service.getAllPedidos();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{pedidoId}")
    public ResponseEntity<PedidoResponse> obterPedidoPorId(@PathVariable Long pedidoId) {
        PedidoResponse response = service.findPedidoById(pedidoId);
        return ResponseEntity.ok(response);
    }


    @PatchMapping("/{pedidoId}")
    public ResponseEntity<PedidoResponse> atualizarPedidoParcial(@PathVariable Long pedidoId,
                                                                 @RequestBody PedidoPatchRequest pedidoRequest) {
        PedidoResponse response = service.patchStatusPedido(pedidoId, pedidoRequest);
        return ResponseEntity.ok(response);
    }

}