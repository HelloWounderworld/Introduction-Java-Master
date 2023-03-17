# Seção 20: Programação funcional e expressões lambda:

## Aula 01 - Visão geral do capítulo Programação Funcional e Expressões Lambda e Aula 02 - Material de apoio do capítulo:
MATERIAL DE APOIO DO CAPÍTULO

Seja muito bem-vindo(a) ao capítulo Programação funcional e expressões lambda!

Aqui você pode baixar o material de apoio usado nas aulas do capítulo, para que você possa aproveitar ao máximo as aulas sem precisar ficar anotando muito.

Grande abraço e bons estudos! Nelio.

Recursos para esta aula

    15-programacao-funcional-expressoes-lambda(espaco-para-anotacoes).pdf
    15-programacao-funcional-expressoes-lambda.pdf

## Aula 03 - Uma experiência com Comparator:
Seguir o link de leitura

    https://docs.oracle.com/javase/10/docs/api/java/util/Comparator.html
    https://www.javatpoint.com/Comparator-interface-in-collection-framework#:~:text=Java%20Comparator%20interface%20is%20used,and%20equals(Object%20element).
    https://www.geeksforgeeks.org/comparator-interface-java/
    https://www.baeldung.com/java-comparator-comparable
    https://www.tutorialspoint.com/java/java_using_comparator.htm

Vamos começar a fazer uma experiência com o comparator que é uma interface do Java 8.

Problema

- Suponha uma classe Product com os atributos name e price.

- Podemos implementar a comparação de produtos por meio da implementação da interface Comparable<Product>

- Entretanto, desta forma nossa classe não fica fechada para alteração: se o critério de comparação mudar, precisaremos alterar a classe Product.

- Podemos então usar o default method "sort" da interface List:

    default void sort(Comparator<? super E> c)

Bom, para isso vamos criar um novo projeto test_comparator e nela iremos ter dois diretórios, application e entities, donde colocamos Program.java e Product.java, respectivamente.

Na classe Product.java colocamos o seguinte

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

Na classe Program.java colocamos o seguinte

    package application;

    import java.util.ArrayList;
    import java.util.Collections;
    import java.util.List;

    import entities.Product;

    public class Program {
        public static void main(String[] args) {
            
            List<Product> list = new ArrayList<>();
            
            list.add(new Product("TV", 900.0));
            list.add(new Product("Notebook", 1200.0));
            list.add(new Product("Tablet", 400.0));
            
            Collections.sort(list);
            
            for (Product p : list) {
                System.out.println(p);
            }
        }
    }

Note que, com o uso do comparable, até agora, podemos usar o Collections.sort() para conseguirmos ordenar a lista que criamos.

Na classe Product.java, vamos usar o comparator, mas para isso vamos ter que tirar a implementação comparable

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

        // (... get / set / hashCode / equals)
        @Override
        public String toString() {
            return "Product [name=" + name + ", price=" + price + "]";
        }
    }

Note que, ao fizermos isso o Program.java exibirá o erro, dizendo que não podemos usar o sort no "Collections". Daí, o que precisamos realizar é o seguinte que é criar uma nova classe MyComparator no diretório application

    package application;

    import java.util.Comparator;

    import entities.Product;

    public class MyComparator implements Comparator<Product> {

        @Override
        public int compare(Product p1, Product p2) {
            // TODO Auto-generated method stub
            return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
        }
        
        
    }

Feito isso, finalmente, no arquivo Program.java vamos realizar o seguinte

    package application;

    import java.util.ArrayList;
    import java.util.List;

    import entities.Product;

    public class Program {
        public static void main(String[] args) {
            
            List<Product> list = new ArrayList<>();
            
            list.add(new Product("TV", 900.0));
            list.add(new Product("Notebook", 1200.0));
            list.add(new Product("Tablet", 400.0));
            
            // Dentro do argumento do sort() vamos ter que passar o comparator.
            list.sort(new MyComparator());
            
            for (Product p : list) {
                System.out.println(p);
            }
        }
    }

No caso, agora, vemos que está ocorrendo a mesma ordenação que tínhamos para comparable.

Bom, a forma de usar o comparator acima é uma das formas, dentre várias existentes.

Agora, vamos mostrar uma outra forma de usar o comparator, desta vez, ignorando a classe MyComparator. Daí, o que podemos realizar é o seguinte, em Program.java

    package application;

    import java.util.ArrayList;
    import java.util.Comparator;
    import java.util.List;

    import entities.Product;

    public class Program {
        public static void main(String[] args) {
            
            List<Product> list = new ArrayList<>();
            
            list.add(new Product("TV", 900.0));
            list.add(new Product("Notebook", 1200.0));
            list.add(new Product("Tablet", 400.0));
            
            Comparator<Product> comp = new Comparator<Product>() {
                @Override
                public int compare(Product p1, Product p2) {
                    // TODO Auto-generated method stub
                    return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
                }
            };
            
            list.sort(comp);
            
            // Dentro do argumento do sort() vamos ter que passar o comparator.
            //list.sort(new MyComparator());
            
            for (Product p : list) {
                System.out.println(p);
            }
        }
    }

Bom, a forma acima tbm nos retornará a mesma ordenação que queremos.

Entretanto, veja que a forma como codamos um comparator diretamente acima é muito verboso. Por isso, vamos implementar a função lambda, que é uma função anônima que permite deixar o código mais enxuto. Então, realizamos em Program.java o seguinte

    package application;

    import java.util.ArrayList;
    import java.util.Comparator;
    import java.util.List;

    import entities.Product;

    public class Program {
        public static void main(String[] args) {
            
            List<Product> list = new ArrayList<>();
            
            list.add(new Product("TV", 900.0));
            list.add(new Product("Notebook", 1200.0));
            list.add(new Product("Tablet", 400.0));
            
            Comparator<Product> comp = (p1, p2) -> {
                return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
            };
            
    //		Comparator<Product> comp = new Comparator<Product>() {
    //			@Override
    //			public int compare(Product p1, Product p2) {
    //				// TODO Auto-generated method stub
    //				return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
    //			}
    //		};
            
            list.sort(comp);
            
            // Dentro do argumento do sort() vamos ter que passar o comparator.
            //list.sort(new MyComparator());
            
            for (Product p : list) {
                System.out.println(p);
            }
        }
    }

Como podemos ver acima, ela retorna a mesma ordenação que queremos, só que desta vez com um código bem mais enxuto.

Bom, a função lambda acima que utilizamos é conhecido tbm como arrow function, como estudei em JavaScript.

Bom, podemos melhorar mais ainda o código tornando-a mais enxuto. Basta fazermos da seguinte forma

    package application;

    import java.util.ArrayList;
    import java.util.Comparator;
    import java.util.List;

    import entities.Product;

    public class Program {
        public static void main(String[] args) {
            
            List<Product> list = new ArrayList<>();
            
            list.add(new Product("TV", 900.0));
            list.add(new Product("Notebook", 1200.0));
            list.add(new Product("Tablet", 400.0));
            
            Comparator<Product> comp = (p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
            
    //		Comparator<Product> comp = (p1, p2) -> {
    //			return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
    //		};
            
    //		Comparator<Product> comp = new Comparator<Product>() {
    //			@Override
    //			public int compare(Product p1, Product p2) {
    //				// TODO Auto-generated method stub
    //				return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
    //			}
    //		};
            
            list.sort(comp);
            
            // Dentro do argumento do sort() vamos ter que passar o comparator.
            //list.sort(new MyComparator());
            
            for (Product p : list) {
                System.out.println(p);
            }
        }
    }

Vemos que ela retorna a lista ordenada como queremos.

Bom, agora, sendo um pouco chato, se quisermos tornar o código mais enxuto ainda, bastaria jogar o código diretamente dentro do sort

    package application;

    import java.util.ArrayList;
    import java.util.Comparator;
    import java.util.List;

    import entities.Product;

    public class Program {
        public static void main(String[] args) {
            
            List<Product> list = new ArrayList<>();
            
            list.add(new Product("TV", 900.0));
            list.add(new Product("Notebook", 1200.0));
            list.add(new Product("Tablet", 400.0));
            
    //		Comparator<Product> comp = (p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
            
    //		Comparator<Product> comp = (p1, p2) -> {
    //			return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
    //		};
            
    //		Comparator<Product> comp = new Comparator<Product>() {
    //			@Override
    //			public int compare(Product p1, Product p2) {
    //				// TODO Auto-generated method stub
    //				return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
    //			}
    //		};
            
    //		list.sort(comp);
            
            list.sort((p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));
            
            // Dentro do argumento do sort() vamos ter que passar o comparator.
            //list.sort(new MyComparator());
            
            for (Product p : list) {
                System.out.println(p);
            }
        }
    }

Resumo da aula

- Comparator objeto de classe separada

- Comparator objeto de classe anônima

- Comparator objeto de expressão lambda com chaves

- Comparator objeto de expressão lambda sem chaves

- Comparator expressão lambda "direto no argumento"

Seguir o link do repositório de resolução do professor

    https://github.com/acenelio/lambda1-java

## Aula 04 - Programação funcional e cálculo lambda:
Seguir links de leitura

    https://medium.com/@nvieirarafael/programa%C3%A7%C3%A3o-funcional-no-java-2a005964cb20
    https://www.devmedia.com.br/programacao-funcional-com-java/32176

Cálculo de Lambdas seguir linds para leituras

    https://pt.wikipedia.org/wiki/C%C3%A1lculo_lambda
    http://www.inf.ufsc.br/~j.barreto/PF/CalLambda.htm

Paradigmas de programação

- Imperativo (C, Pascal, Fortran, Cobol)

- Orientado a objetos (C++, Object Pascal, Java (< 8), C# (< 3))

- Funcional (Haskell, Closure, Clean, Erlang)

- Lógico (Prolog)

- Multiparadigma (JavaScript, Java (8+), C# (3+), Ruby, Python, Go)

Programação Imperativa vs Programação Funcional

    https://pt.stackoverflow.com/questions/127121/o-que-caracteriza-a-programa%C3%A7%C3%A3o-imperativa-e-funcional
    https://pt.wikipedia.org/wiki/Programa%C3%A7%C3%A3o_funcional#:~:text=Em%20ci%C3%AAncia%20da%20computa%C3%A7%C3%A3o%2C%20programa%C3%A7%C3%A3o,mudan%C3%A7as%20no%20estado%20do%20programa.
    https://blog.geekhunter.com.br/quais-sao-os-paradigmas-de-programacao/

É bem importante entender bem esse conceito, então vale a leitura profunda!

O que são "expressões lambda"?

Em programação funcional, expressão lambda corresponde a uma função anônima de primeira classe.

## Aula 05 - Interface funcional:
Interface funcional

É uma interface que possui um único método abstrato. Suas implementações serão tratadas como expressões lambda.

    public class MyComparator implements Comparator<Product> {
        @Override
        public int compare(Product p1, Product p2) {
            return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
        }
    }

    public static void main(String[] args) {

    (...)

    list.sort(new MyComparator());

Algumas outras interfaces funcionais comuns

- Predicate
    
    https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html

- Function
    
    https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html

- Consumer

    https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html

    - Nota: ao contrário das outras interfaces funcionais, no caso do Consumer, é esperado ele possa gerar efeitos colaterais

## Aula 06 - Predicate:
A sintaxe para o uso da interface PRedicate é o seguinte

    public interface Predicate<T> {
        boolean test (T t);
    }

Problema exemplo

    Fazer um programa que, a partir de uma lista de produtos, remova da lista somente aqueles cujo preço mínimo seja 100.

    List<Product> list = new ArrayList<>();
    list.add(new Product("Tv", 900.00));
    list.add(new Product("Mouse", 50.00));
    list.add(new Product("Tablet", 350.50));
    list.add(new Product("HD Case", 80.90));

Seguir o link de resolução do professor

    https://github.com/acenelio/lambda2-java

Bom, vamos criar um novo projeto que visa o uso do predicate com o nome test_predicate, donde dentro desse projeto terá application e entities com arquivos Program.java e Product.java, respectivamente.

No arquivo Program.java, vamos colocar o seguinte

    package application;

    import java.util.ArrayList;
    import java.util.List;

    import entities.Product;

    public class Program {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            List<Product> list = new ArrayList<>();
            
            list.add(new Product("Tv", 900.00));
            list.add(new Product("Mouse", 50.00));
            list.add(new Product("Tablet", 350.50));
            list.add(new Product("HD Case", 80.90));
        }

    }

Agora, no arquivo Product.java, vamos colocar o seguinte

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

        // (... get / set / hashCode / equals)
        @Override
        public String toString() {
            return "Product [name=" + name + ", price=" + price + "]";
        }
    }

Bom, basicamente, o formato acima é o formato padrão que queremos começar a realizar as devidas implementações em cima disso.

No caso, no arquivo Program.java, vamos realizar o seguinte

    package application;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.Locale;

    import entities.Product;

    public class Program {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            Locale.setDefault(Locale.US);
            List<Product> list = new ArrayList<>();
            
            list.add(new Product("Tv", 900.00));
            list.add(new Product("Mouse", 50.00));
            list.add(new Product("Tablet", 350.50));
            list.add(new Product("HD Case", 80.90));
            
            list.removeIf(p -> p.getPrice() >= 100.0);
            
            for (Product p : list) {
                System.out.println(p);
            }
        }

    }

Bom, o formato acima, pelo menos, é o formato que aprendemos anteriormente.

Para o uso do predicate seria da seguinte forma. Vamos ter que criar uma nova classe ProductPredicate dentro do diretório util e dentro dessa classe coloquemos o seguinte

    package util;

    import java.util.function.Predicate;

    import entities.Product;

    public class ProductPredicate implements Predicate<Product> {

        // Método test, conforme foi mostrado na sintaxe
        @Override
        public boolean test(Product p) {
            // TODO Auto-generated method stub
            return p.getPrice() >= 100.0;
        }

    }

Dentro do arquivo Program.java, vamos colocar o seguinte

    package application;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.Locale;

    import entities.Product;
    import util.ProductPredicate;

    public class Program {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            Locale.setDefault(Locale.US);
            List<Product> list = new ArrayList<>();
            
            list.add(new Product("Tv", 900.00));
            list.add(new Product("Mouse", 50.00));
            list.add(new Product("Tablet", 350.50));
            list.add(new Product("HD Case", 80.90));
            
    //		list.removeIf(p -> p.getPrice() >= 100.0);
            list.removeIf(new ProductPredicate());
            
            for (Product p : list) {
                System.out.println(p);
            }
        }

    }

Bom, ao rodarmos o código acima, vamos ver que tudo estará funcionando conforme queremos que funcione.

Versões:

- Implementação da interface
    - Foi feito acima

- Reference method com método estático
    - No caso, na classe Product vamos ter que realizar o seguinte

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
            
            public static boolean staticProductPredicate(Product p) {
                return p.getPrice() >= 100.0;
            }

            // (... get / set / hashCode / equals)
            @Override
            public String toString() {
                return "Product [name=" + name + ", price=" + price + "]";
            }
        }

    Feito o código acima, vamos colocar o seguinte em Program.java, para usarmos esse método

        package application;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Locale;

        import entities.Product;
        import util.ProductPredicate;

        public class Program {

            public static void main(String[] args) {
                // TODO Auto-generated method stub
                Locale.setDefault(Locale.US);
                List<Product> list = new ArrayList<>();
                
                list.add(new Product("Tv", 900.00));
                list.add(new Product("Mouse", 50.00));
                list.add(new Product("Tablet", 350.50));
                list.add(new Product("HD Case", 80.90));
                
        //		list.removeIf(p -> p.getPrice() >= 100.0);
        //		list.removeIf(new ProductPredicate());
                
                // Reference method com método estático
                list.removeIf(Product::staticProductPredicate);
                
                for (Product p : list) {
                    System.out.println(p);
                }
            }

        }

    Testando o código, veremos que ela retornará o que era preciso.

- Reference method com método não estático
    - No caso, na classe Product vamos realizar o seguinte

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
            
            // Reference method com método estático
            // Lembre-se, método estático trabalha com o produto que vc passa como argumento
            public static boolean staticProductPredicate(Product p) {
                return p.getPrice() >= 100.0;
            }
            
            // Reference method com método não estático
            // Como não é estático, então não precisa passar o produto como argumento.
            // Ele trabalha com o próprio Objeto onde ele se encontra
            public boolean nonStaticProductPredicate() {
                return price >= 100.0;
            }

            // (... get / set / hashCode / equals)
            @Override
            public String toString() {
                return name + ", " + price;
            }
        }

    Agora, no arquivo Program.java, vamos realizar o seguinte

        package application;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Locale;

        import entities.Product;
        import util.ProductPredicate;

        public class Program {

            public static void main(String[] args) {
                // TODO Auto-generated method stub
                Locale.setDefault(Locale.US);
                List<Product> list = new ArrayList<>();
                
                list.add(new Product("Tv", 900.00));
                list.add(new Product("Mouse", 50.00));
                list.add(new Product("Tablet", 350.50));
                list.add(new Product("HD Case", 80.90));
                
        //		list.removeIf(p -> p.getPrice() >= 100.0);
        //		list.removeIf(new ProductPredicate());
                
                // Reference method com método estático
        //		list.removeIf(Product::staticProductPredicate);
                
                // Reference method com método não estático
                list.removeIf(Product::nonStaticProductPredicate);
                
                for (Product p : list) {
                    System.out.println(p);
                }
            }

        }

    Assim, tudo estará funcionando da mesma forma como queríamos que funcionasse.

- Expressão lambda declarada
    - Bom, agora, vai ficar mais interessante. No caso, vamos deixar o código bem mais enxuto. No caso, em Program.java, vamos criar uma variável da seguinte forma

        package application;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Locale;
        import java.util.function.Predicate;

        import entities.Product;

        public class Program {

            public static void main(String[] args) {
                // TODO Auto-generated method stub
                Locale.setDefault(Locale.US);
                List<Product> list = new ArrayList<>();
                
                list.add(new Product("Tv", 900.00));
                list.add(new Product("Mouse", 50.00));
                list.add(new Product("Tablet", 350.50));
                list.add(new Product("HD Case", 80.90));
                
        //		list.removeIf(p -> p.getPrice() >= 100.0);
        //		list.removeIf(new ProductPredicate());
                
                // Reference method com método estático
        //		list.removeIf(Product::staticProductPredicate);
                
                // Reference method com método não estático
        //		list.removeIf(Product::nonStaticProductPredicate);
                
                // Expressão lambda declarada
                Predicate<Product> pred = p -> p.getPrice() >= 100.0;
                list.removeIf(pred);
                
                for (Product p : list) {
                    System.out.println(p);
                }
            }

        }

    Ao rodarmos o código, vemos que foi devolvido a mesma forma que queremos.

- Expressão lambda inline
    - Bom, é a forma em que vc passa diretamente o arrow function sem realizar nenhuma declaração. No caso, em Program.java vamos realizar o seguinte

        package application;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Locale;
        import java.util.function.Predicate;

        import entities.Product;

        public class Program {

            public static void main(String[] args) {
                // TODO Auto-generated method stub
                Locale.setDefault(Locale.US);
                List<Product> list = new ArrayList<>();
                
                list.add(new Product("Tv", 900.00));
                list.add(new Product("Mouse", 50.00));
                list.add(new Product("Tablet", 350.50));
                list.add(new Product("HD Case", 80.90));
                
        //		list.removeIf(p -> p.getPrice() >= 100.0);
        //		list.removeIf(new ProductPredicate());
                
                // Reference method com método estático
        //		list.removeIf(Product::staticProductPredicate);
                
                // Reference method com método não estático
        //		list.removeIf(Product::nonStaticProductPredicate);
                
                // Expressão lambda declarada
                // Forma parametrizada
        //		double min = 100.0;
        //		Predicate<Product> pred = p -> p.getPrice() >= min;
        //		list.removeIf(pred);
                
                // Expressão lambda inline
                double min = 100.0;
                list.removeIf(p -> p.getPrice() >= min);
                
                for (Product p : list) {
                    System.out.println(p);
                }
            }

        }

## Aula 07 - Consumer:
Bom, a abordagem desse conceito será feito analogamente com a aula antecessor.

A sintaxe do consumer, basicamente, é o seguinte

    public interface Consumer<T> {
        void accept (T t);
    }

Vamos criar um novo projeto com o nome test_consumer e dentro dela colocamos dois diretórios, application, entities e util, donde criamos os arquivos Program.java, Product.java e ProductPredicate.java, respectivamente.

Versões:

- Implementação da interface
    - Bom, para a realização da implementação da interface, vamos fazer o seguinte.

    No arquivo

- Reference method com método estático

- Reference method com método não estático

- Expressão lambda declarada

- Expressão lambda inline

## Aula 08 - Function:

## Aula 09 - Criando funções que recebem funções como parâmetro:

## Aula 10 - Stream:

## Aula 11 - Pipeline (demo):

## Aula 12 - Exercício resolvido (stream):

## Aula 13 - Exercício de fixação:
