package br.com.pedidosuniformes.boundaries.in.controller.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoRequest {
    @NotBlank
    private String nomeCliente;

    @NotBlank
    private List<UniformeRequest> uniformes;
}
