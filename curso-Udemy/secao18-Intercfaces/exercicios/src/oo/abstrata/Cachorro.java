package oo.abstrata;

public class Cachorro extends Mamifero {

	// o método mover, mesmo sendo abstrato na classe Animal, não precisei implementar
	// pois ela já foi implementado na classe Mamifero que herdou da classe Animal.
	// Mas, caso, na classe abstrata, Mamifero, que herdou da classe abstrata, Animal,
	// o método abstrato, mover, que está definido na classe abstrata, Animal, não for implementada
	// na classe abstrata, Mamifero, então nessa classe, Cachorro, que não é abstrato
	// será necessário implementar esse método.
	@Override
	public String mover() {
		return "Usando as patas";
	}

	@Override
	public String mamar() {
		// TODO Auto-generated method stub
		return null;
	}
}
