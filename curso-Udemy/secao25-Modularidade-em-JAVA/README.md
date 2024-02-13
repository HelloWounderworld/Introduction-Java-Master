# Seção 25: Modularidade em JAVA:

## Aula 01 - Módulo vs Encapsulamento:
Quando criamos um determinado projeto, por exemplo, app-mod1 e app-mod2, uma hora ou outra, esses dois projetos irá gerar um arquivo, .jar, onde estará contido todas as estruturas de pastas do projeto, os arquivos, .class.

Suponhamos que o projeto, app-mod1, tenha alguma dependência com o projeto, app-mod2. No caso, dos arquivos, app-mod1.jar e app-mod2.jar, gerados o app-mod1.jar tem uma série de dependências com as classes do projeto, app-mod2.jar. Bom, em qualquer projeto, provavelmente, há de se ter os pacotes dentro dela. Assim, como, provavelmente, terá no projeto, app-mod2.jar.

O que tínhamos antes de termos tais práticas de modularidade, na situação acima. Basicamente, os pacotes que não teria nenhuma relação com o projeto, app-mod1.jar, e que reside dentro do projeto, app-mod2.jar, facava disponíveis para o projeto, app-mod1.jar. Ou seja, a relação de dependência, antes que não havia modularidade, permitia que o app-mod1 consiga acessar todos os pacotes do app-mod2, até aquelas que não havía nenhuma necessidade e que não tinha nenhuma relação dentro das dependências que o app-mod1 tinha com o app-mod2.

Claro, visto que as classes que estavam dentro dos pacotes do projeto, app-mod2, que não tinha nenhuma relação com o projeto, app-mod1, estando como public, estaríam disponíveis para o projeto, app-mod1.

No caso, nessa brincadeira, haviam cenários em que tinham pacotes dentro do, app-mod2, que teria que ser internos para aquele pacote, ou seja, visíveis somente para aquele projeto, app-mod2, que ficavam visíveis para o projeto, app-mod1. E que tais pacotes internos estavam estabelecendo relações com outras classes de outros pacotes que tinha alguma relação com as classes do projeto, app-mod1. Nesse cenário, suponhamos que esse pacote interno do projeto, app-mod2, não pudesse sofrer nenhuma alteração e que não poderá criar nenhuma outra nova dependência com o projeto, app-mod2. Visto que tais pacotes estão totalmente disponíveis para o projeto, app-mod1, a ideia simples seria, não mexer ou criar algum método que permita criar alguma dependência nesses pacotes. Bom, claro que, se tratando de ser humano, na prática não funciona desse jeito, certo?

Por isso, que existe o conceito de encapsulamento, que é exatamente para evitar que isso ocorra. Ou seja, que aqueles pacotes que precisam estar restritos ao projeto, app-mod2, e que não pode haver nenhuma outra dependência nova com projetos externos, com o encapsulamento, nos possibilita em realizarmos isso.

Entretanto, por mais que o encapsulamento seja uma solução para o cenário, temos uma outra bm mais eficiente disso que é a modularidade, que é indicado pelo module-info. No caso, a funcionalidade dela é parecido com o gitignore. Ou seja, conseguimos selecionar aqueles pacotes e classes que ficam internos e restritos do projeto e outras que podem ficar visíveis ao público. No caso, dentro do arquivo, module-info.java, os pacotes que forem descritos nela, serão os pacotes que podem ser exportados e que ficaram visíveis para outros projetos, garantindo, dessa forma, um nível de encapsulamento muito maior, comparado à necessidade de realizar o processo de encapsulamento manual.

Esse recurso, module-info.java, nos permite aumentar a eficiência da visibilidade até no ponto de vista arquitetural das relações entre sistemas. Um cenário bem delicado, por exemplo, de processos arquiteturais, são casos cíclicos, onde dois projetos possuem dependência entre eles. Basicamente, isso cai em uma sitaução de ovo e a galinha, quem nasceu primeiro. O module-info.java, basicamente, não pemite que ocorra esse tipo de dependêcia cíclica entre projetos, pois isso é o que gera muita dor de cabeça entre os desenvolvedores.

## Aula 02 - Criando Projetos:
Vamos criar dois projetos, app-calculo e app-financeiro.

Para criarmos esses projetos realizamos o seguinte passo, pelo eclipse

    New -> Java Project -> Project Name: app-calculo -> considera "Create module-info.java file" -> Module name: app.calculo -> Finish

Realizamos a mesma coisa para criarmos o projeto "app-financeiro".

Note que, nos dois projetos que foram criados, temos o arquivo, module-info.java, que serve para conseguirmos descrever quais pacotes serão exportados.

Na próxima aula, vamos aprender a utilizar tais arquivos.

## Aula 03 - Dependências entre Projetos:
Vamos aprender a criar uma dependência entre dois projetos.

Primeiramente, nessa aula, iremos realizar a criação de um jeito mais analógico, mas que ela continua sendo importante, pois, caso uma pessoa trabalhe na área de projetos ou produção, ter a destreza desse método fornecerá à pessoa a maneira bem flexível para selecionar qual classe será exportado.

Bom, primeiro, no projeto, app-calculo, vamos criar um pacote, calculo, e, dentro dela, vamos criar uma classe, Teste, e nela inserimos o seguinte

    package calculo;

    public class Teste {

        public static void dizOpa() {
            System.out.println("Opa");
        }
    }

Bom, agora, em cima do projeto, app-calculo, clicamos com o botão direito e selecionamos a opção "Export". Aparecerá um modal e nela realizamos o seguinte passo

    Select an export wizard: jar -> JAR file -> Select the resources to export, selecionamos a pasta "src" que está dentro do projeto, app-calculo -> Browse -> vai até a pasta, app-financeiro, e nela criamos uma pasta libs e dentro dela que colocamos o arquivo, app-calculo.jar. -> Finish

Clicando com o botão direito do mouse e selecionando "Refresh" para atualizar o projeto, vamos ver que, dentro do projeto, app-financeiro, foi criado uma pasta libs e dentro dela haverá o arquivo, app-calculo.jar. Agora, falta realizarmos o que fizemos nas outras seções quando tivemos que trazer o driver para aprendermos o hibernate, buildar. No caso, segue os seguintes passos

    Botão direito do mouse -> Build Path -> Add to Build Path

Note que, foi criado o app-calculo.jar dentro da pasta, Referenced Libraries. Ou seja, passamos a referenciar o projeto, app-calculo.jar. Vamos conseguir ver que, dentro desse arquivo, app-calculo.jar, temos o pacote, calculo, com a classe, Teste, que criamos dentro do projeto, app-calculo.

Agora, suponhamos que criamos um método main dentro dessa classe, Teste, depois de ocorrido os processos acima. Ou seja, realizamos a seguinte complementação

    package calculo;

    public class Teste {

        public static void dizOpa() {
            System.out.println("Opa");
        }
        
        public static void main(String[] args) {
            dizOpa();
        }
    }

No caso, novamente, quando formos buildar, agora, visto que temos o método main, realizamos o seguinte passo, não vá até o final, será, somente, para mostrar como se faz

    Export -> Select an export wizard: jar -> Runnable JAR file -> Launch configuration: Teste-app-calculo -> Browser, selecionamos o destino que será salvo e executado -> Por hora não selecionamos nada e apenas damos o Cancel.

Note que, o processo acima, para conseguirmos criar uma dependência do projeto, app-calculo, para o projeto, app-financeiro, precisou de muitos passo a passo. Por isso que mencionei que será um processo analógico. Porém, a pessoa possuindo a destreza deste processo, terá mais flexibilidade para conseguirmos realizar os builds e criar dependências.

Claro, visto que temos a maneira analógico, temos também, a forma mais moderna, que é o mais usual, pois todo o processo feito acima, será realizado de forma mais rápida. Será discutido na próxima aula.

Vamos excluir o que buildamos, até agora. No caso, em, app-calculo.jar, que está dentro da libs, clicamos com o botão direito e realizamos o seguinte passo

    Build Path -> Configure Build Path -> Libraries -> seleciona "app-calculo.jar-app-financeiro/libs" -> Remove -> Apply and Close

Agora, excluímos a pasta, libs, do proejto, app-financeiro.

Podemos apagar o pacote, calculo, do projeto, app-calculo, de uma vez.

Bom, dessa forma, chegamos na forma como começamos essa aula.

Vamos, mostrar, uma parte de como criamos a dependência entre dois projetos de maneira mais rápida. No caso, clicamos com o botão direito sobre o projeto, app-financeiro, e nela realizamos o seguinte passo

    Build Path -> Configure Build Path -> Seleciona a aba Projects -> Modulepath -> Add -> Seleciona "app-calculo" -> Ok -> Apply and Close

Dessa forma, criamos uma dependência entre os projetos, app-financeiro e app-calculo.

Bom, na próxima aula, vamos conseguir definir os módulos.

## Aula 04 - Requires/Exports:
Vamos, agora, criar uma classe bem simples dentro do projeto, app-calculo, para podermos reusa-las no outro projeto, app-financeiro.

Bom, vamos criar o seguinte pacote "jp.com.mathcoder.app.calculo", de um jeito bem realista como é de costume ser feito tais pacotes em sistemas de emrpesas. Dentro desse pacote, criamos a seguinte classe "Calculadora" e nela inserimos o seguinte

    package jp.com.mathcoder.app.calculo;

    import jp.com.mathcoder.app.calculo.interno.OperacoesAritmeticas;

    public class Calculadora {

        private OperacoesAritmeticas opAritmeticas = new OperacoesAritmeticas();

        public double soma(double... nums) {
            return opAritmeticas.soma(nums);
        }
        
    }

Dentro do pacote, jp.com.mathcoder.app.calculo, criamos um sub-pacote, jp.com.mathcoder.app.calculo.interno, e nela criamos a classe "OperacoesAritmeticas", essa será a classe que queremos deixar como algo interno do projeto, ou seja, não visível, e nessa classe inserimos o seguinte

    package jp.com.mathcoder.app.calculo.interno;

    import java.util.Arrays;

    public class OperacoesAritmeticas {

        public double soma(double... nums) {
            return Arrays.stream(nums).reduce(0.0, (t, a) -> t + a);
        }
    }

Depois disso, vamos no projeto, app-financeiro, e nela criamos o pacote "jp.com.mathcoder.app.financeiro" e, dentro desse pacote, criamos a classe, Teste, e nela inserimos o seguinte

    package jp.com.mathcoder.app.financeiro;

    import jp.com.mathcoder.app.calculo.Calculadora;

    public class Teste {

        public static void main(String[] args) {
            
            Calculadora calc = new Calculadora();
            
            System.out.println(calc.soma(2, 3, 4));
        }
    }

Note que, nesse momento, vemos que a classe, Calculadora, que instanciamos está com um erro, pois no projeto, app-financeiro, ela não está visível do ponto de vista do projeto, app-calculo.

No caso, vamos precisar que essa classe, Calculadora, fique visível para o projeto, app-financeiro. Logo, no arquivo, module-info.java, do projeto, app-calculo, coloquemos o seguinte

    module app.calculo {
        exports jp.com.mathcoder.app.calculo;
    }

Isso torna as classes de até nesse nível de pacote, visíveis. O sub-pacote, interno, não ficará visível para isso.

Entretante, o feito acima não é o suficiente para conseguirmos utilizar a classe, Calculadora, no outro projeto. Vamos precisar realizar um require no arquivo, module-info, do projeto, app-financeiro, da seguinte forma

    module app.financeiro {
        
        requires java.base;
        requires app.calculo;
    }

Feito os ajustes acima, finalmente, podemos rodar a classe, Teste, verificando que deu certo.

Bom, essa aula foi os feitos iniciais de manipulação do arquivo, module-info.java, para conseguirmos estabelecer os apontamentos de um projeto para o outro.

Lembra do que foi abordado na aula introdutória e conceitual sobre a má prática que é uma arquitetura cíclica e que tal arquivo, module-info.java, nos impede de estabelecer esse tipo de relação? Bom, como prometido, no arquivo, module-info.java, do projeto, app-calculo, se colocarmos "requires app.financeiro", vamos ver que ela irá mostrar um erro, indicando que não podemos estabelecer essa arquitetura ciclica.

Bom, lembre-se que a dependência cíclica é uma das piores relações que poderia estabelecer no ramo de modularidade e o arquivo, module-info, nos permitiu, dentre outros e vários recursos que a mesma possui, evitar que estabeleça essa dependencia cíclica.

## Aula 05 - Requires Transitive:
Vamos abordar um outro assunto de Requires, que é o Require Transitive.

Bom, para entendermos bem esse conceito, vamos criar um outro novo projeto, app-loggin, pelo mesmo passo a passo que utilizamos para criamos os dois projetos, app-calculo e app-financeiro.

Bom, dentro desse projeto, app-loggin, vamos criar um novo pacote "jp.com.mathcoder.app.loggin" e, dentro desse pacote, criamos uma nova classe, Logger, e nela inserimos o seguinte

    package jp.com.mathcoder.app.loggin;

    import java.text.SimpleDateFormat;
    import java.util.Date;

    public class Logger {

        public static void info(String msg) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            System.out.println("[INFO]" + sdf.format(new Date()) + " - " + msg);
        }
    }

Agora, vamos usar essa função, Logger, dentro do projeto, app-calculo. Mas, como foi feito para os dois projetos, app-financeiro e app-calculo, vamos ter que, primeiro, estabelecer as dependências entre os projetos, app-calculo e app-loggin, para conseguirmos utilizar dos recursos do module-info.java. Para isso, como foi feito antes, vamos estabelecer o seguinte passo a passo, sobre o app-calculo

    Build Path -> Configure Build Path -> Seleciona a aba Projects -> Modulepath -> Add -> Seleciona "app-loggin" -> Ok -> Apply and Close

Dessa forma, criamos uma dependência entre os projetos, app-calculo e app-loggin.

Agora, no projeto, app-loggin, vamos exportar o pacote, jp.com.mathcoder.app.loggin, da seguinte forma

    module app.loggin {
        exports jp.com.mathcoder.app.loggin;
    }

Em seguida, no arquivo, module-info, do projeto, app-calculo, vamos dar requires desse projeto, app-loggin, da seguinte forma

    module app.calculo {
        requires app.loggin;
        exports jp.com.mathcoder.app.calculo;
    }

Agora, sim, vamos conseguir utilizar as classes do projeto, app-loggin, dentro da classe, app-calculo. Logo, na classe, OperacoesAritmeticas, vamos realizar o seguinte

    package jp.com.mathcoder.app.calculo.interno;

    import java.util.Arrays;
    import jp.com.mathcoder.app.loggin.Logger;

    public class OperacoesAritmeticas {

        public double soma(double... nums) {
            Logger.info("Somando...");
            return Arrays.stream(nums).reduce(0.0, (t, a) -> t + a);
        }
    }

E, finalmente, vamos rodar a classe, Teste, que está no projeto, app-financeiro e vemos que a função definida no projeto, app-loggin, em efeito cascata, surtiu efeito, visto que foi usado na classe, Calculadora.

Entretanto, o que realmente quero mostrar nessa aula não é isso, pois somente configuramos o ambiente para, finalmente, conseguirmos explicar o que queremos que é o assunto foco dessa aula.

Visto que conseguimos importar a classe, Logger, dentro do projeto, app-calculo, dentro da classe, Calculadora, conseguimos relizar o seguinte

    package jp.com.mathcoder.app.calculo;

    import jp.com.mathcoder.app.calculo.interno.OperacoesAritmeticas;
    import jp.com.mathcoder.app.loggin.Logger;

    public class Calculadora {

        private OperacoesAritmeticas opAritmeticas = new OperacoesAritmeticas();

        public double soma(double... nums) {
            return opAritmeticas.soma(nums);
        }
        
        public Class<Logger> getLoggerClass() {
            return Logger.class;
        }
    }

No caso, o que isso nos permite realizar? Bom, na classe, Teste, do projeto, app-financeiro, vamos conseguir realizar o seguinte

    package jp.com.mathcoder.app.financeiro;

    import jp.com.mathcoder.app.calculo.Calculadora;

    public class Teste {

        public static void main(String[] args) {
            
            Calculadora calc = new Calculadora();
            
            System.out.println(calc.soma(2, 3, 4));
            
            System.out.println(calc.getLoggerClass());
        }
    }

Ao rodarmos o código acima, em que pegamos o método, getLoggerClass(), que foi definido na classe, Calculadora, acima, não irá funcionar, pois o projeto, app-loggin, não está visível pelo projeto, app-financeiro. O que é curioso, visto que, no método, soma, da classe, Calculadora, conseguimos verificar o resultado da função, info, definida dentro da classe, Logger. No caso, para corrigirmos o cenário acima, precisamos fazer com que o projeto, app-financeiro, reconheça o projeto, app-loggin. Mas, a maneira como realizamos o requires não será da mesma forma como fizemos antes.

No caso, visto que a classe, Logger, é uma classe que queremos que seja exportado por uma transição, no arquivo, module-info, do projeto, app-calculo, vamos precisar realizar um requires transitive, como segue

    module app.calculo {
        requires transitive app.loggin;
        exports jp.com.mathcoder.app.calculo;
    }

Em seguida, no arquivo, modelo-info, do projeto, app-financeiro, vamos precisar realizar o seguinte

    module app.financeiro {
        
        requires java.base; // Por padrão
        requires app.calculo;
        requires app.loggin;
    }

E, além disso, pelo build path, estabelecer uma relação de dependência com o projeto, app-loggin.

Feito isso, note que, o erro que estava sendo exibido na classe, Teste, sumiu e conseguimos, agora, rodar a classe, Teste, sem nenhum problema.

Bom, vamos tirar as dependências dos módulos, a abordagem que fizemos nessa aula, fica por aqui. Tiramos a relação de dependência entre os projetos, app-financeiro e app-loggin, e apagamos o println do getLoggerClass da classe, Teste, e apagamos o método, getLoggerClass, da classe, Calculadora.

## Aula 06 - Exports To:
O export to, ele é uma forma de conseguirmos exportar os pacotes para um determinado projeto ou classe, apenas. Ou seja, é um apontamento mais refinado.

No caso, como exemplo, no arquivo, module-info, do projeto, app-calculo, vamos colocar o seguinte

    module app.calculo {
        requires transitive app.loggin;
        exports jp.com.mathcoder.app.calculo;
        
        exports jp.com.mathcoder.app.calculo.interno
            to app.financeiro;
    }

Bom, uma vez feito isso, para testarmos, na classe, Teste, inserimos o seguinte

    package jp.com.mathcoder.app.financeiro;

    import jp.com.mathcoder.app.calculo.Calculadora;
    import jp.com.mathcoder.app.calculo.interno.OperacoesAritmeticas;

    public class Teste {

        public static void main(String[] args) {
            
            Calculadora calc = new Calculadora();
            
            System.out.println(calc.soma(2, 3, 4));
            
    //		System.out.println(calc.getLoggerClass());
            
            OperacoesAritmeticas opAritmeticas = new OperacoesAritmeticas();
            System.out.println(opAritmeticas.soma(4, 5, 6));
        }
    }

Bom, lembrando que já foi feito o requires para o projeto, app-calculo, dentro do projeto, app-financeiro, então podemos rodar o código acima sem nenhum problema.

Caso, vc queira apontar para mais projetos em específico, utilizando o export to, basta usarmos a vígula

    exports nome.do.pacote
            to app.projeto1, app.projeto2, app.projeto3;

## Aula 07 - Módulos e Reflection:
Vamos aprender uma sintaxe que existe em modules-info, chamado "open".

Bom, no arquivo, module-info, do projeto, app-loggin, podemos realizar o seguinte

    open module app.loggin {
        exports jp.com.mathcoder.app.loggin;
    }

Bom, depois que fizemos isso, conseguimos ver conseguimos executar a classe, Teste, e, além disso, foi exibido nenhum outro erro.

Mas, então, o que essa sintaxe "open" realiza?

Basicamente, ela nos permite realizar um processo de introspecção. Ou seja, usar o Java reflection, que é o que nos permite alterar alguns dados privados de uma classe.

No caso, por exemplo, vamos realizar a seguinte implementação na classe, Teste, como segue

    package jp.com.mathcoder.app.financeiro;

    import jp.com.mathcoder.app.calculo.Calculadora;
    import jp.com.mathcoder.app.calculo.interno.OperacoesAritmeticas;

    public class Teste {

        public static void main(String[] args) {
            
            Calculadora calc = new Calculadora();
            
            System.out.println(calc.soma(2, 3, 4));
            
    //		System.out.println(calc.getLoggerClass());
            
            OperacoesAritmeticas opAritmeticas = new OperacoesAritmeticas();
            System.out.println(opAritmeticas.soma(4, 5, 6));
            
            System.out.println(Calculadora.class.getName());
        }
    }

Ou seja, simplesmente, só printei o nome da path da classe, Calculadora, acima.

Bom, agora, suponhamos que nessa classe, Calculadora, tenhamos algum atributo privado, como seguinte

    package jp.com.mathcoder.app.calculo;

    import jp.com.mathcoder.app.calculo.interno.OperacoesAritmeticas;
    //import jp.com.mathcoder.app.loggin.Logger;
    import jp.com.mathcoder.app.loggin.Logger;

    public class Calculadora {
        
        private String id = "abc";

        private OperacoesAritmeticas opAritmeticas = new OperacoesAritmeticas();

        public double soma(double... nums) {
            Logger.info("Somando...");
            return opAritmeticas.soma(nums);
        }
        
    //	public Class<Logger> getLoggerClass() {
    //		return Logger.class;
    //	}
    }

Bom, como havíamos dito, a sintaxe "open" que foi usada no arquivo, module-info, do projeto, app-loggin, nos permite realizar altedações de dados em atributos privados. Bom, levando em conta o cenário acima, como faremos isso?

Primeiro, vamos tentar procurar esse atributo que foi declarado na classe, Teste, da seguinte forma

    package jp.com.mathcoder.app.financeiro;

    import jp.com.mathcoder.app.calculo.Calculadora;
    import jp.com.mathcoder.app.calculo.interno.OperacoesAritmeticas;

    public class Teste {

        public static void main(String[] args) {
            
            Calculadora calc = new Calculadora();
            
            System.out.println(calc.soma(2, 3, 4));
            
    //		System.out.println(calc.getLoggerClass());
            
            OperacoesAritmeticas opAritmeticas = new OperacoesAritmeticas();
            System.out.println(opAritmeticas.soma(4, 5, 6));
            
            System.out.println(Calculadora.class.getName());
            System.out.println(Calculadora.class.getDeclaredFields()[0].getName());
        }
    }

Bom, conseguimos ver que, visto que o atributo id foi definido primeiro, identificamos ela pelo print acima.

No caso, podemos realizar o seguinte, utilizando o Field da classe reflect

    package jp.com.mathcoder.app.financeiro;

    import java.lang.reflect.Field;

    import jp.com.mathcoder.app.calculo.Calculadora;
    import jp.com.mathcoder.app.calculo.interno.OperacoesAritmeticas;

    public class Teste {

        public static void main(String[] args) {
            
            Calculadora calc = new Calculadora();
            
            System.out.println(calc.soma(2, 3, 4));
            
    //		System.out.println(calc.getLoggerClass());
            
            OperacoesAritmeticas opAritmeticas = new OperacoesAritmeticas();
            System.out.println(opAritmeticas.soma(4, 5, 6));
            
            System.out.println(Calculadora.class.getName());
            System.out.println(Calculadora.class.getDeclaredFields()[0].getName());
            
            try {
                Field fieldId = Calculadora.class.getDeclaredFields()[0];
                fieldId.setAccessible(true);
                System.out.println("Before " + fieldId.get(calc));
                fieldId.set(calc, "def");
                System.out.println("After " + fieldId.get(calc));
                fieldId.setAccessible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

Bom, se rodarmos o código acima, será exibido um erro com o seguinte tipo de mensagem "module app.calculo does not "opens jp.com.mathcoder.app.calculo". No caso, o que está sendo reclamado aqui, é que o projeto, app-calculo, não está aberto para realizar tais modificações.

Então, assim como fizemos para o arquivo, module-info, do projeto, app-loggin, realizamos para o projeto, app-calculo, em seu arquivo, module-info, o uso da sintaxe "open" como seguinte

    open module app.calculo {
        requires transitive app.loggin;
        exports jp.com.mathcoder.app.calculo;
        
        exports jp.com.mathcoder.app.calculo.interno
            to app.financeiro;
    }

Agora, rodando, novamente, a classe, Teste, como foi complementado, desta vez, não teremos nenhum erro.

Bom, para facilitar o acesso do valor desse atributo privado, na própria classe, Calculadora, podemos definir o getter sobre esse atributo, como seguinte

    package jp.com.mathcoder.app.calculo;

    import jp.com.mathcoder.app.calculo.interno.OperacoesAritmeticas;
    //import jp.com.mathcoder.app.loggin.Logger;
    import jp.com.mathcoder.app.loggin.Logger;

    public class Calculadora {
        
        private String id = "abc";

        private OperacoesAritmeticas opAritmeticas = new OperacoesAritmeticas();

        public double soma(double... nums) {
            Logger.info("Somando...");
            return opAritmeticas.soma(nums);
        }

        public String getId() {
            return id;
        }
        
    //	public Class<Logger> getLoggerClass() {
    //		return Logger.class;
    //	}
        
    }

Feito isso, vamos alterar para a seguinte forma de consulta da classe, Teste

    package jp.com.mathcoder.app.financeiro;

    import java.lang.reflect.Field;

    import jp.com.mathcoder.app.calculo.Calculadora;
    import jp.com.mathcoder.app.calculo.interno.OperacoesAritmeticas;

    public class Teste {

        public static void main(String[] args) {
            
            Calculadora calc = new Calculadora();
            
            System.out.println(calc.soma(2, 3, 4));
                
    //		System.out.println(calc.getLoggerClass());
            
            OperacoesAritmeticas opAritmeticas = new OperacoesAritmeticas();
            System.out.println(opAritmeticas.soma(4, 5, 6));
            
            System.out.println(Calculadora.class.getName());
            System.out.println(Calculadora.class.getDeclaredFields()[0].getName());
            System.out.println("Before " + calc.getId());
            
            try {
                Field fieldId = Calculadora.class.getDeclaredFields()[0];
                fieldId.setAccessible(true);
    //			System.out.println("Before " + fieldId.get(calc));
                fieldId.set(calc, "def");
    //			System.out.println("After " + fieldId.get(calc));
                fieldId.setAccessible(false);
                
                System.out.println("After " + calc.getId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

Vimos que conseguimos alterar o valor de um atributo privado que estava definido dentro da classe, Calculadora.

Mas, claro, se tirarmos o "open" do arquivo, module-info, do projeto, app-calculo, o processo acima não será possível de ser realizado.

Uma outra forma de utilizarmos a sintaxe "opens" seria de uma maneira mais pontual. Em vez de deixarmos em aberto todos os pacotes que exportamos no arquivo, module-info, podemos deixar em aberto apenas certos pacotes da seguinte forma

    module app.calculo {
        requires transitive app.loggin;
        exports jp.com.mathcoder.app.calculo;
        
        exports jp.com.mathcoder.app.calculo.interno
            to app.financeiro;
        
        opens jp.com.mathcoder.app.calculo;
    }

Se rodarmos, novamente, a classe, Teste, podemos ver que não teremos o problema. Ou seja, conseguimos fazer uma introspecção interna de forma pontual.

Além disso, podemos selecionar para qual módulo o pacote estará aberto

    module app.calculo {
        requires transitive app.loggin;
        exports jp.com.mathcoder.app.calculo;
        
        exports jp.com.mathcoder.app.calculo.interno
            to app.financeiro;
        
        opens jp.com.mathcoder.app.calculo to app.loggin, app.financeiro;
    }

Bom, podemos ver que, com o apontamento refinado acima, rodando novamente a classe, Teste, não tivemos nenhum problema.
 
## Aula 08 - Interface vs Implementação:
Bom, vamos tentar entender a diferença entre Interface e Implementação.

No caso, antes de abordarmos o assunto, em questão, vamos, primeiro, fazer algums preparativos que nos permitirá realizar a abordagem do assunto em questão.

No projeto, app-financeiro, do pacote, jp.com.mathcoder.app.financeiro, criamos uma interface "Calc" e nela inserimos o seguinte

    package jp.com.mathcoder.app.financeiro;

    public interface Calc {

        public double soma(double... nums);
    }

Bom, o que queremos discutir no assunto dessa aula, está em exatamente o tipo de flexibilidade que a implementaçãos nos fornece quando vc está utilizando a interface.

No mesmo pacote, vamos criar uma classe, Calc1, e nela realizemos a implementação da interface, Calc, como seguinte

    package jp.com.mathcoder.app.financeiro;

    import java.util.Iterator;

    public class Calc1 implements Calc {

        @Override
        public double soma(double... nums) {
            double total = 0;
            for (int i = 0; i < nums.length; i++) {
                total += nums[i];
            }
            return total;
        }
    }

E criamos uma outra classe, no mesmo pacote, chamado "Calc2" e nela realizamos a seguinte implementação

    package jp.com.mathcoder.app.financeiro;

    import java.util.Arrays;

    public class Calc2 implements Calc {

        @Override
        public double soma(double... nums) {
            return Arrays.stream(nums).reduce(0.0, (t, a) -> t + a);
        }
    }

Agora, na classe, Teste, do mesmo pacote, vamos realizar a seguinte complementação

    package jp.com.mathcoder.app.financeiro;

    import java.lang.reflect.Field;

    import jp.com.mathcoder.app.calculo.Calculadora;
    import jp.com.mathcoder.app.calculo.interno.OperacoesAritmeticas;

    public class Teste {

        public static void main(String[] args) {
            
    //		Calculadora calc = new Calculadora();
    //		
    //		System.out.println(calc.soma(2, 3, 4));
                
    //		System.out.println(calc.getLoggerClass());
            
    //		OperacoesAritmeticas opAritmeticas = new OperacoesAritmeticas();
    //		System.out.println(opAritmeticas.soma(4, 5, 6));
    //		
    //		System.out.println(Calculadora.class.getName());
    //		System.out.println(Calculadora.class.getDeclaredFields()[0].getName());
    //		System.out.println("Before " + calc.getId());
    //		
    //		try {
    //			Field fieldId = Calculadora.class.getDeclaredFields()[0];
    //			fieldId.setAccessible(true);
    ////			System.out.println("Before " + fieldId.get(calc));
    //			fieldId.set(calc, "def");
    ////			System.out.println("After " + fieldId.get(calc));
    //			fieldId.setAccessible(false);
    //			
    //			System.out.println("After " + calc.getId());
    //		} catch (Exception e) {
    //			e.printStackTrace();
    //		}
            
            Calc c1 = new Calc1();
            Calc c2 = new Calc2();
            
            System.out.println(c1.soma(1, 2, 3));
            System.out.println(c2.soma(1, 2, 3));
        }
    }

Bom, notamos que, na implementação que realizamos acima, não tivemos nenhum outro problema.

Basicamente, a maneira como fizemos a implementação e criação de interface, iremos querer realizar de forma análoga em modularidades Java, na próxima aula.

## Aula 09 - Provides With & Uses:

