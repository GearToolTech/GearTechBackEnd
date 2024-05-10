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
@Table(name = "resultado_engrenagem_dentes_conicos")
public class ResultadosEDC {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	public float circuloPrimitivo1;
	public float circuloPrimitivo2;
	public float anguloConeCabe1;
	public float anguloConeCabe2;
	public float anguloPrimitivo1;
	public float anguloPrimitivo2;
	public float anguloEixos;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Aluno aluno;

	public ResultadosEDC() {
	}

	public ResultadosEDC(Long id, float circuloPrimitivo1, float circuloPrimitivo2, float anguloConeCabe1,
			float anguloConeCabe2, float anguloPrimitivo1, float anguloPrimitivo2, float anguloEixos, Aluno aluno) {
		this.id = id;
		this.circuloPrimitivo1 = circuloPrimitivo1;
		this.circuloPrimitivo2 = circuloPrimitivo2;
		this.anguloConeCabe1 = anguloConeCabe1;
		this.anguloConeCabe2 = anguloConeCabe2;
		this.anguloPrimitivo1 = anguloPrimitivo1;
		this.anguloPrimitivo2 = anguloPrimitivo2;
		this.anguloEixos = anguloEixos;
		this.aluno = aluno;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getCirculoPrimitivo1() {
		return circuloPrimitivo1;
	}

	public void setCirculoPrimitivo1(float circuloPrimitivo1) {
		this.circuloPrimitivo1 = circuloPrimitivo1;
	}

	public float getCirculoPrimitivo2() {
		return circuloPrimitivo2;
	}

	public void setCirculoPrimitivo2(float circuloPrimitivo2) {
		this.circuloPrimitivo2 = circuloPrimitivo2;
	}

	public float getAnguloConeCabe1() {
		return anguloConeCabe1;
	}

	public void setAnguloConeCabe1(float anguloConeCabe1) {
		this.anguloConeCabe1 = anguloConeCabe1;
	}

	public float getAnguloConeCabe2() {
		return anguloConeCabe2;
	}

	public void setAnguloConeCabe2(float anguloConeCabe2) {
		this.anguloConeCabe2 = anguloConeCabe2;
	}

	public float getAnguloPrimitivo1() {
		return anguloPrimitivo1;
	}

	public void setAnguloPrimitivo1(float anguloPrimitivo1) {
		this.anguloPrimitivo1 = anguloPrimitivo1;
	}

	public float getAnguloPrimitivo2() {
		return anguloPrimitivo2;
	}

	public void setAnguloPrimitivo2(float anguloPrimitivo2) {
		this.anguloPrimitivo2 = anguloPrimitivo2;
	}

	public float getAnguloEixos() {
		return anguloEixos;
	}

	public void setAnguloEixos(float anguloEixos) {
		this.anguloEixos = anguloEixos;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	@Override
	public int hashCode() {
		return Objects.hash(aluno, anguloConeCabe1, anguloConeCabe2, anguloEixos, anguloPrimitivo1, anguloPrimitivo2,
				circuloPrimitivo1, circuloPrimitivo2, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResultadosEDC other = (ResultadosEDC) obj;
		return Objects.equals(aluno, other.aluno)
				&& Float.floatToIntBits(anguloConeCabe1) == Float.floatToIntBits(other.anguloConeCabe1)
				&& Float.floatToIntBits(anguloConeCabe2) == Float.floatToIntBits(other.anguloConeCabe2)
				&& Float.floatToIntBits(anguloEixos) == Float.floatToIntBits(other.anguloEixos)
				&& Float.floatToIntBits(anguloPrimitivo1) == Float.floatToIntBits(other.anguloPrimitivo1)
				&& Float.floatToIntBits(anguloPrimitivo2) == Float.floatToIntBits(other.anguloPrimitivo2)
				&& Float.floatToIntBits(circuloPrimitivo1) == Float.floatToIntBits(other.circuloPrimitivo1)
				&& Float.floatToIntBits(circuloPrimitivo2) == Float.floatToIntBits(other.circuloPrimitivo2)
				&& Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "ResultadosEDC [id=" + id + ", circuloPrimitivo1=" + circuloPrimitivo1 + ", circuloPrimitivo2="
				+ circuloPrimitivo2 + ", anguloConeCabe1=" + anguloConeCabe1 + ", anguloConeCabe2=" + anguloConeCabe2
				+ ", anguloPrimitivo1=" + anguloPrimitivo1 + ", anguloPrimitivo2=" + anguloPrimitivo2 + ", anguloEixos="
				+ anguloEixos + ", aluno=" + aluno + "]";
	}

}
