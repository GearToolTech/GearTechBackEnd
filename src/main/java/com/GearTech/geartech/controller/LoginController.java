package com.GearTech.geartech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.GearTech.geartech.entity.Aluno;
import com.GearTech.geartech.repository.AlunoRepository;

@RestController
public class LoginController {

    @Autowired
    private AlunoRepository alunoRepository;

    @PostMapping("/login")
    public ResponseEntity<String> authenticate(@RequestBody LoginRequest loginRequest) {
        Aluno aluno = alunoRepository.findByNumMatricula(loginRequest.getNumMatricula());
        if (aluno != null && aluno.getSenha().equals(loginRequest.getSenha())) {
            return ResponseEntity.ok("Login bem-sucedido!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas!");
        }
    }

    static class LoginRequest {
        private Long numMatricula;
        private String senha;

        public Long getNumMatricula() {
            return numMatricula;
        }

        public void setNumMatricula(Long numMatricula) {
            this.numMatricula = numMatricula;
        }

        public String getSenha() {
            return senha;
        }

        public void setSenha(String senha) {
            this.senha = senha;
        }
    }
}
