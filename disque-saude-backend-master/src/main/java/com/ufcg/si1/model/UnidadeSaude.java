package com.ufcg.si1.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.ufcg.si1.service.UnidadeSaudeService;

import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;
import exceptions.Rep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = PostoSaude.class, name = "posto")
})
public abstract class UnidadeSaude {
    private int codigo;

    private String descricao;

    private List<Especialidade> especialidades = new ArrayList();

    private long [] numeroQueixas = new long[1000];
    int contador = 0;

    public UnidadeSaude(String descricao) {
        this.codigo = 0; // gerado no repositorio
        this.descricao = descricao;
    }
    public UnidadeSaude(){
    }

    public void addQueixaProxima(long id) {
        if (this instanceof PostoSaude){
            numeroQueixas[contador++] = id;
        }
    }

    public String pegaDescricao() {
        return this.descricao;
    }

    public void mudaDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Especialidade> getEspecialidades() {
        return this.especialidades;
    }

    public void adicionarEspecialidade(Especialidade esp) {
        this.especialidades.add(esp);
    }

    public int pegaCodigo() {
        return this.codigo;
    }

    public void mudaCodigo(int cod) {
        this.codigo = cod;
    }
    
    public abstract int getNumeroFuncionarios();
    
    public abstract float atendimentosDiarios();
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + contador;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((especialidades == null) ? 0 : especialidades.hashCode());
		result = prime * result + Arrays.hashCode(numeroQueixas);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnidadeSaude other = (UnidadeSaude) obj;
		if (codigo != other.codigo)
			return false;
		if (contador != other.contador)
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (especialidades == null) {
			if (other.especialidades != null)
				return false;
		} else if (!especialidades.equals(other.especialidades))
			return false;
		if (!Arrays.equals(numeroQueixas, other.numeroQueixas))
			return false;
		return true;
	}
    
    
}
