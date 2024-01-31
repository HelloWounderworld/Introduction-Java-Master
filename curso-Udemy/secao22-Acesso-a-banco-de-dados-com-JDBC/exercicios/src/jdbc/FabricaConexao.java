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
			final String url = "jdbc:mysql://localhost:3306/wm";
			final String usuario = "root";
			final String senha = "123456";
			
			return DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException e) {
//			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
