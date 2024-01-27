package oo.abstrata;

public class TesteAbstrato {

	public static void main(String[] args) {
		
		Animal cachorro1 = new Cachorro();
		System.out.println(cachorro1.respirar());
		System.out.println(cachorro1.mover());
//		System.out.println(cachorro1.mamar()); // Note que, não podemos acessar esse método mamar, pois ela está definido na classe, Mamifero
		
		Mamifero cachorro2 = new Cachorro();
		System.out.println(cachorro2.respirar());
		System.out.println(cachorro2.mover());
		System.out.println(cachorro2.mamar()); // Agora, consigo usar esse método, pois, ela está definido em Mamifero, a instanciação foi feito via essa classe.
	}
}
