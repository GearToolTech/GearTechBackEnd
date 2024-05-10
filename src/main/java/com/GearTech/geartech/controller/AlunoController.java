package com.GearTech.geartech.controller;


import com.GearTech.geartech.entity.Aluno;
import com.GearTech.geartech.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping
    public Iterable<Aluno> findAll(){
        return alunoRepository.findAll();
    }

    @GetMapping("/nome/{nome}")
    public Iterable<Aluno> findByNome(@PathVariable String nome){
        return alunoRepository.findByNome(nome);
    }
    
    @GetMapping("/{id}")
    public Aluno findById(@PathVariable Long numMatricula) {
    	return alunoRepository.findById(numMatricula).orElse(null);
    }
    
    @PostMapping
    public Aluno createAluno(@RequestBody Aluno aluno) {
    	return alunoRepository.save(aluno);
    }
    
    @PutMapping("/{id}")
    public Aluno updateAluno(@PathVariable Long numMatricula, @RequestBody Aluno aluno) {
    	aluno.setNumMatricula(numMatricula);
    	return alunoRepository.save(aluno);
    }
    
    @DeleteMapping("{id}")
    public void deleteAluno(@PathVariable Long numMatricula) {
    	alunoRepository.deleteById(numMatricula);
    }
}
