package excecao.personalizadaB;

import excecao.Aluno;

public class TesteValidacoes {

	public static void main(String[] args) {
		
		try {
//			Aluno aluno = new Aluno("", -7);
//			Aluno aluno = new Aluno("    ", -7);
//			Aluno aluno = new Aluno("Leonardo", -7);
//			Aluno aluno = new Aluno("Leonardo  ", -7);
//			Aluno aluno = new Aluno("Leonardo", 10);
			Aluno aluno = null;
			Validar.aluno(aluno);
		} catch (StringVaziaException | NumeroForaDoIntervaloException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
		// Note que, só de ter mudado RuntimeException para Exception nas classes
		// NumeroForaDoIntervaloException e StringVaziaException
		// Não vamos conseguir rodar o Validar.aluno(null); fora do try/catch
//				Validar.aluno(null);
//		Aluno aluno = null;
//		Validar.aluno(aluno);
		
		// Nem quando completamos o processo de instanciação
//		Aluno aluno = new Aluno("", -7);
//		Validar.aluno(aluno);
		
		System.out.println("Fim :)");
	}
}
