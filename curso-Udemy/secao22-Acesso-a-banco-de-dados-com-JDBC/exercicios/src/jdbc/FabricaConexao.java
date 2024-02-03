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
//			final String url = "jdbc:mysql://localhost?useSSL=false";
//			final String url = "jdbc:mysql://localhost?verifyServerCertificate=false&useSSL=true";
//			final String url = "jdbc:mysql://localhost:3306/curso_java";
//			final String usuario = "root";
//			final String senha = "123456";
			Properties prop = getProperties();
			final String url = prop.getProperty("banco.url2");
			final String usuario = prop.getProperty("banco.usuario");
			final String senha = prop.getProperty("banco.senha");
			
//			System.out.println(url);
//			System.out.println(usuario);
//			System.out.println(senha);
			
			return DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException | IOException e) {
//			e.printStackTrace();
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
