package com.desenvolvimento.web.projeto1.controller;

import com.desenvolvimento.web.projeto1.dto.CredenciaisDTO;
import com.desenvolvimento.web.projeto1.model.Credenciais;
import com.desenvolvimento.web.projeto1.model.PessoaFisica;
import com.desenvolvimento.web.projeto1.services.CredenciaisService;
import com.desenvolvimento.web.projeto1.services.PessoaFisicaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CredenciaisController {

    CredenciaisService service;
    PessoaFisicaService servicePf;

    CredenciaisController(CredenciaisService credenciais, PessoaFisicaService servicePf){

        this.service = credenciais;
        this.servicePf = servicePf;
    }

    @PostMapping("/credenciais")
    public String create(@RequestBody CredenciaisDTO credenciaisDTO){
        try{
            PessoaFisica pf = new PessoaFisica();
            pf.setNome(credenciaisDTO.getNome());
            pf.setSobrenome(credenciaisDTO.getSobrenome());
            pf.setEndereco(credenciaisDTO.getEndereco());
            pf.setCpf(credenciaisDTO.getCpf());

            servicePf.create(pf);
            System.out.println(servicePf.getPessoas());
            Credenciais c = new Credenciais();

            c.setPessoaFisica(pf);
            c.setPassword(credenciaisDTO.getPassword());
            c.setUsername(credenciaisDTO.getUsername());
            c.setRole(credenciaisDTO.getRole());
            service.create(c);

        return "Usuário Criado com Sucesso!";
        }catch (Exception e){
            return "Falha ao criar usuário: "+e;
        }
    }
}
