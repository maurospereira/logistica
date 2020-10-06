package com.best2bee.logistica.api.Form;

import java.time.LocalDate;

import com.best2bee.logistica.api.model.Empresa;
import com.best2bee.logistica.api.model.Endereco;
import com.best2bee.logistica.api.model.Pacote;

public class PacoteForm {

private String status;
	private LocalDate dataEntrada;
	private Integer numero;
	private String complemento;
	private String cep;

	public Pacote toPacote(Empresa empresa, Endereco endereco) {
		return new Pacote(this.status, this.dataEntrada, endereco, empresa);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
}
