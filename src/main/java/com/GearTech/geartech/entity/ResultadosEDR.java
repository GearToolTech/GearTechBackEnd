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
@Table(name="resultado_engrenagem_dentes_retos")
public class ResultadosEDR {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	public float circuloPrimitivo1;
	public float passo;
	public float folgaCabeca;
	public float alturaCabecaDente;
	public float alturaPeDente;
	public float alturaDente;
	public float circuloCabeca;
	public float circuloPe;
	public float distanciaEixos;
	public float circuloCabecaInterno;
	public float circuloPeInterno;
	public float circuloPrimitivo2;
	public float distanciaEixosInterno;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Aluno aluno;

	public ResultadosEDR() {
	}

	public ResultadosEDR(Long id, float circuloPrimitivo1, float passo, float folgaCabeca, float alturaCabecaDente,
			float alturaPeDente, float alturaDente, float circuloCabeca, float circuloPe, float distanciaEixos,
			float circuloCabecaInterno, float circuloPeInterno, float circuloPrimitivo2, float distanciaEixosInterno,
			Aluno aluno) {
		this.id = id;
		this.circuloPrimitivo1 = circuloPrimitivo1;
		this.passo = passo;
		this.folgaCabeca = folgaCabeca;
		this.alturaCabecaDente = alturaCabecaDente;
		this.alturaPeDente = alturaPeDente;
		this.alturaDente = alturaDente;
		this.circuloCabeca = circuloCabeca;
		this.circuloPe = circuloPe;
		this.distanciaEixos = distanciaEixos;
		this.circuloCabecaInterno = circuloCabecaInterno;
		this.circuloPeInterno = circuloPeInterno;
		this.circuloPrimitivo2 = circuloPrimitivo2;
		this.distanciaEixosInterno = distanciaEixosInterno;
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

	public float getPasso() {
		return passo;
	}

	public void setPasso(float passo) {
		this.passo = passo;
	}

	public float getFolgaCabeca() {
		return folgaCabeca;
	}

	public void setFolgaCabeca(float folgaCabeca) {
		this.folgaCabeca = folgaCabeca;
	}

	public float getAlturaCabecaDente() {
		return alturaCabecaDente;
	}

	public void setAlturaCabecaDente(float alturaCabecaDente) {
		this.alturaCabecaDente = alturaCabecaDente;
	}

	public float getAlturaPeDente() {
		return alturaPeDente;
	}

	public void setAlturaPeDente(float alturaPeDente) {
		this.alturaPeDente = alturaPeDente;
	}

	public float getAlturaDente() {
		return alturaDente;
	}

	public void setAlturaDente(float alturaDente) {
		this.alturaDente = alturaDente;
	}

	public float getCirculoCabeca() {
		return circuloCabeca;
	}

	public void setCirculoCabeca(float circuloCabeca) {
		this.circuloCabeca = circuloCabeca;
	}

	public float getCirculoPe() {
		return circuloPe;
	}

	public void setCirculoPe(float circuloPe) {
		this.circuloPe = circuloPe;
	}

	public float getDistanciaEixos() {
		return distanciaEixos;
	}

	public void setDistanciaEixos(float distanciaEixos) {
		this.distanciaEixos = distanciaEixos;
	}

	public float getCirculoCabecaInterno() {
		return circuloCabecaInterno;
	}

	public void setCirculoCabecaInterno(float circuloCabecaInterno) {
		this.circuloCabecaInterno = circuloCabecaInterno;
	}

	public float getCirculoPeInterno() {
		return circuloPeInterno;
	}

	public void setCirculoPeInterno(float circuloPeInterno) {
		this.circuloPeInterno = circuloPeInterno;
	}

	public float getCirculoPrimitivo2() {
		return circuloPrimitivo2;
	}

	public void setCirculoPrimitivo2(float circuloPrimitivo2) {
		this.circuloPrimitivo2 = circuloPrimitivo2;
	}

	public float getDistanciaEixosInterno() {
		return distanciaEixosInterno;
	}

	public void setDistanciaEixosInterno(float distanciaEixosInterno) {
		this.distanciaEixosInterno = distanciaEixosInterno;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	@Override
	public int hashCode() {
		return Objects.hash(alturaCabecaDente, alturaDente, alturaPeDente, aluno, circuloCabeca, circuloCabecaInterno,
				circuloPe, circuloPeInterno, circuloPrimitivo1, circuloPrimitivo2, distanciaEixos,
				distanciaEixosInterno, folgaCabeca, id, passo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResultadosEDR other = (ResultadosEDR) obj;
		return Float.floatToIntBits(alturaCabecaDente) == Float.floatToIntBits(other.alturaCabecaDente)
				&& Float.floatToIntBits(alturaDente) == Float.floatToIntBits(other.alturaDente)
				&& Float.floatToIntBits(alturaPeDente) == Float.floatToIntBits(other.alturaPeDente)
				&& Objects.equals(aluno, other.aluno)
				&& Float.floatToIntBits(circuloCabeca) == Float.floatToIntBits(other.circuloCabeca)
				&& Float.floatToIntBits(circuloCabecaInterno) == Float.floatToIntBits(other.circuloCabecaInterno)
				&& Float.floatToIntBits(circuloPe) == Float.floatToIntBits(other.circuloPe)
				&& Float.floatToIntBits(circuloPeInterno) == Float.floatToIntBits(other.circuloPeInterno)
				&& Float.floatToIntBits(circuloPrimitivo1) == Float.floatToIntBits(other.circuloPrimitivo1)
				&& Float.floatToIntBits(circuloPrimitivo2) == Float.floatToIntBits(other.circuloPrimitivo2)
				&& Float.floatToIntBits(distanciaEixos) == Float.floatToIntBits(other.distanciaEixos)
				&& Float.floatToIntBits(distanciaEixosInterno) == Float.floatToIntBits(other.distanciaEixosInterno)
				&& Float.floatToIntBits(folgaCabeca) == Float.floatToIntBits(other.folgaCabeca)
				&& Objects.equals(id, other.id) && Float.floatToIntBits(passo) == Float.floatToIntBits(other.passo);
	}

	@Override
	public String toString() {
		return "ResultadosEDR [id=" + id + ", circuloPrimitivo1=" + circuloPrimitivo1 + ", passo=" + passo
				+ ", folgaCabeca=" + folgaCabeca + ", alturaCabecaDente=" + alturaCabecaDente + ", alturaPeDente="
				+ alturaPeDente + ", alturaDente=" + alturaDente + ", circuloCabeca=" + circuloCabeca + ", circuloPe="
				+ circuloPe + ", distanciaEixos=" + distanciaEixos + ", circuloCabecaInterno=" + circuloCabecaInterno
				+ ", circuloPeInterno=" + circuloPeInterno + ", circuloPrimitivo2=" + circuloPrimitivo2
				+ ", distanciaEixosInterno=" + distanciaEixosInterno + ", aluno=" + aluno + "]";
	}

	
}
