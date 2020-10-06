package com.best2bee.logistica.api.controller;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.best2bee.logistica.api.Form.EmpresaForm;
import com.best2bee.logistica.api.service.EmpresaService;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {
	
	@Autowired
	EmpresaService empresaService;
	
		
	@PutMapping(value = "/{cnpj}", produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> atualizaEmpresa(@PathVariable String cnpj, @RequestBody EmpresaForm empresa) {
		try {
			cnpj = URLDecoder.decode(cnpj, StandardCharsets.UTF_8.toString());
			
			empresaService.atualizaEmpresa(cnpj, empresa);
			
			return new ResponseEntity<String>("Empresa de cnpj "+ cnpj + " atualizada com sucesso", HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/{cnpj}")
	public ResponseEntity<String> deletaEmpresa(@PathVariable String cnpj) {
		try {
			cnpj = URLDecoder.decode(cnpj, StandardCharsets.UTF_8.toString());
			empresaService.deletaEmpresa(cnpj);
			return new ResponseEntity<String>("Empresa de cnpj "+ cnpj + " removida com sucesso", HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/{cnpj}/pacotes/{numeroPacote}")
	public ResponseEntity<String> deletaPacotePorEmpresa(@PathVariable String cnpj, @PathVariable Integer numeroPacote) {		
		try {
			cnpj = URLDecoder.decode(cnpj, StandardCharsets.UTF_8.toString());
			empresaService.deletaPacotePorNumero(numeroPacote, cnpj);
			return new ResponseEntity<String>("Pacote "+ numeroPacote + " removido com sucesso", HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
