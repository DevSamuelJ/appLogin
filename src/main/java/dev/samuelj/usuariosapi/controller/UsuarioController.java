package dev.samuelj.usuariosapi.controller;

import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import dev.samuelj.usuariosapi.model.Usuario;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class UsuarioController {
    private int contadorId = 1;
    private List<Usuario> usuarios = new ArrayList<>();

    @GetMapping("/usuarios")
    public List<Usuario> listarUsuarios() {
        return usuarios;
    }

    @GetMapping("/usuarios/{id}")
    public Usuario buscarUsuarioPorId(@PathVariable int id){
        for (Usuario usuario: usuarios){
            if(usuario.getId() == id){
                return usuario;
            }
        }
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
    }

    @PostMapping("/usuarios")
    public Usuario adicionarUsuario(@RequestBody Usuario usuario) { // Sem essa anotação @RequestBody, ele n vai saber que esse usuario veio do corpo da requisição e nem converter esse json em objeto Java.
        usuario.setId(contadorId++);
        usuarios.add(usuario);
        return usuario;
    }
    @DeleteMapping("/usuarios/{id}")
    public Usuario removerUsuario(@PathVariable int id){
        Usuario usuarioRem = null;
        for (Usuario usuario: usuarios){
            if (usuario.getId() == id){
                usuarioRem = usuario;
                break;
            }
        }if (usuarioRem == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
        }
            usuarios.remove(usuarioRem);
            return usuarioRem;

    }

    @PutMapping("/usuarios/{id}")
    public Usuario modificarUsuarioInteiro(@PathVariable int id,  @RequestBody Usuario dadosAtualizados){
        Usuario usuarioMod = null;
        for (Usuario usuario: usuarios){
            if (usuario.getId() == id){
                usuarioMod = usuario;
                break;
            }
        }if (usuarioMod == null){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
        }
            usuarioMod.setNome(dadosAtualizados.getNome());
            usuarioMod.setIdade(dadosAtualizados.getIdade());
            usuarioMod.setProfissao(dadosAtualizados.getProfissao());
            return usuarioMod;
    }




}