package com.ufcg.si1.state;

public class QueixaAberta implements IQueixaState{

	//Analisar a funcionalidade
	@Override
	public IQueixaState abrirQueixa() {
		System.out.println("Queixa ja aberta!");
		return this;
	}

	@Override
	public IQueixaState fecharQueixa() {
		System.out.println("Fechei uma nova queixa!");
		return new QueixaFechada();
	}

	@Override
	public IQueixaState verificarQueixa() {
		System.out.println("Queixa em andamento!");
		return new QueixaEmAndamento();
	}

}
