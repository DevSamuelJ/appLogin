package dev.samuelj.usuariosapi.service;

import dev.samuelj.usuariosapi.dto.LoginRequestDTO;
import dev.samuelj.usuariosapi.dto.UsuarioRequestDTO;
import dev.samuelj.usuariosapi.dto.UsuarioResponseDTO;
import dev.samuelj.usuariosapi.model.Usuario;
import dev.samuelj.usuariosapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario adicionarUsuario(UsuarioRequestDTO usuario){
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email já cadastrado");
        }

            return usuarioRepository.save(new Usuario(
                    usuario.getNome(),
                    usuario.getIdade(),
                    usuario.getProfissao(),
                    usuario.getEmail(),
                    usuario.getSenha()
            ));
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


    public UsuarioResponseDTO login(String email, String senha) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        if (usuario.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Email não encontrado");
        }

        Usuario usuarioReal = usuario.get();
        if(!usuarioReal.getSenha().equals(senha)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Senha incorreta");
        }
            return new UsuarioResponseDTO(
                usuarioReal.getId(),
                usuarioReal.getNome(),
                usuarioReal.getEmail(),
                usuarioReal.getIdade(),
                usuarioReal.getProfissao()
        );
}
}
