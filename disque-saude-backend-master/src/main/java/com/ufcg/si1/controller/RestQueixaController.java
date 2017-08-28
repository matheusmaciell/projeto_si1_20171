package com.ufcg.si1.controller;

import com.ufcg.si1.model.*;
import com.ufcg.si1.model.prefeitura.*;
import com.ufcg.si1.model.situacao.Situacao;
import com.ufcg.si1.service.*;
import com.ufcg.si1.state.EstadoQueixa;
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
	AdministradorService admService = new AdministradorServiceImpl();



	
	@RequestMapping(value = "/queixasAbertas/", method = RequestMethod.GET)
 	public ResponseEntity<?> queixasAbertas() {
	
 		List<Queixa> queixas = queixaService.findAllQueixas();
 		int contAbertas = queixaService.getAbertas();
 		
 		if (queixas.isEmpty()) {
 			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
 		}
 		return new ResponseEntity<>(contAbertas, HttpStatus.OK);
 	}
 	
 	@RequestMapping(value = "/queixasFechadas/", method = RequestMethod.GET)
 	public ResponseEntity<?> queixasFechadas() {
 		
 		List<Queixa> queixas = queixaService.findAllQueixas();
 		int contFechadas = queixaService.getFechadas();
 		
 		if (queixas.isEmpty()) {
 			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
 		}
 		return new ResponseEntity<>(contFechadas, HttpStatus.OK);
 	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/situacaoPrefeitura", method = RequestMethod.POST)
 	public void setPrefeitura(@RequestBody Prefeitura newPrefeitura) {
 		this.admService.alteraPrefeitura(newPrefeitura);
  	}
	 
	/**
	 * Este metodo lista todas as queixas.
	 * @return
	 */
	@RequestMapping(value = "/listarQueixa/", method = RequestMethod.GET)
	public ResponseEntity<List<Queixa>> listAllUsers() {
		List<Queixa> queixas = queixaService.findAllQueixas();

		if (queixas.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		}
		return new ResponseEntity<List<Queixa>>(queixas, HttpStatus.OK);
	}



	/**
	 * Este metodo, inicia uma nova queixa, salvando-a posteriormente em seu devido banco de dados.
	 * @param queixa
	 * @param ucBuilder
	 * @return
	 * @throws QueixaVaziaException
	 */
	@RequestMapping(value = "/abrirQueixa/", method = RequestMethod.POST)
	public ResponseEntity<?> abrirQueixa(@RequestBody Queixa queixa, UriComponentsBuilder ucBuilder) throws QueixaVaziaException {
		try {
			queixa.abrir();
		} catch (ObjetoInvalidoException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		queixaService.saveQueixa(queixa);
		return new ResponseEntity<Queixa>(queixa, HttpStatus.CREATED);
	}

	
	/**
	 * Este metodo, consulta uma queixa, atraves de seu id, verificando seu status e sua existencia.
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/consultarQueixaID/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> consultarQueixaID(@PathVariable("id") long id) {
		Queixa queixaEncontradaId = queixaService.findById(id);
		if (queixaEncontradaId == null) {
			return new ResponseEntity<>(new CustomErrorType("Queixa with id " + id + " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Queixa>(queixaEncontradaId, HttpStatus.OK);
	}
	
	/**
	 * Este metodo, consulta uma queixa, atraves de seu nome, verificando seu status e sua existencia.
	 * @param nome
	 * @return
	 */
	@RequestMapping(value = "/consultarQueixaNome/{nome}", method = RequestMethod.GET)
	public ResponseEntity<?> consultarQueixaNome(@PathVariable("nome") String nome) {

		Queixa queixaEncontradaName = queixaService.findByName(nome);
		if (queixaEncontradaName == null) {
			return new ResponseEntity<>(new CustomErrorType("Queixa with nome " + nome + " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Queixa>(queixaEncontradaName, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/situacaoGeralQueixas/", method = RequestMethod.GET)
    public ResponseEntity<?> getSituacaoGeralQueixas() {

        Situacao situacaoAtual = this.admService.getPrefeitura().getSituacaoGeral(queixaService.numeroQueixasAbertas(), queixaService.size());

        return new ResponseEntity<>(situacaoAtual, HttpStatus.OK);
    }

	@RequestMapping(value = "/updateQueixaID/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateQueixa(@PathVariable("id") long id, @RequestBody Queixa queixa) {

		if (this.queixaService.findById(id) == null) {
			return new ResponseEntity<>(new CustomErrorType("Unable to update. Queixa with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		
		queixaService.updateQueixa(id, queixa);
		return new ResponseEntity<Queixa>(this.queixaService.findById(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/deletarQueixaID/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {

		Queixa queixaEncontradaId = queixaService.findById(id);
		if (queixaEncontradaId == null) {
			return new ResponseEntity<>(new CustomErrorType("Unable to delete. Queixa with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		queixaService.deleteQueixaById(id);
		return new ResponseEntity<Queixa>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/fecharQueixa/", method = RequestMethod.POST)
	public ResponseEntity<?> fecharQueixa(@RequestBody Queixa queixaAFechar) {
		
		try {
			queixaService.fecharQueixa(queixaAFechar);
		} catch (ObjetoInvalidoException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Queixa>(queixaAFechar, HttpStatus.OK);
	}
}
