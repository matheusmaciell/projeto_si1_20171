package com.ufcg.si1.service;

import com.ufcg.si1.model.Queixa;
import com.ufcg.si1.model.QueixaAnimal;
import com.ufcg.si1.repository.QueixaRepository;

import exceptions.ObjetoInvalidoException;

import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("queixaService")
public class QueixaServiceImpl implements QueixaService {
	
		@Autowired
		QueixaRepository queixaRep;

	@Override
	public List<Queixa> findAllQueixas() {
		return this.queixaRep.findAll();
	}

	@Override
	public void saveQueixa(Queixa queixa) {
		this.queixaRep.save(queixa);
		
	}

	@Override
	public void saveQueixa(QueixaAnimal queixa) {
		this.queixaRep.save(queixa);
		
	}

	@Override
	public Queixa findById(long id) {
		return this.queixaRep.getOne(id);
	}

	@Override
	public void updateQueixa(Queixa queixa) {
		this.queixaRep.save(queixa);
	}

	@Override
	public void deleteQueixaById(long id) {
		this.queixaRep.delete(id);
	}

	@Override
	public Queixa findByName(String name) {
		List<Queixa> bancoQueixas = findAllQueixas();
		for (Queixa queixa : bancoQueixas) {
			if(queixa.getDescricao().equals(name)){
				return queixa;
			}
		}
		return null;
	}

	@Override
	public void fecharQueixa(Queixa queixa) throws ObjetoInvalidoException {
		queixa.fechar(queixa.getComentario());
	}

}
