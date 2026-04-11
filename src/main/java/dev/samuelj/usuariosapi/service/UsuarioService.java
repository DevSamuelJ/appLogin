package dev.samuelj.usuariosapi.service;

import dev.samuelj.usuariosapi.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {
    private int contadorId = 1; // São variáveis de estado da classe.
    private List<Usuario> usuarios = new ArrayList<>(); // Variável de estado.

    public List<Usuario> listarUsuarios() {
        return usuarios;
    }
    public Usuario adicionarUsuario(Usuario usuario){
        usuario.setId(contadorId++);
        usuarios.add(usuario);
        return usuario;
    }
}
