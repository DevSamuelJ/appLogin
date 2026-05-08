package dev.samuelj.usuariosapi.dto;

public class UsuarioResponseDTO {



    private String nome;
    private String email;
    private int idade;
    private String profissao;

    public UsuarioResponseDTO( String nome, String email, int idade, String profissao) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.profissao = profissao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }
}

