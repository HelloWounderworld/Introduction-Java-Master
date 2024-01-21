package oo.heranca.desafio;

public class Carro {

	public final int VELOCIDADE_MAXIMA;
	protected int velocidadeAtual; // protected, visto que não quero que isso seja visível, pela possibilidade de ser alterado
	protected int delta = 5; // protected, visto que não quero que isso seja visível, pela possibilidade de ser alterado
	
	// coloquei protected - visto que não quero que seja instanciado diretamente pela classe Carro
	// somente pelas suas heranças.
	protected Carro(int velocidadeMaxima) {
		VELOCIDADE_MAXIMA = velocidadeMaxima;
	}
	
	public void acelerar() {
		
		if(velocidadeAtual + delta > VELOCIDADE_MAXIMA) {
			velocidadeAtual = VELOCIDADE_MAXIMA;
		} else {
			velocidadeAtual += delta;
		}
	}
	
	public void frear() {
		if(velocidadeAtual >= delta) {
			velocidadeAtual -= delta;
		} else {
			velocidadeAtual = 0;
		}
	}
	
	public String toString() {
		return "Velocidade atual " + velocidadeAtual + "km/h.";
	}
}
