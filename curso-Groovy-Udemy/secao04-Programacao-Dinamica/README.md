# Seção 04 - Programação Dinâmica:

## Aula 01 - Linguagem Dinâmica:
A linguagem java é estática e fortemente tipada.

É uma linguagem que faz a verificação dos tipos de dados (objetos) para garantir que o programa execute corretamente os comportamentos esperados em todas as situações. Esta verificação é feita previamente no código fonte pelo processo de "compilação".

O compilador fornece garantias que problemas não poderão ocorrer em tempo de execução, após o programa passar por esta verificação, ou seja, erros são detectados logo, antes do programa ser efetivamente executado.

Groovy é uma linguagem dinâmica.

Linguagem dinâmica é um termo usado na engenharia de software para descrever uma classe de linguagens de programação que, em tempo de execução conseguem acrescentar dinamicamente comportamentos não existentes no programa, adicionando, substituindo ou removendo comportamentos, estendendo classes e objetos, ou midificando o sistema de tipos.

Diferentemente das antigas linguagens "fortemente tipadas", as linguagens dinâmicas não possuem garantia de tipos e comportamentos na fase de compilação, utilizada anteriormente para restringir e garantir o sistema tipos em tempo de execução.

A principal diferença das linguagens dinâmicas é que o processo de verificação é feita em tempo de execução. Isto é feito através de uma infraestrutura auxiliar como, por exemplo, uma máquina virtual ou uma biblioteca normalmente chamada de "runtime".

O Objetivo dessa nova classe de linguagens é oferecer mais flexibilidade, mais agilidade e um novo paradigma na criação e manutenção de soluções e suas respectivas arquiteturas.

Programação dinâmica em groovy é oferecida através de vários níveis de recursos diferentes:

- ATS Transformations

- Operador def

- Closures

- Metaprogramação (MOP)

Estudaremos cada um deles!

## Aula 02 e 03 - ATS Transformations:
É um recurso utilizado para gerar dinamicamente determinados tipos de comportamentos repetitivos nas classes em tempos de compilação, com base em certas anotações.

A cada nova versão do groovy, novas anotações de ATS são criadas para facilitar a vida dos desenvolvedores.

Vejamos as mais usadas:

@ToString - utilizada para gerar a sobreposição automática do método toString. Esse aqui é um dos métodos mais utilizados no Java e entra na prática Dry.

Exercício 14:

Vamos começando a criar uma classe groovy chamado Funcionario e nela coloquemos o seguinte

    package classes

    import groovy.transform.ToString

    //@ToString(excludes=["idade"])
    //@ToString(includeNames=true)
    //@ToString(includeNames=true, excludes = "salario, idade")
    @ToString
    class Funcionario {
        String nome
        Integer idade
        Double salario

        // Se estivéssemos no Java, teríamos que gerar o toString como abaixo
        // donde se enquadra na prática Dry.
    //	@Override
    //	public String toString() {
    //		return "Funcionario [nome=" + nome + ", idade=" + idade + ", salario=" + salario + "]";
    //	}
        // No Groovy isso não é necessário pois temos o @ToString que nos permite
        // realizar o mesmo processo do código acima, mas em apenas uma linha
        // Bastaria chamar o @ToString antes da classe Funcionario e só.

    }

Agora, no arquivo de Exercicios.groovy, coloquemos o seguinte

    @Test
	void exercicio14() {
		Funcionario f = new Funcionario(nome: "Leo", idade: 3, salario: 10.50)
		println f
	}

## Aula 04 - ATS Transformations:
Vamos ver, agora, o seguinte método que temos no ATS Transformations.

@EqualsAndHashCode: utilizada para gerar a sobreposição automática do método equals e hashCode.

Exercício 15:

Vamos criar uma outra classe groovy de Funcionario2 e nela vamos realizar as mesmas implementações que vimos na classe Funcionario, só que desta vez adaptada para utilizarmos o método @EqualsAndHashCode. Então, coloquemos o seguinte

    package classes

    import groovy.transform.EqualsAndHashCode

    // Da mesma forma para ToString, para EqualsAndHashCode temos tbm include e exclude
    @EqualsAndHashCode
    class Funcionario2 {
        String nome
        Integer idade
        Double salario

        // Se isso fosse no Java, estaríamos criando a seguinte quantidade de código abaixo.
    //	@Override
    //	public int hashCode() {
    //		final int prime = 31;
    //		int result = 1;
    //		result = prime * result + ((idade == null) ? 0 : idade.hashCode());
    //		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
    //		result = prime * result + ((salario == null) ? 0 : salario.hashCode());
    //		return result;
    //	}
    //	@Override
    //	public boolean equals(Object obj) {
    //		if (this == obj)
    //			return true;
    //		if (obj == null)
    //			return false;
    //		if (getClass() != obj.getClass())
    //			return false;
    //		Funcionario2 other = (Funcionario2) obj;
    //		if (idade == null) {
    //			if (other.idade != null)
    //				return false;
    //		} else if (!idade.equals(other.idade))
    //			return false;
    //		if (nome == null) {
    //			if (other.nome != null)
    //				return false;
    //		} else if (!nome.equals(other.nome))
    //			return false;
    //		if (salario == null) {
    //			if (other.salario != null)
    //				return false;
    //		} else if (!salario.equals(other.salario))
    //			return false;
    //		return true;
    //	}

    }

Agora, no arquivo Exercicios.groovy, vamos colocar o seguinte exercício 15

    @Test
	void exercicio15() {
		Funcionario2 f1 = new Funcionario2(nome: "Leo", idade: 12, salario: 10000.00)
		Funcionario2 f2 = new Funcionario2(nome: "Leo", idade: 12, salario: 10000.00)
		println f1.equals(f2)
		println f2.equals(f1)
	}

## Aula 05 - ATS Transformations:
Agora, vamos aprender o seguinte do ATS Transformations.

@Immutable: utilizada para o design pattern de objetos imutáveis. A classe é dinamicamente gerada somente com atributos get's + toString + equals e hashCode. Qualquer tentativa de alteração gera erro.

Exercícios 16:

Vamos começar por criando uma classe groovy Pedido e nela vamos colocar o seguinte

    package classes

    import groovy.transform.Immutable

    @Immutable
    class Pedido {
        String cliente
        Integer numero
    }

Agora, no arquivo Exercicios.groovy, vamos colocar o seguinte

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

## Aula 06 - ATS Transformations:
Vamos, agora, aprender o seguinte método do ATS Transformations.

@Singleton: utilizada para o design pattern de objetos singleton. A classe é dinamicamente gerada apenas com 1 única instância chamada de "instance". Qualquer tentativa de criar uma instância, gerará erro.

Exercício 17:

Vamos criar uma classe groovy chamado Conexao e nela coloquemos o seguinte

    package classes

    @Singleton
    class Conexao {
        Double valor
    }

Agora, no arquivo Exercicios.groovy podemos colocar o seguinte

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

## Aula 07 - ATS Transformations:
Vamos, agora, aprender o outro método do ATS Transformations.

@Builder: utilizada para o design pattern de objetos Builder. A classe é dinamicamente gerada seguindo o padrão, sem acesso set's aos atributos.

Exercícios 18:

Vamos começando por criar uma classe groovy Comida e nela coloquemos o seguinte

    package classes

    import groovy.transform.builder.Builder

    @Builder
    class Comida {
        String fruta
        String bebida
        String doce
    }

Agora, no arquivo Exercicios.groovy, vamos colocar o seguinte

    @Test
	void exercicio18() {
		Comida comida = Comida.builder().fruta("marca").bebida("coca cola").doce("casadinho").build()
		println comida.fruta
		println comida.bebida
		println comida.doce
	}

Para todas as anotações ATS Transformations, segue o seguinte link

    https://groovy-lang.org/metaprogramming.html

## Aula 08 - Operador def:
Operador utilizado para criar objetos do tipo indeterminado. O objeto assume várias tipagens diferente ao longo da execução da solução.

Em linguagens dinâmicas, não existe a limitação da preocupação com tipagem de dados, deixando as referências com tipagem dinâmica ao longo da execução do programa.

Exercício 19:

No arquivo Exercicios.groovy vamos colocar o seguinte

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

## Aula 09 - Operador def:
Utlizados para passagem de parâmetros e retorno de métodos. 

Ausência de tipo na passagem de parâmetros do método, já indica que é do tipo dinâmico. Por isso, não precisa digitar.

Exercício 20:

Vamos criar uma classe groovy chamado de Teste e nela vamos colocar o seguinte

    @Test
	void exercicio20() {
		def teste = new Teste()
		def v1 = teste.metodo("Leo")
		println v1.getClass()
		println v1
		
		v1 = teste.metodo(5)
		println v1.getClass()
		println v1
		
		v1 = teste.metodo(10.0)
		println v1.getClass()
		println v1
		
		v1 = teste.metodo(new Date())
		println v1.getClass()
		println v1
		
		v1 = teste.metodo(new Nota())
		println v1.getClass()
		println v1
		
		v1 = teste.metodo(new Pedido())
		println v1.getClass()
		println v1
		
		v1 = teste.metodo(true)
		println v1.getClass()
		println v1
	}

## Aula 10 - Operador def:
Existe um comando for chamado de FOR-IN no groovy específico para iterar sobre coleções de objetos sem tipo usando def.

Dessa forma, é possível fazer a iteração com tipagem dinâmica.

Exercício 21:

    @Test
	void exercicio21() {
		def colecao = new ArrayList<String>()
		colecao.add("Leo")
		colecao.add("Fer")
		for (item in colecao) {
			println item
		}
		
		colecao = new ArrayList<Integer>()
		colecao.add(1)
		colecao.add(2)
		for (item in colecao) {
			println item
		}
		
		colecao = "Leonardo Takashi Teramatsu"
		for (item in colecao) {
			println item
		}
		
		colecao = 10
		for (item in colecao) {
			println item
		}
	}

## Aula 11 - Aula Final:

## Aula 12 - Aula Bônus:
