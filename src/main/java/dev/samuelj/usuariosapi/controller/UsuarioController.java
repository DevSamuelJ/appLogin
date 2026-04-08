package dev.samuelj.usuariosapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import dev.samuelj.usuariosapi.model.Usuario;

@RestController
public class UsuarioController {
    private int contadorId = 1;
    private List<Usuario> usuarios = new ArrayList<>();

    @GetMapping("/usuarios")
    public List<Usuario> listarUsuarios() {
        return usuarios;
    }

    @PostMapping("/usuarios")
    public Usuario adicionarUsuario(@RequestBody Usuario usuario) { // Sem essa anotação @RequestBody, ele n vai saber que esse usuario veio do corpo da requisição e nem converter esse json em objeto Java.
        usuario.setId(contadorId++);
        usuarios.add(usuario);
        return usuario;
    }


}