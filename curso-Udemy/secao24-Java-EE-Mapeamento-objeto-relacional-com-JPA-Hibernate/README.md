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

Bom, nessa seção, iremos abordar sobre Hibernate e JPA, porém, ao longo do assunto, é importante que fique claro que o que está sendo manuseado é um Hibernate ou uma JPA. Então, entender a diferença dos dois é importante. Para isso, pedimos para seguir a leitura dos seguintes artigos que explique direito a diferença entre essas duas

    https://www.devmedia.com.br/jpa-e-hibernate-acessando-dados-em-aplicacoes-java/32711#:~:text=Diferen%C3%A7a%20Hibernate%20e%20JPA,interface%20comum%20para%20frameworks%20ORM.

    https://pt.stackoverflow.com/questions/374454/hibernate-e-jpa-s%C3%A3o-a-mesma-coisa

    https://medium.com/@duduxss3/entenda-de-uma-vez-por-todas-jpa-e-hibernate-e2a1237161a9

    https://angeliski.com.br/jpa-e-hibernate-existe-diferenca?x-host=angeliski.com.br

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

## Aula 08 - Entidade Usuário:
Vamos criar um pacote "modelo.basico" dentro da pasta "java" e, dentro desse pacote, criamos a classe "Usuario" e nela iremos testar se a configuração que fizemos, até agora, está certa. Logo, inserimos o seguinte nessa classe

    package modelo.basico;

    public class Usuario {

        private Long id;
        
        private String nome;
        
        private String email;
        
        public Usuario() {
            
        }

        public Usuario(String nome, String email) {
            this.nome = nome;
            this.email = email;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
        
    }

Até agora, não tivemos nenhuma novidade. Bom, finalmente, vamos entrar no uso dos jpas. Logo, realizamos a seguinte inserção

    package modelo.basico;

    import javax.persistence.Entity;
    import javax.persistence.Id;

    @Entity
    public class Usuario {

        @Id
        private Long id;
        
        private String nome;
        
        private String email;
        
        public Usuario() {
            
        }

        public Usuario(String nome, String email) {
            this.nome = nome;
            this.email = email;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
        
    }

Ou seja, o @Entity pelo persistence, ele está dizendo que essa classe inteira será uma tabela e nela será exigido que tenha uma chave de auto-indexação, que é indicado pelo @Id do persistence tbm.

Agora, falta mapearmos essa classe no arquivo persistence.xml, como seguinte

    <?xml version="1.0" encoding="UTF-8"?>
    <persistence version="2.2"
        xmlns="http://xmlns.jcp.org/xml/ns/persistence"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_2.xsd">
        <persistence-unit name="exercicios-jpa">
            <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
            <class>modelo.basico.Usuario</class>
            
            <properties>
                <property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver"/>
                <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/curso_java"/>
                <property name="javax.persistence.jdbc.user" value="root"/>
                <property name="javax.persistence.jdbc.password" value="123456"/>
                
                <property name="hibernate.dialect" value="org.hibernate.dialect.MySQL57Dialect"/>
                <property name="hibernate.show_sql" value="true"/>
                <property name="hibernate.format_sql" value="true"/>
                <property name="hibernate.hbm2ddl.auto" value="update"/>
            </properties>
        </persistence-unit>
    </persistence>

Note que, feito isso, o erro que estava aparecendo na classe, Usuario, desaparaceu.

Basicamente, o que está acontecendo aqui, seria que o @Entity irá criar uma tabela, usuario, e as colunas serão as variáveis indicadas pelo private. As colunas, se vc não especificar pelo @Column, os atributos que foram definidas nessa classe, será assumido uma configuração padrão para aquela coluna.

Se tiver algum atributo dessa classe que não queremos que seja mapeado nas colunas da tabela? Para isso, usamos o @Transient.

Bom, note que, Data Mapper, assim como foi explicado de forma bem breve, ela usa apontamentos para relacionar com a base de dados. No caso, o apontamento, é feito pelo "@".

## Aula 09 - Novo Usuário:
Vamos, agora, inserir, de fato, algum dado dentro da tabela, usuarios, para verificarmos se tudo o que fizemos, até agora, está funcionando direito.

Logo, criamos um novo pacote, teste.basico, e dentro dele criamos a classe, NovoUsuario, e nela inserimos o seguinte

    package teste.basico;

    import javax.persistence.EntityManager;
    import javax.persistence.EntityManagerFactory;
    import javax.persistence.Persistence;

    import modelo.basico.Usuario;

    public class NovoUsuario {

        public static void main(String[] args) {
            
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
            EntityManager em = emf.createEntityManager();
            
            Usuario novoUsuario = new Usuario("Alan Turing", "aturing@likesandwich.com"); 
            novoUsuario.setId(1L);
            em.persist(novoUsuario);
            
            em.close();
            emf.close();
        }
    }

Assim, podemos rodar, pelo primeira vez, e verificarmos se deu certo. Aqui, foi usado uma biblioteca chamado EntityManager e o EntityManagerFactory, donde são dois conjuntos que nos possibilitou a realizar um feito similiar à classe FabricaConexao que foi criado no projeto, exercicios, do pacote, jdbc.

Vale a pena dar uma estudada mais à fundo dessas bibliotecas para melhor fundamentar o conceito de Hibernate em ti.

Bom, no console, vai exibir um monte de mensagens em vermelho, porém, ao olharmos nos Workbench, vamos ver que terá uma tabela nova com o nome, Usuario, e nela conseguimos as três colunas que foi definido pelos atributos. Porém, os valores que colocamos no parâmetro em que instanciamos a classe, Usuario, não estará persistindo...

Motivo disso, deve-se a falta de transação.

Porém, visto que a tabela, Usuario, foi criado no banco de dados, curso_java, significa que a configuração deu certo.

Bom, incluindo o processo de transação na classe, NovoUsuario,

    package teste.basico;

    import javax.persistence.EntityManager;
    import javax.persistence.EntityManagerFactory;
    import javax.persistence.Persistence;

    import modelo.basico.Usuario;

    public class NovoUsuario {

        public static void main(String[] args) {
            
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
            EntityManager em = emf.createEntityManager();
            
            Usuario novoUsuario = new Usuario("Alan Turing", "aturing@likesandwich.com"); 
            novoUsuario.setId(1L);
            
            em.getTransaction().begin();
            em.persist(novoUsuario);
            em.getTransaction().commit();
            
            em.close();
            emf.close();
        }
    }

Analisando pelo Workbench, vimos que foi inserido os dados que foi instanciado na classe, Usuario.

Agora, podemos considerar o atributo, id, da classe/tabele, Usuario, como um auto-incremento usando o apontamento @GeneratedValue(strategy = GenerationType.IDENTITY)

    package modelo.basico;

    import javax.persistence.Entity;
    import javax.persistence.GeneratedValue;
    import javax.persistence.GenerationType;
    import javax.persistence.Id;

    @Entity
    public class Usuario {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        
        private String nome;
        
        private String email;
        
        public Usuario() {
            
        }

        public Usuario(String nome, String email) {
            this.nome = nome;
            this.email = email;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
        
    }

O "IDENTITY" nos ajuda a tornar cada usuário único. Ou, podemos usar tbm "AUTO" para tornar a geração das indexações de forma automática.

Cada vez que inserimos um novo usuário na tabela, Usuario, conseguimos, também, identificar qual id ela foi cadastrada realizando um simples print como seguinte

    package teste.basico;

    import javax.persistence.EntityManager;
    import javax.persistence.EntityManagerFactory;
    import javax.persistence.Persistence;

    import modelo.basico.Usuario;

    public class NovoUsuario {

        public static void main(String[] args) {
            
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
            EntityManager em = emf.createEntityManager();
            
            Usuario novoUsuario = new Usuario("Leonardo Takashi Teramatsu", "leonardo.teramatsu@gmail.com");
    //		Usuario novoUsuario = new Usuario("Albert Einstein", "aeinstein@taradao.com");
    //		Usuario novoUsuario = new Usuario("Stephen Hawking", "shawking@iamsupercomputer.com");
    //		novoUsuario.setId(1L);
            
            em.getTransaction().begin();
            em.persist(novoUsuario);
            em.getTransaction().commit();
            
            System.out.println("O Id gerado foi: " + novoUsuario.getId());
            
            em.close();
            emf.close();
        }
    }

Obs: Sempre que rodamos a query que realiza algo no banco de dados, no console, é exibido a query. Caso vc queira que não seja mais exibido, bastaria alterar o "hibernate.show_sql" para false, do arquivo persistence.xml.

## Aula 10 - Obter Usuário:
Vamos aprender a obter o usuário que foi cadastrado no banco de dados a partir da chave que foi cadastrada nela.

No projeto, exercicios-jpa, do pacote, teste.basico, vamos criar uma classe "ObterUsuario" e nela, por começo, inserimos o seguinte

    package teste.basico;

    import javax.persistence.EntityManager;
    import javax.persistence.EntityManagerFactory;
    import javax.persistence.Persistence;

    public class ObterUsuario {

        public static void main(String[] args) {
            
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
            EntityManager em = emf.createEntityManager();

            em.close();
		    emf.close();
        }
    }

Bom, aqui, não precisamos do "Transaction", pois será realizado apenas uma consulta, que é o select no banco. Logo, inserimos o seguinte

    package teste.basico;

    import javax.persistence.EntityManager;
    import javax.persistence.EntityManagerFactory;
    import javax.persistence.Persistence;

    import modelo.basico.Usuario;

    public class ObterUsuario {

        public static void main(String[] args) {
            
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
            EntityManager em = emf.createEntityManager();
            
            Usuario usuario = em.find(Usuario.class, 1L);
		    System.out.println(usuario.getNome());
            
            em.close();
            emf.close();
        }
    }

Donde, em "find(Coloque a classe, coloque o id do usuário que foi cadastrado na tabela)" para realizamos a busca.

Só com a forma acima, já conseguimos obter o nome do usuário que está indexado pela chave "1".

Note que, quanto mais o grau de abstração aumentamos, menos a necessidade de termos que digitar os comandos sql's para conseguirmos realizar as manipulações necessárias no banco de dados? Basicamente, é o que o Hibernate/JPA nos fornecem de recursos para conseguirmos focar mais na linguagem Java.

Mas, isso não significa que não precisamos entender bem os comandos SQL, pois os recursos que estamos aprendendo aqui faz do comando sql como se estivesse por baixo dos panos, então, quanto mais abstração colocarmos em cima disso, corre o risco da pessoa esquecer do conceitos fundamentais do SQL e acabar não conseguindo realizar algumas manipulações bem robustas na construção do código que beneficia na otimização da performance e manutenção.

E entender bem os conceitos por baixo do pano é a parte mais importante de uma pessoa que trabalha com o BackEnd e Infra-estrutura do sistema, pois são áreas em que exige mais a construção e organização, respectivamente, de códigos e arquiteturas robustas que sejam bem performáticas para garantir que o sistema consiga processar com muita rapidez ao mesmo tempo que a mesma esteja suportando uma carga de usuários enormes, na casa dos milhões. E conseguir realizar isso, só possuindo um conhecimento bem consolidado/internalizado sobre os conceitos de código limpo, arquitetura e infra-estrutura, que é a parte em que o Hibernate e JPA abordam.

Logo, não deixe de estudar direito sobre PL/SQL e os conceitos sobre Design Patterns DAO, Arquitetura limpa e código limpo.

Para quem quiser ser um backEnd de sistemas Java's, entender Hibernate e JPA é mais que uma obrigação!

Não limite somente à esse curso, pois ela nos dará somente uma noção geral do conceito. Vale a pena pegar um livro ou uma boa documentação sobre e ir, por conta própria, debruçando nos estudos até que o conceito fique bem internalizado dentro de ti!

## Aula 11 - Obter Usuários:
Vamos, agora, aprender a obter um conjunto de usuários.

Para isso, no projeto, exercicios-jpa, do pacote, teste.basico, criamos uma nova classe "ObterUsuarios" e nela inserimos o seguinte

    package teste.basico;

    import javax.persistence.EntityManager;
    import javax.persistence.EntityManagerFactory;
    import javax.persistence.Persistence;

    public class ObterUsuarios {

        public static void main(String[] args) {
            
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
            EntityManager em = emf.createEntityManager();
            
            em.close();
            emf.close();
        }
    }

Agora, por começo, vamos realizar a seguinte query

    package teste.basico;

    import javax.persistence.EntityManager;
    import javax.persistence.EntityManagerFactory;
    import javax.persistence.Persistence;

    public class ObterUsuarios {

        public static void main(String[] args) {
            
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
            EntityManager em = emf.createEntityManager();
            
            String jpql = "SELECT u FROM Usuario u";
            
            em.close();
            emf.close();
        }
    }

A query acima, basicamente, em SQL, estamos realizando "SELECT u.* FROM Usuario u", se rodarmos isso no Workbench sobre a base, curso_java, vamos obter todos os usuários dessa tabela. Quem irá converter o comando acima para SQL será o JPA.

Em seguida, vamos definir o tipo de query com a seguinte biblioteca

    package teste.basico;

    import javax.persistence.EntityManager;
    import javax.persistence.EntityManagerFactory;
    import javax.persistence.Persistence;
    import javax.persistence.TypedQuery;

    import modelo.basico.Usuario;

    public class ObterUsuarios {

        public static void main(String[] args) {
            
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
            EntityManager em = emf.createEntityManager();
            
            String jpql = "SELECT u FROM Usuario u";
            TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
            
            em.close();
            emf.close();
        }
    }

Feito isso, finalmente, vamos obter os usuários e coloca-los em uma lista como seguinte

    package teste.basico;

    import java.util.List;

    import javax.persistence.EntityManager;
    import javax.persistence.EntityManagerFactory;
    import javax.persistence.Persistence;
    import javax.persistence.TypedQuery;

    import modelo.basico.Usuario;

    public class ObterUsuarios {

        public static void main(String[] args) {
            
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
            EntityManager em = emf.createEntityManager();
            
            String jpql = "SELECT u FROM Usuario u";
            TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
            query.setMaxResults(5);
            
            List<Usuario> usuarios = query.getResultList();
            
            em.close();
            emf.close();
        }
    }

Agora, feito isso, nos possibilita agora manipular os usuários que foram obtidos do banco. Faremos algo bem simples que é somente printar

    package teste.basico;

    import java.util.List;

    import javax.persistence.EntityManager;
    import javax.persistence.EntityManagerFactory;
    import javax.persistence.Persistence;
    import javax.persistence.TypedQuery;

    import modelo.basico.Usuario;

    public class ObterUsuarios {

        public static void main(String[] args) {
            
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
            EntityManager em = emf.createEntityManager();
            
            String jpql = "SELECT u FROM Usuario u";
            TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
            query.setMaxResults(5);
            
            List<Usuario> usuarios = query.getResultList();
            
            for(Usuario usuario: usuarios) {
                System.out.println("ID: " + usuario.getId() + " Email: " + usuario.getEmail() + " Nome: " + usuario.getNome());
            }
            
            em.close();
            emf.close();
        }
    }

Rodando o código acima, será obtido um número máximo de 5 usuários da tabela Usuario, cujo o limite foi estabelecido pelo "setMaxResults".

Quem conhece e já usou o banco de dados não relacional, provavelmente, perceberá que o código acima, podemos realizar uma busca muito parecida com o que é feito ao usar as linguagens para realizar as chamadas via apontamento. Logo, podemos resumir a consulta acima da seguinte forma

    package teste.basico;

    import java.util.List;

    import javax.persistence.EntityManager;
    import javax.persistence.EntityManagerFactory;
    import javax.persistence.Persistence;
    import javax.persistence.TypedQuery;

    import modelo.basico.Usuario;

    public class ObterUsuarios {

        public static void main(String[] args) {
            
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
            EntityManager em = emf.createEntityManager();
            
            String jpql = "SELECT u FROM Usuario u";
    //		TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
    //		query.setMaxResults(5);
            
    //		List<Usuario> usuarios = query.getResultList();
            
            List<Usuario> usuarios = em
                    .createQuery(jpql, Usuario.class)
                    .setMaxResults(5)
                    .getResultList();
            
            for(Usuario usuario: usuarios) {
                System.out.println("ID: " + usuario.getId() + " Email: " + usuario.getEmail() + " Nome: " + usuario.getNome());
            }
            
            em.close();
            emf.close();
        }
    }

Ou seja, conseguimos realizar a busca concatenando as chamadas.

## Aula 12 - Alterar Usuário #01 - Basico:
Vamos, agora, aprender a realizar uns updates via Hibernate.

No projeto, exercicios-jpa, do pacote, teste.basico, criamos a classe "AlterarUsuario1" e nela inserimos o seguinte

    package teste.basico;

    import javax.persistence.EntityManager;
    import javax.persistence.EntityManagerFactory;
    import javax.persistence.Persistence;

    public class AlterarUsuario1 {

        public static void main(String[] args) {
            
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
            EntityManager em = emf.createEntityManager();
            
            em.close();
            emf.close();
        }
    }

Agora, vamos montar a requisição para atualizar o dado de um usuário.

No caso, o que podemos realizar é o seguinte

    package teste.basico;

    import javax.persistence.EntityManager;
    import javax.persistence.EntityManagerFactory;
    import javax.persistence.Persistence;

    import modelo.basico.Usuario;

    public class AlterarUsuario1 {

        public static void main(String[] args) {
            
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
            EntityManager em = emf.createEntityManager();
            
            em.getTransaction().begin();
            
            Usuario usuario = em.find(Usuario.class, 2L);
            System.out.println(usuario.getEmail());
            usuario.setNome("Erwin Schrodinger");
            usuario.setEmail("eschrodinger@iscatdeadorlive.com");
            
            em.merge(usuario); // update
            
            em.getTransaction().commit();
            
            em.close();
            emf.close();
        }
    }

Bom, rodando o código acima, ao analisarmos o usuaŕio com o id, 2, pelo Workbench na tabela, Usuario, vemos que foi alterado o valor.

## Aula 13 - Alterar Usuário #02 - Cenário Transacional:
Vamos, agora, fazer um segundo exercicio de alterar usuário.

No projeto, exercicios-jpa, do pacote, teste.basico, criamos a classe "AlterarUsuario2" e nela inserimos o seguinte

    package teste.basico;

    import javax.persistence.EntityManager;
    import javax.persistence.EntityManagerFactory;
    import javax.persistence.Persistence;

    import modelo.basico.Usuario;

    public class AlterarUsuario2 {

        public static void main(String[] args) {
            
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
            EntityManager em = emf.createEntityManager();
            
            em.getTransaction().begin();
            
            Usuario usuario = em.find(Usuario.class, 6L);
            System.out.println(usuario.getEmail());
            usuario.setNome("Nikolas Tesla");
            usuario.setEmail("ntesla@idiscoveryandelonmuskjustcopyme.com");
            
            em.merge(usuario); // update
            
            em.getTransaction().commit();
            
            em.close();
            emf.close();
        }
    }

Bom, é o mesmo que está na classe, AlterarUsuario1, e, agora, vamos começar a realizar as alterações em cima desse código. No caso, vamos alterar o dado do usuário, 5, e, desta vez, com o merge comentado

    package teste.basico;

    import javax.persistence.EntityManager;
    import javax.persistence.EntityManagerFactory;
    import javax.persistence.Persistence;

    import modelo.basico.Usuario;

    public class AlterarUsuario2 {

        public static void main(String[] args) {
            
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
            EntityManager em = emf.createEntityManager();
            
            em.getTransaction().begin();
            
            Usuario usuario = em.find(Usuario.class, 5L);
            System.out.println(usuario.getEmail());
            usuario.setNome("Marie Curie - Nome alterado");
            usuario.setEmail("mcurie@iamonlywomantogettwonobelprize.com");
            
    //		em.merge(usuario); // update
            
            em.getTransaction().commit();
            
            em.close();
            emf.close();
        }
    }

Ao rodarmos o código acima e, em seguida, consultarmos no Workbench, vamos ver que foi alterado o usuário com o índice 5. Alterando o "hibernate.show_sql" para true, do arquivo persistence.xml, para verificarmos que tipo de query aconteceu, vamos ver que o update está sendo feito, mesmo com o merge comentado.

Agora, por quê que isso aconteceu?

Basicamente, quando vc fez uma consulta, dentro do contexto transacional, o resultado dessa consulta é dita uma entidade que está no "estado gerenciado". Mas que raios isso significa?

É quando o JPA tem um gerenciamento em cima daquele objeto e, quaisquer mudança que vc realize sobre ela, dentro do contexto transacional, a mudança feita será sincronizado com o banco de dados, mesmo que vc não chame o método merge. Ou seja, qualquer mudança que vc fizer no objeto, uma hora ou outra, o JPA vai pegar esse objeto e vai sincronizar ele com o banco de dados de tal forma que os dados serão atualizados lá no banco de dados.

Blz. Mas, então, se eu tirar o "set" fora da transação?

    package teste.basico;

    import javax.persistence.EntityManager;
    import javax.persistence.EntityManagerFactory;
    import javax.persistence.Persistence;

    import modelo.basico.Usuario;

    public class AlterarUsuario2 {

        public static void main(String[] args) {
            
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
            EntityManager em = emf.createEntityManager();
            
            Usuario usuario = em.find(Usuario.class, 5L);
            System.out.println(usuario.getEmail());
            usuario.setNome("Marie Curie - Alterado");
            usuario.setEmail("mcurie@iamonlywomantogettwonobelprize.com");
            
            em.getTransaction().begin();
            
    //		em.merge(usuario); // update
            
            em.getTransaction().commit();
            
            em.close();
            emf.close();
        }
    }

Se rodarmos o código, de novo, será exibido que foi sim alterado o usuário indicado no banco de dados. Ou seja, indicando que ainda sim está dentro do contexto transacional.

Bom, motivo de ter feito a tal abordagem acima, deve-se, pelo fato, de que existem momentos em que é melhor utilizamos o merge, que faz o update. Em qual momento? Nos momentos não transacionais. Isso será abordado na próxima aula.

As boas práticas indicam que, na maioria das vezes, é essencial que não trabalhemos em cenários transacional

## Aula 14 - Alterar Usuário #03 - Cenário Não Transacional Ideal:
Vamos, agora, abordar uma situação não transacional, para, finalmente, entendermos os momentos certos de utilizarmos o método merge, que é uma outra forma de fazer o update no banco de dados.

Primeiro, precisamos entender o que é um cenário não transacional/não gerenciado.

Para isso, no projeto, execicios-jpa, do pacote, teste.basico, vamos criar uma nova classe "AlterarUsuario3" e nela inserimos o seguinte

    package teste.basico;

    import javax.persistence.EntityManager;
    import javax.persistence.EntityManagerFactory;
    import javax.persistence.Persistence;

    import modelo.basico.Usuario;

    public class AlterarUsuario3 {

        public static void main(String[] args) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
            EntityManager em = emf.createEntityManager();
            
            Usuario usuario = em.find(Usuario.class, 5L);
            System.out.println(usuario.getEmail());
            usuario.setNome("Marie Curie - Alterado");
            usuario.setEmail("mcurie@iamonlywomantogettwonobelprize.com");
            
            em.getTransaction().begin();
            
    //		em.merge(usuario); // update
            
            em.getTransaction().commit();
            
            em.close();
            emf.close();
        }
    }

Basicamente, copiei o que está na classe, AlterarUsuario2, e, em cima disso, realizemos as alterações devidas para falsearmos o cenário não gerenciado.

Bom, o que precisaria ser feito para tirarmos do cenário gerenciado?

Bastaria realizarmos o seguinte

    package teste.basico;

    import javax.persistence.EntityManager;
    import javax.persistence.EntityManagerFactory;
    import javax.persistence.Persistence;

    import modelo.basico.Usuario;

    public class AlterarUsuario3 {

        public static void main(String[] args) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
            EntityManager em = emf.createEntityManager();
            
            em.getTransaction().begin();
            
            Usuario usuario = em.find(Usuario.class, 5L);
    //		System.out.println(usuario.getEmail());
            em.detach(usuario);
            usuario.setNome("Marie Curie - Alterado");
            usuario.setEmail("mcurie@iamonlywomantogettwonobelprize.com");
            
    //		em.merge(usuario); // update
            
            em.getTransaction().commit();
            
            em.close();
            emf.close();
        }
    }

Incluímos o método "detach", isso nos permite tirar do contexto gerenciado. Como prova disso, ao executarmos o código acima, e analisarmos no console, não irá aparecer o processo de update. O que significa que a sincronização com o banco de dados não está sendo feito pelo JPA a acada alteração realizada em cima do objeto. Bom, e isso independe de onde colocamos o "detach", coo seguinte

    package teste.basico;

    import javax.persistence.EntityManager;
    import javax.persistence.EntityManagerFactory;
    import javax.persistence.Persistence;

    import modelo.basico.Usuario;

    public class AlterarUsuario3 {

        public static void main(String[] args) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
            EntityManager em = emf.createEntityManager();
            
            em.getTransaction().begin();
            
            Usuario usuario = em.find(Usuario.class, 5L);
    //		System.out.println(usuario.getEmail());
            usuario.setNome("Marie Curie - Alterado");
            usuario.setEmail("mcurie@iamonlywomantogettwonobelprize.com");
            
            em.detach(usuario);
            
    //		em.merge(usuario); // update
            
            em.getTransaction().commit();
            
            em.close();
            emf.close();
        }
    }

Deixarei para o leitor explorar mais sobre.

Assim, finalmente, o método "merge" ganha a real importância para conseguirmos realizar o update. No caso, descomentando o método "merge" iremos ver que, agora, estará sendo feito o devido update

    package teste.basico;

    import javax.persistence.EntityManager;
    import javax.persistence.EntityManagerFactory;
    import javax.persistence.Persistence;

    import modelo.basico.Usuario;

    public class AlterarUsuario3 {

        public static void main(String[] args) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
            EntityManager em = emf.createEntityManager();
            
            em.getTransaction().begin();
            
            Usuario usuario = em.find(Usuario.class, 5L);
    //		System.out.println(usuario.getEmail());
            usuario.setNome("Marie Curie - Alterado");
            usuario.setEmail("mcurie@iamonlywomantogettwonobelprize.com");
            
            em.detach(usuario);
            
            em.merge(usuario); // update	
            
            em.getTransaction().commit();
            
            em.close();
            emf.close();
        }
    }

Rodando o código acima, vemos que, desta vez, o dado do nome foi alterado no banco de dados.

Bom, agora, vamos comentar o motivo de trabalharmos no cenário não gerencidado/ não transacional se encaixa dentro da política da boa prática. Bom, basicamente, o cenário não gerenciado, nos permite ter mais o controle do momento em que realizamos o update com os dados do banco de dados. Ou seja, o fato de o JPA não estar realizando uma sincronização com o banco de dados a cada mudança no objeto, isso nos fornece mais controle e segurança dos momentos em que queremos, de fato, realizar a atualização de algum dado.

As informações do front-End, por exemplo, são informações em estados não gerenciado e temos mais controle dos momentos em que realizamos a devida atualização dos dados.

## Aula 15 - Remover Usuário:
Vamos, agora, aprender a realizar o remove/delete dos dados usando Hibernate/JPA.

No projeto, exercicios-jpa, do pacote, teste.basico, vamos criar a classe "RemoverUsuario" e nela inserimos o seguinte

    package teste.basico;

    import javax.persistence.EntityManager;
    import javax.persistence.EntityManagerFactory;
    import javax.persistence.Persistence;

    public class RemoverUsuario {

        public static void main(String[] args) {
            
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
            EntityManager em = emf.createEntityManager();
            
            em.close();
            emf.close();
        }
    }

Bom, agora, em seguida, realizemos o seguinte complemento

    package teste.basico;

    import javax.persistence.EntityManager;
    import javax.persistence.EntityManagerFactory;
    import javax.persistence.Persistence;

    import modelo.basico.Usuario;

    public class RemoverUsuario {

        public static void main(String[] args) {
            
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
            EntityManager em = emf.createEntityManager();
            
            Usuario usuario = em.find(Usuario.class, 7L);
            System.out.println(usuario.getEmail());
            
            if(usuario != null) {
                em.getTransaction().begin();
                em.remove(usuario);
                em.getTransaction().commit();
            }
            
            em.close();
            emf.close();
        }
    }

Bom, rodando o código acima, vamos conseguir ver que foi excluído da tabela, Usuario, o dado com o id, 7.

## Aula 16 - Entidade Produto:
Vamos, agora, criar uma outa nova entidade/tabela, Produto.

Para isso, no projeto, exercicios-jpa, do pacote, modelo.basico, vamos criar uma classe "Produto" e nela inserimos o seguinte

    package modelo.basico;

    import javax.persistence.Entity;
    import javax.persistence.Id;

    @Entity
    public class Produto {

        @Id
        private Long id;
        
        private String nome;
        
        private Double preco;

        public Produto() {
            super();
        }
        
        

        public Produto(String nome, Double preco) {
            this.nome = nome;
            this.preco = preco;
        }



        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public Double getPreco() {
            return preco;
        }

        public void setPreco(Double preco) {
            this.preco = preco;
        }
        
        
    }

E no arquivo, persistence.xml, vamos considerar essa classe

    <?xml version="1.0" encoding="UTF-8"?>
    <persistence version="2.2"
        xmlns="http://xmlns.jcp.org/xml/ns/persistence"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_2.xsd">
        <persistence-unit name="exercicios-jpa">
            <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
            <class>modelo.basico.Usuario</class>
            <class>modelo.basico.Produto</class>
            
            <properties>
                <property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver"/>
                <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/curso_java"/>
                <property name="javax.persistence.jdbc.user" value="root"/>
                <property name="javax.persistence.jdbc.password" value="123456"/>
                
                <property name="hibernate.dialect" value="org.hibernate.dialect.MySQL57Dialect"/>
                <property name="hibernate.show_sql" value="false"/>
                <property name="hibernate.format_sql" value="true"/>
                <property name="hibernate.hbm2ddl.auto" value="update"/>
            </properties>
        </persistence-unit>
    </persistence>

A parte curiosa do JPA, é que, até agora, só construímos a entidade, Produto, para ser considerado na base de dados, porém não chegamos ao ponto de instanciarmos essa classe para rodarmos em algum programa. Porém, se compilarmos alguma classe que construímos para termos a entidade, Usuario, o JPA irá considerar tbm essa entidade, Produto, e ao conferirmos no Workbench, veremos que foi criado uma nova tabela nela.

Rodamos a classe "NovoUsuario", e vimos que além de ter sido manipulado a tabela/entidade, Usuario, foi criado a tabela/entidade, Produto.

Se criarmos um novo atributo nessa classe, Produto, e rodarmos, da mesma forma, uma classe qualquer que não instancie essa entidade/tabela/classe, Produto, vamos ver que mesmo assim, a alteração será considerado

    package modelo.basico;

    import javax.persistence.Entity;
    import javax.persistence.Id;

    @Entity // Notação obrigatória para criarmos a entidades na base de dados
    public class Produto {

        @Id
        private Long id;
        
        private String nome;
        
        private String descricao;
        
        private Double preco;

        public Produto() {
            // Se não tivermos esse construtor padrão, o JPA não irá conseguir gerar o Objeto para
            // a base de dados.
            // É pré-requisito termos o construtor padrão para trabalharmos com o JPA.
        }
        
        

        public Produto(String nome, Double preco) {
            this.nome = nome;
            this.preco = preco;
        }



        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public Double getPreco() {
            return preco;
        }

        public void setPreco(Double preco) {
            this.preco = preco;
        }
        
        
    }

Colocamos um novo atributo acima, descricao, e rodamos a classe, NovoUsuario, e vimos que foi feito um alter table na tabela/entidade/classe, Produto, e podemos conferir isso pelo Workbench.

Bom, vamos, agora, inserir mais alguns conceitos novos para aprendermos sobre JPA. Na classe, Produto, vamos colocar o seguinte apontamento, @Table, como seguinte

    package modelo.basico;

    import javax.persistence.Entity;
    import javax.persistence.Id;
    import javax.persistence.Table;

    @Entity // Notação obrigatória para criarmos a entidades na base de dados
    @Table(name = "produtos")
    public class Produto {

        @Id
        private Long id;
        
        private String nome;
        
        private String descricao;
        
        private Double preco;

        public Produto() {
            // Se não tivermos esse construtor padrão, o JPA não irá conseguir gerar o Objeto para
            // a base de dados.
            // É pré-requisito termos o construtor padrão para trabalharmos com o JPA.
        }
        
        

        public Produto(String nome, Double preco) {
            this.nome = nome;
            this.preco = preco;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }
        
        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public Double getPreco() {
            return preco;
        }

        public void setPreco(Double preco) {
            this.preco = preco;
        }
        
        
    }

No caso, o @Table, que fizemos acima, definimos um nome personalizado para a tabela que será criado considerando a classe, Produto.

Agora, lembra que aos atributos que configuram as colunas da tabela, foi dito que se vc não colocar nenhuma restrição, em sua criação, é considerado um valor padrão sobre elas? Então, vamos, agora, personalizar as configurações de cada coluna como seguinte

    package modelo.basico;

    import javax.persistence.Column;
    import javax.persistence.Entity;
    import javax.persistence.GeneratedValue;
    import javax.persistence.GenerationType;
    import javax.persistence.Id;
    import javax.persistence.Table;

    @Entity // Notação obrigatória para criarmos a entidades na base de dados
    @Table(name = "produtos")
    public class Produto {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        
        @Column(name = "prod_nome", length = 200, nullable = false)
        private String nome;
        
        @Column(name = "prod_preco", nullable = false, precision = 11, scale = 2)
        private Double preco;

        public Produto() {
            // Se não tivermos esse construtor padrão, o JPA não irá conseguir gerar o Objeto para
            // a base de dados.
            // É pré-requisito termos o construtor padrão para trabalharmos com o JPA.
        }

        public Produto(String nome, Double preco) {
            this.nome = nome;
            this.preco = preco;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public Double getPreco() {
            return preco;
        }

        public void setPreco(Double preco) {
            this.preco = preco;
        }
        
        
    }

No caso, no atributo "nome", definimos a sintaxe @Column e, nela, definimos a estrutura que queremos. Basicamente, traduzido à linguagem SQL, o que foi definido para o atributo, nome, seria um VARCHAR(200), NOT NULL, com o nome da coluna "prod_nome". Analogamente, vale a mesma coisa para o outro atributo, preco.

Podemos, também, definir o esquema para essa entidade, também. Ou seja, em outras palavras, estou dizendo à quem essa entidade irá apenas servi-la. Pois, essa classe/entidade/tabela, Produto, eu poderia muito bem trocar as configurações de conexão do banco de dados e, a partir do momento em que eu rodar qualquer outra classe, nesse outro banco de dados, conseguir criar essa mesma entidade também. Existem inúmeros cenários em que isso é indesejado, pois poderia deixar sujeiras no banco de dados. Para evitar que isso aconteça, acrescentamos, dentro do @Table, o "schema" para conseguirmos definir para qual base de dados, essa entidade, apenas, servirá

    package modelo.basico;

    import javax.persistence.Column;
    import javax.persistence.Entity;
    import javax.persistence.GeneratedValue;
    import javax.persistence.GenerationType;
    import javax.persistence.Id;
    import javax.persistence.Table;

    @Entity // Notação obrigatória para criarmos a entidades na base de dados
    @Table(name = "produtos", schema = "curso_java")
    public class Produto {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        
        @Column(name = "prod_nome", length = 200, nullable = false)
        private String nome;
        
        @Column(name = "prod_preco", nullable = false, precision = 11, scale = 2)
        private Double preco;

        public Produto() {
            // Se não tivermos esse construtor padrão, o JPA não irá conseguir gerar o Objeto para
            // a base de dados.
            // É pré-requisito termos o construtor padrão para trabalharmos com o JPA.
        }
        
        

        public Produto(String nome, Double preco) {
            this.nome = nome;
            this.preco = preco;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public Double getPreco() {
            return preco;
        }

        public void setPreco(Double preco) {
            this.preco = preco;
        }
        
        
    }

esquematizamos para a base "curso_java".

O que foi feito acima, é o mesmo que realizarmos o seguinte em SQL

    SELECT * FROM curso_java.Produto;

Porém, nas boas práticas, não é o recomendado a ser feito o uso de "schema", motivo disso, seria que esse feito é possível, de forma mais flexível ainda, usando o EntityManager. O uso do "schema", está mais conveniente, quando queremos fixar a entidade, somente para aquela base de dados para realizar a manipulação. Ou seja, garantir a unicidade de algum conjunto de dados. Na maioria das vezes, esse apontamento, resolvemos via EntityManager e nas unidades de persistencias, persistence unity, de forma mais flexível.

Bom, novamente, vamos rodar uma classe, ObterUsuario, para que criemos a tabela, produtos, por osmose.

Analisando no Workbench, vimos que temos uma nova tabela, produtos, com as colunas customizadas de acordo como definimos via @Column.

## Aula 17 - DAO (Data Access Object):
Vamos criar um DAO no projeto, exercicios-jpa. Até agora, nas classes que criamos para manipularmos as entidades que criamos, os métodos que aplicamos para o EntityManager e EntityManagerFactory, foram todas diretamente dos métodos de infra-estrutura. O que, nas boas práticas de organização dos códigos é ruim, pois misturamos os códigos de infra-estrutura com os códigos de regra de negócio. Logo, vamos aplicar os conceitos de padrão DAO para melhorarmos na organização do ponto de vista de arquitetura.

Para isso, vamos criar um novo pacote chamado "infra" e nela iremos criar as classes que será feito os encapsulamento.

Então, dentro desse pacote, criamos uma classe "DAO" e nela iremos inserir o seguinte

    package infra;

    import java.util.List;

    import javax.persistence.EntityManager;
    import javax.persistence.EntityManagerFactory;
    import javax.persistence.Persistence;
    import javax.persistence.TypedQuery;

    public class DAO<E> {

        private static EntityManagerFactory emf;
        private EntityManager em;
        private Class<E> classe;
        
        static {
            try {
                emf = Persistence.createEntityManagerFactory("exercicios-jpa");
            } catch(Exception e) {
                // logar -> log4j
            }
        }
        
        public DAO() {
            this(null);
        }
        
        public DAO(Class<E> classe) {
            this.classe = classe;
            em = emf.createEntityManager();
        }
        
        public DAO<E> abrirT() {
            em.getTransaction().begin();
            return this;
        }
        
        public DAO<E> fecharT() {
            em.getTransaction().commit();
            return this;
        }
        
        public DAO<E> incluir(E entidade) {
            em.persist(entidade);
            return this;
        }
        
        public DAO<E> incluirAtomico(E entidade) {
            return this.abrirT().incluir(entidade).fecharT();
        }
        
        public List<E> obterTodos() {
            return this.obterTodos(10, 0);
        }
        
        public List<E> obterTodos(int qtde, int deslocamento) {
            if(classe == null) {
                throw new UnsupportedOperationException("Classe nula.");
            }
            
            String jpql = "select e from " + classe.getName() + " e";
            TypedQuery<E> query = em.createQuery(jpql, classe);
            query.setMaxResults(qtde);
            query.setFirstResult(deslocamento);
            return query.getResultList();
        }
        
        public void fechar() {
            em.close();
        }
    }

Note que, dentro dessa classe, pegamos os métodos de infra-estrutura que utilizamos de forma direta nas outras abordagens anteriores e encapsulamos-as de forma generalizada, para conseguirmos realizar o uso dessas em códigos voltados para regra de negócio. Ou seja, separamos os códigos de infra-estrutura com códigos de regra de negócios com essa classe.

Agora em diante, sempre que criarmos alguma classe que utilize as entidades, não iremos mais chamar o EntityManager e nem o EntityManagerFactory. Chamaremos o DAO, pois os métodos que criamos nela, será voltado para códigos de regra de negócios.

Bom, recomendamos que vc procure entender mais sobre esse padrão DAO, pois, para segurança de sistemas e arquiteturas robustas, o entendimento disso te ajudará a melhorar a qualidades dos dois conceitos mencionados.

## Aula 18 - Novo Produto:
Vamos, agora, criar um novo produto.

No caso, desta vez, usando o padrão DAO da classe, DAO, que criamos na última aula, deixando claro que estaremos usando somente código voltado para regra de negócios.

Logo, do projeto, exercicios-jpa, do pacote, teste.basico, vamos criar a clase "NovoProduto" e inserimos o seguinte

    package teste.basico;

    import infra.DAO;
    import modelo.basico.Produto;

    public class NovoProduto {

        public static void main(String[] args) {
            
            Produto produto = new Produto("Caneta", 7.45);
            
            DAO<Produto> dao = new DAO<>(Produto.class);
            dao.abrirT().incluir(produto).fecharT();
        }
    }

Note que, não vamos mais precisar importar o "EntityManager" e nem o "EntityManagerFactory", que são bibliotecas importantes e que, nelas, contém os métodos que esteja ligado diretamente com a infra?

Basta rodar o código acima que iremos conseguir incluir o produto.

Analisando no Workbench, conseguimos constatar nela que temos a tabela, produtos, e dentro dela, temos a "Caneta" com o preço "7.45" cadastrado.

Bom, vamos, agora, testar outros métodos que encapsulamos dos métodos de infra, EntityManager e EntityManagerFactory, para verificarmos que está funcionando devidamente como queremos. Inserimos o seguinte código na classe, NovoProduto, como segue

    package teste.basico;

    import infra.DAO;
    import modelo.basico.Produto;

    public class NovoProduto {

        public static void main(String[] args) {
            
            Produto produto = new Produto("Caneta", 7.45);
            
            DAO<Produto> dao = new DAO<>(Produto.class);
            dao.abrirT().incluir(produto).fecharT();
            
            Produto produto2 = new Produto("Notebook", 22000.00);
            
            DAO<Produto> dao2 = new DAO<>(Produto.class);
            dao2.incluirAtomico(produto2).fechar();
        }
    }

Vamos ver se esse método realiza todo o processo de inclusão considerando as transação como havíamos codado na classe, DAO.

Vimos que foi incluído o dado, Notebook, que colocamos dentro da classe/entidade/tabela, Produto.

Vamos incluir só mais um dado na tabela, produtos

        package teste.basico;

    import infra.DAO;
    import modelo.basico.Produto;

    public class NovoProduto {

        public static void main(String[] args) {
            
    //		Produto produto = new Produto("Caneta", 7.45);
    //		
    //		DAO<Produto> dao = new DAO<>(Produto.class);
    //		dao.abrirT().incluir(produto).fecharT();
            
    //		Produto produto2 = new Produto("Notebook", 22000.00);
    //		
    //		DAO<Produto> dao2 = new DAO<>(Produto.class);
    //		dao2.incluirAtomico(produto2).fechar();
            
            Produto produto3 = new Produto("Monitor 27 polegadas", 1498.59);
            
            DAO<Produto> dao3 = new DAO<>(Produto.class);
            dao3.incluirAtomico(produto3).fechar();
        }
    }

Rodando o código acima, vamos conseguir realizar a inclusão atômica.

## Aula 19 - Obter Produto:
Vamos, agora, aprender a consultar os produtos usando a classe encapsulada, DAO.

Desta vez, vamos fazer um pouco diferente. No caso, vamos criar uma classe, ProdutoDAO, dentro do pacote, infra, do projeto, exercicios-jpa, e estabelecemos uma herança dessa classe com a classe, DAO, mas, referenciando a entidade, Produto, como seguinte

    package infra;

    import modelo.basico.Produto;

    public class ProdutoDAO extends DAO<Produto>{

        public ProdutoDAO() {
            super(Produto.class);
        }
    }

Em seguida, no pacote, teste.basico, do mesmo projeto, criamos uma classe, ObterProdutos, e nela realizamos o seguinte

    package teste.basico;

    import java.util.List;

    import infra.ProdutoDAO;
    import modelo.basico.Produto;

    public class ObterProdutos {

        public static void main(String[] args) {
            
            ProdutoDAO dao = new ProdutoDAO();
            List<Produto> produtos = dao.obterTodos();
            
            for(Produto produto: produtos) {
                System.out.println("ID: " + produto.getId() + ", Nome: " + produto.getNome());
            }
        }
    }

Rodando o código acima, note que, conseguirmos exibir todos os produtos que foi cadastrado na base, curso_java, da tabela, produtos, donde conseguimos acessar os métodos da classe, DAO, que o ProdutoDAO herdou.

Além disso, conseguimos, também, manipular tais dados para o uso como seguinte

    package teste.basico;

    import java.util.List;

    import infra.ProdutoDAO;
    import modelo.basico.Produto;

    public class ObterProdutos {

        public static void main(String[] args) {
            
            ProdutoDAO dao = new ProdutoDAO();
            List<Produto> produtos = dao.obterTodos();
            
            for(Produto produto: produtos) {
                System.out.println("ID: " + produto.getId() + ", Nome: " + produto.getNome());
            }
            
            double precoTotal = produtos
                    .stream()
                    .map(p -> p.getPreco())
                    .reduce(0.0, (t, p) -> t + p)
                    .doubleValue();
            System.out.println("O valor total é R$ " + precoTotal);

            dao.fechar();
        }
    }

Ou seja, obtemos a soma total dos produtos.

## Aula 20 - Relacionamentos:
Existem dois tipos de relacionamentos:

- OO - Orientação ao Objeto:

    Temos as relações um para um, um para muitos e muitos para muitos: @OneToOne, @OneToMany/@ManyToOne, @ManyToMany 

    Seguir link de leitura:

        https://maryclaired.medium.com/modeling-one-to-many-and-many-to-many-relationships-in-ruby-105e1dfa2af1
        https://medium.com/@bindubc/association-aggregation-and-composition-in-oops-8d260854a446
        https://stackoverflow.com/questions/2780982/many-to-many-relationship-in-oop

- E/R - Entidade/Relacionamento:

    Basicamente, está atrelado ao relacionamento entre tabelas por meio do Primary Key e Foreign Key. No caso, isso é um conceito voltado ao banco de dados, donde vc consegue estudar via à algum livro ou curso sobre banco de dados. No caso, a nível mais avançado, os tipos de relacionamentos, em banco de dados, acaba sendo um fator mais importante quando configura uma arquitura mais robusta.

    Seguir link de leitura:

        https://blog.supportgroup.com/getting-started-with-relational-databases-one-to-one-and-many-to-many-relationships
        https://www.quora.com/Can-you-explain-the-differences-between-one-to-many-one-to-one-and-many-to-many-relationships-in-databases

## Aula 21 - Um Pra Um - One to One #01:
Vamos, primeiro, aprender a relação um para um.

No projeto, exercicios-jpa, do pacote, modelo.umpraum, vamos criar a classe, Assento, e nela inserimos o seguinte

    package teste.umpraum;

    import javax.persistence.Entity;
    import javax.persistence.GeneratedValue;
    import javax.persistence.GenerationType;
    import javax.persistence.Id;
    import javax.persistence.Table;

    @Entity
    @Table(name = "assentos")
    public class Assento {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
            
        private String nome;
    }

E, no mesmo pacote, criamos uma classe, Cliente, e nela, colocamos o seguinte

    package teste.umpraum;

    import javax.persistence.Entity;
    import javax.persistence.GeneratedValue;
    import javax.persistence.GenerationType;
    import javax.persistence.Id;
    import javax.persistence.Table;

    @Entity
    @Table(name = "clientes")
    public class Cliente {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
            
        private String nome;
    }

Claro, no arquivo, persistence.xml, precisamos considerar essas classes para conseguirmos criar a entidade na base de dados, curso_java.

    <?xml version="1.0" encoding="UTF-8"?>
    <persistence version="2.2"
        xmlns="http://xmlns.jcp.org/xml/ns/persistence"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_2.xsd">
        <persistence-unit name="exercicios-jpa">
            <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
            <class>modelo.basico.Usuario</class>
            <class>modelo.basico.Produto</class>
            <class>modelo.umpraum.Cliente</class>
            <class>modelo.umpraum.Assento</class>
            
            <properties>
                <property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver"/>
                <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/curso_java"/>
                <property name="javax.persistence.jdbc.user" value="root"/>
                <property name="javax.persistence.jdbc.password" value="123456"/>
                
                <property name="hibernate.dialect" value="org.hibernate.dialect.MySQL57Dialect"/>
                <property name="hibernate.show_sql" value="true"/>
                <property name="hibernate.format_sql" value="true"/>
                <property name="hibernate.hbm2ddl.auto" value="update"/>
            </properties>
        </persistence-unit>
    </persistence>

Agora, sim, vamos criar os relacionamentos entre essas duas bases para ficar mais claro o conceito na prática. No caso, vamos criar o relacionamento, um para um. Basta realizar o seguinte, visto que criaremos o relacionamento de Assento para Cliente, na classe, Cliente, inserimos

    package modelo.umpraum;

    import javax.persistence.Entity;
    import javax.persistence.GeneratedValue;
    import javax.persistence.GenerationType;
    import javax.persistence.Id;
    import javax.persistence.OneToOne;
    import javax.persistence.Table;

    @Entity
    @Table(name = "clientes")
    public class Cliente {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
            
        private String nome;
        
        @OneToOne
        private Assento assento;
    }

Agora, na classe, Assento, realizamos o seguinte

    package modelo.umpraum;

    import javax.persistence.Entity;
    import javax.persistence.GeneratedValue;
    import javax.persistence.GenerationType;
    import javax.persistence.Id;
    import javax.persistence.Table;

    @Entity
    @Table(name = "assentos")
    public class Assento {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
            
        private String nome;

        public Assento() {
            
        }

        public Assento(String nome) {
            this.nome = nome;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }
    }

Faremos a mesma coisa para a classe, Cliente, como segue

    package modelo.umpraum;

    import javax.persistence.Entity;
    import javax.persistence.GeneratedValue;
    import javax.persistence.GenerationType;
    import javax.persistence.Id;
    import javax.persistence.OneToOne;
    import javax.persistence.Table;

    @Entity
    @Table(name = "clientes")
    public class Cliente {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
            
        private String nome;
        
        @OneToOne
        private Assento assento;
        
        public Cliente() {
            
        }

        public Cliente(String nome, Assento assento) {
            super();
            this.nome = nome;
            this.assento = assento;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public Assento getAssento() {
            return assento;
        }

        public void setAssento(Assento assento) {
            this.assento = assento;
        }
    }

Agora, criamos um pacote com o nome "teste.umpraum" e nela criamos a classe, NovoClienteAssento1, e inserimos o seguinte

    package teste.umpraum;

    import infra.DAO;
    import modelo.umpraum.Assento;
    import modelo.umpraum.Cliente;

    public class NovoClienteAssento1 {

        public static void main(String[] args) {
            
            Assento assento = new Assento("16C");
            Cliente cliente = new Cliente("Ana", assento);
            
            DAO<Object> dao = new DAO<>();
            
            dao.abrirT()
                .incluir(assento)
                .incluir(cliente)
                .fecharT()
                .fechar();
        }
    }

Assim, ao rodarmos o código acima, pelo Workbench, consultamos a base, curso_java, e vemos que nela foi criado duas tabelas, assentos e clientes, donde foi computado nelas os dados que colocamos acima.

Note que, o processo de inclusão acima, não podemos realizar de forma separada, no sentido de incluir, primeiro, o cliente e em seguida, assento, isso em duas transações diferentes

    package teste.umpraum;

    import infra.DAO;
    import modelo.umpraum.Assento;
    import modelo.umpraum.Cliente;

    public class NovoClienteAssento1 {

        public static void main(String[] args) {
            
            Assento assento = new Assento("8C");
            Cliente cliente = new Cliente("Carlos", assento);
            
            DAO<Object> dao = new DAO<>();
            
            dao.abrirT()
                .incluir(assento)
                .incluir(cliente)
                .fecharT()
                .fechar();
            
            // Dará um problema
            dao.abrirT()
                .incluir(cliente)
                .fecharT()
                .fechar();
            dao.abrirT()
                .incluir(assento)
                .fecharT()
                .fechar();
        }
    }

Isso é devido ao fato de o cliente estar no estado transiente e não salvo, o que não podemos salvar o assento. Seria como uma função definida e vc querer pegar um elemento na imagem da função sem o argumento estabelecido para ele. Agora, o cenário acima, o inverso, caso colocamos o assento primeiro e em seguida o cliente, vamos conseguir definir o assento, mas, não, o cliente.

Basicamente, visto a maneira como foi estabelecida a relação, um para um, donde foi apontado do Assento para o Cliente, então, precisamos, primeiro, definir o assento e incluir na base, para depois considerar o cliente e a transação precisaria ser algo mútua.

No formato em que estabelecemos a relação entre Assento e Cliente, imaginando os assentos de cinema, o ideal seria que cada um dos assentos fosse algo único para cada cliente. Ou seja, não podemos apontar um primary key para dois foreign key. Entretanto, no formato da relação, mesmo que um para um, se inserirmos algum cliente novo para um assento que já possua algum dono, será possível, como seguinte, rodando a query direto no Workbench

    INSERT INTO clientes (nome, assento_id) VALUES ("Joker", 1);

Ou seja, o assento "16C" já está direcionado ao cliente "Ana", mas se rodarmos o código acima, vamos ver que conseguimos incluir o cliente "Joker", para o mesmo assento da "Ana".

Bom, para contornarmos esse tipo de problema, na classe, Cliente, podemos realizar o seguinte, usando o @JoinColumn

    package modelo.umpraum;

    import javax.persistence.Entity;
    import javax.persistence.GeneratedValue;
    import javax.persistence.GenerationType;
    import javax.persistence.Id;
    import javax.persistence.JoinColumn;
    import javax.persistence.OneToOne;
    import javax.persistence.Table;

    @Entity
    @Table(name = "clientes")
    public class Cliente {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
            
        private String nome;
        
        @OneToOne
        @JoinColumn(name = "assento_id", unique = true)
        private Assento assento;
        
        public Cliente() {
            
        }

        public Cliente(String nome, Assento assento) {
            super();
            this.nome = nome;
            this.assento = assento;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public Assento getAssento() {
            return assento;
        }

        public void setAssento(Assento assento) {
            this.assento = assento;
        }
    }

Vamos primeiro dropar as tabelas, assentos e clientes, para realizamos o processo tudo do zero. Feito isso, vamos tentar inserir novamente os dados na tabela

    package teste.umpraum;

    import infra.DAO;
    import modelo.umpraum.Assento;
    import modelo.umpraum.Cliente;

    public class NovoClienteAssento1 {

        public static void main(String[] args) {
            
            Assento assento = new Assento("23F");
            Cliente cliente = new Cliente("Vegeta", assento);
            
            DAO<Object> dao = new DAO<>();
            
            dao.abrirT()
                .incluir(assento)
                .incluir(cliente)
                .fecharT()
                .fechar();
            
            // Dará um problema
    //		dao.abrirT()
    //			.incluir(cliente)
    //			.fecharT()
    //			.fechar();
    //		dao.abrirT()
    //			.incluir(assento)
    //			.fecharT()
    //			.fechar();
        }
    }

Agora, rodando, novamente, o insert

    INSERT INTO clientes (nome, assento_id) VALUES ("Joker", 1);

Vamos ver que, desta vez, não conseguiremos incluir esse dado na tabela.

## Aula 22 - Um Pra Um #02:
Vamos, agora, aprender a sincronizar as inclusões. Ou seja, visto que temos duas tabelas relacionadas, quando ocorrer alguma ação em uma, a tal ação reflita no outro tbm.

Dentro do pacote, teste.umpraum, criamos a classe, NovoClienteAssento2, e nela inserimos o seguinte

    package teste.umpraum;

    import infra.DAO;
    import modelo.umpraum.Assento;
    import modelo.umpraum.Cliente;

    public class NovoClienteAssento2 {

        public static void main(String[] args) {
            
            Assento assento = new Assento("4D");
            Cliente cliente = new Cliente("Rodrigo", assento);
            
            DAO<Cliente> dao = new DAO<>(Cliente.class);
            dao.incluirAtomico(cliente);
        }
    }

Se rodarmos o código acima, teremos um problema, pois, visto que o Cliente está relacionado com a classe Assento, então teremos um problema de transação.

No caso, o que queremos aqui seria que, no momento em que estivemos incluindo um cliente, que incluímos um assento também. Para contornarmos esse tipo de problema, queremos que seja realizado o seguinte na classe, Cliente

    package modelo.umpraum;

    import javax.persistence.CascadeType;
    import javax.persistence.Entity;
    import javax.persistence.GeneratedValue;
    import javax.persistence.GenerationType;
    import javax.persistence.Id;
    import javax.persistence.JoinColumn;
    import javax.persistence.OneToOne;
    import javax.persistence.Table;

    @Entity
    @Table(name = "clientes")
    public class Cliente {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
            
        private String nome;
        
        @OneToOne(cascade = CascadeType.PERSIST)
        @JoinColumn(name = "assento_id", unique = true)
        private Assento assento;
        
        public Cliente() {
            
        }

        public Cliente(String nome, Assento assento) {
            super();
            this.nome = nome;
            this.assento = assento;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public Assento getAssento() {
            return assento;
        }

        public void setAssento(Assento assento) {
            this.assento = assento;
        }
    }

Ou seja, em @OneToOne, iremos colocar o cascade, donde declaramos alguma operação em cascata. Ou seja, alguma ação ocorrida por via do cliente, refletirá na classe Assento tbm.

Assim, rodando, novamente, o código

    package teste.umpraum;

    import infra.DAO;
    import modelo.umpraum.Assento;
    import modelo.umpraum.Cliente;

    public class NovoClienteAssento2 {

        public static void main(String[] args) {
            
            Assento assento = new Assento("4D");
            Cliente cliente = new Cliente("Rodrigo", assento);
            
            DAO<Cliente> dao = new DAO<>(Cliente.class);
            dao.incluirAtomico(cliente);
        }
    }

Vamos ver que, agora, a mudança persistiu.

Isso é uma das formas de conseguirmos incluir o processo de automatização em nível alto, pois, vimos que não tivemos a necessidade de gerar algum código SQL e só usando os apontamentos, Data Mapper, nos permitiu realizar tais feitos em poucos passos.

## Aula 23 - Um Pra Um #03:
Vamos, agora, realizar uma pequena alteração do exercício que fizemos na última aula.

Vimos, até agora, que o relacionamento uma para um entre as classes, Assento e Cliente, foi algo unidirecional. Ou seja, de Assento apontando para o Cliente. Porém, agora, iremos fazer algumas mudanças para que o tal relacionamento, definitivamente, torne algo bidirecional.

Bom, para estabelecermos esse relacionamento bidirecional é bem simples. Para que a classe, Cliente, estabeleça um relacionamento uma para um com a classe, Assento, foi o suficiente, colocarmos @OneToOne na classe Cliente e nela definirmos um atributo chamando a classe Assento. Para estabelecermos a relação bidirecional, por fim, será necessário realizarmos algo parecido para a classe, Assento. Logo, realizamos o seguinte

    package modelo.umpraum;

    import javax.persistence.Entity;
    import javax.persistence.GeneratedValue;
    import javax.persistence.GenerationType;
    import javax.persistence.Id;
    import javax.persistence.OneToOne;
    import javax.persistence.Table;

    @Entity
    @Table(name = "assentos")
    public class Assento {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
            
        private String nome;
        
        @OneToOne
        private Cliente cliente;

        public Assento() {
            
        }

        public Assento(String nome) {
            this.nome = nome;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public Cliente getCliente() {
            return cliente;
        }

        public void setCliente(Cliente cliente) {
            this.cliente = cliente;
        }
    }

Bom, somente com a forma como está acima, iremos estabelecer uma relação bidirecional, porém, não da forma que entra dentro das boas práticas, pois dão margem de haver alguma inconsistência de dados. No caso, além do apontamento que realizamos acima, vamos precisar dizer à classe que esse apontamento é advinda de uma classe já mapeado. Usamos o "mappedBy" como seguinte

    package modelo.umpraum;

    import javax.persistence.Entity;
    import javax.persistence.GeneratedValue;
    import javax.persistence.GenerationType;
    import javax.persistence.Id;
    import javax.persistence.OneToOne;
    import javax.persistence.Table;

    @Entity
    @Table(name = "assentos")
    public class Assento {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
            
        private String nome;
        
        @OneToOne(mappedBy = "assento")
        private Cliente cliente;

        public Assento() {
            
        }

        public Assento(String nome) {
            this.nome = nome;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public Cliente getCliente() {
            return cliente;
        }

        public void setCliente(Cliente cliente) {
            this.cliente = cliente;
        }
    }

Basicamente, o que está sendo dito pelo "mappedBy" seria que a relação um para um já foi estabelecida na classe Cliente, em relação à classe Assento. A relação um para um está mapeado pelo atributo assento dentro da classe Cliente.

Para conferirmos a validade disso, vamos criar uma nova classe, ObterClienteAssento, no pacote, teste.umpraum, do projeto, exercicios-jpa, e nela inserimos o seguinte

    package teste.umpraum;

    import infra.DAO;
    import modelo.umpraum.Cliente;

    public class ObterClienteAssento {

        public static void main(String[] args) {
            
            DAO<Cliente> dao = new DAO<>(Cliente.class);
            
        }
    }

Agora, na classe, DAO, vamos criar um novo método que realiza a obtenção dos clientes pelo id, obterPorID

    package infra;

    import java.util.List;

    import javax.persistence.EntityManager;
    import javax.persistence.EntityManagerFactory;
    import javax.persistence.Persistence;
    import javax.persistence.TypedQuery;

    public class DAO<E> {

        private static EntityManagerFactory emf;
        private EntityManager em;
        private Class<E> classe;
        
        static {
            try {
                emf = Persistence.createEntityManagerFactory("exercicios-jpa");
            } catch(Exception e) {
                // logar -> log4j
            }
        }
        
        public DAO() {
            this(null);
        }
        
        public DAO(Class<E> classe) {
            this.classe = classe;
            em = emf.createEntityManager();
        }
        
        public DAO<E> abrirT() {
            em.getTransaction().begin();
            return this;
        }
        
        public DAO<E> fecharT() {
            em.getTransaction().commit();
            return this;
        }
        
        public DAO<E> incluir(E entidade) {
            em.persist(entidade);
            return this;
        }
        
        public DAO<E> incluirAtomico(E entidade) {
            return this.abrirT().incluir(entidade).fecharT();
        }
        
        public E obterPorID(Object id) {
            return em.find(classe, id);
        }
        
        public List<E> obterTodos() {
            return this.obterTodos(10, 0);
        }
        
        public List<E> obterTodos(int qtde, int deslocamento) {
            if(classe == null) {
                throw new UnsupportedOperationException("Classe nula.");
            }
            
            String jpql = "select e from " + classe.getName() + " e";
            TypedQuery<E> query = em.createQuery(jpql, classe);
            query.setMaxResults(qtde);
            query.setFirstResult(deslocamento);
            return query.getResultList();
        }
        
        public void fechar() {
            em.close();
        }
    }

Agora, na classe, ObterClienteAssento, complementamos com o seguinte código

    package teste.umpraum;

    import infra.DAO;
    import modelo.umpraum.Cliente;

    public class ObterClienteAssento {

        public static void main(String[] args) {
            
            DAO<Cliente> dao = new DAO<>(Cliente.class);
            
            Cliente cliente = dao.obterPorID(1L);
            System.out.println(cliente.getAssento().getNome());
            
            dao.fechar();
        }
    }

Agora, basta rodarmos o código acima, para conseguirmos obter o que precisamos.

Bom, podemos ver que foi trago o assento do cliente e vimos que nem na tabela, assentos, e nem em, clientes, foi criado uma nova coluna. Ambas permanecem como estava antes.

Vamos printar mais dados que foi puxado, para vermos se é possível realizarmos a consulta

    package teste.umpraum;

    import infra.DAO;
    import modelo.umpraum.Cliente;

    public class ObterClienteAssento {

        public static void main(String[] args) {
            
            DAO<Cliente> dao = new DAO<>(Cliente.class);
            
            Cliente cliente = dao.obterPorID(1L);
            System.out.println(cliente.getAssento().getNome());
            System.out.println(cliente.getAssento().getCliente().getNome());
            dao.fechar();
        }
    }

Vamos realizar a mesma coisa, agora, para o assento. Refatoremos um pouco do nosso código e complementamo-las como seguinte

    package teste.umpraum;

    import infra.DAO;
    import modelo.umpraum.Assento;
    import modelo.umpraum.Cliente;

    public class ObterClienteAssento {

        public static void main(String[] args) {
            
            DAO<Cliente> daoCliente = new DAO<>(Cliente.class);
            
            Cliente cliente = daoCliente.obterPorID(1L);
            System.out.println(cliente.getAssento().getNome());
            System.out.println(cliente.getAssento().getCliente().getNome());
            daoCliente.fechar();
            
            DAO<Assento> daoAssento = new DAO<>(Assento.class);
            Assento assento = daoAssento.obterPorID(3L);
            System.out.println(assento.getCliente().getNome());
            daoAssento.fechar();
        
        }
    }

Nisso, vamos ver se conseguimos puxar os dados pelo assento e o nome o cliente que está com o número do assento.

## Aula 24 - Um Pra Muitos #01:
Vamos, agora, abordar a relação um para muitos nas tabelas.

Vamos criar as classes, Pedido e ItemPedido, dentro do pacote, modelo.umpramuitos.

Dentro da classe, Pedido, coloquemos o seguinte

    package modelo.umpramuitos;

    import java.util.Date;

    import javax.persistence.Column;
    import javax.persistence.Entity;
    import javax.persistence.GeneratedValue;
    import javax.persistence.GenerationType;
    import javax.persistence.Id;

    @Entity
    public class Pedido {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        
        @Column(nullable = false)
        private Date data;
        
        public Pedido() {
            this(new Date());
        }

        public Pedido(Date data) {
            super();
            this.data = data;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Date getData() {
            return data;
        }

        public void setData(Date data) {
            this.data = data;
        }
    }

Agora, na classe, ItemPedido, coloquemos o seguinte

    package modelo.umpramuitos;

    import javax.persistence.Entity;
    import javax.persistence.GeneratedValue;
    import javax.persistence.GenerationType;
    import javax.persistence.Id;
    import javax.persistence.ManyToOne;

    import modelo.basico.Produto;

    @Entity
    public class ItemPedido {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        
        // Muitos itens de pedido está para um pedido - Many está para a classe ItemPedido
        // e One está para a classe Pedido
        @ManyToOne
        private Pedido pedido;
        
        @ManyToOne
        private Produto produto;
        
        private int quantidade;
        
        private Double preco;
        
        public ItemPedido() {
            
        }

        public ItemPedido(Pedido pedido, Produto produto, int quantidade) {
            super();
            this.setPedido(pedido);
            this.setProduto(produto);
            this.setQuantidade(quantidade);
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Pedido getPedido() {
            return pedido;
        }

        public void setPedido(Pedido pedido) {
            this.pedido = pedido;
        }

        public Produto getProduto() {
            return produto;
        }

        public void setProduto(Produto produto) {
            this.produto = produto;
            
            if(produto != null && this.preco == null) {
                this.setPreco(produto.getPreco());
            }
        }

        public int getQuantidade() {
            return quantidade;
        }

        public void setQuantidade(int quantidade) {
            this.quantidade = quantidade;
        }

        public Double getPreco() {
            return preco;
        }

        public void setPreco(Double preco) {
            this.preco = preco;
        }
    }

No arquivo, persistence.xml, vamos considerar essas duas classes

    <?xml version="1.0" encoding="UTF-8"?>
    <persistence version="2.2"
        xmlns="http://xmlns.jcp.org/xml/ns/persistence"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_2.xsd">
        <persistence-unit name="exercicios-jpa">
            <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
            <class>modelo.basico.Usuario</class>
            <class>modelo.basico.Produto</class>
            <class>modelo.umpraum.Cliente</class>
            <class>modelo.umpraum.Assento</class>
            <class>modelo.umpramuitos.Pedido</class>
            <class>modelo.umpramuitos.ItemPedido</class>
            
            <properties>
                <property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver"/>
                <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/curso_java"/>
                <property name="javax.persistence.jdbc.user" value="root"/>
                <property name="javax.persistence.jdbc.password" value="123456"/>
                
                <property name="hibernate.dialect" value="org.hibernate.dialect.MySQL57Dialect"/>
                <property name="hibernate.show_sql" value="true"/>
                <property name="hibernate.format_sql" value="true"/>
                <property name="hibernate.hbm2ddl.auto" value="update"/>
            </properties>
        </persistence-unit>
    </persistence>

Agora, vamos criar uma classe, NovoPedido, dentro do pacote, teste.umpramuitos, do projeto, exercicios-jpa, e nela iremos inserir o seguinte

    package teste.umpramuitos;

    import infra.DAO;
    import modelo.basico.Produto;
    import modelo.umpramuitos.ItemPedido;
    import modelo.umpramuitos.Pedido;

    public class NovoPedido {

        public static void main(String[] args) {
            
            DAO<Object> dao = new DAO<>();
            
            Pedido pedido = new Pedido();
            Produto produto = new Produto("Geladeira", 3899.59);
            ItemPedido item = new ItemPedido(pedido, produto, 10);
            
            dao.abrirT()
                .incluir(produto)
                .incluir(pedido)
                .incluir(item)
                .fecharT()
                .fechar();
        }
    }

Com isso, podemos, agora, testar para vermos o resultado, então basta rodar o código acima.

No Workbench, vamos verificar se a mudança surtiu algum efeito. No caso, note que, foi criado as tabelas, ItemPedido e Pedido, e na tabela, produtos, foi incluído a "Geladeira" que pedimos para colocar acima.

## Aula 25 - Um Pra Muitos #02 - Bidirecional:

## Aula 26 - Um Pra Muitos #03:

## Aula 27 - Muitos Pra Muitos #01:

## Aula 28 - Muitos Pra Muitos #02:

## Aula 29 - Aviso sobre o arquivo XML criado na aula a seguir:
E aí, pessoal! Tudo bem?

Na próxima aula irei criar um arquivo do tipo “JPA ORM Mapping File", caso para vocês não tenham a opção para gerar esse tipo de arquivo, vocês podem então gerar um arquivo xml normal buscando apenas por “xml” depois de abrir o “Other”, então você irá criar o arquivo do tipo “XML File”, a única diferença é que o arquivo que irei criar já vem com a tag “entity-mappings” e o xml padrão não vem. Então após vocês criarem o XML File, substitua todo o conteúdo do arquivo pelo conteúdo que está aqui abaixo:

    <?xml version="1.0" encoding="UTF-8"?> <entity-mappings version="2.1" xmlns="<http://xmlns.jcp.org/xml/ns/persistence/orm>" xmlns:xsi="<http://www.w3.org/2001/XMLSchema-instance>" xsi:schemaLocation="<http://xmlns.jcp.org/xml/ns/persistence/orm> <http://xmlns.jcp.org/xml/ns/persistence/orm_2_1.xsd>">



    </entity-mappings>

Após isso é só seguir a aula normalmente! :)

Bons estudos!

## Aula 30 - Named Query:

## Aula 31 - Named Native Query:

## Aula 32 - Embeddable:

## Aula 33 - Desafio Herança:

## Aula 34 - Herança:
