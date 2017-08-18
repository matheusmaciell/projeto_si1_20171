package com.ufcg.si1.state;

public class QueixaFechada implements IQueixaState {

	@Override
	public IQueixaState abrirQueixa() {
		System.out.println("Abri uma nova queixa!");
		return new QueixaAberta();
	}

	@Override
	public IQueixaState fecharQueixa() {
		System.out.println("Queixa fechada!");
		return this;
	}

	@Override
	public IQueixaState verificarQueixa() {
		System.out.println("Queixa em andamento!");
		return new QueixaEmAndamento();
	}
}
