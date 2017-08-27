package com.ufcg.si1.service;


import java.util.Iterator;
import java.util.List;

import com.ufcg.si1.model.Queixa;
import com.ufcg.si1.model.QueixaAnimal;

import exceptions.ObjetoInvalidoException;

public interface QueixaService {

	public List<Queixa> findAllQueixas();
	
    public void saveQueixa(Queixa queixa);
    
    public void saveQueixa(QueixaAnimal queixa);

	public Queixa findById(long id);
	
	public Queixa findByName(String name);
	
	public void updateQueixa(Queixa user);

	void deleteQueixaById(long id);
	
	public void fecharQueixa(Queixa queixa);

	
}
