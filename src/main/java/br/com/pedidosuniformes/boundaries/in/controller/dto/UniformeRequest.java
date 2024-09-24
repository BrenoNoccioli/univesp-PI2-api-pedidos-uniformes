package br.com.pedidosuniformes.boundaries.in.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UniformeRequest {
    private String genero;

    private String tamanho;

    private Long quantidade;
}
