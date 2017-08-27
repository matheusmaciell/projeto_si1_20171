package com.ufcg.si1.service;

import com.ufcg.si1.model.UnidadeSaude;
import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;
import exceptions.Rep;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("unidadeSaudeService")
public class UnidadeSaudeServiceImpl implements UnidadeSaudeService {

	@Override
	public List<UnidadeSaude> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(UnidadeSaude us) throws Rep, ObjetoJaExistenteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UnidadeSaude findById(long id) throws ObjetoInexistenteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UnidadeSaude findByBairro(String bairro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UnidadeSaude> findByEspecialidade(String especialidadeBuscada) {
		// TODO Auto-generated method stub
		return null;
	}
 
}
