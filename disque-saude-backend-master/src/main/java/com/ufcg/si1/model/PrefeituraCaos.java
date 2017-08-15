package com.ufcg.si1.model;

public class PrefeituraCaos extends Prefeitura {
	
	private static final double QUOEFICIENTEREGULAR = 0.2;
	private static final double QUOEFICIENTERUIM = 0.5;

	public PrefeituraCaos(){
		this.setQuoeficienteRegular(QUOEFICIENTEREGULAR);
		this.setQuoeficienteRuim(QUOEFICIENTERUIM);
	}

}
