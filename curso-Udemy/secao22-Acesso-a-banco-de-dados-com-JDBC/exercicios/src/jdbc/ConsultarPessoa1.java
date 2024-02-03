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
		
//		System.out.println(resultado);
		
		// Essa forma de uso de while com o next, é muito bom
		// Enquanto tiver próximo ele irá processando
		while(resultado.next()) {
			int codigo = resultado.getInt("codigo");// Nome da coluna
			String nome = resultado.getString("nome");// Nome da coluna
			pessoas.add(new Pessoa(codigo, nome));
		}
		
		for(Pessoa p: pessoas) {
			System.out.println(p.getCodigo() + " ==> " + p.getNome());
		}
		
		stmt.close();
		conexao.close();
	}
}
