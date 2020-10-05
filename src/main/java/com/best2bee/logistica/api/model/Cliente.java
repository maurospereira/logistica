package com.best2bee.logistica.api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Cliente {

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@Column(name = "NOME")
	private String nome;
	
	
	@NotNull
	@Column(name = "EMAIL")
	@Pattern(regexp = "/^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\"
			+ ".[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$/")
	private String email;
	
	@NotNull
	@Column(name = "TELEFONE")
	@Pattern(regexp = "^(\\([0-9]{2}\\))\\s([9]{1})?([0-9]{4})-([0-9]{4})$")
	private String telefone;
	
	
	@ManyToOne
	@JoinColumn(name="ID_ENDERECO", referencedColumnName = "id")
	private Endereco endereco;
	
	@OneToMany(targetEntity=Pacote.class, 
	           mappedBy="cliente",
	           cascade=CascadeType.ALL, 
	           fetch = FetchType.LAZY)    
	private List<Pacote> pacote;

	public Cliente(@NotNull String nome, @NotNull String email, @NotNull String telefone, Endereco endereco) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
	}

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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
