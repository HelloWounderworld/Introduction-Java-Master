# Seção 21: Acesso a Banco de Dados com JDBC - Opcional, pois terei um curso de PL/SQL - Mas mesmo depois que pegar o certificado assista essa aula!!

## Aula 01 - Visão geral do capítulo e Aula 02 - Material de apoio do capítulo:
MATERIAL DE APOIO DO CAPÍTULO

Seja muito bem-vindo(a) ao capítulo Acesso a banco de dados com JDBC!

Aqui você pode baixar o material de apoio usado nas aulas do capítulo, para que você possa aproveitar ao máximo as aulas sem precisar ficar anotando muito.

Grande abraço e bons estudos! Nelio.

Recursos para esta aula

    acesso-a-dados-com-jdbc.pdf

## Aula 03 - Visão geral do JDBC:
Seguir o pdf

    acesso-a-dados-com-jdbc.pdf

## Aula 04 - Nivelamento: Álgebra Relacional e SQL:
Basicamente vc precisa entender de conjuntos e produto cartesiano.

Já estudei esses conceitos pelos livros de análise matemática e teoria de conjuntos do Thomas Jech.

## Aula 05 - Instalando o MySQL:
Seguir o link de instalação

    https://dev.mysql.com/downloads

    MySQL Community Server -> Go to Download Page -> MSI Installer (full)

## Aula 06 e 07 - Preparação do primeiro projeto no Eclipse - PARTE 1 e 2:
Vamos preparar primero o projeto no Eclipse para começarmos a usar o MySQL.

Bom, no MySQL vamos começando a criar uma base de dados chamado "coursejdbc"

    create database coursejdbc;

Agora, vamos baixar o MySQL Java Connector 

    https://dev.mysql.com/downloads/connector/j/

Em seguida, no Disco Local (C:) vamos criar uma pasta chamado java-libs e dentro dessa pasta criar uma outra pasta chamado jdbc-connectors. Daí, do arquivo zipado vc envia somente o 

    mysql-connector-j-8.0.32.jar

Agora, vamor criar um novo worspace no eclipse com o nome ws-javafx e dentro dela fazemos

    Window -> Perspective -> Open Perspective -> Java

Em seguida, realizamos o seguinte passos

    Window -> Preferences -> Java -> Build path -> User Libraries

Para criamos um MySQLConnector.

Em seguida, selecionado a pasta MySQLConnector, vamos clicar em Add External & Jar e por essa via, selecionamos mysql-connector-j-8.0.32.jar.

Agora, vamos criar um novo projeto dentro do eclipse com o nome "jdbc1" e clicamos em next e localizamos o "Libraries" e selecionamos o Modulepath e clicamos em "Add Library" em seguida selecionamos o "User Library" e clicamos em Next e selecionamos o "MySQLConnector" e clicamos em Finish. Por fim, vamos clicar em Finish.

Na pasta raiz do projeto, criar um arquivo "db.properties" contendo os dados de conexão: 

    user=developer 
    password=1234567 
    dburl=jdbc:mysql://localhost:3306/coursejdbc 
    useSSL=false

Obs: No meu uso, utilizo a senha que eu criei em vez de 1234567. Não irei colocar aqui nas notas por motivos óbvios.

Em seguida, vamos criar uma classe DbException dentro do diretório db dentro do src. E nela realizamos as seguintes implementações básicas de excessões

    package db;

    public class DbException extends RuntimeException {

        private static final long serialVersionUID = 1L;
        
        public DbException(String msg) {
            super(msg);
        }

    }

No pacote db, vamos criar uma outra classe chamado DB e nela iremos criar métodos estáticos auxiliares

    package db;

    import java.io.FileInputStream;
    import java.io.IOException;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;
    import java.util.Properties;

    public class DB {

        private static Connection conn = null;
        
        public static Connection getConnection() {
            if (conn == null) {
                try {
                    Properties props = loadProperties();
                    String url = props.getProperty("dburl");
                    conn = DriverManager.getConnection(url, props);
                }
                catch (SQLException e) {
                    throw new DbException(e.getMessage());
                }
            }
            return conn;
        }
        
        public static void closeConnection() {
            if (conn != null) {
                try {
                    conn.close();
                }
                catch (SQLException e) {
                    throw new DbException(e.getMessage());
                }
            }
        }
        
        // Método que serve para carregar as propiedades definidos dentro do db.properties
        private static Properties loadProperties() {
            try (FileInputStream fs = new FileInputStream("db.properties")) {
                Properties props = new Properties();
                props.load(fs);
                return props;
            }
            catch (IOException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

Vamos verificar se tudo está correto. No caso, vamos criar um arquivo Program.java na pasta application e nela colocamos o seguinte

    package application;

    import java.sql.Connection;

    import db.DB;

    public class Program {

        public static void main(String[] args) {
            
            Connection conn = DB.getConnection();
            DB.closeConnection();
            
        }

    }

Podemos rodar o código acima para verificarmos se vai ou não ocorrer algum erro.

## Aula 08 - Demo - recuperar dados:
Seguir o link do repositório para conseguirmos entender a estrutura

    https://github.com/acenelio/demo-dao-jdbc/blob/master/database.sql
    https://github.com/acenelio/jdbc2

## Aula 09 - Demo - inserir dados:
Seguir o link do repositório do professor

    https://github.com/acenelio/jdbc3

## Aula 10 - Demo - atualizar dados:
Seguir o link do repositório do professor

    https://github.com/acenelio/jdbc4

## Aula 11 - Demo - deletar dados:
Seguir o link do repositório do professor

    https://github.com/acenelio/jdbc5

## Aula 12 - Demo - transações:
Seguir o link de leitura

     https://www.ibm.com/support/knowledgecenter/en/SSGMCP_5.4.0/product-overview/acid.html

Seguir o link do repositório do professor

    https://github.com/acenelio/jdbc6

## Aula 13 - Padrão de projeto DAO (Data Access Object):

## Aula 14 - PROJETO - criando projeto e repositório Git:

## Aula 15 - Classe Department:

## Aula 16 - Classe Seller:

## Aula 17 - Interfaces DepartmentDao e SellerDao:

## Aula 18 - SellerDaoJDBC e DaoFactory:

## Aula 19 - Implementando findById:

## Aula 20 - Reutilizando a instanciação:

## Aula 21 - Implementando findByDepartment:

## Aula 22 - Implementando findAll:

## Aula 23 - Implementando insert:

## Aula 24 - Implementando update:

## Aula 25 - Implementando delete:

## Aula 26 - Implementação e teste do DepartmentDao:
