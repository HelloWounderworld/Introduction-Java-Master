package oo.heranca.desafio;

public class Ferrari extends Carro {
	
	Ferrari() {
		super(340);
	}
	
	Ferrari(int velocidadeMaxima) {
		super(velocidadeMaxima);
		delta = 15;
	}

	// Override - serve para entendermos que um método está sendo sobrescrito um método que existe na classe pai
	// Embora não seja obrigatório está dentor das boas práticas para conseguirmos entender melhor tal método.
//	@Override
//	void acelerar() {
//		velocidadeAtual += 15;
//	}
}
