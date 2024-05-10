package com.GearTech.geartech.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GearTech.geartech.entity.ResultadosEDR;
import com.GearTech.geartech.repository.ResultadosEDRRepository;

@RestController
@RequestMapping("/resultadoDentesRetos")
public class ResultadosEDRControler {
	
	@Autowired
	private ResultadosEDRRepository resultadosEDRRepository;
	
	@GetMapping
	public Iterable<ResultadosEDR> findIAll(){
		return resultadosEDRRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<ResultadosEDR> findById(@PathVariable Long id) {
		return resultadosEDRRepository.findById(id);
	}
	
	@PostMapping
	public ResultadosEDR createResultadosEDR(@RequestBody ResultadosEDR resultadosEDR) {
		return resultadosEDRRepository.save(resultadosEDR);
	}
	
	@PutMapping("/{id}")
	public ResultadosEDR updateResultadosEDR(@PathVariable Long id, @RequestBody ResultadosEDR resultadosEDR) {
		resultadosEDR.setId(id);
		return resultadosEDRRepository.save(resultadosEDR);
	}
	
	@DeleteMapping("{id}")
	public void deleteResultadosEDR(@PathVariable Long id) {
		resultadosEDRRepository.deleteById(id);
	}
}
