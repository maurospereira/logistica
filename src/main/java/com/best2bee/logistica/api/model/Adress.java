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


@Entity
@Table(name="ADRESS")
public class Adress {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name="CITY")
	private String city;
	
	@NotNull
	@Column(name="STREET")
	private String street;

	@NotNull
	@Column(name="NUMBER")
	private Integer number;
	
	@NotNull
	@Column(name="NEIGHBORHOOD")
	private String neighborhood;
	
	@NotNull
	@Column(name="ZIP")
	private String zip;
	
	@Column(name="ADD_ON")
	private String addOn;
	
	@NotNull
	@Column(name="STATE")
	private String state;

	@OneToMany(targetEntity=Company.class, 
	           mappedBy="adress",
	           cascade=CascadeType.ALL, 
	           fetch = FetchType.LAZY)    
	private List<Company> company;
	
	@OneToMany(targetEntity=Pack.class, 
	           mappedBy="adress",
	           cascade=CascadeType.ALL, 
	           fetch = FetchType.LAZY)    
	private List<Pack> pack;

	public Adress(@NotNull String city, @NotNull String street, @NotNull Integer number, @NotNull String neighborhood,
			@NotNull String zip, String addOn, @NotNull String state) {
		this.city = city;
		this.street = street;
		this.number = number;
		this.neighborhood = neighborhood;
		this.zip = zip;
		this.addOn = addOn;
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getAddOn() {
		return addOn;
	}

	public void setAddOn(String addOn) {
		this.addOn = addOn;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}