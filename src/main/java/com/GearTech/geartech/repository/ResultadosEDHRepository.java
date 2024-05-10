package com.GearTech.geartech.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.GearTech.geartech.entity.ResultadosEDH;

public interface ResultadosEDHRepository extends JpaRepository<ResultadosEDH, Long> {
    @Query("SELECT a FROM ResultadosEDH a WHERE a.id =: id")
    Optional<ResultadosEDH> findById(Long id);
}
