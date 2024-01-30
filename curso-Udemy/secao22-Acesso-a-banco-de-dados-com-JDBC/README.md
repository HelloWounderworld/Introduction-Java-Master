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

Primeiro, vamos criar uma nova base de banco de dados.

## Aula 03 - Fábrica de Conexões:

## Aula 04 - Criar Tabela:

## Aula 05 - Inserir Registro:

## Aula 06 - Consultar Registros #01:

## Aula 07 - Desafio Consultar Registros:

## Aula 08 - Desafio Consultar Registros - Resposta:

## Aula 09 - Desafio Atualizar Registro:

## Aula 10 - Desafio Atualizar Registro - Resposta:

## Aula 11 - Excluir Registro:

## Aula 12 - Externalizando Dados de Conexão:

## Aula 13 - Padrão DAO #01:

## Aula 14 - Padrão DAO #02:
