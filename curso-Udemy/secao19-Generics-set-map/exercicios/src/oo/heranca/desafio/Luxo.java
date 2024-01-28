package oo.heranca.desafio;

public interface Luxo {

	void ligarAr();
	void desligarAr();
	
	// Esse método não precisa ser implementada na classe Ferrari que implementou essa interface, Luxo
	// Mesmo que não foi implementada na classe ferrari, podemos usar esse método da interface.
	default int velocidadeDoAr() {
		return 1;
	}
}
