package jdbc;

public class DAOTeste {

	public static void main(String[] args) {
		
		DAO dao = new DAO();
		
		String sql = "INSERT INTO pessoas (nome) VALUES (?)";
		System.out.println(dao.incluir(sql, "Albert Einstein")); // Vamos conseguir verificar os ids que foram gerados
		System.out.println(dao.incluir(sql, "Alan Turing"));
		System.out.println(dao.incluir(sql, "Kiyoshi Oka"));
		
		dao.close();
	}
}
