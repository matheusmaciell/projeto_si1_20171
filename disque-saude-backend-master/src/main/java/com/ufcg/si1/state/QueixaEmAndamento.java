package com.ufcg.si1.state;

public class QueixaEmAndamento implements IQueixaState {

	@Override
	public IQueixaState abrirQueixa() {
		System.out.println("Abri uma nova queixa!");
		return new QueixaAberta();
	}

	@Override
	public IQueixaState fecharQueixa() {
		System.out.println("Fechei uma nova queixa!");
		return new QueixaFechada();
	}

	@Override
	public IQueixaState verificarQueixa() {
		System.out.println("Queixa verificada!");
		return this;
	}

}
