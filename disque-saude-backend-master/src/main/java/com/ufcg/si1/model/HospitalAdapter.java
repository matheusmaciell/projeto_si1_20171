package com.ufcg.si1.model;



import br.edu.ufcg.Hospital;

public class HospitalAdapter extends UnidadeSaude {
	
	private Hospital hospital;
	
	public HospitalAdapter(String descricao, int medicos, int num) {
		this.hospital = new Hospital(descricao, medicos, num);
	}
	
	@Override
	public int pegaCodigo() {
		return hospital.getCodigo();
	}
	
	@Override
	public void mudaCodigo(int codigo) {
		hospital.setCodigo(codigo);
	}
	
	@Override
	public String getBairro() {
		return hospital.getDescricao();		
	}
	
	public int pegaContador() {
		return hospital.getContador();
	}

	@Override
	public int getNumeroFuncionarios() {
		return hospital.getNumeroMedicos();
	}

	@Override
	public float atendimentosDiarios() {
		return hospital.getNumeroPacientesDia();
	}
}
