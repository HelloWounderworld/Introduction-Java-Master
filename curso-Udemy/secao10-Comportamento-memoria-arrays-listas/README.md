# Seção 10: Comportamento de memória, arrays, listas:

## Aula 01 - Visão geral do capítulo e Aula 02 - Material de apoio do capítulo:
MATERIAL DE APOIO DO CAPÍTULO

Seja muito bem-vindo(a) ao capítulo Comportamento de memória, arrays, listas!

Aqui você pode baixar o material de apoio usado nas aulas do capítulo, para que você possa aproveitar ao máximo as aulas sem precisar ficar anotando muito.

Grande abraço e bons estudos! Nelio.

Recursos para esta aula

    05-memoria-arrays-e-listas(para-anotacoes).pdf
    05-memoria-arrays-e-listas.pdf
    05-exercicios-de-fixacao-vetores.pdf

## Aula 03 - Tipos referência vs. tipos valor - Atribuição: Valor vs Referência:
Vamos diferenciar tipos referências e tipos valor

    https://www.devmedia.com.br/tipos-de-dados-por-valor-e-por-referencia-em-java/25293#:~:text=O%20Java%20possui%20dois%20tipos,Strings%2C%20Arrays%20Primitivos%20e%20Objetos.
    https://blog.grancursosonline.com.br/os-tipos-primitivos-da-linguagem-java/
    https://learn.microsoft.com/pt-br/dotnet/visual-basic/programming-guide/language-features/data-types/value-types-and-reference-types

Aqui é o mesmo que foi aprendido em JavaScript e Python, que é a diferença entre dados primitivos e dados passados por refrência, aula 13 da seção 2 do meu estudo de JavaScript.

Bom, ao declararmos um valor, diferentemente de JavaScript, ao printarmos ela sem atribuir algum valor isso irá acarretar em um erro

    int p;
    System.out.println(p);

Ou seja, para printar alguma variável, é necessário que a tal variável declarada, já tenha algum vlaor atribuído para ela.

### Desafio:
Vamos criar a classe "PrimeiroTrauma" do projeto "exercicios" do pacote "classe".

Motivo desse nome, é que, segundo o professor, Leonardo Moura Leitao, esse exercício foi, literalmente, o primeiro trauma dele quando estava estudando programação.

    package classe;

    public class PrimeiroTrauma {
        
        int a = 3; // Não pode mexer aqui

        public static void main(String[] args) {
            
            // pode mexer aqui
            System.out.println(a);
            // pode mexer aqui
        }
    }

Bom, o desafio é o seguinte.

Note que, a variável "int a = 3;" está definido fora do main e estou tentando printar essa variável dentro do main usando o "System.out.println".

No caso, sem alterar nada na variável que está definido fora do main, quero que, dentro do main, vc realize uma alteração que corrija o problema que está dando, quando vc tenta rodar o código no formato acima.

## Aula 04 - Desalocação de memória - garbage collector e escopo local:
Seguir o link para leitura

    https://newrelic.com/blog/best-practices/java-garbage-collection#:~:text=Garbage%20collection%20in%20Java%20is,be%20executed%20by%20a%20JVM.

Basicamente, o garbage collector ele significa de um dado que ficará acoplado na memória temporariamente. Um exemplo disso, está em seguinte

    p1 = Product("TV", 900.00, 0);
    p2 = Product("PC", 1500.00, 0);

    p1 = p2;

O ato acima fará com que o p1 e o p2 aponte para a mesma classe, Product("PC", 1500.00, 0), mas e a classe Product("TV", 900.00, 0)? Ela será guardada no garbage collector, donde será apagado da memória caso caia, de fato, em um desuso.

## Aula 05 e 06 - Vetores - Parte 1 e 2:
Bom, a ideia aqui é análoga que foi estudada em Álgebra Linear.

Só vamos aprender as suas sintaxes

    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    double[] vect = new double[n];

    for (int i=0; i<n; i++) {
        vect[i] = sc.nextDouble();
    }

    double sum = 0.0;
        for (int i=0; i<n; i++) {
        sum += vect[i];
    }

    double avg = sum / n;
    System.out.printf("AVERAGE HEIGHT: %.2f%n", avg);

    sc.close();

Como podemos ver acima, o jeito double[] vect = new double[n]; é a sintaxe para podermos definir um vetor.

Um outro exemplo, desta vez, cujo os elementos do vetor são classes

    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    Product[] vect = new Product[n];

    for (int i=0; i<vect.length; i++) {
        sc.nextLine();
        String name = sc.nextLine();
        double price = sc.nextDouble();
        vect[i] = new Product(name, price);
    }

    double sum = 0.0;
    for (int i=0; i<vect.length; i++) {
    sum += vect[i].getPrice();
    }

    double avg = sum / vect.length;

    System.out.printf("AVERAGE PRICE = %.2f%n", avg);

    sc.close();

A sintaxe para criar um vetor com elementos sendo classe é Product[] vect = new Product[n];.

Assim vale para outros tipos tbm.

Claro, os vetores, todas elas, não precisa ter um nome de vect. Podemos colocar outros nomes tbm

    Product[] nomes = new Product[n];
    double[] price = new double[n];

## Aula 07 - Exercícios de fixação sobre vetores:
Seguir o arquivo

    05-exercicios-de-fixacao-vetores.pdf

FAzer os exercícios, não precisa ser todas, no momento em que eu estiver revisando.

## Aula 08 - Correção do exercício negativos:
Seguir o link onde está a resolução do professor

     https://github.com/acenelio/curso-algoritmos/blob/master/java/negativos.java

## Aula 09 - Correção do exercício alturas:
Seguir o link onde está a resolução do professor

    https://github.com/acenelio/curso-algoritmos/blob/master/java/alturas.java

## Aula 10 - Desafio sobre vetores (pensionato):
Seguir o enunciado

    A dona de um pensionato possui dez quartos para alugar para estudantes,sendo esses quartos identificados pelos números 0 a 9.
    Fazer um programa que inicie com todos os dez quartos vazios, e depois leia uma quantidade N representando o número de estudantes que vão alugar quartos (N pode ser de 1 a 10). Em seguida, registre o aluguel dos N estudantes. Para cada registro de aluguel, informar o nome e email doestudante, bem como qual dos quartos ele escolheu (de 0 a 9). Suponha que seja escolhido um quarto vago. Ao final, seu programa deve imprimir um relatório de todas ocupações do pensionato, por ordem de quarto, conforme exemplo.

Exemplo de como deve funcionar

    How many rooms will be rented? 3
    Rent #1:
    Name: Maria Green
    Email: maria@gmail.com
    Room: 5
    Rent #2:
    Name: Marco Antonio
    Email: marco@gmail.com
    Room: 1
    Rent #3:
    Name: Alex Brown
    Email: alex@gmail.com
    Room: 8
    Busy rooms:
    1: Marco Antonio, marco@gmail.com
    5: Maria Green, maria@gmail.com
    8: Alex Brown, alex@gmail.com

## Aula 11 - Correção do desafio sobre vetores (pensionato):
Compare a sua resolução com a resolução do professor

- A classe

    package entities;
    public class Rent {
        private String name;
        private String email;

        public Rent(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String toString() {
            return name + ", " + email;
        }
    }

- A aplicação

    package application;
    import java.text.ParseException;
    import java.util.Scanner;
    import entities.Rent;
    public class Program {
        public static void main(String[] args) throws ParseException {

            Scanner sc = new Scanner(System.in);

            Rent[] vect = new Rent[10];
            System.out.print("How many rooms will be rented? ");
            int n = sc.nextInt();
            
            for (int i=1; i<=n; i++) {
                System.out.println();
                System.out.println("Rent #" + i + ":");
                System.out.print("Name: ");
                sc.nextLine();
                String name = sc.nextLine();
                System.out.print("Email: ");
                String email = sc.nextLine();
                System.out.print("Room: ");
                int room = sc.nextInt();
                vect[room] = new Rent(name, email);
            }

            System.out.println();
            System.out.println("Busy rooms:");
            for (int i=0; i<10; i++) {
                if (vect[i] != null) {
                    System.out.println(i + ": " + vect[i]);
                }
            }

            sc.close();
        }
    }

## Aula 12 - Boxing, unboxing e wrapper classes:
Seguir os links para leitura.

- Boxing and Unboxing:

    https://docs.oracle.com/javase/tutorial/java/data/autoboxing.html#:~:text=Autoboxing%20is%20the%20automatic%20conversion,way%2C%20this%20is%20called%20unboxing.

- Wrapper:

    https://www.devmedia.com.br/wrappers-em-java-aprenda-como-utilizar/30275
    https://www.w3schools.com/java/java_wrapper_classes.asp
    https://www.tutorialspoint.com/why-do-we-need-a-wrapper-class-in-java#:~:text=A%20Wrapper%20class%20is%20a,wrapper%20classes%20come%20under%20java.

Baiscamente, o boxing é o processo de conversão de um objeto tipo valor para um objeto tipo referência compatível e o Unboxing é o processo de conversão de um objeto tipo referência para um objeto tipo valor compatível. Seguir os exemplos, respectivamente

    int x = 20;
    Object obj = x;

e

    int x = 20;
    Object obj = x;
    Object obj = x;int y = (int) obj;

Agora, o Wrapper classes seria o seguinte

- São classes equivalentes aos tipos primitivos

- Boxing e unboxing é natural na linguagem

- Uso comum: campos de entidades em sistemas de informação (IMPORTANTE!)
    - Pois tipos referência (classes) aceitam valor null e usufruem dos recursos OO (Orientação aos Objetos)

Um exemplo disso seria o seguinte

    Integer x = 10;
    int y = x * 2;

Ou podemos usar até para as classes

    public class Product {

        public String name;
        public Double price;
        public Integer quantity;

    }

Digamos que é uma forma mais fácil de nos livrarnos de ter que usar os castings.

## Aula 13 - Laço for each:
O uso é similar ao que foi estudado em JavaScript.

Logo, focarei apenas na sintaxe da mesma

    for (Tipo apelido : coleção) {
        <comando 1>
        <comando 2>
    }

No caso, ela foi diretamente no elemento. Daí, um exemplo do seu uso é o seguinte

    // É uma forma de já instanciar algum objeto com os valores
    String[] vect = new String[] {"Maria", "Bob", "Alex"};

    for (int i=0; i< vect.length; i++) {
        System.out.println(vect[i]);
    }

    for (String obj : vect) {
        System.out.println(obj);
    }

O exemplo acima, será feito um comparativo entre for e for each.

## Aula 14 e 15 - Listas - Parte 1 e 2:
Seguir o link para leitura

    https://docs.oracle.com/javase/10/docs/api/java/util/List.html

Listas

Lista é uma estrutura de dados:

- Homogênea (dados do mesmo tipo)

- Ordenada (elementos acessados por meio de posições)

- Inicia vazia, e seus elementos são alocados sob demanda

- Cada elemento ocupa um "nó" (ou nodo) da lista

- Tipo (interface): List

- Classes que implementam: ArrayList, LinkedList, etc.

- Vantagens: 
    - Tamanho variável

- Facilidade para se realizar inserções e deleções

- Desvantagens:
    - Acesso sequencial aos elementos *

No caso, vamos ver os métodos que temos de disposição para as listas

Demo:

- Tamanho da lista: size()

- Obter o elemento de uma posição: get(position)

- Inserir elemento na lista: add(obj), add(int, obj)

- Remover elementos da lista: remove(obj), remove(int), removeIf(Predicate)

- Encontrar posição de elemento: indexOf(obj), lastIndexOf(obj)

- Filtrar lista com base em predicado:List<Integer> result = list.stream().filter(x -> x > 4).collect(Collectors.toList());

- Encontrar primeira ocorrência com base em predicado:Integer result = list.stream().filter(x -> x > 4).findFirst().orElse(null);

- Assuntos pendentes:
    - interfaces
    - generics
    - predicados (lambda)

Siga um exemplo de sua aplicação

    package application;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.stream.Collectors;

    public class Program {
        public static void main(String[] args) {

            // A classe List não aceita o tipo primitivo
            // No caso, quando fizermos List<int> isso não funcionará
            // Precisa ser List<Integer>
            // Ou seja, sempre um wrapper class.
            List<String> list = new ArrayList<>();
            list.add("Maria");
            list.add("Alex");
            list.add("Bob");
            list.add("Anna");
            // Essa adição faz com que, se tiver outros elementos à frente, desloca esses elementos à frente no índice sucessor
            list.add(2, "Marco");

            System.out.println(list.size());

            // A forma de remoção aceita tanto pelo elemento, quanto pelo índice que o elemento está definido.
            //list.remove("Anna");
            //list.remove(1);
            
            for (String x : list) {
                System.out.println(x);
            }

            System.out.println("---------------------");
            
            // Remoção por predicado, usa-se arrow function (função lambda)
            // No caso, está removendo todos os nomes que começa com 'M'.
            list.removeIf(x -> x.charAt(0) == 'M');
            for (String x : list) {
                System.out.println(x);
            }

            System.out.println("---------------------");

            // Para encontrar o índice em que o elemento está definido
            // Quando não é encontrado ele retorna -1
            System.out.println("Index of Bob: " + list.indexOf("Bob"));
            System.out.println("Index of Marco: " + list.indexOf("Marco"));

            System.out.println("---------------------");

            /* Usando o stream, ele devolve uma nova lista e vc pode concatenar ele com outros métodos adiante, pois o que será devolvido seria uma nova lista com o novo resultado. Entretanto, esse stream não é compatível com a lista, o que será necessário vc usar o collect(Collectors.toList()) para poder voltar a converter para uma lista. Tais recurso estão disponíveis somente de Java 8 para frente */
            List<String> result = list.stream().filter(x -> x.charAt(0) == 'A').collect(Collectors.toList());
            for (String x : result) {
                System.out.println(x);
            }

            System.out.println("---------------------");
            
            /* Esse findFirst ele serve para vc conseguir encontrar algum elemento que inicie com tal nome ou como foi definido no predicado abaixo. Poderia ser de outra forma tbm. Para isso seria necessário o orElse(null) para retornar nada caso não encontre o elemento. */
            String name = list.stream().filter(x -> x.charAt(0) == 'J').findFirst().orElse(null);

            System.out.println(name);
        }
    }


## Aula 16 - Exercício proposto:
Seguir o enunciado

    Fazer um programa para ler um número inteiro N e depois os dados (id, nome e salario) de N funcionários. Não deve haver repetição de id.
    Em seguida, efetuar o aumento de X por cento no salário de um determinado funcionário. Para isso, o programa deve ler um id e o valor X. Se o id informado não existir, mostrar uma mensagem e abortar a operação. Ao final, mostrar a listagem atualizada dos funcionários, conforme exemplos.
    Lembre-se de aplicar a técnica de encapsulamento para não permitir que o salário possa ser mudado livremente. Um salário só pode ser aumentado com base em uma operação de aumento por porcentagem dada.

Exemplo do seu funcionamento

    How many employees will be registered? 3
    Emplyoee #1:
    Id: 333
    Name: Maria Brown
    Salary: 4000.00
    Emplyoee #2:
    Id: 536
    Name: Alex Grey
    Salary: 3000.00
    Emplyoee #3:
    Id: 772
    Name: Bob Green
    Salary: 5000.00
    Enter the employee id that will have salary increase : 536
    Enter the percentage: 10.0
    List of employees:
    333, Maria Brown, 4000.00
    536, Alex Grey, 3300.00
    772, Bob Green, 5000.00

e

    How many employees will be registered? 2
    Emplyoee #1:
    Id: 333
    Name: Maria Brown
    Salary: 4000.00
    Emplyoee #2:
    Id: 536
    Name: Alex Grey
    Salary: 3000.00
    Enter the employee id that will have salary increase: 776
    This id does not exist!
    List of employees:
    333, Maria Brown, 4000.00
    536, Alex Grey, 3000.00

Bom, será necessário o uso da lista para poder resolver esse problema!

## Aula 17 - Correção em vídeo do exercício proposto:
Seguir o link do exercício resolvido

    https://github.com/acenelio/list1-java

Olá pessoal! A correção deste exercício sobre lista foi feita em uma live no Youtube:

    https://youtu.be/Xj-osdBe3TE

Abraços e até a próxima!

## Aula 18 - Matrizes:
Lista dentro de lista

- Em programação, "matriz" é o nome dado a arranjos bidimensionais- Atenção: "vetor de vetores"

- Arranjo (array) é uma estrutura de dados:
    - Homogênea (dados do mesmo tipo)

- Ordenada (elementos acessados por meio de posições)

- Alocada de uma vez só, em um bloco contíguo de memória

- Vantagens:
    - Acesso imediato aos elementos pela sua posição

- Desvantagens:
    - Tamanho fixo

- Dificuldade para se realizar inserções e deleções

## Aula 19 - Exercício resolvido:
Seguir o link da resolução

    https://github.com/acenelio/matrix1-java

O enunciado do exercício

    Fazer um programa para ler um número inteiro N e uma matriz de ordem N contendo números inteiros. Em seguida, mostrar a diagonal principal e a quantidade de valores negativos da matriz.

Exemplo de funcionamento

    Input:
    3
    5 -3 10
    15 8  2
    7  9 -4

    Output:
    Main diagonal:
    5 8 -4
    Negative numbers = 2

## Aula 20 - Exercício proposto:
Seguir o link da resolução

    https://github.com/acenelio/matrix2-java

O enunciado do exercício

    Fazer um programa para ler dois números inteiros M e N, e depois ler uma matriz de M linhas por N colunas contendo números inteiros, podendo haver repetições. Em seguida, ler um número inteiro X que pertence à matriz. Para cada ocorrência de X, mostrar os valores à esquerda, acima, à direita e abaixo de X, quando houver, conforme exemplo.

Exemplo de seu funcionamento

    3 4
    10 8 15 12
    21 11 23 8
    14 5 13 19
    8
    Position 0,1:
    Left: 10
    Right: 15
    Down: 11
    Position 1,3:
    Left: 23
    Up: 12
    Down: 19
