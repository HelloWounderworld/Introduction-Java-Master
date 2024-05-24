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

    https://www.devmedia.com.br/heranca-versus-composicao-qual-utilizar/26145
    https://www.treinaweb.com.br/blog/devo-usar-heranca-ou-composicao
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

Seguir as classes "Jogador", "Jogo", "Heroi" e "Monstro" e enumeração "Direcao" do projeto "exercicios" do pacote "oo.heranca".

### Deafio - Herança - Carros:
Criar uma classe "Carro" e, a partir dessa classe genérica, crie duas classes "Ferrari" e "Civic" que irá herdar a classe "Carro" e nela definiremos os métodos de acelerar e frear com diferentes intensidades, dentro do projeto "exercicios" do pacote "oo.heranca.desafio".

Por fim, para conseguirmos testa-las, criamos a classe "CarroTeste" no mesmo nível das outras classes de cima, para instanciarmos.

### Desafio - Herança - Carro - Colocando condições para evitar absurdos:
Bom, fizemos a seguinte modificação na classe Carro

    package oo.heranca.desafio;

    public class Carro {

        final int VELOCIDADE_MAXIMA;
        int velocidadeAtual;
        int delta = 5;
        
        Carro(int velocidadeMaxima) {
            VELOCIDADE_MAXIMA = velocidadeMaxima;
        }
        
        void acelerar() {
            
            if(velocidadeAtual + delta > VELOCIDADE_MAXIMA) {
                velocidadeAtual = VELOCIDADE_MAXIMA;
            } else {
                velocidadeAtual += delta;
            }
        }
        
        void frear() {
            if(velocidadeAtual >= delta) {
                velocidadeAtual -= delta;
            } else {
                velocidadeAtual = 0;
            }
        }
        
        public String toString() {
            return "Velocidade atual " + velocidadeAtual + "km/h.";
        }
    }

Com essa forma atual, as outras classes que herdaram a classe carro irá exibir o erro.

O desafio é vc conseguir corrigir o erro de modo que o Civic e a Ferrari continue com o mesmo funcionamento.

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

### Definicao:
Bom existem varios tipos de definicoes de polimorfismo. Gostaria de fornecer duas delas que considero bastante interessantes, a primeira definicao de polimorfismo e a generalizacao de morfismos, considerado pelo Shinichi Mochizuki, e outra que vem do universo da teoria de tipagem, ou seja, no ambito dentro da ciencias da computacao, esta ultima que e a teoria base que deu origem a todas as linguagens de programacao orientadas a objetos.

#### Definicao geral de polimorfismo:
Para uma categoria $\mathbb{C}$, um poli-Morfismo e uma colecao de morfismos com um recurso e alvo comum, considerado como um morfismo em uma nova categoria $\mathbb{C}^{poly}$ com o mesmo objeto, mas com conjunto de morfismos $\mathbb{C}^{poly}(a,b) := \mathbb{P}(\mathbb{C}(a,b))$ o conjunto potencia do conjunto de morfismos original.

#### Definicao de Polimorfismo no sentido de teoria de tipagem:

Alguém me explica qual a razão de associarem tanto polimorfismos à Programação Orientada a Objetos (OOP)?

Polimorfismos se manisfestam em sistemas de tipos, sejam eles representando programas escritos em uma linguagem de programação ou outra coisa, em outras classes de linguagens formais. 

Nada mais é do que a possibilidade de se utilizar de funções que possuem o mesmo nome, mas que se aplicam a diferentes tipos. _Função polimórfica_ é o nome que se dá a uma função que exibe polimorfismo.

Existem vários tipos de funções polimórficas. Uma delas é quando a função, digamos definida num tipo T, recebe o mesmo nome de sua restrição a um subtipo S. Nesse caso, fala-se que a função é _polimórfica de subtipo_.

Observe que isso em nada está relacionado com OOP. Polimorfismo __não__ é uma característica fundamental de OOP. OOP não necessariamente exibe todos os tipos de polimorfismo!!

O que se observa é que polimorfismo por subtipos é uma _consequência_ da relação de herança que se pode estabelecer entre classes (no caso de OOP baseada em classes) ou entre objetos e seus protótipos (no caso de OOP baseada em objetos).

Polimorfismo não é uma _premissa_ de OOP. É uma _consequência_ de suas premissas fundamentais. 

Existem duas formas de polimorfismo:

- Estático/Sobrecarga

- Dinâmico

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

Seguir as classes "Pessoa", "Arroz", "Feijao", "Sorvete" e "Jantar" do pacote "oo.polimorfismo" do projeto "exercicios".

### Desafio - Polimorfismo:
Seguir as classes "Pessoa", "Arroz", "Feijao", "Sorvete" e "Jantar" do pacote "oo.polimorfismo" do projeto "exercicios", que estão em polimorfismo estático.

O desafio seria, tornar esse polimorfismo estático/sobrecarga para dinâmico.

## Aula 08 - Exercício resolvido:
Seguir o enunciado

    Uma empresa possui funcionários próprios e terceirizados.Para cada funcionário, deseja-se registrar nome, horastrabalhadas e valor por hora. Funcionários terceirizadopossuem ainda uma despesa adicional.

    O pagamento dos funcionários corresponde ao valor da hora multiplicado pelas horas trabalhadas, sendo que os funcionários terceirizados ainda recebem um bônus correspondente a 110% de sua despesa adicional.

    Fazer um programa para ler os dados de N funcionários (N fornecido pelo usuário) e armazená-los em uma lista. Depois de ler todos os dados, mostrar nome e pagamento de cada funcionário na mesma ordem em que foram digitados.

    Construa o programa conforme projeto ao lado. Veja

Example

    Enter the number of employees: 3
    Employee #1 data:
    Outsourced (y/n)? n
    Name: Alex
    Hours: 50
    Value per hour: 20.00
    Employee #2 data:
    Outsourced (y/n)? y
    Name: Bob
    Hours: 100
    Value per hour: 15.00
    Additional charge: 200.00
    Employee #3 data:
    Outsourced (y/n)? n
    Name: Maria
    Hours: 60
    Value per hour: 20.00
    PAYMENTS:
    Alex - $ 1000.00
    Bob - $ 1720.00
    Maria - $ 1200.00

Seguir o link do repositório do professor

    https://github.com/acenelio/inheritance4-java

## Aula 09 - Exercício de fixação:
Fazer quando estiver revisando o conceito.

    Fazer um programa para ler os dados de N produtos (N fornecido pelo usuário). Ao final, mostrar a etiqueta de preço de cada produto na mesma ordem em que foram digitados.

    Todo produto possui nome e preço. Produtos importados possuem uma taxa de alfândega, e produtos usados possuem data de fabricação. Estes dados específicos devem ser acrescentados na etiqueta de preço conforme exemplo (próxima página). Para produtos importados, a taxa e alfândega deve ser acrescentada ao preço final do produto.

    Favor implementar o programa conforme projeto ao lado.

Exemplo de funcionamento

    Enter the number of products: 3
    Product #1 data:
    Common, used or imported (c/u/i)? i
    Name: Tablet
    Price: 260.00
    Customs fee: 20.00
    Product #2 data:
    Common, used or imported (c/u/i)? c
    Name: Notebook
    Price: 1100.00
    Product #3 data:
    Common, used or imported (c/u/i)? u
    Name: Iphone
    Price: 400.00
    Manufacture date (DD/MM/YYYY): 15/03/2017
    PRICE TAGS:
    Tablet $ 280.00 (Customs fee: $ 20.00)
    Notebook $ 1100.00
    Iphone (used) $ 400.00 (Manufacture date: 15/03/2017)

Seguir o link do repositório do professor. Comparar a sua resolução com a dele

    https://github.com/acenelio/inheritance5-java

## Aula 10 Abstração - Classes abstratas:
Seguir o link de leitura

    https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html#:~:text=An%20abstract%20class%20is%20a,but%20they%20can%20be%20subclassed.&text=When%20an%20abstract%20class%20is,methods%20in%20its%20parent%20class.
    https://www.devmedia.com.br/polimorfismo-classes-abstratas-e-interfaces-fundamentos-da-poo-em-java/26387
    https://www.treinaweb.com.br/blog/classes-abstratas-vs-interfaces#:~:text=%C3%89%20um%20tipo%20de%20classe,apenas%20de%20suas%20%E2%80%9Csubclasses%E2%80%9D.

Classes abstratas:

- São classes que não podem ser instanciadas

- É uma forma de garantir herança total: somente subclasses não 
abstratas podem ser instanciadas, mas nunca a superclasse abstrata

Basicamente, as classes abstratas, elas carregam todas as características ou definições intrísecas do que define um determinado conceito.

Exemplo, um animal, a definição são seres vivos que possuem algumas características em comum: nascem, desenvolvem-se, reproduzem-se e morrem. Donde, com base dessa definição, temos muitos, mas muitos, animais como gato, cachorro, papagaio, etc... Só que, sempre que vemos esses animais, não chamamos elas de "animais", certo? E sim, chamamos pelo nome que torna único as características desses seres, mas que não deixam de serem animais. 

Basicamente, quem está exercendo o papel de uma classe abstrata aqui é a classe "animal", donde, dentro dela, podemos definir as características que qualquer "animal" possui, porém, sempre que queremos pegar algum animal de exemplo, que é o momento em que instanciamos, não instanciamos essa classe "animal", mas, sim, instanciamos as subclasses que derivam desse conceito de animal, como gato, cachorro, papagaio, peixe, etc...

Ou seja, basicamente, tornarmos uma classe abstrata, é quando conseguimos definir uma categoria, onde está definido as estruturas fundamentais donde originam outras subcategorias que são estruturas mais específicas, mas que usam, como base, essa estrutura fundamental.

Vamos seguir com um exemplo.

    Suponha que em um negócio relacionado a banco, apenas contas poupança e contas para empresas são permitidas. Não existe conta comum.

    Para garantir que contas comuns não possam ser instanciadas, basta acrescentarmos a palavra "abstract" na declaração da classe.

    public abstract class Account {
    (...)

    Notação UML: itálico

Bom, como um experimento, vamos fazer o seguinte. Primeiro, no arquivo Program.java vamos realizar a seguinte alteração

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
            
    //		Account acc1 = new Account(1001, "Alex", 1000.0);
    //		acc1.withdraw(200.0);
    //		System.out.println(acc1.getBalance());
            
    //		Account acc2 = new SavingsAccount(1002, "Maria", 1000.0, 0.01);
    //		acc2.withdraw(200.0);
    //		System.out.println(acc2.getBalance());
    //		
    //		Account acc3 = new BusinessAccount(1003, "Leonardo", 1000.0, 5000.0);
    //		acc3.withdraw(200.0);
    //		System.out.println(acc3.getBalance());
            
            Account acc1 = new Account(1001, "Alex", 1000.0);
            Account acc2 = new SavingsAccount(1002, "Maria", 1000.0, 0.01);
            Account acc3 = new BusinessAccount(1003, "Bob", 1000.0, 500.0);

            
        }

    }

Em seguida, no arquivo Account.java, vamos colocar a palavra abstract da seguinte forma

    package entities;

    public abstract class Account {
        
        private Integer number;
        private String holder;
        protected Double balance;
        
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
            balance -= amount + 5.0;
        }
        
        public void deposit(double amount) {
            balance += amount;
        }
    }

Note que, ao fazermos isso, no arquivo Program.java, ele exibirá um erro à respeito disso. Ou seja, não está sendo possível instanciar a classe Account.

Questionamento:

- Se a classe Account não pode ser instanciada, porque simplesmente não criar somente SavingsAccounte BusinessAccount?

- Resposta:
    - Reuso

    - Polimorfismo: a superclasse classe genérica nos permite tratar de forma fácil e uniforme todos os tipos de conta, inclusive com polimorfismo se for o caso (como fizemos nos últimos exercícios). Por exemplo, você pode colocar todos tipos de contas em uma mesma coleção.

- Demo: suponha que você queira:
    - Totalizar o saldo de todas as contas.

    - Depositar 10.00 em todas as contas.

Seguir o link do repositório do professor

    https://github.com/acenelio/inheritance6-java

Bom, ciente do motivo de usarmos o abstract acima, vamos ver como adotamos as boas práticas. No caso, no arquivo Program.java vamos realizar as seguintes modificações

    package application;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.Locale;

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
            
    //		Account acc1 = new Account(1001, "Alex", 1000.0);
    //		acc1.withdraw(200.0);
    //		System.out.println(acc1.getBalance());
            
    //		Account acc2 = new SavingsAccount(1002, "Maria", 1000.0, 0.01);
    //		acc2.withdraw(200.0);
    //		System.out.println(acc2.getBalance());
    //		
    //		Account acc3 = new BusinessAccount(1003, "Leonardo", 1000.0, 5000.0);
    //		acc3.withdraw(200.0);
    //		System.out.println(acc3.getBalance());
            
    //		Account acc1 = new Account(1001, "Alex", 1000.0);
    //		Account acc2 = new SavingsAccount(1002, "Maria", 1000.0, 0.01);
    //		Account acc3 = new BusinessAccount(1003, "Bob", 1000.0, 500.0);
            
            Locale.setDefault(Locale.US);
            
            List<Account> list = new ArrayList<>();
            
            list.add(new SavingsAccount(1002, "Maria", 1000.0, 0.01));
            list.add(new BusinessAccount(1003, "Alex", 1000.0, 500.0));
            list.add(new SavingsAccount(1004, "Bob", 300.0, 0.01));
            list.add(new BusinessAccount(1005, "Anna", 500.0, 500.0));
            
            double sum = 0.0;
            for (Account acc : list) {
                sum += acc.getBalance();
            }
            
            System.out.printf("Total balance: %.2f%n", sum);
            
            for (Account acc : list) {
                acc.deposit(10.0);
            }
            
            for (Account acc : list) {
                System.out.printf("Updated balance for account %d: %.2f%n", acc.getNumber(), acc.getBalance());
            }
            
        }

    }

Bom, aqui em cima, usamos fortemente o conceito de polimorfismo para conseguirmos controlar as ações que seriam uniformes.

Seguir as classes "Arroz", "Feijao", "Sorvete", "Comida", "Pessoa" e "Jantar" do pacote "oo.polimorfismo" do projeto "exercicios" - Nesse exercíco, eu abstrai a classe "Comida".

Seguir as classes "Animal", "Mamifero", "Cachorro" e "TesteAbstrato" do pacote "oo.abstrato" do projeto "exercicios".

## Aula 11 - Métodos abstratos:
Seguir o link de leitura

    https://www.feg.unesp.br/Home/PaginasPessoais/profedsonluizfrancasenne/pc2-cap5.pdf
    https://www.devmedia.com.br/polimorfismo-classes-abstratas-e-interfaces-fundamentos-da-poo-em-java/26387

Métodos abstratos, são basicamente, métodos inacabados. É como se vc soubesse que existe uma função, mas não sabe ainda como será a cara dela. Então, vc define esse método de forma implícito/abstrato, para ter a flexibilidade de conseguir definir esse método nos momentos mais certeiros das subclasses que foram herdando a classe abstrata que possui esse método abstrato.

Os métodos abstratos, tem como característica, os seguintes:

- São métodos que não possuem implementação.

- Métodos precisam ser abstratos quando a classe é genérica demais para conter sua implementação.

- Se uma classe possuir pelo menos um método abstrato, então esta classe também é abstrata. (Demonstre matematicamente!)

- Notação UML: itálico

- As classes não abstratas que herdarem das classes abstratas que contem um método abstrato, necessariamente, essa classe precisa implementar esse método abstrado que foi definido na classe Pai.

- Uma classe abstrata herdada de uma classe abstrata, que contém um método abstrato, não precisa implementar o método abstrado da classe abstrata pai.

Vamos fazer um exercício disso.

Seguir o enunciado

    Fazer um programa para ler os dados de N figuras (N fornecido pelo usuário), e depois mostrar as áreas destas figuras na mesma ordem em que foram digitadas.

Exemplo do seu funcionamento

    Enter the number of shapes: 2
    Shape #1 data:
    Rectangle or Circle (r/c)? r
    Color (BLACK/BLUE/RED): BLACK
    Width: 4.0
    Height: 5.0
    Shape #2 data:
    Rectangle or Circle (r/c)? c
    Color (BLACK/BLUE/RED): RED
    Radius: 3.0
    SHAPE AREAS:
    20.00
    28.27

Seguir o link do repositório do professor

    https://github.com/acenelio/inheritance7-java

No caso, vamos começar criando um novo projeto para isso, abstract_methods. Daí, dentro da pasta src vamos criar os diretórios application e entities. Dentro do diretório application, criamos um arquivo Program.java e dentro do diretório entities criamos um arquivo Shape.java e enumeramos as criando um arquivo Color.java.

Agora, no arquivo Color.java vamos colocar o seguinte

    package entities.enums;

    public enum Color {
        BLACK,
        BLUE,
        RED;
    }

Agora, na classe Shape vamos declarar o atributo

    package entities;

    import entities.enums.Color;

    public class Shape {
        
        private Color color;
    }

Vamos criar os getters e setters e criamos o método abstrato chamado area

    package entities;

    import entities.enums.Color;

    public class Shape {
        
        private Color color;

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }
        
        public abstract double area();
    }

Note que, ao colocarmos o abstract no método fica com um erro. Pois, precisamos colocar o abstract dentro da classe tbm, como foi afirmado no teorema "Dada uma classe, se ela tiver, pelo menos, um método abstrado, então essa classe é abstrata"

    package entities;

    import entities.enums.Color;

    public abstract class Shape {
        
        private Color color;

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }
        
        public abstract double area();
    }

Para finalizar, vamos colocar os construtores dentro dessa classe

    package entities;

    import entities.enums.Color;

    public abstract class Shape {
        
        private Color color;
        
        public Shape() {
        };

        public Shape(Color color) {
            this.color = color;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }
        
        public abstract double area();
    }

Agora, vamos criar uma subclasse para essa classe Shape, o Rectangle. No caso, dentro do diretório entities, vamos criar o arquivo Rectangle.java e dentro dela colocar o seguinte

    package entities;

    public class Rectangle extends Shape {

    }

Note que isso dá um erro, pois na classe Shape ela está como abstrata, então para conseguirmos "herdar" vamos ter que realizar uma sobreposição do método abstrado da classe Shape

    package entities;

    public class Rectangle extends Shape {

        @Override
        public double area() {
            // TODO Auto-generated method stub
            return 0;
        }

    }

Vamos prosseguir com as seguintes alterações

    package entities;

    import entities.enums.Color;

    public class Rectangle extends Shape {
        
        private Double width;
        private Double height;
        
        public Rectangle() {
            super();
        }
        
        public Rectangle(Color color, Double width, Double height) {
            super(color);
            this.width = width;
            this.height = height;
        }
        
        public Double getWidth() {
            return width;
        }

        public void setWidth(Double width) {
            this.width = width;
        }

        public Double getHeight() {
            return height;
        }

        public void setHeight(Double height) {
            this.height = height;
        }

        @Override
        public double area() {
            return width * height;
        }

    }

Vamos, agora, criar uma outra subclasse Circle. No caso, no diretório entities, vamos criar um arquivo Circle.java e dentro dela vamos fazer o seguinte

    package entities;

    import entities.enums.Color;

    public class Circle extends Shape{
        
        private Double radius;
        
        public Circle() {
            super();
        }
        
        public Circle(Color color, Double radius) {
            super(color);
            this.radius = radius;
        }

        public Double getRadius() {
            return radius;
        }

        public void setRadius(Double radius) {
            this.radius = radius;
        }

        @Override
        public double area() {
            // TODO Auto-generated method stub
            return Math.PI * radius * radius;
        }

    }

Feito as criações acima, vamos agora realizar as alterações no Program.java. No caso, vamos fazer o seguinte

    package application;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.Locale;
    import java.util.Scanner;

    import entities.Circle;
    import entities.Rectangle;
    import entities.Shape;
    import entities.enums.Color;

    public class Program {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            Locale.setDefault(Locale.US);
            Scanner sc = new Scanner(System.in);
            
            // Para o bom proveito do polimorfismo, sempre que vc declarar alguma lista
            // nela se coloca a superclasse
            List<Shape> list = new ArrayList<>();
            
            System.out.print("Enter the number os shapes: ");
            int n = sc.nextInt();
            
            for (int i = 1; i <= n; i++) {
                System.out.println("Shape #" + i + " data:");
                System.out.print("Rectangle or Circle (r/c)? ");
                char ch = sc.next().charAt(0);
                System.out.print("Color (BLACK/BLUE/RED): ");
                Color color = Color.valueOf(sc.next());
                if (ch == 'r') {
                    System.out.print("Width: ");
                    double width = sc.nextDouble();
                    System.out.print("Height: ");
                    double height = sc.nextDouble();
                    list.add(new Rectangle(color, width, height));
                } else {
                    System.out.print("Radius: ");
                    double radius = sc.nextDouble();
                    list.add(new Circle(color, radius));
                }
            }
            
            System.out.println();
            System.out.println("SHAPE AREAS:");
            for (Shape shape : list) {
                System.out.println(String.format("%.2f", shape.area()));
            }
        }

    }

Agora, basta rodar o programa para verificar se está tudo funcionando corretamente.

Seguir as classes "Animal", "Mamifero", "Cachorro" e "TesteAbstrato" do pacote "oo.abstrato" do projeto "exercicios".

## Aula 12 - Exercício de fixação:
Seguir o enunciado

    Fazer um programa para ler os dados de N contribuintes (N fornecido pelo usuário), os quais podem ser pessoa física ou pessoa jurídica, e depois mostrar o valor do imposto pago por cada um, bem como o total de imposto arrecadado. 

    Os dados de pessoa física são: nome, renda anual e gastos com saúde. Os dados de pessoa jurídica são nome, renda anual e número de funcionários. As regras para cálculo de imposto são as 
    seguintes:

    Pessoa física: pessoas cuja renda foi abaixo de 20000.00 pagam 15% de imposto. Pessoas com renda de 20000.00 em diante pagam 25% de imposto. Se a pessoa teve gastos com saúde, 50% destes gastos são abatidos no imposto. 

    Exemplo: uma pessoa cuja renda foi 50000.00 e teve 2000.00 em gastos com saúde, o imposto fica: (50000 * 25%) - (2000 * 50%) = 11500.00

    Pessoa jurídica: pessoas jurídicas pagam 16% de imposto. Porém, se a empresa possuir mais de 10 funcionários, ela paga 14% de imposto.

    Exemplo: uma  empresa  cuja  renda foi 400000.00 e possui 25 funcionários, o imposto fica:
        400000 * 14% = 56000.00

Example

    Enter the number of tax payers: 3
    Tax payer #1 data:
    Individual or company (i/c)? i
    Name: Alex
    Anual income: 50000.00
    Health expenditures: 2000.00
    Tax payer #2 data:
    Individual or company (i/c)? c
    Name: SoftTech
    Anual income: 400000.00
    Number of employees: 25
    Tax payer #3 data:
    Individual or company (i/c)? i
    Name: Bob
    Anual income: 120000.00
    Health expenditures: 1000.00
    TAXES PAID:
    Alex: $ 11500.00
    SoftTech: $ 56000.00
    Bob: $ 29500.00
    TOTAL TAXES: $ 97000.00

## Aula 13 - Correção em vídeo do exercício de fixação:
Olá pessoal!

A correção deste exercício sobre lista foi feita em uma live no Youtube:

    https://www.youtube.com/watch?v=eDsS3JM5iXw

Abraços e até a próxima!


