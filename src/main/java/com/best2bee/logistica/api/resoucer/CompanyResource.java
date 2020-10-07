package com.best2bee.logistica.api.resoucer;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.best2bee.logistica.api.model.dto.CompanyDTO;
import com.best2bee.logistica.api.service.CompanyService;


@RestController
public class CompanyResource {

	@Autowired
	CompanyService companyService;
	
	@PostMapping
	public ResponseEntity<Void> insertCompany(@Valid @RequestBody CompanyDTO empresa){
		companyService.insert(empresa);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}	
		
	@PutMapping(value = "/empresas/{cnpj}", produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> atualizaEmpresa(@PathVariable String cnpj, @RequestBody CompanyDTO companyDto) {
		try {
			cnpj = URLDecoder.decode(cnpj, StandardCharsets.UTF_8.toString());
			
			companyService.updateCompany(cnpj, companyDto);
			
			return new ResponseEntity<String>("Empresa de cnpj "+ cnpj + " atualizada com sucesso", HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/empresas/{cnpj}")
	public ResponseEntity<String> deletaEmpresa(@PathVariable String cnpj) {
		try {
			cnpj = URLDecoder.decode(cnpj, StandardCharsets.UTF_8.toString());
			companyService.deleteCompany(cnpj);
			return new ResponseEntity<String>("Empresa de cnpj "+ cnpj + " removida com sucesso", HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/empresas/{cnpj}/pacotes/{numeroPacote}")
	public ResponseEntity<String> deletaPacotePorEmpresa(@PathVariable String cnpj, @PathVariable Long packageNumber) {		
		try {
			cnpj = URLDecoder.decode(cnpj, StandardCharsets.UTF_8.toString());
			companyService.deletePackageByIdAndCnpj(packageNumber, cnpj);
			return new ResponseEntity<String>("Pacote "+ packageNumber + " removido com sucesso", HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
}
