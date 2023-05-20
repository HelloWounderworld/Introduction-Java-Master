package aula

import classes.Cliente
import classes.Comida
import classes.Conexao
import classes.Funcionario
import classes.Funcionario2
import classes.Nota
import classes.Pedido
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
		// O inteiro criado acima é um objeto
		// Se vc dar a. aparecerá um monte de métodos.
		println a.class
		println a.toString()
		
		// O Integer Long term.
		println 12l.class.name
		
		println 10.toString()
		
		// Todo valor literal inteiro que vc esteja mapeando com o "g", como foi feito abaixo
		// em "11g", vc estará mapeando na classe BigInteger.
		println 11g.class.name
		
		// O BigDecimal, no Java, vc precisa mapear que ele é um float.
		// No Groovy, o BigDecimal, por padrão, é float.
		BigDecimal valor = 200.50
		println valor
	}
	
	@Test
	void exercicio2() {
		Cliente c = new Cliente()
		// Note que, não precisa definir set e get na classe Cliente
		// mas, por padrão, já temos tais métodos para cada classe instanciado
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
		// Mas, graças a, Direct Field Access Operator, não é necessário
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
		// Aqui, ficaria nítido que o groovy já oferece as duas sobrecargas
		// algo que na classe Venda só foi definido um parâmetro por padrão nela
		// No java, vc teria que criar os métodos considerando a quantidade de possibilidades
		// de combinações dos parâmetros que vc queira considerar.
		println v.vender(100)
		println v.vender(100, 15)
	}
	
	@Test
	void exercicio8() {
		Somar soma = new Somar()
		
		// O que estou fazendo aqui embaixo, ao chamar o método somar
		// No java, não seria possível, pois teria que primeiro
		// definir um array indicando que está indo um número flutuante nela.
		println soma.somar(10)
		println soma.somar(10, 10)
		println soma.somar(10, 10, 10)
	}
	
	@Test
	void exercicio9() {
		Cliente c = null
		
		// Esse "?" (Safe operator) usado e que é tipicamente do groovy
		// Em java vc teria que contornar usando um if
		c?.getNome()
		
		// A forma como seria contornado usando o Java.
//		if (c != null) {
//			c.getNome()
//		}
		
		c?.nome = "Leonardo"
		println c?.getNome()
		
		// No caso, o println acima retornou null
		// Isso significa que sempre será necessário instanciar a classe
		// para poder contornar a situação
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
		
		// Se eu quiser deixar todos os nomes começando com letra maiuscula
		// usando Java, teria que fazer algo do seguinte tipo
		// Ou seja, estou vendo se não é nulo, o que daria para ser sanado pelo
		// safe operator. E, além disso, teria que usar o toUpperCase() iterando
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
	
	@Test
	void exercicio11() {
		// Se estivessemos em Java, teríamos que realizar o seguinte usando o try/catch
//		try {
//			URL url = new URL("http://www.google.com.br")
//		} catch (Exception e) {
//			e.printStackTrace()
//		}
		// Mas em groovy, podemos resolver isso em uma única linha
		// apenas instanciando a classe.
		
		URL url = new URL("http://www.google.com.br")
		println url
	}
	
	@Test
	void exercicio12() {
		String nome = null
		
		// No java, colocando na condicional if, a forma como está nela
		// não será avaliado. Mas no groovy, será! Que nem em JS e Python que eu ví.
		if (nome) {
			println true
		} else {
			println false
		}
		
		nome = "Leo"
		if (nome) {
			println true
		} else {
			println false
		}
		
		int valor = 0
		if (valor) {
			println true
		} else {
			println false
		}
		
		valor = 1
		if (valor) {
			println true
		} else {
			println false
		}
	}
	
	@Test
	void exercicio13() {
		Nota n1 = new Nota(itens: 2, valor: 20)
		Nota n2 = new Nota(itens: 3, valor: 15)
		// Isso aqui em baixo, não compila em Java.
		// É algo típico do groovy
		Nota n3 = n1 + n2
		// Em Java seria n3 = n1.plus(n2)
		println n1.valor + " - " + n1.itens
		println n2.valor + " - " + n2.itens
		println n3.valor + " - " + n3.itens
		// Podemos fazer esse ++ abaixo, mediante à definição do next na classe Nota
		n1++
		// Em Java seria n1 = n1.next()
		println n1.valor + " - " + n1.itens
	}
	
	@Test
	void exercicio13ponto2() {
		// No java, vc teria que fazer o seguinte
		// BigDecimal vl = new BigDecimal(10)
		BigDecimal vl = 10
		println vl
		
		// Isso em Java não iria compilar
		// Em java teria que fazer o seguinte
		// BigDecimal x = vl.add(new BigDecimal(1))
		vl = vl + 1
		println vl
		vl++
		println vl
		vl -= 5
		println vl
		
		Date data = new Date()
		println data
		data++ // acrescenta mais 1 dia
		println data
		data--
		println data
	}
	
	@Test
	void exercicio14() {
		Funcionario f = new Funcionario(nome: "Leo", idade: 3, salario: 10.50)
		println f
	}
	
	@Test
	void exercicio15() {
		Funcionario2 f1 = new Funcionario2(nome: "Leo", idade: 12, salario: 10000.00)
		Funcionario2 f2 = new Funcionario2(nome: "Leo", idade: 12, salario: 10000.00)
		println f1.equals(f2)
		println f2.equals(f1)
	}
	
	@Test
	void exercicio16() {
		Pedido p = new Pedido(cliente: "Leonardo", numero: 10)
		println p.cliente + " - " + p.numero
		println p
		
		// Por estar usando o Immutable, não será possível realizar a tal alteração de baixo
		p.cliente = "Leo"
		p.setCliente("Leonardo")
		println p.cliente
	}
	
	@Test
	void exercicio17() {
		Conexao.instance.valor = 10
		println Conexao.instance.valor
		Conexao cn = Conexao.instance
		cn.valor = 11
		println cn.valor
		println Conexao.instance.valor
		
		// Isso não vai executar
		Conexao x = new Conexao()
	}
	
	@Test
	void exercicio18() {
		Comida comida = Comida.builder().fruta("marca").bebida("coca cola").doce("casadinho").build()
		println comida.fruta
		println comida.bebida
		println comida.doce
	}
	
	@Test
	void exercicio19() {
		def objeto = "texto"
		println objeto.getClass()
		println objeto
		
		objeto = 10
		println objeto.getClass()
		println objeto
		
		objeto = 10.0
		println objeto.getClass()
		println objeto
		
		objeto = new Nota(itens: 2, valor: 50)
		println objeto.getClass()
		println objeto
		objeto.itens = 10
		println objeto.itens
		println objeto.valor
		
		objeto = new Pedido(cliente: "Leonardo", numero: 100)
		println objeto.getClass()
		println objeto.cliente
		println objeto.numero
	}

}
