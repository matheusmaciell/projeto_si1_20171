package com.ufcg.si1.model;





public class PrefeituraExtra{
	private static final double quoeficienteRegular = 0.05;
	private static final double quoeficienteRuim = 0.1;
	private SituacaoPrefeitura situacao;	

	public PrefeituraExtra(){
		this.situacao = new SituacaoPrefeitura(quoeficienteRuim,quoeficienteRegular);
	}
	
	
	public Object getSituacaoGeral(double numQueixasAbertas, int queixaService) {
		 return this.situacao.getSituacaoGeral(numQueixasAbertas, queixaService);
	
	}
	
	
	
	

}
