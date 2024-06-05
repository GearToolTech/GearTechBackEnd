package com.GearTech.geartech.repository;

import java.util.List;
import java.util.Optional;

import com.GearTech.geartech.entity.ResultadosEDR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.GearTech.geartech.entity.ResultadosT;
import org.springframework.data.repository.query.Param;

public interface ResultadosTRepository extends JpaRepository<ResultadosT, Long>{
	@Query("SELECT r FROM ResultadosT r WHERE r.aluno.numMatricula = :numMatricula")
	List<ResultadosT> findByAlunoNumMatricula(@Param("numMatricula") String numMatricula);
}
