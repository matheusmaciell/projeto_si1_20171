package com.ufcg.si1.state;

import exceptions.QueixaStatusException;

public interface IQueixaState {
	
	public IQueixaState estadoAberto() throws QueixaStatusException;
	
	public IQueixaState estadoFechado() throws QueixaStatusException; // Metodos criados apenas para adaptação posterior com os metodos corretos pertencentes ao codigo.
	
	public IQueixaState estadoEmAndamento() throws QueixaStatusException;

}
