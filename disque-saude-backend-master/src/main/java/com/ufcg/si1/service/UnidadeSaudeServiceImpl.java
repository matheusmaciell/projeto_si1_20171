package com.ufcg.si1.service;

import com.ufcg.si1.model.UnidadeSaude;
import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;
import exceptions.Rep;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("unidadeSaudeService")
public class UnidadeSaudeServiceImpl implements UnidadeSaudeService {
    private List<UnidadeSaude> array;

    private int indice;

    private int geraCodigo = 0; // para gerar codigos das queixas cadastradas

    public UnidadeSaudeServiceImpl() {
        array = new ArrayList<>();
        indice = 0;
    }


    @Override
    public UnidadeSaude procura(int codigo) throws Rep,
            ObjetoInexistenteException {
        int i = 0;
        while (i < indice) {
            
            if(array.get(i).pegaCodigo() == codigo){
                return array.get(i);
            }          
            
            i++;
        }
        throw new ObjetoInexistenteException("Não achou unidade");
    }

    @Override
    public List<UnidadeSaude> getAll() {
        return array;
    }

    @Override
    public void insere(UnidadeSaude us) throws Rep,
            ObjetoJaExistenteException {

        if (us == null) {throw new Rep("Erro!");
        } else{
        	us.mudaCodigo(++geraCodigo);
        }

        if (indice == this.array.size()) {
        	throw new Rep("Erro ao incluir no array");
        }

    	if (this.existe(us.pegaCodigo())){
    		throw new ObjetoJaExistenteException("Objeto jah existe no array");
    	}

        this.array.set(indice, us);
        indice++;
    }

    @Override
    public boolean existe(int codigo) {
        boolean existe = false;

        for (int i = 0; i < indice; i++) {
            
            if (array.get(i).pegaCodigo() == codigo){
                existe = true;
                break;    
            }
           
        }

        return existe;
    }

    public UnidadeSaude findById(long id) {
        for (UnidadeSaude esp: array) {
            if (esp != null && esp.pegaCodigo() == id){
                return esp;
            }            
        }
        return null;
    }

    @Override
    public UnidadeSaude findByBairro(String bairro) {
        for (UnidadeSaude esp: array) {
            if (esp.getBairro().equals(bairro)){
                return esp;
            }
            
        }
        return null;
    }

}
