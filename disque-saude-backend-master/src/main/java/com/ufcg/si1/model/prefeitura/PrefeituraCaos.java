package com.ufcg.si1.model.prefeitura;

public class PrefeituraCaos extends Prefeitura {
	
	private static final double QUOEFICIENTEREGULAR = 0.02;
	private static final double QUOEFICIENTERUIM = 0.5;

	public PrefeituraCaos(){
		this.setQuoeficienteRegular(QUOEFICIENTEREGULAR);
		this.setQuoeficienteRuim(QUOEFICIENTERUIM);
	}

}
