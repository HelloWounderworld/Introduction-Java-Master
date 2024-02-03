# Seção 22: Banco de dados com JDBC - Java Data Base Connection

## Aula 01 - Abrindo uma conexão:
O Objetivo dessa aula seria, apenas, se conectar com o banco de dados.

Para isso, por começo, teremos que ter o MySQL, o seu server, configurado na máquina.

Vamos continuar usando o nosso projeto, exercicios, e nela iremos criar um novo pacote "jdbc" e dentro desse pacote vamos criar uma classe chamado "TesteConexao".

Depois que vc fizer a seguinte configuração

    package jdbc;

    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;

    public class TesteConexao {

        public static void main(String[] args) throws SQLException {
            
            final String url = "jdbc:mysql://localhost";
            final String usuario = "root";
            final String senha = "xxxxx"; // não irei dizer por segurança
            
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            
            System.out.println("Conexão efetuada com sucesso!");
            conexao.close();
        }
    }

Agora, será necessário baixar um connector entre o java e o banco de dados MySQL

    https://dev.mysql.com/downloads/connector/j/?os=26

No link acima baixamos o arquivo 

    mysql-connector-j-8.3.0.zip

Em seguida, extraímos ela na pasta de Downloads.

Entrando na pasta mysql-connector-j-8.3.0 teremos o arquivo

    mysql-connector-j-8.3.0.jar

Agora, no projeto, exercicios, criamos uma nova pasta chamado "libs" fora do src e dentro dela mandmos uma cópia desse arquivo (Basta abrir o eclipse com o arquivo aberto e arrastar para libs e escolher a opção "copy").

No caso, isso é necessário para conseguirmos estabelecer a conexção como banco de dados MySQL.

Agora, no eclipse conferimos se esse arquivo se encontra na pasta libs.

Bom, agora, temos o driver que nos permite estabelecer a conexão com o banco de dados MySQL com o nosso projeto. Porém, ainda não estabelecemos a conexão. Vamos precisar buildar a path.

Agora, cliamos com o botão direito do mouse em cima do arquivo .jar que mandamos para o libs e selecionamos a opção "Build Path" e nela irá mostrar a opção "Add to Build Path", onde clicamos nela.

Notamos que, feito isso será criado uma nova pasta chamado "Referenced Libraries", donde, dentro dela, teremos "mysql-connector-8.3.0.jar", onde fica as bibliotecas referenciadas.

Feito isso, finalmente, conseguiremos executar o código acima da classe "TesteConexao". Se rodarmos veremos que vamos ter o processo bem sucedido.

Provavelmente, para algumas pessoas, irá aparecer, junto com a mensagem do print, uma msg de Warning reclamando sobre SSL, que indica uma autenticação de um certificado válido. Caso aparecer isso, mudamos a variável "url" para o seguinte

    final String url = "jdbc:mysql://localhost?useSSL=false";

Para indicar que para essa path não tem nenhuma autenticação de segurança e certificação. Porém, o que isso está indicando?

Significa que sempre que estivermos nos conectando com o servidor, será por via de uma conexão insegura, que não é o desejável.

Para isso, mudamos o false para true

    final String url = "jdbc:mysql://localhost?useSSL=true";

Só que se usarmos a conexão segura, podemos ter algum problema em relação à identidade do servidor. Então, para contornarmos esse problema, é recomendável que coloquemos o seguinte

    final String url = "jdbc:mysql://localhost?verifyServerCertificate=false&useSSL=false";

Bom, isso irá garantir que estaremos usando uma conexao segura, sem a necessidade de conferirmos a validade do certificado.

Agora, conseguimos estabelecer uma conexão entre o projeto java e o servidor MySQL, mas ainda não estabelecemos a conexão com o banco de dados.

Para isso, é necessário indicarmos a porta

    final String url = "jdbc:mysql://localhost:3306?verifyServerCertificate=false&useSSL=true";

E para conseguirmos conectar ao banco de dados que temos dentro dessa porta, seria

    final String url = "jdbc:mysql://localhost/wm?verifyServerCertificate=false&useSSL=true";

Temos uma base de dados, wm. Verifique se o print continua sendo exibido sem nenhum problema.

## Aula 02 - Criar Banco de Dados:
Bom, configurado o ambiente de conexão entre o projeto, exercicios, e o servidor MySQL que foi instalado na máquina, agora, vamos manipular, via o projeto, o banco de dados.

Primeiro, vamos criar uma nova base de banco de dados a partir do Java.

Obs: Geralmente, o processo de criação de uma base é feito diretamente no servidor do banco de dados do que realizar isso pela linguagem de programação. Mas, essa abordagem serve para deixar ciente que é possível sim realizar a criação por essa via tbm.

Criamos no pacote, jdbc, uma nova classe "CriarBanco.java" do projeto, exercicios, e nessa classe coloquemos

    package jdbc;

    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;

    public class CriarBanco {

        public static void main(String[] args) throws SQLException {
            
    //		final String url = "jdbc:mysql://localhost?useSSL=false";
    //		final String url = "jdbc:mysql://localhost?verifyServerCertificate=false&useSSL=true";
            final String url = "jdbc:mysql://localhost:3306/wm";
            final String usuario = "root";
            final String senha = "xxxxxxxx";
            
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            
            conexao.close();
        }
    }

Agora, vamos colocar os comandos que permite a criação do banco de dados. Para isso, vamos importar o módulo Statment e com ela realizamos o seguinte

    package jdbc;

    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;
    import java.sql.Statement;

    public class CriarBanco {

        public static void main(String[] args) throws SQLException {
            
    //		final String url = "jdbc:mysql://localhost?useSSL=false";
    //		final String url = "jdbc:mysql://localhost?verifyServerCertificate=false&useSSL=true";
            final String url = "jdbc:mysql://localhost:3306/wm";
            final String usuario = "root";
            final String senha = "xxxxxxxxx";
            
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            
            Statement stmt = conexao.createStatement();
            stmt.execute("CREATE DATABASE curso_java");
            
            System.out.println("Banco criado com sucesso!");
            
            conexao.close();
        }
    }

No caso, agora, basta executar o código acima que será possível criar o banco de dados que queremos. Para checar isso, podemos verificar isso via VSCode ou visitando o Workbench.

Agora, se tentarmos executar novamente o código acima, provavelmente, dara um erro, pois esse banco de dados já foi criado

    Exception in thread "main" java.sql.SQLException: Can't create database 'curso_java'; database exists
        at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:130)
        at com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping.translateException(SQLExceptionsMapping.java:122)
        at com.mysql.cj.jdbc.StatementImpl.executeInternal(StatementImpl.java:770)
        at com.mysql.cj.jdbc.StatementImpl.execute(StatementImpl.java:653)
        at jdbc.CriarBanco.main(CriarBanco.java:21)

Como uma alternativa, assim como foi aprendido em banco de dados relacional, colocar uma condição de "IF NOT EXISTS" como seguinte

    package jdbc;

    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;
    import java.sql.Statement;

    public class CriarBanco {

        public static void main(String[] args) throws SQLException {
            
    //		final String url = "jdbc:mysql://localhost?useSSL=false";
    //		final String url = "jdbc:mysql://localhost?verifyServerCertificate=false&useSSL=true";
            final String url = "jdbc:mysql://localhost:3306/wm";
            final String usuario = "root";
            final String senha = "xxxxxxxxx";
            
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            
            Statement stmt = conexao.createStatement();
            stmt.execute("CREATE DATABASE IF NOT EXISTS curso_java");
            
            System.out.println("Banco criado com sucesso!");
            
            conexao.close();
        }
    }

Assim, o erro acima não será mais exibido, pois visto que existe o banco de dados, então, simplesmente, não foi feito nada.

Agora, claro, se criamos um banco de dados, podemos tbm remover o mesmo usando o Drop como seguinte, primeiro vamos criar uma base de exemplo

    package jdbc;

    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;
    import java.sql.Statement;

    public class CriarBanco {

        public static void main(String[] args) throws SQLException {
            
    //		final String url = "jdbc:mysql://localhost?useSSL=false";
    //		final String url = "jdbc:mysql://localhost?verifyServerCertificate=false&useSSL=true";
            final String url = "jdbc:mysql://localhost:3306/wm";
            final String usuario = "root";
            final String senha = "xxxxxxxx";
            
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            
            Statement stmt = conexao.createStatement();
    //		stmt.execute("CREATE DATABASE curso_java");
            stmt.execute("CREATE DATABASE IF NOT EXISTS curso_java2");
            
            System.out.println("Banco criado com sucesso!");
            
            conexao.close();
        }
    }

Conferido no Workbench que essa base de dados, curso-java2, foi criado (dá um refresh), agora, vamos dropar ela

    package jdbc;

    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;
    import java.sql.Statement;

    public class CriarBanco {

        public static void main(String[] args) throws SQLException {
            
            final String url = "jdbc:mysql://localhost:3306/wm";
            final String usuario = "root";
            final String senha = "xxxxxxx";
            
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            
            Statement stmt = conexao.createStatement();
            stmt.execute("DROP DATABASE IF EXISTS curso_java2");
            
            System.out.println("Banco criado com sucesso!");
            
            conexao.close();
        }
    }

Novamente, confira no Workbench se a base, curso_java2, não existe mais (dando refresh).

Bom, esses são os passos que precisamos para realizar a criação e remoção de uma base de dados.

Na próxima aula, vamos aprender a apontar para as tabelas que criadas para cada base de dados.

## Aula 03 - Fábrica de Conexões:
Vamos criar uma classe que nos ajudará a estabelecer uma conexão com as bases que precisamos.

Em outras palavras, é uma classe que, nela iremos configurar, apenas, uma única vez as chaves, senhas, urls, etc... para quando uma outra classe for necessária estabelecer uma conexão com alguma base, bastaria importar essa classe e inserir os parâmetros necessários nela para realizar a tal conexão.

No projeto, exercicios, do pacote, jdbc, vamos criar a classe "FabricaConexao" e nela colocamos o seguinte

    package jdbc;

    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;

    public class FabricaConexao {

        public static Connection getConexao() {
            // try/cath - Ctrl + Alt + z
            try {
                final String url = "jdbc:mysql://localhost:3306/wm";
                final String usuario = "root";
                final String senha = "xxxxxxx";
                
                return DriverManager.getConnection(url, usuario, senha);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

Agora, vamos testar se essa conexão está sendo feito de forma certa.

Na classe, CriarBanco.java, vamos realizar o seguinte

    package jdbc;

    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;
    import java.sql.Statement;

    public class CriarBanco {

        public static void main(String[] args) throws SQLException {
            
            Connection conexao = FabricaConexao.getConexao();
            
            Statement stmt = conexao.createStatement();
            stmt.execute("CREATE DATABASE IF NOT EXISTS curso_java2");
            
            System.out.println("Banco criado com sucesso!");
            
            conexao.close();
        }
    }

Executando o código acima, vamos verificar se a msg do println será exibido. Se exibir, significa que a conexão deu certo e foi criado a base de dados, caso não exista.

Bom, vamos remover a base que foi criada, pois não precisamos dela, realizando o mesmo processo feito na classe, CriarBanco, para a classe, RemoverBanco.

Bom, na próxima aula, vamos começar a criar as tabelas no banco de dados.

## Aula 04 - Criar Tabela:
Vamos, agora, aprender a criar as tabelas via Java.

No projeto, exercicios, do pacote, jdbc, criamos a classe "CriarTabelaPessoas". E nela adicionamos o seguinte

    package jdbc;

    import java.sql.Connection;
    import java.sql.SQLException;
    import java.sql.Statement;

    public class CriarTabelaPessoas {

        public static void main(String[] args) throws SQLException {
            Connection conexao = FabricaConexao.getConexao();
            
            String sql = "CREATE TABLE pessoas("
                    +"codigo INT AUTO_INCREMENT PRIMARY KEY,"
                    + "nome VARCHAR(80) NOT NULL"
                    +")";
            
            Statement stmt = conexao.createStatement();
            stmt.execute(sql);
            
            System.out.println("Tabela criada com sucesso!");
            conexao.close();
        }
    }

Se vc rodar o coódigo como está acima, será exibido um erro, pois ainda não selecionamos nenhum banco onde será criado essa tabela.

Agora, na classe, FabricaConexao, vamos apontar para qual base de dados vamos querer criar essa tabela

    package jdbc;

    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;

    public class FabricaConexao {

        public static Connection getConexao() {
            // try/cath - Ctrl + Alt + z
            try {
    //			final String url = "jdbc:mysql://localhost?useSSL=false";
    //			final String url = "jdbc:mysql://localhost?verifyServerCertificate=false&useSSL=true";
                final String url = "jdbc:mysql://localhost:3306/curso_java";
                final String usuario = "root";
                final String senha = "123456";
                
                return DriverManager.getConnection(url, usuario, senha);
            } catch (SQLException e) {
    //			e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

Agora, sim, rodando o código da classe, CriarTabelaPessoas, vamos conseguir criar a tabela na base, curso_java.

Analisando isso no Workbench, vamos ver que na base de dado, curso_java, essa tabela, pessoas, estará aparecendo.

Bom, visto que conseguimos criar a tabela na base de dados, agora, é só implementar o conhecimento que adquirimos na seção sobre banco de dados relacional. Brincar com o CRUD.

Seguir o link:

    https://openjdk.org/jeps/355

## Aula 05 - Inserir Registro:
Vamos aprender a inserir registros pelo Java.

Temos duas formas de realizamos isso, uma, por via padrão que realizamos, até agora, usando o Statement e, outra, por via de mais segura, que não usamos em nenhum momento ainda. 

Motivo disso, seria porque as inserções em banco de dados precisa de muita cautela, principalmente, quando se trata do banco de dados que lhe é utilizado por muita gente. Logo, estabelecer um protocolo de segurança para isso é essencial para evitarmos que gere um problema muito grande a nível de ocorrer alguma perda aquisitiva para a empresa.

Para o começo no projeto, exercicios, do pacote, jdbc, vamos criar uma classe "NovaPessoa" e nela coloquemos o seguinte

    package jdbc;

    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.SQLException;
    import java.util.Scanner;

    public class NovaPessoa {

        public static void main(String[] args) throws SQLException {
            
            Scanner entrada = new Scanner(System.in);
            
            System.out.print("Informe o nome: ");
            String nome = entrada.nextLine();
            
            System.out.println("Pessoa que será inserido: " + nome);
            
            Connection conexao = FabricaConexao.getConexao();
            
    //		String sql = "INSERT INTO pessoas (nome) VALUES('" + nome + "')";// Forma vulneravel
            
            String sql = "INSERT INTO pessoas (nome) VALUES(?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nome); // Forma segura, pois nos garante que qualquer coisa que for colocado
            // será uma string, e não um comando sql.
            
            stmt.execute();
            
            System.out.println(sql);
            
            entrada.close();
        }
    }

Note que, na parte onde está escrito "Forma vulneravel" mostra um caso em que o comando nos permite que a pessoa consiga colocar até comandos sql, o que torna suscetível ao ataque externo de alguma hacker. Abaixo, com o uso do prepareStatement, garantimos a segurança, pois o que for colocado dentro dessa base de dados, será uma string e, não, um comando em sql.

## Aula 06 - Consultar Registros #01:
Vamos, agora, aprender a consultar o banco de dados usando o Java.

No projeto, exercicios, do pacote, jdbc, vamos criar uma classe "Pessoa" e nela inserimos o seguinte

    package jdbc;

    public class Pessoa {

        private int codigo;
        private String nome;

        public Pessoa(int codigo, String nome) {
            this.codigo = codigo;
            this.nome = nome;
        }

        public int getCodigo() {
            return codigo;
        }

        public void setCodigo(int codigo) {
            this.codigo = codigo;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

    }

No mesmo projeto e pacote, vamos criar uma classe "ConsultarPessoa1" e nela inserimos o seguinte

    package jdbc;

    import java.sql.Connection;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.sql.Statement;
    import java.util.ArrayList;
    import java.util.List;

    public class ConsultarPessoa1 {

        public static void main(String[] args) throws SQLException {
            
            Connection conexao = FabricaConexao.getConexao();
            
            String sql = "SELECT * FROM pessoas";
            
            Statement stmt = conexao.createStatement();
            ResultSet resultado = stmt.executeQuery(sql);
            
            List<Pessoa> pessoas = new ArrayList<>();
            
            while(resultado.next()) {
                int codigo = resultado.getInt("codigo");
                String nome = resultado.getString("nome");
                pessoas.add(new Pessoa(codigo, nome));
            }
            
            for(Pessoa p: pessoas) {
                System.out.println(p.getCodigo() + " ==> " + p.getNome());
            }
            
            stmt.close();
            conexao.close();
        }
    }

Ao executarmos a classe "ConsultarPessoa1", conseguimos ver que puxamos os dados da tabela "pessoas", como é exibido no console.

## Aula 07 e 08 - Desafio Consultar Registros - Resposta:
Seguir a classe "ConsultarPessoa2" do projeto, exercicios, do pacote, jdbc.

Esse desafio é aprender a manusear a sintaxe de consulta "LIKE" do sql, via java.

## Aula 09 e 10 - Desafio Atualizar Registro - Resposta:
Seguir a classe "AlterarNomePessoa" do projeto, exercicios, do pacote, jdbc.

Esse desafio serve para aprender a manusear a sintaxe de atualização "UPDATE" do sql, via java.

## Aula 11 - Excluir Registro:
Vamos aprender a realizar a exclusão da pessoa via java.

Do projeto, exercicios, do pacote, jdbc, vamos criar a classe "ExcluirPessoa" e nela inserimos o seguinte

    package jdbc;

    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.SQLException;
    import java.util.Scanner;

    public class ExcluirPessoa {

        public static void main(String[] args) throws SQLException {
            
            Scanner entrada = new Scanner(System.in);
            System.err.print("Informe o código: ");
            int codigo = entrada.nextInt();
            
            Connection conexao = FabricaConexao.getConexao();
            String sql = "DELETE FROM pessoas WHERE codigo = ?";
            
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, codigo);
        
            if(stmt.executeUpdate() > 0) {
                System.out.println("Pessoa excluida com sucesso!");
            } else {
                System.out.println("Nada feito...");
            }
            
            conexao.close();
            entrada.close();
        }
    }

No caso, o código como está feito acima, é uma forma simples de excluir os dados de uma tabela.

## Aula 12 - Externalizando Dados de Conexão:
Vamos, agora, aprender sobre arquivo de propriedade.

No caso, no projeto, exercicios, vamos criar um arquivo com o nome "conexao.properties" e nela inserimos o seguinte

    banco.url=jdbc:mysql://localhost?verifyServerCertificate=false&useSSL=true 
    banco.usuario=root
    banco.senha=123456

O bom desse arquivo é que ela serve para conseguirmos externalizar os dados de acesso de modo que bastaríamos, em código, montar um algoritmo que realize a leitura desse arquivo.

Obs: Eu alterei algumas condições de segurança quando instalei o MySQL server. Provavelmente, ele está mais fácil, mas, visto que só instalei para estudos, então não vi muita necessidade de procurar deixar firme o banco de dados. Lembre-se, sempre colocar alguma senha que seja em número sem caracteres especiais. Logo, com a url acima, pode ser que não funcione a conexão com o banco de dados. Por isso, caso tenha ocorrido algum problema do tipo, tente com a url, jdbc:mysql://localhost:3306/curso_java, em vez do que foi configurado acima.

Uma outra vantagem desse problema, seria na facilidade de conseguirmos alterar os dados de conexão sem a necessidade de encontrarmos a classe que contenha esse dado.

Feito a inputação dos dados de acesso servidor MySQL, na classe "FabricaConexao" realizamos o seguinte

    package jdbc;

    import java.io.IOException;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;
    import java.util.Properties;

    public class FabricaConexao {

        public static Connection getConexao() {
            // try/cath - Ctrl + Alt + z
            try {
                Properties prop = getProperties();
                final String url = prop.getProperty("banco.url");
                final String usuario = prop.getProperty("banco.usuario");
                final String senha = prop.getProperty("banco.senha");
                
                return DriverManager.getConnection(url, usuario, senha);
            } catch (SQLException | IOException e) {
                throw new RuntimeException(e);
            }
        }
        
        private static Properties getProperties() throws IOException {
            Properties prop = new Properties();
            String caminho = "/conexao.properties";
            prop.load(FabricaConexao.class.getResourceAsStream(caminho));
            return prop;
        }
    }

Lembrando, o arquivo "conexao.properties" está localizado dentro da pasta src do projeto, exercicios. As boas práticas nos informam que seria melhor criar uma pasta de usuários e nela guardar tais arquivos que informa os dados da conexão, assim, evitando que esse arquivo seja configurado como o arquivo java. Em outras palavras, isso nos evita expor informações importantes dentro do repositório de modo que acaba comprometendo na segurança do sistema.

Caso vc for buildar esse repositório, é recomendado que tenha um arquivo gitignore e nela considerar para ignorar esse arquivo, conexao.properties, para evitar que ocorra uma exposição de dados de conexões importantes.

Bom, basicamente, a externalização das informações de conexões do banco de dados, é uma prática que nos permite manter o sistema da pessoa em segurança.

Seguir link de leitura:

    https://stackoverflow.com/questions/585534/what-is-the-best-way-to-find-the-users-home-directory-in-java

## Aula 13 e 14 - Padrão DAO (Data Access Object) #01 e #02:
Basicamente, o padrão DAO é uma forma de organizar os códigos para cada finalidade, sejam elas voltado para regra de negócio, infra-estrutura, etc...

Motivo de ter surgido esse conceito, está em exatamente ter ocorrido, historicamente, problemas atrelados em misturar códigos de regra de negócio com códigos de infra-estrutura. Isso torna confuso entender qual código é para qual finalidade.

Vamos construir uma classe que retrate, de forma simples, essa ideia.

No projeto, exercicios, do pacote, jdbc, vamos criar uma classe "DAO" e nela inserimos o seguinte

    package jdbc;

    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;

    public class DAO {

        private Connection conexao;
        
        public int incluir(String sql, Object... atributos) {
            try {
                PreparedStatement stmt = getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                adicionarAtributos(stmt, atributos);
                
                if(stmt.executeUpdate() > 0) {
                    ResultSet resultado = stmt.getGeneratedKeys();
                    
                    if(resultado.next()) {
                        return resultado.getInt(1);
                    }
                }
                
                return -1;
            } catch(SQLException e) {
                throw new RuntimeException(e);
            }
        }
        
        public void close() {
            try {
                getConexao().close();
            } catch (Exception e) {
                
            } finally {
                conexao = null;
            }
        }
        
        private void adicionarAtributos(PreparedStatement stmt, Object[] atributos) throws SQLException {
            int indice = 1;
            for(Object atributo: atributos) {
                if(atributo instanceof String) {
                    stmt.setString(indice, (String) atributo);
                } else if(atributo instanceof Integer) {
                    stmt.setInt(indice, (Integer) atributo);
                }
                
                indice++;
            }
        }
        
        private Connection getConexao() {
            try {
                if(conexao != null && !conexao.isClosed()) {
                    return conexao;
                }
            } catch (SQLException e) {
                
            }
            
            conexao = FabricaConexao.getConexao();
            return conexao;
        }
    }

Basicamente, com o código acima, não precisamos mais nos preocupar com a forma como iremos nos conectar com o banco de dados. Fizemos uma espécie de encapsulamento.

Falta, agora, testarmos o "DAO" que criamos acima. Para isso, vamos realizar o seguinte, dentro do projeto, exercicios, do pacote, jdbc, vamos criar a classe "DAOTeste" e nela implementamos o seguinte

    package jdbc;

    public class DAOTeste {

        public static void main(String[] args) {
            
            DAO dao = new DAO();
            
            String sql = "INSERT INTO pessoas (nome) VALUES (?)";
            dao.incluir(sql, "Albert Einstein");
            dao.incluir(sql, "Alan Turing");
            dao.incluir(sql, "Kiyoshi Oka");

            dao.close();
        }
    }

No caso, quando rodarmos o código acima, iremos inserir esses elementos na tabela pessoas.

Para conferir se a inserção foi bem sucedida, bastaria, rodarmos a classe "ConsultarPessoa1" ou verificar diretamente do Workbench.

Basicamente, o que notamos aqui nesse estudo é a ideia de encapsularmos os métodos que conseguimos acessar diretamente da infra-estrutura, como close, exceute, incluir. Ou seja, a classe, DAO, tem a funcionalidade de evitarmos que use os métodos diretamente vinda da infraestrutura de modo que isso nos permite não misturarmos com os códigos mais voltados para a regra de negócio, como foi visto no código, DAOTeste.

Seguir link de leitura:

    https://www.devmedia.com.br/dao-pattern-persistencia-de-dados-utilizando-o-padrao-dao/30999#:~:text=Padr%C3%A3o%20DAO%20(Data%20Access%20Object,tornar%20nossas%20classes%20mais%20leg%C3%ADveis.

    https://pt.stackoverflow.com/questions/113840/como-funciona-o-padr%C3%A3o-dao
