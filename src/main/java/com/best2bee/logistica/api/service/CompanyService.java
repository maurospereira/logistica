package com.best2bee.logistica.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.best2bee.logistica.api.model.Company;
import com.best2bee.logistica.api.model.dto.CompanyDTO;
import com.best2bee.logistica.api.model.Adress;
import com.best2bee.logistica.api.repository.CompanyRepository;

@Service
public class CompanyService{

	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private AdressService adressService;
	
	
	public Company insert(CompanyDTO companyDTO) {
		Adress adress = adressService.insert(companyDTO.getZip(), companyDTO.getNumber(), companyDTO.getAddOn());
		Company company = new Company(companyDTO.getCnpj(), companyDTO.getTradingName(), companyDTO.getCompanyName(), adress);
		Company companySaveOnDB = companyRepository.save(company);
		return companySaveOnDB;
		
	}
}
