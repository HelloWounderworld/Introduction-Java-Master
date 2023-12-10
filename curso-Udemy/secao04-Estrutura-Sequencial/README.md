# Seção 04: Estrutura Sequencial

## Aula 01 - Visão geral do capítulo e Aula 02 - Material de apoio do capítulo:
MATERIAL DE APOIO DO CAPÍTULO

Seja muito bem-vindo(a) ao capítulo Estrutura sequencial!

Aqui você pode baixar o material de apoio usado nas aulas do capítulo, para que você possa aproveitar ao máximo as aulas sem precisar ficar anotando muito.

Grande abraço e bons estudos! Nelio.

Seguir os seguintes pdfs

    04-estrutura-sequencial.pdf
    04-estrutura-sequencial(para-anotacoes).pdf

## Aula 03 - Expressões aritméticas:
Vamos ver como é a expressão aritmética!

No caso, como eu já sei Python e JavaScript, então eu irei realizar apenas a codificação do conceito que eu já sei traduzindo para o conceito lexico e sintatico da linguagem java. São elas

    + - Adição
    - - Subtração
    * - Múltiplicação
    / - Divisão
    % - Resto da divisão ("mod") o módulo, em teoria dos números

Agora, a sua precedência seria, em ordem decrescente

    * / %
    + - 

Assim como em Python e JavaScript, a leitura é de esquerda para direita, caso tenha operadores no mesmo nível de precedencia.

A precedência que vai acima de tudo, será o entre parênmteses, ().

## Aula 04 - Variáveis e tipos Básico/Primitivos em Java:
Bom, basicamente a ideia de variáveis e tipos básicos de Java, está no fato de como um programa de computador ele executa as suas contas

• Um programa de computador em execução lida com dados

• Como esses dados são armazenados?

• Em VARIÁVEIS!

Variáveis

Definição informal:

    Em programação, uma variável é uma porção de memória (RAM) utilizada para armazenar dados durante a execução dos programas

Para cada declaração do tipo de variável será criado um espaço no armazenamento da memória ram relativo à essa variável que vc criou

    int idade = 25;
    double altura = 1.83;
    char sexo = ´F´;

E cada variável ela possui um endereço seu único.

Caso quisermos que a variável declarada, o seu valor, não seja mudado ao longo da compilação, bastaria acrescentar a sintaxe "final" no início da declaração de uma variável

    final double pi = 3.14159;

Se compilarmos

    final double pi = 3.14159;
		
	pi = 1;

Isso, irá nos exibir um erro, como podemos ver na classe AreaCircunferencia.java do projeto exercicios.

Bom, uma outra forma de conseguirmos evitar de um certo valor, que queremos que ela seja constante, seja evitada de ser alterada, seria usando uma constante (Será abordado em mais detalhes na Seção 08 da aula 10 e 11). Ou seja, bastaria declarar em letra maíscula

    final double PI = 3.14159;

Como podemos ver na classe AreaCircunferencia.java do projeto exercicio.

Daí, quais são os tipos de valores primitivos, donde em Python e JavaScript, são conhecidos como valores imutáveis?

Temos 8 tipos.

São elas:

- Tipos númericos inteiros: (bytes = capacidade de armazenamento)

    byte // range do bytes é de -128 até 127 - 1 bytes
    short // já do short é +- 32.767 - 2 bytes
    int // temos 4 bytes
    long // 8 bytes

- Tipos numéricos com ponto flutuante:

    float // 4 bytes
    double // 8 bytes

- Um caractere Unicode:

    char

- Booleanos:

    boolean // Por padrão é definido como false

- String:

    string // essa palavra não está guardada no Java - String não é uma chave primitiva - Vamos dar uma atenção espécial para ela na seção Tipo Strings

    String x = "bla" // Jeito certo de declararmos

Os valores e valor padrão vc pode consultar na tabela que se encontra no pdf dessa seção.

As boas práticas para declarar uma variável, basta consultar no pdf.

Se colocarmos o seguinte

    double a = 3;
    double b = 3.2;

No caso, a variável "a" será defido, por padrão, mesmo que usado o double, como int, então será consumido 4 bytes. Já, a variável "b" será consumido 8 bytes, por ser, de fato, um double.

### Obs:

    1 byte <=> 8 bits

Lembrando que, em tipos primitivos, sempre que vc converte algum valor da mesma natureza, numérica, por exemplo, para outra, se será ou não possível, vai ser visto via o tamanho de bytes. Como podemos ver no último exemplo da variável "a" e "b", onde usando o double, foi possível colocar o int, porque o double, ela pode armazenar até 8 bytes, "int < double".

A lógica é o tipo menor sempre pode ser atribuído ao tipo maior.

### Tipo String:
Vamos falar um pouco mais sobre o tipo String, que, ela não é um tipo primitivo, mas, sim, ela é um tipo classe.

Por começo, dentro do projeto, exercicios, no pacote, fundamentos, vamos criar uma classe chamado "TipoString"

    package fundamentos;

    public class TipoString {

        public static void main(String[] args) {
            
        }
    }

Por começo, vamos printar um valor literal

    package fundamentos;

    public class TipoString {

        public static void main(String[] args) {
            System.out.println("Olá pessoal");
            System.out.println("Olá pessoal".charAt(0));
            System.out.println("Olá pessoal".charAt(1));
            System.out.println("Olá pessoal".charAt(2));
            System.out.println("Olá pessoal".charAt(3));
            System.out.println("Olá pessoal".charAt(4));
            System.out.println("Olá pessoal".charAt(5));
        }
    }

Acima, estamos usando o método "charAt" donde colocamos um índice nela e vamos ver que ela, trata a String como uma lista, donde podemos exibir cada caractere onde está na sua posição. Bom, temos uma correspondência entre o conjunto {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10} e {O, l, á, , p, e, s, o, a} que daria uma função que define uma sequência.

Bom, agora, trabalhando com algumas funcionalidades da String

    package fundamentos;

    public class TipoString {

        public static void main(String[] args) {
            System.out.println("Olá pessoal");
            System.out.println("Olá pessoal".charAt(0));
            System.out.println("Olá pessoal".charAt(1));
            System.out.println("Olá pessoal".charAt(2));
            System.out.println("Olá pessoal".charAt(3));
            System.out.println("Olá pessoal".charAt(4));
            System.out.println("Olá pessoal".charAt(5));
            
            String s = "Hello WounderWorld";
            System.out.println(s.concat("!!!"));
            System.out.println(s + "!!!");
        }
    }

Bom, acima, temos o método "concat" que foi usado, porém, podemos fazer a mesma coisa usando o operador "+".

Vamos deixar em mente uma coisa bem importante.

Afirmação:

    String é um objeto imutável

O que significa isso?

Significa que vc nunca, mas nunca, irá conseguir mudar o valor inicial atribuido à uma string. Por exemplo

    package fundamentos;

    public class TipoString {

        public static void main(String[] args) {
            System.out.println("Olá pessoal");
            System.out.println("Olá pessoal".charAt(0));
            System.out.println("Olá pessoal".charAt(1));
            System.out.println("Olá pessoal".charAt(2));
            System.out.println("Olá pessoal".charAt(3));
            System.out.println("Olá pessoal".charAt(4));
            System.out.println("Olá pessoal".charAt(5));
            
            String s = "Hello WounderWorld";
            s = s.toUpperCase();
            s = "Good Morning!";
            System.out.println(s.concat("!!!"));
            System.out.println(s + "!!!");
        }
    }

Nos métodos que eu apliquei acima ou até mesmo troquei o valor, parece que eu mudei o valor original em si. Não se engane, pois eu não mudei o valor, eu troquei elas. Ou seja, o valor em si "Hello WounderWorld" eu não mudei absolutamente nada dela.

Assim, a mesma analogia vale para outros métodos que temos para a classe "String"

    package fundamentos;

    public class TipoString {

        public static void main(String[] args) {
            System.out.println("Olá pessoal");
            System.out.println("Olá pessoal".charAt(0));
            System.out.println("Olá pessoal".charAt(1));
            System.out.println("Olá pessoal".charAt(2));
            System.out.println("Olá pessoal".charAt(3));
            System.out.println("Olá pessoal".charAt(4));
            System.out.println("Olá pessoal".charAt(5));
            
            String s = "Hello WounderWorld";
            s = s.toUpperCase();
            s = "Good Morning";
            System.out.println(s.concat("!!!"));
            System.out.println(s + "!!!");
            System.out.println(s.startsWith("Good"));
            System.out.println(s.startsWith("good"));
            System.out.println(s.toLowerCase().startsWith("good"));
            System.out.println(s.endsWith("Morning"));
            System.out.println(s.endsWith("morning"));
            System.out.println(s.toLowerCase().endsWith("Morning"));
            System.out.println(s.equals("good morning"));
            System.out.println(s.equalsIgnoreCase("good morning"));
            
            var nome = "Leonardo";
            var sobrenome = "Teramatsu";
            var idade = 27;
            var salario = 3000.00;
            
            System.out.println("Nome: " + nome + "\nSobrenome: " + sobrenome + "\nIdade: " + idade + "\nSalario: " + salario);
            System.out.printf("O senhor %s %s tem %d anos e ganha R$ %.2f.", nome, sobrenome, idade, salario);
            
            String frase = String.format("\nO senhor %s %s tem %d anos e ganha R$ %.2f.", nome, sobrenome, idade, salario);
            System.out.println(frase);
        }
    }

### Desafio:
No projeto exercicio, vamos criar uma classe "Temperatura.java" e nela, vamos criar um método de conversão de Celsius para Fahrenheit.

    package fundamentos;

    public class Temperatura {

        public static void main(String[] args) {
                //(ºF - 32) / 9 = ºC / 5
        }
    }

Existem diversas formas de resolvermos esse desafio. Porém, exigimos que deixem claro quem são as constantes e quem são as variáveis com os seus respectivos tipos de valores para resolvermos esse problema!

Vamos praticar mais sobre os Tipos Primitivos na linguagem Java.

Vamos criar uma classe "TiposPrimitivos" e nela vamos colocar o seguinte

    package fundamentos;

    public class TiposPrimitivos {

        public static void main(String[] args) {
            // Informações do funcionário
            
            // Tipos numéricos inteiros
            byte anosDeEmpresa = 23; // se colocar 128 ele dará problema
            short numeroDeVoos = 542; // se colocar acima disso dará problema
            int id = 56789;
            long pontosAcumulados = 1_234_845_223; // Se vc colocar mais que 3 bilhões dará um problema
            pontosAcumulados = 3_234_845_223L; // Você precisa colocar um L (large) caso supere os 3 bilhões
            
            // Tipos numéricos reais
            float salario = 11_445.44F;// Se vc utilizar o float, é necessário colocar o F (pode ser f) no final para indicar que é literal float, e não double
            salario = 1.22F;
            double vendasAcumuladas = 2_991_797_103.01;
            
            // Até agora, temos 6 tipos numéricos básicos.
            
            // Tipo booleano
            boolean estaDeFerias = false; // true
            
            // Tipo caractere
            char status = 'A'; // ativo - Vc pode colocar um tipo de caractere, não pode colocar, por exemplo, 'AT'
    //		char statusDois = '\u0010'; // raras excecoes, vc pode colocar esse tipo de dado que é um tipo de valor da tabela unicode
            
            // Dias de empresas
            System.out.println(anosDeEmpresa * 365);
            
            // Número de viagens
            System.out.println(numeroDeVoos / 2);
            
            // Pontos por real
            System.out.println(pontosAcumulados / vendasAcumuladas);
            
            System.out.println(id + ": ganha -> " + salario);
            System.out.println("Férias? " + estaDeFerias);
            
            System.out.println("Status: " + status);
        }
    }

## Aula 05 - As três operações básicas de programação:
No caso, as três operações básicas de um computador, essencialmente, são

 Entrada de Dados (teclado, mouse) -> Processamento de Dados (Intel chip, Ryzen, IOS, etc...) -> Saída de dados (Exibido pela tela do pc)

Vamos ver uma por uma à fundo nas próximas aulas.

## Aula 06 - Saída de dados em Java:
No caso, a saída de dados seria o momento em que ocorre a exibição da mesma.

Daí, um exemplo, bem ridículo que temos aqui seria quando printamos algo na tela. São elas

    System.out.print("Hello WounderWorld!"); - Sem quebra de linha ao final
    System.out.println("Hello WounderWorld!"); - Com quebra de linha ao final

Agora, o print serve para mostrar as variáveis que foram declaradas tbm da mesma forma

    int y = 32;
	System.out.print(y);
	System.out.println(y);

    double x = 10.35464161;
    System.out.println(x);
    System.out.printf("%.2f"n", x);
    System.out.printf("%.4f"n", x);

Para arredondamento das casas, vamos usar o printf, que seria o format que estudei em Python.

Podemos usar o Locale.setDefault(Locale.US); para podermos mudar de vígula para ponto na representação das casas decimais que foi exibido depois desse comando. Mas, note que, ao vc colocar esse comando na linha de código, ela irá exibir um erro, pois ela é uma classe que necessita de um módulo para importar.

Tanto no Eclipse quanto no VSCode, ao vc passar o mouse por cima desse erro haverá uma opção de correção rápida que automaticamente importará esse módulo

    import java.util.Locale;

Sem a necessidade de importar manualmente.

O operador + tem o mesmo papel de concatenação como em Python e JavaScript

    System.out.println("RESULTADO = "+ x + " METROS");

Uma outra forma de concatenar, no estilo format() que foi visto em Python, seria bem análogo

    System.out.printf("RESULTADO = %f metros %n", x);
	System.out.printf("RESULTADO = %.2f metros %n", x);

"%n" causa a quebra de linha. Em Python, seria "\n".

Vamos fazer um teste

    String nome = "Leonardo";
    int idade = 26;
    double renda = 2400.45646;
    System.out.printf("%s tem %d anos e ganha R$ %.2f reais%n", nome, idade, renda);

note que, cada sigla "%s", "%d" e "%f", corresponde aos tipos de valores primitivos.

## Aula 07 - Processamento de dados em Java, Casting:
O processamento de dados ele é literalmente a atribuição, como foi visto no curso de JavaScript e Python. No caso, a sua estrutura se define o seguinte

- Sintaxe:

    <variável> = <expressão>;

O "=" acima lê e recebe o dado.

Assim como foi visto em JavaScript, em Java, também, é possível declarar uma variável sem atribuição

    int x, y;

    x = 5;

    y = 2 * x;

    System.out.println(x);
    System.out.println(y);

Por algum motivo quando criei um novo projeto no eclipse não rodou o arquivo java. No caso, eu segui esse link para resolver esse problema

    https://cursos.alura.com.br/forum/topico-error-occurred-during-initialization-of-boot-layer-119494

Bom, aqui temos um outro exemplo quando fazemos as operações com um número inteiro e o número flutuante. O resultado é um número flutuante, o mesmo que ocorre para JavaScript e Python

    int x;
    double y;

    x = 5;

    y = 2 * x;

    System.out.println(x);
    System.out.println(y);

Uma boa prática para o uso do double e float, está em seguinte:

- double - se vc usar números que exigem até duas casas decimais

- float - caso vc use muitas casas decimais

Agora, tome cuidado com divisão de números inteiros. No caso, o seguinte exemplo

    int a, b;
    double resultado;

    a = 5;
    b = 2;

    resultado = a / b;

    System.out.println(resultado);

Acima, será printado o número 2, apenas, pois é divisão de inteiros. Então, se vc quiser que seja exibido os valores quebrados, precisa fazer com que o número, mesmo inteiro, seja expresso em variáveis de números flutuantes.

Ou a outra alternativa para resolver esse problema é o seguinte

    resultado = (double) a / c;

Se chama casting.

Da mesma forma, usamos o casting da seguinte forma

    double a;
    int b;
    a = 5.0;
    //		Percebe que está dando erro na forma abaixo
    //		b = a;
    //		Usando o casting teria que corrigir assim
    b = (int) a;
    System.out.println(b);

## Aula 08 e 09 - Entrada de dados em Java - Parte 1 e 2 - Console:
Vamos ver sobre entrada de dados, que é quando vc digita algo pelo teclado, usualmente.

Vamos usar o scanner para realizar a entrada de algum dado

    Scanner sc = new Scanner(System.in);

Bom, a forma de uso é o mesmo. Se tratando de uma classe, então será necessário a importação de um módulo importante para isso. No projeto, curso_programacao, no Main, vamos importar

    Scanner sc = new Scanner(System.in);

    String x ;
    x = sc.next();
    System.out.println("Você digitou: " + x);

    sc.close();
    
No caso, ao rodarmos o código, vc vai ver que ele ficou parado. Mas aí, seria porque ele está esperando que vc coloque alguma coisa nela.

Para ler um número com ponto flutuante

    double x;

    x = sc.nextDouble();

No caso, precisamos tomar cuidado se vamos digitar com vírgula ou ponto o número flutuante, pois dependendo do caso, precisaria usar o Locale.setDefault(Locale.US);.

Para ler um caractere será

    char x;
    x = sc.next().charAt(0);

Como ele pega somente os caracteres, então se vc escrever alguma palavra, ele irá pegar somente o primeiro caractere.

Para ler vários dados na mesma linha seria

    String x;
    int y;
    double z;
    x = sc.next();
    y = sc.nextInt();
    z = sc.nextDouble();

Para ler um texto até a quebra de linha seria o seguinte

    Para ler um texto ATÉ A QUEBRA DE LINHAimport java.util.Scanner;
    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String s1, s2, s3;
            s1 = sc.nextLine();
            s2 = sc.nextLine();
            s3 = sc.nextLine();
            System.out.println("DADOS DIGITADOS:");
            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s3);
            sc.close();
        }
    }

Para quebra de liha pendente do tipo

    int x;
    String s1, s2, s3;
    x = sc.nextInt();
    s1 = sc.nextLine();
    s2 = sc.nextLine();
    s3 = sc.nextLine();
    System.out.println("DADOS DIGITADOS:");
    System.out.println(x);
    System.out.println(s1);
    System.out.println(s2);
    System.out.println(s3);

Se tentarmos digitar os dados como solicitado, vc verá que a variável s1 ficará vazio, pois quando vc digitou o número inteiro e deu enter, esse enter foi contado para a variável s1 como se vc estivesse já atribuido algo valor para ela. E isso fez com que fosse para as variáveis adiantes.

Para resolver esse problema vc dá um outro nextLine antes dessa variável s1

    int x;
    String s1, s2, s3;
    x = sc.nextInt();
    sc.nextLine();
    s1 = sc.nextLine();
    s2 = sc.nextLine();
    s3 = sc.nextLine();
    System.out.println("DADOS DIGITADOS:");
    System.out.println(x);
    System.out.println(s1);
    System.out.println(s2);
    System.out.println(s3);

Passando para esclarecer uma particularidade dos métodos nextInt() e nextDouble(). Ambos os métodos têm a mesma particularidade, mas vou explicá-la através do nextInt() com o exemplo abaixo.

    Scanner teclado = new Scanner(System.in);
 
    System.out.println("Qual a sua idade?");
    int idade = teclado.nextInt();
    System.out.println("Qual o seu nome?");
    String nome = teclado.nextLine();
    System.out.println("Qual o seu sobrenome?");
    String sobrenome = teclado.nextLine();
 
    teclado.close();

À primeira vista, parece que está tudo bem com este código. Mas quando o rodamos, o que é impresso no console (contendo os inputs) é o seguinte:

Qual a sua idade? 25
Qual o seu nome? Qual o seu sobrenome? Silva
Isso acontece por causa da maneira como o nextInt() faz a leitura dos valores.

Esse método faz a leitura de um único número, por exemplo, 58 ou 958. Mas quando digitamos os inputs, além do valor que deve ser lido, também apertamos enter, o que gera um caracter "\n" no buffer de entrada (fila de coisas que devem ser lidas), que é uma representação do enter.

Então, o que acontece é: "Qual a sua idade?" é impresso, digitamos o valor e apertamos enter. Quando fazemos isso, o buffer de entrada fica com o conteúdo "25\n", e quando o nextInt() faz a leitura, ele lê apenas o 25, deixando o "\n" para trás. Depois disso, "Qual o seu nome?" é impresso, e o método nextLine() vai ler tudo que estiver no buffer de entrada até encontrar um "\n". Como o nextInt() deixou um "\n" para trás, é esse o valor que o nextLine() lê. Isso conclui a leitura e a próxima linha de código, que é "Qual o seu sobrenome?", é impressa.

Para resolver esse problema, precisamos "pegar" o "\n" que o nextInt() não lê. Isso pode ser feito colocando um comando nextLine() depois do nextInt(), de modo que o código abaixo vai funcionar da maneira como queríamos.

Scanner teclado = new Scanner(System.in);
 
    System.out.println("Qual a sua idade?");
    int idade = teclado.nextInt();
    teclado.nextLine(); //lê o "\\\\n" que o teclado.nextInt() deixa para trás.
    System.out.println("Qual o seu nome?");
    String nome = teclado.nextLine();
    System.out.println("Qual o seu sobrenome?");
    String sobrenome = teclado.nextLine();
 
    teclado.close();

### Obs:
Seguir a classe "Console" criado no projeto exercicios, dentro do pacote fundamentos. Essa classe, serve como espaço para explorar mais dos recursos.

## Aula 10 - Funções matemáticas em Java:
Vamos ver algumas funções matemáticas!

Bom, vou colocar apenas as sintaxes visto que são intuitivas

    A = Math.sqrt(x); - Raíz quadrada
    A = Math.pow(x, y) - x^y
    A = Math.abs(x) - função módulo de x

Aqui está um modelo de aplicação

    double x = 3.0;
    double y = 4.0;
    double z = -5.0;
    double A, B, C;
    A = Math.sqrt(x);
    B = Math.sqrt(y);
    C = Math.sqrt(25.0);
    System.out.println("Raiz quadrada de " + x + " = " + A);
    System.out.println("Raiz quadrada de " + y + " = " + B);
    System.out.println("Raiz quadrada de 25 = " + C);
    A = Math.pow(x, y);
    B = Math.pow(x, 2.0);
    C = Math.pow(5.0, 2.0);
    System.out.println(x + " elevado a " + y + " = " + A);
    System.out.println(x + " elevado ao quadrado = " + B);
    System.out.println("5 elevado ao quadrado = " + C);
    A = Math.abs(y);
    B = Math.abs(z);
    System.out.println("Valor absoluto de " + y + " = " + A);
    System.out.println("Valor absoluto de " + z + " = " + B)

## Aula 11 - AVISO: exercícios para iniciantes PARTE 1 e Aula 12 - Exercícios para Iniciantes - PARTE 1:
ATENÇÃO ESTUDANTES INICIANTES: se você ainda não sabe Lógica de Programação (em qualquer linguagem) e optou por não adquirir nosso curso "Java primeiros passos - Lógica de Programação e Algoritmos", então você DEVE fazer os exercícios contidos no documento PDF abaixo para que você tenha condição mínima de acompanhar o restante do curso.

ORIENTAÇÕES: no início do documento há links para vídeos no Youtube onde eu resolvo alguns problemas para você ter como exemplo. Assista os vídeos e, em seguida, resolva todos os exercícios propostos. Cada exercício vem acompanhado de correção. Se mesmo assim você tiver alguma dúvida, nos envie uma pergunta.

Abraços e bons estudos! Nelio.

Seguir o arquivo pdf

    02-exercicios1-estrutura-sequencial.pdf

## Aula 13 - Inferência de Tipos:
Vamos falar sobre inferência de tipos que é um recurso que surgiu no lançamento do Java 10.

No projeto de exercícios, vamos criar uma classe chamado "Inferencia".

No caso, a inferência, em Java, é quando vc coloca o seguinte

    package fundamentos;

    public class Inferencia {

        public static void main(String[] args) {
            
            double a = 4.5;
            System.out.println(a);
            
            var b = 4.5;
            System.out.println(b);
        }
    }

Note que, acima, temos a variável "double", donde deixa claro o tipo de variável que vc está colocando. Enquanto que na variável "b", foi utilizado o "var" e foi colocado o mesmo tipo de número.

No caso, a inferência aqui é quando vc usa esse "var" e, de acordo com o tipo de valor que vc colocar na variável, a linguagem Java, ela infere para determinar qual o tipo de valor que foi colocado.

Ou seja, podemos realizar a mesma coisa para outros tipos de valores, como podemos ver abaixo

    package fundamentos;

    public class Inferencia {

        public static void main(String[] args) {
            
            double a = 4.5;
            System.out.println(a);
            
            var b = 4.5;
            System.out.println(b);
            
            var c = "Texto";
            System.out.println(c);
            
            c= "Outro texto";
            System.out.println(c);
        }
    }

Abaixo, no uso de "var" para a variável "c", foi utilizado uma string. No momento em que é processado, será inferido que foi utilizado uma String.

Agora, o que vc não pode fazer no uso da inferência de uma variável, é de colocar um outro tipo de valor em uma variável que já foi inferido uma vez

    package fundamentos;

    public class Inferencia {

        public static void main(String[] args) {
            
            double a = 4.5;
            System.out.println(a);
            
            var b = 4.5;
            System.out.println(b);
            
            var c = "Texto";
            System.out.println(c);
            
            c= "Outro texto";
            System.out.println(c);
            
            c = 4.5;
        }
    }

Como podemos ver acima, na variável "c", que foi inferido uma vez uma string, vc não pode definir um valor float nela.

Ou seja, em Java, uma vez que ela está amarrado à um tipo, vc não pode alterar ela ao longo do processo. Não é que nem JavaScript.

O mesmo, obviamente, vale para outros tipos de variáveis que são definidos sem a inferência

    package fundamentos;

    public class Inferencia {

        public static void main(String[] args) {
            
            double a = 4.5;
            System.out.println(a);
            
            a = 12;
            System.out.println(a);
            
    //		a = "...";
            
            var b = 4.5;
            System.out.println(b);
            
            var c = "Texto";
            System.out.println(c);
            
            c= "Outro texto";
            System.out.println(c);
            
    //		c = 4.5;
        }
    }

Podemos ver que a variável "a", que está definido como double, foi colocado à ela um valor inteiro, mas o que será retornado no console será "12.0".

Uma outra coisa que não podemos fazer usando "var" para inferir algum valor, seria em declarar alguma variável, diferentemente na forma como é definido uma variável sem usar a inferencia

    package fundamentos;

    public class Inferencia {

        public static void main(String[] args) {
            
            double a = 4.5; //declaracao da variavel e inicializacao da mesma
            System.out.println(a);
            
            a = 12;
            System.out.println(a);
            
    //		a = "... ";
            
            var b = 4.5;
            System.out.println(b);
            
            var c = "Texto";
            System.out.println(c);
            
            c= "Outro texto";
            System.out.println(c);
            
    //		c = 4.5;
            
            double d; // variavel foi declarada
            d = 123.65; // variavel foi inicializada
            System.out.println(d); // variavel foi usada
            
    //		var e; // Não é possível declarar uma variavel usando o var
    //		e = 123.65;
            var e = 123.65;
            System.out.println(e);
        }
    }

Como podemos ver acima na comparação entre a variável "d" e "e", onde, a primeira, é declarada, em seguida inicializada e, depois, usada, sendo que na segunda, com o uso do "var", no momento em que ela é declarada já precisa ser inicializada tbm.

Bom, lembrando, novamente, que visto que a linguagem de programação Java é de tipagem forte, então, uma vez que vc define um tipo não pode ser convertido em outra, exceto de for de double usando um int dentro dela, mas não o inverso, como podemos ver na variável "f" abaixo

    package fundamentos;

    public class Inferencia {

        public static void main(String[] args) {
            
            double a = 4.5; //declaracao da variavel e inicializacao da mesma
            System.out.println(a);
            
            a = 12;
            System.out.println(a);
            
    //		a = "... ";
            
            var b = 4.5;
            System.out.println(b);
            
            var c = "Texto";
            System.out.println(c);
            
            c= "Outro texto";
            System.out.println(c);
            
    //		c = 4.5;
            
            double d; // variavel foi declarada
            d = 123.65; // variavel foi inicializada
            System.out.println(d); // variavel foi usada
            
    //		var e; // Não é possível declarar uma variavel usando o var
    //		e = 123.65;
            var e = 123.65;
            System.out.println(e);
            
            var f = 12;
    //		f = 12.01;
            System.out.println(f);
        }
    }

Podemos ver que, na variável "a", se ela for definido como double, mesmo vc atribuindo um valor inteiro nela, ela reconhecerá como um double, mas o inverso não funciona. Ou seja, uma vez que vc define um inteiro, vc não consegue atribuir um valor double nela.

## Aula 14 - Notação Ponto:
Bom, o uso do ponto, ".", dentro do programa Java é extremamente importante e relevante.

Para aprofundarmos mais no assunto, vamos criar uma classe "NotacaoPonto", que será usada para explicarmos a importância disso

    package fundamentos;

    public class NotacaoPonto {

        public static void main(String[] args) {
            
            double a = 2.3;
            String s = "Bom dia X";
            
            
        }
    }

Note que, quando pegamos a variável "s" que foi definida acima e fazemos "s.", ou seja, colocamos o ponto, ".", podemos ver que irá aparecer vários métodos nativos do Java que podemos aplicar sobre ela. Escolhemos o "toUpperCase()" como segue

    package fundamentos;

    public class NotacaoPonto {

        public static void main(String[] args) {
            
            double a = 2.3;
            String s = "Bom dia X";
            
            System.out.println(s.toUpperCase());
            System.out.println(s); // Note que, o método "toUpperCase()" aplicado, não foi permanente
            
            s = s.toUpperCase();
            System.out.println(s);
        }
    }

Da mesma forma, a lógica serve para outros métodos que temos de nativos para podermos aplicar sobre a String

    package fundamentos;

    public class NotacaoPonto {

        public static void main(String[] args) {
            
            double a = 2.3;
            String s = "Bom dia X";
            
            System.out.println(s.toUpperCase());
            System.out.println(s); // Note que, o método "toUpperCase()" aplicado, não foi permanente
            
            s = s.toUpperCase();
            System.out.println(s);
            
            System.out.println(s.replace("X", "WounderWorld!"));
            System.out.println(s);
            
            s = s.replace("X", "WounderWorld!");
            System.out.println(s);
            
            s = s.concat("?????");
            System.out.println(s);
            
            System.out.println("Leo".toUpperCase());
            
            String x = "Leo".toUpperCase();
            System.out.println(x);
            
            String y = "Bom dia X".replace("X", "Lupin");
            System.out.println(y);
        }
    }

Porém, podemos ver que, esse uso de ponto, pode ser algo sequencial. Ou seja, podemos aplicar de forma em série

    package fundamentos;

    public class NotacaoPonto {

        public static void main(String[] args) {
            
            double a = 2.3;
            String s = "Bom dia X";
            
            System.out.println(s.toUpperCase());
            System.out.println(s); // Note que, o método "toUpperCase()" aplicado, não foi permanente
            
            s = s.toUpperCase();
            System.out.println(s);
            
            System.out.println(s.replace("X", "WounderWorld!"));
            System.out.println(s);
            
            s = s.replace("X", "WounderWorld!");
            System.out.println(s);
            
            s = s.concat("?????");
            System.out.println(s);
            
            System.out.println("Leo".toUpperCase());
            
            String x = "Leo".toUpperCase();
            System.out.println(x);
            
            String y = "Bom dia X"
                    .replace("X", "Lupin")
                    .toUpperCase()
                    .concat("!!!");
            System.out.println(y);
        }
    }

A ordem de execução é de esquerda para a direita. Ou seja, "replace", em seguida, "toUpperCase" e, por fim, "concat".

Lembrando que, todo esse processo fizemos sobre String, que não é um valor primitivo. Em um valor primitivo, esse ponto, não funciona

    package fundamentos;

    public class NotacaoPonto {

        public static void main(String[] args) {
            
    //		double a = 2.3;
            String s = "Bom dia X";
            
            System.out.println(s.toUpperCase());
            System.out.println(s); // Note que, o método "toUpperCase()" aplicado, não foi permanente
            
            s = s.toUpperCase();
            System.out.println(s);
            
            System.out.println(s.replace("X", "WounderWorld!"));
            System.out.println(s);
            
            s = s.replace("X", "WounderWorld!");
            System.out.println(s);
            
            s = s.concat("?????");
            System.out.println(s);
            
            System.out.println("Leo".toUpperCase());
            
            String x = "Leo".toUpperCase();
            System.out.println(x);
            
            String y = "Bom dia X"
                    .replace("X", "Lupin")
                    .toUpperCase()
                    .concat("!!!");
            System.out.println(y);
            
            // Tipos primitivos não tem o operador "."
            int a = 3;
            System.out.println(a);
        }
    }

Ou seja, na variável inteiro "a" acima, se fizermos "a.", não irá aparecer nada.

## Aula 15 - Import:
Vamos falar um pouco sobre o import.

O "import", basicamente, ela serve para conseguirmos importar classes para outras classes. Isso tem tudo haver com o conceito de orientação à objetos, pois esse processo de "import" ela serve para vc conseguir apontar um objeto para o outro de fora unívoca ou biunívoca. Bom, em teoria das categorias, isso, provavelmente, são chamados de funtores.

Para explicarmos, de forma breve, sobre esse conceito, vamos criar uma classe chamado "Import"

    package fundamentos;

    public class Import {

        public static void main(String[] args) {
            
        }
    }

Bom, por começo, temos o caso de podermos usar a "String" que é algo nativo dentro da linguagem de programação Java, que é um caso em que não temos necessidade de importarmos nada à respeito

    package fundamentos;

    public class Import {

        public static void main(String[] args) {
            String s = "Hello WounderWorld!";
            System.out.println(s);
        }
    }

Porém, se eu tiver que usar um tipo "Date", como segue, para podermos realizar o uso dela, teremos, sim, que importar a tal classe para podermos aplicar os métodos definidos dentro dela

    package fundamentos;

    public class Import {

        public static void main(String[] args) {
            String s = "Hello WounderWorld!";
            System.out.println(s);
            
            Date d = new Date();
            System.out.println(d);
        }
    }

Se tentarmos executar na forma como está acima, teremos um grande problema, pois, mesmo que a classe Date, exista dentro da lingugem de programação Java, ela não existe como algo nativo. Então, o "Date" não será reconhecido pela linguagem Java. Para resolvermos isso, precisamos importar o "Date".

    package fundamentos;

    import java.util.Date;

    public class Import {

        public static void main(String[] args) {
            String s = "Hello WounderWorld!";
            System.out.println(s);
            
            Date d = new Date();
            System.out.println(d);
        }
    }

Conseguimos, agora, exibir.

Caso você queria construir uma interface gráfica em Java, temos a classe que existe em Java, mas não é nativo, que é o "JButton", quando digitamos o "JButton" e darmos "Ctrl + Space", será mostrado a opção de importação automatica

    package fundamentos;

    import java.util.Date;

    import javax.swing.JButton;

    public class Import {

        public static void main(String[] args) {
            String s = "Hello WounderWorld!";
            System.out.println(s);
            
            Date d = new Date();
            System.out.println(d);
            
            JButton botao = new JButton();
        }
    }

Bom, como podemos notar, nem tudo está disponível na linguagem Java de forma nativa, ao ponto de algumas coisas termos a necessidade de ter que importar.

Note que, como exemplo, a classe "String", ela é uma classe, e não um valor primitivo. Porém, sempre que usamos ela, não temos a necessidade de importar a mesma. Porém, podemos mostrar em qual path essa classe "String" ela pertence

    package fundamentos;

    import java.util.Date;

    import javax.swing.JButton;

    public class Import {

        public static void main(String[] args) {
            java.lang.String b = "Path onde a classe String pertence dentro do Java";
            System.out.println(b);
            
            String s = "Hello WounderWorld!";
            System.out.println(s);
            
            Date d = new Date();
            System.out.println(d);
            
            JButton botao = new JButton();
        }
    }

O mesmo vale para a classe "System", como segue

    package fundamentos;

    import java.util.Date;

    import javax.swing.JButton;

    public class Import {

        public static void main(String[] args) {
            java.lang.String b = "Path onde a classe String pertence dentro do Java";
            java.lang.System.out.println(b);
            
            String s = "Hello WounderWorld!";
            System.out.println(s);
            
            Date d = new Date();
            System.out.println(d);
            
            JButton botao = new JButton();
        }
    }

Além disso, podemos notar que a forma como importamos uma classe ela é feita importanto a path inteira. Isso, pode ser útil, pois caso exista duas classes com o mesmo nome, mas com o caminho diferente, podemos importar as duas classes em uma mesma classe sem termos o problema de conflito.

## Aula 16 - Objeto vs Prmitivo - Wrappers:
Sobre wrappers, temos uma abordagem desse conceito na seção 10 da aula 12 pela frente. Porém, vamos dar uma breve introdução da mesma.

Vamos começando por criar a classe "PrimitivoVsObjeto" dentro do projeto exercicios, do pacote fundmentos

    package fundamentos;

    public class PrimitivosVsObjetos {

        public static void main(String[] args) {
            
        }
    }

Já foi discutido que, em Java, temos 8 tipos de valores primitivos, sendo 6 numéricos, 1 booleano e 1 char.

Vamos que, quando usamos a classe "String", vimos que conseguimos ter acessos aos métodos definidos dentro dessa classe. Porém, para os tipos primitivos, vimos que não

    package fundamentos;

    public class PrimitivosVsObjetos {

        public static void main(String[] args) {
            
            String s = new String("Texto");
            s.toUpperCase();
            
            // Wrappers - são a versão objeto dos tipos primitivos!
            int a = 123;
            System.out.println(a);
        }
    }

No caso, os wrappers, basicamente, são objetos dos tipos primitivos. Ou seja, é um objeto que simula um valor primitivo, mas, por ser um objeto, te permite aplicar os métodos dentro dela.

Bom, para melhor aprofundarmos nesse conceito, vamos criar uma nova classe dentro do projeto, exercicios, e dentro do pacote, fundamentos, chamado "Wrapper"

    package fundamentos;

    public class Wrapper {

        public static void main(String[] args) {
            
        }
    }
