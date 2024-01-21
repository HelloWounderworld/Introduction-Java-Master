package oo.composicao;

import javax.annotation.processing.SupportedSourceVersion;

public class CursoTeste {

	public static void main(String[] args) {
		
		Aluno aluno1 = new Aluno("João");
		Aluno aluno2 = new Aluno("Maria");
		Aluno aluno3 = new Aluno("Pedro");
		
		Curso curso1 = new Curso("Java Completo");
		Curso curso2 = new Curso("Web 2023");
		Curso curso3 = new Curso("React Native");
		
		curso1.adicionarAluno(aluno1);
		curso1.adicionarAluno(aluno2);
		
		curso2.adicionarAluno(aluno1);
		curso2.adicionarAluno(aluno3);
		
		aluno1.adicionarCurso(curso3);
		aluno2.adicionarCurso(curso3);
		aluno3.adicionarCurso(curso3);
		
		// Note que, a forma como adicionamos os alunos e os cursos acima
		// Mostra a maneira como podemos realizar isso de forma bidirecional
		// Ou seja, consigo matricular um aluno num curso, através do curso
		// Assim como, podemos matricular um aluno num curso, o próprio aluno escolhendo o curso
		
		for(Aluno aluno: curso1.alunos) {
			System.out.println("Estou matriculando no curso 1...");
			System.out.println("e o meu nome é " + aluno.nome);
			System.out.println();
		}
		
		for(Aluno aluno: curso2.alunos) {
			System.out.println("Estou matriculando no curso 2...");
			System.out.println("e o meu nome é " + aluno.nome);
			System.out.println();
		}
		
		for(Aluno aluno: curso3.alunos) {
			System.out.println("Estou matriculando no curso 3...");
			System.out.println("e o meu nome é " + aluno.nome);
			System.out.println();
		}
		
		// Precisa do método toString para possibilitar a tal exibição
		// O que uma relação biunívoca nos possibilita
		System.out.println("Mostrar alunos matriculado desse nesse curso " + aluno1.cursos.get(0).alunos);
		
		Curso cursoEncontrado = aluno1.obterCursoPorNome("Java Completo");
		
		if(cursoEncontrado != null) {
			 System.out.println(cursoEncontrado.nome);
			 System.out.println(cursoEncontrado.alunos);
		}
	}
}
