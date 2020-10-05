package com.best2bee.logistica.api.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="PACOTE")
public class Pacote {

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@Column(name="STATUS", unique = true)
	private String status;
	
	@NotNull
	@Column(name="DATA_ENTRADA", unique=true)
	private LocalDate dataEntrada;
	
	@ManyToOne
	@JoinColumn(name="ID_EMPRESA", referencedColumnName = "id")
	private Empresa empresa;
	
	@ManyToOne
	@JoinColumn(name="ID_ENDERECO", referencedColumnName = "id")
	private Endereco endereco;
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENTE", referencedColumnName = "id")
	private Cliente cliente;
	
	public Pacote() {
	}

	public Pacote(@NotNull String status, Empresa empresa, Endereco endereco) {
		super();
		this.status = status;
		this.dataEntrada = LocalDate.now();
		this.empresa = empresa;
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	

}
