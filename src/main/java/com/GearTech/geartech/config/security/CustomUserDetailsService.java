package com.GearTech.geartech.config.security;

import com.GearTech.geartech.entity.Aluno;
import com.GearTech.geartech.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Aluno aluno = this.alunoRepository.findByNumMatricula(Long.valueOf(username)).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new org.springframework.security.core.userdetails.User(String.valueOf(aluno.getNumMatricula()), aluno.getSenha(), new ArrayList<>());
    }
}
