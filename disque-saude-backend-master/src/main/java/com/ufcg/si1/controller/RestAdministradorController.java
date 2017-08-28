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
	/**
	 * Este metodo guarda no banco de dados um usuario do tipo administrador.
	 * @param adm
	 * @return
	 */
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public ResponseEntity<Administrador> cadastrar(@RequestBody Administrador adm) {
	
		
		Administrador admCadastrado = administradorService.cadastrar(adm);
		if (adm == null) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<>(admCadastrado, HttpStatus.CREATED);
	}
	
	/**
	 * Este metodo permite que o usuario de conecte com o sistema, dando-lhe acesso ás suas funcionalidades.
	 * @param email
	 * @return
	 */
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<Administrador> logar(@RequestBody String email) {
		System.out.println("entrou aqui");
		Administrador adm = administradorService.logar(email);
		if (adm == null) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<>(adm, HttpStatus.OK);
	}

}
