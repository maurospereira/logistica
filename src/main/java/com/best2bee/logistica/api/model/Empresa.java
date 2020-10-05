package com.best2bee.logistica.api.model;

import java.time.LocalDate;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="EMPRESA")
public class Empresa{
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
//	@Pattern(regexp = "^[0-9]{2}\\.[0-9]{3}\\.[0-9]{3}\\/[0-9]{4}\\[-0-9]{2}$")
	@Column(name="CNPJ", unique = true)
	private String cnpj;
	
	@NotNull
	@Column(name="NOME_FANTASIA", unique = true)
	private String nomeFantasia;
	
	@NotNull
	@Column(name="RAZAO_SOCIAL")
	private String razaoSocial;
	
	@NotNull
	@Column(name="DATA_CADASTRO")
	private LocalDate dataCadastro;
	
	@OneToMany(targetEntity=Pacote.class, 
	           mappedBy="empresa",
	           cascade=CascadeType.ALL, 
	           fetch = FetchType.LAZY)    
	private List<Pacote> pacote;
	
	@ManyToOne
	@JoinColumn(name="ID_ENDERECO", referencedColumnName = "id")
	private Endereco endereco;

	public Empresa() {
	}

	public Empresa(@NotNull  @Pattern(regexp = "^[0-9]{2}\\.[0-9]{3}\\.[0-9]{3}\\/[0-9]{4}\\[-0-9]{2}$") String cnpj,
			@NotNull String nomeFantasia, @NotNull String razaoSocial, Endereco endereco) {
		this.cnpj = cnpj;
		this.nomeFantasia = nomeFantasia;
		this.razaoSocial = razaoSocial;
		this.dataCadastro = LocalDate.now();
		this.endereco = endereco;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	
}