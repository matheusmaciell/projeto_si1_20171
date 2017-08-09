package com.ufcg.si1.model;

public class PrefeituraExtra extends Prefeitura{
	
	private static final double QUOEFICIENTEREGULAR = 0.05;
	private static final double QUOEFICIENTERUIM = 0.1;

	public PrefeituraExtra(){
		this.setQuoeficienteRegular(QUOEFICIENTEREGULAR);
		this.setQuoeficienteRuim(QUOEFICIENTERUIM);
	}
	
	public Situacao getSituacaoGeral(double numQueixasAbertas, int queixaService) {
		 return this.getSituacao().getSituacaoGeral(numQueixasAbertas, queixaService);
	
	}

}
