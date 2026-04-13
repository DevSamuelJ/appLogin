package dev.samuelj.usuariosapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice // essa classe observa todos os controllers
public class GlobalExceptionHandler {

    @ExceptionHandler(ResponseStatusException.class) // quando acontecer esse tipo de erro, eu cuido dele
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErroResponse handleResponseStatusException(ResponseStatusException ex) {
        return new ErroResponse(
                ex.getStatusCode().value(),
                ex.getReason()
        );
    }
}