package com.ufcg.si1.service;

import com.ufcg.si1.model.Administrador;
import com.ufcg.si1.model.UnidadeSaude;

import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoInvalidoException;

public interface AdministradorService {
	
	public Administrador cadastrar(Administrador adm);
	
	public Administrador logar(Administrador adms) throws ObjetoInvalidoException, ObjetoInexistenteException ;
	
	public UnidadeSaude adicionaUnidade(UnidadeSaude newUnidade);

}
