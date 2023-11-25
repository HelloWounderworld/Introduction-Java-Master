# Seção 3 - Introdução à linguagem de programação Java:

## Aula 01 - Visão geral do capítulo e Aula 02 - Material de apoio do capítulo:
Seguir os dois arquivos em pdf

    introducao-linguagem-java.pdf
    introducao-linguagem-java(para-anotacoes).pdf

## Aula 03 - Entendendo as versões do Java:
Bom, temos o link em que vc consegue acessar as versões do Java atuais

    http://www.oracle.com/technetwork/java/javase

    https://www.oracle.com/java/technologies/downloads/#java21

Ou jogar no google "Java SE donwload", SE - Standard Edition.

No caso, vc precisaria baixar os Javas das versões que tenha a sigla LTS (Long Term Support).

No caso, para o curso a versão do Java que vamos utilizar será Java SE 11.0.4 (LTS).

Para quem usa o Linux, baixar a versão Debian, linux-x64_bin.deb.

## Aula 04 - Histórico e edições de Java:
Vamos entender um pouco sobre o histórico e edições de Java.

    https://www.coursera.org/articles/what-is-java-used-for

## Aula 05 - JDK / JVM - Máquina Virtual do Java:
Seguir o link para leitura

    https://www.naukri.com/learning/articles/difference-between-jdk-jre-and-jvm/

Basicamente, podemos entender JVM, JRE e JDK da seguinte forma

   JVM $\subset$ JRE $\subset$ JDK

### Definição de JVM
É uma máquina virtual responsável em converter o bytecode para um código de uma máquina específica.

Obs: O JVM é necessário em ambos JDK e JRE.

### Definição de JRE
É um software que tem como definição JVM mais as bibliotecas de classes.

### Definição de JDK
É um software com o ambiente completop para construir aplicações e aparatos para usar a linguagem de programação Java. Em outras palavras, o JDK é um software que possui a definição do JRE mais as ferramentas de desenvolvimentos.

## Aula 06 - Estrutura de uma aplicação Java - Organização da linguagem de programação Java:
O Java é uma linguagem orientada à objetos.

Bom, a ideia de orientação à objetos é o mesmo que eu já estudei em Python e JavaScript. Vale dar uma revisada no meu repositório sobre a tal linguagem ou ler pelo livro, Java: Como programar, 10ª Edição - Paulo Deitel, Harvey Deitel.

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

### Instalando Eclipse no Linux Ubuntu 22.04LTS:
Basta entrar no software e procurar pelo eclipse e instalar. Contato que esteja escrito como a última versão está ótimo!

Eclipse não estava abrindo no 19.04. Formatei o notebook e instalei o 20.04 LTS e após instalar o Eclipse,o mesmo problema: não abria.

Solução: No meu caso era só o pacote java JDK que não estava instalado. Após o instalar,o Eclipse abriu normalmente.

Comando para instalar o JDK pelo Terminal: sudo apt install openjdk-8-jdk

### Criando um novo projeto na minha máquina Linux Ubuntu 22.04:
Bom, vamos entender melhor sobre o workspace que o eclipse cria automaticamente e dela vamos criar o nosso primeiro novo projeto. Esse projeto será focado em algum estudo conceitual, então, não será necessário criar um novo repositório no github para conseguirmos prosseguir com os estudos.

O recomendável é que sempre utilizemos as últimas versões de Java e Eclipse para prosseguirmos com o estudo para que não tenha problema de compatibilidade no meio do processo, pois o conceito, por mais que as versões das tecnologias usadas sejam diferentes, são as mesmas para serem aplicadas.

Bom, a priori quando abrimos o eclipse, no meu caso, ela aponta em "/home/leonardo/eclipse-workspace" que é o apontamento padrão configurado, no momento em que instalamos o eclipse. Porém, isso não significa que não podemos personalizar o apontamento da mesma. Vamos criar uma nova pasta no lugar que o estudante preferir e colocarmos o nome dessa pasta como "curso-java" para começarmos o nosso curso aí dentro.

O menu "welcome" vc pode fechar.

No meu caso, a path ficou o seguinte "/home/leonardo/Documentos/curso-java", e apontado nessa pasta, vamos clicar em "Launch" para que dentro dessa pasta seja criado a pasta ".metadata" (pasa fantasma) para começarmos o nosso estudo.

No caso, dentro desse "workspace" que colocamos como o nome "curso-java", e que o eclipse configurou como padrão "eclipse-workspace", ela serve para vc criar projetos dentro dela de modo que isso fique guardado na memória do ".metadata" donde essa pasta nos ajuda a manter a configuração que colocamos dentro do ecliopse sobre os projetos que são salvos dentro dessa pasta "workspace". Basta dar "ls -la" dentro da pasta "curso-java" para vermos que essa pasta ".metadata" existe.

Se vc quiser ficar alternando entre outros "workspaces" pelo eclipse, basta encontrar o botão "switch workspace".

Vamo agora configurar a perspectiva no eclipse. No caso, vamos realizar o seguinte passo, com o eclipse aberto

    Window -> Perspective -> Open perspective -> Java (default)

Isso é importante, pois o estudante que estiver definindo a mesma perspectiva que a minha ela poderá acompanhar o curso sem muitos problemas.

Cada perspectiva, ela nos oferece a finalidade do que queremos desenvolver banco de dados, git, Java, JavaScript, etc...

Por hora vamos fechar todas as janelas menos o "Package Explore". Então, janelas como "Task List", "Outline", "Problems", "Javadoc" e "Declaration", vamos fechar todas elas.

Qualquer coisa se for necessário abrir novamente, bastaria fazer passo

    Window -> Show view

nela selecionamos a janela que gostaríamos que seja exibida.

Finalmente, vamos criar o nosso primeiro projeto "java".

Em "Package Explore" cliamos em "Create a Java Project". Isso irá abrir uma modal e nela vamos configurar o seguinte

    Project name: exercicios

Em seguida, clicamos no botão "Finish". Se aparecer algum modal perguntando se vc quer criar algum módulo vc clica em "não" ou "Don't create".

Bom, agora, estamos prontos para entrarmos no processo de código.

### Obs:
Na versão antiga do Eclipse, ela não selecionava por padrão a opção de criar o arquivo “module-info.java”, atualmente o Eclipse está deixando essa opção marcada por padrão, e a presença desse arquivo irá gerar problemas no decorrer do curso, então vocês podem simplesmente excluir esse arquivo que tudo irá correr bem.

Vocês também podem desabilitar essa opção quando forem criar outro projeto, conforme a imagem modulo_info-java.png.

Basta desmarcar a opção “Create module-info.java file” ou, simplesmente, quando criar um novo projeto, deleta essa pasta.

### Usuários Windows:
Fala, galera! Tranquilo?

Antes de mais nada, recomendamos que vocês utilizem sempre a versão mais atualizada possível do Windows, ou seja, o Windows 10. Pois diversas tecnologias não dão mais suporte aos Windows 7, 8 ou 8.1, então caso vocês utilizem alguma dessas versões, vocês vão acabar tendo problemas em algum ponto do curso. A recomendação é utilizar o Windows 10.

Venho também dar uma outra dica super rápida porém super importante para todos que irão dar início às atividades do curso no ambiente Windows. O que acontece é que existem duas configurações padrão que vêm ativadas e acabam dificultando ou gerando erros na hora de programar em qualquer ambiente. Vou explicar rapidinho sobre elas e sobre como lidar com isso.

Na programação é super normal utilizar os caminhos absolutos de localizações na sua máquina em diversos momentos. Às vezes você mesmo utiliza, mas em geral as linguagens utilizam ali por debaixo do panos para que possam ser executadas. Esses caminhos são literalmente "c/users/seuNome/pasta" e tudo mais.

O primeiro problema é relacionado a Área de Trabalho, pois em alguns casos ela entra nesse caminho absoluto com seu nome em português, ou seja, com espaços e acentos. E isso acaba gerando erro em diversos ambientes. A forma de se lidar com isso é bem simples, basta criar seu projeto em outra pasta que não seja a Área de Trabalho.

O segundo problema é relacionado ao OneDrive. Nas versões mais recentes do Windows o OneDrive é ativado por padrão e ele acaba deixando todas as pastas e arquivos criados no seu computador como arquivos em nuvem, ao invés de arquivos locais. Isso também acaba gerando erros em alguns ambientes. Para resolver isso é simples, basta desativar o OneDrive para a pasta do seu projeto ou desativar geral mesmo. Você escolhe.

Relacionado a versão do Java que deve ser feito o download, é ideal que seja a versão 12, a qual é a usada pelo professor no decorrer do curso. Porém o curso também pode ser feito com outras versões, de preferência não mais velhas que a versão 12. Desconsiderando a mais nova que é a versão 18, onde infelizmente recebemos alguns relatos de problemas ao fazer o curso com ela, mas tudo indica que é instabilidade dela com a própria IDE usada no curso. O site também teve atualizações e não está como na vídeo aula, então iremos disponibilizar um novo link onde possui as versões do Java.

Link:

    https://www.oracle.com/java/technologies/downloads/archive/

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

Dentro do projeto "exercicio", vamos, agora, criar uma pasta/pacote "fundamentos", com os mesmos passos acima, e vamos criar uma classe com o nome "PrimeiroPrograma". Disso, segue a pasta projeto exercícios que temos nesse curso.
