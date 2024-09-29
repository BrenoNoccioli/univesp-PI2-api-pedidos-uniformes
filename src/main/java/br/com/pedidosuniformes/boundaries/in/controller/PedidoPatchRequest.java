package br.com.pedidosuniformes.boundaries.in.controller;

import br.com.pedidosuniformes.models.StatusPedido;
import br.com.pedidosuniformes.utils.validations.EnumValid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PedidoPatchRequest {

    @NotBlank
    @EnumValid(enumClass = StatusPedido.class, message = "Status informado inválido")
    private String status;
}
