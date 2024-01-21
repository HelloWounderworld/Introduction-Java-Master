package oo.encapsulamento;

public class Pessoa {

	private String nome;
//	public int idade;
	private int idade;

	public Pessoa(String nome, int idade) {
//		this.idade = idade;
		setIdade(idade);
		setNome(nome);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	// Getter
	public int getIdade() {
		return idade;
	}
	
	// Setter
	public void setIdade(int novaIdade) {
		novaIdade = Math.abs(novaIdade);
		if(novaIdade >= 0 && novaIdade <= 120) {
			this.idade = novaIdade;
		}
	}

	public String toString() {
		return "Olá, meu nom é " + nome + " e tenho " + idade + " anos.";
	}
}
