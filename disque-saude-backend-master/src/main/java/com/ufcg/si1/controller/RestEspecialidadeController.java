package com.ufcg.si1.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import com.ufcg.si1.model.Especialidade;
import com.ufcg.si1.model.UnidadeSaude;
import com.ufcg.si1.service.*;
import com.ufcg.si1.util.CustomErrorType;
import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;
import exceptions.Rep;

@RestController
@RequestMapping("/especialide")
@CrossOrigin
public class RestEspecialidadeController {
	
	@Autowired
	private EspecialidadeService especialidadeService = new EspecialidadeServiceImpl();

	@Autowired
	private UnidadeSaudeService unidadeSaudeService = new UnidadeSaudeServiceImpl();
	 
	 /**
	  * Metodo que busca uma especialidade medica, consultando uma unidade de saude através de seu código.
	  * @param codigoUnidadeSaude
	  * @return
	  */
	@RequestMapping(value = "/porUnidadeSaude/", method = RequestMethod.GET)
    public ResponseEntity<?> consultaEspecialidadeporUnidadeSaude(@RequestBody long unidadeSaudeid) {
		List<Especialidade> especialidades = especialidadeService.getListaEspecialidades(unidadeSaudeid);
		return new ResponseEntity<>(especialidades, HttpStatus.OK);
    }

	/**
	 * Metodo que inclui uma nova especialidade medica, ao sistema.
	 * @param esp
	 * @param ucBuilder
	 * @return
	 */
    @RequestMapping(value = "/incluirEspecialidade/", method = RequestMethod.POST)
    public ResponseEntity<String> incluirEspecialidade(@RequestBody Especialidade esp, UriComponentsBuilder ucBuilder) {
        try {
            especialidadeService.save(esp);
        } catch (ObjetoJaExistenteException e) {
            return new ResponseEntity<String>(HttpStatus.CONFLICT);
        }

        HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/especialidade/{id}").buildAndExpand(esp.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
    
    /**
     * Metodo que consulta uma especialidade medica atraves de seu id, verificando se ela ja é
     * cadastrada ou não.
     * @param id
     * @return
     */
    @RequestMapping(value = "/consultaEspecialidadeID/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> consultarEspecialidade(@PathVariable("id") long id) {

        Especialidade especialidade;
		try {
			especialidade = especialidadeService.procuraEspecialidade(id);
	        return new ResponseEntity<Especialidade>(especialidade, HttpStatus.OK);
		} catch (Rep e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		} catch (ObjetoInexistenteException e) {
			 return new ResponseEntity<>(new CustomErrorType("Especialidade with id " + id
	                    + " not found"), HttpStatus.NOT_FOUND);
		}
      
    }
    
  
}
