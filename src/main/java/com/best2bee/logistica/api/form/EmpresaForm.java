package com.best2bee.logistica.api.form;

import javax.validation.constraints.NotNull;

public class EmpresaForm {
	
	@NotNull
	private String cnpj;
	
	@NotNull
	private String nomeFantasia;
	
	@NotNull
	private String razaoSocial;
	
	@NotNull
	private String cep;
	
	@NotNull
	private Integer numero;
	
	private String complemento;
	

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

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
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

	@Override
	public String toString() {
		return "EmpresaForm [cnpj=" + cnpj + ", nomeFantasia=" + nomeFantasia + ", razaoSocial=" + razaoSocial
				+ ", cep=" + cep + ", numero=" + numero + ", complemento=" + complemento + "]";
	}
	
}
