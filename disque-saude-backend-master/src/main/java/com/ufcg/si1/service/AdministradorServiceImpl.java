package com.ufcg.si1.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcg.si1.model.Administrador;
import com.ufcg.si1.model.UnidadeSaude;
import com.ufcg.si1.repository.AdministradorRepository;

import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoInvalidoException;

@Service("AdministradorService")
public class AdministradorServiceImpl implements AdministradorService {
	
	@Autowired
	AdministradorRepository adminRep;

	@Override
	public Administrador cadastrar(Administrador adm) {
		return this.adminRep.save(adm);
	}

	@Override
	public Administrador logar(Administrador administrador) throws ObjetoInvalidoException, ObjetoInexistenteException {
		return this.logar(administrador.getEmail(), administrador.getSenha());
	}

	private Administrador logar(String login, String senha) throws ObjetoInvalidoException, ObjetoInexistenteException {
		for (Administrador administrador : this.adminRep.findAll()) {
			if (administrador.getEmail().equals(login)) {
				if (administrador.getSenha().equals(senha)) {
					return administrador;
				} else {
					throw new ObjetoInvalidoException("Senha incorreta");
				}
			}
		}
		throw new ObjetoInexistenteException("Administrador nao cadastrado");
	}
	@Override
	public UnidadeSaude adicionaUnidade(UnidadeSaude newUnidade) {
		return null;
	}
	
	
	
	
}
