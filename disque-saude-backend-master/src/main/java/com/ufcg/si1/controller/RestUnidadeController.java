package com.ufcg.si1.controller;

import java.util.Iterator;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import com.ufcg.si1.model.*;
import com.ufcg.si1.service.*;
import com.ufcg.si1.state.SituacaoQueixa;
import com.ufcg.si1.util.*;


import br.edu.ufcg.Hospital;
import exceptions.ObjetoJaExistenteException;
import exceptions.Rep;

@RestController
@RequestMapping("/unidadeSaude")
@CrossOrigin
public class RestUnidadeController {
	
	 QueixaService queixaService = new QueixaServiceImpl();
	 UnidadeSaudeService unidadeSaudeService = new UnidadeSaudeServiceImpl();
	 private Prefeitura situacaoAtualPrefeitura = new PrefeituraNormal();
	 
	//how to save a subclass object?
    @RequestMapping(value = "/incluirUnidade/", method = RequestMethod.POST)
    public ResponseEntity<String> incluirUnidadeSaude(@RequestBody UnidadeSaude us, UriComponentsBuilder ucBuilder) {

        try {
            unidadeSaudeService.insere(us);
        } catch (Rep e) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        } catch (ObjetoJaExistenteException e) {
            return new ResponseEntity<String>(HttpStatus.CONFLICT);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/us/unidade/{id}").buildAndExpand(us.pegaCodigo()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }


    

    @RequestMapping(value = "/consultaUnidadeID/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> consultarUnidadeSaude(@PathVariable("id") long id) {

        Object us = unidadeSaudeService.findById(id);
        if (us == null) {
            return new ResponseEntity<>(new CustomErrorType("Unidade with id " + id
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(us, HttpStatus.OK);
    }


    @RequestMapping(value = "/mediaPacienteMedicoPorDia/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> calcularMediaMedicoPacienteDia(@PathVariable("id") long id) {

        UnidadeSaude unidade = unidadeSaudeService.findById(id);

        if(unidade == null){
            return new ResponseEntity<ObjWrapper<Double>>(HttpStatus.NOT_FOUND);
        }

        double c = 0.0;
        
        c = unidade.getNumeroFuncionarios() / unidade.atendimentosDiarios();
        
        return new ResponseEntity<ObjWrapper<Double>>(new ObjWrapper<Double>(new Double(c)), HttpStatus.OK);
    }

    @RequestMapping(value = "/situacaoGeralQueixas/", method = RequestMethod.GET)
    public ResponseEntity<?> getSituacaoGeralQueixas() {

        // dependendo da situacao da prefeitura, o criterio de avaliacao muda
        // se normal, mais de 20% abertas eh ruim, mais de 10 eh regular
        // se extra, mais de 10% abertas eh ruim, mais de 5% eh regular
        Object obj = this.situacaoAtualPrefeitura.getSituacaoGeral((double)numeroQueixasAbertas(), queixaService.size());

        //situacao retornada
        //0: RUIM
        //1: REGULAR
        //2: BOM
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @RequestMapping(value="/unidadesSaudeBairro/", method= RequestMethod.GET)
    public ResponseEntity<?> consultarUnidadeSaudePorBairro(@RequestParam(value = "bairro", required = true) String bairro){
        Object us = unidadeSaudeService.findByBairro(bairro);
        if (us == null && !(us instanceof UnidadeSaude)) {
            return new ResponseEntity<>(new CustomErrorType("Unidade with bairro " + bairro
                    + " not found"), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<UnidadeSaude>((UnidadeSaude) us, HttpStatus.OK);
    }

    private double numeroQueixasAbertas() {
        int contador = 0;
        Iterator<Queixa> it = queixaService.getIterator();
        for (Iterator<Queixa> it1 = it; it1.hasNext(); ) {
            Queixa q = it1.next();
            if (q.getSituacao() == SituacaoQueixa.ABERTA)
                contador++;
        }

        return contador;
    }
	
}
