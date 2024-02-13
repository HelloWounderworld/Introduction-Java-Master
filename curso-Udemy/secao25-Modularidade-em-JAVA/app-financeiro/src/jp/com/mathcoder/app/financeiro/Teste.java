package jp.com.mathcoder.app.financeiro;

import java.lang.reflect.Field;

import jp.com.mathcoder.app.calculo.Calculadora;
import jp.com.mathcoder.app.calculo.interno.OperacoesAritmeticas;

public class Teste {

	public static void main(String[] args) {
		
		Calculadora calc = new Calculadora();
		
		System.out.println(calc.soma(2, 3, 4));
			
//		System.out.println(calc.getLoggerClass());
		
		OperacoesAritmeticas opAritmeticas = new OperacoesAritmeticas();
		System.out.println(opAritmeticas.soma(4, 5, 6));
		
		System.out.println(Calculadora.class.getName());
		System.out.println(Calculadora.class.getDeclaredFields()[0].getName());
		System.out.println("Before " + calc.getId());
		
		try {
			Field fieldId = Calculadora.class.getDeclaredFields()[0];
			fieldId.setAccessible(true);
//			System.out.println("Before " + fieldId.get(calc));
			fieldId.set(calc, "def");
//			System.out.println("After " + fieldId.get(calc));
			fieldId.setAccessible(false);
			
			System.out.println("After " + calc.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
