package br.com.cjr.apirest.model.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class DemoForm {
	
	@NotNull @NotEmpty
	private String nome;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
