# Seção 19: Generic, Set, Map:

Revisar definitivamente essa seção!!!! Será muito necessário!

## Aula 01 - Visão geral do capítulo Generics, Set, Map e Aula 02 - Material de apoio do capítulo:
MATERIAL DE APOIO DO CAPÍTULO

Seja muito bem-vindo(a) ao capítulo Generics, Set, Map!

Aqui você pode baixar o material de apoio usado nas aulas do capítulo, para que você possa aproveitar ao máximo as aulas sem precisar ficar anotando muito.

Grande abraço e bons estudos! Nelio.

Recursos para esta aula

    13-generics-set-map(espaco-para-anotacoes).pdf
    13-generics-set-map.pdf

## Aula 03 - Introdução aos Generics:
Seguir link para leitura

    https://www.devmedia.com.br/usando-generics-em-java/28981
    https://blog.cod3r.com.br/generics-em-java-o-que-e-e-exemplos/
    https://www.geeksforgeeks.org/generics-in-java/

Generics
- Generics permitem que classes, interfaces e métodos possam ser parametrizados por tipo. Seus benefícios são:
    - Reuso
    - Type safety
    - Performance

- Uso comum: coleções

    List<String> list = new ArrayList<>();
    list.add("Maria");
    String name = list.get(0);

Seguir o link da aplicação de generic do professor

    https://github.com/acenelio/generics1-java

## Aula 04 - Genéricos delimitados:
Seguir link de leitura

    https://pt.stackoverflow.com/questions/371136/java-pra-que-serve-o-e-tipos-gen%C3%89ricos

Seguir o link de resolução do professor

    https://github.com/acenelio/generics2-java

Vamos resolver o seguinte problema:

Uma empresa de consultoria deseja avaliar a performance de produtos, funcionários, dentre outras coisas. Um dos cálculos que ela precisa é encontrar o maior dentre um conjunto de elementos. Fazer um programa que leia um conjunto de produtos a partir de um arquivo, conforme exemplo, e depois mostre o mais caro deles.

    Computer,890.50
    IPhone X,910.00
    Tablet,550.00
    Most expensive:
    IPhone, 910.00

Primeiro, tente resolver esse problema acima sem o uso do genérico. Ou seja, resolver ela de forma simples.

Depois disso, tente resolvê-la usando o generics e compare com a solução do professor.

## Aula 05 - Tipos curinga (Wildcard types):
Seguir link para leitura

    https://en.wikipedia.org/wiki/Wildcard_(Java)#:~:text=In%20the%20Java%20programming%20language,definition%20of%20a%20generic%20type.
    https://www.geeksforgeeks.org/wildcards-in-java/
    https://en.wikipedia.org/wiki/Wildcard_(Java)#:~:text=In%20the%20Java%20programming%20language,definition%20of%20a%20generic%20type.

Generics são invariantes

List<Object> não é o supertipo de qualquer tipo de lista:

    List<Object> myObjs = new ArrayList<Object>();
    List<Integer> myNumbers = new ArrayList<Integer>();
    myObjs = myNumbers; // erro de compilação

O supertipo de qualquer tipo de lista é List<?>. Este é um tipo curinga:

    List<?> myObjs = new ArrayList<Object>();
    List<Integer> myNumbers = new ArrayList<Integer>();
    myObjs = myNumbers;

Com tipos curinga podemos fazer métodos que recebem um genérico de "qualquer tipo":

    package application;

    import java.util.Arrays;
    import java.util.List;

    public class Program {

        public static void main(String[] args) {
            List<Integer> myInts = Arrays.asList(5, 2, 10);
            printList(myInts);
        }

        public static void printList(List<?> list) {
            for (Object obj : list) {
                System.out.println(obj);
            }
        }
    }

Porém não é possível adicionar dados a uma coleção de tipo curinga

    package application;

    import java.util.ArrayList;
    import java.util.List;

    public class Program {

        public static void main(String[] args) {

            List<?> list = new ArrayList<Integer>();
            list.add(3); // erro de compilação
        }
    }

O compilador não sabe qual é o tipo específico do qual a lista foi instanciada.

## Aula 06 - Curingas delimitados:
Seguir links para leitura

    https://en.wikipedia.org/wiki/Wildcard_(Java)#:~:text=A%20bounded%20wildcard%20is%20one,bounds%20using%20the%20super%20keyword.
    https://docs.oracle.com/javase/tutorial/java/generics/upperBounded.html
    https://stackoverflow.com/questions/3486689/java-bounded-wildcards-or-bounded-type-parameter#:~:text=What%20is%20the%20difference%20between,bound%20for%20a%20type%20parameter.
    https://javarevisited.blogspot.com/2012/04/what-is-bounded-and-unbounded-wildcards.html#:~:text=Bounded%20and%20unbounded%20wildcards%20in%20Generics%20are%20two%20types%20of,Generics%20by%20using%20bounded%20wildcards.

Seguir o link do repositório do professor

    https://github.com/acenelio/generics4-java

Problema 1
Vamos fazer um método para retornar a soma das áreas de uma lista de figuras.

Nota 1: soluções impróprias:

    public double totalArea(List<Shape> list)
    public double totalArea(List<?> list) 

Nota 2: não conseguiremos adicionar elementos na lista do método

Problema 2 (princípio get/put)

Vamos fazer um método que copia os elementos de uma lista para uma outra lista que pode ser mais genérica que a primeira.

    List<Integer> myInts = Arrays.asList(1, 2, 3, 4);
    List<Double> myDoubles = Arrays.asList(3.14, 6.28);
    List<Object> myObjs = new ArrayList<Object>();

    copy(myInts, myObjs);

    copy(myDoubles, myObjs);

    https://stackoverflow.com/questions/1368166/what-is-a-difference-between-super-e-and-extends-e

Princípio get/put - covariância

    List<Integer> intList = new ArrayList<Integer>();
    intList.add(10);
    intList.add(5);

    List<? extends Number> list = intList;

    Number x = list.get(0);

    list.add(20); // erro de compilacao

Princípio get/put - contravariância

    List<Object> myObjs = new ArrayList<Object>();
    myObjs.add("Maria");
    myObjs.add("Alex");

    List<? super Number> myNums = myObjs;

    myNums.add(10);
    myNums.add(3.14);

    Number x = myNums.get(0); // erro de compilacao

No final das contas, como ficará o código

    package application;

    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.List;
    
    public class Program {

        public static void main(String[] args) {

            List<Integer> myInts = Arrays.asList(1, 2, 3, 4);
            List<Double> myDoubles = Arrays.asList(3.14, 6.28);
            List<Object> myObjs = new ArrayList<Object>();
            
            copy(myInts, myObjs);
            printList(myObjs);
            copy(myDoubles, myObjs);
            printList(myObjs);
        }

        public static void copy(List<? extends Number> source, List<? super Number> destiny) {
            for(Number number : source) {
                destiny.add(number);
            }
        }

        public static void printList(List<?> list) {
            for (Object obj : list) {
                System.out.print(obj + " ");
            }
            System.out.println();
        }
    }

## Aula 07 - HashCode e Equals:

## Aula 08 - Set:

## Aula 09 - Como Set testa igualdade:

## Aula 10 - Como TreeSet compara os elementos:

## Aula 11 - Exercício resolvido (Set):

## Aula 12 - Exercício de fixação (Set):

## Aula 13 - Map:

## Aula 14 - Exercício de fixação (Map):
