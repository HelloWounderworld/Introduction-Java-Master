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


## Aula 05 - Requires Transitive:

## Aula 06 - Exports To:

## Aula 07 - Módulos e Reflection:

## Aula 08 - Interface vs Implementação:

## Aula 09 - Provides With & Uses:
