package com.GearTech.geartech.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.GearTech.geartech.entity.ResultadosT;

public interface ResultadosTRepository extends JpaRepository<ResultadosT, Long>{
	@Query("SELECT a FROM ResultadosT a WHERE a.id = :id")
	Optional<ResultadosT> findById(Long id);
}
