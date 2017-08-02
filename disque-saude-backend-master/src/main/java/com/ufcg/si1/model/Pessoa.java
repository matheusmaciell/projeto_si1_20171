package com.ufcg.si1.model;

public class Pessoa  {
	private String nome;
	// precisa tirar o extends
	private String email;
	private Endereco endereco;
	public Pessoa(){
		super();
	}


	public Pessoa(String nome, String email, String rua, String uf,
			String cidade) {
		this.endereco = new Endereco(rua, uf, cidade);
		
		this.nome = nome;
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


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	

}
