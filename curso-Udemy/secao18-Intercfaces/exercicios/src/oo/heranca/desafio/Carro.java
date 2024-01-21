package oo.heranca.desafio;

public class Carro {

	public final int VELOCIDADE_MAXIMA;
	protected int velocidadeAtual; // protected, visto que não quero que isso seja visível, pela possibilidade de ser alterado
//	protected int delta = 5; // protected, visto que não quero que isso seja visível, pela possibilidade de ser alterado
	private int delta = 5;
	
	// coloquei protected - visto que não quero que seja instanciado diretamente pela classe Carro
	// somente pelas suas heranças.
	protected Carro(int velocidadeMaxima) {
		VELOCIDADE_MAXIMA = velocidadeMaxima;
	}
	
	public int getDelta() {
		return delta;
	}


	public void setDelta(int delta) {
		this.delta = delta;
	}


	public void acelerar() {
		
		if(velocidadeAtual + getDelta() > VELOCIDADE_MAXIMA) {
			velocidadeAtual = VELOCIDADE_MAXIMA;
		} else {
			velocidadeAtual += getDelta();
		}
	}
	
	public void frear() {
		if(velocidadeAtual >= getDelta()) {
			velocidadeAtual -= getDelta();
		} else {
			velocidadeAtual = 0;
		}
	}
	
	public String toString() {
		return "Velocidade atual " + velocidadeAtual + "km/h.";
	}
}
