package br.com.Bin;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity(name = "adverbio")   
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)  
@AttributeOverrides(value={  
        @AttributeOverride(name="id",column=@Column(columnDefinition = "id")),  
        @AttributeOverride(name="nome",column=@Column(name="nome"))  
})  

public class Adverbio extends Palavra {
	
	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	private String classificacao;
	
	

}
