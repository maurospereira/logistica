package com.best2bee.logistica.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.best2bee.logistica.api.model.Adress;
import com.best2bee.logistica.api.model.Company;

@Repository
public interface AdressRepository  extends JpaRepository<Adress, Integer>{

	Optional<Adress> findByCompany(Company company);

	List<Adress> getByCompany(Company company);

}
