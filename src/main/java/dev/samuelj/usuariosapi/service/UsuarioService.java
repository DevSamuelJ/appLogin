package dev.samuelj.usuariosapi.service;

import dev.samuelj.usuariosapi.model.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
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

    public Usuario removerUsuario(int id){
        Usuario usuarioRem = buscaPorID(id);
        usuarios.remove(usuarioRem);
        return usuarioRem;
    }

    public Usuario buscaPorID(int id){
        Usuario usuarioBuscado = null;
        for (Usuario usuario: usuarios){
            if (usuario.getId() == id){
                usuarioBuscado = usuario;
                break;
            }
        }if (usuarioBuscado == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
        }   return usuarioBuscado;

    }

    public Usuario atualizarUsuario(int id, Usuario dadosAtualizados){
            Usuario usuarioMod = buscaPorID(id);
            usuarioMod.setNome(dadosAtualizados.getNome());
            usuarioMod.setIdade(dadosAtualizados.getIdade());
            usuarioMod.setProfissao(dadosAtualizados.getProfissao());
            return usuarioMod;
    }
}
