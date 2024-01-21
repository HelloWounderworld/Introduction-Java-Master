package oo.encapsulamento;

public class Pessoa {

	private String nome;
	private String sobrenome;
//	public int idade;
	private int idade;

	public Pessoa(String nome, String sobrenome, int idade) {
//		this.idade = idade;
		setIdade(idade);
		setSobrenome(sobrenome);
		setNome(nome);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public String nomeCompleto() {
		return getNome() + " " + getSobrenome();
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
		return "Olá, meu nome é " + nomeCompleto() + " e tenho " + idade + " anos.";
	}
}
