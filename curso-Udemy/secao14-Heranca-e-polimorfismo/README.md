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
            
            //BusinessAccount acc5 = (BusinessAccount) acc3;
            if (acc3 instanceof BusinessAccount) {
                BusinessAccount acc5 = (BusinessAccount) acc3;
                acc5.loan(200.0);
                System.out.println("Loan!");
            }
            
            if (acc3 instanceof SavingsAccount) {
                SavingsAccount acc5 = (SavingsAccount) acc3;
                acc5.updateBalance();
                System.out.println("Update!");
            }
        }

    }

No caso, o que aconteceu acima, foi que o instanceof ele viu que não valeu para a condição acc3 instanceof BusinessAccount, mas valeu para a segunda condição.

## Aula 05 - Sobreposição, palavra super, anotação @Override:
Seguir link para leitura

    https://www.devmedia.com.br/sobrecarga-e-sobreposicao-de-metodos-em-orientacao-a-objetos/33066#:~:text=Basicamente%20a%20sobreposi%C3%A7%C3%A3o%20(override)%20possibilita,o%20nome%20e%20a%20assinatura.

Sobreposição ou sobrescrita

- É a implementação de um método de uma superclasse na subclasse

- É fortemente recomendável usar a anotação @Override em um método sobrescrito
    - Facilita a leitura e compreensão do código
    - Avisamos ao compilador (boa prática)

Vamos continuar no mesmo proejto banking_account.

Bom, vamos ver um cenário de exemplo disso

    Suponha que a operação de saque possui uma taxa no valor 
    de 5.0. Entretanto, se a conta for do tipo poupança, esta taxa não deve ser cobrada.

Como resolver isso?

    Resposta: sobrescrevendo o método withdraw na subclasse SavingsAccount

Basicamente, para realizarmos uma sobrescrição de um método da superclasse dentro de uma subclasse, usamos a sintaxe @Override. Daí, vimos que no arquivo Account.java temos o método withdraw e queremos sobrescrever esse método dentro da sua subclasse SavingsAccount. Então realizamos o seguinte no arquivo SavingsAccount

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
        
        @Override
        public void withdraw(double amount) {
            balance -= amount;
        }
    }

Bom, aí vem a pergunta. Qual a importância o Override? No caso, para realizar a sobreposição de métodos da superclasse para a subclasse, o Override, ele serve para vc conseguir igualar os nomes dos métodos que vc realizará a sobreposição.

Visto isso, vamos testar se o código está rodando bem.

No caso, na aplicação, o arquivo Program.java, vamos colocar o seguinte

    package application;

    import entities.Account;
    import entities.BusinessAccount;
    import entities.SavingsAccount;

    public class Program {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            //Account acc = new Account(1001, "Alex", 0.0);
            //BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);
            
            // UPCASTING
            //Account acc1 = bacc;
            //Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
            //Account acc3 = new SavingsAccount(1004, "Anna", 0.0, 0.01);
            
            //System.out.println(acc1.getBalance());
            
            // DOWNCASTING
            //BusinessAccount acc4 = (BusinessAccount) acc2;
            //acc4.loan(100.0);
            
            //BusinessAccount acc5 = (BusinessAccount) acc3;
            //if (acc3 instanceof BusinessAccount) {
            //	BusinessAccount acc5 = (BusinessAccount) acc3;
            //	acc5.loan(200.0);
            //	System.out.println("Loan!");
            //}
            
            //if (acc3 instanceof SavingsAccount) {
            //	SavingsAccount acc5 = (SavingsAccount) acc3;
            //	acc5.updateBalance();
            //	System.out.println("Update!");
            //}
            
            Account acc1 = new Account(1001, "Alex", 1000.0);
            acc1.withdraw(200.0);
            System.out.println(acc1.getBalance());
        }

    }

Bom, se tudo estiver funcionando corretamente, deverá ser exibido no console 795.0.

Agora, falta verificar se o método withdraw sobreposto na subclasse SavingsAccount está ou não funcionando como sobrescrevemos. Para isso, no arquivo Program.java vamos colocar o seguinte

    package application;

    import entities.Account;
    import entities.BusinessAccount;
    import entities.SavingsAccount;

    public class Program {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            //Account acc = new Account(1001, "Alex", 0.0);
            //BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);
            
            // UPCASTING
            //Account acc1 = bacc;
            //Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
            //Account acc3 = new SavingsAccount(1004, "Anna", 0.0, 0.01);
            
            //System.out.println(acc1.getBalance());
            
            // DOWNCASTING
            //BusinessAccount acc4 = (BusinessAccount) acc2;
            //acc4.loan(100.0);
            
            //BusinessAccount acc5 = (BusinessAccount) acc3;
            //if (acc3 instanceof BusinessAccount) {
            //	BusinessAccount acc5 = (BusinessAccount) acc3;
            //	acc5.loan(200.0);
            //	System.out.println("Loan!");
            //}
            
            //if (acc3 instanceof SavingsAccount) {
            //	SavingsAccount acc5 = (SavingsAccount) acc3;
            //	acc5.updateBalance();
            //	System.out.println("Update!");
            //}
            
            Account acc1 = new Account(1001, "Alex", 1000.0);
            acc1.withdraw(200.0);
            System.out.println(acc1.getBalance());
            
            Account acc2 = new SavingsAccount(1002, "Maria", 1000.0, 0.01);
            acc2.withdraw(200.0);
            System.out.println(acc2.getBalance());
        }

    }

Bom, no experimento acima, se tudo estiver funcionando corretamente será exibido no console 795.0 e 800.0, uma de uma conta corrente normal e a outra o saque de uma conta salário. O que indica que para a conta salário, o mesmo método withdraw utilizado foi usado a que foi sobrescrito no SavingsAccount.

Agora, para finalizar, vamos entender melhor a palavra super().

Palavra super

É possível chamar a implementação da superclasse usando a palavra super.

Exemplo: 

    suponha que, na classe BusinessAccount, a regra para saque seja realizar o saque normalmente da superclasse, e descontar mais 2.0.

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
        balance -= 2.0;
    }

Bom, vamos então experimentar isso. No arquivo BusinessAccount.java colocamos o seguinte código

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
        
        @Override
        public void withdraw(double amount) {
            super.withdraw(amount);
            balance -= 2.0;
        }
    }

Agora, no Program.java vamos realizar o seguinte

    package application;

    import entities.Account;
    import entities.BusinessAccount;
    import entities.SavingsAccount;

    public class Program {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            //Account acc = new Account(1001, "Alex", 0.0);
            //BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);
            
            // UPCASTING
            //Account acc1 = bacc;
            //Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
            //Account acc3 = new SavingsAccount(1004, "Anna", 0.0, 0.01);
            
            //System.out.println(acc1.getBalance());
            
            // DOWNCASTING
            //BusinessAccount acc4 = (BusinessAccount) acc2;
            //acc4.loan(100.0);
            
            //BusinessAccount acc5 = (BusinessAccount) acc3;
            //if (acc3 instanceof BusinessAccount) {
            //	BusinessAccount acc5 = (BusinessAccount) acc3;
            //	acc5.loan(200.0);
            //	System.out.println("Loan!");
            //}
            
            //if (acc3 instanceof SavingsAccount) {
            //	SavingsAccount acc5 = (SavingsAccount) acc3;
            //	acc5.updateBalance();
            //	System.out.println("Update!");
            //}
            
            Account acc1 = new Account(1001, "Alex", 1000.0);
            acc1.withdraw(200.0);
            System.out.println(acc1.getBalance());
            
            Account acc2 = new SavingsAccount(1002, "Maria", 1000.0, 0.01);
            acc2.withdraw(200.0);
            System.out.println(acc2.getBalance());
            
            Account acc3 = new BusinessAccount(1003, "Leonardo", 1000.0, 5000.0);
            acc3.withdraw(200.0);
            System.out.println(acc3.getBalance());
            
        }

    }

Bom, se apareceu 795.0, 800.0 e 793.0 significa que rodou certo. Pois o saque de 200.0 que foi realizado usando a classe do BusinessAccount, não só descontou o valor 5.0, como tbm o valor 2.0 que foi definido na sua sobreposição.

Seguir o link do repositório do professor

    https://github.com/acenelio/inheritance3-java

## Aula 06 - Classes e métodos final:
Vamos ver classes e métodos final.

Seguir o link de leitura

    https://www.dm.ufscar.br/~waldeck/curso/java/part27.html#:~:text=final%3A%20Uma%20classe%20final%20pode,awt%2C%20por%20exemplo.
    https://deviniciative.wordpress.com/2019/06/25/afinal-o-que-o-final-do-java-resolve/#:~:text=Fica%20mais%20f%C3%A1cil%20decidir%20utilizar,que%20ser%C3%A3o%20consumidos%20sem%20altera%C3%A7%C3%A3o.

Classes e métodos final

- Palavra chave: final

- Classe: evita que a classe seja herdada

    public final class SavingsAccount {

- Método: evita que o método sob seja sobreposto

Ou seja, basicamente, indica o fim da linhagem daquela classe ou método.

Primeiro, vamos ver a palavra final sendo aplicada à classe. Então, suponha o seguinte cenário

Exemplo - Classe final

    Suponha que você queira evitar que sejam criadas subclasses de SavingsAccount

    public final class SavingsAccount {
        (...)

Basicamente, se vc quiser evitar que seja criada alguma subclasse da classe SavingsAccount, bastaria colocar public final class na construção dessa classe. Como podemos ver no arquivo SavingsAccount.java

    package entities;

    public final class SavingsAccount extends Account {

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
        
        @Override
        public void withdraw(double amount) {
            balance -= amount;
        }
    }

Daí, como uma forma de experimento, vamos criar uma classe cobaia para verificar que, de fato, não podemos mais criar uma subclasse da classe SavingsAccount. No caso, criamos o seguinte arquivo SavingsAccountPlus.java

    package entities;

    public class SavingsAccountPlus extends SavingsAccount {

    }

Daí, vamos ver que essa extensão fica sublinhado de vermelho indicando que está errado e que não é possível herdar a classe SavingsAccount para a subclasse SavingsAccountPlus.

Agora, vamos ver como seria o uso da palavra final para os métodos. No caso, vamos continuar com o arquivo que criamos SavingsAccountPlus.java e tirar o final da classe SavingsAccount.java. Daí, dentro do arquivo SavingsAccountPlus, colocamos o seguinte

    package entities;

    public class SavingsAccountPlus extends SavingsAccount {

        @Override
        public void withdraw(double amount) {
            balance -= amount + 2.0;
        }
    }

Em seguida, no arquivo SavingsAccount, no método withdrwaw colocamos a palavra final da seguinte forma

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
        
        @Override
        public final void withdraw(double amount) {
            balance -= amount;
        }
    }

Note que, feito isso, no arquivo SavingsAccountPlus.java o método que tentamos sobrepor ficará com sublinhado em vermelho indicando que ele não pode ser sobreposto.

Agora, para concluirmos a aula, vamos ver os motivos das finalidades de uso da palavra final

Pra quê?

- Segurança: dependendo das regras do negócio, às vezes é desejável garantir que uma classe não seja herdada, ou que um método não seja sobreposto.
    -  Geralmente convém acrescentar final em métodos sobrepostos, pois sobreposições múltiplas podem ser uma porta de entrada para inconsistências

- Performance: atributos de tipo de uma classe final são analisados de forma mais rápida em tempo de execução.
    -  Exemplo clássico: String

        https://docs.oracle.com/javase/7/docs/api/java/lang/String.html

## Aula 07 - Introdução ao polimorfismo:
Seguir o link para leitura

    https://en.wikipedia.org/wiki/Polymorphism_(computer_science)#:~:text=In%20programming%20language%20theory%20and,to%20represent%20multiple%20different%20types.
    https://ncatlab.org/nlab/show/universe+polymorphism
    https://ncatlab.org/nlab/show/polymorphism
    https://blog.hubspot.es/website/polimorfismo-java#:~:text=El%20polimorfismo%20hace%20referencia%20a,nombre%20para%20ejecutar%20funciones%20diferentes.

Polimorfismo

Em Programação Orientada a Objetos, polimorfismo é recurso que permite que variáveis de um mesmo tipo mais genérico possam apontar para objetos de tipos específicos diferentes, tendo assim comportamentos diferentes conforme cada tipo específico.

    Account x = new Account(1020, "Alex", 1000.0);
    Account y = new SavingsAccount(1023, "Maria", 1000.0, 0.01);

    x.withdraw(50.0);
    y.withdraw(50.0);

Importante entender
- A associação do tipo específico com o tipo genérico é feita em tempo de execução (upcasting).

- O compilador não sabe para qual tipo específico a chamada do método Withdraw está sendo feita (ele só sabe que são duas variáveis tipo Account):

    Account x = new Account(1020, "Alex", 1000.0);
    Account y = new SavingsAccount(1023, "Maria", 1000.0, 0.01);
    x.withdraw(50.0);
    y.withdraw(50.0);

## Aula 08 - Exercício resolvido:

## Aula 09 - Exercício de fixação:

## Aula 10 - Classes abstratas:

## Aula 11 - Métodos abstratos:

## Aula 12 - Exercício de fixação:

## Aula 13 - Correção em vídeo do exercício de fixação:
