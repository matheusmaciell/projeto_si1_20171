package com.ufcg.si1.service;


import java.util.Iterator;
import java.util.List;

import com.ufcg.si1.model.Queixa;

public interface QueixaService {

	List<Queixa> findAllQueixas();
	
    void saveQueixa(Queixa queixa);

	Queixa findById(long id);
	
	Queixa findByName(String name);

	void updateQueixa(Queixa user);

	void deleteQueixaById(long id);

    int size();

	Iterator<Queixa> getIterator();

	double numeroQueixasAbertas();


//	boolean isUserExist(Queixa user);
	
}
