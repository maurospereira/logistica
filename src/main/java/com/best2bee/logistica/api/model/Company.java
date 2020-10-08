package com.best2bee.logistica.api.model;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="COMPANY")
public class Company{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name="CNPJ", unique = true)
	private String cnpj;
	
	@NotNull
	@Column(name="TRADING_NAME")
	private String tradingName;
	
	@NotNull
	@Column(name="COMPANY_NAME", unique = true)
	private String companyName;
	
	@NotNull
	@Column(name="REGISTER_DATE")
	private LocalDate registerDate = LocalDate.now();
	
	@NotNull
	@Column(name="ACTIVE")
	private Boolean active = true;
	
	@OneToMany(targetEntity=Pack.class, 
	           mappedBy="company",
	           cascade=CascadeType.ALL, 
	           fetch = FetchType.LAZY)    
	private List<Pack> pack;
	
	@ManyToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="ID_ADRESS", referencedColumnName = "id")
	private Adress adress;
	
	
	
	public Company() {}

	public Company(@NotNull String cnpj, @NotNull String tradingName, @NotNull String companyName, Adress adress) {
		this.cnpj = cnpj;
		this.tradingName = tradingName;
		this.companyName = companyName;
		this.adress = adress;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTradingName() {
		return tradingName;
	}

	public void setTradingName(String tradingName) {
		this.tradingName = tradingName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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