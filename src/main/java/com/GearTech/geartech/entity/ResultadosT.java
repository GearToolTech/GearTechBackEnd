package com.GearTech.geartech.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "resultado_transmissoes")
public class ResultadosT {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private float iTotal;
	private float iIndividuais;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Aluno aluno;

	public ResultadosT() {
	}

	public ResultadosT(Long id, float iTotal, float iIndividuais, Aluno aluno) {
		super();
		this.id = id;
		this.iTotal = iTotal;
		this.iIndividuais = iIndividuais;
		this.aluno = aluno;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getiTotal() {
		return iTotal;
	}

	public void setiTotal(float iTotal) {
		this.iTotal = iTotal;
	}

	public float getiIndividuais() {
		return iIndividuais;
	}

	public void setiIndividuais(float iIndividuais) {
		this.iIndividuais = iIndividuais;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ResultadosT that = (ResultadosT) o;
		return Float.compare(iTotal, that.iTotal) == 0 && Float.compare(iIndividuais, that.iIndividuais) == 0 && Objects.equals(id, that.id) && Objects.equals(aluno, that.aluno);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, iTotal, iIndividuais, aluno);
	}

	@Override
	public String toString() {
		return "ResultadosT{" +
				"id=" + id +
				", iTotal=" + iTotal +
				", iIndividuais=" + iIndividuais +
				", aluno=" + aluno.getNome() +
				'}';
	}
}
