package br.com.pedidosuniformes.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Uniforme {
    @Enumerated(EnumType.STRING)
    private GeneroUniforme genero;

    @Enumerated(EnumType.STRING)
    private TamanhoUniforme tamanho;

    private Long quantidade;
}
