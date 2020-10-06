package com.best2bee.logistica.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.best2bee.logistica.api.model.Adress;
import com.best2bee.logistica.api.model.dto.AdressDTO;
import com.best2bee.logistica.api.repository.AdressRepository;

@Service
public class AdressService {

	@Autowired
	private AdressRepository adressRepository;
	

	public Adress insert(String zip, Integer number, String addOn) {
		String fullUrl = "https://viacep.com.br/ws/" + zip + "/json";
		RestTemplate restTemplate = new RestTemplate();
		AdressDTO objectReturnedAPI =  restTemplate.getForObject(fullUrl,AdressDTO.class);
		Adress endereco = new Adress(objectReturnedAPI.getCity(), objectReturnedAPI.getStreet(), number, objectReturnedAPI.getNeighborhood(),
				 objectReturnedAPI.getZip(), addOn, objectReturnedAPI.getState());
		Adress enderecoSalvoNoDB = adressRepository.save(endereco);
		return enderecoSalvoNoDB;
	}
}
