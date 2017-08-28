package com.ufcg.si1.service;


import java.util.Iterator;
import java.util.List;

import com.ufcg.si1.model.Queixa;

import exceptions.ObjetoInvalidoException;

public interface QueixaService {

	List<Queixa> findAllQueixas();
	
    void saveQueixa(Queixa queixa);

	Queixa findById(long id);
	
	Queixa findByName(String name);

	void updateQueixa(long id, Queixa user);

	void deleteQueixaById(long id);


	Iterator<Queixa> getIterator();

	double numeroQueixasAbertas();

	void fecharQueixa(Queixa queixaAFechar) throws ObjetoInvalidoException;

	int size();
	
	int getAbertas();
	
	int getFechadas();


//	boolean isUserExist(Queixa user);
	
}
