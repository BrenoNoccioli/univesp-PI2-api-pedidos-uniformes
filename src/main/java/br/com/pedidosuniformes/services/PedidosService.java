package br.com.pedidosuniformes.services;

import br.com.pedidosuniformes.boundaries.in.controller.PedidoPatchRequest;
import br.com.pedidosuniformes.boundaries.in.controller.dto.PedidoRequest;
import br.com.pedidosuniformes.boundaries.in.controller.dto.PedidoResponse;
import br.com.pedidosuniformes.exceptions.PedidoNotFoundException;
import br.com.pedidosuniformes.models.Pedido;
import br.com.pedidosuniformes.models.StatusPedido;
import br.com.pedidosuniformes.repositories.PedidosRepository;
import br.com.pedidosuniformes.utils.mappers.PedidosMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PedidosService {

    private final PedidosRepository repository;
    private final PedidosMapper mapper;

    public PedidoResponse postPedido(PedidoRequest pedidoRequest) {
        Pedido pedido = mapper.requestToEntity(pedidoRequest);

        Pedido pedidoSalvo = repository.save(pedido);

        return mapper.entityToResponse(pedidoSalvo);
    }

    public List<PedidoResponse> getAllPedidos() {

        List<Pedido> pedidos = repository.findAll();

        return mapper.entityToResponseList(pedidos);
    }

    public PedidoResponse findPedidoById(Long pedidoId) {
        Optional<Pedido> optionalPedido = repository.findById(pedidoId);

        if (optionalPedido.isEmpty()){
            throw PedidoNotFoundException.create("Pedido não encontrado");
        }

        return mapper.entityToResponse(optionalPedido.get());
    }

    public PedidoResponse patchStatusPedido(Long pedidoId, PedidoPatchRequest pedidoRequest) {
        Optional<Pedido> optionalPedido = repository.findById(pedidoId);

        if (optionalPedido.isEmpty()){
            throw PedidoNotFoundException.create("Pedido não encontrado");
        }

        Pedido pedido = optionalPedido.get();
        pedido.setStatus(StatusPedido.valueOf(pedidoRequest.getStatus()));

        repository.save(pedido);

        return mapper.entityToResponse(pedido);

    }
}
