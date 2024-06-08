package com.GearTech.geartech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.GearTech.geartech.entity.ResultadosEDC;
import org.springframework.data.repository.query.Param;

public interface ResultadosEDCRepository extends JpaRepository<ResultadosEDC, Long>{
    @Query("SELECT r FROM ResultadosEDC r WHERE r.aluno.numMatricula = :numMatricula")
    List<ResultadosEDC> findByAluno(@Param("numMatricula") String numMatricula);

    @Query("SELECT r FROM ResultadosEDC r WHERE r.professor.nif = :nif")
    List<ResultadosEDC> findByProfessor(@Param("nif") String nif);
}
