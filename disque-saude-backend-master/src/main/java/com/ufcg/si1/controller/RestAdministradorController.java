package com.ufcg.si1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ufcg.si1.model.Administrador;
import com.ufcg.si1.service.AdministradorServiceImpl;

@RestController
@RequestMapping("/administrador")
@CrossOrigin
public class RestAdministradorController {
	
	AdministradorServiceImpl administradorService = new AdministradorServiceImpl();
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Administrador> cadastrar(@RequestBody Administrador adm) {
		Administrador admCadastrado = administradorService.cadastrar(adm);
		if (adm == null) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<>(admCadastrado, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<Administrador> logar(@RequestBody Administrador adm) {
		adm = administradorService.logar(adm);
		if (adm == null) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<>(adm, HttpStatus.OK);
	}

}
