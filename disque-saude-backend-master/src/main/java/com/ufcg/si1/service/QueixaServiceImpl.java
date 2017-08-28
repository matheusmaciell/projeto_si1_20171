package com.ufcg.si1.service;

import com.ufcg.si1.model.Queixa;
import com.ufcg.si1.state.EstadoQueixa;

import exceptions.ObjetoInvalidoException;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


@Service("queixaService")
public class QueixaServiceImpl implements QueixaService {

    private  final AtomicLong counter = new AtomicLong();
    private List<Queixa> queixas = new ArrayList<Queixa>();
    

    public List<Queixa> findAllQueixas() {
        return queixas;
    }
    
    public int getAbertas(){
    	int contAbertas = queixas.size();
 		
    	return contAbertas;
    }
    
    public int getFechadas(){
    	int contFechadas = 0;
 		for (int i = 0; i < queixas.size(); i++) {
 			if(queixas.get(i).getEstado().equals(EstadoQueixa.FECHADA)){
 				contFechadas++;
 			}
 		}
    	return contFechadas;
    }
    
    public int size() {
    	return queixas.size();
    }

    public void saveQueixa(Queixa queixa){
    	if(queixa != null){
    		queixa.setId(counter.incrementAndGet());
    		queixas.add(queixa);    		
    	}                                                      
    }

    public void updateQueixa(long id, Queixa queixa) {
    	Queixa currentQueixa = this.findById(id);
    	currentQueixa.setDescricao(queixa.getDescricao());
		currentQueixa.setComentario(queixa.getComentario());
        int index = queixas.indexOf(queixa);
        queixas.set(index, queixa);
    }
    
    @Override
    public void fecharQueixa(Queixa queixaAFechar) throws ObjetoInvalidoException {
    	queixaAFechar.fechar(queixaAFechar.getComentario());    	
    }

    public void deleteQueixaById(long id) {
        for (Queixa queixa : queixas) {
            if (queixa.getId() == id) {
                queixas.remove(queixa);
            }
        }
    }

    @Override
    public Iterator<Queixa> getIterator() {
        return queixas.iterator();
    }

    public void deleteAllUsers() {
        queixas.clear();
    }

    public Queixa findById(long id) {
        for (Queixa queixa : queixas) {
            if (queixa.getId() == id) {
                return queixa;
            }
        }
        return null;
    }

    public Queixa findByName(String name) {
    	for(Queixa queixa : queixas) {
    		if(queixa.getSolicitante().getNome().equals(name)) {
    			return queixa;
    		}
    	}
    	return null;
    }

	@Override
	public double numeroQueixasAbertas() {
        int contador = 0;
        for (Queixa queixa: queixas) {
            if (queixa.getSituacao() == EstadoQueixa.ABERTA)
                contador++;
        }

        return (double)contador;
    }


}
