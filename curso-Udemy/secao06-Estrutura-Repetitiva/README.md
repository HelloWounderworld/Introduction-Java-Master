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
    • F6
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

## Aula 11 - Teste de mesa com estrutura repetitiva para:
O mesmo que foi feito para o while na aula 05.

## Aula 12 - Exercícios de testes de mesa com for, Aula 13 - AVISO: exercícios para iniciantes PARTE 4 e Aula 14 - Exercícios para iniciantes PARTE 4:
ATENÇÃO ESTUDANTES INICIANTES: se você ainda não sabe Lógica de Programação (em qualquer linguagem) e optou por não adquirir nosso curso "Java primeiros passos - Lógica de Programação e Algoritmos", então você DEVE fazer os exercícios contidos no documento PDF abaixo para que você tenha condição mínima de acompanhar o restante do curso.

ORIENTAÇÕES: no início do documento há links para vídeos no Youtube onde eu resolvo alguns problemas para você ter como exemplo. Assista os vídeos e, em seguida, resolva todos os exercícios propostos. Cada exercício vem acompanhado de correção. Se mesmo assim você tiver alguma dúvida, nos envie uma pergunta.

Abraços e bons estudos! Nelio.

Recursos para esta aula

    02-exercicios4-estrutura-for.pdf

## Aula 15 - Estrutura repetitiva faça-enquanto (do-while):
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
