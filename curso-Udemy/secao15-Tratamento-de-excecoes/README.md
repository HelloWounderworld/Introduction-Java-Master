# Seção 15: Tratamento de exceções/erros:

## Aula 01 - Visão geral do capítulo Tratamento de Exceções e Aula 02 - Material de apoio do capítulo:
MATERIAL DE APOIO DO CAPÍTULO

Seja muito bem-vindo(a) ao capítulo Tratamento de exceções!

Aqui você pode baixar o material de apoio usado nas aulas do capítulo, para que você possa aproveitar ao máximo as aulas sem precisar ficar anotando muito.

Grande abraço e bons estudos! Nelio.

Recursos para esta aula

    09-tratamento-de-excecoes(espaco-para-anotacoes).pdf
    09-tratamento-de-excecoes.pdf

## Aula 03 - Tipos de Erros:
Existem dois tipos de erros:

- O que é identificado pelo compilação:

    Caso aconteça algum erro, a compilação para no meio do processo.

- Erro de tempos de execução:

    Um tipo de erro, quando o seu programa já foi compilado. É um caso em que precisamos implementar o conceito de tratamento de exceção.

### Pilhas e Métodos:
Serve para entender, quando é exibido algum erro, qual é a ordem de interpretação certa que realizamos para conseguirmos tratar o erro e identificar exatamente onde ocorreu.

Ou seja, pilhas de métodos, é uma forma de facilitar em detectar o erro e ver onde exatamente isso aconteceu.

## Aula 04 - Discussão inicial sobre exceções - Basico:
Exceções

- Uma exceção é qualquer condição de erro ou comportamento inesperado encontrado por um programa em execução

- Em Java, uma exceção é um objeto herdado da classe:
    -  java.lang.Exception - o compilador obriga a tratar ou propagar
    -  java.lang.RuntimeException - o compilador não obriga a tratar ou propagar

- Quando lançada, uma exceção é propagada na pilha de chamadas de métodos em execução, até que seja capturada (tratada) ou o programa seja encerrado

Seguir o link de leitura sobre hierarquia de exceções do Java

    https://docs.oracle.com/javase/10/docs/api/java/lang/package-tree.html

Por que exceções?

- O modelo de tratamento de exceções permite que erros sejam tratados de forma consistente e flexível, usando boas práticas

- Vantagens:
    -  Delega a lógica do erro para a classe responsável por conhecer as regras que podem ocasionar o erro

    -  Trata de forma organizada (inclusive hierárquica) exceções de tipos diferentes

    -  A exceção pode carregar dados quaisquer

Seguir as classes "Basico" e "Aluno" do pacote "excecao" do projeto "exercicios". 

## Aula 05 - Estrutura try-catch:
Estrutura try-catch:

- Bloco try
    - Contém o código que representa a execução normal do trecho de código que podeacarretar em uma exceção

- Bloco catch
    - Contém o código a ser executado caso uma exceção ocorra

    - Deve ser especificado o tipo da exceção a ser tratada (upcasting é permitido)

Sintaxe

    try {
    }
    catch (ExceptionType e) {
    }
    catch (ExceptionType e) {
    }
    catch (ExceptionType e) {
    }

A forma de uso é análoga com o que foi estudado em JavaScript. A única excessão, imagino eu, que em JavaScript vc usa, geralmente, apenas um catch, enquanto que em Java vc pode usar ela quantas vezes que quiser.

Bom, vale a leitura de try/catch que eu estudei no meu repositório github para o curso de JavaScript que realizei.

Por hora, vamos apenas ir revisando e vendo a sua forma de uso.

Criamos, para isso, um novo projeto com o nome "excession". Daí, dentro dela, vamos colocar, dentro da pasta src, os diretórios application e dentro desse diretório o arquivo Program.java e, dentro desse arquivo, vamos fazer o seguinte

    package excession;

    import java.util.Scanner;

    public class Program {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            Scanner sc = new Scanner(System.in);
            
            String[] vect = sc.nextLine().split(" ");
            int position = sc.nextInt();
            System.out.println(vect[position]);
            
            
            sc.close();
        }

    }

Bom, o que quero realizar de experimento acima, é tratando quando eu coloco uma posição que não existe na lista. Quando rodo dessa forma no console, ele exibirá um erro, que retrata exatamente algum caso de excessão. Assim, o que quero realizar é o seguinte, capturar essa msg de erro e tratar ela

    package excession;

    import java.util.Scanner;

    public class Program {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            Scanner sc = new Scanner(System.in);
            
            try {
            String[] vect = sc.nextLine().split(" ");
            int position = sc.nextInt();
            System.out.println(vect[position]);
            }
            catch(ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid position!");
            }
            
            System.out.println("End of program");
            
            sc.close();
        }

    }

É importante lembrar que esse tipo tratamento serve para que algum erro de excessão ele não pare o funcionamento do sistema.

Note que, dentro do catch é colocado o tipo de erro, como podemos ver

    package excession;

    import java.util.InputMismatchException;
    import java.util.Scanner;

    public class Program {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            Scanner sc = new Scanner(System.in);
            
            try {
            String[] vect = sc.nextLine().split(" ");
            int position = sc.nextInt();
            System.out.println(vect[position]);
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid position!");
            }
            catch (InputMismatchException e) {
                System.out.println("Input error!");
            }
            
            System.out.println("End of program");
            
            sc.close();
        }

    }

Bom, uma das perguntas que pode ser feitas para o uso do try/catch seria o motivo do por quê não podemos usar o if no lugar deles para tratar? Bom, de fato, a resposta disso foi respondido no meu estudo de JavaScript, basta dar uma lida.

Para melhor entendimento do conceito, seguir o seguinte link

    https://stackoverflow.com/questions/651619/what-is-the-advantage-of-using-try-catch-versus-if-else#:~:text=In%20general%2C%20try%2Dcatch%20blocks,when%20an%20error%20is%20hit.

## Aula 06 - Pilha de chamadas de métodos (stack trace):
Vamos continuar a trabalhar em cima do mesmo projeto, excession.

Bom, vamos criar um método colocando tudo o que foi usado no try catch. Logo, no arquivo Program.java ficaria da seguinte forma

    package excession;

    import java.util.InputMismatchException;
    import java.util.Scanner;

    public class Program {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            
            method2();
            
            System.out.println("End of program");
            
        }
        
        public static void method2() {
            Scanner sc = new Scanner(System.in);
            
            try {
            String[] vect = sc.nextLine().split(" ");
            int position = sc.nextInt();
            System.out.println(vect[position]);
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid position!");
            }
            catch (InputMismatchException e) {
                System.out.println("Input error!");
            }
            
            sc.close();
        }

    }

Vamos testar se tudo está funcionando corretamente.

Visto que está funcionando, irei realizar as seguintes marcações dos métodos

    package excession;

    import java.util.InputMismatchException;
    import java.util.Scanner;

    public class Program {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            
            method2();
            
            System.out.println("End of program");
            
        }
        
        public static void method2() {
            System.out.println("*****METHOD2 START*****");
            Scanner sc = new Scanner(System.in);
            
            try {
            String[] vect = sc.nextLine().split(" ");
            int position = sc.nextInt();
            System.out.println(vect[position]);
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid position!");
            }
            catch (InputMismatchException e) {
                System.out.println("Input error!");
            }
            
            sc.close();
            System.out.println("*****METHOD2 END*****");
        }

    }

Visto que a marcação acima está sendo exibida corretamente na execução do programa. Em seguida, vamos criar mais métodos à respeito disso

    package excession;

    import java.util.InputMismatchException;
    import java.util.Scanner;

    public class Program {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            
            //method2();
            method1();
            
            System.out.println("End of program");
            
        }
        
        public static void method1() {
            System.out.println("*****METHOD1 START*****");
            method2();
            System.out.println("*****METHOD1 END*****");
        }
        
        public static void method2() {
            System.out.println("*****METHOD2 START*****");
            Scanner sc = new Scanner(System.in);
            
            try {
            String[] vect = sc.nextLine().split(" ");
            int position = sc.nextInt();
            System.out.println(vect[position]);
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid position!");
            }
            catch (InputMismatchException e) {
                System.out.println("Input error!");
            }
            
            sc.close();
            System.out.println("*****METHOD2 END*****");
        }

    }

Daí, vamos ver se está rodando tudo corretamente.

Visto que está tudo funcionando corretamente, vamos gerar um erro, então. Ou seja, ao rodar o programa vamos colocar uma posição que não existe. Assim, visto que o erro foi exibido com sucesso, então vamos colocar o seguinte código e.printStackTrace(); da seguinte forma

    package excession;

    import java.util.InputMismatchException;
    import java.util.Scanner;

    public class Program {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            
            //method2();
            method1();
            
            System.out.println("End of program");
            
        }
        
        public static void method1() {
            System.out.println("*****METHOD1 START*****");
            method2();
            System.out.println("*****METHOD1 END*****");
        }
        
        public static void method2() {
            System.out.println("*****METHOD2 START*****");
            Scanner sc = new Scanner(System.in);
            
            try {
            String[] vect = sc.nextLine().split(" ");
            int position = sc.nextInt();
            System.out.println(vect[position]);
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid position!");
                e.printStackTrace();
                sc.next();
            }
            catch (InputMismatchException e) {
                System.out.println("Input error!");
            }
            
            sc.close();
            System.out.println("*****METHOD2 END*****");
        }

    }

Vamos, novamente, simular o mesmo erro para ver o que está acontecendo. Note que, desta vez, foi exibido um erro, exatamente como um sistema exibiria pelo console, só que, a única diferença, é que o sistema não parou de funcionar. Ele continou seguindo o fluxo. Além de que, o StackTrace ele chamará todos os métodos que estavam envolvidos no processo para tratá-la.

## Aula 07 - Bloco finally:
Bom, o bloco finally, já estudei pelo JavaScript.

Aqui no Java, a lógica de funcionalidade é a mesma.

Bloco finally

- É um bloco que contém código a ser executado independentemente de ter ocorrido ou não uma exceção. 

- Exemplo clássico: fechar um arquivo, conexão de banco de dados, ou outro recurso específico ao final do processamento.

Sintaxe:
    try {
    }
    catch (ExceptionType e) {
    }
    finally {
    }

Seguir o código que realiza o experimento disso

    package application;

    import java.io.File;
    import java.io.IOException;
    import java.util.Scanner;

    public class Program {
        public static void main(String[] args) {
            File file = new File("C:\\temp\\in.txt");
            Scanner sc = null;
            try {
                sc = new Scanner(file);
                while (sc.hasNextLine()) {
                    System.out.println(sc.nextLine());
                }
            } 
            catch (IOException e) {
                System.out.println("Error opening file: " + e.getMessage());
            } 
            finally {
                if (sc != null) {
                    sc.close();
                }
                System.out.println("Finally block executed");
            }
        }
    }

## Aula 08 - Criando exceções personalizadas:
Vamos aprender a criar exceções personalizadas.

Antes disso, sugerimos o uso de pacotes model

    https://www.edureka.co/blog/mvc-architecture-in-java/#:~:text=In%20the%20MVC%20design%20pattern,the%20model%20in%20a%20database.

Seguir o enunciado

    Fazer um programa para ler os dados de uma reserva de hotel (número do quarto, data de entrada e data de saída) e mostrar os dados da reserva, inclusive sua duração em dias. Em seguida, ler novas datas de entrada e saída, atualizar a reserva, e mostrar novamente a reserva com os dados atualizados. O programa não deve aceitar dados inválidos para a reserva, conforme as seguintes regras:

    - Alterações de reserva só podem ocorrer para datas futuras

    - A data de saída deve ser maior que a data de entrada

Examples

    Room number: 8021
    Check-in date (dd/MM/yyyy): 23/09/2019
    Check-out date (dd/MM/yyyy): 26/09/2019
    Reservation: Room 8021, check-in: 23/09/2019, check-out: 26/09/2019, 3 nights

    Enter data to update the reservation:
    Check-in date (dd/MM/yyyy): 24/09/2019
    Check-out date (dd/MM/yyyy): 29/09/2019
    Reservation: Room 8021, check-in: 24/09/2019, check-out: 29/09/2019, 5 nights

    Room number: 8021
    Check-in date (dd/MM/yyyy): 23/09/2019
    Check-out date (dd/MM/yyyy): 21/09/2019
    Error in reservation: Check-out date must be after check-in date

Examples

    Room number: 8021
    Check-in date (dd/MM/yyyy): 23/09/2019
    Check-out date (dd/MM/yyyy): 26/09/2019
    Reservation: Room 8021, check-in: 23/09/2019, check-out: 26/09/2019, 3 nights

    Enter data to update the reservation:
    Check-in date (dd/MM/yyyy): 24/09/2015
    Check-out date (dd/MM/yyyy): 29/09/2015
    Error in reservation: Reservation dates for update must be future dates

    Room number: 8021
    Check-in date (dd/MM/yyyy): 23/09/2019
    Check-out date (dd/MM/yyyy): 26/09/2019
    Reservation: Room 8021, check-in: 23/09/2019, check-out: 26/09/2019, 3 nights

    Enter data to update the reservation:
    Check-in date (dd/MM/yyyy): 24/09/2020
    Check-out date (dd/MM/yyyy): 22/09/2020
    Error in reservation: Check-out date must be after check-in date

Resumo da aula

- Solução 1 (muito ruim): lógica de validação no programa principal
    - Lógica de validação não delegada à reserva

- Solução 2 (ruim): método retornando string- A semântica da operação é prejudicada- Retornar string não tem nada a ver com atualização de reserva
    - E se a operação tivesse que retornar um string?
    - Ainda não é possível tratar exceções em construtores
    - Ainda não há auxílio do compilador: o programador deve "lembrar" de verificar se houve erro
    - A lógica fica estruturada em condicionais aninhadas

- Solução 3 (boa): tratamento de exceções

Seguir o link da resolução

    https://github.com/acenelio/exceptions1-java

Só vamos deixar preparado os ambientes.

## Aula 09 - Primeira solução - muito ruim:
Bom, vamos começando com a seguinte modificação

Seguir o link de leitura para enteder melhor o throws exception

    https://rollbar.com/blog/how-to-use-the-throws-keyword-in-java-and-when-to-use-throw/#:~:text=The%20throws%20keyword%20in%20Java%20is%20used%20to%20declare%20exceptions,exceptions%20that%20can%20be%20thrown.

No arquivo Program.java vamos colocar o seguinte

    package application;

    import java.text.ParseException;
    import java.text.SimpleDateFormat;
    import java.util.Date;
    import java.util.Scanner;

    import model.entities.Reservation;

    public class Program {

        public static void main(String[] args) throws ParseException {
            // TODO Auto-generated method stub
            Scanner sc = new Scanner(System.in);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            System.out.print("Room Number: ");
            int number = sc.nextInt();
            System.out.print("Check-in date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(sc.next());
            
            // Legal que em date tem essa função que já calcula se está depois ou antes da data
            if(!checkOut.after(checkIn)) {
                System.out.println("Error in reservation: Check-out date must be after check-in date");
            } else {
                Reservation reservation = new Reservation(number, checkIn, checkOut);
                System.out.println(reservation.toString());
                
                System.out.println();
                System.out.println("Enter data to update the reservation:");
                System.out.print("Check-in date (dd/MM/yyyy): ");
                checkIn = sdf.parse(sc.next());
                System.out.print("Check-out date (dd/MM/yyyy): ");
                checkOut = sdf.parse(sc.next());
                
                // Solução péssimo
                // Mother of God... This is worst...
                Date now = new Date();
                if (checkIn.before(now) || checkOut.before(now)) {
                    System.out.println("Error in reservation: Check-out date must be after check-in date");
                }
                else if(!checkOut.after(checkIn)) {
                    System.out.println("Error in reservation: Check-out date must be after check-in date");
                }
                else {
                    reservation.updateDates(checkIn, checkOut);
                    System.out.println("Reservation: " + reservation);
                }
            }
            
            sc.close();
        }

    }

Bom, note que, aqui na solução péssima acima, tratamos as excessões usando loucamente if, else if e else, o que é péssimo, pois fica ruim no ponto de vista da interpretação do código, ruim no sentido de eficiência e péssimo no quesito de contar outras possibilidades do que poderia acontecer e não cobrir nenhuma delas. Além disso, o sistema pode parar caso algum erro aconteça.

## Aula 10 - Segunda solução - ruim:
Bom, a péssima solução da aula anterior estava no problema de lógica de validação no programa principal. Algo que deveria estar presente nas classes.

Vamos corrigir esse problema, mas ainda sim o código ao todo estará ruim, pois teremos problemas do método retornando string.

No caso, no arquivo Reservation.java vamos realizar o seguinte, no método updateDates

    package model.entities;

    import java.text.SimpleDateFormat;
    import java.util.Date;
    import java.util.concurrent.TimeUnit;

    public class Reservation {
        
        private Integer roomNumber;
        private Date checkIn;
        private Date checkOut;
        
        private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        
        public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
            this.roomNumber = roomNumber;
            this.checkIn = checkIn;
            this.checkOut = checkOut;
        }

        public Integer getRoomNumber() {
            return roomNumber;
        }

        public void setRoomNumber(Integer roomNumber) {
            this.roomNumber = roomNumber;
        }

        public Date getCheckIn() {
            return checkIn;
        }

        public Date getCheckOut() {
            return checkOut;
        }
        
        public long duration() {
            long diff = checkOut.getTime() - checkIn.getTime();
            return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        }
        
        public String updateDates(Date checkIn, Date checkOut) {
            
            Date now = new Date();
            if (checkIn.before(now) || checkOut.before(now)) {
                return "Check-out date must be after check-in date";
            }
            if(!checkOut.after(checkIn)) {
                return "Check-out date must be after check-in date";
            }
            
            this.checkIn = checkIn;
            this.checkOut = checkOut;
            return null;
        }
        
        @Override
        public String toString() {
            return "Room" + roomNumber + ", check-in: " + sdf.format(checkIn) + ", check-out: " + sdf.format(checkOut) + ", " + duration() + " nights";
        }
    }

Agora, no arquivo Program.java vamos realizar o seguinte

    package application;

    import java.text.ParseException;
    import java.text.SimpleDateFormat;
    import java.util.Date;
    import java.util.Scanner;

    import model.entities.Reservation;

    public class Program {

        public static void main(String[] args) throws ParseException {
            // TODO Auto-generated method stub
            Scanner sc = new Scanner(System.in);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            System.out.print("Room Number: ");
            int number = sc.nextInt();
            System.out.print("Check-in date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(sc.next());
            
            // Legal que em date tem essa função que já calcula se está depois ou antes da data
            if(!checkOut.after(checkIn)) {
                System.out.println("Error in reservation: Check-out date must be after check-in date");
            } else {
                Reservation reservation = new Reservation(number, checkIn, checkOut);
                System.out.println(reservation.toString());
                
                System.out.println();
                System.out.println("Enter data to update the reservation:");
                System.out.print("Check-in date (dd/MM/yyyy): ");
                checkIn = sdf.parse(sc.next());
                System.out.print("Check-out date (dd/MM/yyyy): ");
                checkOut = sdf.parse(sc.next());
                
                // Solução ruim
                // Mother of God... This is bad...
                String error = reservation.updateDates(checkIn, checkOut);
                if (error != null) {
                    System.out.println("Error in reservation: " + error);
                } else {
                    System.out.println("Reservation: " + reservation);
                }
            }
            
            sc.close();
        }

    }

Bom, no formato acima, já ficou melhor, pois colocamos as condicionais nos métodos das classes.

Entretanto, ainda sim podemos melhorar a solução, pois seria usando o tratamento de exceções.

Resforçando aqui, vale a pena dar uma lida reforçada entre quando usamos as condicionais e o try/catch para tratamento de erros.

## Aula 11 - Terceira solução - boa:
Agora, vamos ver a solução boa, donde, desta vez, é codando de forma que tratamos as exceções.

No caso, a última melhoria que fizemos é enviar as condicionais nas classes, de forma, que o código de aplicação torne-a muito mais simples de ler.

Agora, a mudança que iremos fazer é algo bem mais geral, pois ainda, sim, o formato como foi feito a melhoria ainda está precária e com o risco de o sistema parar caso dê algum erro, visto que ela não cobre todas as exceções possíveis.

Bom, para começar, no arquivo Program.java vamos fazer o seguinte

    package application;

    import java.text.ParseException;
    import java.text.SimpleDateFormat;
    import java.util.Date;
    import java.util.Scanner;

    import model.entities.Reservation;

    public class Program {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            Scanner sc = new Scanner(System.in);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            try {
                System.out.print("Room Number: ");
                int number = sc.nextInt();
                System.out.print("Check-in date (dd/MM/yyyy): ");
                Date checkIn = sdf.parse(sc.next());
                System.out.print("Check-out date (dd/MM/yyyy): ");
                Date checkOut = sdf.parse(sc.next());
                
                Reservation reservation = new Reservation(number, checkIn, checkOut);
                System.out.println(reservation.toString());
                
                System.out.println();
                System.out.println("Enter data to update the reservation:");
                System.out.print("Check-in date (dd/MM/yyyy): ");
                checkIn = sdf.parse(sc.next());
                System.out.print("Check-out date (dd/MM/yyyy): ");
                checkOut = sdf.parse(sc.next());
                
                reservation.updateDates(checkIn, checkOut);
                System.out.println("Reservation: " + reservation);
            }
            catch (ParseException e) {
                System.out.println("Invalid date Format");
            }
            
            sc.close();
        }

    }

Agora, no arquivo Reservation.java vamos fazer o seguinte, usaremos o throw, ou seja, lançaremos apenas a informação do erro, isso aplicado no método updateDate

     package model.entities;

    import java.text.SimpleDateFormat;
    import java.util.Date;
    import java.util.concurrent.TimeUnit;

    public class Reservation {
        
        private Integer roomNumber;
        private Date checkIn;
        private Date checkOut;
        
        private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        
        public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
            this.roomNumber = roomNumber;
            this.checkIn = checkIn;
            this.checkOut = checkOut;
        }

        public Integer getRoomNumber() {
            return roomNumber;
        }

        public void setRoomNumber(Integer roomNumber) {
            this.roomNumber = roomNumber;
        }

        public Date getCheckIn() {
            return checkIn;
        }

        public Date getCheckOut() {
            return checkOut;
        }
        
        public long duration() {
            long diff = checkOut.getTime() - checkIn.getTime();
            return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        }
        
        public void updateDates(Date checkIn, Date checkOut) {
            
            Date now = new Date();
            if (checkIn.before(now) || checkOut.before(now)) {
                throw new IllegalArgumentException("Check-out date must be after check-in date");
            }
            if(!checkOut.after(checkIn)) {
                throw new IllegalArgumentException("Check-out date must be after check-in date");
            }
            
            this.checkIn = checkIn;
            this.checkOut = checkOut;
        }
        
        @Override
        public String toString() {
            return "Room" + roomNumber + ", check-in: " + sdf.format(checkIn) + ", check-out: " + sdf.format(checkOut) + ", " + duration() + " nights";
        }
    }

Agora, no Program.java, precisamos capturar essa msg de erro lançada tbm. No caso, vamos ter que criar mais um catch da seguinte forma

    package application;

    import java.text.ParseException;
    import java.text.SimpleDateFormat;
    import java.util.Date;
    import java.util.Scanner;

    import model.entities.Reservation;

    public class Program {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            Scanner sc = new Scanner(System.in);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            try {
                System.out.print("Room Number: ");
                int number = sc.nextInt();
                System.out.print("Check-in date (dd/MM/yyyy): ");
                Date checkIn = sdf.parse(sc.next());
                System.out.print("Check-out date (dd/MM/yyyy): ");
                Date checkOut = sdf.parse(sc.next());
                
                Reservation reservation = new Reservation(number, checkIn, checkOut);
                System.out.println(reservation.toString());
                
                System.out.println();
                System.out.println("Enter data to update the reservation:");
                System.out.print("Check-in date (dd/MM/yyyy): ");
                checkIn = sdf.parse(sc.next());
                System.out.print("Check-out date (dd/MM/yyyy): ");
                checkOut = sdf.parse(sc.next());
                
                reservation.updateDates(checkIn, checkOut);
                System.out.println("Reservation: " + reservation);
            }
            catch (ParseException e) {
                System.out.println("Invalid date Format");
            }
            catch (IllegalArgumentException e) {
                System.out.println("Error in reservation: " + e.getMessage());
            }
            
            sc.close();
        }

    }

Agora, basta testarmos e vamos ver que está tudo funcionando como deveria tornando o código bem mais limpo para leitura e conseguindo dar conta de tratamento de todos os erros.

Bom, para melhorarmos mais ainda a arquitetura do sistema, vamos usar os conceitos de model para melhorar a organização.

Criamos o seguinte diretório dentro do src, uma classe model.exceptions com o arquivo DomainException.java e, dentro dela colocamos o seguinte

    package model.exceptions;

    public class DomainException extends Exception {
        private static final long serialVersionUID = 1L;
        
        public DomainException (String msg) {
            super(msg);
        }
    }

No caso, agora, no arquivo Reservation vamos alterar o erro lançado pelo throw que está escrito IllegalArgumentException para DomainException. Ou seja, estamos criando uma forma de captura de erro personalizado

Obs: Note que, o Exception não temos a classe dela no projeto e mesmo assim criamos uma subclasse para isso.

    package model.entities;

    import java.text.SimpleDateFormat;
    import java.util.Date;
    import java.util.concurrent.TimeUnit;

    import model.exceptions.DomainException;

    public class Reservation {
        
        private Integer roomNumber;
        private Date checkIn;
        private Date checkOut;
        
        private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        
        public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
            this.roomNumber = roomNumber;
            this.checkIn = checkIn;
            this.checkOut = checkOut;
        }

        public Integer getRoomNumber() {
            return roomNumber;
        }

        public void setRoomNumber(Integer roomNumber) {
            this.roomNumber = roomNumber;
        }

        public Date getCheckIn() {
            return checkIn;
        }

        public Date getCheckOut() {
            return checkOut;
        }
        
        public long duration() {
            long diff = checkOut.getTime() - checkIn.getTime();
            return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        }
        
        public void updateDates(Date checkIn, Date checkOut) {
            
            Date now = new Date();
            if (checkIn.before(now) || checkOut.before(now)) {
                throw new DomainException("Check-out date must be after check-in date");
            }
            if(!checkOut.after(checkIn)) {
                throw new DomainException("Check-out date must be after check-in date");
            }
            
            this.checkIn = checkIn;
            this.checkOut = checkOut;
        }
        
        @Override
        public String toString() {
            return "Room" + roomNumber + ", check-in: " + sdf.format(checkIn) + ", check-out: " + sdf.format(checkOut) + ", " + duration() + " nights";
        }
    }

No caso, irá aparecer um erro no throw dizendo que ou vc trata essa exceção ou vc propaga. Para isso, iremos propagar, pois o tratamento dessa exceção deverá ser feito no catch da aplicação

    package model.entities;

    import java.text.SimpleDateFormat;
    import java.util.Date;
    import java.util.concurrent.TimeUnit;

    import model.exceptions.DomainException;

    public class Reservation {
        
        private Integer roomNumber;
        private Date checkIn;
        private Date checkOut;
        
        private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        
        public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
            this.roomNumber = roomNumber;
            this.checkIn = checkIn;
            this.checkOut = checkOut;
        }

        public Integer getRoomNumber() {
            return roomNumber;
        }

        public void setRoomNumber(Integer roomNumber) {
            this.roomNumber = roomNumber;
        }

        public Date getCheckIn() {
            return checkIn;
        }

        public Date getCheckOut() {
            return checkOut;
        }
        
        public long duration() {
            long diff = checkOut.getTime() - checkIn.getTime();
            return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        }
        
        public void updateDates(Date checkIn, Date checkOut) throws DomainException {
            
            Date now = new Date();
            if (checkIn.before(now) || checkOut.before(now)) {
                throw new DomainException("Check-out date must be after check-in date");
            }
            if(!checkOut.after(checkIn)) {
                throw new DomainException("Check-out date must be after check-in date");
            }
            
            this.checkIn = checkIn;
            this.checkOut = checkOut;
        }
        
        @Override
        public String toString() {
            return "Room" + roomNumber + ", check-in: " + sdf.format(checkIn) + ", check-out: " + sdf.format(checkOut) + ", " + duration() + " nights";
        }
    }

Agora, no Program.java basta mudarmos o IllegalArgumentException para DomainException

    package application;

    import java.text.ParseException;
    import java.text.SimpleDateFormat;
    import java.util.Date;
    import java.util.Scanner;

    import model.entities.Reservation;
    import model.exceptions.DomainException;

    public class Program {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            Scanner sc = new Scanner(System.in);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            try {
                System.out.print("Room Number: ");
                int number = sc.nextInt();
                System.out.print("Check-in date (dd/MM/yyyy): ");
                Date checkIn = sdf.parse(sc.next());
                System.out.print("Check-out date (dd/MM/yyyy): ");
                Date checkOut = sdf.parse(sc.next());
                
                Reservation reservation = new Reservation(number, checkIn, checkOut);
                System.out.println(reservation.toString());
                
                System.out.println();
                System.out.println("Enter data to update the reservation:");
                System.out.print("Check-in date (dd/MM/yyyy): ");
                checkIn = sdf.parse(sc.next());
                System.out.print("Check-out date (dd/MM/yyyy): ");
                checkOut = sdf.parse(sc.next());
                
                reservation.updateDates(checkIn, checkOut);
                System.out.println("Reservation: " + reservation);
            }
            catch (ParseException e) {
                System.out.println("Invalid date Format");
            }
            catch (DomainException e) {
                System.out.println("Error in reservation: " + e.getMessage());
            }
            
            sc.close();
        }

    }

Feito isso, vamos testar o programa para ver se ele está funcionando.

Bom, visto que está tudo funcionando, note que, agora, o nosso código ficou bem, mais bem, organizados.

Bom, para melhorar mais ainda alguns detalhes, no método updateDate, onde consta o tratamento condicional para verificar se a data está antes ou depois, podemos mandar essa condicional, em vez dentro desse método, no construtor. Essa prática é conhecida como "Programação Defensiva" que é uma boa prática para melhorar a segurança do teu sistema

    package model.entities;

    import java.text.SimpleDateFormat;
    import java.util.Date;
    import java.util.concurrent.TimeUnit;

    import model.exceptions.DomainException;

    public class Reservation {
        
        private Integer roomNumber;
        private Date checkIn;
        private Date checkOut;
        
        private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        
        public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
            if(!checkOut.after(checkIn)) {
                throw new DomainException("Check-out date must be after check-in date");
            }
            this.roomNumber = roomNumber;
            this.checkIn = checkIn;
            this.checkOut = checkOut;
        }

        public Integer getRoomNumber() {
            return roomNumber;
        }

        public void setRoomNumber(Integer roomNumber) {
            this.roomNumber = roomNumber;
        }

        public Date getCheckIn() {
            return checkIn;
        }

        public Date getCheckOut() {
            return checkOut;
        }
        
        public long duration() {
            long diff = checkOut.getTime() - checkIn.getTime();
            return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        }
        
        public void updateDates(Date checkIn, Date checkOut) throws DomainException {
            
            Date now = new Date();
            if (checkIn.before(now) || checkOut.before(now)) {
                throw new DomainException("Check-out date must be after check-in date");
            }
            
            this.checkIn = checkIn;
            this.checkOut = checkOut;
        }
        
        @Override
        public String toString() {
            return "Room" + roomNumber + ", check-in: " + sdf.format(checkIn) + ", check-out: " + sdf.format(checkOut) + ", " + duration() + " nights";
        }
    }

Agora, sim, o sistema ficou bem melhor.

Agora, para acrescentar, vamos mudar, na classe DomainException, o extends Exception para extends RuntimeException

    package model.exceptions;

    public class DomainException extends RuntimeException {
        private static final long serialVersionUID = 1L;
        
        public DomainException (String msg) {
            super(msg);
        }
    }

O que isso nos permite fazer?

Apagar o throws DomainExceptions que colocamos para propagar o erro na classe Reservation.java

    package model.entities;

    import java.text.SimpleDateFormat;
    import java.util.Date;
    import java.util.concurrent.TimeUnit;

    import model.exceptions.DomainException;

    public class Reservation {
        
        private Integer roomNumber;
        private Date checkIn;
        private Date checkOut;
        
        private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        
        public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
            if(!checkOut.after(checkIn)) {
                throw new DomainException("Check-out date must be after check-in date");
            }
            this.roomNumber = roomNumber;
            this.checkIn = checkIn;
            this.checkOut = checkOut;
        }

        public Integer getRoomNumber() {
            return roomNumber;
        }

        public void setRoomNumber(Integer roomNumber) {
            this.roomNumber = roomNumber;
        }

        public Date getCheckIn() {
            return checkIn;
        }

        public Date getCheckOut() {
            return checkOut;
        }
        
        public long duration() {
            long diff = checkOut.getTime() - checkIn.getTime();
            return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        }
        
        public void updateDates(Date checkIn, Date checkOut) {
            
            Date now = new Date();
            if (checkIn.before(now) || checkOut.before(now)) {
                throw new DomainException("Check-out date must be after check-in date");
            }
            
            this.checkIn = checkIn;
            this.checkOut = checkOut;
        }
        
        @Override
        public String toString() {
            return "Room" + roomNumber + ", check-in: " + sdf.format(checkIn) + ", check-out: " + sdf.format(checkOut) + ", " + duration() + " nights";
        }
    }

Agora, para completar, no Program.java, existe uma exceção que não conseguimos tratar que é o InputMismatchException. No caso, podemos realizar a seguinte complementação colocando mais um catch e nela colocar RuntimeException. Isso significa que se não aparecer nenhum outro erro acima, mas mesmo assim, estar dando erro, será tratado dentro desse catch que captura o RuntimeException

    package application;

    import java.text.ParseException;
    import java.text.SimpleDateFormat;
    import java.util.Date;
    import java.util.Scanner;

    import model.entities.Reservation;
    import model.exceptions.DomainException;

    public class Program {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            Scanner sc = new Scanner(System.in);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            try {
                System.out.print("Room Number: ");
                int number = sc.nextInt();
                System.out.print("Check-in date (dd/MM/yyyy): ");
                Date checkIn = sdf.parse(sc.next());
                System.out.print("Check-out date (dd/MM/yyyy): ");
                Date checkOut = sdf.parse(sc.next());
                
                Reservation reservation = new Reservation(number, checkIn, checkOut);
                System.out.println(reservation.toString());
                
                System.out.println();
                System.out.println("Enter data to update the reservation:");
                System.out.print("Check-in date (dd/MM/yyyy): ");
                checkIn = sdf.parse(sc.next());
                System.out.print("Check-out date (dd/MM/yyyy): ");
                checkOut = sdf.parse(sc.next());
                
                reservation.updateDates(checkIn, checkOut);
                System.out.println("Reservation: " + reservation);
            }
            catch (ParseException e) {
                System.out.println("Invalid date Format");
            }
            catch (DomainException e) {
                System.out.println("Error in reservation: " + e.getMessage());
            }
            catch (RuntimeException e) {
                System.out.println("Unexpected error");
            }
            
            sc.close();
        }

    }

Resumo da aula

- Cláusula throws: propaga a exceção ao invés de trata-la

- Cláusula throw: lança a exceção / "corta" o método

- Exception: compilador obriga a tratar ou propagar

- RuntimeException: compilador não obriga

- O modelo de tratamento de exceções permite que erros sejam tratados de forma consistente e flexível, usando boas práticas

- Vantagens:
    - Lógica delegada

    - Construtores podem ter tratamento de exceções

    - Possibilidade de auxílio do compilador (Exception)

    - Código mais simples. Não há aninhamento de condicionais: a qualquer momento que uma exceção for disparada, a execução é interrompida e cai no bloco catch correspondente.
    
    - É possível capturar inclusive outras exceções de sistema


## Aula 12 - Exercício de fixação:
Seguir o enunciado

    Fazer um programa para ler os dados de uma conta bancária e depois realizar um saque nesta conta bancária, mostrando o novo saldo. Um saque não pode ocorrer ou se não houver saldo na conta, ou se o valor do saque for superior ao limite de saque da conta. Implemente a conta bancária conforme projeto abaixo:

Examples

    Enter account data
    Number: 8021
    Holder: Bob Brown
    Initial balance: 500.00
    Withdraw limit: 300.00
    Enter amount for withdraw: 100.00
    New balance: 400.00

    Enter account data
    Number: 8021
    Holder: Bob Brown
    Initial balance: 500.00
    Withdraw limit: 300.00
    Enter amount for withdraw: 400.00
    Withdraw error: The amount exceeds withdraw limit

Examples

    Enter account data
    Number: 8021
    Holder: Bob Brown
    Initial balance: 500.00
    Withdraw limit: 300.00
    Enter amount for withdraw: 800.00
    Withdraw error: The amount exceeds withdraw limit

    Enter account data
    Number: 8021
    Holder: Bob Brown
    Initial balance: 200.00
    Withdraw limit: 300.00
    Enter amount for withdraw: 250.00
    Withdraw error: Not enough balance

Seguir o link de resolução do professor

    https://github.com/acenelio/exceptions2-java

## Aula 13 - Correção do exercício de fixação:
Olá pessoal! A correção deste exercício foi feita em uma live no Youtube:

https://www.youtube.com/watch?v=AiIuJqJ0r8A

Abraços e até a próxima!
