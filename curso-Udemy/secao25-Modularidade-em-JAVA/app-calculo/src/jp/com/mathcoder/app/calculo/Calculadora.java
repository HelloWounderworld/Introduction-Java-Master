package jp.com.mathcoder.app.calculo;

import jp.com.mathcoder.app.calculo.interno.OperacoesAritmeticas;

public class Calculadora {

	private OperacoesAritmeticas opAritmeticas = new OperacoesAritmeticas();

	public double soma(double... nums) {
		return opAritmeticas.soma(nums);
	}
	
}
