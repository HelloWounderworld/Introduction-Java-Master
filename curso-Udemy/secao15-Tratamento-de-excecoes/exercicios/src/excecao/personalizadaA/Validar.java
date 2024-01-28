package excecao.personalizadaA;

import excecao.Aluno;

public class Validar {

	private Validar() {
		// TODO Auto-generated constructor stub
	}
	
	public static void aluno(Aluno aluno) {
		
		if(aluno == null) {
			throw new IllegalArgumentException("O aluno está nulo!");
		}
		
		if(aluno.nome == null || aluno.nome.trim().isEmpty()) {
			// StringVaziaException = Nome da classe personalizada que criei
			throw new StringVaziaException("nome");
		}
		
		if(aluno.nota < 0 || aluno.nota > 10) {
			throw new NumeroForaDoIntervaloException("nota");
		}
	}
}
