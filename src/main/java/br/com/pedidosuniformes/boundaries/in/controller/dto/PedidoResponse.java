package br.com.pedidosuniformes.boundaries.in.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PedidoResponse {
    private Long pedidoId;

    private String nomeCliente;

    private String status;

    private List<UniformeResponse> uniformes;

    private String dataAbertura;
}
