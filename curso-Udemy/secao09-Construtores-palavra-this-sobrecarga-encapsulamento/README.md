# Seção 9: Construtores, palavra this, sobrecarga, encapsulamento:
Recomendo ver essa seção com muito carinho, pois será muito importante para aprofundar no conceito de orientação à objetos, nem que custe o dobro do tempo para entender bem cada conceito!

## Aula 01 - Visão geral do capítulo e Aula 02 - Material de apoio do capítulo:
MATERIAL DE APOIO DO CAPÍTULO

Seja muito bem-vindo(a) ao capítulo Construtores, palavra this, sobrecarga, encapsulamento!

Aqui você pode baixar o material de apoio usado nas aulas do capítulo, para que você possa aproveitar ao máximo as aulas sem precisar ficar anotando muito.

Grande abraço e bons estudos! Nelio.

Recursos para esta aula

    04-construtores-this-sobrecarga-encapsulamento(espaco-para-anotacoes).pdf
    04-construtores-this-sobrecarga-encapsulamento.pdf

## Aula 03 - Construtores:
Vamos entender melhor sobre os construtores.

O construtor é quando usamos aquela palavra new

    https://www.devmedia.com.br/construtores-em-java-primeiros-passos/28618#:~:text=Tamb%C3%A9m%20conhecidos%20pelo%20ingl%C3%AAs%20constructors,declarados%20conforme%20a%20Listagem%201.
    https://blog.cod3r.com.br/funcoes-construtoras/#:~:text=As%20fun%C3%A7%C3%B5es%20construtoras%20em%20JavaScript,para%20a%20cria%C3%A7%C3%A3o%20de%20objetos.

Na revisão, dar uma lida dos dois links acima.

Bom, lembra do código que desenvolvemos para o produto, donde conseguíamos realizar o controle de estoque? No caso, vamos analisar o código desse problema que resolvemos. Nela, tínhamos a função construtora new Product, porém, note que, enquanto não colocarmos nenhuma informação nela, o valor padrão dela para name, price e quantity, seria null, 0.0 e 0, respectivamente. Podemos ver isso da seguinte forma

    package application;

    import java.util.Locale;
    import java.util.Scanner;

    import entities.Product;

    public class Program {
        public static void main(String[] args) {

            Locale.setDefault(Locale.US);
            Scanner sc = new Scanner(System.in);

            Product product = new Product();

            System.out.println(product.name);
            System.out.println(product.price);
            System.out.println(product.quantity);

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
        }
    }

Bom, daí vem a seguinte pergunta. Faz sentido um produto que não tenha nome, preço e quantidade?? É possível evitar que tenha a existência de um produto sem nome, preço e quantidade obrigando a iniação desses valores?

Bom, a resposta é sim e o segredo para isso está em construtores, pois uma das utilidades que temos de um construtor é permitir ou obrigar que o objeto receba dados / dependências no momento de sua instanciação (injeção de dependência).

Bom, vamos fazer isso, então. No arquivo Product.java, depois dos atributos vamos colocar o seguinte

    package entities;

    public class Product {

        public String name;
        public double price;
        public int quantity;

        public Product(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

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

Feito a alteração acima, vc vai ver que no arquivo Program.java será exibido um erro na própria linha que usamos o new para construir o objeto Product. Para arrumarmos isso, vamos ter que apagar esse construtor e simplesmente criar uma variável temporária aqui com name, price e quantity, para somente depois instanciar a classe

    package application;

    import java.util.Locale;
    import java.util.Scanner;

    import entities.Product;

    public class Program {
        public static void main(String[] args) {

            Locale.setDefault(Locale.US);
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter product data: ");
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();
            System.out.print("Quantity in stock: ");
            int quantity = sc.nextInt();

            Product product = new Product(name, price, quantity);

            System.out.println();
            System.out.println("Product data: " + product);
            System.out.println();
            System.out.print("Enter the number of products to be added in stock: ");
            quantity = sc.nextInt();
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
        }
    }

Bom, feito as alterações acima, agora sim, com o uso do construtor, vamos conseguir evitar o risco com que o usuário crie um produto que não tenha nome, preço e quantidade.

Seguir as classes "Produto" e "ProdutoTeste" do projeto "exercicio" do pacote "classe".

### Obs:
Todos os construtores é um método, mas nem todos os métodos é um construtor.

Exemplo:

Abaixo, temos o exemplo de um construtor explícito. Ou seja, sempre que eu instanciar a classe Produto, "Produto p = new Produto(bla)", preciso passar algum parâmetro dentro dela, pois a forma como está abaixo, exige que tenha algum parâmetro.

    public class Produto {

        Produto (int a) {
            ....
        }
    }

O construtor explícito acima é o Produto. O implícito é quando instanciamos ela em outra classe sem parâmetros, que é construtor padrão

    Produto p1 = new Produto();

Agora, se fizermos

    public class Produto {

        void Produto (int a) {
            ....
        }
    }

Vira um método, mas não é um construtor.

O que diferencia entre construtor e um método, está exatamente na ausência de retorno. Ou seja, um construtor não retorna nada!

Basicamente, a regra geral de construtor é o seguinte.

Você criou uma classe e não definiu nenhum construtor, então o construtor será padrão/implícita, sempre que vc instanciar essa classe numa outra classe

    public class Produto {

    }

Caso vc definiu um construtor com um parâmetro, vc criou um construtor explícito. Ou seja, sempre que vc instanciar essa classe para uma outra classe, vc precisa passar algum parâmetro ao construtor

    public class Produto {

        Produto (int a) {
            ....
        }
    }

Porém, se vc quiser que uma classe com construtor explícito seja possível definir um construtor implícito/padrão, basta vc definir um construtor vazio dentro dessa classe

    public class Produto {

        Produto (int a) {
            ....
        }

        Produto() {

        }
    }

O que não podemos fazer no construtor é o seguinte.

Suponhamos que uma classe tenha dois atributos definidos

    public class Produto {

        int a;
        int b;
    }

Não podemos fazer o seguinte

    public class Produto {

        int a;
        int b;

        Produto (int a) {
            ....
        }

        Produto (int b) {
            ....
        }
    }

O java não consegue reconhecer a diferença de um parâmetro único ao do outro parâmetro único que é passado... Ela diferencia pela estrutura.

### Desafio Construtor:
Da classe "Data" e "DataTeste" que está no projeto "exercicio" dentro do pacote "classe", queremos que crie um construtor explícito, onde devo passar o dia, mês e o ano. E outra, um construtor padrão, mas com o dia, mês e ano pré-definido.

## Aula 04 - Palavra this e this():
Bom, seguir uma fonte de leitura quando vc for revisar

    https://www.devmedia.com.br/o-que-significa-cada-palavra-reservada/8320#:~:text=%C2%B7%20this%3A%20Vari%C3%A1vel%20de%20refer%C3%AAncia%20que,de%20retorno%20para%20o%20m%C3%A9todo.
    https://pt.wikipedia.org/wiki/This_(programa%C3%A7%C3%A3o_de_computadores)#:~:text=this%2C%20self%20e%20Me%20s%C3%A3o,atualmente%20em%20execu%C3%A7%C3%A3o%20faz%20parte.
    https://pt.stackoverflow.com/questions/27197/palavra-reservada-this

Bom, a princípio a palavra this ele é uma referência para o próprio objeto, this object. Usualmente, ele serve para diferenciar atributos de variáveis locais e passar o próprio objeto como argumento na chamada de um método ou construtor.

Basicamente, podemos associar, para quem conhece VueJS, que o this, ele guarda elementos que foi guardado com algum valor padrão dentro do escopo do objeto, no caso do Vue da tela, em que vc está criando.

Para mais abordagem seguir as classes "Data" e "DataTeste"  do projeto "exercicios" do pacote "classe".

## Aula 05 - Sobrecarga:
Seguir os links de leitura

    https://www.devmedia.com.br/sobrecarga-e-sobreposicao-de-metodos-em-orientacao-a-objetos/33066#:~:text=A%20sobrecarga%20(overload)%20consiste%20em,possuir%20argumentos%20diferentes%20para%20funcionar.
    https://es.wikipedia.org/wiki/Sobrecarga_(inform%C3%A1tica)

Bom, vemos que sobrecarga é algo universal da linguagem de programação, então o que será aprendido aqui valerá para JavaScript e Python tbm.

No caso, para entender melhor sobre esse conceito, vamos realizar a seguinte melhoria no nosso programa

    package entities;

    public class Product {

        public String name;
        public double price;
        public int quantity;

        public Product(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
            // opcional
            // this.quantity = 0;
            // Pois não temos o parâmetro quantity
            // quantity = 0
        }

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

No caso, criamos uma outra instância construtora e tiramos o parâmetro int quantity.

Agora, no arquivo Program.java, vamos apagar a parte onde pede para colocar o quantity

    package application;

    import java.util.Locale;
    import java.util.Scanner;

    import entities.Product;

    public class Program {
        public static void main(String[] args) {

            Locale.setDefault(Locale.US);
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter product data: ");
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();

            Product product = new Product(name, price);

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
        }
    }

Agora, sempre que criarmos um produto será exbido o produto com o preço, mas como valor de quantidade inicial zero, pois vc irá alterar isso depois.

No caso, o conceito de sobrecarga aqui apareceu da seguinte forma. Definimos duas funções com nomes iguais mas que realiza tarefas diferentes.

Obs: É possível também incluir um construtor padrão. No caso, podemos realizar uma outra sobrecarga da seguinte forma

    package entities;

    public class Product {

        public String name;
        public double price;
        public int quantity;

        public Product() {
            
        }

        public Product(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
            // opcional
            // this.quantity = 0;
            // Pois não temos o parâmetro quantity
            // quantity = 0
        }

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

Em seguida, no arquivo Program.java fazemos o seguinte

    package application;

    import java.util.Locale;
    import java.util.Scanner;

    import entities.Product;

    public class Program {
        public static void main(String[] args) {

            Locale.setDefault(Locale.US);
            Scanner sc = new Scanner(System.in);

            Product p = new Product();

            System.out.println("Enter product data: ");
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();

            Product product = new Product(name, price);

            System.out.println();
            System.out.println("Product data: " + product);
            System.out.println();
            System.out.print("Enter the number of products to be added in stock: ");
            quantity = sc.nextInt();
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
        }
    }

No caso, vimos que mesmo que criamos uma sobrecarga, nesse caso, o programa foi o inteligente o suficiente para saber qual das funções, mesmo com todas tenha o mesmo nome, pode ser usado para finalidades do que precisamos.

Do ponto de vista matemático, é como se tivessemos uma função que vai de um espaço R^3 como domínio que temos f(x,y,z), mas podemos usar a mesma função definindo um subdomínio da seguinte forma R^2x{z_0} e a função f ficará algo desse tipo f(x,y,z_0).

## Aula 06 - Encapsulamento:
Vamos ver sobre o encapsulamento.

Seguir o link para leitura

    https://www.devmedia.com.br/encapsulamento-polimorfismo-heranca-em-java/12991#:~:text=Encapsulamento%20vem%20de%20encapsular%2C%20que,e%20m%C3%A9todos%20de%20uma%20classe.
    https://es.wikipedia.org/wiki/Encapsulamiento_(inform%C3%A1tica)
    https://stackify.com/oop-concept-for-beginners-what-is-encapsulation/

Uma analogia legal do encapsulamento é muito parecido com a diferença entre o front-end e back-end. Enquanto que no front-end o usuário realiza as tais ações, a execução de tais ações toda a arquitetura ou os tipos de acessos que ocorrem vc não vê ela acontecendo, pois ela fica tudo no back-end, que é por baixo dos panos, o que possibilita executar com base das ações que o usuário realiza pela tela. Basicamente, o encapsulamento é algo análogo à isso, ou seja, como funcionará por baixo dos panos.

É muito importante entender sobre encapsulamento, pois a compreensão profunda dela, nos permite conseguir construir relações e arquiteturas mais robustas de um sistema, de modo que fique mais perfomático e com segurança. Entender como os níveis de visibilidade funciona, pode ou não fornecer brechas de vazamento de dados ou, até mesmo, nos permite melhorar a performance, visto que os níveis de relações acaba sendo um fator que facilita ou não que informações de uma classe para outra seja compartilhada, sem muita necessidade de termos que colocar ou usar algum critério que implique em mais uso de processamento.

As sintaxes que definem os pilares do encapsulamento:

- Private

- Default (Pacote)

- Protected

- Public

Regra geral básica para encapsulamento

- Um objeto NÃO deve expor nenhum atributo (modificador de acesso private)

- Os atributos devem ser acessados por meio de métodos get e set:

    Padrão JavaBeans: https://en.wikipedia.org/wiki/JavaBeans

Um exemplo disso

    //Padrão para implementação de getters e setters
    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

No caso, seguindo a regra de exemplo acima, vamos aplicar isso no arquivo Product.java. No caso, vamos encapsular os atributos

    package entities;

    public class Product {

        private String name;
        private double price;
        private int quantity;

        public Product() {

        }

        public Product(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
            // opcional
            // this.quantity = 0;
            // Pois não temos o parâmetro quantity
            // quantity = 0
        }

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

Agora, no arquivo Program.java, vamos acessar um desses atributos encapsulado e vamos modificar o nome dela

    package application;

    import java.util.Locale;
    import java.util.Scanner;

    import entities.Product;

    public class Program {
        public static void main(String[] args) {

            Locale.setDefault(Locale.US);
            Scanner sc = new Scanner(System.in);

            //Product p = new Product();

            System.out.println("Enter product data: ");
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();

            Product product = new Product(name, price);

            product.name = "Computer";

            System.out.println();
            System.out.println("Product data: " + product);
            System.out.println();
            System.out.print("Enter the number of products to be added in stock: ");
            quantity = sc.nextInt();
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
        }
    }

Logo de cara, vamos ver que no product.name ele fica sublinhado em vermelho que não podemos alterar o nome. Daí, para possibilitar isso, vamos ter que usar o get e o set, onde geralmente são colocados depois dos construtores. No arquivo Product.java vamos fazer a seguinte modificação

    package entities;

    public class Product {

        private String name;
        private double price;
        private int quantity;

        public Product() {

        }

        public Product(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
            // opcional
            // this.quantity = 0;
            // Pois não temos o parâmetro quantity
            // quantity = 0
        }

        public void setName(String name) {
            this.name = name;
        }

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

No arquivo Program.java, em vez de escrever product.name, vamos escrever product.setName(com o nome do que vc quer alterar)

    package application;

    import java.util.Locale;
    import java.util.Scanner;

    import entities.Product;

    public class Program {
        public static void main(String[] args) {

            Locale.setDefault(Locale.US);
            Scanner sc = new Scanner(System.in);

            //Product p = new Product();

            System.out.println("Enter product data: ");
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();

            Product product = new Product(name, price);

            //product.name = "Computer";
            product.setName("Computer");

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
        }
    }

Agora, se quisermos que o atributo name da classe Product seja exibido? Se fizermos algo do tipo, System.out.println("Update name: " + product.name) ocorrerá um erro

    package application;

    import java.util.Locale;
    import java.util.Scanner;

    import entities.Product;

    public class Program {
        public static void main(String[] args) {

            Locale.setDefault(Locale.US);
            Scanner sc = new Scanner(System.in);

            //Product p = new Product();

            System.out.println("Enter product data: ");
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();

            Product product = new Product(name, price);

            //product.name = "Computer";
            product.setName("Computer");

            System.out.println("Update name: " + product.name);

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
        }
    }

No caso, aí que temos o get para isso. Então, no arquivo Product.java realizamos o seguinte

    package entities;

    public class Product {

        private String name;
        private double price;
        private int quantity;

        public Product() {

        }

        public Product(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
            // opcional
            // this.quantity = 0;
            // Pois não temos o parâmetro quantity
            // quantity = 0
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

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

Daí, no arquivo Program.java realiamos a seguinte chamada desse get, product.getName()

    package application;

    import java.util.Locale;
    import java.util.Scanner;

    import entities.Product;

    public class Program {
        public static void main(String[] args) {

            Locale.setDefault(Locale.US);
            Scanner sc = new Scanner(System.in);

            //Product p = new Product();

            System.out.println("Enter product data: ");
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();

            Product product = new Product(name, price);

            //product.name = "Computer";
            product.setName("Computer");

            //System.out.println("Update name: " + product.name);
            System.out.println("Update name: " + product.getName());

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
        }
    }

Analogamente, serve para o atributo price, caso vc queira que ela mude de preço e seja exibido.

No arquivo Product.java fazemos o seguinte

    package entities;

    public class Product {

        private String name;
        private double price;
        private int quantity;

        public Product() {

        }

        public Product(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
            // opcional
            // this.quantity = 0;
            // Pois não temos o parâmetro quantity
            // quantity = 0
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

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

No arquivo Program.java fazemos o seguinte

    package application;

    import java.util.Locale;
    import java.util.Scanner;

    import entities.Product;

    public class Program {
        public static void main(String[] args) {

            Locale.setDefault(Locale.US);
            Scanner sc = new Scanner(System.in);

            //Product p = new Product();

            System.out.println("Enter product data: ");
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();

            Product product = new Product(name, price);

            //product.name = "Computer";
            product.setName("Computer");
            product.setPrice(1200.00);

            //System.out.println("Update name: " + product.name);
            System.out.println("Update name: " + product.getName());
            System.out.println("Update price: " + product.getPrice());

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
        }
    }

Agora, e o quantity é necessário aplicarmos o get o set nela? Bom, aí que está, a quantidade, geralmente, nas regras de negócios ela não pode permitir que ocorra alguma alteração manual nela, mas, sim, conforme o processo. Por isso, no máximo podemos definir um get para ela, mas não o set

    package entities;

    public class Product {

        private String name;
        private double price;
        private int quantity;

        public Product() {

        }

        public Product(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
            // opcional
            // this.quantity = 0;
            // Pois não temos o parâmetro quantity
            // quantity = 0
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setPrice(double price) {
            this.price = price;
        }

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

Dessa forma, conseguimos proteger que a quantidade sempre fique no estado consistente, no sentido de que ela só irá alterar quando houver, apenas, alguma entrada ou saída.

Seguir as classes "Paulo", "Pedro", "Ana" e "Julia" do projeto "exercicios" dos pacotes "oo.encapsulamento.casaA" e "oo.encapsulamento.casaB".

### Desafio - Modificadores de Acesso:


## Aula 07 - Gerando automaticamente construtores, getters e setters com Eclipse:
Bom, segue a seguinte instrução

Comandos

    •Botão direito -> Source -> Generate Constructor using Fields
    •Botão direito -> Source -> Generate Getters and Setters

Bom, na prática isso irá construir, por exemplo, automaticamente um construtor e dentro dela aparecerá uma função super();, super classe.

## Aula 08 - Modificadores de acesso:
Modificadores de acesso

- https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html

- private: o membro só pode ser acessado na própria classe

- (nada): o membro só pode ser acessado nas classes do mesmo pacote. Note que, se tirarmos o private do String name do arquivo Product.java e depois criarmos uma outra classe dentro do entities Order.java e definirmos 

    package entities;

    import java.util.Date;

    public class Order {
        
        private Date date;
        private Product product;

        public Order(Date date, Product product) {
            super();
            this.date = date;
            this.product = product;
            this.product.name = "TV";
        }
        
        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }
    }

Note que, no this.product.name = "TV"; não irá exibir um erro, pois não coloquei nenhum tipo de modificadores de acesso. No caso, isso faz com que eu consiga acessar o atributo de uma classe por outra classe.

- protected: o membro só pode ser acessado no mesmo pacote, bem como em subclasses de pacotes diferentes

- public: o membro é acessado por todas classes (ao menos que ele resida em um módulo diferente  que não exporte o pacote onde ele está)

## Aula 09 - Exercício de fixação:
Em um banco, para se cadastrar uma conta bancária, é necessário informar o número da conta, o nome do titular da conta, e o valor de depósito inicial que o titular depositou ao abrir a conta. Este valor de depósito inicial, entretanto, é opcional, ou seja: se o titular não tiver dinheiro a depositar no momento de abrir sua conta, o depósito inicial não será feito e o saldo inicial da conta será, naturalmente, zero.

Importante: uma vez que uma conta bancária foi aberta, o número da conta nunca poderá ser alterado. Já o nome do titular pode ser alterado (pois uma pessoa pode mudar de nome por ocasião de casamento, por exemplo).

Por fim, o saldo da conta não pode ser alterado livremente. É preciso haver um mecanismo para proteger isso. O saldo só aumenta por meio de depósitos, e só diminui por meio de saques. Para cada saque realizado, o banco cobra uma taxa de $ 5.00. Nota: a conta pode ficar com saldo negativo se o saldo não for suficiente para realizar o saque e/ou pagar a taxa.

Você deve fazer um programa que realize o cadastro de uma conta, dando opção para que seja ou não informado o valor de depósito inicial. Em seguida, realizar um depósito e depois um saque, sempre mostrando os dados da conta após cada operação.

- EXAMPLE 1

    Enter account number: 8532
    Enter account holder: Alex Green
    Is there na initial deposit (y/n)? y
    Enter initial deposit value: 500.00
    Account data:
    Account 8532, Holder: Alex Green, Balance: $ 500.00
    Enter a deposit value: 200.00
    Updated account data:
    Account 8532, Holder: Alex Green, Balance: $ 700.00
    Enter a withdraw value: 300.00
    Updated account data:
    Account 8532, Holder: Alex Green, Balance: $ 395.00

- EXAMPLE 2

    Enter account number: 7801
    Enter account holder: Maria Brown
    Is there na initial deposit (y/n)? n
    Account data:
    Account 7801, Holder: Maria Brown, Balance: $ 0.00
    Enter a deposit value: 200.00
    Updated account data:
    Account 7801, Holder: Maria Brown, Balance: $ 200.00
    Enter a withdraw value: 198.00
    Updated account data:
    Account 7801, Holder: Maria Brown, Balance: $ -3.00

Realize quando eu fizer uma revisão! Pode usar tudo o que foi aprendido até agora!!

## Aula 10 e 11 - Correção do exercício de fixação - Parte 1 e 2:
Bom, segue a resolução do exercício!

    https://github.com/acenelio/encapsulation1-java

- No arquivo Program.java da pasta application

    package application;

    import java.util.Locale;
    import java.util.Scanner;

    import entities.Account;

    public class Program {

        public static void main(String[] args) {

            Locale.setDefault(Locale.US);
            Scanner sc = new Scanner(System.in);
            Account account;

            System.out.print("Enter account number: ");
            int number = sc.nextInt();
            System.out.print("Enter account holder: ");
            sc.nextLine();
            String holder = sc.nextLine();
            System.out.print("Is there an initial deposit (y/n)? ");
            char response = sc.next().charAt(0);
            if (response == 'y') {
                System.out.print("Enter initial deposit value: ");
                double initialDeposit = sc.nextDouble();
                account = new Account(number, holder, initialDeposit);
            }
            else {
                account = new Account(number, holder);
            }
            
            System.out.println();
            System.out.println("Account data:");
            System.out.println(account);
            
            System.out.println();
            System.out.print("Enter a deposit value: ");
            double depositValue = sc.nextDouble();
            account.deposit(depositValue);
            System.out.println("Updated account data:");
            System.out.println(account);
            
            System.out.println();
            System.out.print("Enter a withdraw value: ");
            double withdrawValue = sc.nextDouble();
            account.withdraw(withdrawValue);
            System.out.println("Updated account data:");
            System.out.println(account);
            
            sc.close();
        }
    }

- No arquivo Account.java da pasta entities

    package entities;

    public class Account {

        private int number;
        private String holder;
        private double balance;
        
        public Account(int number, String holder) {
            this.number = number;
            this.holder = holder;
        }

        public Account(int number, String holder, double initialDeposit) {
            this.number = number;
            this.holder = holder;
            // Abaixo está uma outra regra de encapsulamento bem importante
            // Se a regra de depósito mudar, aqui vc garante que será necessário alterar apenas o deposit, deixando apenas um único ponto de alteração.
            deposit(initialDeposit);
        }

        public int getNumber() {
            return number;
        }

        public String getHolder() {
            return holder;
        }

        public void setHolder(String holder) {
            this.holder = holder;
        }

        public double getBalance() {
            return balance;
        }

        public void deposit(double amount) {
            balance += amount;
        }
        
        public void withdraw(double amount) {
            balance -= amount + 5.0;
        }
        
        public String toString() {
            return "Account "
                    + number
                    + ", Holder: "
                    + holder
                    + ", Balance: $ "
                    + String.format("%.2f", balance);
        }
    }
