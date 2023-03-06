# Seção 11: Tópicos Especiais em Java - data hora:

## Aula 01 - Boas-vindas e avisos e Aula 02 - Material de apoio do capítulo:
MATERIAL DE APOIO DO CAPÍTULO

Seja muito bem-vindo(a) ao capítulo Tópicos especiais em Java!

Aqui você pode baixar o material de apoio usado nas aulas do capítulo, para que você possa aproveitar ao máximo as aulas sem precisar ficar anotando muito.

Grande abraço e bons estudos! Nelio.

Recursos para esta aula

    date-calendar.pdf
    trabalhando-com-data-hora.pdf

## Aula 03 - Introdução a data-hora e duração:
Bom, o uso de data é abem análogo com que é visto em JavaScript.

Seguir o link de leitura

    https://docs.oracle.com/javase/10/docs/api/java/text/SimpleDateFormat.html

Quando usar?

- Data-[hora] local: 

    Quando o momento exato não interessa a pessoas de outro fuso horário.
    Uso comum: sistemas de região única, Excel.

        Data de nascimento: "15/06/2001"
        Data-hora da venda: "13/08/2022 às 15:32" (presumindo não interessar fuso horário)

- Data-hora global: 

    Quando o momento exato interessa a pessoas de outro fuso horário.
    Uso comum: sistemas multi-região, web.

        Quando será o sorteio? "21/08/2022 às 20h (horário de São Paulo)"
        Quando o comentário foi postado? "há 17 minutos"
        Quando foi realizada a venda? "13/08/2022 às 15:32 (horário de São Paulo)"
        Início e fim do evento? "21/08/2022 às 14h até 16h (horário de São Paulo)"

## Aula 04 - Entendendo timezone (fuso horário):
Timezone(fuso horário)

- GMT -Greenwich MeanTime

- Horário de Londres

- Horário do padrão UTC -CoordinatedUniversal Time

- Também chamado de "Z" time, ou Zulu time

- Outros fuso horários são relativos ao GMT/UTC:

    - São Paulo: GMT-3
    - Manaus: GMT-4
    - Portugal: GMT+1
    - Muitas linguagens/tecnologias usam nomes para as timezones:
    - "US/Pacific"
    - "America/Sao_Paulo"
    - etc.

## Aula 05 - Padrão ISO 8601:
Padrão ISO 8601

- Data-[hora] local:

    2022-07-21
    2022-07-21T14:52
    2022-07-22T14:52:09
    2022-07-22T14:52:09.4073

- Data-hora global:

    2022-07-23T14:52:09Z
    2022-07-23T14:52:09.254935Z
    2022-07-23T14:52:09-03:00

## Aula 06 - Operações importantes com data-hora:
Operações importantes com data-hora

-Instanciação

    - (agora) ➞Data-hora
    - Texto ISO 8601 ➞Data-hora
    - Texto formato customizado ➞Data-hora
    - dia, mês, ano, [horário] ➞Data-hora local
-Formatação

    - Data-hora ➞Texto ISO 8601
    - Data-hora ➞Texto formato customizado

## Aula 07 - Instanciando data-hora em Java:
Seguir o link de demonstração

    https://github.com/devsuperior/date-time-java

Vamos ver como instanciar o Data-hora local e Data-hora global

    package app;

    import java.time.Instant;
    import java.time.LocalDate;
    import java.time.LocalDateTime;
    import java.time.format.DateTimeFormatter;

    public class Program1 {

        public static void main(String[] args) {

            // https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/format/DateTimeFormatter.html
            DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DateTimeFormatter fmt2 =  DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            
            LocalDate d01 = LocalDate.now();
            LocalDateTime d02 = LocalDateTime.now();
            // Data hora global - Londres
            Instant d03 = Instant.now();
            
            // LocalDate.parse vai exibir a data local do formato como vc colocou dentro dela
            LocalDate d04 = LocalDate.parse("2022-07-20");
            LocalDateTime d05 = LocalDateTime.parse("2022-07-20T01:30:26");

            // Uma forma de vc exibir o horário estático global
            // O d06 ele exibe conforme o horário do londres
            // O d07 ele exibe o horário ajustado para o Br subitraindo 3 horas.
            Instant d06 = Instant.parse("2022-07-20T01:30:26Z");
            Instant d07 = Instant.parse("2022-07-20T01:30:26-03:00");
            
            // https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/format/DateTimeFormatter.html
            // Usando o dateTimeFormatter, podemos usar ele para dizer qual é o formato da data que vc está colocando
            // Nesse caso, estamos usando o fmt1
            // Donde foi definido acima DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            // O mesmo vale para fm2
            LocalDate d08 = LocalDate.parse("20/07/2022", fmt1);
            LocalDateTime d09 = LocalDateTime.parse("20/07/2022 01:30", fmt2);

            LocalDate d10 = LocalDate.of(2022, 07, 20);
            LocalDateTime d11 = LocalDateTime.of(2022, 07, 20, 1, 30);
            
            // o toString() ele converte a data exibida no formato ISO 8601
            System.out.println("d01 = " + d01.toString());
            System.out.println("d01 = " + d01);
            System.out.println("d02 = " + d02.toString());
            System.out.println("d02 = " + d02);
            System.out.println("d03 = " + d03.toString());
            System.out.println("d03 = " + d03);
            System.out.println("d04 = " + d04.toString());
            System.out.println("d04 = " + d04);
            System.out.println("d05 = " + d05.toString());
            System.out.println("d05 = " + d05);
            System.out.println("d06 = " + d06.toString());
            System.out.println("d06 = " + d06);
            System.out.println("d07 = " + d07.toString());
            System.out.println("d07 = " + d07);
            System.out.println("d08 = " + d08.toString());
            System.out.println("d08 = " + d08);
            System.out.println("d09 = " + d09.toString());
            System.out.println("d09 = " + d09);
            System.out.println("d10 = " + d10.toString());
            System.out.println("d10 = " + d10);
            System.out.println("d11 = " + d11.toString());
            System.out.println("d11 = " + d11);
        }
    }

## Aula 08 - Convertendo data-hora para texto:
Vimos como é feito a data-hora para texto usando o toString() na aula anterior.

Agora, vamos aprender a como converter em algum texto personalizado

    package app;

    import java.time.Instant;
    import java.time.LocalDate;
    import java.time.LocalDateTime;
    import java.time.ZoneId;
    import java.time.format.DateTimeFormatter;

    public class Program2 {

        public static void main(String[] args) {
            
            LocalDate d04 = LocalDate.parse("2022-07-20");
            LocalDateTime d05 = LocalDateTime.parse("2022-07-20T01:30:26");
            Instant d06 = Instant.parse("2022-07-20T01:30:26Z");
            
            // https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/format/DateTimeFormatter.html
            DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            // Isso permite que pegue o horário local de onde a máquina está processando
            DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
            // O ISO_DATE_TIME é uma data local que não representa um fuso horário. No caso, não dá para usar para uma data que foi gerado por Instant
            DateTimeFormatter fmt4 = DateTimeFormatter.ISO_DATE_TIME;
            // Já esse aqui é para usar para o Instant
            DateTimeFormatter fmt5 = DateTimeFormatter.ISO_INSTANT;
            
            System.out.println("d04 = " + d04);
             // É uma outra forma de conseguirmos formatar a data para um texto, usando o .format()
            System.out.println("d04 = " + d04.format(fmt1));
            // É uma outra forma invertida para ter o mesmo resultado
            System.out.println("d04 = " + fmt1.format(d04));
            System.out.println("d04 = " + d04.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            
            System.out.println("d05 = " + d05.format(fmt1));
            System.out.println("d05 = " + d05.format(fmt2));
            System.out.println("d05 = " + d05.format(fmt4));

            // Note que, o d06 ele está no formato global do horário de Londres, mas ao usar o fmt3, ele irá exibir no formato personalizado como foi montado dentro do fmt3, como está sendo usado o withZone(ZoneId.systemDefault()) irá exibir com o horário atualizado subtraindo 3 horas do londres.
            // Sempre que vc usar o instante, é necessário, na formatação, especificar o fuso-horário
            System.out.println("d06 = " + fmt3.format(d06));
            System.out.println("d06 = " + fmt5.format(d06));
            System.out.println("d06 = " + d06.toString());
        }
    }

## Aula 09 - Convertendo data-hora global para local:
Vamos aprender a realizar conversão de data-hora global para local.

Seguir o seguinte código

    package app;

    import java.time.Instant;
    import java.time.LocalDate;
    import java.time.LocalDateTime;
    import java.time.ZoneId;

    public class Program3 {

        public static void main(String[] args) {

            // for (String s : ZoneId.getAvailableZoneIds())
            // System.out.println(s);

            LocalDate d04 = LocalDate.parse("2022-07-20");
            LocalDateTime d05 = LocalDateTime.parse("2022-07-20T01:30:26");
            Instant d06 = Instant.parse("2022-07-20T01:30:26Z");

            // Note que, o d06 ele é uma data que foi gerado pelo Instant, e para conseguirmos converter ele no horário local seria usando o .ofInstant
            LocalDate r1 = LocalDate.ofInstant(d06, ZoneId.systemDefault());
            LocalDate r2 = LocalDate.ofInstant(d06, ZoneId.of("Portugal"));
            LocalDateTime r3 = LocalDateTime.ofInstant(d06, ZoneId.systemDefault());
            LocalDateTime r4 = LocalDateTime.ofInstant(d06, ZoneId.of("Portugal"));

            System.out.println("r1 = " + r1);
            System.out.println("r2 = " + r2);
            System.out.println("r3 = " + r3);
            System.out.println("r4 = " + r4);

            // Aqui não muda com JavaScript, dos métodos que temos para new Date().
            System.out.println("d04 dia = " + d04.getDayOfMonth());
            System.out.println("d04 mês = " + d04.getMonthValue());
            System.out.println("d04 ano = " + d04.getYear());

            System.out.println("d05 hora = " + d05.getHour());
            System.out.println("d05 minutos = " + d05.getMinute());

        }
    }

## Aula 10 - Cálculos com data-hora:
Vamos aprender a manipular data-hora realizando alguns cálculos com ele.

Seguir o código

    package app;

    import java.time.Duration;
    import java.time.Instant;
    import java.time.LocalDate;
    import java.time.LocalDateTime;
    import java.time.temporal.ChronoUnit;

    public class Program4 {

        public static void main(String[] args) {

            LocalDate d04 = LocalDate.parse("2022-07-20");
            LocalDateTime d05 = LocalDateTime.parse("2022-07-20T01:30:26");
            Instant d06 = Instant.parse("2022-07-20T01:30:26Z");
            
            LocalDate pastWeekDate = d04.minusDays(7);
            LocalDate nextWeekDate = d04.plusDays(7);
            
            LocalDateTime pastWeekLocalDate = d05.minusDays(7);
            LocalDateTime nextWeekLocalDate = d05.plusDays(7);
            
            // O ChronoUnit ele é uma outra forma de vc definir se é dia, ano, etc... que vc quer add ou subtrair.
            Instant pastWeekInstant = d06.minus(7, ChronoUnit.DAYS);
            Instant nextWeekInstant = d06.plus(7, ChronoUnit.DAYS);
            
            System.out.println("d04 = " + d04);
            System.out.println("pastWeekDate = " + pastWeekDate);
            System.out.println("nextWeekDate = " + nextWeekDate);
            
            System.out.println("d05 = " + d05);
            System.out.println("pastWeekLocalDate = " + pastWeekLocalDate);
            System.out.println("nextWeekLocalDate = " + nextWeekLocalDate);
            
            System.out.println("d06 = " + d06);
            System.out.println("pastWeekInstant = " + pastWeekInstant);
            System.out.println("nextWeekInstant = " + nextWeekInstant);
            
            // Aqui estamos usando o Duration para podermos realizar a diferença entre duas datas
            // O atTime aqui seria devido ao pastWeekDAte e d04, não terem a cada de segundos para conseguirmos calcular a diferença. Pois o Duration.between, ele considera a data no formato LocalDateTime.
            // Daí, vamos ter que converter essas duas datas em localDateTime, uma forma para fazer isso é usando o atTime.
            Duration t1 = Duration.between(pastWeekDate.atTime(0, 0), d04.atTime(0, 0));

            // Tem um outro método que convertemos o localDate para localDateTime que é usando o atStartOfDay.
            // No caso, o atStartOfDay, está dizendo que queremos converter a data para a meia-noite dessa data.
            Duration t1 = Duration.between(pastWeekDate.atStartOfDay(), d04.atStartOfDay());
            Duration t2 = Duration.between(pastWeekLocalDate, d05);
            Duration t3 = Duration.between(pastWeekInstant, d06);
            Duration t4 = Duration.between(d06, pastWeekInstant);

            // O toDays() aqui pede para mostrar a diferença apenas de dias
            System.out.println("t1 dias = " + t1.toDays());
            System.out.println("t1 dias = " + t1);
            System.out.println("t2 dias = " + t2.toDays());
            System.out.println("t2 dias = " + t2);
            System.out.println("t3 dias = " + t3.toDays());
            System.out.println("t3 dias = " + t3);
            System.out.println("t4 dias = " + t4.toDays());
            System.out.println("t4 dias = " + t4);
        }
    }

## Aula 11 - Aviso: próximas duas aulas são sobre Date e Calendar:
Queridos estudantes, conforme avisei na introdução deste capítulo, as próximas duas aulas serão sobre os tipos Date e Calendar, que é o modelo antigo de data-hora usado pelo Java antes da versão 8. Deixei essas aulas aqui para vocês como referência opcional caso precisem trabalhar com esse modelo antigo em algum sistema legado em Java. Abraços e bons estudos!

## Aula 12 - Trabalhando com datas - Date:
Bom, o formato de trabalhar com data aqui será do modo antigo. Ou seja, da versão Java anterior de 8.

Seguir o link para leitura

    https://docs.oracle.com/javase/10/docs/api/java/text/SimpleDateFormat.html

Um objeto Date internamente armazena:

- O número de  milissegundos desde a meia noite do dia 1 de janeiro de 1970 GMT (UTC)

    - GMT: Greenwich MeanTime (time zone)
    - UTC: CoordinatedUniversal Time (time standard)

Seguir o código

    SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    sdf3.setTimeZone(TimeZone.getTimeZone("GMT"));

    // Será necessário importar o módulo de Date tbm para podermos usar os construtores de baixo
    Date x1 = new Date();
    Date x2 = new Date(System.currentTimeMillis());
    Date x3 = new Date(0L);
    Date x4 = new Date(1000L * 60L * 60L * 5L);

    // Aqui o parse não será reconhecido
    // Por isso, será necessário incluir throws ParseException depois do public static void main.
    Date y1 = sdf1.parse("25/06/2018");
    Date y2 = sdf2.parse("25/06/2018 15:42:07");
    Date y3 = Date.from(Instant.parse("2018-06-25T15:42:07Z"));

    System.out.println("x1: " + x1);
    System.out.println("x2: " + x2);
    System.out.println("x3: " + x3);
    System.out.println("x4: " + x4);
    System.out.println("y1: " + y1);
    System.out.println("y2: " + y2);
    System.out.println("y3: " + y3);
    System.out.println("-------------");
    System.out.println("x1: " + sdf2.format(x1));
    System.out.println("x2: " + sdf2.format(x2));
    System.out.println("x3: " + sdf2.format(x3));
    System.out.println("x4: " + sdf2.format(x4));
    System.out.println("y1: " + sdf2.format(y1));
    System.out.println("y2: " + sdf2.format(y2));
    System.out.println("y3: " + sdf2.format(y3));
    System.out.println("-------------");
    System.out.println("x1: " + sdf3.format(x1));
    System.out.println("x2: " + sdf3.format(x2));
    System.out.println("x3: " + sdf3.format(x3));
    System.out.println("x4: " + sdf3.format(x4));
    System.out.println("y1: " + sdf3.format(y1));
    System.out.println("y2: " + sdf3.format(y2));
    System.out.println("y3: " + sdf3.format(y3));

Curiosamente é análogo ao JavaScript com o construtor new Date().

## Aula 13 - Manipulando um Date com Calendar:
Vamos aprender a manipular uma data com Calendar.

No caso, é um método que te permite realizar cálculos com as datas

- Somando uma unidade de tempo:

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    Date d = Date.from(Instant.parse("2018-06-25T15:42:07Z"));

    System.out.println(sdf.format(d));

    Calendar cal = Calendar.getInstance();
    cal.setTime(d);
    cal.add(Calendar.HOUR_OF_DAY, 4);
    d = cal.getTime();

    System.out.println(sdf.format(d));

- Obtendo uma unidade de tempo:

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    Date d = Date.from(Instant.parse("2018-06-25T15:42:07Z"));

    System.out.println(sdf.format(d));

    Calendar cal = Calendar.getInstance();
    cal.setTime(d);
    int minutes = cal.get(Calendar.MINUTE);
    int month = 1 + cal.get(Calendar.MONTH);
    
    System.out.println("Minutes: " + minutes);
    System.out.println("Month: " + month);
