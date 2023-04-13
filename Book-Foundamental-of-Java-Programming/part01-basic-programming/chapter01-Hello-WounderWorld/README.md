# The Programming Environment for Java

## The Java Virtual Machine (JVM):
Basicamente as definições de JVM, JRE e JDK são subconjuntos de uma à outra. Ou seja, de forma ilustrativa é o seguinte

   JVM $\subset$ JRE $\subset$ JDK

Bom, quero deixar claro ao leitor que as minhas notas aqui não será feito como uma espécie de tradução do livro. Basicamente, o que irei realizar seria deixar claro as definições de cada conceito, pois vejo que é algo que muitos leitores tem de dificuldade de deixar claro na cabeça dela para facilitar o entendimento.

### Definição de JVM (Java Virtual Machine):
Antes de te dar a definição formal, irei te explicar à grosso modo o que é um JVM. Basicamente, o JVM ele é uma espécie de interprete de uma linguagem de baixo nível, chamado bytecode, para a máquina física, Hardware. Ou seja, ela é o que permite a comunicação entre a parte física de um computador (processador, memória ram, hd, etc...) com a parte virtual do computador (softwares em geral). No caso, a comunicação é de dupla via, ou seja, enquanto que podemos processar algum comando por meio físico para o meio virtual, o meio virtual pode processar algum comando e o físico responderá de alguma forma esse comando.

Então, tendo uma noção por cima, vamos, agora, partir para a definição formal.

#### Definição:
O JVM interpreta o código binário Java compilado (chamado bytecode) para um processador de um computador (ou plataforma de Hardware) para possibilitar na execução das instruções de um programa Java.

Uma definição formal mais geral seria.

#### Definição:
Um JVM é uma máquina virtual que garante um computador rodar programas Java, bem como outros programas escritos em outras linguagens que são também compilados para um Java bytecode.

Obs: Existem outras tecnicalidades que estamos usando aqui que não definimos, como bytecode, máquina virtual, etc... Como o foco, no momento, seria entender os conceitos fundamentais que o livro quer nos explicar, entrar em detalhes de bytecodes, VM, ou outras tecnicalidades, não será tão conveniente e pretendo realizar isso somente depois que eu terminar de ler o livro e quiser deixar o contéudo bem mais completo ainda.

### Definição de JRE (Java Running Environment):
Novamente, vamos explicar à grosso modo para facilitar do leitor pegar uma noção da sua ideia para depois partirmos para definição formal. Bom, o JRE tem como funcionalidade o JVM mais as bibliotecas de classes Java (JCL). O que seriam esse complemento à mais?

As bibliotecas de classes Java é um conjunto de bibliotecas dinamicamente carregáveis que o JVM pode chamar no tempo em que ele roda.

Vale ressaltar que o JRE ele depende em grande parte do JVM para o seu funcionamento.

Bom, vamos, agora, para a definição formal do JRE.

#### Definição:
JRE é JVM + JCL.

Seria a definição mais direta e suscinta que podemos ter de JRE.

### Definição de JDK (Java Development Kit):
A grosso modo, o JDK, como o nome já sugere, é um conjuntos de ferramentas que podemos ter que nos permite realizar as aplicações ou construções em linguagem Java. E isso é dependente do Sistema Operacional em que está sendo processado, pois cada Sistema Operacional, por ter a sua particularidade, acaba ficando diferentes os tipos de conjuntos de ferramentas adequadas para operar na linguagem Java. Não é a toa que quando a pessoa vai instalar o Java na máquina dela, os downloads existem para sistemas operacionais Linux, Windows e Mac.

Ou seja, são ferramentas que ajudam a compilar a linguagem Java que você vai aprender nesse livro. Em outras palavras, JDK ele fornece meios para que programas em Java sejam executados e rodados pelo JRE e JVM.

A definição formal de JDK pode ser feita como seguinte.

#### Definição:
JDK é JRE + compilador

Basicamente, é uma implementação de especificações de plataformas Java, na qual inclui compiladores e biblioteca de classes padrões.

Bom, na expectativa de reforçar mais o entendimento, podemos dividir o JDK em duas partes

- Primeira: Gera o componente essencial de Java chamado java.lang

- Segunda: É uma coleção de código recurso que pode ser selecionado e adicionado ao programa Java que está sendo escrito.
