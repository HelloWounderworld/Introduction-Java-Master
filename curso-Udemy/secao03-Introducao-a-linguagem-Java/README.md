# Seção 3 - Introdução à linguagem de programação Java:

## Aula 01 - Visão geral do capítulo e Aula 02 - Material de apoio do capítulo:
Seguir os dois arquivos em pdf

    introducao-linguagem-java.pdf
    introducao-linguagem-java(para-anotacoes).pdf

## Aula 03 - Entendendo as versões do Java:
Bom, temos o link em que vc consegue acessar as versões do Java atuais

    http://www.oracle.com/technetwork/java/javase

Ou jogar no google "Java SE donwload", SE - Standard Edition.

No caso, vc precisaria baixar os Javas das versões que tenha a sigla LTS (Long Term Support).

No caso, para o curso a versão do Java que vamos utilizar será Java SE 11.0.4 (LTS).

## Aula 04 - Histórico e edições de Java:
Vamos entender um pouco sobre o histórico e edições de Java.

    https://www.coursera.org/articles/what-is-java-used-for

## Aula 05 - JDK / JVM - Máquina Virtual do Java:
Seguir o link para leitura

    https://www.naukri.com/learning/articles/difference-between-jdk-jre-and-jvm/

Basicamente, podemos entender JVM, JRE e JDK da seguinte forma

    JVM &sub; JRE &sub; JDK

### Definição de JVM
É uma máquina virtual responsável em converter o bytecode para um código de uma máquina específica.

Obs: O JVM é necessário em ambos JDK e JRE.

### Definição de JRE
É um software que tem como definição JVM mais as bibliotecas de classes.

### Definição de JDK
É um software com o ambiente completop para construir aplicações e aparatos para usar a linguagem de programação Java. Em outras palavras, o JDK é um software que possui a definição do JRE mais as ferramentas de desenvolvimentos.

## Aula 06 - Estrutura de uma aplicação Java:
O Java é uma linguagem orientada à objetos.

Bom, a ideia de orientação à objetos é o mesmo que eu já estudei em Python e JavaScript. Vale dar uma revisada no meu repositório sobre a tal linguagem.

## Aula 07 - Instalando o Java JDK:
INSTALANDO O JAVA JDK

Veja como instalar o Java JDK no nosso Youtube.

Windows:

    https://www.youtube.com/watch?v=QekeJBShCy4

Linux:

    https://www.youtube.com/watch?v=Sv0EwYPLw8w&list=PLNuUvBZGBA8mcAF-YX7RJhA26TBLdG5yk&index=3

Mac:

    https://github.com/devsuperior/sds2/tree/master/instalacao/mac#java-11-on-macos

## Aula 08 - Instalando o Eclipse:
Vamos instalar o eclipse!

Bom, estou usando o VSCode para tentar rodar os projetos e tudo mais, mas é melhor usarmos essa via como um meio de nota que nos permite guardar os meus avanços para o meu repositório github. Por hora, em paralelo, do que estiver sendo feito em eclipse, irei realizar aqui no VSCode tbm para ver se não haverá nenhum problema de particularidade das IDE para prosseguir com o curso.

Seguir o seginte link para realizar o download do IDE Eclipse

    https://www.eclipse.org/downloads/packages/

Bom, daí vc irá mover o arquivo descompactado "eclipse" no disco local C: e dentro dela vc irá acessar essa pasta e irá acessar o arquivo com o nome "eclipse", é um arquivo com cor azul ou roxo ou meio termo disso.

Em seguida, irá aparecer uma tela em que vc pode confiugrar a path onde será salvo todos os projetos que vc desenvolveu com o Eclipse. No meu caso, eu salvei na seguinte path, clicando no botão "Browser"

    DiscoLocalC:/temp/ws-eclipse

A pasta temp e ws-eclipse, se não tiver, vc pode cirar. Em seguida, vc clica no launch.

Feito isso, o ambiente de IDE para Eclipse estará configurado.

## Aula 09 - Primeiro programa em Java no Eclipse:
Vamos codar o nosso primeiro código em Java!

Seguir as instruções de utilização do eclipse.

• Workspace(selecione a pasta aonde os projetos serão salvos)

• Mudar o layout: Window-> Perspective -> Open Perspective -> Java

• Zerar o layout: Window-> Perspective -> Reset Perspective

• Mostrar a aba Console: Window-> Show View-> Console

O nome do projeto java que vamos criar será "curso_programacao"

• Criar projeto: File -> New -> Java Project

É importante ressaltar que a linguagem java separa os projetos em pacotes, principalmente quando se tem muita classe, para facilitar a leituira e interpretação, o formato de pacotes é importante.

Criar classe: 

• Botão direito na pasta "src" -> New -> Class

• Package: deixe em branco

• Nome da classe: Main(com M maiúsculo)

É a opção de baixo que permite que o arquivo java seja executável.

• Marque a opção: public static void main(String[] args)

Mudar o tamanho da fonte:

• CTRL +

• CTRL -

Bom, feito os passos acima, teremos um arquivo Main.java criado com a seguinte configuração dentro dela

    public class Main {

        public static void main(String[] args) {
            // TODO Auto-generated method stub

        }

    }

No caso, analisando a restrutura, fica evidente a natureza da linguagem de programação Java, que ela é orientada à objetos. Por isso, faz sentido de que cada execução fique alocado dentro de uma classe.

Para o primeiro teste de rodar um código java, vamos colocar dentro da função o seguinte

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("Hello WounderWorld!");
    }

Daí, no Eclipse vc pode rodar ela clicando sobre a pasta Main.java com o botão direito do mouse e escolher a opção "run as" e clicar em "Application as Java". No VSCode, instalado a extensão Code Runner, bastaria clicar no botão play que aparece nas abas dos arquivos em aberto.
