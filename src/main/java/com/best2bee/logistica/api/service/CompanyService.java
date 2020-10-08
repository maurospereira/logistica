package com.best2bee.logistica.api.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.best2bee.logistica.api.exceptions.CompanyNotFoundException;
import com.best2bee.logistica.api.model.Adress;
import com.best2bee.logistica.api.model.Company;
import com.best2bee.logistica.api.model.Pack;
import com.best2bee.logistica.api.model.dto.CompanyDTO;
import com.best2bee.logistica.api.repository.AdressRepository;
import com.best2bee.logistica.api.repository.CompanyRepository;
import com.best2bee.logistica.api.repository.PackRepository;

@Service
public class CompanyService{

	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private AdressService adressService;
	
	@Autowired
	private AdressRepository adressRepository;
	
	@Autowired PackRepository packRepository;
	
	public Company insert(CompanyDTO companyDTO) {
		Adress adress = adressService.insert(companyDTO.getZip(), companyDTO.getNumber(), companyDTO.getAddOn());
		Company company = new Company(companyDTO.getCnpj(), companyDTO.getTradingName(), companyDTO.getCompanyName(), adress);
		Company companySaveOnDB = companyRepository.save(company);
		return companySaveOnDB;
	}
	
	@Transactional
	public void updateCompany(String cnpj, CompanyDTO companyDTO) {
		Optional<Company> companyOpt = companyRepository.findByCnpj(cnpj);

		if (companyOpt.isPresent()) {
			Company company = companyOpt.get();

			if (companyDTO.getTradingName() != null) {
				String tradingName = companyDTO.getTradingName();
				company.setTradingName(tradingName);
			}

			if (companyDTO.getZip() != null) {
				Optional<Adress> adressOpt = adressRepository.findByCompany(company);

				if (adressOpt.isPresent()) {
					Adress adress = adressOpt.get();

					if (companyDTO.getNumber() != null) {
						adress.setNumber(companyDTO.getNumber());
					}

					if (companyDTO.getAddOn() != null) {
						adress.setAddOn(companyDTO.getAddOn());
					}

					adressService.update(adress, companyDTO.getZip());
				}
			}
		}
	}
	
	@Transactional
	public void deleteCompany(String cnpj) throws Exception {
		
		Optional<Company> companyOpt = companyRepository.findByCnpj(cnpj);
		
		if (companyOpt.isPresent()) {
			Company company = companyOpt.get();
			company.setActive(false);
			
			List<Adress> adresses = adressRepository.getByCompany(company);
			adresses.stream().forEach(adress -> {
				adress.setActive(false);
				adressRepository.save(adress);
			});
			
			List<Pack> packages = packRepository.getByCompany(company);
			packages.stream().forEach(pack -> {
				pack.setActive(false);
				packRepository.save(pack);
			});
			
			companyRepository.save(company);
		} else {
			throw new CompanyNotFoundException();
		}
	}

	@Transactional
	public void deletePackageById(Long packageNumber) {
		packRepository.deleteById(packageNumber);
	}
}
