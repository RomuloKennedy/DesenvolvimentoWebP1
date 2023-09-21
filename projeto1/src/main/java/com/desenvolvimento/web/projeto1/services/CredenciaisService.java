package com.desenvolvimento.web.projeto1.services;

import com.desenvolvimento.web.projeto1.model.Credenciais;
import com.desenvolvimento.web.projeto1.repository.CredenciaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CredenciaisService implements UserDetailsService {

    @Autowired
    CredenciaisRepository repository;
    BCryptPasswordEncoder encoder;

    CredenciaisService(BCryptPasswordEncoder encoder){
        this.encoder = encoder;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Credenciais> credenciais = repository.findByUsername(username);
        if(credenciais.isPresent()) {
            return credenciais.get();
        }
        throw new UsernameNotFoundException("Usuário não cadastrado com Username: "+username);
    }

    public Credenciais create(Credenciais c){
        c.setPassword(encoder.encode(c.getPassword()));
        return repository.save(c);
    }
}
