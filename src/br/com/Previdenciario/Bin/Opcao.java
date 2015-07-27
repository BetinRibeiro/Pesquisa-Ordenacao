package br.com.Previdenciario.Bin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "opcao")
public class Opcao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Integer id;
	@Column(name = "descricao",nullable=false, length=10000)
	private String descricao;
	@Column(name = "id_questao")
	private Integer idQuestao;
	private float facilidade;
	private Boolean verdadeira;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getIdQuestao() {
		return idQuestao;
	}
	public void setIdQuestao(Integer idQuestao) {
		this.idQuestao = idQuestao;
	}
	public float getFacilidade() {
		return facilidade;
	}
	public void setFacilidade(float facilidade) {
		this.facilidade = facilidade;
	}
	public Boolean getVerdadeira() {
		return verdadeira;
	}
	public void setVerdadeira(Boolean verdadeira) {
		this.verdadeira = verdadeira;
	}
	

}
