package jp.com.mathcoder.app.financeiro;

import jp.com.mathcoder.app.calculo.Calculadora;

public class Teste {

	public static void main(String[] args) {
		
		Calculadora calc = new Calculadora();
		
		System.out.println(calc.soma(2, 3, 4));
		
		System.out.println(calc.getLoggerClass());
	}
}
