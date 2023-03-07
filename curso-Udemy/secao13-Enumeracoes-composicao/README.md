# Seção 13: Enumerações, composição:

## Aula 01 - Visão geral do capítulo Enumerações e Composição e Aula 02 - Material de apoio do capítulo:
MATERIAL DE APOIO DO CAPÍTULO

Seja muito bem-vindo(a) ao capítulo Enumerações, composição!

Aqui você pode baixar o material de apoio usado nas aulas do capítulo, para que você possa aproveitar ao máximo as aulas sem precisar ficar anotando muito.

Grande abraço e bons estudos! Nelio.

Recursos para esta aula

    07-enumeracoes-composicao(espaco-para-anotacoes).pdf
    07-enumeracoes-composicao.pdf

## Aula 03 - Enumerações:
Seguir o link para leitura

    https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
    https://www.devmedia.com.br/uml-para-java/2711

Digamos que a enumeração é um conjunto de constantes que vc enumera-as.

Repositório onde está o código do professor

    https://github.com/acenelio/enum1-java

Vamos criar um novo projeto no eclipse, enumerate e dentro da pasta src, criamos o application com o arquivo Program.java de forma usual. Além disso, dentro da pasta src, usando do recurso Enum, vc cria uma pasta entities e enums e dentro da pasta enums criar um arquivo orderStatus.java.

Dentro do arquivo OrderStatus.java vamos colocar o seguinte

    package entities.enums;

    public enum OrderStatus {
        
        PENDING_PAYMENT,
        PROCESSING,
        SHIPPED,
        DELIVERED;
    }

No caso, o código acima já é uma forma de enumeração das contantes.

Agora, dentro da pasta entities, vamos criar um arquivo Order.java e dentro dela colocamos o seguinte

    package entities;

    import java.util.Date;

    import entities.enums.OrderStatus;

    public class Order {

        private Integer id;
        private Date moment;
        private OrderStatus status;
        
        public Order() {
        }

        public Order(Integer id, Date moment, OrderStatus status) {
            this.id = id;
            this.moment = moment;
            this.status = status;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Date getMoment() {
            return moment;
        }

        public void setMoment(Date moment) {
            this.moment = moment;
        }

        public OrderStatus getStatus() {
            return status;
        }

        public void setStatus(OrderStatus status) {
            this.status = status;
        }
        
    }

Agora, no arquivo Program.java colocamos o seguinte

    package application;

    import java.util.Date;

    import entities.Order;
    import entities.enums.OrderStatus;

    public class Program {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            Order order = new Order(1080, new Date(), OrderStatus.PENDING_PAYMENT);
            
            System.out.println(order);
        }

    }

Agora, no arquivo Order.java vamos criar um método que gere automaticamente o toString

    package entities;

    import java.util.Date;

    import entities.enums.OrderStatus;

    public class Order {

        private Integer id;
        private Date moment;
        private OrderStatus status;
        
        public Order() {
        }

        public Order(Integer id, Date moment, OrderStatus status) {
            this.id = id;
            this.moment = moment;
            this.status = status;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Date getMoment() {
            return moment;
        }

        public void setMoment(Date moment) {
            this.moment = moment;
        }

        public OrderStatus getStatus() {
            return status;
        }

        public void setStatus(OrderStatus status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return "Order [id=" + id + ", moment=" + moment + ", status=" + status + "]";
        }
        
    }

Agora, vamos rodar a aplicação para ver se está tudo ocorrendo certo.

Agora, vamos ver sobre a conversão de String para enum. No caso, no arquivo Program.java vamos realizar o seguinte

    package application;

    import java.util.Date;

    import entities.Order;
    import entities.enums.OrderStatus;

    public class Program {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            Order order = new Order(1080, new Date(), OrderStatus.PENDING_PAYMENT);
            
            System.out.println(order);
            
            OrderStatus os1 = OrderStatus.DELIVERED;
            
            OrderStatus os2 = OrderStatus.valueOf("DELIVERED");
            
            System.out.println(os1);
            System.out.println(os2);
        }

    }

Verifique se o código está funcionando corretamente.

## Aula 04 - Vamos falar um pouco sobre design:
Vamos falar um pouco sobre design.

No caso, o design que quero falar aqui ela está mais atrelada na forma como organizamos os diretórios, que podemos ver como se estivessemos categorizando as classes, como Views, Controllers, Entities, Services e Repositories. No caso, é algo análogo à organização de diretórios que estudei em JavaScript.

## Aula 05 - Composição:
Vamos começar com a parte de composição!

Seguir o link de leitura

    https://www.javaprogressivo.net/2012/10/Composicao-em-Java-trocando-informacoes-entre-objetos.html

É instanciar, ou usar, uma classe/objeto em outra(o). É como se elas se comunicassem, trocassem informações. Ou seja, serve para reutilizar dados, sem ter que criar mais código pra isso.
Simplesmente passamos a informação - na forma de Objeto - para outro Objeto, e este se encarrega de obter os dados e como trabalhar em cima dele.

Costuma-se dizer que composição é o ato de delegar trabalho para outro objeto.
Isso deixa seu código mais elegante, menor e mais seguro.

## Aula 06 e 07 - Exercício resolvido 1 - Parte 1 e 2:
Seguir o enunciado

    Ler os dados de um trabalhador com N contratos (N fornecido pelo usuário). Depois, solicitar do usuário um mês e mostrar qual foi o salário do funcionário nesse mês, conforme exemplo

Example

    Enter department's name: Design
    Enter worker data:
    Name: Alex
    Level: MID_LEVEL
    Base salary: 1200.00
    How many contracts to this worker? 3
    Enter contract #1 data:
    Date (DD/MM/YYYY): 20/08/2018
    Value per hour: 50.00
    Duration (hours): 20
    Enter contract #2 data:
    Date (DD/MM/YYYY): 13/06/2018
    Value per hour: 30.00
    Duration (hours): 18
    Enter contract #3 data:
    Date (DD/MM/YYYY): 25/08/2018
    Value per hour: 80.00
    Duration (hours): 10
    Enter month and year to calculate income (MM/YYYY): 08/2018
    Name: Alex
    Department: Design
    Income for 08/2018: 3000.00

Repositor onde tem a resolução do professor

    https://github.com/acenelio/composition1-java

Vamos criando o projeto exec-composition1 no eclipse. Dentro desse projeto vamos colocar as pastas application e entities, onde criamos os arquivos Program.java e Department.java, respectivamente.

Agora, no arquivo Department.java colocamos o código

    package entities;

    public class Department {

        private String name;
        
        public Department() {
            
        }

        public Department(String name) {
            this.name = name;
        }
        
    }

Dentro do diretório entities, vamos criar mais um arquivo HourContract.java e dentro dela colocar o seguinte código

    package entities;

    import java.util.Date;

    public class HourContract {

        private Date date;
        private Double valuePerHour;
        private Integer hours;
        
        public HourContract() {
        }

        public HourContract(Date date, Double valuePerHour, Integer hours) {
            this.date = date;
            this.valuePerHour = valuePerHour;
            this.hours = hours;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public Double getValuePerHour() {
            return valuePerHour;
        }

        public void setValuePerHour(Double valuePerHour) {
            this.valuePerHour = valuePerHour;
        }

        public Integer getHours() {
            return hours;
        }

        public void setHours(Integer hours) {
            this.hours = hours;
        }
        
    }

Em seguida, vamos criar mais uma pasta entities.enums usando o Enum e criar um arquivo dentro dela WorkerLevel.java dentro dela e vamos enumerar as constantes

    package entities.enums;

    public enum WorkerLevel {

        JUNIOR,
        MID_LEVEL,
        SENIOR;
    }

Em seguida, dentro da pasta entities, vamos criar uma outra classe chamado Worker.java

    package entities;

    import java.util.ArrayList;
    import java.util.Calendar;
    import java.util.List;

    import entities.enums.WorkerLevel;

    public class Worker {

        private String name;
        private WorkerLevel level;
        private Double baseSalary;
        
        private Department deparment;
        private List<HourContract> contracts = new ArrayList<>();
        
        public Worker() {
        }

        public Worker(String name, WorkerLevel level, Double baseSalary, Department deparment) {
            this.name = name;
            this.level = level;
            this.baseSalary = baseSalary;
            this.deparment = deparment;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public WorkerLevel getLevel() {
            return level;
        }

        public void setLevel(WorkerLevel level) {
            this.level = level;
        }

        public Double getBaseSalary() {
            return baseSalary;
        }

        public void setBaseSalary(Double baseSalary) {
            this.baseSalary = baseSalary;
        }

        public Department getDeparment() {
            return deparment;
        }

        public void setDeparment(Department deparment) {
            this.deparment = deparment;
        }

        public List<HourContract> getContracts() {
            return contracts;
        }

        // Não pode ficar esse set abaixo, pois ele vire e mexe fica criando uma nova lista
        // A finalidade aqui é que não ocorra isso, ou seja, com a mesma lista sejam feitas as
        // adições e remoções.
        //public void setContracts(List<HourContract> contracts) {
        //	this.contracts = contracts;
        //}
        
        public void addContract(HourContract contract) {
            contracts.add(contract);
        }
        
        public void removeContract(HourContract contract) {
            contracts.remove(contract);
        }
        
        public double income(int year, int month) {
            double sum = baseSalary;
            Calendar cal = Calendar.getInstance();
            for (HourContract c : contracts) {
                cal.setTime(c.getDate());
                int c_year = cal.get(Calendar.YEAR);
                int c_month = 1 + cal.get(Calendar.MONTH);
                if (year == c_year && month == c_month) {
                    sum += c.totalValue();
                }
            }
            
            return sum;
        }
    }

O totalValue está sendo chamado da classe HourContract, então vamos precisar criar esse método dentro dessa classe tbm

    package entities;

    import java.util.Date;

    public class HourContract {

        private Date date;
        private Double valuePerHour;
        private Integer hours;
        
        public HourContract() {
        }

        public HourContract(Date date, Double valuePerHour, Integer hours) {
            this.date = date;
            this.valuePerHour = valuePerHour;
            this.hours = hours;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public Double getValuePerHour() {
            return valuePerHour;
        }

        public void setValuePerHour(Double valuePerHour) {
            this.valuePerHour = valuePerHour;
        }

        public Integer getHours() {
            return hours;
        }

        public void setHours(Integer hours) {
            this.hours = hours;
        }
        
        public double totalValue() {
            return valuePerHour * hours;
        }
    }

Feito as classes e as enumerações acima, agora só falta configurar o ambiente de aplicação disso.

Logo, no arquivo Program.java da pasta application vamos realizar o seguinte

    package application;

    import java.text.ParseException;
    import java.text.SimpleDateFormat;
    import java.util.Date;
    import java.util.Locale;
    import java.util.Scanner;

    import entities.Department;
    import entities.HourContract;
    import entities.Worker;
    import entities.enums.WorkerLevel;

    public class Program {

        public static void main(String[] args) throws ParseException {

            Locale.setDefault(Locale.US);
            Scanner sc = new Scanner(System.in);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            System.out.print("Enter department's name: ");
            String departmentName = sc.nextLine();
            System.out.println("Enter worker data:");
            System.out.print("Name: ");
            String workerName = sc.nextLine();
            System.out.print("Level: ");
            String workerLevel = sc.nextLine();
            System.out.print("Base salary: ");
            double baseSalary = sc.nextDouble();
            Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
            
            System.out.print("How many contracts to this worker? ");
            int n = sc.nextInt();
            
            for (int i=1; i<=n; i++) {
                System.out.println("Enter contract #" + i + " data:");
                System.out.print("Date (DD/MM/YYYY): ");
                Date contractDate = sdf.parse(sc.next());
                System.out.print("Value per hour: ");
                double valuePerHour = sc.nextDouble();
                System.out.print("Duration (hours): ");
                int hours = sc.nextInt();
                HourContract contract = new HourContract(contractDate, valuePerHour, hours);
                worker.addContract(contract);
            }
            
            System.out.println();
            System.out.print("Enter month and year to calculate income (MM/YYYY): ");
            String monthAndYear = sc.next();
            int month = Integer.parseInt(monthAndYear.substring(0, 2));
            int year = Integer.parseInt(monthAndYear.substring(3));
            System.out.println("Name: " + worker.getName());
            System.out.println("Department: " + worker.getDepartment().getName());
            System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
            
            sc.close();
        }
    }

## Aula 08 - Exercício resolvido 2 (demo StringBuilder):

## Aula 09 - Exercício de fixação:

## Aula 10 - Correção em vídeo do exercício de fixação:
