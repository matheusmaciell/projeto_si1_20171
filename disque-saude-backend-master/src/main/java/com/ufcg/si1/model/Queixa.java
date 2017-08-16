package com.ufcg.si1.model;

import exceptions.QueixaStatusException;

import com.ufcg.si1.state.IQueixaState;
import com.ufcg.si1.state.QueixaAberta;

public class Queixa {

	private long id;

	private String descricao;

	private Pessoa solicitante;

	public IQueixaState estadoQueixa;
	
	private String comentario = ""; // usado na atualizacao da queixa

	public Queixa(){
		id = 0;
	}

	public Queixa(long id, String descricao, String comentario, String nome,
					String email, String rua, String uf, String cidade) {
		this.id = id;
		this.descricao = descricao;
		this.estadoQueixa = new QueixaAberta();
		this.comentario = comentario;
		this.solicitante = new Pessoa(nome, email, rua, uf, cidade);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public IQueixaState getEstado() {
		return estadoQueixa;
	}
	
	public void setEstado(IQueixaState estado) {
		this.estadoQueixa = estado;
	}
	//a queixa se abre e fecha!?

	public void abrir() throws QueixaStatusException {
		this.setEstado(this.estadoQueixa.estadoAberto());
	}

	public void fechar(String coment) throws QueixaStatusException {
		this.setEstado(estadoQueixa.estadoFechado());
		this.setComentario(coment);
	}
	
	public void andamento(String coment) throws QueixaStatusException {
		this.setEstado(estadoQueixa.estadoEmAndamento());
		this.setComentario(coment);
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Pessoa getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Pessoa solicitante) {
		this.solicitante = solicitante;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Queixa other = (Queixa) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
