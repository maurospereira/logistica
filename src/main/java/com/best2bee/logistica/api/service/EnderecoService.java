package com.best2bee.logistica.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.best2bee.logistica.api.form.EnderecoForm;
import com.best2bee.logistica.api.model.Endereco;
import com.best2bee.logistica.api.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	

	public Endereco inserir(String cep, Integer numero, String complemento) {
		String fullUrl = "https://viacep.com.br/ws/" + cep + "/json";
		RestTemplate restTemplate = new RestTemplate();
		EnderecoForm objetoRetornadoDaApi =  restTemplate.getForObject(fullUrl,EnderecoForm.class);
		Endereco endereco = new Endereco(objetoRetornadoDaApi.getCidade(), numero, objetoRetornadoDaApi.getBairro(),
				objetoRetornadoDaApi.getRua(), objetoRetornadoDaApi.getCep(), complemento, objetoRetornadoDaApi.getUf());
		Endereco enderecoSalvoNoDB = enderecoRepository.save(endereco);
		return enderecoSalvoNoDB;
	}
}
