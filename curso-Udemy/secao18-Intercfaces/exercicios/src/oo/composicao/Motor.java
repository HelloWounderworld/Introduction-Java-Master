package oo.composicao;

public class Motor {

	Carro carro; // Essa atribuição ira exibir um erro na classe Carro na atribuição que está instanciada
	boolean ligado = false;
	double fatorInjecao = 1;
	
	// Definindo o parametro explicito
	Motor(Carro carro) {
		this.carro = carro;
	}
	
	int giros() {
		if(!ligado) {
			return 0;
		} else {
			return (int) Math.round(fatorInjecao * 3000);
		}
	}
}
