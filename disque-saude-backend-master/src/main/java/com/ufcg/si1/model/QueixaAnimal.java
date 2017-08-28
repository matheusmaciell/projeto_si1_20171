package com.ufcg.si1.model;

import com.ufcg.si1.state.EstadoQueixa;

public class QueixaAnimal extends Queixa {
	
	private String tipoAnimal;
	
	public QueixaAnimal(int id, String descricao, EstadoQueixa estado, String comentario,String nome, String email,String rua, String uf, String cidade, String tipoAnimal) {
		super(id,descricao,estado,comentario,nome,email,rua,uf,cidade);
		this.setTipoAnimal(tipoAnimal);
	}
	
	public String getTipoAnimal() {
		return tipoAnimal;
	}

	public void setTipoAnimal(String tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}

}
