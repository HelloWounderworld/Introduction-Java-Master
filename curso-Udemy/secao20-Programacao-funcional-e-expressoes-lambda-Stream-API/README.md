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

## Aula 04 - Programação funcional e cálculo lambda - Funções lambdas:
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

Seguir as classes "Soma", "Multiplicar", "CalculoTese1" e "CalculoTeste2" e a interface "Calculo" do pacote "lambda" do projeto "exercicios".

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

Obs: Existem várias, mas várias, interfaces funcionais.

    https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html

Seguir o interface "Calculo" e a classe "CalculoTeste2" do pacote "lambdas" do projeto "exercicios".

### Usando interfaces funcionais disponíveis em Java:
Seguir a classe "CalculoTeste3" do pacote "lambdas" do projeto "exercicios".

### Usando o Foreach Funcional:
Seguir a classe "Foreach" do pacote "lambdas" do projeto "exercicios".

## Aula 06 - Predicate (Predicado):
A sintaxe para o uso da interface Predicate é o seguinte

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

Obs: Existem várias, mas várias, interfaces funcionais.

    https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html

Seguir as classes "Predicado" e "Produto" no pacote "lambdas" do projeto "exercicios".

Seguir a classe "PredicadoComposicoes" no pacote "lambdas" do projeto "exercicios".

## Aula 07 - Consumer (Consumidor):
Bom, a abordagem desse conceito será feito analogamente com a aula antecessor.

A sintaxe do consumer, basicamente, é o seguinte

    public interface Consumer<T> {
        void accept (T t);
    }

Vamos criar um novo projeto com o nome test_consumer e dentro dela colocamos dois diretórios, application, entities e util, donde criamos os arquivos Program.java, Product.java e PriceUpdate.java, respectivamente.

Seguir o link de resolução do professor

    https://github.com/acenelio/lambda3-java

Na classe Product, vamos colocar o seguinte

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
            return name + ", " + String.format("%.2f", price);
        }
    }

Versões:

- Implementação da interface
    - Bom, para a realização da implementação da interface, vamos fazer o seguinte.

    No arquivo Program.java colocamos o seguinte

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
                
                // Dentro desse forEach que vamos colocar um consumer
                list.forEach();
            }

        }

    Note que, ao usarmos o forEach, foi mostrado que precisamos implementar a interface consumer para o uso do forEach.

    Em seguida, no arquivo PriceUpdate.java, colocamos o seguinte, que será onde vamos adotar o consumer

        package util;

        import java.util.function.Consumer;

        import entities.Product;

        public class PriceUpdate implements Consumer<Product> {

            @Override
            public void accept(Product t) {
                // TODO Auto-generated method stub
                
            }

        }

    Nela, vamos realizar a seguinte configuração

        package util;

        import java.util.function.Consumer;

        import entities.Product;

        public class PriceUpdate implements Consumer<Product> {

            @Override
            public void accept(Product p) {
                // TODO Auto-generated method stub
                p.setPrice(p.getPrice() * 1.1);
            }

        }

    Agora, no arquivo Program.java, vamos usar o seguinte

        package application;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Locale;

        import entities.Product;
        import util.PriceUpdate;

        public class Program {

            public static void main(String[] args) {
                // TODO Auto-generated method stub
                
                Locale.setDefault(Locale.US);
                List<Product> list = new ArrayList<>();
                
                list.add(new Product("Tv", 900.00));
                list.add(new Product("Mouse", 50.00));
                list.add(new Product("Tablet", 350.50));
                list.add(new Product("HD Case", 80.90));
                
                // Dentro desse forEach que vamos colocar um consumer
                list.forEach(new PriceUpdate());
                
                list.forEach(System.out::println);
            }

        }

    Vemos que, agora, está sendo feito a atualização dos produtos.

- Reference method com método estático
    - Na classe Product, vamos colocar o seguinte

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
            
            // Reference method com método estático
            public static void staticPriceUpdate(Product p) {
                p.setPrice(p.getPrice() * 1.1);
            }

            // (... get / set / hashCode / equals)
            @Override
            public String toString() {
                return name + ", " + String.format("%.2f", price);
            }
        }

    Em seguida, em Program.java, vamos colocar o seguinte, para chamarmos esse método estático que definimos acima

        package application;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Locale;

        import entities.Product;
        import util.PriceUpdate;

        public class Program {

            public static void main(String[] args) {
                // TODO Auto-generated method stub
                
                Locale.setDefault(Locale.US);
                List<Product> list = new ArrayList<>();
                
                list.add(new Product("Tv", 900.00));
                list.add(new Product("Mouse", 50.00));
                list.add(new Product("Tablet", 350.50));
                list.add(new Product("HD Case", 80.90));
                
                // Dentro desse forEach que vamos colocar um consumer
        //		list.forEach(new PriceUpdate());
                
                // Reference method com método estático
                list.forEach(Product::staticPriceUpdate);
                
                list.forEach(System.out::println);
            }

        }

    Note que, conseguimos atualizar da devida forma.

- Reference method com método não estático
    - Para esse método não estático, basta realizar o seguinte na classe Product

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
            
            // Reference method com método estático
            public static void staticPriceUpdate(Product p) {
                p.setPrice(p.getPrice() * 1.1);
            }
            
            // Reference method com método estático
            public void nonStaticPriceUpdate() {
        //		setPrice(getPrice() * 1.1);
                price = price * 1.1;
            }

            // (... get / set / hashCode / equals)
            @Override
            public String toString() {
                return name + ", " + String.format("%.2f", price);
            }
        }

    Agora, no Progam.java, vamos colocar o seguinte

        package application;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Locale;

        import entities.Product;
        import util.PriceUpdate;

        public class Program {

            public static void main(String[] args) {
                // TODO Auto-generated method stub
                
                Locale.setDefault(Locale.US);
                List<Product> list = new ArrayList<>();
                
                list.add(new Product("Tv", 900.00));
                list.add(new Product("Mouse", 50.00));
                list.add(new Product("Tablet", 350.50));
                list.add(new Product("HD Case", 80.90));
                
                // Dentro desse forEach que vamos colocar um consumer
        //		list.forEach(new PriceUpdate());
                
                // Reference method com método estático
        //		list.forEach(Product::staticPriceUpdate);
                
                // Reference method com método não estático
                list.forEach(Product::nonStaticPriceUpdate);
                
                list.forEach(System.out::println);
            }

        }

- Expressão lambda declarada
    - Analogamente, como foi visto antes em predicates, conseguimos usar o arrow function para tornar o código bem mais enxuto. No caso, em Program.java, vamos realizar o seguinte

        package application;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Locale;
        import java.util.function.Consumer;

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
                
                // Dentro desse forEach que vamos colocar um consumer
        //		list.forEach(new PriceUpdate());
                
                // Reference method com método estático
        //		list.forEach(Product::staticPriceUpdate);
                
                // Reference method com método não estático
        //		list.forEach(Product::nonStaticPriceUpdate);
                
                double factor = 1.1;
                Consumer<Product> cons = p -> {
                    p.setPrice(p.getPrice() * factor);
                };
                list.forEach(cons);
                
                list.forEach(System.out::println);
            }

        }

    Podemos ver aqui que funcionou perfeitamente.

- Expressão lambda inline
    - Vamos deixar bem mais enxuto

        package application;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Locale;
        import java.util.function.Consumer;

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
                
                // Dentro desse forEach que vamos colocar um consumer
        //		list.forEach(new PriceUpdate());
                
                // Reference method com método estático
        //		list.forEach(Product::staticPriceUpdate);
                
                // Reference method com método não estático
        //		list.forEach(Product::nonStaticPriceUpdate);
                
                // Expressão lambda declarada
                double factor = 1.1;
        //		Consumer<Product> cons = p -> {
        //			p.setPrice(p.getPrice() * factor);
        //		};
        //		Consumer<Product> cons = p -> p.setPrice(p.getPrice() * factor);
        //		list.forEach(cons);
                
                // Expressão lambda inline
                list.forEach(p -> p.setPrice(p.getPrice() * factor));
                
                list.forEach(System.out::println);
            }

        }

Obs: Existem várias, mas várias, interfaces funcionais.

    https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html

Seguir as classes "Produto" e "Consumidor" do pacote "lambdas" do projeto "exercicios".

## Aula 08 - Function:
A sintaxe da function é o seguinte

    public interface Function<T, R> {
        R apply (T t);
    }

Seguir o link da resolução do professor

    https://github.com/acenelio/lambda4-java

Vamos criar um novo projeto disso denotado como test_function, donde vamos ter os seguintes diretórios application, entities e util, donde coloquemos os arquivos Program.java, Product.java e UpperCaseName.java.

Em Program.java vamos colocar o seguinte

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
        }

    }

Em Product.java, vamos colocar o seguinte

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
        
        // Reference method com método estático
        public static void staticPriceUpdate(Product p) {
            p.setPrice(p.getPrice() * 1.1);
        }
        
        // Reference method com método não estático
        public void nonStaticPriceUpdate() {
    //		setPrice(getPrice() * 1.1);
            price = price * 1.1;
        }

        // (... get / set / hashCode / equals)
        @Override
        public String toString() {
            return name + ", " + String.format("%.2f", price);
        }
    }

Versões:

- Implementação da interface
    - Vamos implementar de forma normal a function. No caso, na classe UpperCaseName, vamos colocar o seguinte

        package util;

        import java.util.function.Function;

        import entities.Product;

        public class UpperCaseName implements Function<Product, String> {

            @Override
            public String apply(Product p) {
                // TODO Auto-generated method stub
                return p.getName().toUpperCase();
            }

        }

    Agora, no arquivo Program.java vamos colocar o seguinte para conseguirmos aplicar esse método configurado

        package application;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Locale;
        import java.util.stream.Collectors;

        import entities.Product;
        import util.UpperCaseName;

        public class Program {

            public static void main(String[] args) {
                // TODO Auto-generated method stub
                Locale.setDefault(Locale.US);
                List<Product> list = new ArrayList<>();
                
                list.add(new Product("Tv", 900.00));
                list.add(new Product("Mouse", 50.00));
                list.add(new Product("Tablet", 350.50));
                list.add(new Product("HD Case", 80.90));
                
                List<String> names = list.stream().map(new UpperCaseName()).collect(Collectors.toList());
                
                names.forEach(System.out::println);
            }

        }

    Vamos ver se está tudo funcionando.

- Reference method com método estático
    - Na classe Product.java vamos realizar a seguinte implementação

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
            
            // Reference method com método estático
            public static void staticPriceUpdate(Product p) {
                p.setPrice(p.getPrice() * 1.1);
            }
            
            // Reference method com método não estático
            public void nonStaticPriceUpdate() {
        //		setPrice(getPrice() * 1.1);
                price = price * 1.1;
            }
            
            // Reference method com método estático
            public static String staticUpperCaseName(Product p) {
                return p.getName().toUpperCase();
            }

            // (... get / set / hashCode / equals)
            @Override
            public String toString() {
                return name + ", " + String.format("%.2f", price);
            }
        }

    Agora, no Program.java, vamos realizar o seguinte

        package application;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Locale;
        import java.util.stream.Collectors;

        import entities.Product;
        import util.UpperCaseName;

        public class Program {

            public static void main(String[] args) {
                // TODO Auto-generated method stub
                Locale.setDefault(Locale.US);
                List<Product> list = new ArrayList<>();
                
                list.add(new Product("Tv", 900.00));
                list.add(new Product("Mouse", 50.00));
                list.add(new Product("Tablet", 350.50));
                list.add(new Product("HD Case", 80.90));
                
        //		List<String> names = list.stream().map(new UpperCaseName()).collect(Collectors.toList());
                
                // Reference method com método estático
                List<String> names = list.stream().map(Product::staticUpperCaseName).collect(Collectors.toList());
                
                names.forEach(System.out::println);
            }

        }

- Reference method com método não estático
    - Analogamente, vamos realizar o seguinte, no arquivo Product.java

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
            
            // Reference method com método estático
            public static void staticPriceUpdate(Product p) {
                p.setPrice(p.getPrice() * 1.1);
            }
            
            // Reference method com método não estático
            public void nonStaticPriceUpdate() {
        //		setPrice(getPrice() * 1.1);
                price = price * 1.1;
            }
            
            // Reference method com método estático
            public static String staticUpperCaseName(Product p) {
                return p.getName().toUpperCase();
            }
            
            // Reference method com método não estático
            public String nonStaticUpperCaseName() {
                return name.toUpperCase();
            }

            // (... get / set / hashCode / equals)
            @Override
            public String toString() {
                return name + ", " + String.format("%.2f", price);
            }
        }

    Agora, no arquivo Program.java, coloquemos o seguinte

        package application;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Locale;
        import java.util.stream.Collectors;

        import entities.Product;
        import util.UpperCaseName;

        public class Program {

            public static void main(String[] args) {
                // TODO Auto-generated method stub
                Locale.setDefault(Locale.US);
                List<Product> list = new ArrayList<>();
                
                list.add(new Product("Tv", 900.00));
                list.add(new Product("Mouse", 50.00));
                list.add(new Product("Tablet", 350.50));
                list.add(new Product("HD Case", 80.90));
                
        //		List<String> names = list.stream().map(new UpperCaseName()).collect(Collectors.toList());
                
                // Reference method com método estático
        //		List<String> names = list.stream().map(Product::staticUpperCaseName).collect(Collectors.toList());
                
                // Reference method com método não estático
                        List<String> names = list.stream().map(Product::nonStaticUpperCaseName).collect(Collectors.toList());
                
                names.forEach(System.out::println);
            }

        }

- Expressão lambda declarada
    - Agora, a forma enxuta vamos fazer o seguinte no Program.java

        package application;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Locale;
        import java.util.function.Function;
        import java.util.stream.Collectors;

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
                
        //		List<String> names = list.stream().map(new UpperCaseName()).collect(Collectors.toList());
                
                // Reference method com método estático
        //		List<String> names = list.stream().map(Product::staticUpperCaseName).collect(Collectors.toList());
                
                // Reference method com método não estático
        //		List<String> names = list.stream().map(Product::nonStaticUpperCaseName).collect(Collectors.toList());
                
                // Expressão lambda declarada
                Function<Product, String> func = p -> p.getName().toUpperCase();
                List<String> names = list.stream().map(func).collect(Collectors.toList());
                
                names.forEach(System.out::println);
            }

        }

- Expressão lambda inline
    - O Formato mais enxuto possível

        package application;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Locale;
        import java.util.function.Function;
        import java.util.stream.Collectors;

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
                
        //		List<String> names = list.stream().map(new UpperCaseName()).collect(Collectors.toList());
                
                // Reference method com método estático
        //		List<String> names = list.stream().map(Product::staticUpperCaseName).collect(Collectors.toList());
                
                // Reference method com método não estático
        //		List<String> names = list.stream().map(Product::nonStaticUpperCaseName).collect(Collectors.toList());
                
                // Expressão lambda declarada
        //		Function<Product, String> func = p -> p.getName().toUpperCase();
        //		List<String> names = list.stream().map(func).collect(Collectors.toList());
                
                // Expressão lambda inline
                List<String> names = list.stream().map(p -> p.getName().toUpperCase()).collect(Collectors.toList());
                
                names.forEach(System.out::println);
            }

        }

Obs: Existem várias, mas várias, interfaces funcionais.

    https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html

Seguir a classe "Funcao" do pacote "lambdas" do projeto "exercicios".

## Aula 09 - Supplier (Fornecedor):
Seguir a classe "Fornecedor" do pacote "lambdas" do projeto "exercicios".

## Aula 10 - Unary Operator (Operador Unário):
Seguir a classe "OperadorUnario" do pacote "lambdas" do projeto "exercicios".

## Aula 11 - Binary Operator e BiFunction (Operador Binário e Função Bi):
Seguir a classe "OperadorBinario" do pacote "lambdas" do projeto "exercicios".

### Desafio - Operador Binário:
Seguir a classe "Desafio" do pacote "lambdas" do projeto "exercicios".

### Extra - Interfaces Funcionais Antes de Java 8:
Seguir as classes "Threads" e "Trabalho1" do pacote "lambdas" do projeto "exercicios".

## Aula 12 - Criando funções que recebem funções como parâmetro:
Seguir o link de resolução do professor

    https://github.com/acenelio/lambda5-java

Revisar esse conceito!!! Pois é bem importante!

## Aula 13 - Stream, List e Iterator:
Seguir o link de leitura

    http://www.oracle.com/technetwork/pt/articles/java/streams-api-java-8-3410098-ptb.html
    https://www.geeksforgeeks.org/stream-in-java/
    https://www.tutorialspoint.com/java8/java8_streams.htm#:~:text=Stream%20is%20a%20new%20abstract,)%2C%20employee_id%2C%20employee_name%20FROM%20Employee

Stream

- É uma sequencia de elementos advinda de uma fonte de dados que 
oferece suporte a "operações agregadas".
    - Fonte de dados: coleção, array, função de iteração, recurso de E/S

Características

- Stream é uma solução para processar sequências de dados de forma:
    - Declarativa (iteração interna: escondida do programador)

    - Parallel-friendly (imutável -> thread safe)

    - Sem efeitos colaterais

    - Sob demanda (lazy evaluation)

- Acesso sequencial (não há índices)

- Single-use: só pode ser "usada" uma vez

- Pipeline: operações em streams retornam novas streams. Então é possível criar uma cadeia de operações (fluxo de processamento).

Operações intermediárias e terminais

- O pipeline é composto por zero ou mais operações intermediárias e uma terminal.

- Operação intermediária: 
    - Produz uma nova streams (encadeamento)

    - Só executa quando uma operação terminal é invocada (lazy evaluation)

- Operação terminal:
    - Produz um objeto não-stream (coleção ou outro)

    - Determina o fim do processamento da stream

Operações intermediárias

- filter

- map

- flatmap

- peek

- distinct

- sorted

- skip

- limit (*)

Operações terminais

- forEach

- forEachOrdered

- toArray

- reduce

- collect

- min

- max

- count

- anyMatch (*)

- allMatch (*)

- noneMatch (*)

- findFirst (*)

- findAny (*)

Criar uma stream

- Basta chamar o método stream() ou parallelStream() a partir 
de qualquer objeto Collection.

    https://docs.oracle.com/javase/10/docs/api/java/util/Collection.html
    
- Outras formas de se criar uma stream incluem:
    - Stream.of

    - Stream.ofNullable

    - Stream.iterate

Vamos ver na prática como os streams funcionam. No caso, vamos criar um novo projeto test_stream e dentro dela colocar apenas application com o arquivo Program.java.

No caso, em Program.java coloquemos o seguinte

    package application;

    import java.util.Arrays;
    import java.util.List;
    import java.util.stream.Stream;

    public class Program {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            
            List<Integer> list = Arrays.asList(3, 4, 5, 10, 7);
            Stream<Integer> st1 = list.stream();
            System.out.println(Arrays.toString(st1.toArray()));
            
            Stream<String> st2 = Stream.of("Maria", "Alex", "Bob");
            System.out.println(Arrays.toString(st2.toArray()));
            
            Stream<Integer> st3 = Stream.iterate(0, x -> x + 2);
            System.out.println(Arrays.toString(st3.limit(10).toArray()));
            
            Stream<Long> st4 = Stream.iterate(new long[] { 0L, 1L }, p -> new long[] { p[1], p[0] + p[1] }).map(p -> p[0]);
            System.out.println(Arrays.toString(st4.limit(10).toArray()));
        }

    }

Revisar esse conceito!!! Muito importante!!!

Seguir a classe "ImprimindoObjeto" do pacote "streams" do projeto "exercicios".

Seguir a classe "CriandStreams" do pacote "streams" do projeto "exercicios".

### Uso do Map em Stream:
Seguir a classe "Map" do pacote "streams" do projeto "exercicios".

### Desafio - Map em Stream:
Seguir a classe "DesafioMap" do pacote "streams" do projeto "exercicios".

### Uso do Filter em Stream:
Seguir a classe 

### Desafio - Uso do Filter em Stream:

### Uso do Reduce em Stream:

### Uso do Match em Stream:

## Aula 14 - Pipeline (demo):
Seguir link para leitura

    https://medium.com/@deepakbapat/the-pipeline-design-pattern-in-java-831d9ce2fe21
    https://java-design-patterns.com/patterns/pipeline/#explanation
    https://stackify.com/streams-guide-java-8/#:~:text=A%20stream%20pipeline%20consists%20of,operations%2C%20and%20a%20terminal%20operation.

Vamos criar um novo projeto para testarmos o pipeline. Denotamos o projeto com o seguinte nome test_pipeline com application e Program.java.

Em Program.java, vamos colocar o seguinte

    package application;

    import java.util.Arrays;
    import java.util.List;
    import java.util.stream.Collectors;
    import java.util.stream.Stream;

    public class Program {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            List<Integer> list = Arrays.asList(3, 4, 5, 10, 7);
            
            Stream<Integer> st1 = list.stream().map(x -> x * 10);
            System.out.println(Arrays.toString(st1.toArray()));
            
            int sum = list.stream().reduce(0, (x, y) -> x + y);
            System.out.println("Sum = " + sum);
            
            List<Integer> newList = list.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x * 10)
                .collect(Collectors.toList());
            
            System.out.println(Arrays.toString(newList.toArray()));
        }

    }

## Aula 15 - Exercício resolvido (stream):
Exercício resolvido - filter, sorted, map, reduce

Seguir o enunciado

    Fazer um programa para ler um conjunto de produtos a partir de um arquivo em formato .csv (suponha que exista pelo menos um produto).

    Em seguida mostrar o preço médio dos produtos. Depois, mostrar os nomes, em ordem decrescente, dos produtos que possuem preço inferior ao preço médio.

- InputFile

    Tv,900.00
    Mouse,50.00
    Tablet,350.50
    HD Case,80.90
    Computer,850.00
    Monitor,290.00

- Execution

    Enter full file path: c:\temp\in.txt
    Average price: 420.23
    Tablet
    Mouse
    Monitor
    HD Case

Seguir o link da resolução

    https://github.com/acenelio/lambda6-java

## Aula 16 - Exercício de fixação:
Seguir o enunciado

    Fazer um programa para ler os dados (nome, email e salário)de funcionários a partir de um arquivo em formato .csv.

    Em seguida mostrar, em ordem alfabética, o email dos funcionários cujo salário seja superior a um dado valor fornecido pelo usuário.

    Mostrar também a soma dos salários dos funcionários cujo nome começa com a letra 'M'.

Example

- inputFile

    Maria,maria@gmail.com,3200.00
    Alex,alex@gmail.com,1900.00
    Marco,marco@gmail.com,1700.00
    Bob,bob@gmail.com,3500.00
    Anna,anna@gmail.com,2800.00

- Execute

    Enter full file path: c:\temp\in.txt
    Enter salary: 2000.00
    Email of people whose salary is more than 2000.00:
    anna@gmail.com
    bob@gmail.com
    maria@gmail.com
    Sum of salary of people whose name starts with 'M': 4900.00

Seguir o link de resolução do professor

    https://github.com/acenelio/lambda7-java

Tente resolver primeiro para depois comparar com a resolução do professor.
