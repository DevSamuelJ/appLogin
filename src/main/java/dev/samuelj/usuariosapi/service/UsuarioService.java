package dev.samuelj.usuariosapi.service;

import dev.samuelj.usuariosapi.model.Usuario;
import dev.samuelj.usuariosapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;




@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

//    private int contadorId = 1; // São variáveis de estado da classe.
//    private List<Usuario> usuarios = new ArrayList<>(); // Variável de estado.

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario adicionarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario removerUsuario(int id){
        Usuario usuarioRem = buscaPorID(id);
        usuarioRepository.delete(usuarioRem);
        return usuarioRem;
    }

    public Usuario buscaPorID(int id){
            return usuarioRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
    }

    public Usuario atualizarUsuario(int id, Usuario dadosAtualizados){
            Usuario usuarioMod = buscaPorID(id);
            usuarioMod.setNome(dadosAtualizados.getNome());
            usuarioMod.setIdade(dadosAtualizados.getIdade());
            usuarioMod.setProfissao(dadosAtualizados.getProfissao());
            return usuarioMod;
    }
}
