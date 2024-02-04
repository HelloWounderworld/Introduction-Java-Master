# Seção 22: Java EE - Mapeamento objeto-relacional com JPA / Hibernate:

## Aula 01 - Visão geral do capítulo e Aula 02 - Material de apoio do capítulo:
MATERIAL DE APOIO DO CAPÍTULO

Seja muito bem-vindo(a) ao capítulo Java EE - mapeamento objeto-relacional com JPA / Hibernate!

Aqui você pode baixar o material de apoio usado nas aulas do capítulo, para que você possa aproveitar ao máximo as aulas sem precisar ficar anotando muito.

Grande abraço e bons estudos! Nelio.

Recursos para esta aula

    nivelamento-JPA-Hibernate.pdf

## Aula 03 - Instalação do STS e Postman:
Basta procurar o canal do Youtube

    DevSuperior

Procurar pelo playlist 

    SDS Instalação de ferramentas no Windows

E seguir as instruções do vídeo

    Instalar STS no Windows
    Instalar o Postman para testar API REST

No postman, para a requisição GET, vamos colocar o seguinte link para testarmos se está tudo ok

    viacep.com.br/ws/01001000/json/

Se aparecer um json do tipo

    {
        "cep": "01001-000",
        "logradouro": "Praça da Sé",
        "complemento": "lado ímpar",
        "bairro": "Sé",
        "localidade": "São Paulo",
        "uf": "SP",
        "ibge": "3550308",
        "gia": "1004",
        "ddd": "11",
        "siafi": "7107"
    }

É indicativo de que tudo está funcionando corretamente.

## Aula 04 - Nivelamento JPA / Hibernate - PARTE 1:
Seguir o link do livro sobre

    https://www.amazon.com.br/Patterns-Enterprise-Application-Architecture-Martin/dp/0321127420

Eu tenho ele no drive. Se alguém quiser pode me enviar uma msg.

https://kinsta.com/knowledgebase/xampp-error-apache-shutdown-unexpectedly/

## Aula 05 - Nivelamento JPA / Hibernate - PARTE 2 (Trabalhando com Maven):
Vamos criar um projeto Maven pelo sts que usa o eclipse.

## Aula 06 - Nivelamento JPA / Hibernate - PARTE 3:

# Java Persistence API (JPA) - Leonardo Moura Leitao:

## Aula 01 - Padrões de Persistência:
Existem dois grandes padrões de projetos, são elas:

- Data Mapper - usado pelo JPA:

    Como o nome disse, é um padrão de mapeamento. Bom, a abordagem introdutória está sendo muito superficial, até porque, será o padrão que iremos estudar ao longo do curso. Logo, o fundamento teórico será explicado em momentos importantes.

- Active Record:

    Possui os próprios métodos responsáveis para manusear o banco de dados. O Active Record, infelizmente, não é muito utilizado no JPA, mas é um assunto que vale a pena dar uma pesquisada de forma mais aprofundada.

Basicamente, os dois de cima, são ditas ORM (Object Relational Mapping), que é uma técnica que foi desenvolvida para diminuir a impedância da programação orientada a objetos.

Seguir link de leitura:

    https://pt.wikipedia.org/wiki/Mapeamento_objeto-relacional

    https://medium.com/@matheusflauzino/entenda-orm-active-record-e-data-mapper-9be60da0e799

    https://medium.com/oceanize-geeks/the-active-record-and-data-mappers-of-orm-pattern-eefb8262b7bb

    https://orkhan.gitbook.io/typeorm/docs/active-record-data-mapper

    https://pt.stackoverflow.com/questions/25160/qual-a-diferen%C3%A7a-entre-os-design-patterns-data-mapper-e-active-record

## Aula 02 - Active Record:
Basicamente, para utilizar os recursos do Active Records, será por meio de Herança. Ou seja, quando criamos uma classe no nosso projeto, iremos fazer com que essa classe herde as funcionalidades do Active Records e só aplicamos os seus métodos para realizar as manipulações no banco de dados.

Seguir link de leitura:

    https://guides.rubyonrails.org/active_record_basics.html

    https://en.wikipedia.org/wiki/Active_record_pattern#:~:text=The%20active%20record%20pattern%20is%20an%20approach%20to%20accessing%20data,to%20the%20table%20upon%20save.

    https://calpaterson.com/activerecord.html

    https://ysinjab.medium.com/activerecord-vs-datamapper-in-python-f7f13ffb6774

## Aula 03 - ORM (Object Relational Mapping):
Basicamente, ela serve para mapear as classes que irá ter uma relação direta com o banco de dados.

No caso, o ORM, possui diversas funcionalidades que nos ajuda a mapear as classes, donde os dados que será computado dentro dessa classe será mapeado, automaticamente, em uma tabela de um banco de dados.

Seguir o link de leitura:

    https://www.freecodecamp.org/news/what-is-an-orm-the-meaning-of-object-relational-mapping-database-tools/

    https://stackoverflow.com/questions/1279613/what-is-an-orm-how-does-it-work-and-how-should-i-use-one

## Aula 04 - Aviso sobre a configuração do projeto:
Fala, pessoal. Na próxima aula o professor baixa o Hibernate. No entanto, o site mudou e não está mais como ele mostrou na aula.

Diversas versões mais novas do Hibernate não contém todas as libs necessárias para que o projeto rode normalmente, então, vamos disponibilizar o link para download do Hibernate na mesma versão usada no projeto.

Sugerimos que você baixe a versão disponibilizada no link a seguir: https://sourceforge.net/projects/hibernate/files/hibernate-orm/5.4.8.Final/

Nesse link vocês devem escolher a primeira opção "hibernate-release-5.4.8.Final.zip" e então fazer o procedimento da aula a seguir.

## Aula 05 - Configuração do Projeto - Hibernate:
Vamos configurar o nosso projeto, para isso, iremos criar um projeto diferente com a qual usamos até agora, exercicios.

Vamos criar um novo projeto com o nome "exercicios-jpa" donde, no eclipse, criamos esse projeto no formato "JPA Project".

    New -> Other -> digitar "jpa" -> selecionar JPA Project. -> Colocar o nome "exercicios-jpa" -> clicando em next até chegar na janela "JPA facet" -> Type, selecionar "Disable Library Configuration" -> Finish

Bom, infelizmente, no meu eclipse, essa opção não apareceu de primeira, pois precisaria instalar alguns softwares novos. Caso o mesmo problema esteja acontecendo contigo, sugiro seguir os seguintes dois links que te mostra o que precisa ser baixado no "Install New Software" que fica em "Help", e verificar o que precisa ser instalado para possibilitar que apareça a opção acima

    https://stackoverflow.com/questions/50817803/jpa-tools-menu-missing-from-eclipse

    https://stackoverflow.com/questions/32111999/not-able-to-create-or-convert-a-project-in-to-jpa-project

Bom, basicamente, o motivo de criarmos o novo projeto via "JPA Project" seria que, nela, virá o arquivo persistence.xml.

Assim, como primeiro passo, iremos configurar esse aquivo para conseguirmos preparar o ambiente para começar os estudos do JPA.

Em seguida, criamos a pasta "libs" como foi feito quando enviamos o arquivo .jar, e nela colocamos o mesmo arquivo .jar, que foi feito na aula do JDBC.

Agora, iremos configurar o Hibernate, seguindo a Aula 04, e baixando o arquivo zipado. Depois disso, vamos descompactar o arquivo zip baixado na mesma pasta de downloads. Assim, acessamos o seguinte caminho dessa pasta

    hibernate-release-5.4.8.Final -> lib -> required -> copia e cola todos os arquivos que encontrar dentro dela na pasta "libs"

Agora, no eclipse, na pasta "libs" selecionamos todos os arquivos que encontramos nela e clicamos com o botão direito do mouse e realizamos o seguinte caminho

    Build Path -> Add to Build Path

Feito isso, vemos que todas as bibliotecas foram inclusas dentro do "Referenced Libraries".

Bom, agora, o nosso projeto está configurado. No caso, falta configurarmos o arquivo persistence.xml.

Já a base de dados que iremos usar será o mesmo que foi feito na seção 22 sobre JDBC. Ou seja, iremos usar o banco de dados curso_java.

## Aula 06 - Arquivo persistence.xml:
O arquivo persistence.xml utilizado na aula.

    <?xml version="1.0" encoding="UTF-8"?>
    <persistence version="2.1" 
        xmlns="http://xmlns.jcp.org/xml/ns/persistence"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
        xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd">
        <persistence-unit name="exercicios-jpa">
            <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
            
            <mapping-file>META-INF/consultas.xml</mapping-file>
            
            <properties>
                <property name="javax.persistence.jdbc.driver"
                    value="com.mysql.jdbc.Driver"/>
                <property name="javax.persistence.jdbc.url"
                    value="jdbc:mysql://localhost/curso_java"/>
                <property name="javax.persistence.jdbc.user"
                    value="root"/>
                <property name="javax.persistence.jdbc.password"
                    value="12345678"/>
                
                <property name="hibernate.dialect"
                    value="org.hibernate.dialect.MySQL57Dialect"/>
                <property name="hibernate.show_sql" value="true"/>
                <property name="hibernate.format_sql" value="true"/>
                <property name="hibernate.hbm2ddl.auto" value="update"/>
            </properties>
        </persistence-unit>
    </persistence>

## Aula 07 - persistence.xml:
Bom, a recomendação é que não decore a forma como se configura esse arquivo, pois conseguimos encontrar algo padrão configurado se procurarmos na internet. Logo, é recomendável que se preocupe mais em entender e internalizar/consolidar os conceitos dentro da sua cabeça do que decorar. Programação, assim como matemática, não se faz decorando!! Mas, sim, se faz entendendo e internalizando os conceitos.

Bom, a configuração exemplo temos na aula 06, acima, bastaria configurar a senha que foi definida no MySQL server de vcs!

Feito isso, a parte chata de configuração já passou.

Agora, só falta adicionarmos as classes dentro do persistence.xml, para testarmos se a configuração que realizamos até agora deu certo.

