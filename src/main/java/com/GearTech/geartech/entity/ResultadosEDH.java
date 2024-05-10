package com.GearTech.geartech.entity;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "resultado_engrenagem_dentes_helicoidas")
public class ResultadosEDH {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	public float circuloPrimitivo1;
	public float circuloPrimitivo2;
	public float moduloNormal;
	public float passoNormal;
	public float passoHelicoidal;
	public float distanciaEntreEixos;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Aluno aluno;

	public ResultadosEDH() {
	}

	public ResultadosEDH(Long id, float circuloPrimitivo1, float circuloPrimitivo2, float moduloNormal,
			float passoNormal, float passoHelicoidal, float distanciaEntreEixos, Aluno aluno) {
		this.id = id;
		this.circuloPrimitivo1 = circuloPrimitivo1;
		this.circuloPrimitivo2 = circuloPrimitivo2;
		this.moduloNormal = moduloNormal;
		this.passoNormal = passoNormal;
		this.passoHelicoidal = passoHelicoidal;
		this.distanciaEntreEixos = distanciaEntreEixos;
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

	public float getModuloNormal() {
		return moduloNormal;
	}

	public void setModuloNormal(float moduloNormal) {
		this.moduloNormal = moduloNormal;
	}

	public float getPassoNormal() {
		return passoNormal;
	}

	public void setPassoNormal(float passoNormal) {
		this.passoNormal = passoNormal;
	}

	public float getPassoHelicoidal() {
		return passoHelicoidal;
	}

	public void setPassoHelicoidal(float passoHelicoidal) {
		this.passoHelicoidal = passoHelicoidal;
	}

	public float getDistanciaEntreEixos() {
		return distanciaEntreEixos;
	}

	public void setDistanciaEntreEixos(float distanciaEntreEixos) {
		this.distanciaEntreEixos = distanciaEntreEixos;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(aluno, circuloPrimitivo1, circuloPrimitivo2, distanciaEntreEixos, id, moduloNormal,
				passoHelicoidal, passoNormal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResultadosEDH other = (ResultadosEDH) obj;
		return Objects.equals(aluno, other.aluno)
				&& Float.floatToIntBits(circuloPrimitivo1) == Float.floatToIntBits(other.circuloPrimitivo1)
				&& Float.floatToIntBits(circuloPrimitivo2) == Float.floatToIntBits(other.circuloPrimitivo2)
				&& Float.floatToIntBits(distanciaEntreEixos) == Float.floatToIntBits(other.distanciaEntreEixos)
				&& Objects.equals(id, other.id)
				&& Float.floatToIntBits(moduloNormal) == Float.floatToIntBits(other.moduloNormal)
				&& Float.floatToIntBits(passoHelicoidal) == Float.floatToIntBits(other.passoHelicoidal)
				&& Float.floatToIntBits(passoNormal) == Float.floatToIntBits(other.passoNormal);
	}

	@Override
	public String toString() {
		return "ResultadosEDH [id=" + id + ", circuloPrimitivo1=" + circuloPrimitivo1 + ", circuloPrimitivo2="
				+ circuloPrimitivo2 + ", moduloNormal=" + moduloNormal + ", passoNormal=" + passoNormal
				+ ", passoHelicoidal=" + passoHelicoidal + ", distanciaEntreEixos=" + distanciaEntreEixos + ", aluno="
				+ aluno + "]";
	}

}
