package com.desenvolvimento.web.projeto1.dto;

import com.desenvolvimento.web.projeto1.model.PessoaFisica;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PessoaFisicaDTO {
    String nome;

    public PessoaFisicaDTO(PessoaFisica user){
        this.nome = user.getNome();
    }

    public static List<PessoaFisicaDTO> converter(List<PessoaFisica> listPessoaFisica) {
        return listPessoaFisica.stream().map(PessoaFisicaDTO::new).collect(Collectors.toList());
    }
    public static PessoaFisicaDTO converter(PessoaFisica pessoaFisica) {
        PessoaFisicaDTO dto = new PessoaFisicaDTO(pessoaFisica);
        return dto;
    }

}
