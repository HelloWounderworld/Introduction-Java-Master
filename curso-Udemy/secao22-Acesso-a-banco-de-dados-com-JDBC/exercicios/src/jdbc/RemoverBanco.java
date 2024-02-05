package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class RemoverBanco {

	public static void main(String[] args) throws SQLException {
		
//		final String url = "jdbc:mysql://localhost?useSSL=false";
//		final String url = "jdbc:mysql://localhost?verifyServerCertificate=false&useSSL=true";
//		final String url = "jdbc:mysql://localhost:3306/wm";
//		final String usuario = "root";
//		final String senha = "123456";
		
//		Connection conexao = DriverManager.getConnection(url, usuario, senha);
		Connection conexao = FabricaConexao.getConexao();
		
		Statement stmt = conexao.createStatement();
		stmt.execute("DROP DATABASE IF EXISTS curso_java2");
		
		System.out.println("Banco removido com sucesso!");
		
		conexao.close();
	}
}