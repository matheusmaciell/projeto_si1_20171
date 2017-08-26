package com.ufcg.si1.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ufcg.si1.model.Administrador;

@Service("AdministradorService")
public class AdministradorServiceImpl {
	
	private Map<String, Administrador> administradores;
	
	public AdministradorServiceImpl() {
		this.administradores = new HashMap<>();
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
	
	

}
