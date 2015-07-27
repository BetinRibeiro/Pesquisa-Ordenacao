package br.com.Portugues.Bin;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "desempenho")
public class Desempenho {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Integer id;
	
	private Date data;
	@Column(name = "percento_acerto")
	private float percentoAcerto;
	
	private int tempo;
	
	private float eficiencia;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public float getPercentoAcerto() {
		return percentoAcerto;
	}

	public void setPercentoAcerto(float percentoAcerto) {
		this.percentoAcerto = percentoAcerto;
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	public float getEficiencia() {
		return eficiencia;
	}

	public void setEficiencia(float eficiencia) {
		this.eficiencia = eficiencia;
	}
	
	

}
