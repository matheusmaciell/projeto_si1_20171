package com.ufcg.si1.model.prefeitura;

public class PrefeituraNormal extends Prefeitura{
	
	private static final double QUOEFICIENTEREGULAR = 0.1;
	private static final double QUOEFICIENTERUIM = 0.2;

	public PrefeituraNormal(){
		this.setQuoeficienteRegular(QUOEFICIENTEREGULAR);
		this.setQuoeficienteRuim(QUOEFICIENTERUIM);
	}
}
