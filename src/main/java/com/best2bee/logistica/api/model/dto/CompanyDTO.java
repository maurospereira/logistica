package com.best2bee.logistica.api.model.dto;

import javax.validation.constraints.NotNull;

public class CompanyDTO {
	
	@NotNull
	private String cnpj;
	
	@NotNull
	private String tradingName;
	
	@NotNull
	private String companyName;
	
	@NotNull
	private String zip;
	
	@NotNull
	private Integer number;
	
	private String addOn;
	
	public CompanyDTO() {}

	public CompanyDTO(@NotNull String cnpj, @NotNull String tradingName, @NotNull String companyName,
			@NotNull String zip, @NotNull Integer number, String addOn) {
		this.cnpj = cnpj;
		this.tradingName = tradingName;
		this.companyName = companyName;
		this.zip = zip;
		this.number = number;
		this.addOn = addOn;
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

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getAddOn() {
		return addOn;
	}

	public void setAddOn(String addOn) {
		this.addOn = addOn;
	}
	
	
}
