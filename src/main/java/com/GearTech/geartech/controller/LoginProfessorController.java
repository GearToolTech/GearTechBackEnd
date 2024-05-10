package com.GearTech.geartech.controller;

import java.util.Base64;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.GearTech.geartech.entity.Professor;
import com.GearTech.geartech.repository.ProfessorRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@RestController
public class LoginProfessorController {

	@Autowired
	private ProfessorRepository professorRepository;

	@PostMapping("loginProfessor")
	public ResponseEntity<Object> authenticate(@RequestBody LoginRequest loginRequest) {
		Professor professor = professorRepository.findByNif(loginRequest.getNif());
		if (professor != null && professor.getSenha().equals(loginRequest.getSenha())) {
			byte[] keyBytes = Keys.secretKeyFor(SignatureAlgorithm.HS512).getEncoded();
            String base64EncodedKey = Base64.getEncoder().encodeToString(keyBytes);

            @SuppressWarnings("deprecation")
			String token = Jwts.builder()
                    .setSubject(professor.getNif().toString())
                    .signWith(SignatureAlgorithm.HS512, base64EncodedKey)
                    .compact();
            return ResponseEntity.ok(Collections.singletonMap("token", token));
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas!");
		}
	}

	static class LoginRequest {
		private Long nif;
		private String senha;

		public Long getNif() {
			return nif;
		}

		public void setNif(Long nif) {
			this.nif = nif;
		}

		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
			this.senha = senha;
		}
	}
}
