package dev.samuelj.usuariosapi.service;

import dev.samuelj.usuariosapi.dto.UsuarioRequestDTO;
import dev.samuelj.usuariosapi.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    public String generateToken(UsuarioRequestDTO usuario) {

    }

    public boolean isTokenValid(String token) {

    }

    public String extractEmail(String token) {

    }
}
