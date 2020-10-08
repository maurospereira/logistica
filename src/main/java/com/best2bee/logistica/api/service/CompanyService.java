package com.best2bee.logistica.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.best2bee.logistica.api.model.Company;
import com.best2bee.logistica.api.model.Pack;
import com.best2bee.logistica.api.repository.CompanyRepository;
import com.best2bee.logistica.api.utils.Exceptions.ItemNotFoundException;



@Service
public class CompanyService {

	@Autowired
	private CompanyRepository empresaRepository;
	
	public List<Company> getAll(){
		List<Company> empresas= empresaRepository.findAll();
		if(empresas.isEmpty()) {
			return null;
		}
		
		return empresas;
	}
	private Company findCnpj(String cnpj) throws ItemNotFoundException {
		Optional<Company> foundEmpresa = empresaRepository.findByCnpj(cnpj);
		if(foundEmpresa.isPresent()) {
			return foundEmpresa.get();
		}else {
			throw new ItemNotFoundException(cnpj);
		}
	}
	
	
	public Company getEmpresa(String cnpj) throws ItemNotFoundException {
		return findCnpj(cnpj);
}
	public List<Pack> getPacks(String cnpj) throws ItemNotFoundException {
		
		return findCnpj(cnpj).getPack();
	}
	}
