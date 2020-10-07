package com.best2bee.logistica.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.best2bee.logistica.api.model.Company;



public interface  CompanyRepository extends JpaRepository<Company,Long> {
	public Optional<Company> findByCnpj(String cnpj);

}
