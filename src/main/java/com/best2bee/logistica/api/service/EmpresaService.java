package com.best2bee.logistica.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.best2bee.logistica.api.form.EmpresaForm;
import com.best2bee.logistica.api.model.Empresa;
import com.best2bee.logistica.api.model.Endereco;
import com.best2bee.logistica.api.repository.EmpresaRepository;

@Service
public class EmpresaService{

	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private EnderecoService enderecoService;
	
	public List<Empresa> listar(Empresa Empresa){
		return empresaRepository.findAll();
	}
	
	public Empresa inserir(EmpresaForm empresa) {
		Endereco endereco = enderecoService.inserir(empresa.getCep(), empresa.getNumero(), empresa.getComplemento());
		Empresa empresa1 = new Empresa(empresa.getCnpj(), empresa.getNomeFantasia(), empresa.getRazaoSocial(), endereco);
		Empresa empresaSalvaNoDB = empresaRepository.save(empresa1);
		return empresaSalvaNoDB;
		
	}
}
