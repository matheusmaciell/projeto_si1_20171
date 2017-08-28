package com.ufcg.si1.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ufcg.si1.model.Administrador;
import com.ufcg.si1.model.prefeitura.Prefeitura;
import com.ufcg.si1.model.prefeitura.PrefeituraNormal;

@Service("AdministradorService")
public class AdministradorServiceImpl implements AdministradorService{
	
	private Map<String, Administrador> administradores;
	private Prefeitura prefeitura;
	
	public AdministradorServiceImpl() {
		this.administradores = new HashMap<>();
		this.prefeitura = new PrefeituraNormal();
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
	
	public void alteraPrefeitura(Prefeitura newPrefeitura) {
		this.setPrefeitura(newPrefeitura);
	}

	public Prefeitura getPrefeitura() {
		return prefeitura;
	}

	public void setPrefeitura(Prefeitura prefeitura) {
		this.prefeitura = prefeitura;
	}
	
	

}
