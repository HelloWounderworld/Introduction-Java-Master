package oo.heranca.desafio;

public class Ferrari extends Carro implements Esportivo, Luxo {
	
	private boolean ligarTurbo;
	private boolean ligarAr;
	
	public Ferrari() {
		super(340);
	}
	
	public Ferrari(int velocidadeMaxima) {
		super(velocidadeMaxima);
//		delta = 15;
		setDelta(15);
	}
	
	@Override
	public void ligarTurbo() {
//		delta = 35;
//		setDelta(35);
		ligarTurbo = true;
	}
	
	@Override
	public void desligarTurbo() {
//		delta = 15;
//		setDelta(15);
		ligarTurbo = false;
	}
	
	@Override
	public void ligarAr() {
		ligarAr = true;
	}
	
	@Override
	public void desligarAr() {
		ligarAr = false;
	}
	
	@Override
	public int getDelta() {
		if(ligarTurbo && !ligarAr) {
			return 35;
		} else if(ligarTurbo && ligarAr) {
			return 30;
		} else if(!ligarTurbo && !ligarAr) {
			return 20;
		} else {
			return 15;
		}
	}

	// Override - serve para entendermos que um método está sendo sobrescrito um método que existe na classe pai
	// Embora não seja obrigatório está dentor das boas práticas para conseguirmos entender melhor tal método.
//	@Override
//	void acelerar() {
//		velocidadeAtual += 15;
//	}
}
