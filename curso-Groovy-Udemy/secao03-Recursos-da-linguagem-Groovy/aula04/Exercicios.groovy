package aula

import org.junit.Test;

class Exercicios {
	
	@Test
	void exercicio1ponto2() {
		int a = 10
		// O inteiro criado acima � um objeto
		// Se vc dar a. aparecer� um monte de m�todos.
		println a.class
		println a.toString()
		
		// O Integer Long term.
		println 12l.class.name
		
		println 10.toString()
		
		// Todo valor literal inteiro que vc esteja mapeando com o "g", como foi feito abaixo
		// em "11g", vc estar� mapeando na classe BigInteger.
		println 11g.class.name
		
		// O BigDecimal, no Java, vc precisa mapear que ele � um float.
		// No Groovy, o BigDecimal, por padr�o, � float.
		BigDecimal valor = 200.50
		println valor
	}
	
	@Test
	void exercicio1ponto3() {
		
	}
	
	@Test
	void exercicio1ponto4() {
		
	}
	
	@Test
	void exercicio1ponto5() {
		
	}
	
	@Test
	void exercicio1ponto6() {
		
	}

}
