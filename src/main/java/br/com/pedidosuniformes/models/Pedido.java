package br.com.pedidosuniformes.models;

import jakarta.persistence.Entity;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Pedido {

    private Long pedidoId;
    private String nomeCliente;
    private LocalDate dataAbertura;
    private StatusPedido status;
    private List<Uniforme> uniformes;
}
