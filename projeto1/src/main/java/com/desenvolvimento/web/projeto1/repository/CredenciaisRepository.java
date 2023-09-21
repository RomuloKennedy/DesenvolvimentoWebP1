package com.desenvolvimento.web.projeto1.repository;

import com.desenvolvimento.web.projeto1.model.Credenciais;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CredenciaisRepository extends JpaRepository<Credenciais, String> {
    Optional<Credenciais> findByUsername(String username);
}
