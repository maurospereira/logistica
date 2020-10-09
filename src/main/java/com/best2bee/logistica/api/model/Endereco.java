package com.best2bee.logistica.api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="ENDERECO")
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name="CIDADE")
	private String cidade;
	
	@NotNull
	@Column(name="NUMERO")
	private Integer numero;
	
	@NotNull
	@Column(name="BAIRRO")
	private String bairro;
	
	@NotNull
	@Column(name="LOGRADOURO")
	private String rua;
	
	@NotNull
	@Column(name="CEP")
	@Pattern(regexp = "^[0-9]{5}\\-[0-9]{3}$")
	private String cep;
	
	@Column(name="COMPLEMENTO")
	private String complemento;
	
	@NotNull
	@Column(name="UF")
	private String uf;

	@OneToMany(targetEntity=Empresa.class, 
	           mappedBy="endereco",
	           cascade=CascadeType.ALL, 
	           fetch = FetchType.LAZY)    
	private List<Empresa> empresa;
	

	@OneToMany(targetEntity=Pacote.class, 
	           mappedBy="endereco",
	           cascade=CascadeType.ALL, 
	           fetch = FetchType.LAZY)    
	private List<Pacote> pacote;
	
	@OneToMany(targetEntity=Cliente.class, 
	           mappedBy="endereco",
	           cascade=CascadeType.ALL, 
	           fetch = FetchType.LAZY)    
	private List<Pacote> Cliente;
	
	public Endereco() {
	}

	public Endereco(@NotNull String cidade, @NotNull Integer numero, @NotNull String bairro, @NotNull String rua,
			@NotNull @Pattern(regexp = "^[0-9]{5}\\-[0-9]{3}$") String cep, String complemento, @NotNull String uf) {
		super();
		this.cidade = cidade;
		this.numero = numero;
		this.bairro = bairro;
		this.cep = cep;
		this.complemento = complemento;
		this.uf = uf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}
	
}
