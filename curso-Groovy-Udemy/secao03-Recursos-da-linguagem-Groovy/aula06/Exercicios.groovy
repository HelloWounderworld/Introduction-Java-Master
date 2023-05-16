package aula

import classes.Cliente

import java.util.Date;

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
	void exercicio2() {
		Cliente c = new Cliente()
		// Note que, n�o precisa definir set e get na classe Cliente
		// mas, por padr�o, j� temos tais m�todos para cada classe instanciado
		c.setNome "Leo"
		c.setData new Date()
		println c.somar(10, 20)
		println c.getNome() + " - " + c.getData()
	}
	
	@Test
	void exercicio3() {
		Cliente c = new Cliente()
		println c.getNome() + " - " + c.getData()
		
		c = new Cliente(nome: "Leonardo")
		println c.getNome() + " - " + c.getData()

		c = new Cliente(data: new Date())
		println c.getNome() + " - " + c.getData()

		c = new Cliente(nome: "Leonardo", data: new Date())
		println c.getNome() + " - " + c.getData()
	}
	
	@Test
	void exercicio1ponto5() {
		
	}
	
	@Test
	void exercicio1ponto6() {
		
	}

}
