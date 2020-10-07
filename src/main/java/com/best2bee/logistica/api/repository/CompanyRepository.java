package com.best2bee.logistica.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.best2bee.logistica.api.model.Company;

@Repository
public interface CompanyRepository  extends JpaRepository<Company, Integer>{

	void deleteByCnpj(String cnpj);

	Optional<Company> findByCnpj(String cnpj);

}
