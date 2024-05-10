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

import com.GearTech.geartech.entity.ResultadosEDH;
import com.GearTech.geartech.repository.ResultadosEDHRepository;

@RestController
@RequestMapping("/resultadoDentesHelicoidas")
public class ResultadosEDHController {

	@Autowired
	private ResultadosEDHRepository resultadosEDHRepository;
	
	@GetMapping
	public Iterable<ResultadosEDH> findIAll(){
		return resultadosEDHRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<ResultadosEDH> findById(@PathVariable Long id) {
		return resultadosEDHRepository.findById(id);
	}
	
	@PostMapping
	public ResultadosEDH createResultadosEDH(@RequestBody ResultadosEDH resultadosEDH) {
		return resultadosEDHRepository.save(resultadosEDH);
	}
	
	@PutMapping("/{id}")
	public ResultadosEDH updateResultadosEDH(@PathVariable Long id, @RequestBody ResultadosEDH resultadosEDH) {
		resultadosEDH.setId(id);
		return resultadosEDHRepository.save(resultadosEDH);
	}
	
	@DeleteMapping("{id}")
	public void deleteResultadosEDH(@PathVariable Long id) {
		resultadosEDHRepository.deleteById(id);
	}
}
