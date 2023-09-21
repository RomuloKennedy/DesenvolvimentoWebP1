package com.desenvolvimento.web.projeto1;

import com.desenvolvimento.web.projeto1.config.RsaKeyProperties;
import com.desenvolvimento.web.projeto1.model.Credenciais;
import com.desenvolvimento.web.projeto1.model.Usuario;
import com.desenvolvimento.web.projeto1.repository.CredenciaisRepository;
import com.desenvolvimento.web.projeto1.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class Projeto1Application {

	public static void main(String[] args) {
		SpringApplication.run(Projeto1Application.class, args);
	}


}
