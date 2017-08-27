package com.ufcg.si1.service;

import com.ufcg.si1.model.Especialidade;
import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;
import exceptions.Rep;

import java.util.Collection;
import java.util.List;


public interface EspecialidadeService {
	
    public Especialidade procuraEspecialidade(long id) throws Rep,ObjetoInexistenteException;

    public List<Especialidade> getListaEspecialidades(Long unidadadeSaudeId);

    public void save(Especialidade esp) throws ObjetoJaExistenteException;
    
    public Collection<Especialidade> getTodasEspecialidades();
    
    public List<Long> getUnidadesPorEspecialidade(String descricao) throws ObjetoInexistenteException;

}



