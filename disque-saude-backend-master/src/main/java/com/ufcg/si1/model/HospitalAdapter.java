package com.ufcg.si1.model;


import java.util.List;

import javax.persistence.Entity;

import br.edu.ufcg.Hospital;


public class HospitalAdapter extends UnidadeSaude {
	
	private Hospital hospital;
	
	public HospitalAdapter(String descricao, int medicos, int num) {
		this.hospital = new Hospital(descricao, medicos, num);
	}
	
	public int pegaCodigo() {
		return hospital.getCodigo();
	}
	
	public void mudaCodigo(int codigo) {
		hospital.setCodigo(codigo);
	}
	
	public String pegaDescricao() {
		return hospital.getDescricao();		
	}
	
	public int pegaContador() {
		return hospital.getContador();
	}

	public int getNumeroFuncionarios() {
		return hospital.getNumeroMedicos();
	}

	public float atendimentosDiarios() {
		return hospital.getNumeroPacientesDia();
	}
	
	
	
	

}
