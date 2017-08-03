package com.ufcg.si1.model;

import com.ufcg.si1.util.ObjWrapper;

public interface SituacaoPrefeitura {
	
	public ObjWrapper<Integer> getSituacaoGeral(double numQueixasAbertas, int queixaService);

}
