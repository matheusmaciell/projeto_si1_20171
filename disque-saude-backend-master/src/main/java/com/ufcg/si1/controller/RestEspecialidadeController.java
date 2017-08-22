package com.ufcg.si1.controller;


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
	 UnidadeSaudeService unidadeSaudeService = new UnidadeSaudeServiceImpl();
	 EspecialidadeService especialidadeService = new EspecialidadeServiceImpl();
	 QueixaService queixaService = new QueixaServiceImpl();
	 
	@RequestMapping(value = "/porUnidadeSaude/", method = RequestMethod.GET)
    public ResponseEntity<?> consultaEspecialidadeporUnidadeSaude(@RequestBody int codigoUnidadeSaude) {

        UnidadeSaude us = null;
        try {
            us = unidadeSaudeService.procura(codigoUnidadeSaude);
        } catch (Rep e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (ObjetoInexistenteException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (us != null){
            return new ResponseEntity<>(us.getEspecialidades(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/incluirEspecialidade/", method = RequestMethod.POST)
    public ResponseEntity<String> incluirEspecialidade(@RequestBody Especialidade esp, UriComponentsBuilder ucBuilder) {
        try {
            especialidadeService.insere(esp);
        } catch (Rep e) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        } catch (ObjetoJaExistenteException e) {
            return new ResponseEntity<String>(HttpStatus.CONFLICT);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/especialidade/{id}").buildAndExpand(esp.getCodigo()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/consultaEspecialidadeID/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> consultarEspecialidade(@PathVariable("id") long id) {

        Especialidade q = especialidadeService.findById(id);
        if (q == null) {
            return new ResponseEntity<>(new CustomErrorType("Especialidade with id " + id
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Especialidade>(q, HttpStatus.OK);
    }
    
  
}
