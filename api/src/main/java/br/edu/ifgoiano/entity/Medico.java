package br.edu.ifgoiano.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.edu.ifgoiano.enumerator.TipoEspecialidade;

@Entity
@Table
public class Medico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nome;
	@Column
	private String email;
	@Column
	private String crm;
	
	@Enumerated
	private TipoEspecialidade especialidade;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(columnDefinition = "endereco_id", referencedColumnName = "id")
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
