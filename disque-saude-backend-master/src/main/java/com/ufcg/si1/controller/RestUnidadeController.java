package com.ufcg.si1.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import com.ufcg.si1.model.*;
import com.ufcg.si1.service.*;
import com.ufcg.si1.util.*;

import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;
import exceptions.Rep;

@RestController
@RequestMapping("/unidadeSaude")
@CrossOrigin
public class RestUnidadeController {
	

	@Autowired
	private UnidadeSaudeService unidadeSaudeService = new UnidadeSaudeServiceImpl();
	 
	//how to save a subclass object?
    @RequestMapping(value = "/incluirUnidade/", method = RequestMethod.POST)
    public ResponseEntity<UnidadeSaude> incluirUnidadeSaude(@RequestBody PostoSaude us, UriComponentsBuilder ucBuilder) {

        try {
            unidadeSaudeService.save(us);
        } catch (Rep e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (ObjetoJaExistenteException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(us, HttpStatus.CREATED);
    }    

    @RequestMapping(value = "/consultaUnidadeID/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> consultarUnidadeSaude(@PathVariable("id") long id) {
		try {
			  UnidadeSaude unidadeSaudeEncontradaId = unidadeSaudeService.findById(id);
				return new ResponseEntity<>(unidadeSaudeEncontradaId, HttpStatus.OK);
		} catch (ObjetoInexistenteException e) {
			 return new ResponseEntity<>(new CustomErrorType("Unidade with id " + id
	                    + " not found"), HttpStatus.NOT_FOUND);
		}
	
    }
    
    @RequestMapping(value = "/getUnidades/", method = RequestMethod.GET)
    public ResponseEntity<?> getAllUnidades() {
        List<UnidadeSaude> unidades = unidadeSaudeService.getAll();
        if (unidades.isEmpty()) 
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else{
            return new ResponseEntity<>(unidades, HttpStatus.OK);
        }
    }


    @RequestMapping(value = "/mediaPacienteMedicoPorDia/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> calcularMediaMedicoPacienteDia(@PathVariable("id") long id) {
    	return null;
    }

    @RequestMapping(value="/unidadesSaudeBairro/", method= RequestMethod.GET)
    public ResponseEntity<?> consultarUnidadeSaudePorBairro(@RequestParam(value = "bairro", required = true) String bairro){
         UnidadeSaude unidadeSaudeEncontradaNoBairro = unidadeSaudeService.findByBairro(bairro);
        if (unidadeSaudeEncontradaNoBairro == null && !(unidadeSaudeEncontradaNoBairro instanceof UnidadeSaude)) {
            return new ResponseEntity<>(new CustomErrorType("Unidade with bairro " + bairro
                    + " not found"), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<UnidadeSaude>((UnidadeSaude) unidadeSaudeEncontradaNoBairro, HttpStatus.OK);
    }

    
	
}
