package com.GearTech.geartech.controller;

import java.util.Base64;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.GearTech.geartech.entity.Aluno;
import com.GearTech.geartech.repository.AlunoRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@RestController
public class LoginAlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @PostMapping("/loginAluno")
    public ResponseEntity<Object> authenticate(@RequestBody LoginRequest loginRequest) {
        Aluno aluno = alunoRepository.findByNumMatricula(loginRequest.getNumMatricula());
        if (aluno != null && aluno.getSenha().equals(loginRequest.getSenha())) {
            byte[] keyBytes = Keys.secretKeyFor(SignatureAlgorithm.HS512).getEncoded();
            String base64EncodedKey = Base64.getEncoder().encodeToString(keyBytes);

            @SuppressWarnings("deprecation")
			String token = Jwts.builder()
                    .setSubject(aluno.getNumMatricula().toString())
                    .signWith(SignatureAlgorithm.HS512, base64EncodedKey)
                    .compact();
            return ResponseEntity.ok(Collections.singletonMap("token", token));
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
