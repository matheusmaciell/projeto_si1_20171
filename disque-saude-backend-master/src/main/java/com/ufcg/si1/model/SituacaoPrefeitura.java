package com.ufcg.si1.model;


public class SituacaoPrefeitura {
	private double quoeficienteRuim;
	private double quoeficienteRegular;
	
	public SituacaoPrefeitura(double quoeficienteRuim,double quoeficienteRegular){
		this.quoeficienteRuim = quoeficienteRuim;
		this.quoeficienteRegular = quoeficienteRegular;
	}
	
	public Object getSituacaoGeral(double numQueixasAbertas, int queixaService) {
		if (numQueixasAbertas / queixaService > quoeficienteRuim) {
            return new SituacaoRuim();
        } else {
            if (numQueixasAbertas / queixaService > quoeficienteRegular) {
                return new SituacaoRegular();
            }
            return new SituacaoBoa();
        }
	}
	
	
			
	
	
	

}
