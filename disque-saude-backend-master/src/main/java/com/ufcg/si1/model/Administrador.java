package com.ufcg.si1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Administrador{
	
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String senha;
	private String nome;
	private String email;

	public Administrador(String nome, String email, String senha){
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
