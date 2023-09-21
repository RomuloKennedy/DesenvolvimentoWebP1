package com.desenvolvimento.web.projeto1.controller;

import com.desenvolvimento.web.projeto1.dto.CredenciaisDTO;
import com.desenvolvimento.web.projeto1.model.Credenciais;
import com.desenvolvimento.web.projeto1.model.Usuario;
import com.desenvolvimento.web.projeto1.services.CredenciaisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/credenciais")
public class CredenciaisController {

    CredenciaisService service;

    CredenciaisController(CredenciaisService credenciais){
        this.service = credenciais;
    }

    @PostMapping
    public String create(@RequestBody CredenciaisDTO credenciaisDTO){
        try{
        Usuario u = new Usuario();
        u.setNome(credenciaisDTO.getNome());
        Credenciais c = new Credenciais();

        c.setUsuario(u);
        c.setPassword(credenciaisDTO.getPassword());
        c.setUsername(credenciaisDTO.getUsername());
        c.setRole(credenciaisDTO.getRole());
        service.create(c);
        System.out.println();
        return "Usuário Criado com Sucesso!";
        }catch (Exception e){
            return "Falha ao criar usuário: "+e;
        }
    }
}
