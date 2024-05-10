package com.GearTech.geartech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.GearTech.geartech.entity.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    @Query("SELECT a FROM Professor a WHERE a.nome LIKE :nome%")
    Iterable<Professor> findByNome(String nome);
    
    Professor findByNif(Long nif);
}
