package com.ufcg.si1.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.ufcg.si1.model.Administrador;
import com.ufcg.si1.model.UnidadeSaude;

@Service("AdministradorService")
public class AdministradorServiceImpl {
	
	private Map<String, Administrador> administradores;
	private Set<UnidadeSaude> unidadesSaude;
	
	public AdministradorServiceImpl() {
		this.administradores = new HashMap<>();
		this.unidadesSaude = new HashSet<>();
	}
	
	public Administrador cadastrar(Administrador adm) {
		if (administradores.containsKey(adm.getEmail())) {
			return null; 
		}
		return administradores.put(adm.getEmail(), adm);
	}
	
	public Administrador logar(String email) {
		return administradores.get(email);
	}

	public UnidadeSaude adicionaUnidade(UnidadeSaude newUnidade) {
		this.unidadesSaude.add(newUnidade);
		return newUnidade;
		
	}
	
	

}
