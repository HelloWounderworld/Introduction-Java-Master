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

## Aula 07:

## Aula 08:

## Aula 09:

## Aula 10:

## Aula 11:

## Aula 12:

## Aula 13:

## Aula 14:

## Aula 15:

## Aula 16:

## Aula 17:

## Aula 18: