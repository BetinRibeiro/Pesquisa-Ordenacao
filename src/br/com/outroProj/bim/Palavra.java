package br.com.outroProj.bim;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "palavra")
public class Palavra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	Integer id;
	@Column(name = "nome")
	String nome;
	@Column(name = "ocorrencia")
	Integer ocorrencia;
	@Column(name = "materia")
	String materia;
	@Column(name = "quant_provas")
	Integer quantProvas;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getOcorrencia() {
		return ocorrencia;
	}
	public void setOcorrencia(Integer ocorrencia) {
		this.ocorrencia = ocorrencia;
	}
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public Integer getQuantProvas() {
		return quantProvas;
	}
	public void setQuantProvas(Integer quantProvas) {
		this.quantProvas = quantProvas;
	}
	

	
	
}
