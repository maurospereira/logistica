package com.best2bee.logistica.api.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AdressDTO {

	@JsonProperty("cep")
	String zip;
	
	@JsonProperty("logradouro")
	String street;
	
	@JsonProperty("bairro")
	String neighborhood;
	
	@JsonProperty("localidade")
	String city;
	
	@JsonProperty("uf")
	String state;
	
	public AdressDTO() {
	}
	
	public AdressDTO(String zip, String street, String neighborhood, String city, String state) {
		this.zip = zip;
		this.street = street;
		this.neighborhood = neighborhood;
		this.city = city;
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}	
}
