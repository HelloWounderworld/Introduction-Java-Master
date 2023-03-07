# Seção 14: Herança e polimorfismo:

## Aula 01 - Visão geral do capítulo Herança e Polimorfismo e Aula 02 - Material de apoio do capítulo:
MATERIAL DE APOIO DO CAPÍTULO

Seja muito bem-vindo(a) ao capítulo Herança e polimorfismo!

Aqui você pode baixar o material de apoio usado nas aulas do capítulo, para que você possa aproveitar ao máximo as aulas sem precisar ficar anotando muito.

Grande abraço e bons estudos! Nelio.

Recursos para esta aula

    08-heranca-e-polimorfismo(para-anotacao).pdf
    08-heranca-e-polimorfismo.pdf

## Aula 03 - Herança:
Seguir link para leitura

    https://www.devmedia.com.br/entendendo-e-aplicando-heranca-em-java/24544
    https://www.computersciencemaster.com.br/heranca-em-java/
    https://www.devmedia.com.br/encapsulamento-polimorfismo-heranca-em-java/12991#:~:text=A%20heran%C3%A7a%20%C3%A9%20um%20mecanismo,e%20reaproveitamento%20de%20c%C3%B3digo%20existente.

Herança

- É um tipo de associação que permite que uma classe herde todosdados e comportamentos de outra

- Definições importantes

- Vantagens

- Reuso
    - Polimorfismo

- Sintaxe
    - class A extends B

Vamos fazer um exemplo disso criando um novo projeto banking_account.

No arquivo Account.java vamos colocar o seguinte

    package entities;

    public class Account {
        
        private Integer number;
        private String holder;
        private Double balance;
        
        public Account() {
        }

        public Account(Integer number, String holder, Double balance) {
            this.number = number;
            this.holder = holder;
            this.balance = balance;
        }

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }

        public String getHolder() {
            return holder;
        }

        public void setHolder(String holder) {
            this.holder = holder;
        }

        public Double getBalance() {
            return balance;
        }

        // É necessário tirar esse setBalance
        // pois não iremos mudar as nossas contas manualmente.
        //public void setBalance(Double balance) {
        //	this.balance = balance;
        //}
        
        public void withdraw(double amount) {
            balance -= amount;
        }
        
        public void deposit(double amount) {
            balance += amount;
        }
    }

Agora, vamos criar a sua subclasse BusinessAccount que herdará todas as funcionalidades da classe Account. 

Para dizer que ela está herdando a classe Account basta usar extends Account

    package entities;

    public class BusinessAccount extends Account {
        
        private Double loanLimit;
        
        public BusinessAccount() {
            super();
        }

        public BusinessAccount(Integer number, String holder, Double balance, Double loanLimit) {
            super(number, holder, balance);
            this.loanLimit = loanLimit;
        }

        public Double getLoanLimit() {
            return loanLimit;
        }

        public void setLoanLimit(Double loanLimit) {
            this.loanLimit = loanLimit;
        }
        
        public void loan(double amount) {
            if (amount <= loanLimit) {
                deposit(amount);
            }
        }
    }

Mas, note que, o balance ela está no modificador de acesso private. No caso, vamos usar o protected, que foi visto na aula de encapsulamento, donde ele permite que a tal variável seja acessível apenas na própria classe e na sua subclasse.

No caso, na classe Account, vc muda do private para protected do balance e no arquivo BusinessAccount vamos colocar o seguinte

    package entities;

    public class BusinessAccount extends Account {
        
        private Double loanLimit;
        
        public BusinessAccount() {
            // É legal colocar esse super(), pois pode ser que na classe superior tenha algum recurso que vc queria usar na subclasse
            super();
        }

        public BusinessAccount(Integer number, String holder, Double balance, Double loanLimit) {
            super(number, holder, balance);
            this.loanLimit = loanLimit;
        }

        public Double getLoanLimit() {
            return loanLimit;
        }

        public void setLoanLimit(Double loanLimit) {
            this.loanLimit = loanLimit;
        }
        
        public void loan(double amount) {
            if (amount <= loanLimit) {
                //deposit(amount);
                balance += amount - 10.0;
            }
        }
    }

Isso finaliza a arquitetura da classe que precisamos.

Definições importantes

- Relação "é-um"

- Generalização/especialização

- Superclasse (classe base)/subclasse (classe derivada)

- Herança/extensão

- Herança é uma associação entre classes (e não entre objetos)

## Aula 04 - Upcasting e downcasting:
Seguir link para leitura

    https://pt.stackoverflow.com/questions/131091/o-que-%C3%A9-upcasting-e-downcasting-na-linguagem-java
    https://acervolima.com/upcasting-vs-downcasting-em-java/

- Upcasting
    - Casting da subclasse para superclasse
    - Uso comum: polimorfismo

-Downcasting
    - Casting da superclasse para subclasse
    - Palavra instanceof
    - Uso comum: métodos que recebem parâmetros genéricos (ex: Equals)

Bom, vamos seguir com o mesmo projeto, banking_account.

Nela vamos criar um novo arquivo no entities SavingsAccount.java e dentro dela realizar o seguinte

    package entities;

    public class SavingsAccount extends Account {

        private Double interestRate;
        
        public SavingsAccount() {
            super();
        }

        public SavingsAccount(Integer number, String holder, Double balance, Double interestRate) {
            super(number, holder, balance);
            this.interestRate = interestRate;
        }

        public Double getInterestRate() {
            return interestRate;
        }

        public void setInterestRate(Double interestRate) {
            this.interestRate = interestRate;
        }
        
        public void updateBalance() {
            balance += balance * interestRate;
        }
    }

Bom, até aqui, nada de novidade sobre o uso de herança.

Agora, no arquivo de aplicação Program.java vamos fazer o seguinte

    package application;

    import entities.Account;
    import entities.BusinessAccount;
    import entities.SavingsAccount;

    public class Program {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            Account acc = new Account(1001, "Alex", 0.0);
            BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);
            
            // UPCASTING
            Account acc1 = bacc;
            Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
            Account acc3 = new SavingsAccount(1004, "Anna", 0.0, 0.01);
            
            System.out.println(acc1.getBalance());
            
        }

    }

Note que, aqui estamos atribuindo um valor de uma subclasse para um valor de superclasse e isso não está dando nenhum erro.

Agora, vamos ver o que é Downcasting

    package application;

    import entities.Account;
    import entities.BusinessAccount;
    import entities.SavingsAccount;

    public class Program {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            Account acc = new Account(1001, "Alex", 0.0);
            BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);
            
            // UPCASTING
            Account acc1 = bacc;
            Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
            Account acc3 = new SavingsAccount(1004, "Anna", 0.0, 0.01);
            
            System.out.println(acc1.getBalance());
            
            // DOWNCASTING
            BusinessAccount acc4 = acc2;
            
        }

    }

Note que, o formato abaixo acc4, quando foi atribuído o acc2 que é uma superclasse está dando um erro, pois é uma atribuição de uma classe maior para uma classe maior. No caso, para forçarmos isso teríamos que realizar um casting colocando o nome da subclasse que vc está fazendo a atribuição

    package application;

    import entities.Account;
    import entities.BusinessAccount;
    import entities.SavingsAccount;

    public class Program {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            Account acc = new Account(1001, "Alex", 0.0);
            BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);
            
            // UPCASTING
            Account acc1 = bacc;
            Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
            Account acc3 = new SavingsAccount(1004, "Anna", 0.0, 0.01);
            
            System.out.println(acc1.getBalance());
            
            // DOWNCASTING
            BusinessAccount acc4 = (BusinessAccount) acc2;
            
        }

    }

Como prova disso, veja o que é possível seguinte

    package application;

    import entities.Account;
    import entities.BusinessAccount;
    import entities.SavingsAccount;

    public class Program {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            Account acc = new Account(1001, "Alex", 0.0);
            BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);
            
            // UPCASTING
            Account acc1 = bacc;
            Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
            Account acc3 = new SavingsAccount(1004, "Anna", 0.0, 0.01);
            
            System.out.println(acc1.getBalance());
            
            // DOWNCASTING
            BusinessAccount acc4 = (BusinessAccount) acc2;
            acc4.loan(100.0);
            
        }

    }

Note que, estamos conseguindo acessar o método loan que reside dentro da subclasse BusinessAccount e que não está presente no Account.

Agora, vamos explorar mais realizando o seguinte

    package application;

    import entities.Account;
    import entities.BusinessAccount;
    import entities.SavingsAccount;

    public class Program {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            Account acc = new Account(1001, "Alex", 0.0);
            BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);
            
            // UPCASTING
            Account acc1 = bacc;
            Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
            Account acc3 = new SavingsAccount(1004, "Anna", 0.0, 0.01);
            
            System.out.println(acc1.getBalance());
            
            // DOWNCASTING
            BusinessAccount acc4 = (BusinessAccount) acc2;
            acc4.loan(100.0);
            
            BusinessAccount acc5 = (BusinessAccount) acc3;
        }

    }

Note que, em acc5 temos algo bem diferente. Ou seja, estamos tentando atribuir um valor de uma superclasse que tem como valor uma subclasse para uma outra subclasse?

Bom, aqui vem outra questão. Nem sempre o downcasting funciona. Para evitar esse tipo de erro iremos usar o instanceof

    

## Aula 05 - Sobreposição, palavra super, anotação @Override:

## Aula 06 - Classes e métodos final:

## Aula 07 - Introdução ao polimorfismo:

## Aula 08 - Exercício resolvido:

## Aula 09 - Exercício de fixação:

## Aula 10 - Classes abstratas:

## Aula 11 - Métodos abstratos:

## Aula 12 - Exercício de fixação:

## Aula 13 - Correção em vídeo do exercício de fixação:
