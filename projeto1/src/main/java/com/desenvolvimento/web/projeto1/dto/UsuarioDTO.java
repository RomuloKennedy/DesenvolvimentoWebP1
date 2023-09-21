package com.desenvolvimento.web.projeto1.dto;

import com.desenvolvimento.web.projeto1.model.Usuario;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class UsuarioDTO {
    String nome;

    public UsuarioDTO(Usuario user){
        this.nome = user.getNome();
    }

    public static List<UsuarioDTO> converter(List<Usuario> listUsuario) {
        return listUsuario.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }
    public static UsuarioDTO converter(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO(usuario);
        return dto;
    }

}
