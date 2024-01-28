package excecao;

public class Causa {

	public static void main(String[] args) {
		
//		metodoA(null);
		try {
			metodoA(null);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			if(e.getCause() != null) {
				// Mostrará a msg da exceção que causou o problema inicial
				System.out.println(e.getCause().getMessage());
			}
		}
	}
	
	static void metodoA(Aluno aluno) {
//		metodoB(aluno);
		// Suponhamos que não concordei com o programador que
		// simplesmente, chamou o método, metodoB, dentro do método, metodoA
		// Quero tratar o erro que der dentro do desse método, metodoA
		try {
			metodoB(aluno);
		} catch (Exception causa) {
			throw new IllegalArgumentException(causa);
		}
	}
	
	static void metodoB(Aluno aluno) {
		if(aluno == null) {
			throw new NullPointerException("Aluno está NULO!");
		}
		
		System.out.println(aluno.nome);
	}
}
