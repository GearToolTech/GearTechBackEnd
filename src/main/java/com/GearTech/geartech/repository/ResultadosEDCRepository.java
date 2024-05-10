package com.GearTech.geartech.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.GearTech.geartech.entity.ResultadosEDC;

public interface ResultadosEDCRepository extends JpaRepository<ResultadosEDC, Long>{
	@Query("SELECT a FROM ResultadosEDC a WHERE a.id = :id")
    Optional<ResultadosEDC> findById(Long id);
}
