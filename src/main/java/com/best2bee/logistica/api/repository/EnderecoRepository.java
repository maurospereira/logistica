package com.best2bee.logistica.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.best2bee.logistica.api.model.Empresa;
import com.best2bee.logistica.api.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

	Optional<Endereco> findByEmpresa(Empresa empresa);

}
