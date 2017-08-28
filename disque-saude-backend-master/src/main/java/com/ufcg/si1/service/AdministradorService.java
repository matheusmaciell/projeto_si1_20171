package com.ufcg.si1.service;

import com.ufcg.si1.model.Administrador;
import com.ufcg.si1.model.prefeitura.Prefeitura;

public interface AdministradorService {

	public Administrador cadastrar(Administrador adm);
	
	public Administrador logar(String email);
	
	public void alteraPrefeitura(Prefeitura newPrefeitura);
	
	public Prefeitura getPrefeitura();
	
	public void setPrefeitura(Prefeitura prefeitura);

}
