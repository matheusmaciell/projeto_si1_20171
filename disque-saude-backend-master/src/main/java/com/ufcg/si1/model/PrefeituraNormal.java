package com.ufcg.si1.model;



public class PrefeituraNormal{
	
	private static final double quoeficienteRegular = 0.1;
	private static final double quoeficienteRuim = 0.2;
	private SituacaoPrefeitura situacao;	

	public PrefeituraNormal(){
		this.situacao = new SituacaoPrefeitura(quoeficienteRuim,quoeficienteRegular);
	}
	
	
	public Object getSituacaoGeral(double numQueixasAbertas, int queixaService) {
		 return this.situacao.getSituacaoGeral(numQueixasAbertas, queixaService);
	
	}
	
}
