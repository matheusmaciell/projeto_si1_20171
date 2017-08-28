package com.ufcg.si1.model;

public class Administrador extends Pessoa{
	
	private String senha;

	public Administrador(){}
	
	public Administrador(String nome, String email, String senha) {
		super(nome, email);
		this.setSenha(senha);
	}
	

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
