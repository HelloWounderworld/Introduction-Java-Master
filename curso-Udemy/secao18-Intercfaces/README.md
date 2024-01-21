# Seção 18: Interfaces - Acho que posso mergear essa seção com a seção 14...:

## Aula 01 - Visão geral do capítulo Interfaces e Aula 02 - Material de apoio do capítulo:
MATERIAL DE APOIO DO CAPÍTULO

Seja muito bem-vindo(a) ao capítulo Interfaces!

Aqui você pode baixar o material de apoio usado nas aulas do capítulo, para que você possa aproveitar ao máximo as aulas sem precisar ficar anotando muito.

Grande abraço e bons estudos! Nelio.

Recursos para esta aula

    13-interfaces-para-anotacoes.pdf
    13-interfaces.pdf

## Aula 03 - Interfaces:
Seguir o link para leitura sobre Interface

    https://www.devmedia.com.br/entendendo-interfaces-em-java/25502
    https://www.simplilearn.com/tutorials/java-tutorial/java-interface#:~:text=and%20project%20performance.-,What%20is%20Interface%20in%20Java%3F,in%20Java%20to%20achieve%20abstraction.
    https://www.javatpoint.com/interface-in-java#:~:text=An%20interface%20in%20Java%20is,Java%20interface%2C%20not%20method%20body.
    https://pt.stackoverflow.com/questions/107524/como-e-quando-usar-interface#:~:text=Quando%20h%C3%A1%20necessidade%20de%20agrupar,um%20modelo%20que%20%C3%A9%20imut%C3%A1vel.
    https://www.devmedia.com.br/java-interface-aprenda-a-usar-corretamente/28798#:~:text=A%20Interface%20%C3%A9%20muito%20utilizada,padr%C3%A3o%20de%20implementa%C3%A7%C3%A3o%20da%20Interface.

Bom, ainda estou em dúvida do que seria uma interface é em quais momentos seria de uma boa prática a sua utilização.

Do que eu entendi, seria que, as interfaces nos ajudam a implementar novos métodos a uma classe, que independente dos outros métodos que a classe já possui.

Ou seja, a interface, do que consegui entender, ela é uma forma de conseguir customizar mais ainda as qualidades de uma classe, que já possui as suas qualidades intrísecas.

Dentro da interface, todos os métodos são public e abstract (método que não tem corpo {})!!!

A classe que implementar uma interface, é obrigatório que sobrescreva todos os métodos definido dentro desssa interface, a não ser que vc crie uma implementação padrão no método definido dentro da interface.

## Aula 04 e 05 - Solução do problema - PARTE 1 e 2:
Vamos resolver um problema sem o uso da interface para depois entender como se deve usar uma interface.

Seguir o link da resolução do professor

    https://github.com/acenelio/interfaces1-java

Bom, vamos começar criando um projeto problem_solution_without_interface vamos criar os seguintes diretórios e arquivos

- model.entities com a classe Vehicle

Dentro da classe Vehicle vamos colocar o seguinte

    package model.entities;

    public class Vehicle {

        private String model;
        
        public Vehicle() {
        }

        public Vehicle(String model) {
            this.model = model;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }
        
    }

- model.entities com a classe CarRental

Dentro da classe CarRental vamos colocar o seguinte

    package model.entities;

    import java.time.LocalDateTime;

    public class CarRental {

        private LocalDateTime start;
        private LocalDateTime finish;
        
        private Vehicle vehicle;
        private Invoice invoice;
        
        public CarRental() {
        }

        public CarRental(LocalDateTime start, LocalDateTime finish, Vehicle vehicle, Invoice invoice) {
            this.start = start;
            this.finish = finish;
            this.vehicle = vehicle;
            this.invoice = invoice;
        }

        public LocalDateTime getStart() {
            return start;
        }

        public void setStart(LocalDateTime start) {
            this.start = start;
        }

        public LocalDateTime getFinish() {
            return finish;
        }

        public void setFinish(LocalDateTime finish) {
            this.finish = finish;
        }

        public Vehicle getVehicle() {
            return vehicle;
        }

        public void setVehicle(Vehicle vehicle) {
            this.vehicle = vehicle;
        }

        public Invoice getInvoice() {
            return invoice;
        }

        public void setInvoice(Invoice invoice) {
            this.invoice = invoice;
        }
        
    }

- model.entities com a classe Invoice

Dentro da classe Invoice vamos colocar o seguinte

    package model.entities;

    public class Invoice {

        private Double basicPayment;
        private Double tax;
        
        public Invoice() {
        }

        public Invoice(Double basicPayment, Double tax) {
            this.basicPayment = basicPayment;
            this.tax = tax;
        }

        public Double getBasicPayment() {
            return basicPayment;
        }

        public void setBasicPayment(Double basicPayment) {
            this.basicPayment = basicPayment;
        }

        public Double getTax() {
            return tax;
        }

        public void setTax(Double tax) {
            this.tax = tax;
        }
        
        public Double getTotalPayment() {
            return getBasicPayment() + getTax();
        }
    }

Agora, feito as criações das classes necessárias, vamos realizar a sua aplicação. Mas para isso é necessário criar o ambiente para isso. No caso, vamos criar o diretório application e dentro dela criar o arquivo Program.java. Dentro desse arquivo Program.java vamos colocar o seguinte

    package application;

    import java.time.LocalDateTime;
    import java.time.format.DateTimeFormatter;
    import java.util.Locale;
    import java.util.Scanner;

    import model.entities.CarRental;
    import model.entities.Vehicle;

    public class Program {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            Locale.setDefault(Locale.US);
            Scanner sc = new Scanner(System.in);
            
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            
            System.out.println("Entre com os dados do aluguel");
            System.out.print("Modelo do carro: ");
            String carModel = sc.nextLine();
            System.out.println("Retirada (dd/MM/yyyy hh:mm): ");
            LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);
            System.out.println("Retorno (dd/MM/yyyy hh:mm): ");
            LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);
            
            CarRental cr = new CarRental(start, finish, new Vehicle(carModel));
            
            sc.close();
        }

    }

- model.services criando a classe BrazilTaxService.java

Dentro dessa classe vamos realizar o seguinte

    package model.services;

    public class BrazilTaxService {

        public double tax(double amount) {
            if (amount <= 100.0) {
                return amount * 0.2;
            }
            else {
                return amount * 0.15;
            }
        }
    }

Vamos isso na aplicação, Program.java. Nela vamos colocar o seguinte para ver se esse BrazilTaxService ele resolve

    package application;

    import java.time.LocalDateTime;
    import java.time.format.DateTimeFormatter;
    import java.util.Locale;
    import java.util.Scanner;

    import model.entities.CarRental;
    import model.entities.Vehicle;
    import model.services.BrazilTaxService;

    public class Program {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            Locale.setDefault(Locale.US);
            Scanner sc = new Scanner(System.in);
            
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            
            System.out.println("Entre com os dados do aluguel");
            System.out.print("Modelo do carro: ");
            String carModel = sc.nextLine();
            System.out.println("Retirada (dd/MM/yyyy hh:mm): ");
            LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);
            System.out.println("Retorno (dd/MM/yyyy hh:mm): ");
            LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);
            
            CarRental cr = new CarRental(start, finish, new Vehicle(carModel));
            
            BrazilTaxService taxService = new BrazilTaxService();
            
            System.out.println(taxService.tax(50.0));
            
            sc.close();
        }

    }

Bom, visto que a classe BrazilTaxService está funcionando direito, vamos, agora, criar uma outra classe.

- model.services criando a classe RentalService.java

Dentro da classe ReantalService vamos colocar o seguinte

    package model.services;

    import model.entities.CarRental;
    import model.entities.Invoice;

    public class RentalService {

        private Double pricePerHour;
        private Double pricePerDay;
        
        private BrazilTaxService taxService;

        public RentalService(Double pricePerHour, Double pricePerDay, BrazilTaxService taxService) {
            this.pricePerHour = pricePerHour;
            this.pricePerDay = pricePerDay;
            this.taxService = taxService;
        }
        
        public void processInvoice(CarRental carRental) {
            
            carRental.setInvoice(new Invoice(50.0, 10.0));
        }
    }

Vamos, agora, testar essa aplicação rodando em Program.java. Para isso, coloquemos o seguinte

    package application;

    import java.time.LocalDateTime;
    import java.time.format.DateTimeFormatter;
    import java.util.Locale;
    import java.util.Scanner;

    import model.entities.CarRental;
    import model.entities.Vehicle;
    import model.services.BrazilTaxService;
    import model.services.RentalService;

    public class Program {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            Locale.setDefault(Locale.US);
            Scanner sc = new Scanner(System.in);
            
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            
            System.out.println("Entre com os dados do aluguel");
            System.out.print("Modelo do carro: ");
            String carModel = sc.nextLine();
            System.out.println("Retirada (dd/MM/yyyy hh:mm): ");
            LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);
            System.out.println("Retorno (dd/MM/yyyy hh:mm): ");
            LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);
            
            CarRental cr = new CarRental(start, finish, new Vehicle(carModel));
            
    //		BrazilTaxService taxService = new BrazilTaxService();
    //		
    //		System.out.println(taxService.tax(50.0));
            
            System.out.print("Entre com o preço por hora:");
            double pricePerHour = sc.nextDouble();
            System.out.print("Entre com o preço por dia: ");
            double pricePerDay = sc.nextDouble();
            
            RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
            
            rentalService.processInvoice(cr);
            
            System.out.println("FATURA:");
            System.out.println("Pagamento basico: " + cr.getInvoice().getBasicPayment());
            System.out.println("Imposto: " + cr.getInvoice().getTax());
            System.out.println("Pagamento total: " + cr.getInvoice().getTotalPayment());
            
            sc.close();
        }

    }

Bom, podemos testar se tudo até agora está funcionando corretamente.

Visto que está tudo ok, então vamos ter que melhorar o método processInvoice do RentalService. Coloquemos o seguinte

    package model.services;

    import java.time.Duration;

    import model.entities.CarRental;
    import model.entities.Invoice;

    public class RentalService {

        private Double pricePerHour;
        private Double pricePerDay;
        
        private BrazilTaxService taxService;

        public RentalService(Double pricePerHour, Double pricePerDay, BrazilTaxService taxService) {
            this.pricePerHour = pricePerHour;
            this.pricePerDay = pricePerDay;
            this.taxService = taxService;
        }
        
        public void processInvoice(CarRental carRental) {
            
            double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
            double hours = minutes / 60.0;
            
            double basicPayment;
            if (hours <= 12.0) {
                basicPayment = pricePerHour * Math.ceil(hours);
            }
            else {
                basicPayment = pricePerDay * Math.ceil(hours / 24.0);
            }
            
            double tax = taxService.tax(basicPayment);
            
            carRental.setInvoice(new Invoice(basicPayment, tax));
        }
    }

Bom, vamos melhorar a forma de exibição na aplicação fazendo da seguinte forma no arquivo Program.java

    package application;

    import java.time.LocalDateTime;
    import java.time.format.DateTimeFormatter;
    import java.util.Locale;
    import java.util.Scanner;

    import model.entities.CarRental;
    import model.entities.Vehicle;
    import model.services.BrazilTaxService;
    import model.services.RentalService;

    public class Program {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            Locale.setDefault(Locale.US);
            Scanner sc = new Scanner(System.in);
            
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            
            System.out.println("Entre com os dados do aluguel");
            System.out.print("Modelo do carro: ");
            String carModel = sc.nextLine();
            System.out.print("Retirada (dd/MM/yyyy hh:mm): ");
            LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);
            System.out.print("Retorno (dd/MM/yyyy hh:mm): ");
            LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);
            
            CarRental cr = new CarRental(start, finish, new Vehicle(carModel));
            
    //		BrazilTaxService taxService = new BrazilTaxService();
    //		
    //		System.out.println(taxService.tax(50.0));
            
            System.out.print("Entre com o preço por hora:");
            double pricePerHour = sc.nextDouble();
            System.out.print("Entre com o preço por dia: ");
            double pricePerDay = sc.nextDouble();
            
            RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
            
            rentalService.processInvoice(cr);
            
            System.out.println("FATURA:");
            System.out.println("Pagamento basico: " + String.format("%.2f", cr.getInvoice().getBasicPayment()));
            System.out.println("Imposto: " + String.format("%.2f", cr.getInvoice().getTax()));
            System.out.println("Pagamento total: " + String.format("%.2f", cr.getInvoice().getTotalPayment()));
            
            sc.close();
        }

    }

## Aula 06 - Solução do problema - PARTE 3:
Bom, agora, vamos mostrar uma solução usando o interface.

Basicamente, a solução usando a interface aqui ele resolve de forma a facilitar a manutenção do sistema visto que mudou a regra de negócio. Por exemplo, a regra de negócio implementada na solução de carros de aluguel foi resolvida de forma que ele siga as regras aqui no Brazil. Entretanto, se quisermos aplicar isso no EUA a forma como foi codado te dará muito trabalho para alterarmos e adaptarmos a regra de negócio para os EUA. No caso, aí que entra a função da interface, pois ela nos permite realizar tais alterações mantendo a mesma arquitetura do sistema sem muita dificuldade.

Bom, vamos então implementar o interface no nosso projeto. Vamos copiar o nosso projeto para o outro projeto problem_solution_with_interface.

Agora, dentro do model.services, vamos criar a seguinte classe, TaxService

    package model.services;

    public interface TaxService {

        double tax(double amount);
    }

Agora, na classe BrazilTaxService vamos falar que essa classe implementa a classe TaxService

    package model.services;

    public class BrazilTaxService implements TaxService {

        public double tax(double amount) {
            if (amount <= 100.0) {
                return amount * 0.2;
            }
            else {
                return amount * 0.15;
            }
        }
    }

Feito a tal implementação, agora, na classe RentalService.java só vamos precisar alterar tudo que tiver com o nome BrazilTaxService para TaxService. É aí que fica mais nítido a utilidade de interface

    package model.services;

    import java.time.Duration;

    import model.entities.CarRental;
    import model.entities.Invoice;

    public class RentalService {

        private Double pricePerHour;
        private Double pricePerDay;
        
        private TaxService taxService;

        public RentalService(Double pricePerHour, Double pricePerDay, TaxService taxService) {
            this.pricePerHour = pricePerHour;
            this.pricePerDay = pricePerDay;
            this.taxService = taxService;
        }
        
        public void processInvoice(CarRental carRental) {
            
            double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
            double hours = minutes / 60.0;
            
            double basicPayment;
            if (hours <= 12.0) {
                basicPayment = pricePerHour * Math.ceil(hours);
            }
            else {
                basicPayment = pricePerDay * Math.ceil(hours / 24.0);
            }
            
            double tax = taxService.tax(basicPayment);
            
            carRental.setInvoice(new Invoice(basicPayment, tax));
        }
    }

Agora, no caso, o que vai acontecer é que na aplicação Program.java, onde está RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService()); mudarmos para USATaxService, por exemplo, só será necessário isso, visto que a nova regra de negócio foi implementada para TaxService tbm.

Seguir as interfaces "Esportivo" e "Luxo" e a classe "Ferrari" do pacote "oo.herenca.desafio" do projeto "exercicio".

## Aula 07 - Inversão de controle e injeção de dependência:
Seguir o link para leitura

    https://www.devmedia.com.br/inversao-de-controle-x-injecao-de-dependencia/18763
    http://www.linhadecodigo.com.br/artigo/3418/inversao-de-controle-ioc-e-injecao-de-dependencia-di-diferencas.aspx
    https://gabrieluizramos.com.br/inversao-de-controle
    https://www.freecodecamp.org/portuguese/news/uma-rapida-introducao-a-injecao-de-dependencias-o-que-e-e-quando-usa-la/#:~:text=Em%20Java%2C%20antes%20de%20poder,chamado%20de%20inje%C3%A7%C3%A3o%20de%20depend%C3%AAncia.

- Inversão de controle

    Padrão de desenvolvimento que consiste em retirar da classe a responsabilidade de instanciar suas dependências.

- Injeção de dependências

    É uma forma de realizar a inversão de controle: um componente externo instancia a dependência, que é então injetada no objeto "pai". Pode ser implementada de várias formas:

    - Construtor

    - Classedeinstanciação(builder/factory)

    - Container/framework

No arquivo Program.java, onde temos RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());, na parte onde temos "new BrazilTaxService()" foi feito uma injeção de dependência. No caso, em vez de "new BrazilTaxService()" coloquemos o "new USATaxService()" isso não irá afetar o RentalService contanto que o USATaxService esteja implementado o TaxService. Ou seja, o TaxService, essa interface ela está cumprindo um papel de camaleão, no sentido de ir se adequando conforme a regra de negócio que é necessário.

## Aula 08 - Exercício de fixação:
Seguir o enunciado

    Uma empresa deseja automatizar o processamento de seus contratos. Oprocessamento de umcontratoconsisteemgerarasparcelasaserempagasparaaquelecontrato,combasenonúmerodemesesdesejado.

    A empresa utiliza um serviço de pagamento online para realizar o pagamento das parcelas.Osserviçosdepagamentoonlinetipicamentecobramum juromensal,bem comoumataxapor pagamento.Porenquanto, o serviço contratado pela empresa éo do Paypal,que aplicajurossimplesde1%acadaparcela,maisumataxadepagamentode2%.

    Fazerumprogramaparalerosdadosdeumcontrato(númerodocontrato,datadocontrato,e valor total do contrato). Em seguida, o programa deve ler o número de meses paraparcelamentodo contrato, edaí gerar osregistrosdeparcelasa serempagas(data evalor),sendoaprimeiraparcelaaserpagaummêsapósadatadocontrato,asegundaparceladoismesesapósocontratoeassimpordiante.Mostrarosdadosdasparcelasnatela.

Example

    Entre os dados do contrato:
    Numero: 8028
    Data (dd/MM/yyyy): 25/06/2018
    Valor do contrato: 600.00
    Entre com o numero de parcelas: 3
    Parcelas:
    25/07/2018 - 206.04
    25/08/2018 - 208.08
    25/09/2018 - 210.12

Cálculos (1% juro simples mensal + 2% taxa de pagamento):

- Parcela #1: 

    200 + 1% * 1 = 202 
    202 + 2% = 206.04

- Parcela #2: 

    200 + 1% * 2 = 204 
    204 + 2% = 208.08

- Parcela #3: 

    200 + 1% * 3 = 206 
    206 + 2% = 210.12

Seguir o link de resolução do professor

    https://github.com/acenelio/interfaces4-java

Bom, realizar esse exercício na revisão e comparar com a resolução do professor!
    
## Aula 09 e 10 - Correção do exercício de fixação PARTE 1 e 2:
Não irei tomar notas dessa aula, pois é melhor eu praticar bem o conceito para resolver esse problema!

Tomar notas da correção sem mesmo ter aprendido bem os conceitos, acaba que o conteúdo se consolide de forma raza na cabeça!

## Aula 11 - Herdar vs. cumprir contrato:
Seguir link para leitura

    https://medium.com/@danielchristofolli/heran%C3%A7a-polimorfismo-e-interfaces-java-4d2728b58924

Seguir o link do repositorio do professor

    https://github.com/acenelio/interfaces2-java

Aspectos em comum entre herança e interfaces

- Relação é-um

- Generalização/especialização

- Polimorfismo

Diferença fundamental

- Herança => reuso

- Interface => contrato a ser cumprido

Vamos criar um novo projeto, onde vamos mostrar como se realiza a combinação de herança e interface. No caso, o nome do projeto se chamará combination_inheritance_interface e dentro desse projeto vamos arquitetá-las das seguinte forma

- Diretório application
    - Program.java

- Diretório model.entities
    - Classe AbstractShape.java

    - Classe Circle.java

    - Classe Rectangle.java

    - Classe Shape.java

- Diretório model.enums
    - Enumeração Color.java

## Aula 12 - Herança múltipla e o problema do diamante:
Seguir o link de resolução do professor

    https://github.com/acenelio/interfaces3-java

Seguir os links de leitura

    https://pt.wikipedia.org/wiki/Heran%C3%A7a_m%C3%BAltipla#:~:text=Heran%C3%A7a%20m%C3%BAltipla%2C%20em%20orienta%C3%A7%C3%A3o%20a,uma%20classe%20implemente%20v%C3%A1rias%20interfaces.
    https://www.javatpoint.com/what-is-diamond-problem-in-java#:~:text=What%20Java%20does%20not%20allow,is%20not%20allowed%20in%20Java.
    https://pt.stackoverflow.com/questions/233728/heran%C3%A7a-m%C3%BAltipla-e-problema-do-diamante
    https://www.alura.com.br/apostila-python-orientacao-a-objetos/heranca-multipla-e-interfaces

Bom, vamos criar um novo projeto que retrata exatamente o problema do diamante que é derivado do conceito de múltiplas heranças. No caso, o novo projeto se chamará inheritance_diamond_problem. Dentro desse projeto vamos criar a seguinte arquitetura

- Diretório application
    - Program.java

- Diretório devices
    - Classe ComboDevice.java

    - Classe ConcretePrinter.java

    - Classe ConcreteScanner.java

    - Classe Device.java

    - Classe Printer.java

    - Classe Scanner.java

## Aula 13 - Interface Comparable:
Seguir o link de leitura

    https://docs.oracle.com/javase/10/docs/api/java/lang/Comparable.html
    https://www.arquitecturajava.com/java-comparable-interface-y-ordenaciones/
    https://leandersonandre.medium.com/interface-comparable-como-comparar-objetos-na-linguagem-de-programa%C3%A7%C3%A3o-java-d08deb842cc9

A sintaxe para usarmos esse interface comparable seria o seguinte

    public interface Comparable<T> {
        int compareTo (T o);
    }

Problema motivador

Faça um programa para ler um arquivo contendo nomes de pessoas (um nome por linha), armazenando-os em uma lista. Depois, ordenar os dados dessa lista e mostra-los ordenadamente na tela. Nota: o caminho do arquivo pode ser informado "hardcode".

    Maria Brown
    Alex Green
    Bob Grey
    Anna White
    Alex Black
    Eduardo Rose
    Willian Red
    Marta Blue
    Alex Brown

Bom, vamos começar a resolver esse problema!!

No caso, vamos criar um novo projeto chamado interface_comparable_test. Por início, vamos criar apenas o diretório application e dentro dela o arquivo Program.java e vamos colocar o seguinte

    package application;

    import java.io.BufferedReader;
    import java.io.FileReader;
    import java.io.IOException;
    import java.util.ArrayList;
    import java.util.Collections;
    import java.util.List;

    public class Program {
        public static void main(String[] args) {
            
            List<String> list = new ArrayList<>();
            String path = "C:\\temp\\in.txt";
            
            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                
                String name = br.readLine();
                while (name != null) {
                    list.add(name);
                    name = br.readLine();
                }
                Collections.sort(list);
                for (String s : list) {
                    System.out.println(s);
                }
                
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

No arquivo in.txt vamos colocar a lista de nome do enunciado do problema.

Agora, vamos rodar o programa para verificarmos se está tudo funcionando corretamente.

Bom, até aqui foi usado um exemplo do não uso do interface comparable.

Agora, vamos ver o outro problema seguinte

Outro problema

Faça um programa para ler um arquivo contendo funcionários (nome e salário) no formato.csv, armazenando-os em uma lista. Depois, ordenar a lista por nome e mostrar o resultado na tela.

Nota: o caminho do arquivo pode ser informado "hardcode".

    Maria Brown,4300.00
    Alex Green,3100.00
    Bob Grey,3100.00
    Anna White,3500.00
    Alex Black,2450.00
    Eduardo Rose,4390.00
    Willian Red,2900.00
    Marta Blue,6100.00
    Alex Brown,5000.00

Agora, vamos usar o interface comparable para resolvermos esse problema acima, pois, desta vez, não temos  somente o nome, mas temos um outro valor tbm.

No caso, no mesmo projeto, vamos criar, agora, uma classe Employee dentro do diretório entities. Daí, nessa classe coloquemos o seguinte

    package entities;

    public class Employee {

        private String name;
        private Double salary;
        
        public Employee(String name, Double salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getSalary() {
            return salary;
        }

        public void setSalary(Double salary) {
            this.salary = salary;
        }
        
    }

Agora, no arquivo Program.java vamos realizar os seguintes ajustes

    package application;

    import java.io.BufferedReader;
    import java.io.FileReader;
    import java.io.IOException;
    import java.util.ArrayList;
    import java.util.Collections;
    import java.util.List;

    import entities.Employee;

    public class Program {
        public static void main(String[] args) {
            
            List<Employee> list = new ArrayList<>();
            String path = "C:\\temp\\in.txt";
            
            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                
                String employeeCsv = br.readLine();
                while (employeeCsv != null) {
                    String[] fields = employeeCsv.split(",");
                    list.add(new Employee(fields[0], Double.parseDouble(fields[1])));
                    employeeCsv = br.readLine();
                }
                Collections.sort(list);
                for (String s : list) {
                    System.out.println(s);
                }
                
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

Note que, a alteração acima está exibindo um erro no método sort que está sendo aplicado. No caso, isso é um indicativo de que vc terá que usar necessariamente o interface comparable para a classe Employee.

Assim, na classe Employee coloquemos o seguinte

    package entities;

    public class Employee implements Comparable<Employee> {

        private String name;
        private Double salary;
        
        public Employee(String name, Double salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getSalary() {
            return salary;
        }

        public void setSalary(Double salary) {
            this.salary = salary;
        }

        @Override
        public int compareTo(Employee o) {
            // TODO Auto-generated method stub
            return 0;
        }
        
    }

Note que, nesse processo foi criado um override compareTo que serve para comparar um objeto com outro.

Agora, vamos usar essa ferramenta para a finalidade que precisamos. No caso, no compareTo, vamos definir o que vamos querer comparar entre dois funcionários

    package entities;

    public class Employee implements Comparable<Employee> {

        private String name;
        private Double salary;
        
        public Employee(String name, Double salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getSalary() {
            return salary;
        }

        public void setSalary(Double salary) {
            this.salary = salary;
        }

        @Override
        public int compareTo(Employee other) {
            // TODO Auto-generated method stub
            return name.compareTo(other.getName());
        }
        
    }

Feito isso, note que, no Program.java não está sendo mais exibido o erro do método sort. Assim, só falta realizarmos a seguinte implementação

    package application;

    import java.io.BufferedReader;
    import java.io.FileReader;
    import java.io.IOException;
    import java.util.ArrayList;
    import java.util.Collections;
    import java.util.List;

    import entities.Employee;

    public class Program {
        public static void main(String[] args) {
            
            List<Employee> list = new ArrayList<>();
            String path = "C:\\temp\\in.txt";
            
            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                
                String employeeCsv = br.readLine();
                while (employeeCsv != null) {
                    String[] fields = employeeCsv.split(",");
                    list.add(new Employee(fields[0], Double.parseDouble(fields[1])));
                    employeeCsv = br.readLine();
                }
                Collections.sort(list);
                for (Employee emp : list) {
                    System.out.println(emp.getName() + ", " +emp.getSalary());
                }
                
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

Agora, basta rodar o programa para verificar se vai funcionar.

Se quisermos comparar por salário, em vez de nome, bastaria mudar o "name.compareTo(other.getName())" para "salary.compareTo(other.getSalary())". E se quisermos inverter a ordem bastaria colocar um "-" na frente do "name.compareTo(other.getName())".

## Aula 14 - Default methods:
Seguir link para leitura

    https://docs.oracle.com/javase/tutorial/java/IandI/defaultmethods.html#:~:text=Default%20methods%20enable%20you%20to%20add%20new%20functionality%20to%20existing,as%20parameters%20to%20existing%20interfaces.
    https://www.baeldung.com/java-static-default-methods#:~:text=Like%20regular%20interface%20methods%2C%20default,and%20they%20provide%20an%20implementation.
    https://www.devmedia.com.br/introducao-aos-default-methods-do-java-8/36876
    https://www.geeksforgeeks.org/default-methods-java/

Seguir o link de resolução do professor

    https://github.com/acenelio/interfaces5-java

Default methods(defender methods)

- A partir do Java 8, interfaces podem conter métodos concretos.

- A intenção básica é prover implementação padrão para métodos, de modo a evitar:
    -  1) repetição de implementação em toda classe que implemente a interface
    -  2) a necessidade de se criar classes abstratas para prover reuso da implementação 

- Outras vantagens:
    -  Manter a retrocompatibilidadecom sistemas existentes
    -  Permitir que "interfaces funcionais" (que devem conter apenas um método) possam prover outras operações padrão reutilizáveis

Problema exemplo

Fazer um programa para ler uma quantia e a duração em meses de um empréstimo. Informar o valor a ser pago depois de decorrido o prazodo empréstimo, conforme regras de juros do Brasil. A regra de cálculo de juros do Brasil é juro composto padrão de 2% ao mês.

Example

    Quantia: 200.00
    Meses: 3
    Pagamento apos 3 meses:
    212.24


Considerações importantes

- Sim: agora as interfaces podem prover reuso

- Sim: agora temos uma forma de herança múltipla
    - Mas o compilador reclama se houver mais de um método com a mesma assinatura, obrigando a sobrescreve-lo

- Interfaces ainda são bem diferentes de classes abstratas. Interfaces não possuem recursos tais como construtores e atributos.

Reassistir essa aula, pois acabei vendo quando estava meio grogue.
