# Seção 18: Interfaces:

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

## Aula 07 - Inversão de controle e injeção de dependência:

## Aula 08 - Exercício de fixação:

## Aula 09 - Correção do exercício de fixação PARTE 1:

## Aula 10 - Correção do exercício de fixação PARTE 2:

## Aula 11 - Herdar vs. cumprir contrato:

## Aula 12 - Herança múltipla e o problema do diamante:

## Aula 13 - Interface Comparable:

## Aula 14 - Default methods:
