package com.best2bee.logistica.api.resoucer;

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

import com.best2bee.logistica.api.model.Company;
import com.best2bee.logistica.api.model.dto.CompanyDTO;
import com.best2bee.logistica.api.service.CompanyService;


@RestController
@RequestMapping("/empresa")
public class CompanyResource {

	@Autowired
	CompanyService companyService;
	
	@PostMapping
	public ResponseEntity<Void> insertCompany(@Valid @RequestBody CompanyDTO empresa){
		companyService.insert(empresa);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}
