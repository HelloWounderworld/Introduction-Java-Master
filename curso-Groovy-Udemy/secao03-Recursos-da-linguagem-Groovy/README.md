# Seção 03 - Recursos da Linguagem Groovy:

## Aula 01 - Groovando:
### Regra Geral
Groovy é Java, com as seguintes alterações:

- Um arquivo/classe em groovy deve ter a extensão "NomeClasse.groovy".

- Você pode programar Java no Groovy usando a sintaxe padrão.

- Groovy usa como palavra reservadas: def, in e it, e assim, não podem ser usadas como identificadores.

- Segue abaixo os itens da linguagem Java padrão que NÃO EXISTE no groovy:
    - Sintaxe de inicialização de array de primitivos.
    
    - Bloco de escopo lógico anônimo de instância.

    - Instrução de loop "do/while".

    - Visibilidade "package default" na ausência de modificar.

    - Expressões lambdas do Java 8.

Exercício 1: Criar Projeto

Consultar pelo 

    Apostila-Exercicios-f1.pdf

- Adicionar jar's externos.

- MBD -> New Groovy Project -> aula.

- Criar uma classe groovy com main "Hello Groovy" e executar.

O código é o seguinte

    package aula

    class Exercicio1 {
        static main(args) {
            println "Hello WounderWorld Groovy"
            
            String nome = "Leonardo"
            int idade = 26
            
            String frase = "O " + nome + " tem " + idade + " anos"
            // Interpolacao de String
            
            String frase2 = "O $nome tem $idade anos"
            
            println(frase)
            println(frase2)
        }
    }

O "println", visto que não tem mais de um parâmetro, não precisa colocar o entre parênteses, como foi feito o print para "Hello WounderWorld Groovy".

## Aula 02 - Recursos Groovy - Java tem "Dry":
DRY é uma abreviação do inglês Don't Repeat Yourself, "Não se Repita". É o primeiro princípio do desenvolvimento de software mencionado por Andy Hunt e Dave Thomas no clássico livro O Programador Pragmático.

O princípio, basicamente, declara que não se pode fazer coisas repetidas ou duplicadas ao longo do desenvolvimento de software. Isso ocasiona alta manutenção, aumenta a complexidade, reduz a qualidade de solução final e deixa chato e cansativo de fazer.

Java é uma linguagem repletas de DRY!

A OOP prega que todos os atributos de uma classe tem que ser privado segundo as regras de encapsulamento.

Por que a linguagem java assumiu como padrão atributos default e não privado, sendo que eles são os mais usados e os indicados?

Quantos "private" vc declarou na sua vida como atributos usando a linguagem Java?

Isso não faz sentido!! Isso é puro DRY!!

Groovy resolve todos os problemas de DRY da linguagem java.

Exemplo: Todos os atributos em groovy são private por padrão e não precisam ser digitados.

## Aula 03 - Recursos Groovy - Default Imports:
Em groovy, os pacotes abaixo são importados automaticamente por default. Por isso, não é necessário digitar:

- java.io.*

- java.lang.*

- java.math.BigDecimal;

- java.math.BigInteger;

- java.net.*

- java.util.*

- groovy.lang.*

- groovy.util.*

Em groovy não existe tipos primitivos, tudo é objeto!

Todos os literais primitivos digitado diretamente no código fonte será automaticamente mapeado e convertido para seu objeto wrapper java padrão.

Toda referência a qualquer tipo primitivo, será automaticamente convertido para seu objeto wrapper padrão.

A partir de agora, usamos os exercícios em modelo de testes com JUnit. Adicione os jars, crie uma única classe e acumule todos os exercícios.

Exercício 1.2: Siga o Instrutor

    package aula

    import org.junit.Test;

    class Exercicios {
        
        @Test
        void exercicio1ponto2() {
            
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

## Aula 04 - Continuando com o Exercício 1.2:
Vamos dar continuidade ao exercício 1.2 para entendermos as diferença dos tipos primitivos que tem no Java e que não tem no Groovy.

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

O exercício acima é mais para provar que não existe um valor primitivo em Groovy.

OBS: o ponto e vírgula, ";", em cada linha de código é Dry!!! No Groovy não será necessário isso!

## Aula 05 - Recurso Groovy - POGO:
- Visibilidade "public" é o padrão para nível de classes e métodos. Por isso, não é necessário digitar.

- Visibilidade "private" é o padrão para nível de atributos. Por isso, não é necessário digitar.

- Ponto e vírgula, ";", é opcional para comando em 1 linha ou quando não houver ambiguidade na instrução. Para vários comandos na mesma linha, é obrigatório delimitação com ";".

- Parentes para chamadas de métodos com 1 único parâmetro é opcional e ou quando não houver ambiguidade na instrução.

Por isso, na maioria dos casos, não é necessário digitar.

- Não é necessário criar get's e set's, uma vez que eles serão automaticamente e dinamicamente gerados pelo groovy na compilação.

- Nos métodos com retornos, não é necessário colocar a palavra "return", pois a última linha de qualquer método groovy faz um return implícito.

- Simplesmente coloque o valor/objeto de retorno como última instrução, última linha.

Para entender isso na prática, vamos para o exercício.

Exercício 2: Siga o Instrutor

O arquivo Cliente.groovy

    package classes

    class Cliente {
        // Se liberte de usar public para classes e métodos
        // Se liberte de usar private para os atributos
        String nome
        // No Groovy, vc não precisa importar o Date
        // Por padrão, isso é importado.
        Date data
        Integer somar(Integer v1, Integer v2) {
            // Você não precisa colocar o return, pois ele fica implícito
            v1 + v2
            // Outra alternativa de fazer é abaixo
            // Mas como a intenção do groovy é sempre reduzir o código
            // então o formato acima é o suficiente
    //		int temp = v1 + v2
    //		temp
        }
        
        // Não é necessário criar os get's e os set's para os atributos acima, visto que, por padrão, são private.
        
    }

Do arquivo Exercicio.groovy

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

A criação da classe Cliente acima, feita em Groovy, se fizermos em Java ficaria o seguinte

    package classes;

    import java.util.Date;

    public class ClienteJava {
        private String nome;
        private Date data;

        public Integer somar(Integer v1, Integer v2) {
            return v1 + v2;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public Date getData() {
            return data;
        }

        public void setData(Date data) {
            this.data = data;
        }
    }
   
## Aula 06 - Recursos Groovy - POGO:
Não é necessário criar vários construtores sobrecarregados com os parâmetros diversos que preenchem os atributos de um objeto.

Em groovy existe um recurso chamado "Constructor Names Arguments" que gera dinamicamente todas as combinações de construtores em forma de "mapa" que atribui valores padrões para cada atributo da classe.

Exercício 3: Siga o Instrutor

Vamos nos aproveitar da classe que foi criado pelo Groovy, Cliente.groovy.

No caso, o código ficaria o seguinte

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

No caso, para Java, como ficaria a construção? Seria o seguinte

    package classes;

    import java.util.Date;

    public class ClienteJava {
        private String nome;
        private Date data;

        public ClienteJava(String p1) {
            nome = p1;
        }

        public ClienteJava(Date p1) {
            data = p2;
        }

        public ClienteJava(String p1, Date p2) {
            nome = p1;
            data = p2;
        }

        public Integer somar(Integer v1, Integer v2) {
            return v1 + v2;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public Date getData() {
            return data;
        }

        public void setData(Date data) {
            this.data = data;
        }
    }

## Aula 07 - Recursos Groovy:
Em groovy existe um recurso chamado "Subscript Operator" que dinamicamente usa operador objeto["nomeDoAtributo"] para acessar e manipular os atributos de um objeto.

Ela acessa o get e set da classe.

Muito utilizado para gerar estruturas dinâmicas para atribuição de valores em soluções como por exemplo: Swing, Web Apps, etc...

Exercício 4: Siga o Intrutor

No arquivo Exercicio.groovy, vamos fazer o seguinte

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

## Aula 08 - Recursos Groovy:
Em groovy existe um recurso chamado "Direct Field Access Operator" que usa operador Objeto.atributo para acessar e manipular os atributos de um objeto.

Dinamicamente, é invocado o get e set da classe.

Utilizado para otimizar chamadas de get's e set's. Por isso, não é necessário digitar setBlaBlaBla(Bla) e getBlaBlaBla().

Exercício 5:
Vamos criar uma classe Produto em java.

    package classes;

    public class Produto {
        
        private String nome;
        private double valor;
        
        public Produto(String nome, double valor) {
            super();
            this.nome = nome;
            this.valor = valor;
        }

        public String getNome() {
            System.out.println("getNome");
            return nome;
        }

        public void setNome(String nome) {
            System.out.println("setNome");
            this.nome = nome;
        }

        public double getValor() {
            System.out.println("getValor");
            return valor;
        }

        public void setValor(double valor) {
            System.out.println("setValor");
            this.valor = valor;
        }
        
    }

Agora, em Exercicios.groovy, vamos colocar o exercício 5 da seguinte forma

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

No caso, como ficaria a classe Produto em groovy? Ficaria da seguinte forma

    package classes

    class ProdutoGroovy {
        String nome
        double valor
    }

## Aula 09 - Recursos Groovy:
Em groovy existe o operador "as" utilizado para criar "alias" reduzidos para nomes de classes e recursos estáticos.

Ele é utilizado para várias *** outras coisas...

Use para reduzir qualquer digitação de código repetida.

Exercício 6:

No arquivo Exercícios.groovy temos o seguinte

    // Importando a classe Cliente e denotando-a como Cl
    // Assim, podemos instanciar essa classe cliente por via desse nome Cl.
    import classes.Cliente as Cl
    import static javax.swing.JFrame.EXIT_ON_CLOSE as ex

    @Test
	void exercicio6() {
		Cl c = new Cl(nome: "Leonardo", data: new Date())
		println c.nome + " - " + c.data
		println c.getNome() + " - " + c.getData()
		println c["nome"] + " - " + c["data"]
		println "$c['nome'] - $c['data']"
		println ex
	}

## Aula 10 - Recursos Groovy:
Em groovy existe um recurso chamado de "Optional Parameters" utilizado para que os parâmetros de um método assuma valores padrões em caso de não ser devidamente informados na sua chamada.

Groovy vai gerar dinamicamente todas as sobrecargas necessários para cumprir os parâmetros opcionais. Por isso, não é necessário digitar.

Exercício 7:
Vamos criar uma classe Venda em groovy e coloquemos o seguinte nela

    package classes

    class Venda {
        // Note que, já podemos estabelecer um valor padrão, caso não seja fornecido nada
        // nos argumentos abaixo. A lógica é o mesmo que foi estudado no JavaScript.
        double vender (double valor, int taxa = 10) {
            double rs = valor * taxa / 100
            rs
        }
    }

Agora, no arquivo Exercicios.groovy, vamos colocar o seguinte

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

## Aula 11 - Recursos Groovy:
Em groovy existe um recurso chamado de "Array Optional Paerameters" utilizado para que os parâmetros de um método como array possa ser passado de forma simples, utilizando vírgulas.

Groovy vai gerar dinamicamente a criação do array e a passagem correta do método. Por isso, não é necessário digitar.

Exercício 8:
Vamos, inicialmente, criar uma classe groovy chamada somar e nela colocamos o seguinte

    package classes

    class Somar {
        double somar(double[] valores) {
            double rs = 0
            for (double v: valores) {
                rs += v
            }
            rs
        }
    }

No arquivo Exercicios.groovy, vamos colocar o seguinte

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

## Aula 12 - Recursos Groovy:
Em groovy existe um recurso chamado de "Safe Navegator Operator" utilizando para evitar o famoso NullPointException quando referências as objetos não estão devidamente apontadas.

    objeto?.executar()... objeto?.setNome("bla")...

Groovy, dinamicamente vai fazer uma verificação de "if" como null e não executar a operação. Por isso, não é necessário digitar.

Exercício 9:
No arquivo Exercicios.groovy vamos colocar o seguinte

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

Usamos a classe Cliente groovy que já foi definido não sofreu nenhuma modificação.

## Aula 13 - Recursos Groovy:
Em groovy existe um recurso chamado de "Spread Operator" utilizando para executar comportamentos em bloco sobre coleções.

- colecao*.executar()

- colecao*.setNome("bla")

Groovy vai dinamicamente iterar na coleção e executar a determinada operação em bloco. Spread usa o operador "safe ?" por padrão. Por isso, não é necessário digitar.

Exercício 10:
No arquivo Exercicios.groovy vamos colocar o seguinte

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

## Aula 14 - Recursos Groovy:
Em groovy as "checked exceptions" são opcionais. Ou seja, o desenvolvedor não é obrigado a digitar try/catch para executar as operações checadas.

Em caso de acontecer a exceção, ela será lançada para o método chamador até estourar a pilha de execução da JVM. Por isso, não é necessário digitar.

Cada um fica livre em tratar ou não. Equipes ágeis com cobertura de testes automatizados não precisam usar try/catch reduzindo e muito o código da solução final.

Exercício 11:
No arquivo de Exercicios.groovy vamos colocar o seguinte

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

## Aula 15 - Recursos Groovy:
Em groovy existe um recurso chamado de "Boolean Avaliuation" utilizado para avaliar qualquer tipo de expressão como resultado boolean.

De forma que não existe necessidade de digitar qualquer coisa extra para avaliar a expressão para boolean.

Segue a listagem das regras:

    Type            Condition for Truth
    Boolean         True
    Collection      Not empty
    Character       Value not 0
    CharSequence    Length greater than 0
    Enumeration     Has more elements
    Iterator        Has next
    Number          Double value not 0
    Map             Not empty
    Matcher         At least one match
    Object[]        Length greater than 0
    Any other type  Reference not null

Exercício 12:
No arquivo Exercicios.groovy, vamos fazer o seguinte

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

## Aula 16 - Recursos Groovy:
Em groovy existe um recurso chamado de "Operator Overloading" utilizado para criar expressões de operadores com qualquer tipo de objeto.

Utilizado para criar uma melhor expressividade e otimização na utilização de objetos com os operadores.

Segue a listagem das opções:

    Operator            Method
    +                   a.plus(b)
    -                   a.minus(b)
    *                   a.multiply(b)
    /                   a.div(b)
    %                   a.mod(b)
    **                  a.power(b)
    |                   a.or(b)
    &                   a.and(b)
    ^                   a.xor(b)
    a[b]                a.getAt(b)
    a[b] = c            a.putAt(b, c)
    <<                  a.leftShift(b)
    >>                  a.rightShift(b)
    ++                  a.next()
    --                  a.previous()
    +a                  a.positive()
    -a                  a.negative()
    -a                  a.bitwiseNegative

Métodos padrões do "Operator Overloading":

- Devem ser públicos

- Devem ser nomeados exatamente como indicado na tabela

- Devem retornar o mesmo objeto do tipo operado a esquerda.

- O parâmetro depende do tipo do objeto a direita do operador, de forma que é possível operar com objetos diferentes.

Exercício 13:

Vamos começar criando uma classe groovy chamado Nota e nela colocamos o seguinte

    package classes

    class Nota {
        Integer itens
        Double valor
        
        Nota plus(Nota nota) {
            println "plus"
            Nota novo = new Nota()
            println this.valor + " - " + this.itens
            println nota.valor + " - " + nota.itens
            novo.itens = + this.itens + nota.itens
            novo.valor = + this.valor + nota.valor
            println "Quem é o novo.itens: " + novo.itens
            println "Quem é o novo.valor: " + novo.valor
            novo
        }
        
        Nota next() {
            println "next"
            this.itens += 1
            this.valor += 2
            this
        }
    }

Agora, em Exercicios.groovy, colocamos o seguinte

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

## Aula 17 - Recursos Groovy:
Várias classes da JDK foram implementadas para automaticamente funcionar com a maioria dos operadores.

Exercício 13.2:
No arquivo Exercicios.groovy, vamos colocar o seguinte

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

## Aula 18 - Recursos Groovy:
Trait é uma nova construção estrutural em groovy que mistura regras de interface + classes concretas abstratas.

Trait é uma interface que pode ter métodos abstratos e é também uma classe abstrata que pode conter estado e métodos concretos.

 As outras classes usam o comando implements para implementar uma trait herdando todos os seus comportamentos.

 As traits podem herdar outras traits e outras interfaces usando comando extends.

 Todas as regras básicas de herança, sobreposição e polimorfismo da linguagem Java padrão se aplica da mesma forma.

 As traits vieram para facilitar a criação de estruturas OO que eram implementados usando um padrão verboso, burocrático e trabalhoso chamado de "Java Skeletal Implementations" [Java Effective by Joshua Blosh].

 Usando trait em groovy é possível fazer herançã múltiplas no qual uma classe pode implementar várias traits diferentes herdando métodos concretos de varios lados.

Na linguagem Java até a versão 7, não existia recursos para herança múltiplas.

Em resumo, podemos entender que a trait é uma interface e uma classe abstrata, podemos misturas as duas coisas.

Exercício 13.3:
Vamos começando a criar uma classe groovy Animal e nela colocamos o seguinte

    package classes

    trait Animal {
        String nome
        abstract void pular()
        void falar() {
            println "Animal" + nome + " falando.."
        }
    }

Vamos criar uma outra classe groovy chamado Lutador e nela colocamos o seguinte

    package classes

    trait Lutador {
        String arma
        abstract void correr()
        void lutar() {
            println "Lutador " + arma + " lutando..."
        }
    }

Agora, vamos criar uma outra classe groovy Pessoa e nela colocamos o seguinte

Herança múltipla com trait gera novas regras de OOP inexistentes por programadores Java como por exemplo "Conflito de Herença Múltiplas".

Para todas as informações, acesse o manual oficial do groovy:

    https://groovy-lang.org/objectorientation.html

Na linguagem Java padrão, o nível de visibilidade conhecido como package é indicado com a ausência de qualquer modificador de acesso. No groovy isso não funciona em virtude dos recursos de POGO.

Sendo assim, no código groovy não existe mais esse nível de visibilidade.
