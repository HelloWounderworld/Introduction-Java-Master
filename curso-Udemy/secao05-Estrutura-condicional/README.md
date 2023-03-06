# Seção 05: Estrutura Condicional

## Aula 01 - Visão geral do capítulo e Aula 02 - Material de apoio do capítulo:
MATERIAL DE APOIO DO CAPÍTULO

Seja muito bem-vindo(a) ao capítulo Estrutura condicional!

Aqui você pode baixar o material de apoio usado nas aulas do capítulo, para que você possa aproveitar ao máximo as aulas sem precisar ficar anotando muito.

Grande abraço e bons estudos! Nelio.

Seguir os arquivos em pdf

    05-estrutura-condicional(para-anotacoes).pdf
    05-estrutura-condicional.pdf

## Aula 03 - Expressões comparativas e Aula 04 - Expressões lógicas:
São elas

    > maior
    < menor
    >= maior ou igual
    <= menor ou igual
    == igual
    != diferente

A funcionalidade é a mesma que foi visto em Python e JavaScript.

Operadores lógicos são

    && - and
    || - or
    ! - not

## Aula 05 - Estrutura condicional (if-else):
Vamos ver como é a sua sintaxe

    if ( condição 1 ) {
    comando 1
    comando 2
    }
    else if ( condição 2 ) {
    comando 3
    comando 4
    } 
    else if ( condição 3 ) {
    comando 5
    comando 6
    }
    else {
    comando 7
    comando 8
    }

O uso é análogo com o Python e JavaScript.

Um exemplo de aplicação

    int x = -5;

    System.out.println("Bom dia");

    if(x > 0) {
        System.out.println("Boa Tarde");
    }

    System.out.println("Boa Noite");

Bom, por desencargo de consciência, a estrutura condicional simples é quando vc usa somente o if, a composta é quando vc usa (if, else if e else) ou (if e else).

## Aula 06 - AVISO: exercícios para iniciantes PARTE 2 e Aula 07 - Exercícios para Iniciantes - PARTE 2:
ATENÇÃO ESTUDANTES INICIANTES: se você ainda não sabe Lógica de Programação (em qualquer linguagem) e optou por não adquirir nosso curso "Java primeiros passos - Lógica de Programação e Algoritmos", então você DEVE fazer os exercícios contidos no documento PDF abaixo para que você tenha condição mínima de acompanhar o restante do curso.

ORIENTAÇÕES: no início do documento há links para vídeos no Youtube onde eu resolvo alguns problemas para você ter como exemplo. Assista os vídeos e, em seguida, resolva todos os exercícios propostos. Cada exercício vem acompanhado de correção. Se mesmo assim você tiver alguma dúvida, nos envie uma pergunta.

Abraços e bons estudos! Nelio.

Seguir o pdf

    02-exercicios2-estrutura-condicional.pdf

## Aula 08 - Sintaxe opcional - operadores de atribuição cumulativa:
No caso, já vi isso em JavaScript e Python e é a mesma coisa

    a += b; a = a + b;
    a -= b; a = a - b;
    a *= b; a = a * b;
    a /= b; a = a / b;
    a %= b; a = a % b;

No caso, um exemplo disso é

    import java.util.Locale;
    import java.util.Scanner;
    public class Main {
        public static void main(String[] args) {
            Locale.setDefault(Locale.US);
            Scanner sc = new Scanner(System.in);
            int minutos = sc.nextInt();
            double conta = 50.0;
            if (minutos > 100) {
            conta += (minutos - 100) * 2.0;
            }
            System.out.printf("Valor da conta = R$ %.2f%n", conta);
            sc.close();
        }
    }


## Aula 09 - Sintaxe opcional - switch-case:
O switch case é o mesmo uso que foi visto em JavaScript.

Seguir a sintaxe

    import java.util.Scanner;
    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int x = sc.nextInt();
            String dia;
            if (x == 1) {
                dia = "domingo";
            }
            else if (x == 2) {
                dia = "segunda";
            }
            else if (x == 3) {
                dia = "terca";
            }
            else if (x == 4) {
                dia = "quarta";
            }
            else if (x == 5) {
                dia = "quinta";
            }
            else if (x == 6) {
                dia = "sexta";
            }
            else if (x == 7) {
                dia = "sabado";
            }
            else {
                dia = "valor invalido";
            }
            System.out.println("Dia da semana: " + dia);
            sc.close();
        }
    }

e como ficaria em switch-case

    import java.util.Scanner;
    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int x = sc.nextInt();
            String dia;
            switch (x) {
                case 1:
                    dia = "domingo";
                    break;
                case 2:
                    dia = "segunda";
                    break;
                case 3:
                    dia = "terca";
                    break;
                case 4:
                    dia = "quarta";
                    break;
                case 5:
                    dia = "quinta";
                    break;
                case 6:
                    dia = "sexta";
                    break;
                case 7:
                    dia = "sabado";
                    break;
                default:
                    dia = "valor invalido";
                    break;
            }
            System.out.println("Dia da semana: " + dia);
            sc.close();
        }
    }

## Aula 10 - Expressão condicional ternária:
A ternária é o mesmo que vimos em JavaScript

    ( condição ) ? valor_se_verdadeiro : valor_se_falso

Um exemplo disso

    double preco = 34.5;
    double desconto = (preco < 20.0) ? preco * 0.1 : preco * 0.05;

## Aula 11 - Escopo e inicialização:
No caso, a nível de variável, que é o básico, precisamos sempre que uma variável seja inicializada

    double price = sc.nextDouble();
    if (price > 100.0) {
        double discount = price * 0.1;
    }
    System.out.println(discount);

Lembrando que o Java ele é uma linguagem de escopo por bloco. Ou seja, o código acima não funcionará, pois a variável discount foi criada dentro da condicional if e quando chamamos ela fora desse bloco o programa não irá reconhecer. Para corrigirmos isso teríamos que declarar essa mesma variável fora do if já com algum valor definido

    double price = sc.nextDouble();
    double discount = 0;
    if (price > 100.0) {
        discount = price * 0.1;
    }
    System.out.println(discount);

Ou a outra alternativa que podemos usar, caso seja necessário somente declarar a variável seria usando a estrutura composta de condicionais

    double price = sc.nextDouble();
    double discount;
    if (price > 100.0) {
        discount = price * 0.1;
    } else {
        discount = 0;
    }
    System.out.println(discount);

Isso não irá mais exibir o erro no print.
