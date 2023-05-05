# Introdução ao Groovy:

## Aula 01 - Introdução ao Groovy:
Seguir os pdf baixados da secao01.

## Aula 02 - Linguagens de programação na JVM:
Apenas um problema dessa linguagem Java que fica para trás, que é a linguagem de programação Java, que por motivos de retro compatibilidade, não consegue evoluir e nem atender novas formas de produtividade.

Linguagens modernas chamadas de ágeis, dinâmicas, funcionais e com capacidade de meta programação como Ruby, Python e Scala começaram se destacar sobre a velha e antiga linguagem Java (1994).

Bom, visto dessa limitação da linguagem de programação Java, em 2006 foi estrategicamente criado e aprovado uma especificação chamada de "JSR 292 - Da Vinci Machine" responsável por abrir a JVM para ser utilizada com outras linguagens de programação.

A partir disso, a comunidade Java agora tinham a liberdade de escolher qual linguagem de programação usar para escrever suas soluções em Java.

E, por isso, hoje, quem usa JVM, tem a versatilidade de selecionar e ou combinar diferentes tipos de linguagens de programação, atualmente com mais de 240 diferentes linguagens.

    https://medium.com/adlers-blog/linguagens-baseadas-na-jvm-4db31d5bc427
    https://en.wikipedia.org/wiki/List_of_JVM_languages

Em outras palavras, hoje em dia, para vc programar na linguagem Java, não precisa saber programar em Java, mas, sim, das linguagens mais atuais e que estão evoluindo como JavaScript e Python. No caso, o Groovy é uma delas tbm, desde que essa linguagem que vc escolheu já tenha o JSR 292 - Da Vinci Machine já escrito para compilar isso em Java.

Bom, para quem é mais radical, se nenhuma das linguagens para JVM te agradar, vcs tem a opção de criar a sua própria linguagem sobre a JVM. Abaixo são exemplos de algumas empresas que criaram essa linguagem.

    Google = Go - https://go.dev/
    Red Hat = Ceylon - https://en.wikipedia.org/wiki/Ceylon_(programming_language)

Nesse ponto da história, alguns da comunidade estavam começando a pensar em abandonar a plataforma Java em virtude de não ter como usar uma linguagem de programação nova e moderna.

O que certamente não aconteceu.

A partir da JSR 292, foi possível continuar usando a melhor e maior plataformada história e escolher qual linguagem utilizar.

## Aula 03 - Por que usar Groovy?:
Bom, o professor ele deu os seus motivos justos. Porém, no meu caso, eu preciso mais porque o sistema que estou mexendo da empresa Minsait, está inteiramente programado em Groovy.

Criado em 2003, o Groovy, é uma linguagem de programação desenvolvida para a plataforma Java como alternativa à "velha" linguagem de programação tradicional.

Ela foi aprovada pela Java Community Process (JSR 241) como linguagem dinâmica oficial da plataforma Java. A JSR está congelada atualmente.

Atualmente, o Groovy, está sobre Apache License, Version 2.0.

Foi criado com objetivo de fornecer aos programadores Java, todas as características das linguagens modernas chamadas de dinâmicas, funcionais e com capacidades de metaprogramação.

    Groovy = Dinâmica + Funcional + Recursos de Metaprogramação.

Filosofia do Groovy:

    Ser a linguagem de programação Java do século 21, evoluída e acrescida com os determinados recursos modernos que não podem ser adicionados ou alterados na linguagem atual devido a retrocompatibilidade...

    Foi criado por uma comunidade de programadores Java experientes, para programadores Java, com único e exclusivo objetivo de facilitar, melhorar e aumentar a produtividade na atividade de programação cotidiana.

Bom, para quem já tem um nível intermediário em Java, vai entender o motivo de ser mais vantajoso aprender a linguagem de programação Groovy.

- Nenhuma Curva de Aprendizado: Groovy é exatamente a linguagem Java, "acrescida" dos recursos encontradas nestas outras linguagens modernas, ágeis, produtivas, dinâmicas, funcionais e com recursos de metaprogramação.

A curva de aprendizado para um programador Java é extremamente baixa.

- Groovy tem o GDK = JDK + Groovy API: Groovy estende inúmeras api's da JDK padrão acrescentando centenas de recursos e otimização que vão facilitar e aumentar a produtividade em praticamente todas as api's e ou frameworks como, por exemplo: testes, xml, json, io, datas, jdbc,swing, web services, strings, collections, expressão regular, entre muitos outros...

- Novos recursos Groovy: Groovy oferece novos recursos de linguagens que melhoram o paradigma de programação:
    - Pogo's, AST Transformations, Operator Overloading, Builders, Clousures e Metaprogramming.

Veremos cada um deles durante o curso.

- Alta produtividade: Baixa curva de aprendizado + novos recursos oferecidos na linguagem groovy + as facilidades do GDK = programadores Groovy escrevem em torno de 50% a menos de código, elevando exponencialmente a produtividade na entrega de soluções Java.

- Integrar Java e Groovy no mesmo projeto: No mesmo projeto, pode-se criar e usar classes Java ou classes em Groovy. As classes feitas em Java, podem usar objetos de classe feitas em Groovy e vice versa. Compilador "groovyc" compila ambas, não tendo diferença no bytecode java ou groovy. Comece hoje usar groovy em projetos antigos ou aplique groovy em camadas específicas. Use o melhor de cada um, no lugar correto.

## Aula 04 e 05 - Montagem do ambiente de desenvolvimento 1 e 2:
