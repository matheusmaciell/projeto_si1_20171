package com.ufcg.si1.service;

import com.ufcg.si1.model.Especialidade;
import com.ufcg.si1.repository.EspecialidadeRepository;

import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;
import exceptions.Rep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service("especialidadeService")
public class EspecialidadeServiceImpl implements EspecialidadeService {

	
	@Autowired
	EspecialidadeRepository especialidadeRep;
	
	
	@Override
	public Especialidade procuraEspecialidade(long id) throws Rep, ObjetoInexistenteException {
		Especialidade espProcurada = this.especialidadeRep.findOne(id);
		
		if(espProcurada != null)
			return espProcurada;
		else
			throw new ObjetoInexistenteException("Especialidade não foi encontrada");
	}

	@Override
	public List<Especialidade> getListaEspecialidades(Long unidadadeSaudeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Especialidade esp) throws ObjetoJaExistenteException {
		if(exists(esp.getId())) {
			throw new ObjetoJaExistenteException("Objeto já foi cadastrado");
		}
		this.especialidadeRep.save(esp);
		
	}
	
	 private boolean exists(Long espId) {
	        return (this.especialidadeRep.findOne(espId) != null);
	    }

	@Override
	public Collection<Especialidade> getTodasEspecialidades() {
		return this.especialidadeRep.findAll();
	}

	@Override
	public List<Long> getUnidadesPorEspecialidade(String descricao) throws ObjetoInexistenteException {
		// TODO Auto-generated method stub
		return null;
	}

    
}
