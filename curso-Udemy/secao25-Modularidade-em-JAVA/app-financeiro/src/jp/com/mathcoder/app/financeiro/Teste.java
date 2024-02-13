package jp.com.mathcoder.app.financeiro;

import java.lang.reflect.Field;
import java.util.ServiceLoader;

import jp.com.mathcoder.app.Calculadora;
//import jp.com.mathcoder.app.calculo.CalculadoraImpl;
//import jp.com.mathcoder.app.calculo.interno.OperacoesAritmeticas;

public class Teste {

	public static void main(String[] args) {
		
//		CalculadoraImpl calc = new CalculadoraImpl();
		
		Calculadora calc = ServiceLoader
				.load(Calculadora.class)
				.findFirst()
				.get();
		
		System.out.println(calc.soma(2, 3, 4));
			
//		System.out.println(calc.getLoggerClass());
		
//		OperacoesAritmeticas opAritmeticas = new OperacoesAritmeticas();
//		System.out.println(opAritmeticas.soma(4, 5, 6));
		
//		System.out.println(CalculadoraImpl.class.getName());
//		System.out.println(CalculadoraImpl.class.getDeclaredFields()[0].getName());
//		System.out.println("Before " + calc.getId());
//		
//		try {
//			Field fieldId = CalculadoraImpl.class.getDeclaredFields()[0];
//			fieldId.setAccessible(true);
////			System.out.println("Before " + fieldId.get(calc));
//			fieldId.set(calc, "def");
////			System.out.println("After " + fieldId.get(calc));
//			fieldId.setAccessible(false);
//			
//			System.out.println("After " + calc.getId());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		Calc c1 = new Calc1();
		Calc c2 = new Calc2();
		
		System.out.println(c1.soma(1, 2, 3));
		System.out.println(c2.soma(1, 2, 3));
	}
}
