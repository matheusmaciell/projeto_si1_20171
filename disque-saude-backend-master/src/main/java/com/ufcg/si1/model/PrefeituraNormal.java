package com.ufcg.si1.model;

public class PrefeituraNormal extends Prefeitura{
	
	private static final double QUOEFICIENTEREGULAR = 0.1;
	private static final double QUOEFICIENTERUIM = 0.2;

	public PrefeituraNormal(){
		this.setQuoeficienteRegular(QUOEFICIENTEREGULAR);
		this.setQuoeficienteRuim(QUOEFICIENTERUIM);
	}
	
	public Situacao getSituacaoGeral(double numQueixasAbertas, int queixaService) {
		 return this.getSituacao().getSituacaoGeral(numQueixasAbertas, queixaService);
	
	}
	
}
