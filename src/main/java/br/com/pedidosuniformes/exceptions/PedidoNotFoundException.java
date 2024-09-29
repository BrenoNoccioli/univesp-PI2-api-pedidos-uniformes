package br.com.pedidosuniformes.exceptions;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public class PedidoNotFoundException extends RuntimeException {

    private final HttpStatus status;
    private final String message;


    public static PedidoNotFoundException create(String message){
        return new PedidoNotFoundException(HttpStatus.NOT_FOUND, message);
    }

}
