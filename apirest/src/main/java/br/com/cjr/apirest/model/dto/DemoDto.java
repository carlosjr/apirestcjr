package br.com.cjr.apirest.model.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import br.com.cjr.apirest.model.Demo;

public class DemoDto {

	private String nome;
	private LocalDateTime dataCriacao;
	
	
	public DemoDto(Demo demo) {
		this.nome = demo.getNome();
		this.dataCriacao = demo.getDataCriacao();
	}

	public String getNome() {
		return nome;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public static List<DemoDto> converter(List<Demo> demos) {
		return demos.stream().map(DemoDto::new).collect(Collectors.toList());
	}
	
	public static Page<DemoDto> converter(Page<Demo> demos) {
		return demos.map(DemoDto::new);
	}
}
