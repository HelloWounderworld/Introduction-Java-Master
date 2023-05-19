package aula

import classes.Cliente
import classes.Produto
import classes.Somar
import classes.Venda

import java.util.Date;

import org.junit.Test;

// Importando a classe Cliente e denotando-a como Cl
// Assim, podemos instanciar essa classe cliente por via desse nome Cl.
import classes.Cliente as Cl
import static javax.swing.JFrame.EXIT_ON_CLOSE as ex

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
	void exercicio4() {
		Cliente c = new Cliente(nome: "Leonardo", data: new Date())
		println c.getNome()
		println c.getData()
		
		c["nome"] = "Chris Rock"
		// Subscribed Operator
		println c["nome"]
		println c["data"]
//		c["idade"] = 26
//		println "Atributo inexistente " + c["idade"]
	}
	
	@Test
	void exercicio5() {
		Produto p = new Produto("CD", 12.00);
		// Se fosse em java teria que digitar getNome()
		// Mas, gra�as a, Direct Field Access Operator, n�o � necess�rio
		println p.nome
		println p.nome = "Everbody Hates Chris!"
		println p.valor
		println p.valor = 15.00
	}
	
	@Test
	void exercicio6() {
		Cl c = new Cl(nome: "Leonardo", data: new Date())
		println c.nome + " - " + c.data
		println c.getNome() + " - " + c.getData()
		println c["nome"] + " - " + c["data"]
		println "$c['nome'] - $c['data']"
		println ex
	}
	
	@Test
	void exercicio7() {
		Venda v = new Venda()
		// Aqui, ficaria n�tido que o groovy j� oferece as duas sobrecargas
		// algo que na classe Venda s� foi definido um par�metro por padr�o nela
		// No java, vc teria que criar os m�todos considerando a quantidade de possibilidades
		// de combina��es dos par�metros que vc queira considerar.
		println v.vender(100)
		println v.vender(100, 15)
	}
	
	@Test
	void exercicio8() {
		Somar soma = new Somar()
		
		// O que estou fazendo aqui embaixo, ao chamar o m�todo somar
		// No java, n�o seria poss�vel, pois teria que primeiro
		// definir um array indicando que est� indo um n�mero flutuante nela.
		println soma.somar(10)
		println soma.somar(10, 10)
		println soma.somar(10, 10, 10)
	}
	
	@Test
	void exercicio9() {
		Cliente c = null
		
		// Esse "?" (Safe operator) usado e que � tipicamente do groovy
		// Em java vc teria que contornar usando um if
		c?.getNome()
		
		// A forma como seria contornado usando o Java.
//		if (c != null) {
//			c.getNome()
//		}
		
		c?.nome = "Leonardo"
		println c?.getNome()
		
		// No caso, o println acima retornou null
		// Isso significa que sempre ser� necess�rio instanciar a classe
		// para poder contornar a situa��o
		Cliente c2 = new Cliente()
		c2?.nome = "Leonardo"
		println c2.getNome()
		println c2.nome
	}
	
	@Test
	void exercicio10() {
		List<String> colecao = new ArrayList()
		colecao.add("leonardo")
		colecao.add(null)
		colecao.add("fernando")
		colecao.add("anny")
		colecao.add("rita")
		println colecao
		
		// Se eu quiser deixar todos os nomes come�ando com letra maiuscula
		// usando Java, teria que fazer algo do seguinte tipo
		// Ou seja, estou vendo se n�o � nulo, o que daria para ser sanado pelo
		// safe operator. E, al�m disso, teria que usar o toUpperCase() iterando
		// para todos.
//		for (String item: colecao) {
//			if (item != null) {
//				item = item.toUpperCase()
//			}
//		}
		// No caso, usando o Spread "*", podemos sanar esses dois casos
		colecao = colecao*.toUpperCase()
		println colecao
		
		// Onde estiver com letra "A" substituir em "@" em todos os nomes que aparece
		colecao = colecao*.replace("A", "@")
		println colecao
	}

}
