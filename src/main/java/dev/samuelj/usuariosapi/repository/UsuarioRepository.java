package dev.samuelj.usuariosapi.repository;

import dev.samuelj.usuariosapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    boolean existsByEmail(String email);
}

