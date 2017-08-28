package com.ufcg.si1.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


import java.util.ArrayList;
import java.util.List;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = PostoSaude.class, name = "posto")
})
public abstract class UnidadeSaude {
    private int codigo;

    private String bairro;

    private List<Especialidade> especialidades = new ArrayList();

    private List idsDeQueixas = new ArrayList();
    int contador = 0;

    public UnidadeSaude(String bairro) {
        this.bairro = bairro;        
	}

  
	public UnidadeSaude(){
    }

    public void addQueixaProxima(long id) {
        idsDeQueixas.add(id);
    }

    public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
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

    public void mudaCodigo(int l) {
        this.codigo = l;
    }
    
    public abstract int getNumeroFuncionarios();
    
    public abstract float atendimentosDiarios();
    
    @Override
  	public int hashCode() {
  		final int prime = 31;
  		int result = 1;
  		result = prime * result + contador;
  		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
  		result = prime * result + ((especialidades == null) ? 0 : especialidades.hashCode());
  		result = prime * result + ((idsDeQueixas == null) ? 0 : idsDeQueixas.hashCode());
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
  		if (bairro == null) {
  			if (other.bairro != null)
  				return false;
  		} else if (!bairro.equals(other.bairro))
  			return false;
  		if (especialidades == null) {
  			if (other.especialidades != null)
  				return false;
  		} else if (!especialidades.equals(other.especialidades))
  			return false;
  		if (idsDeQueixas == null) {
  			if (other.idsDeQueixas != null)
  				return false;
  		} else if (!idsDeQueixas.equals(other.idsDeQueixas))
  			return false;
  		return true;
  	}
    

    
}
