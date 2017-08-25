package com.ufcg.si1.service;

import java.util.HashMap;
import java.util.Map;

import com.ufcg.si1.model.Administrador;

public class AdministradorServiceImpl {
	
	private Map<String, Administrador> administradores;
	
	public AdministradorServiceImpl() {
		this.administradores = new HashMap<>();
	}
	
	public Administrador cadastrar(Administrador adm) {
		if (administradores.containsKey(adm.getEmail())) {
			return null; // lançar excessao
		}
		return administradores.put(adm.getEmail(), adm);
	}
	
	public Administrador logar(Administrador adm) {
		return logar(adm.getEmail(), adm.getSenha());
	}
	
	private Administrador logar(String email, String senha) {
		if (administradores.containsKey(email)) {
			if(administradores.get(email).getSenha().equals(senha)) {
				return administradores.get(email);
			}
		}
		
		return null; // lançar excessao
	}

}
