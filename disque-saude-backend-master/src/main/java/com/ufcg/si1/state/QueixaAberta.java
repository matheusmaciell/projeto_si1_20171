package com.ufcg.si1.state;

import exceptions.QueixaStatusException;

public class QueixaAberta implements IQueixaState{

	//Analisar a funcionalidade
	@Override
	public IQueixaState estadoAberto() throws QueixaStatusException {
		throw new QueixaStatusException("Queixa já está aberta!");
	}

	@Override
	public QueixaFechada estadoFechado() {
		return new QueixaFechada();
	}

	@Override
	public QueixaEmAndamento estadoEmAndamento() {
		return new QueixaEmAndamento();
	}

}
