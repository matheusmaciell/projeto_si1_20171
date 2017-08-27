package com.ufcg.si1.model;

import exceptions.ObjetoInvalidoException;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.ufcg.si1.state.EstadoQueixa;

@Entity
public class Queixa {

	
	@Id
	@GeneratedValue
	private Long id;

	private String descricao;

	@Embedded
	private Pessoa solicitante;

	@Embedded
	private Endereco estabelecimento;
	
	@Enumerated(EnumType.STRING)
	private EstadoQueixa estado;
	
	private String comentario = "";

	public Queixa(){
	}

	public Queixa(long id, String descricao, EstadoQueixa estado, String comentario,
                  String nome, String email,
				  String rua, String uf, String cidade) {
		this.id = id;
		this.descricao = descricao;
		this.estado = estado;
		this.comentario = comentario;
		this.solicitante = new Pessoa(nome, email);
		this.estabelecimento = new Endereco(rua, uf, cidade);
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

	public EstadoQueixa getSituacao() {
		return estado;
	}
	//a queixa se abre e fecha!?

	public void abrir() throws ObjetoInvalidoException {
		if (this.estado != EstadoQueixa.EM_ANDAMENTO)
			this.estado = EstadoQueixa.ABERTA;
			
		else
			throw new ObjetoInvalidoException("Status inválido");
	}

	public void fechar(String coment) throws ObjetoInvalidoException {
		if (this.estado == EstadoQueixa.EM_ANDAMENTO
				|| this.estado == EstadoQueixa.ABERTA) {
			this.estado = EstadoQueixa.FECHADA;
			this.comentario = coment;
		} else
			throw new ObjetoInvalidoException("Status Inválido");
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

	public Endereco getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Endereco estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public EstadoQueixa getEstado() {
		return estado;
	}

	public void setEstado(EstadoQueixa estado) {
		this.estado = estado;
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
