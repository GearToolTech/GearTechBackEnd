package com.GearTech.geartech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GearTech.geartech.entity.Professor;
import com.GearTech.geartech.repository.ProfessorRepository;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	@GetMapping
    public Iterable<Professor> findAll(){
        return professorRepository.findAll();
    }

    @GetMapping("/nome/{nome}")
    public Iterable<Professor> findByNome(@PathVariable String nome){
        return professorRepository.findByNome(nome);
    }
    
    @GetMapping("/{id}")
    public Professor findById(@PathVariable Long nif) {
    	return professorRepository.findById(nif).orElse(null);
    }
    
    @PostMapping
    public Professor createProfessor(@RequestBody Professor professor) {
    	return professorRepository.save(professor);
    }
    
    @PutMapping("/{id}")
    public Professor updateProfessor(@PathVariable Long nif, @RequestBody Professor professor) {
    	professor.setNif(nif);
    	return professorRepository.save(professor);
    }
    
    @DeleteMapping("{id}")
    public void deleteProfessor(@PathVariable Long nif) {
    	professorRepository.deleteById(nif);
    }
}
