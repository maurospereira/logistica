package com.best2bee.logistica.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.best2bee.logistica.api.model.Pack;

public interface PackRepository extends JpaRepository<Pack, Long> {

	public void deleteByIdAndCompanyCnpj(Long packageNumber, String cnpj);
}
