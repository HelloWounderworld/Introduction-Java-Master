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
Seguir link para leitura

    https://www.digitalocean.com/community/tutorials/java-equals-hashcode
    https://blog.algaworks.com/entendendo-o-equals-e-hashcode/
    https://stackoverflow.com/questions/2265503/why-do-i-need-to-override-the-equals-and-hashcode-methods-in-java#:~:text=Both%20methods%2C%20equals()%20and,such%20object%20as%20a%20key.

hashCode e equals
- São operações da classe Object utilizadas para comparar se um objeto é igual a outro

- equals: lento, resposta 100%

- hashCode: rápido, porém resposta positiva não é 100%

- Tipos comuns (String, Date, Integer, Double, etc.) já possuem implementação para essas operações. Classes personalizadas precisam sobrepô-las.

Vamos criar um projeto, primeiro, para usar o método equals. No caso, vamos criar um projeto com o nome test_equals_method e dentro dela criamos apenas o diretório application com o arquivo Program.java.

Equals:

Método que compara se o objeto é igual a outro, retornando true ou false. No caso, no arquivo Program.java vamos colocar o seguinte

    String a = "Maria";
    String b = "Alex";

    System.out.println(a.equals(b));
 
Para o método hashcode vamos criar um projeto test_hashcode_method e dentro dela criar o diretório application com o arquivo Program.java.

HashCode:

Método que retorna um número inteiro representando um código gerado a partir das informações do objeto. No caso, no arquivo Program.java vamos colocar o seguinte código

    String a = "Maria";
    String b = "Alex";

    System.out.println(a.hashCode());
    System.out.println(b.hashCode());

Bom, lembre-se que para cada valor diferente que iremos atribuir acima irá gerar um número inteiro maluco diferente. Entretanto, o hashcode tem os seus defeitos tbm. Ou seja, existem casos em que vc tem dois objetos diferentes, mas que irá gerar o mesmo número inteiro, devido à limitação de 32bits, mesmo que a probabilidade disso acontecer seja muito, mas muito, menor, devido À 4 bilhões de possibilidades.

Regra de ouro do HashCode

- Se o hashCode de dois objetos for diferente, então os dois objetos são diferentes.

- Se o código de dois objetos for igual, muito provavelmente os objetos são iguais (pode haver colisão).

Bom, uma boa prática usando hashcode seria combinado com o método equals. Ou seja, vc vai realizando as comparações com o hascode e se, por ventura, os dois valores do hashcode derem iguais, usamos o método equals para, de fato, confirmarmos que é igual. Isso porque o método hashcode ele é um método muito mais rápido do que equals. Em outras palavras, se fizermos a lógica acima usando apenas o equals, o código ficará muito lento.

Por último, vamos criar um HashCode e Equals personalizados. Para isso, vamos criar um outro projeto chamado hashcode_equals_customized. Dentro desse projeto, vamos colocar o diretório application com o arquivo Program.java e vamos criar um diretório entities com a classe Client.java.

Dentro da classe Client.java vamos colocar o seguinte

    package entities;

    import java.util.Objects;

    public class Client {
        
        private String name;
        private String email;
        
        public Client(String name, String email) {
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

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Client other = (Client) obj;
            return Objects.equals(name, other.name);
        }
        
    }

Agora, vamos tentar aplicar esse teste na aplicação. Então no Program.java colocamos o seguinte

    package application;

    import entities.Client;

    public class Program {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            Client c1 = new Client("Maria", "maria@gmail.com");
            Client c2 = new Client("Alex", "alex@gmail.com");
            
            System.out.println(c1.hashCode());
            System.out.println(c2.hashCode());
            System.out.println(c1.equals(c2));
        }

    }

O mesmo vale para o email ou (nome e email). Bastaríamos aproveitar dos recursos do eclipse para gerarmos o hashCode() e equals() para uma ou para ambas.

Obs: Se colocarmos o System.out.println(c1 == c2); retornará um false, mesmo que os valores sejam as mesmas, pois essa comparação não está sendo feito o valor que foi atribuído, mas, sim, da memória que foi atribuída visto que temos dois objetos diferentes que alocará, na memória, dois valores diferentes. Ou seja, está comparando a memória e não o valor.

Bom, o que chegamos a seguinte conclusão

- Se vc quiser comparar os valores vc deverá usar o equals

- Se vc quiser comparar as referências do objeto, então vc usa o "==".

Para deixarmos mais claro o ponto de cima, vamos realizar o seguinte em Program.java

    package application;

    import entities.Client;

    public class Program {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            Client c1 = new Client("Maria", "maria@gmail.com");
            Client c2 = new Client("Alex", "alex@gmail.com");
            
            String s1 = "Teste";
            String s2 = "Teste";
            
            System.out.println(c1.hashCode());
            System.out.println(c2.hashCode());
            System.out.println(c1.equals(c2));
            System.out.println(c1 == c2);
            System.out.println(s1 == s2);
        }

    }

A comparação, System.out.println(s1 == s2);, retornará "true", pois aqui, no caso, essa comparação é algo especial, pois colocamos diretamente o valor. Daria falso se tivessemos forçado da seguinte forma String s1 = new String("Teste"); para s2 tbm. Aí sim, a comparação usando o operador "==", se tornará por referência.

## Aula 08 - Set:
Seguir o link para leitura

    https://www.geeksforgeeks.org/set-in-java/
    https://docs.oracle.com/javase/10/docs/api/java/util/Set.html

Bom, o set é literalmente a definição de conjunto que é visto em matemática.

Set<T>

- Representa um conjunto de elementos (similar ao da Álgebra)
    - Não admite repetições

    - Elementos não possuem posição

    - Acesso, inserção e remoção de elementos são rápidos

    - Oferece operações eficientes de conjunto: interseção, união, diferença.

    - Principais implementações: 
        - HashSet - mais rápido (operações O(1) em tabela hash) e não ordenado

        - TreeSet - mais lento (operações O(log(n)) em árvore rubro-negra) e ordenado pelo compareTo do objeto (ou Comparator)

        - LinkedHashSet - velocidade intermediária e elementos na ordem em que são adicionados

Alguns métodos importantes
- add(obj), remove(obj), contains(obj)
    - Baseado em equals e hashCode

    - Se equals e hashCode não existir, é usada comparação de ponteiros

- clear()

- size()

- removeIf(predicate)

- addAll(other) - união: adiciona no conjunto os elementos do outro conjunto, sem repetição

- retainAll(other) - interseção: remove do conjunto os elementos não contitos em other

- removeAll(other) - diferença: remove do conjunto os elementos contidos em other

Vamos criar um projeto novo, test_set_method. Dentro dela colocamos o diretório application com o arquivo Program.java.

No arquivo, Program.java coloquemos o seguinte

    package application;

    import java.util.HashSet;
    import java.util.Set;

    public class Program {
        
        public static void main(String[] args) {
            
            Set<String> set = new HashSet<>();
            
            set.add("TV");
            set.add("Notebook");
            set.add("Tablet");
            
            System.out.println(set.contains("Notebook"));
            
            for (String p : set) {
                System.out.println(p);
            }
        }
    }

Bom, o código acima nos mostra que podemos verificar se algum elemento pertence ou não ao conjunto e, tbm, mostra que podemos iterar o conjunto como uma lista. No caso, a única desvantagem do HashSet, seria que ele não irá te garantir a ordem. Bom, isso é óbvio, visto que na definição de conjuntos, vc só tem os elementos nele e a relação de ordem é algo independente. No caso, tem teoria dos conjuntos, Thomas Jech, isso fica claro, que tudo na matemática que tenha alguma relação pode ser descrito como função, mas para podermos escrever uma função precisa-se de conjunto, visto que uma função é uma relação.

Entretanto, se quisermos colocar uma ordem dentro desse conjunto, em vez de usarmos o HashSet, podemos usar o TreeSet, pois assim, podemos estabelecer uma ordem dentro desse conjunto

    package application;

    import java.util.Set;
    import java.util.TreeSet;

    public class Program {
        
        public static void main(String[] args) {
            
    //		Set<String> set = new HashSet<>();
            Set<String> set = new TreeSet<>();
            
            set.add("TV");
            set.add("Notebook");
            set.add("Tablet");
            
            System.out.println(set.contains("Notebook"));
            
            for (String p : set) {
                System.out.println(p);
            }
        }
    }

Se quisermos manter tbm a ordem em que os elementos foram inseridos, da mesma lógica de definirmos uma sequência em ordem de indexação, podemos usar o LinkedHashSet

    package application;

    import java.util.LinkedHashSet;
    import java.util.Set;

    public class Program {
        
        public static void main(String[] args) {
            
    //		Set<String> set = new HashSet<>();
    //		Set<String> set = new TreeSet<>();
            Set<String> set = new LinkedHashSet<>();
            
            set.add("TV");
            set.add("Notebook");
            set.add("Tablet");
            
            System.out.println(set.contains("Notebook"));
            
            for (String p : set) {
                System.out.println(p);
            }
        }
    }

Agora, vamos mostrar outras funcionalidades boas do set. Para isso, vamos criar um novo projeto test_set_method_demo2. Criamos dentro dela os diretórios application com o arquivo Program.java.

Dentro do Program.java, desse projeto, coloquemos o seguinte

    package application;

    import java.util.Arrays;
    import java.util.Set;
    import java.util.TreeSet;

    public class Program {
        
        public static void main(String[] args) {
            
            Set<Integer> a = new TreeSet<>(Arrays.asList(0, 2, 4, 5, 6, 8, 10));
            Set<Integer> b = new TreeSet<>(Arrays.asList(5, 6, 7, 8, 9, 10));
    //union
            Set<Integer> c = new TreeSet<>(a);
            c.addAll(b);
            System.out.println(c);
    //intersection
            Set<Integer> d = new TreeSet<>(a);
            d.retainAll(b);
            System.out.println(d);
    //difference
            Set<Integer> e = new TreeSet<>(a);
            e.removeAll(b);
            System.out.println(e);
        }
    }

Bom, o conceito acima se torna trivial de se entender, pois é teoria de conjuntos básicos.

## Aula 09 - Como Set testa igualdade:
Como as coleções Hash testam igualdade?

- Se hashCode e equals estiverem implementados:
    - Primeiro hashCode. Se der igual, usa equals para confirmar.

    - Lembre-se: String, Integer, Double, etc. já possuem equals e hashCode

- Se hashCode e equals NÃO estiverem implementados:
    - Compara as referências (ponteiros) dos objetos.

Vamos criar um novo projeto disso com o nome test_set_equals_hash e dentro dela vamos criar dois diretórios, application e entities. Assim, em application vc coloca o Program.java e em entities vc cria a classe Product.java.

Daí, na classe Product.java, vamos colocar o seguinte

    package entities;

    public class Product {
        
        private String name;
        private Double price;

        public Product(String name, Double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }
    }

E em Program.java, vamos colocar o seguinte

    package application;

    import java.util.HashSet;
    import java.util.Set;

    import entities.Product;

    public class Program {
        public static void main(String[] args) {
            
            Set<Product> set = new HashSet<>();
            
            set.add(new Product("TV", 900.0));
            set.add(new Product("Notebook", 1200.0));
            set.add(new Product("Tablet", 400.0));
            
            Product prod = new Product("Notebook", 1200.0);
            
            System.out.println(set.contains(prod));
        }
    }

Bom, no teste acima, ele retornará false, pois o que acontece é que, por conta da classe Product.java não ter nenhum comparativo Hash nela, a conferência da relação de pertinência está sendo feita por referência/setas, em vez do valor em si. Ou seja, como as referências dos dois objetos, mesmo que o valor "Notebook" e "1200.0" sejam iguais, são diferentes, então isso foi interpretado como falso.

Bom, para que isso seja evitado, precisaríamos implementar o hashcode dentro da classe Product.java da seguinte forma

    package entities;

    import java.util.Objects;

    public class Product {
        
        private String name;
        private Double price;

        public Product(String name, Double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, price);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Product other = (Product) obj;
            return Objects.equals(name, other.name) && Objects.equals(price, other.price);
        }
        
    }

Bom, feito isso e rodando o código, será retornado true!

## Aula 10 - Como TreeSet compara os elementos:
Recordando as implementações

- Principais implementações: 
    - HashSet - mais rápido (operações O(1) em tabela hash) e não ordenado

    - TreeSet - mais lento (operações O(log(n)) em árvore rubro-negra) e ordenado pelo compareTo do objeto (ou Comparator)

    - LinkedHashSet - velocidade intermediária e elementos na ordem em que são adicionados

Vamos criar um novo projeto com o nome de test_treeset_hashcode, daí vamos criar dois diretórios, application e entities, donde colocamos Program.java e criamos a classe Product.java, respectivamente.

Note que, se mantermos o código da classe Product como está no outro projeto acima e fizermos o seguinte no arquivo Program.java

    package application;

    import java.util.Set;
    import java.util.TreeSet;
    import entities.Product;

    public class Program {
        public static void main(String[] args) {
            
            Set<Product> set = new TreeSet<>();
            
            set.add(new Product("TV", 900.0));
            set.add(new Product("Notebook", 1200.0));
            set.add(new Product("Tablet", 400.0));
            
            for (Product p : set) {
                System.out.println(p);
            }
        }
    }

Vamos ver que ao rodarmos isso será retornado um problema no console, pedindo para implementar o comparable na classe Product.

Logo, no arquivo Product.java, vamos precisar realizar oseguinte

    package entities;

    public class Product implements Comparable<Product> {
        private String name;
        private Double price;

        public Product(String name, Double price) {
            this.name = name;
            this.price = price;
        }
        
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        // (... get / set / hashCode / equals)
        @Override
        public String toString() {
            return "Product [name=" + name + ", price=" + price + "]";
        }

        @Override
        public int compareTo(Product other) {
            return name.toUpperCase().compareTo(other.getName().toUpperCase());
        }
    }

Ou seja, impelementamos o Comparable<Product> e isso nos possibilita realizarmos a ordenação.

## Aula 11 - Exercício resolvido (Set):

## Aula 12 - Exercício de fixação (Set):

## Aula 13 - Map:

## Aula 14 - Exercício de fixação (Map):
