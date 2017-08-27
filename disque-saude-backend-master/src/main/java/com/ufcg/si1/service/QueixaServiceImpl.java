package com.ufcg.si1.service;

import com.ufcg.si1.model.Queixa;
import com.ufcg.si1.model.QueixaAnimal;
import com.ufcg.si1.repository.QueixaRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("queixaService")
public class QueixaServiceImpl implements QueixaService {
	
	@Autowired
	QueixaRepository queixaRep;

	@Override
	public List<Queixa> findAllQueixas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveQueixa(Queixa queixa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveQueixa(QueixaAnimal queixa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Queixa findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateQueixa(Queixa user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteQueixaById(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Queixa findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fecharQueixa(Queixa queixa) {
		// TODO Auto-generated method stub
		
	}



}
