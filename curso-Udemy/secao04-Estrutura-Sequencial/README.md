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

## Aula 04 - Variáveis e tipos básicos em Java:
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

Daí, quais são os tipos de valores primitivos, donde em Python e JavaScript, são conhecidos como valores imutáveis? São elas

- Tipos númericos inteiros:

    byte
    short
    int long

- Tipos numéricos com ponto flutuante:

    float
    double

- Um caractere Unicode:

    char

- Booleanos:

    boolean

- String:

    string

Os valores e valor padrão vc pode consultar na tabela que se encontra no pdf dessa seção.

As boas práticas para declarar uma variável, basta consultar no pdf.

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

## Aula 08 e 09 - Entrada de dados em Java - Parte 1 e 2:
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
