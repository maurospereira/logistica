package com.best2bee.logistica.api.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.best2bee.logistica.api.model.Adress;
import com.best2bee.logistica.api.model.Company;
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
	public void deleteCompany(String cnpj) throws Exception {
		companyRepository.deleteByCnpj(cnpj);
	}

	@Transactional
	public void deletePackageByIdAndCnpj(Long packageNumber, String cnpj) {
		packRepository.deleteByIdAndCompanyCnpj(packageNumber, cnpj);
	}

	@Transactional
	public void updateCompany(String cnpj, CompanyDTO companyDTO) {
		Optional<Company> companyOpt = companyRepository.findByCnpj(cnpj);

		if (companyOpt.isPresent()) {
			Company company = companyOpt.get();

			// TODO put nome fantasia?
			if (companyDTO.getTradingName() != null) {
				String tradingName = companyDTO.getTradingName();
				company.setTradingName(tradingName);
			}

			if (companyDTO.getCompanyName() != null) {
				String companyName = companyDTO.getCompanyName();
				company.setCompanyName(companyName);
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
}
