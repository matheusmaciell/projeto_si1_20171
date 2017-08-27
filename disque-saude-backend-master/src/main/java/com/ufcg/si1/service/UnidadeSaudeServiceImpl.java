package com.ufcg.si1.service;

import com.ufcg.si1.model.UnidadeSaude;
import com.ufcg.si1.repository.UnidadeSaudeRepository;

import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;
import exceptions.Rep;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("unidadeSaudeService")
public class UnidadeSaudeServiceImpl implements UnidadeSaudeService {

	private UnidadeSaudeRepository unidadeRepository;
	
	@Override
	public List<UnidadeSaude> getAll() {
		return this.unidadeRepository.findAll();
	}

	@Override
	public void save(UnidadeSaude us) throws Rep, ObjetoJaExistenteException {
		this.unidadeRepository.save(us);
		
	}

	@Override
	public UnidadeSaude findById(long id) throws ObjetoInexistenteException {
		return this.unidadeRepository.findOne(id);
	}

	@Override
	public UnidadeSaude findByBairro(String bairro) {
		for (UnidadeSaude unidade : this.unidadeRepository.findAll()) {
			if (unidade.getDescricao().equals(bairro)) {
				return unidade;
			}
		}
		return null;
	}

	@Override
	public List<UnidadeSaude> findByEspecialidade(String especialidadeBuscada) {
		// TODO Auto-generated method stub
		return null;
	}
 
}
