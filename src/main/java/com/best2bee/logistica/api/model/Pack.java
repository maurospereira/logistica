package com.best2bee.logistica.api.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="PACK")
public class Pack {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name="STATUS")
	private String status;
	
	@NotNull
	@Column(name="ENTRY_DATE")
	private LocalDate entryDate = LocalDate.now();
	
	@ManyToOne
	@JoinColumn(name="ID_COMPANY", referencedColumnName = "id")
	private Company company;
	
	@ManyToOne
	@JoinColumn(name="ID_ADRESS", referencedColumnName = "id")
	private Adress adress;
	
	@NotNull
	@Column(name="ACTIVE")
	private Boolean active = true;
	
	public Pack() {}

	public Pack(Long id, @NotNull String status, Company company, Adress adress) {
		this.id = id;
		this.status = status;
		this.company = company;
		this.adress = adress;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(LocalDate entryDate) {
		this.entryDate = entryDate;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	
}
