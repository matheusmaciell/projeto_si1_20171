package com.ufcg.si1.state;

import exceptions.QueixaStatusException;

public class QueixaFechada implements IQueixaState {

	@Override
	public IQueixaState estadoAberto() {
		return new QueixaAberta();
	}

	@Override
	public IQueixaState estadoFechado() throws QueixaStatusException {
		throw new QueixaStatusException("Queixa já está fechada!");
	}

	@Override
	public IQueixaState estadoEmAndamento() {
		return new QueixaEmAndamento();
	}

	
}
