package br.com.pedidosuniformes.repositories;

import br.com.pedidosuniformes.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidosRepository extends JpaRepository<Pedido, Long> {
}
