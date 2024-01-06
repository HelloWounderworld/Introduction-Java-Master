# Seção 06: Estruturas Repetitivas:

## Aula 01 - Visão geral do capítulo e Aula 02 - Material de apoio do capítulo:
MATERIAL DE APOIO DO CAPÍTULO

Seja muito bem-vindo(a) ao capítulo Estruturas repetitivas!

Aqui você pode baixar o material de apoio usado nas aulas do capítulo, para que você possa aproveitar ao máximo as aulas sem precisar ficar anotando muito.

Grande abraço e bons estudos! Nelio.

Recursos para esta aula

    06-estruturas-repetitivas(para-anotacoes).pdf
    06-estruturas-repetitivas.pdf

## Aula 03 - Como utilizar o DEBUG no Eclipse (execução passo a passo):
Vamos aprender a utilizar o Debug do Eclipse.

Bom, usaremos o seguinte código como exemplo 

    import java.util.Locale;
    import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            Locale.setDefault(Locale.US);
            Scanner sc = new Scanner(System.in);
            double largura = sc.nextDouble();
            double comprimento = sc.nextDouble();
            double metroQuadrado = sc.nextDouble();
            double area = largura * comprimento;
            double preco = area * metroQuadrado;
            System.out.printf("AREA = %.2f%n", area);
            System.out.printf("PRECO = %.2f%n", preco);
            sc.close();
        }
    }

E os passos para conseguirmos utilizar o debug seria o seguinte

    •Para marcar uma linha de breakpoint:
    • Run -> Toggle Breakpoint
    •Para iniciar o debug:
    • Botão direito na classe -> Debug as -> Java Application
    •Para executar uma linha:
    • F6 ou F8 (caso vc queira pular para o próximo breakpoint)
    •Para interromper o debug:

## Aula 04 - Estrutura repetitiva enquanto (while):
Vamos ver apenas a sua sintaxe, pois o uso é o mesmo que no JavaScript e Python.

No caso, a sua estrutura é o seguinte

    while ( condição ) {
        comando 1
        comando 2
    }

Um exemplo para rodar esse comando é o seguinte

    Scanner sc = new Scanner(System.in);

    int x = sc.nextInt();

    int soma = 0;
    while (x != 0) {
        soma += x;
        x = sc.nextInt();
    }
    System.out.println(soma);
    sc.close();

### While Determinado:
Por começo, vamos criar uma classe "WhileDeterminado" dentro do projeto "exercicios" do pacote "controle".

    package controle;

    public class WhileDeterminado {

        public static void main(String[] args) {
            
        }
    }

Suponhamos que queiramos repetir o "System.out.println("Bom dia!");" dez vezes. Não iremos colocar 10 linhas desse print, que seria o jeito analógico.

No caso, vamos usar o "while" para facilitar isso da seguinte forma

    package controle;

    public class WhileDeterminado {

        public static void main(String[] args) {
            
            int soma = 0;
            while (soma < 10) {
                System.out.println("Bom dia!");
                soma += 1;
            }
        }
    }

Ou seja, eu defini uma variável "soma", donde coloquei uma condição dentro do "while" que ela avalia se continua ou não repetindo o processo por via de true ou false.

No caso, a ideia de while Determinado, agora, é explicado. Ou seja, é um while que tem uma condição nela e, enquanto essa condição for verdadeira, ela repete o processo.

Tem que tomar cuidado com a condição que colocamos no while, pois, ela poderia, muito bem, tornar um loop infinito, caso eu coloque uma condição que não mude

    package controle;

    public class WhileDeterminado {

        public static void main(String[] args) {
            
            while (true) {
                System.out.println("Bom dia!");
            }
        }
    }

Loop infinito acima!

Por isso, como uma boa prática, se tivermos alguma estrutura determinada, em vez de usar o While, é recomendável que seja usado o for!

### Desafio - Exercício - While Indeterminado:
Vamos usar o while para conseguirmos determinar uma condição indeterminada.

No caso, o desafio é estabelecer o uso do while em uma condição indeterminada de quantidade de repetições.

Quero que vc crie um Scanner que nesse input, ela sempre te exige que vc digite algo eternamente, exceto, caso vc digite "sair"

    package controle;

    import java.util.Scanner;

    public class WhileIndeterminado {

        public static void main(String[] args) {
            
            Scanner entrada = new Scanner(System.in);
            
            String valor = "";
            
            while(!valor.equalsIgnoreCase("sair")) {
                System.out.print("Você diz: ");
                valor = entrada.nextLine();
            }
            
            entrada.close();
        }
    }

### Outro desafio usando o while:
O desafio é determinar a média de nota do aluno da sala de aula.

Vamos criar a classe "DesafioWhile" e nela coloquemos o seguinte

    package controle;

    import java.util.Scanner;

    public class DesafioWhile {

        public static void main(String[] args) {
            
            Scanner entrada = new Scanner(System.in);
            
            int quantidadeDeNotas = 0;
            double nota = 0;
            double total = 0;
            
            while(nota != -1) {
                
            }
            
            // Calcular a média
            double media = total / quantidadeDeNotas;
            System.out.println("Média = " + media);
            
            entrada.close();
        }
    }

Estrutura básica acima para começar com o desafio.

Resposta, conferir no projeto "exercicio" do pacote "controle" da classe "DesafioWhile".

## Aula 05 - Teste de mesa com estrutura repetitiva enquanto:
No caso, o teste de mesa manual é vc conseguir simular por escrita os passos de execução. É aquele negócio que eu aprendi em Python na faculdade.

## Aula 07 - Exercícios de teste de mesa com while, Aula 08 - AVISO: exercícios para iniciantes PARTE 3 e Aula 09 - Exercícios para Iniciantes - PARTE 3:
ATENÇÃO ESTUDANTES INICIANTES: se você ainda não sabe Lógica de Programação (em qualquer linguagem) e optou por não adquirir nosso curso "Java primeiros passos - Lógica de Programação e Algoritmos", então você DEVE fazer os exercícios contidos no documento PDF abaixo para que você tenha condição mínima de acompanhar o restante do curso.

ORIENTAÇÕES: no início do documento há links para vídeos no Youtube onde eu resolvo alguns problemas para você ter como exemplo. Assista os vídeos e, em seguida, resolva todos os exercícios propostos. Cada exercício vem acompanhado de correção. Se mesmo assim você tiver alguma dúvida, nos envie uma pergunta.

Abraços e bons estudos! Nelio.

Recursos para esta aula

    02-exercicios3-estrutura-while.pdf

## Aula 10 - Estrutura repetitiva para (for):
Vamos ver somente a sintaxe dessa estrutura for

    for ( início ; condição ; incremento) {
        comando 1
        comando 2
    }

Ou seja, é a mesma estrutura que foi visto em JavaScript.

Um exemplo disso seria o seguinte

    for (int i=0; i<5; i++) {
        System.out.println("Valor de i: " + i);
    }

    for (int i=4; i>=0; i--) {
        System.out.println("Valor de i: " + i);
    }

Vamos criar uma classe "For1" para projeto "exercicios" do pacote "controle", por começo

    package controle;

    public class For1 {

        public static void main(String[] args) {
            
        }
    }

Daí, vamos realizar a mesma coisa que foi feito na classe "WhileDeterminado" para esse cenário

    package controle;

    public class For1 {

        public static void main(String[] args) {
            
            for (int soma = 0; soma < 10; soma += 1) {
                System.out.println("Bom dia!");
            }
        }
    }

Também, estruturalmente, conseguimos fazer uma coisa parecida com o while determinado

    package controle;

    public class For1 {

        public static void main(String[] args) {
            
            for(int soma = 0; soma < 10; soma ++) {
                System.out.println("Bom dia!");
                System.out.printf("soma = %d\n", soma);
            }
            
            int x = 2;
            for(;x < 10;) {
                System.out.println("x = " + x);
                x++;
            }
        }
    }

Com o "for" também, conseguimos criar uma laço infinito da seguinte forma

    package controle;

    public class For1 {

        public static void main(String[] args) {
            
            for(int soma = 0; soma < 10; soma ++) {
                System.out.println("Bom dia!");
                System.out.printf("soma = %d\n", soma);
            }
            
            int x = 2;
            for(;x < 10;) {
                System.out.println("x = " + x);
                x++;
            }
            
            for(;;) {
                System.out.println("Loop infinity! Version 1");
            }

            for(;true;) {
                System.out.println("Loop infinity! Version 2");
            }
        }
    }

### For2 - Determinado e decrescente:
Seguir a classe "For2" do projeto "exercicios" do pacote "controle".

### For3 - for dentro do for:
Seguir a classe "For3" do projeto "exercicios" do pacote "controle".

### Desafio:
Seguir a classe "DesafioFor" do projeto "exercicios" do pacote "controle".

Considere o seguinte código abaixo

    String valor = "#";
    for(int i = 1; i <= 5; i++) {
        System.out.println(valor);
        valor += "#";
    }

Realizar o mesmo sem que vc use o valor numério para controlar o laço.

## Aula 11 - Teste de mesa com estrutura repetitiva para:
O mesmo que foi feito para o while na aula 05.

## Aula 12 - Exercícios de testes de mesa com for, Aula 13 - AVISO: exercícios para iniciantes PARTE 4 e Aula 14 - Exercícios para iniciantes PARTE 4:
ATENÇÃO ESTUDANTES INICIANTES: se você ainda não sabe Lógica de Programação (em qualquer linguagem) e optou por não adquirir nosso curso "Java primeiros passos - Lógica de Programação e Algoritmos", então você DEVE fazer os exercícios contidos no documento PDF abaixo para que você tenha condição mínima de acompanhar o restante do curso.

ORIENTAÇÕES: no início do documento há links para vídeos no Youtube onde eu resolvo alguns problemas para você ter como exemplo. Assista os vídeos e, em seguida, resolva todos os exercícios propostos. Cada exercício vem acompanhado de correção. Se mesmo assim você tiver alguma dúvida, nos envie uma pergunta.

Abraços e bons estudos! Nelio.

Recursos para esta aula

    02-exercicios4-estrutura-for.pdf

## Aula 15 - Estrutura repetitiva faça-enquanto (do/while):
A lógica é o mesmo que eu ví em JavaScript.

A estrutura sintatica é o mesmo

    do {
        comando 1
        comando 2
    } while ( condição );

Um exemplo desse uso

    import java.util.Locale;
    import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {

            Locale.setDefault(Locale.US);
            Scanner sc = new Scanner(System.in);

            char resp;

            do {
            System.out.print("Digite a temperatura em Celsius: ");
            double C = sc.nextDouble();
            double F = 9.0 * C / 5.0 + 32.0;
            System.out.printf("Equivalente em Fahrenheit: %.1f%n", F);
            System.out.print("Deseja repetir (s/n)? ");
            resp = sc.next().charAt(0);
            } while (resp != 'n');
            sc.close();
        }
    }

Vamos criar uma classe "DoWhile" no projeto "exercicios" do pacote "controle" e, nela, vamos realizar o seguinte

    package controle;

    public class DoWhile {

        public static void main(String[] args) {
            // if(...) sentença; ou {}
            // while(...) sentença; ou {}
            // for(...;...;...) sentença; ou {}
            
            // do sentença; ou {} while(...);
        }
    }

Daí, vamos escrever o seguinte

    package controle;

    import java.util.Scanner;

    public class DoWhile {

        public static void main(String[] args) {
            // if(...) sentença; ou {}
            // while(...) sentença; ou {}
            // for(...;...;...) sentença; ou {}
            
            // do sentença; ou {} while(...);
            
            Scanner entrada = new Scanner(System.in);
            
            String texto = "";
            
            do {
                System.out.println("Você precisa falar as palavras mágicas...");
                System.out.println("Quer sair?");
                texto = entrada.nextLine();
            } while(!texto.equalsIgnoreCase("A vara que raba!!"));
            
            System.out.println("Obrigado!");
            entrada.close();
        }
    }

## Aula 16 - Break:
Seguir a classe "Break" e "BreakRotulado" do projeto "exercicios" do pacote "controle".

Estudei muito bem esse conceito em Python.

As boas práticas nos informam em tentar usar menos vezes possível o break...

## Aula 16 - Continue:
Seguir a classe "Continue" e "ContinueRotulado" do projeto "exercicios" do pacote "controle".

Estudei muito bem esse conceito em Python.

As boas práticas nos informam em tentar usar menos vezes possível o continue...

## Aula 17 - Mais exercícios de controle:
Estruturas de Controle

1. Criar um programa que receba um número e verifique se ele está entre 0 e 10 e é par;

2. Criar um programa informa se o ano atual é um ano bissexto;

3. Criar um programa que receba duas notas parciais, calcular a média final. Se a nota do aluno for maior ou igual a 7.0 imprime no console "Aprovado", se a nota for menor que 7.0 e maior do que 4.0 imprime no console "Recuperação", caso contrário imprime no console "Reprovado".

4. Criar um programa que receba um número e diga se ele é um número primo.

5. Refatorar o exercício 04, utilizando a estrutura switch.

6. Jogo da adivinhação: Tentar adivinhar um número entre 0 - 100. Armazene um numero aleatório em uma variável. O Jogador tem 10 tentativas para adivinhar o número gerado. Ao final de cada tentativa, imprima a quantidade de tentativas restantes, e imprima se o número inserido é maior ou menor do que o número armazenado.

7. Criar um programa que enquanto estiver recebendo números positivos, imprime no console a soma dos números inseridos, caso receba um número negativo, encerre o programa. Tente utilizar a estrutura do while.

8. Criar um programa que receba uma palavra e imprime no console letra por letra.

9. Crie um programa que recebe 10 valores e ao final imprima o maior número.

Seguir o link:

    https://github.com/cod3rcursos/fundamentos-programacao-java/tree/master/CursoJavaExercicios/src/controle
