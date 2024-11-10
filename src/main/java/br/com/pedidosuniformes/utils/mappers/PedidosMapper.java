package br.com.pedidosuniformes.utils.mappers;

import br.com.pedidosuniformes.boundaries.in.controller.dto.PedidoRequest;
import br.com.pedidosuniformes.boundaries.in.controller.dto.PedidoResponse;
import br.com.pedidosuniformes.boundaries.in.controller.dto.UniformeRequest;
import br.com.pedidosuniformes.boundaries.in.controller.dto.UniformeResponse;
import br.com.pedidosuniformes.models.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PedidosMapper {

    public Pedido requestToEntity(PedidoRequest request){
        return Pedido.builder()
                .nomeCliente(request.getNomeCliente())
                .status(StatusPedido.RECEBIDO)
                .uniformes(uniformeRequestToEntityList(request.getUniformes()))
                .dataAbertura(LocalDate.now())
                .build();
    }

    public PedidoResponse entityToResponse(Pedido entity){
        return PedidoResponse.builder()
                .pedidoId(entity.getPedidoId())
                .nomeCliente(entity.getNomeCliente())
                .status(entity.getStatus().name())
                .uniformes(uniformeEntityToResponseList(entity.getUniformes()))
                .dataAbertura(String.valueOf(entity.getDataAbertura()))
                .build();
    }

    public List<PedidoResponse> entityToResponseList(List<Pedido> entities){
        return entities.stream().map(this::entityToResponse).collect(Collectors.toList());
    }

    public List<Uniforme> uniformeRequestToEntityList(List<UniformeRequest> requests){
        return requests.stream().map(this::uniformeRequestToEntity).collect(Collectors.toList());
    }

    public List<UniformeResponse> uniformeEntityToResponseList(List<Uniforme> entities){
        return entities.stream().map(this::uniformeEntityToResponse).collect(Collectors.toList());
    }

    public Uniforme uniformeRequestToEntity(UniformeRequest request){
        return new Uniforme(GeneroUniforme.valueOf(request.getGenero()),
                TamanhoUniforme.valueOf(request.getTamanho()),
                request.getQuantidade());
    }

    public UniformeResponse uniformeEntityToResponse(Uniforme entity){
        return UniformeResponse.builder()
                .genero(entity.getGenero().name())
                .tamanho(entity.getTamanho().name())
                .quantidade(entity.getQuantidade())
                .build();
    }
}
