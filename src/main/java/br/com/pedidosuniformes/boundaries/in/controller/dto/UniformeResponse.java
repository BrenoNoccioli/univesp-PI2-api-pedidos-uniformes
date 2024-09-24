package br.com.pedidosuniformes.boundaries.in.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UniformeResponse {

    private String genero;

    private String tamanho;

    private Long quantidade;
}
