package com.ufcg.si1.controller;


import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import com.ufcg.si1.model.*;
import com.ufcg.si1.service.*;
import com.ufcg.si1.util.*;


import exceptions.ObjetoJaExistenteException;
import exceptions.Rep;

@RestController
@RequestMapping("/unidadeSaude")
@CrossOrigin
public class RestUnidadeController {
	
	 QueixaService queixaService = new QueixaServiceImpl();
	 UnidadeSaudeService unidadeSaudeService = new UnidadeSaudeServiceImpl();
	 
	
    @RequestMapping(value = "/incluirUnidade/", method = RequestMethod.POST)
    public ResponseEntity<UnidadeSaude> incluirUnidadeSaude(@RequestBody UnidadeSaude us, UriComponentsBuilder ucBuilder) {

        try {
            unidadeSaudeService.insere(us);
        } catch (Rep e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (ObjetoJaExistenteException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        return new ResponseEntity<UnidadeSaude>(us, HttpStatus.CREATED);
    }    

    @RequestMapping(value = "/consultaUnidadeID/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> consultarUnidadeSaude(@PathVariable("id") int id) {

        UnidadeSaude unidadeSaudeEncontradaId = unidadeSaudeService.findById(id);
        if (unidadeSaudeEncontradaId == null) {
            return new ResponseEntity<>(new CustomErrorType("Unidade with id " + id
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(unidadeSaudeEncontradaId, HttpStatus.OK);
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
    public ResponseEntity<?> calcularMediaMedicoPacienteDia(@PathVariable("id") int id) {

        UnidadeSaude unidadeSaudeEncontradaName = unidadeSaudeService.findById(id);

        if(unidadeSaudeEncontradaName == null){
            return new ResponseEntity<ObjWrapper<Double>>(HttpStatus.NOT_FOUND);
        }

        double calculo = 0.0;
        
        calculo = unidadeSaudeEncontradaName.getNumeroFuncionarios() / unidadeSaudeEncontradaName.atendimentosDiarios();
        
        return new ResponseEntity<ObjWrapper<Double>>(new ObjWrapper<Double>(new Double(calculo)), HttpStatus.OK);
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
