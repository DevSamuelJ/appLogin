package dev.samuelj.usuariosapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice // faz com que essa classe observe todos os controllers
public class GlobalExceptionHandler { // quando acontecer certo tipo de erro, eu transformo ele em um ErroResponse (molde/corpo do erro)

    @ExceptionHandler(ResponseStatusException.class) // quando acontecer esse tipo de erro, eu cuido dele
//    @ResponseStatus(HttpStatus.NOT_FOUND) // Sem utilidade no momento, pois se usarmos isso, o método vai ficar fixo em sempre retornar um erro 404 (not fount)
    public ErroResponse handleResponseStatusException(ResponseStatusException ex) {

        return new ErroResponse( // Isso além de retornar as informações ele instancia um objeto automaticamente da classe ErrorResponde
                ex.getStatusCode().value(),
                ex.getReason()
        );
    }
}