package com.desenvolvimento.web.projeto1.services;

import com.desenvolvimento.web.projeto1.model.Credenciais;
import com.desenvolvimento.web.projeto1.model.PessoaFisica;
import com.desenvolvimento.web.projeto1.repository.PessoaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaFisicaService {

     BCryptPasswordEncoder encoder;
     @Autowired
     PessoaFisicaRepository repository;

     PessoaFisicaService(BCryptPasswordEncoder encoder){
         this.encoder = encoder;
     }

    public PessoaFisica create(PessoaFisica p){
        p.setNome(encoder.encode(p.getNome()));
        p.setSobrenome(encoder.encode(p.getNome()));
        p.setEndereco(encoder.encode(p.getEndereco()));
        p.setCpf(encoder.encode(p.getCpf()));
        return repository.save(p);
    }
    public List<PessoaFisica> getPessoas(){

     return repository.findAll();
    }
}
