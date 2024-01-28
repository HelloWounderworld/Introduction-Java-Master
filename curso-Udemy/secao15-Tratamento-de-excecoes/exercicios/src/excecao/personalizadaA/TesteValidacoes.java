package excecao.personalizadaA;

import excecao.Aluno;

public class TesteValidacoes {

	public static void main(String[] args) {
		
//		try {
////			Aluno aluno = new Aluno("", -7);
////			Aluno aluno = new Aluno("    ", -7);
//			Aluno aluno = new Aluno("Leonardo", -7);
////			Aluno aluno = new Aluno("Leonardo  ", -7);
////			Aluno aluno = new Aluno("Leonardo", 10);
//			Validar.aluno(aluno);
//		} catch (StringVaziaException e) {
//			// TODO Auto-generated catch block
////			e.printStackTrace();
//			System.out.println("Entrei - StringVaziaException");
//			System.out.println(e.getMessage());
//		} catch (NumeroForaDoIntervaloException e) {
//			System.out.println("Entrei - NumeroForaDoIntervaloException");
//			System.out.println(e.getMessage());
//		}
		
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
		
		System.out.println("Fim :)");
	}
}
