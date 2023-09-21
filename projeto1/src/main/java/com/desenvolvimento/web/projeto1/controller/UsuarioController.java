package com.desenvolvimento.web.projeto1.controller;

import com.desenvolvimento.web.projeto1.dto.UsuarioDTO;
import com.desenvolvimento.web.projeto1.model.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
public class UsuarioController{

    @GetMapping
    public UsuarioDTO find() {
        return new UsuarioDTO(new Usuario());
    }


}
