package com.best2bee.logistica.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.best2bee.logistica.api.form.EmpresaForm;
import com.best2bee.logistica.api.model.Empresa;
import com.best2bee.logistica.api.service.EmpresaService;


@RestController
@RequestMapping("/empresa")
public class EmpresaController {

	@Autowired
	EmpresaService empresaService;
	
	@GetMapping
	public ResponseEntity<List<Empresa>> listarUsuarios(Empresa empresa) {
		return new ResponseEntity<>(empresaService.listar(empresa), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> inserirEmpresas(@Valid @RequestBody EmpresaForm empresa){
		empresaService.inserir(empresa);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}
