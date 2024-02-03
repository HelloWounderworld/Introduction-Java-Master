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
//		String sql = "INSERT INTO pessoas (nome, codigo) VALUES(?, ?)";// A quantidade de interrogação indica a quantidade de valores e parâmetros que deve ser considerado
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, nome); // Forma segura, pois nos garante que qualquer coisa que for colocado
		// será uma string, e não um comando sql.
//		stmt.setInt(2, 100);
		
		stmt.execute();
		
		System.out.println(sql);
		
		entrada.close();
	}
}
