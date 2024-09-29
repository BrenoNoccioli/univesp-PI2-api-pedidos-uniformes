package br.com.pedidosuniformes.utils.mappers;

import br.com.pedidosuniformes.boundaries.in.controller.dto.PedidoRequest;
import br.com.pedidosuniformes.boundaries.in.controller.dto.PedidoResponse;
import br.com.pedidosuniformes.boundaries.in.controller.dto.UniformeRequest;
import br.com.pedidosuniformes.boundaries.in.controller.dto.UniformeResponse;
import br.com.pedidosuniformes.models.GeneroUniforme;
import br.com.pedidosuniformes.models.Pedido;
import br.com.pedidosuniformes.models.StatusPedido;
import br.com.pedidosuniformes.models.Uniforme;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper
public interface PedidosMapper {

    @Mapping(source = "uniformes", target = "uniforme", qualifiedByName = "uniformeRequestToEntityList")
    @Mapping(target = "status", defaultValue = "StatusPedido.RECEBIDO")
    @Mapping(target = "dataAbertura", defaultValue = "LocalDate.now()")
    Pedido requestToEntity(PedidoRequest request);

    @Named("entityToResponse")
    @Mapping(source = "uniformes", target = "uniformes", qualifiedByName = "uniformeEntityToResponseList")
    @Mapping(target = "status", expression = "java(entity.getStatus().name())")
    @Mapping(target = "dataAbertura", expression = "java(String.valueOf(entity.getDataAbertura()))")
    PedidoResponse entityToResponse(Pedido entity);

    @IterableMapping(qualifiedByName = "entityToResponse")
    List<PedidoResponse> entityToResponseList(List<Pedido> entities);

    @Named("uniformeRequestToEntityList")
    @IterableMapping(qualifiedByName = "uniformeRequestToEntity")
    List<Uniforme> uniformeRequestToEntityList(List<UniformeRequest> requests);

    @Named("uniformeEntityToResponseList")
    @IterableMapping(qualifiedByName = "uniformeEntityToResponse")
    List<UniformeResponse> uniformeEntityToResponseList(List<Uniforme> entities);

    @Named("uniformeRequestToEntity")
    @Mapping(target = "genero", expression = "java(GeneroUniforme.valueOf(request.getGenero()))")
    @Mapping(target = "tamanho", expression = "java(TamanhoUniforme.valueOf(request.getTamanho()))")
    Uniforme uniformeRequestToEntity(UniformeRequest request);

    @Named("uniformeEntityToResponse")
    @Mapping(target = "genero", expression = "java(entity.getGenero().name())")
    @Mapping(target = "tamanho", expression = "java(entity.getTamanho().name())")
    UniformeResponse uniformeEntityToResponse(Uniforme entity);
}
