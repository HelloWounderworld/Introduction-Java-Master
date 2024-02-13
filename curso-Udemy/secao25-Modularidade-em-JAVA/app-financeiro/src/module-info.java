module app.financeiro {
	
	requires java.base; // Por padrão
//	requires app.calculo;
//	requires app.loggin;
	requires app.api;
	uses jp.com.mathcoder.app.Calculadora;
}