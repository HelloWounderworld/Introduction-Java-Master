module app.calculo {
	requires transitive app.loggin;
	exports jp.com.mathcoder.app.calculo;
	
	exports jp.com.mathcoder.app.calculo.interno
		to app.financeiro;
	
	opens jp.com.mathcoder.app.calculo to app.loggin, app.financeiro;
}