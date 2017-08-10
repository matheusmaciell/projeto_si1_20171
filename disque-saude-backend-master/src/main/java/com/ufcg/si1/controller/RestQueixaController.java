package com.ufcg.si1.controller;

import com.ufcg.si1.enuns.SituacaoQueixa;
import com.ufcg.si1.model.*;
import com.ufcg.si1.service.*;
import com.ufcg.si1.util.CustomErrorType;

import exceptions.ObjetoInvalidoException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/queixa")
@CrossOrigin
public class RestQueixaController {

	QueixaService queixaService = new QueixaServiceImpl();

	// -------------------Retrieve All
	// Complaints---------------------------------------------

	@RequestMapping(value = "/listarQueixa/", method = RequestMethod.GET)
	public ResponseEntity<List<Queixa>> listAllUsers() {
		List<Queixa> queixas = queixaService.findAllQueixas();

		if (queixas.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Queixa>>(queixas, HttpStatus.OK);
	}

	// -------------------Abrir uma
	// Queixa-------------------------------------------

	@RequestMapping(value = "/abrirQueixa/", method = RequestMethod.POST)
	public ResponseEntity<?> abrirQueixa(@RequestBody Queixa queixa, UriComponentsBuilder ucBuilder) {

		// este codigo estava aqui, mas nao precisa mais
		/*
		 * if (queixaService.doesQueixaExist(queixa)) { return new
		 * ResponseEntity(new CustomErrorType("Esta queixa já existe+
		 * queixa.pegaDescricao()),HttpStatus.CONFLICT); }
		 */

		try {
			queixa.abrir();
		} catch (ObjetoInvalidoException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		
		try {
			queixaService.saveQueixa(queixa);
		} catch (QueixaVaziaException e) {    // ver se este try catch esta correto
			e.printStackTrace();
		}

		// HttpHeaders headers = new HttpHeaders();
		// headers.setLocation(ucBuilder.path("/api/queixa/{id}").buildAndExpand(queixa.getId()).toUri());

		return new ResponseEntity<Queixa>(queixa, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/consultarQueixaID/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> consultarQueixaID(@PathVariable("id") long id) {

		Queixa q = queixaService.findById(id);
		if (q == null) {
			return new ResponseEntity<>(new CustomErrorType("Queixa with id " + id + " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Queixa>(q, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/consultarQueixaNome/{nome}", method = RequestMethod.GET)
	public ResponseEntity<?> consultarQueixaNome(@PathVariable("nome") String nome) {

		Queixa q = queixaService.findByName(nome);
		if (q == null) {
			return new ResponseEntity<>(new CustomErrorType("Queixa with nome " + nome + " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Queixa>(q, HttpStatus.OK);
	}

	@RequestMapping(value = "/updateQueixaID/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateQueixa(@PathVariable("id") long id, @RequestBody Queixa queixa) {

		Queixa currentQueixa = queixaService.findById(id);

		if (currentQueixa == null) {
			return new ResponseEntity<>(new CustomErrorType("Unable to upate. Queixa with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		currentQueixa.setDescricao(queixa.getDescricao());
		currentQueixa.setComentario(queixa.getComentario());

		queixaService.updateQueixa(currentQueixa);
		return new ResponseEntity<Queixa>(currentQueixa, HttpStatus.OK);
	}

	@RequestMapping(value = "/deletarQueixaID/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {

		Queixa user = queixaService.findById(id);
		if (user == null) {
			return new ResponseEntity<>(new CustomErrorType("Unable to delete. Queixa with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		queixaService.deleteQueixaById(id);
		return new ResponseEntity<Queixa>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/fecharQueixa/", method = RequestMethod.POST)
	public ResponseEntity<?> fecharQueixa(@RequestBody Queixa queixaAFechar) {
		queixaAFechar.situacao = SituacaoQueixa.FECHADA;
		queixaService.updateQueixa(queixaAFechar);
		return new ResponseEntity<Queixa>(queixaAFechar, HttpStatus.OK);
	}
}
