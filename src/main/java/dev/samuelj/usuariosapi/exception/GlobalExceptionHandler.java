package dev.samuelj.usuariosapi.exception;


import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.awt.font.FontRenderContext;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice // faz com que essa classe observe todos os controllers
public class GlobalExceptionHandler { // quando acontecer certo tipo de erro, eu transformo ele em um ErroResponse (molde/corpo do erro)

    @ExceptionHandler(ResponseStatusException.class) // quando acontecer esse tipo de erro, eu cuido dele
    public ErroResponse handleResponseStatusException(ResponseStatusException ex) {

        return new ErroResponse( // Isso além de retornar as informações ele instancia um objeto automaticamente da classe ErrorResponde
                ex.getStatusCode().value(),
                ex.getReason()
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class) // essa parte ta dizendo: se esse tipo de erro acontecer, chama esse método; O .class serve pra pegar a classe.
    public ErroResponse nomeDoMetodo(MethodArgumentNotValidException ex) {
        List<String> erros = new ArrayList<>();
        for(FieldError erro: ex.getBindingResult().getFieldErrors()){
            
        }
    }
}