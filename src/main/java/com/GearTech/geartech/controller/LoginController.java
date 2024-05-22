package com.GearTech.geartech.controller;

import com.GearTech.geartech.config.security.TokenService;
import com.GearTech.geartech.dto.LoginRequestAlunoDTO;
import com.GearTech.geartech.dto.RegisterRequestAlunoDTO;
import com.GearTech.geartech.dto.ResponseDTO;
import com.GearTech.geartech.entity.Aluno;
import com.GearTech.geartech.repository.AlunoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class LoginController {

    private final AlunoRepository alunoRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    public LoginController(AlunoRepository alunoRepository, PasswordEncoder passwordEncoder, TokenService tokenService) {
        this.alunoRepository = alunoRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

    @PostMapping("/loginAluno")
    public ResponseEntity login(@RequestBody LoginRequestAlunoDTO body) {
        Aluno aluno = this.alunoRepository.findByNumMatricula(body.numMatricula()).orElseThrow(() -> new RuntimeException("User not found"));
        if (passwordEncoder.matches(body.senha(), aluno.getSenha())) {
            String token = this.tokenService.generateToken(aluno);
            return ResponseEntity.ok(new ResponseDTO(aluno.getNome(), token));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/registerAluno")
    public ResponseEntity register(@RequestBody RegisterRequestAlunoDTO body) {
        Optional<Aluno> aluno = this.alunoRepository.findByNumMatricula(body.numMatricula());
        if (aluno.isEmpty()) {
            Aluno newAluno = new Aluno();
            newAluno.setSenha(passwordEncoder.encode(body.senha()));
            newAluno.setNome(body.nome());
            newAluno.setEmail(body.email());
            newAluno.setTurma(body.turma());
            newAluno.setNumMatricula(body.numMatricula());
            this.alunoRepository.save(newAluno);
            String token = this.tokenService.generateToken(newAluno);
            return ResponseEntity.ok(new ResponseDTO(newAluno.getNome(), token));

        }
        return ResponseEntity.badRequest().build();
    }
}