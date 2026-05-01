package dev.samuelj.usuariosapi.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ErroResponse {

    private int status;
    private String mensagem;
    private LocalDateTime timestamp;
    private List<String> erros = new ArrayList<>();

    public ErroResponse(int status, String mensagem, List<String> erros) {
        this.status = status;
        this.mensagem = mensagem;
        this.timestamp = LocalDateTime.now();
        this.erros = erros;
    }
    public ErroResponse(int status, String mensagem) {
    this.status = status;
    this.mensagem = mensagem;
    this.timestamp = LocalDateTime.now();
}

    public int getStatus() {
        return status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }


}