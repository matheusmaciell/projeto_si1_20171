package com.ufcg.si1.service;

import com.ufcg.si1.model.Especialidade;
import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;
import exceptions.Rep;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("especialidadeService")
public class EspecialidadeServiceImpl implements EspecialidadeService {

    private List<Especialidade> especialidades;

    private int geraCodigo = 0; // para gerar codigos

    public EspecialidadeServiceImpl() {
        especialidades = new ArrayList<>();
    }

    @Override
    public Especialidade procura(int codigo) throws Rep,
            ObjetoInexistenteException {
        
        for (Especialidade especialidade : especialidades) {
        	if(especialidade.getCodigo() == codigo) 
        		return especialidade;
			
		}

        throw new ObjetoInexistenteException("Erro Especialidade");
    }

    @Override
    public List getListaEspecialidade()
            throws Rep, ObjetoInexistenteException {
        return Arrays.asList(especialidades);
    }

    @Override
    public int size() {
        return this.especialidades.size();
    }

    @Override
    public void insere(Especialidade esp) throws Rep,
            ObjetoJaExistenteException {
        esp.setCodigo(++geraCodigo);
        if (this.existe(esp.getCodigo())) {
            throw new ObjetoJaExistenteException("Objeto jah existe no array");
        }
        this.especialidades.add(esp);
    }

    @Override
    public boolean existe(int codigo) {
        for (Especialidade especialidade : especialidades) {
			if (especialidade.getCodigo() == codigo) {
				return true;
			}
		}

        return false;
    }

    public Especialidade findById(long id) {
        for (Especialidade esp: especialidades) {
            if (esp.getCodigo() == id) {
                return esp;
            }
        }
        return null;
    }


}
