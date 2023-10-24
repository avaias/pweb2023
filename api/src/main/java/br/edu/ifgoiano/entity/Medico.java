package br.edu.ifgoiano.entity;

import br.edu.ifgoiano.enumerator.TipoEspecialidade;

public class Medico {
	
	private Long id;
	
	private String nome;
	private String email;
	private String crm;
	
	private TipoEspecialidade especialidade;
	
	private Endereco endereco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	public TipoEspecialidade getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(TipoEspecialidade especialidade) {
		this.especialidade = especialidade;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
