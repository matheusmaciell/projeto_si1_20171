package com.ufcg.si1.model.prefeitura;

import com.ufcg.si1.model.situacao.Situacao;

public abstract class Prefeitura {
	
	
	private double quoeficienteRuim;
	private double quoeficienteRegular;
	private SituacaoPrefeitura situacao;
	
	public Prefeitura(){
		this.setSituacao( new SituacaoPrefeitura(quoeficienteRuim,quoeficienteRegular) );
	}
	
	public Situacao getSituacaoGeral(double numQueixasAbertas, int queixaService) {
		 return this.getSituacao().getSituacaoGeral(numQueixasAbertas, queixaService);
	}

	public double getQuoeficienteRuim() {
		return quoeficienteRuim;
	}

	public void setQuoeficienteRuim(double quoeficienteRuim) {
		this.quoeficienteRuim = quoeficienteRuim;
	}

	public double getQuoeficienteRegular() {
		return quoeficienteRegular;
	}

	public void setQuoeficienteRegular(double quoeficienteRegular) {
		this.quoeficienteRegular = quoeficienteRegular;
	}

	public SituacaoPrefeitura getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoPrefeitura situacao) {
		this.situacao = situacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(quoeficienteRegular);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(quoeficienteRuim);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((situacao == null) ? 0 : situacao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prefeitura other = (Prefeitura) obj;
		if (Double.doubleToLongBits(quoeficienteRegular) != Double.doubleToLongBits(other.quoeficienteRegular))
			return false;
		if (Double.doubleToLongBits(quoeficienteRuim) != Double.doubleToLongBits(other.quoeficienteRuim))
			return false;
		if (situacao == null) {
			if (other.situacao != null)
				return false;
		} else if (!situacao.equals(other.situacao))
			return false;
		return true;
	}
}
