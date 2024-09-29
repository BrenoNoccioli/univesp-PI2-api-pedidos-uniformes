package br.com.pedidosuniformes.boundaries.in.controller.dto;

import br.com.pedidosuniformes.models.GeneroUniforme;
import br.com.pedidosuniformes.models.TamanhoUniforme;
import br.com.pedidosuniformes.utils.validations.EnumValid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UniformeRequest {
    @NotBlank
    @EnumValid(enumClass = GeneroUniforme.class)
    private String genero;

    @NotBlank
    @EnumValid(enumClass = TamanhoUniforme.class)
    private String tamanho;

    @NotBlank
    @Positive
    private Long quantidade;
}
