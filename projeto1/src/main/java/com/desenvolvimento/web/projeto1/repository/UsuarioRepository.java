package com.desenvolvimento.web.projeto1.repository;

import com.desenvolvimento.web.projeto1.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

}
