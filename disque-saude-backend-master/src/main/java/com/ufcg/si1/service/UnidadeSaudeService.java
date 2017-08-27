package com.ufcg.si1.service;

import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;
import exceptions.Rep;

import java.util.List;

import com.ufcg.si1.model.UnidadeSaude;


public interface UnidadeSaudeService {
	
    public List<UnidadeSaude> getAll();

    void save(UnidadeSaude us)throws Rep,ObjetoJaExistenteException;

    UnidadeSaude findById(long id) throws ObjetoInexistenteException;

    public UnidadeSaude findByBairro(String bairro);
    
    List<UnidadeSaude> findByEspecialidade(String especialidadeBuscada);
    
}
