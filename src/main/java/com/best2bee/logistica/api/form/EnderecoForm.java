package com.best2bee.logistica.api.form;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EnderecoForm {

	@JsonProperty("cep")
	String cep;
	
	@JsonProperty("logradouro")
	String rua;
	
	@JsonProperty("bairro")
	String bairro;
	
	@JsonProperty("localidade")
	String cidade;
	
	@JsonProperty("uf")
	String uf;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua(){
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
	
}
