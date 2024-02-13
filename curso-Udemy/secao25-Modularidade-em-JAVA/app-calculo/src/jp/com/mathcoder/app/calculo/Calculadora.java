package jp.com.mathcoder.app.calculo;

import jp.com.mathcoder.app.calculo.interno.OperacoesAritmeticas;
//import jp.com.mathcoder.app.loggin.Logger;
import jp.com.mathcoder.app.loggin.Logger;

public class Calculadora {
	
	private String id = "abc";

	private OperacoesAritmeticas opAritmeticas = new OperacoesAritmeticas();

	public double soma(double... nums) {
		Logger.info("Somando...");
		return opAritmeticas.soma(nums);
	}

	public String getId() {
		return id;
	}
	
//	public Class<Logger> getLoggerClass() {
//		return Logger.class;
//	}
	
}
