package dev.samuelj.usuariosapi.controller;

import dev.samuelj.usuariosapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import dev.samuelj.usuariosapi.model.Usuario;


@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @GetMapping("/usuarios/{id}")
    public Usuario buscarUsuarioPorId(@PathVariable int id){
       return usuarioService.buscaPorID(id);
    }

    @PostMapping("/usuarios")
    public Usuario adicionarUsuario(@RequestBody Usuario usuario) { // Sem essa anotação @RequestBody, ele n vai saber que esse usuario veio do corpo da requisição e nem converter esse json em objeto Java.
        return usuarioService.adicionarUsuario(usuario);
    }

//    @DeleteMapping("/usuarios/{id}")
//    public Usuario removerUsuario(@PathVariable int id){
//            return usuarioService.removerUsuario(id);
//    }

    @PutMapping("/usuarios/{id}")
    public Usuario modificarUsuarioInteiro(@PathVariable int id,  @RequestBody Usuario dadosAtualizados){
            return usuarioService.atualizarUsuario(id, dadosAtualizados);
    }
}