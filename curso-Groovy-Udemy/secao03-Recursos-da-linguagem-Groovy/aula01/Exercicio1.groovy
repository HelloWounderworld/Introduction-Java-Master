package aula

class Exercicio1 {
	static main(args) {
		println "Hello WounderWorld Groovy"
		
		String nome = "Leonardo"
		int idade = 26
		
		String frase = "O " + nome + " tem " + idade + " anos"
		// Interpolacao de String
		
		String frase2 = "O $nome tem $idade anos"
		
		println(frase)
		println(frase2)
	}
}
