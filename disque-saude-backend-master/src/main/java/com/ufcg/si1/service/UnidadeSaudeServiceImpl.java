package com.ufcg.si1.service;

import com.ufcg.si1.model.UnidadeSaude;
import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;
import exceptions.Rep;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service("unidadeSaudeService")
public class UnidadeSaudeServiceImpl implements UnidadeSaudeService {
	
	private  final AtomicInteger counter = new AtomicInteger();
    private List<UnidadeSaude> unidadesDeSaude;

    public UnidadeSaudeServiceImpl() {
        unidadesDeSaude = new ArrayList<>();
    }


    @Override
    public UnidadeSaude procura(int codigo) throws Rep,
            ObjetoInexistenteException {
        for(UnidadeSaude uni : unidadesDeSaude) {
        	if(uni.pegaCodigo() == codigo)
        		return uni;
        }
        throw new ObjetoInexistenteException("Não achou unidade");
    }

    @Override
    public List<UnidadeSaude> getAll() {
        return unidadesDeSaude;
    }

    @Override
    public void insere(UnidadeSaude us) throws Rep,
            ObjetoJaExistenteException {
    	if (this.existe(us.pegaCodigo()))
    		throw new ObjetoJaExistenteException("Objeto jah existe");
    	else {
    		us.mudaCodigo(counter.incrementAndGet());
    		unidadesDeSaude.add(us);
    	}

    }

    @Override
    public boolean existe(int l) {
    	for(UnidadeSaude uni : unidadesDeSaude) {
    		if(uni.pegaCodigo() == l)
    			return true;
    	}
    	return false;
    }

    public UnidadeSaude findById(int id) {
        for(UnidadeSaude uni : unidadesDeSaude) {
        	if(uni.pegaCodigo() == id)
        		return uni;
        }
        return null;
    }

    @Override
    public UnidadeSaude findByBairro(String bairro) {
        for (UnidadeSaude esp: unidadesDeSaude) {
            if (esp.getBairro().equals(bairro)){
            	return esp;
            
            }
        }
        return null;
    }
}
