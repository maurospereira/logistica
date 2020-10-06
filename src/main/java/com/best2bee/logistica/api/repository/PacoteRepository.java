package com.best2bee.logistica.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.best2bee.logistica.api.model.Pacote;

@Repository
public interface PacoteRepository extends JpaRepository<Pacote, Long>{

	@Query("DELETE FROM Pacote p WHERE p.id = :numeroPacote AND empresa.cnpj = :cnpj")
	void deletaPacotePorId(Integer numeroPacote, String cnpj);
	
}
