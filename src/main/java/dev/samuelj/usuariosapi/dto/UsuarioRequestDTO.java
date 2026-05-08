package dev.samuelj.usuariosapi.dto;


import jakarta.validation.constraints.*;


public class UsuarioRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotNull(message = "Idade é obrigatória")
    @Min(value = 18, message = "O usuário deve ser maior ou igual a 18 anos")
    private Integer idade;

    @NotBlank(message = "Profissão é obrigatória")
    private String profissao;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @NotBlank(message = "Senha é obrigatória")
    @Size(min = 6, message = "Senha deve ter pelo menos 6 caracteres")
    private String senha;


    public UsuarioRequestDTO(String nome, Integer idade, String profissao, String email, String senha) {
        this.nome = nome;
        this.idade = idade;
        this.profissao = profissao;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
