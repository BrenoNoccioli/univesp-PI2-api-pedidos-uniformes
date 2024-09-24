package br.com.pedidosuniformes.boundaries.in.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoRequest {
    private String nomeCliente;

    private String status;

    private List<UniformeRequest> uniformes;
}
