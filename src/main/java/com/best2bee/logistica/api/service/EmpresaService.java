package com.best2bee.logistica.api.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.best2bee.logistica.api.Form.EmpresaForm;
import com.best2bee.logistica.api.model.Empresa;
import com.best2bee.logistica.api.model.Endereco;
import com.best2bee.logistica.api.repository.EmpresaRepository;
import com.best2bee.logistica.api.repository.EnderecoRepository;
import com.best2bee.logistica.api.repository.PacoteRepository;

@Service
public class EmpresaService {

	@Autowired
	EmpresaRepository empresaRepository;

	@Autowired
	PacoteRepository pacoteRepository;

	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	EnderecoService enderecoService;

	@Transactional
	public void deletaEmpresa(String cnpj) throws Exception {
		empresaRepository.deleteByCnpj(cnpj);
	}

	@Transactional
	public void deletaPacotePorNumero(Integer numeroPacote, String cnpj) {
		pacoteRepository.deletaPacotePorId(numeroPacote, cnpj);
	}

	@Transactional
	public void atualizaEmpresa(String cnpj, EmpresaForm formEmpresa) {
		Optional<Empresa> empresaOpt = empresaRepository.findByCnpj(cnpj);

		if (empresaOpt.isPresent()) {
			Empresa empresa = empresaOpt.get();

			// TODO put nome fantasia?
			if (formEmpresa.getNomeFantasia() != null) {
				String nomeFantasia = formEmpresa.getNomeFantasia();
				empresa.setNomeFantasia(nomeFantasia);
			}

			if (formEmpresa.getRazaoSocial() != null) {
				String razaoSocial = formEmpresa.getRazaoSocial();
				empresa.setRazaoSocial(razaoSocial);
			}

			if (formEmpresa.getCep() != null) {
//				RestTemplate restTemplate = new RestTemplate();
//				String url = "http://viacep.com.br/ws/" + formEmpresa.getCep() + "/json";
//
//				EnderecoForm enderecoForm = restTemplate.getForObject(url, EnderecoForm.class);
//
				Optional<Endereco> enderecoOpt = enderecoRepository.findByEmpresa(empresa);

				if (enderecoOpt.isPresent()) {
					Endereco endereco = enderecoOpt.get();

					if (formEmpresa.getNumero() != null) {
						endereco.setNumero(formEmpresa.getNumero());
					}

					if (formEmpresa.getComplemento() != null) {
						endereco.setComplemento(formEmpresa.getComplemento());
					}

					enderecoService.atualizar(endereco, formEmpresa.getCep());
				}
			}
		}
	}

}
