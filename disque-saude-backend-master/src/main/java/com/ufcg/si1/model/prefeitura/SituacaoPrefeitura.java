package com.ufcg.si1.model.prefeitura;

import com.ufcg.si1.model.situacao.Situacao;
import com.ufcg.si1.model.situacao.SituacaoBoa;
import com.ufcg.si1.model.situacao.SituacaoRegular;
import com.ufcg.si1.model.situacao.SituacaoRuim;

public class SituacaoPrefeitura {
	private double quoeficienteRuim;
	private double quoeficienteRegular;
	
	public SituacaoPrefeitura(double quoeficienteRuim,double quoeficienteRegular){
		this.quoeficienteRuim = quoeficienteRuim;
		this.quoeficienteRegular = quoeficienteRegular;
	}
	
	public Situacao getSituacaoGeral(double numQueixasAbertas, int queixaService) {
		if (numQueixasAbertas / queixaService > quoeficienteRuim) 
            return new SituacaoRuim(); 
        if (numQueixasAbertas / queixaService > quoeficienteRegular)
             return new SituacaoRegular();
        else 
            return new SituacaoBoa();
	}
	
	
			
	
	
	

}
