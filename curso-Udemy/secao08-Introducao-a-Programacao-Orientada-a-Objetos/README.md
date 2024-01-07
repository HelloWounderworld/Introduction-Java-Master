# Seção 08: Introdução à Programação Orientada a Objeto:

## Aula 01 - Visão geral do capítulo e Aula 02 -  Material de apoio do capítulo:
MATERIAL DE APOIO DO CAPÍTULO

Seja muito bem-vindo(a) ao capítulo Introdução à Programação Orientada a Objetos!

Aqui você pode baixar o material de apoio usado nas aulas do capítulo, para que você possa aproveitar ao máximo as aulas sem precisar ficar anotando muito.

(se o link não estiver acessível abaixo, por favor acesse o botão "Recursos disponíveis" no canto da tela)

Grande abraço e bons estudos! Nelio.

Recursos para esta aula

    03-classes-atributos-membros-staticos(para-anotacoes).pdf
    03-classes-atributos-membros-staticos.pdf

## Aula 03 - Resolvendo um problema sem orientação a objetos:
Bom, vamos, primeiro, resolver um problema sem usar o conceito de orientação à objetos, pois depois iremos usar a orientação à objetos para mostrarmos como tudo torna fácil.

Antes de irmos ao problema, deixa eu esclarecer um ponto. A Orientação aos Objetos, esse conceito surgiu puramente na matemática. Um estudo disso seria a Teoria de Categoria, que é um dos assuntos mais complicados e avançados que existem em matemática e, dentro dessa teoria, existe uma teoria chamado de tipagens que é o que originou toda a ideia de orientação à objetos que, mais tarde, foi introduzido ao mundo da programação.

Vale ressaltar que a teoria de categoria é um assunto bem antigo que já havia sendo estudado desde do século 20. Porém, nos cursos de programação são pouco abordado esse assunto, devido ao seu nível de complexidade alta para entendimento. Seria necessário o aluno conhecer muita, mas muita, análise matemática, fundamentos da matemática e lógica abstrata para que ele consiga entender essa teoria. Bom, mas qual seria a vantagem de entender categoria para programação? Seria que, tudo ficaria intuitivo e vc não terá dificuldade nenhuma de aprender a programação e esperar o que aquela linguagem de programação POO já teria como utilidade. É como se soubesse programar e saber tudo o que ele é capaz de fazer sem conhecer uma linguagem de programação POO.

Bom, segue um link para referência

    https://dev.to/kspeakman/category-theory-is-object-oriented-3l8k
    
    https://cstheory.stackexchange.com/questions/21387/whats-the-relation-between-oop-and-category-theory

Bom, vamos agora à resolução do problema

    Fazer um programa para ler as medidas dos lados de dois triângulos X e Y (suponha medidas válidas). Em seguida, mostrar o valor das áreas dos dois triângulos e dizer qual dos dois triângulos possui a maior área.
    A fórmula para calcular a área de um triângulo a partir das medidas de seus lados a, b e c é a seguinte (fórmula de Heron).

    Enter the measures of triangle X:
    3.00
    4.00
    5.00
    Enter the measures of triangle Y:
    7.50
    4.50
    4.02
    Triangle X area: 6.0000
    Triangle Y area: 7.5638
    Larger area: Y

Bom, o código para resolver esse problema é bem simples, sem o uso de orientação à objetos

    import java.util.Locale;
    import java.util.Scanner;
    public class Program {
        public static void main(String[] args) {

            Locale.setDefault(Locale.US);
            Scanner sc = new Scanner(System.in);

            double xA, xB, xC, yA, yB, yC;

            System.out.println("Enter the measures of triangle X: ");
            xA = sc.nextDouble();
            xB = sc.nextDouble();
            xC = sc.nextDouble();

            System.out.println("Enter the measures of triangle Y: ");
            yA = sc.nextDouble();
            yB = sc.nextDouble();
            yC = sc.nextDouble();

            double p = (xA + xB + xC) / 2.0;
            double areaX = Math.sqrt(p * (p - xA) * (p - xB) * (p - xC));
            p = (yA + yB + yC) / 2.0;
            double areaY = Math.sqrt(p * (p - yA) * (p - yB) * (p - yC));

            System.out.printf("Triangle X area: %.4f%n", areaX);
            System.out.printf("Triangle Y area: %.4f%n", areaY);

            if (areaX > areaY) {
                System.out.println("Larger area: X");
            }
            else {
                System.out.println("Larger area: Y");
            }

            sc.close();
        }
    }


## Aula 04 - Criando uma classe com três atributos para representar melhor o triângulo:
Bom, agora, vamos implementar os conceitos de orientação à objetos para resolvermos o mesmo problema!

Bom, vamos lá. Entendendo um pouco mais à fundo sobre o conceito de orientação à objetos. No caso, no exemplo do problema anterior, codamos uma função que soluciona o problema de um triângulo. Entretanto, para isso foi necessário criar várias variáveis que serviria como uma representação de um triângulo, o que torna algo custoso no quesito de quantidade de linhas e códigos. Para isso, temos o conceito de classe, que nos permite criar uma definição do que é triângulo e sempre que formos trabalhar com algo que seja necessário o uso de algum triângulo, em vez de toda hora termos que definir várias variáveis, vamos precisar usar somente essa definição.

No caso, isso, no ponto de vista matemático é como se vc estivesse estabelecendo alguma base axiomática pronta ou alguma definição pronta para vc trabalhar acima disso, o que seria muito econômico no ponto de vista de esforço, pois imagine se na matemática sempre que vc for definir alguma função, vc ter que sempre ficar definindo uma função para a finalidade x, e outra função para finalidade y, etc... A melhor forma aqui seria definir o que é uma função e sempre que vc for usar chamar essa definição para, simplesmente, aplicar ela para as suas finalidade necessárias, o que economizaria bastante o seu esforço.

Ou seja, basicamente, a grosso modo e a nível de computação, podemos entender classes como se fosse as definições que vc cria e usa ela sempre que for necessária sem a necessidade de ter que ficar toda hora criando várias variáveis conforme a necessidade, pois isso tornaria muito custoso tanto pelo esforço quanto pela quantidade de memória que seria consumida pela sua máquina.

Bom, vamos ver agora a sintaxe para definir uma classe

    package entities;
    public class Triangle {

        public double a;
        public double b;
        public double c;
    }

No caso, começando com o public class, vc nomeia ele como vc quiser, nesse caso "Triangle", seguindo as boas práticas de definir nomes para classes, daí em seguida, dentro dessa classe vamos definir os atributos dela ou métodos dela.

Sempre que formos chamar essa classe a sintaxe certa seria o seguinte

    Triangle x, y;
    x = new Triangle();
    y = new Triangle();

Bom, agora, vamos criar um outro projeto com o nome "course" e dentro dela, na pasta src, criamos duas pastas, uma application onde teremos o arquivo Java com o nome Program.java e a outra pasta chamado entities com o arquivo Java Triangle.java.

Agora, no arquivo Program realizamos a seguinte modificação do código que foi feito na última aula

    package application;

    import java.util.Locale;
    import java.util.Scanner;

    import entities.Triangle;

    public class Program {
        public static void main(String[] args) {

            Locale.setDefault(Locale.US);
            Scanner sc = new Scanner(System.in);

            Triangle x, y;

            x = new Triangle();
            y = new Triangle();

            System.out.println("Enter the measures of triangle X: ");
            x.a = sc.nextDouble();
            x.b = sc.nextDouble();
            x.c = sc.nextDouble();

            System.out.println("Enter the measures of triangle Y: ");
            y.a = sc.nextDouble();
            y.b = sc.nextDouble();
            y.c = sc.nextDouble();

            double p = (x.a + x.b + x.c) / 2.0;
            double areaX = Math.sqrt(p * (p - x.a) * (p - x.b) * (p - x.c));
            p = (y.a + y.b + y.c) / 2.0;
            double areaY = Math.sqrt(p * (p - y.a) * (p - y.b) * (p - y.c));

            System.out.printf("Triangle X area: %.4f%n", areaX);
            System.out.printf("Triangle Y area: %.4f%n", areaY);

            if (areaX > areaY) {
                System.out.println("Larger area: X");
            }
            else {
                System.out.println("Larger area: Y");
            }

            sc.close();
        }
    }

e no arquivo Triangle.java realizamos a seguinte

    package entities;

    public class Triangle {

        public double a;
        public double b;
        public double c;

    }

No caso, isso irá funcionar da mesma forma que a resolução que fizemos sem o uso de POO.

No caso, de forma abstrata, o que está acontecendo? Visto que teoria de categoria é vc partir de um objeto e apontar para o outro objeto, onde isso está acontecendo? Ele acontece exatamente quando apontamos os elementos que estão dentro do objeto Stack para os elementos que estão dentro do objeto Heap, ambos dentro de uma memória.

Seguir a classe "Produto" e "ProdutoTeste" do projeto "exercicios" do pacote "classe", para abordar mais dos conceitos.

Para melhor entendimento do conceito de classe, seguir com a leitura dos dois livros, depois que realizar o curso da Udemy

    Fundamentals of Java Programming, Mitsunori Ogihara

    Java como programar, 10ª Edição, Paul Deitel

Lembrando, que, eu, Leonardo, pelo menos, tenho a ideia de que o curso da Udemy não é uma espécie de estudo. Mas, sim, para te fornecer uma visão geral sobre o conceito que vc está estudando. O estudo, para mim, começa essencialmente quando realizo uma leitura de um bom livro, donde tais conceitos abordados de forma superficial na Udemy, para tornar o conceito abstrado em algo concreto dentro da minha mente.

Lembrando que, em programação, o código, ela evolui conforme o tempo. Porém, a base conceitual delas, sempre será a mesma, pois toda a linguagem de programação ela é originada de conceitos matemáticos que nunca será substituida. Bom, assim espero kkkkkkkk

Logo, o que torna mais importante em programação, não é a codificação em si. Mas, sim, o conceito que lhe é aplicado sobre ela.

### Desafio - Classe Data:
Dentro do projeto "exercicio" do pacote "classe", criamos nela duas classes "Data" e "DataTeste".

Na classe "Data", definimos três atributos

    dia, mes, ano

E dentro da classe "DataTeste" teremos o método main, nela iremos instanciar duas datas.

## Aula 05 - Criando um método para obtermos os benefícios de reaproveitamento e delegação:
Vamos agora criar os métodos.

No caso, na classe Triangle criada, vamos criar um método para calcular a sua área. Basicamente, vamos definir uma função que tem a finalidade de calcular a área sem a necessidade de ficarmos repetindo a mesma conta como ocorria no código inicial.

Assim, no arquivo Triangle.java, vamos acrescentar o seguinte

    package entities;

    public class Triangle {

        public double a;
        public double b;
        public double c;

        // Motivo de ser public double, é porque vai retornar um double
        // Não será necessário colocar os parâmetros a, b e c dentro desse método
        // pois elas já residem dentro dessa classe
        public double area() {
            double p = (a + b + c) / 2.0;
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
    }

Agora, no arquivo Program.java, vamos colocar o seguinte

    package application;

    import java.util.Locale;
    import java.util.Scanner;

    import entities.Triangle;

    public class Program {
        public static void main(String[] args) {

            Locale.setDefault(Locale.US);
            Scanner sc = new Scanner(System.in);

            Triangle x, y;

            x = new Triangle();
            y = new Triangle();

            System.out.println("Enter the measures of triangle X: ");
            x.a = sc.nextDouble();
            x.b = sc.nextDouble();
            x.c = sc.nextDouble();

            System.out.println("Enter the measures of triangle Y: ");
            y.a = sc.nextDouble();
            y.b = sc.nextDouble();
            y.c = sc.nextDouble();

            double areaX = x.area();

            double areaY = y.area();

            System.out.printf("Triangle X area: %.4f%n", areaX);
            System.out.printf("Triangle Y area: %.4f%n", areaY);

            if (areaX > areaY) {
                System.out.println("Larger area: X");
            }
            else {
                System.out.println("Larger area: Y");
            }

            sc.close();
        }
    }

Bom, fizemos isso até agora, mas temos um ponto bem crucial do que não foi definido na classe triangle. Pois veja que podemos definir medidas de triangulos impossíveis e mesmo assim efetuar as contas. No caso, o que seria necessário verificar para isso?? Bom deixarei ao cargo do leitor essa melhoria.

Seguir com as classes "Produto" e "ProdutoTeste" do projeto "exerccicios" do pacote "classe".

### Desafio - Data Formatada:
Na classe "Data" e "DataTeste" que foi feito no desafio da aula 04 desta seção, do projeto "exercicios" no pacote "classe", o desafio é criar um método "obterDataFormatada" e nela iremos formatar a data de acordo com o que foi passado nela.

## Aula 06 - Começando a resolver um segundo problema exemplo e Aula 07 - Object e toString:
Bom, segue a sentença do exercício

    Fazer um programa para ler os dados de um produto em estoque (nome, preço e quantidade no estoque). Em seguida:

    • Mostrar os dados do produto (nome, preço, quantidade no estoque, valor total no estoque)
    • Realizar uma entrada no estoque e mostrar novamente os dados do produto
    • Realizar uma saída no estoque e mostrar novamente os dados do produto

    Para resolver este problema, você deve criar uma CLASSE conforme projeto ao lado:

    - Name: string
    - Price: double
    - Quantity: int

    + TotalValueStock: double
    + AddProducts(quantity: int): void
    + RemoveProducts(quantity: int): void

Exemplo de como deve funcionar 

    Enter product data:
    Name: TV
    Price: 900.00
    Quantity in stock: 10
    Product data: TV, $ 900.00, 10 units, Total: $ 9000.00
    Enter the number of products to be added in stock: 5
    Updated data: TV, $ 900.00, 15 units, Total: $ 13500.00
    Enter the number of products to be removed from stock: 3
    Updated data: TV, $ 900.00, 12 units, Total: $ 10800.00
    Example:
    Enter product data:
    Name: TV
    Price: 900.00
    Quantity in stock: 10
    Product data: TV, $ 900.00, 10 units, Total: $ 9000.00
    Enter the number of products to be added in stock: 5
    Updated data: TV, $ 900.00, 15 units, Total: $ 13500.00
    Enter the number of products to be removed from stock: 3
    Updated data: TV, $ 900.00, 12 units, Total: $ 10800.00

Bom, vamos para a resolução desse problema!

Criamos um projeto course e dentro da pasta src criamos duas pastas application e entities, donde colocamos os arquivos Program.java e Product.java, respectivamente.

Agora, no arquivo Product.java vamos colocar o seguinte

    package entities;

    public class Product {

        public String name;
        public double price;
        public int quantity;

        public double totalValueInStock() {
            return price * quantity;
        }

        public void addProducts(int quantity) {
            // Usamos o this, donde ele faz referência ao escopo
            // do que foi atribuído dentro da classe Product
            this.quantity += quantity;
        }

        public void removeProducts(int quantity) {
            this.quantity -= quantity;
        }
    }

Como foi visto, conforme o que foi solicitado de como deve ser criado a classe.

Agora, no arquivo Program.java colocamos o seguinte

    package application;

    import java.util.Locale;
    import java.util.Scanner;

    import entities.Product;

    public class Program {
        public static void main(String[] args) {

            Locale.setDefault(Locale.US);
            Scanner sc = new Scanner(System.in);

            Product product = new Product();
            System.out.println("Enter product data: ");
            System.out.println("Name: ");
            product.name = sc.nextLine();
            System.out.print("Price: ");
            product.price = sc.nextDouble();
            System.out.print("Quantity in stock: ");
            product.quantity = sc.nextInt();

            System.out.println(product.name + ", " + product.price + ", " + product.quantity);
            
            sc.close();
        }
    }

Bom, o formato acima seria para verificar se o código está em funcionamento.

Agora, vamos explicar um pouco sobre Object e toString, que é um método que tem no Object.

•Toda classe em Java é uma subclasse da classe Object

•Object possui os seguintes métodos:

    • getClass- retorna o tipo do objeto
    • equals - compara se o objeto é igual a outro
    • hashCode - retorna um código hash do objeto
    • toString - converte o objeto para string

Note que, todos esses métodos do Object acima, vc pode usar ela independente se ela foi ou não definido nas classes que vc constroe. Ou seja, vc pode usar ela em qualquer lugar, pois elas são subclasses da classe mais alta de todas dessa linguagem de programação Java, o Object.

No caso, vamos aprender a usar o toString nessa aula. No caso, como foi descrito acima, ela converte o objeto em uma string, mas o que isso significa?

Vamos ver o seguinte

    package application;

    import java.util.Locale;
    import java.util.Scanner;

    import entities.Product;

    public class Program {
        public static void main(String[] args) {

            Locale.setDefault(Locale.US);
            Scanner sc = new Scanner(System.in);

            Product product = new Product();
            System.out.println("Enter product data: ");
            System.out.println("Name: ");
            product.name = sc.nextLine();
            System.out.print("Price: ");
            product.price = sc.nextDouble();
            System.out.print("Quantity in stock: ");
            product.quantity = sc.nextInt();

            //product.equals(arg0);

            System.out.println(product);
            
            sc.close();
        }
    }

Note que, no System.out.println(product);, o que será retornado no console seria o seguinte

    entities.Product@36d4b5c

Ou seja, eu pedi para printar o que será devolvido pelo objeto product, mas ele acabou devolvendo esse endereço único dele. No caso, isso dificulta de sabermos o que tem de conteúdo dentro dela. Por isso que usamos o toString para isso!

No arquivo Product.java vamos colocar o seguinte

    package entities;

    public class Product {

        public String name;
        public double price;
        public int quantity;

        public double totalValueInStock() {
            return price * quantity;
        }

        public void addProducts(int quantity) {
            // Usamos o this, donde ele faz referência ao escopo
            // do que foi atribuído dentro da classe Product
            this.quantity += quantity;
        }

        public void removeProducts(int quantity) {
            this.quantity -= quantity;
        }

        public String toString() {
            return name;
        }
    }

e no aquivo Program.java colocamos

    package application;

    import java.util.Locale;
    import java.util.Scanner;

    import entities.Product;

    public class Program {
        public static void main(String[] args) {

            Locale.setDefault(Locale.US);
            Scanner sc = new Scanner(System.in);

            Product product = new Product();
            System.out.println("Enter product data: ");
            System.out.println("Name: ");
            product.name = sc.nextLine();
            System.out.print("Price: ");
            product.price = sc.nextDouble();
            System.out.print("Quantity in stock: ");
            product.quantity = sc.nextInt();

            //product.equals(arg0);

            //System.out.println(product.name + ", " + product.price + ", " + product.quantity);
            System.out.println(product);
            System.out.println(product.toString());
            
            sc.close();
        }
    }

Note que, independentemente se chamamos o toString ou não, pelo fato de termos colocado esse método na nossa classe Product, automaticamente os dois prints acima printaram o nome que colocamos.

Bom, agora, entendido isso, nos permite personalizar o uso do toString. Vamos realizar da seguinte forma no arquivo Product.java

    package entities;

    public class Product {

        public String name;
        public double price;
        public int quantity;

        public double totalValueInStock() {
            return price * quantity;
        }

        public void addProducts(int quantity) {
            // Usamos o this, donde ele faz referência ao escopo
            // do que foi atribuído dentro da classe Product
            this.quantity += quantity;
        }

        public void removeProducts(int quantity) {
            this.quantity -= quantity;
        }

        public String toString() {
            return name + ", $ " + price + ", " + quantity + " units, Total: $" + totalValueInStock();
        }
    }

Falta, agora, acertarmos o número de casas decimais. Para isso, vamos colocar o seguinte, String.format

    package entities;

    public class Product {

        public String name;
        public double price;
        public int quantity;

        public double totalValueInStock() {
            return price * quantity;
        }

        public void addProducts(int quantity) {
            // Usamos o this, donde ele faz referência ao escopo
            // do que foi atribuído dentro da classe Product
            this.quantity += quantity;
        }

        public void removeProducts(int quantity) {
            this.quantity -= quantity;
        }

        public String toString() {
            return name + ", $ " + String.format("%.2f", price) + ", " + quantity + " units, Total: $" + String.format("%.2f", totalValueInStock());
        }
    }

## Aula 08 - Finalizando o programa:
Agora, vamos partir para finalização desse código que estamos quase terminando.

No caso, ficaria assim

    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);
    Product product = new Product();
    System.out.println("Enter product data: ");
    System.out.print("Name: ");
    product.name = sc.nextLine();
    System.out.print("Price: ");
    product.price = sc.nextDouble();
    System.out.print("Quantity in stock: ");
    product.quantity = sc.nextInt();
    System.out.println();
    System.out.println("Product data: " + product);
    System.out.println();
    System.out.print("Enter the number of products to be added in stock: ");
    int quantity = sc.nextInt();
    product.addProducts(quantity);
    System.out.println();
    System.out.println("Updated data: " + product);
    System.out.println();
    System.out.print("Enter the number of products to be removed from stock: ");
    quantity = sc.nextInt();
    product.removeProducts(quantity);
    System.out.println();
    System.out.println("Updated data: " + product);
    sc.close();

## Aula 09 - Exercícios de fixação:
Se der tempo, na revisão faça esse exercício!

## Aula 10 e 11 - Membros estáticos - Parte 1 e 2:
Vamos entender sobre esses mebros.

Bom, até agora, sabemos o que é membro de classes que são os atributos e métodos.

Membros estáticos

• Também chamados membros de classe

    • Em oposição a membros e instância (exemplo: quando usamos x.area(), esse area() é um membro de instância)

• São membros que fazem sentido independentemente de objetos. Não precisam de objeto para serem chamados. São chamados a partir do próprio nome da classe.

• Aplicações comuns:

    • Classes utilitárias (exemplo: Math)
    • Declaração de constantes

• Uma classe que possui somente membros estáticos, pode ser uma classe estática também. Esta classe não poderá ser instanciada.

Vamos mostrar exemplo disso, mas realizando um comparativo. Uma usando os métodos da própria classe do programa, a segunda usando membro de uma instância e a última usando os membros estáticos

- Exemplo 1: Todas no arquivo Program.java

    package application;
    import java.util.Locale;
    import java.util.Scanner;
    public class Program {
        // Esse é o padrões de nomes para constantes
        // que é escrevendo tudo em maiúsculo, PI, EULER, etc...
        public static final double PI = 3.14159;
        public static void main(String[] args) {
            Locale.setDefault(Locale.US);
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter radius: ");
            double radius = sc.nextDouble();
            double c = circumference(radius);
            double v = volume(radius);
            System.out.printf("Circumference: %.2f%n", c);
            System.out.printf("Volume: %.2f%n", v);
            System.out.printf("PI value: %.2f%n", PI);
            sc.close();
        }
        public static double circumference(double radius) {
            // Note que, conseguimos chamar a constante sem problemas
            return 2.0 * PI * radius;
        }
        public static double volume(double radius) {
            return 4.0 * PI * radius * radius * radius / 3.0;
        }
    }

- Exemplo 2:

    // A classe do arquvio Calculator
    package util;
    public class Calculator {
        public final double PI = 3.14159;
        public double circumference(double radius) {
            return 2.0 * PI * radius;
        }
        public double volume(double radius) {
            return 4.0 * PI * radius * radius * radius / 3.0;
        }
    }

    // Programa que rodará no arquivo Program.java
    // Instanciando a classe Calculator.
    Calculator calc = new Calculator();

    System.out.print("Enter radius: ");

    double radius = sc.nextDouble();
    double c = calc.circumference(radius);
    double v = calc.volume(radius);

    System.out.printf("Circumference: %.2f%n", c);
    System.out.printf("Volume: %.2f%n", v);
    System.out.printf("PI value: %.2f%n", calc.PI);

- Exemplo 3:

    // A classe - Calculator.java
    package util;
    public class Calculator {
        // Aqui quando colocamos o static
        // Está sendo dito que isso independe de qualquer objeto do tipo calculator.
        // Isso nos permite chamar tanto as constantes quanto os métodos sem necessidade de declarar que estamos usando a tal classe, o new Calculator().
        public static final double PI = 3.14159;

        public static double circumference(double radius) {
            return 2.0 * PI * radius;
        }
        public static double volume(double radius) {
            return 4.0 * PI * radius * radius * radius / 3.0;
        }
    }

    // Código que vai no Program.java
    System.out.print("Enter radius: ");
    double radius = sc.nextDouble();

    double c = Calculator.circumference(radius);
    double v = Calculator.volume(radius);

    System.out.printf("Circumference: %.2f%n", c);
    System.out.printf("Volume: %.2f%n", v);
    System.out.printf("PI value: %.2f%n", Calculator.PI);

Importante deixar claro aqui que, visto que os membros da classe Calculator são utilitárias, então podemos usar o static em todas elas.

Entretanto, precisamos deixar bem claro a diferença entre quando é bom usar o static e quando não, no lugar usar a instanciada.

## Aula 13 - Membros de Classes vs Instância:
Existem cenários, em que, quando criamos uma classe, os atributos definidos nela, quando instanciados, sejam as mesmas para qualquer outra nova instanciação da mesma classe.

Exemplo:

    public class Data {
        
        int dia;
        int mes;
        int ano;
    }

Existem casos em que, o atributo "int dia" seja uniforme para qualquer outra nova instanciação

    Data d1 = new Data();
    Data d2 = new Data();

## Aula 14 - Exercício de fixação:
Se der tempo, fazer isso na revisão!

    Faça um programa para ler a cotação do dólar, e depois um valor em dólares a ser comprado por uma pessoa em reais. Informar quantos reais a pessoa vai pagar pelos dólares, considerando ainda que a pessoa terá que pagar 6% de IOF sobre o valor em dólar. Criar uma classe CurrencyConverter para ser responsável pelos cálculos.

Exemplo:

    What is the dollar price? 3.10
    How many dollars will be bought? 200.00
    Amount to be paid in reais = 657.20
