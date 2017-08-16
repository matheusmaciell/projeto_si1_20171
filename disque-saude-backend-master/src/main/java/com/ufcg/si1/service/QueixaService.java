package com.ufcg.si1.service;


import java.util.Iterator;
import java.util.List;

import com.ufcg.si1.model.Queixa;

import exceptions.QueixaStatusException;

public interface QueixaService {

	List<Queixa> findAllQueixas();
	
    void saveQueixa(Queixa queixa) throws QueixaStatusException;

	Queixa findById(long id);
	
	Queixa findByName(String name);

	void updateQueixa(Queixa user);

	void deleteQueixaById(long id);

    int size();

	Iterator<Queixa> getIterator();
	
	void abrirQueixa(Queixa queixa) throws QueixaStatusException ;
	
	void fecharQueixa(Queixa queixa, String coment) throws QueixaStatusException;
	
	void andamentoQueixa(Queixa queixa, String coment) throws QueixaStatusException;


//	boolean isUserExist(Queixa user);
	
}
