package excecao;

public class Basico {

	public static void main(String[] args) {
		
		// Erro: java.lang.ArithmeticException
		try {
			System.out.println(7 / 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Erro: java.lang.NullPointerException
		// Pilhas e Métodos:
		// Exception in thread "main" java.lang.NullPointerException: Cannot read field "nome" because "aluno" is null
		// 			at excecao.Basico.imprimirAluno(Basico.java:15)
		// 			at excecao.Basico.main(Basico.java:11)
		// Leitura é de baixo para cima
		Aluno a1 = null;
//		imprimirAluno(a1);
		
		try {
			imprimirAluno(a1);
		} catch(Exception excecao) {
			System.out.println("Ocorreu um erro no momento de imprimir o nome do usuario");
		}
	}
	
	public static void imprimirAluno(Aluno aluno) {
		System.out.println(aluno.nome);
	}
}
