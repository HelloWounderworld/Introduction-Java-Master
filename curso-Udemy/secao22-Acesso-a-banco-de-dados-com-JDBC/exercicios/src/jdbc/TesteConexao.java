package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {

	public static void main(String[] args) throws SQLException {
		
//		final String url = "jdbc:mysql://localhost?useSSL=false";
//		final String url = "jdbc:mysql://localhost?verifyServerCertificate=false&useSSL=true";
		final String url = "jdbc:mysql://localhost:3306/wm";
		final String usuario = "root";
		
		Connection conexao = DriverManager.getConnection(url, usuario, senha);
		
		System.out.println("Conexão efetuada com sucesso!");
		conexao.close();
	}
}
