package com.GearTech.geartech.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.GearTech.geartech.entity.ResultadosEDR;

public interface ResultadosEDRRepository extends JpaRepository<ResultadosEDR, Long>{
	@Query("SELECT a FROM ResultadosEDR a WHERE a.id = :id")
    Optional<ResultadosEDR> findById(Long id);
}
