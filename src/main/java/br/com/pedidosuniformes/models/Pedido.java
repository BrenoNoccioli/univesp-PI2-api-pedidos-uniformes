package br.com.pedidosuniformes.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pedidoId;

    private String nomeCliente;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    @ElementCollection
    @CollectionTable(name = "pedidos_uniformes", joinColumns = @JoinColumn(name = "pedido_id"))
    private List<Uniforme> uniformes;

    private LocalDate dataAbertura;
}
