package com.best2bee.logistica.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.best2bee.logistica.api.model.Company;
import com.best2bee.logistica.api.model.Pack;
import com.best2bee.logistica.api.service.CompanyService;
import com.best2bee.logistica.api.utils.Exceptions.ItemNotFoundException;






@RestController
public class CompanyResource {

	@Autowired
	private CompanyService companyService;
	
	@GetMapping("/empresas")
	public List<Company> getEmpresas(){
		return companyService.getAll();
	}
	
	@GetMapping("/empresa/{cnpj}")
	public Company getEmpresa(@PathVariable String cnpj) throws ItemNotFoundException {
		return companyService.getEmpresa(cnpj);
	}
	@GetMapping("/empresa/{cnpj}/pacotes")
	public List<Pack> getPacks(@PathVariable String cnpj) throws ItemNotFoundException {
		return companyService.getPacks(cnpj);
	}
}
