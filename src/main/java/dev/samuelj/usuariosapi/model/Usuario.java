package dev.samuelj.usuariosapi.model;

public class Usuario {
    private int id;
    private String nome;
    private int idade;
    private String profissao;

    public Usuario(String nome, int idade, String profissao) {
        this.nome = nome;
        this.idade = idade;
        this.profissao = profissao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getProfissao() {
        return profissao;
    }
}