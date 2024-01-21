package oo.polimorfismo;

public class Jantar {

	public static void main(String[] args) {
		
		Pessoa convidado = new Pessoa(99.6);
		
		Arroz igrediente1 = new Arroz(0.25);
		Feijao igrediente2 = new Feijao(0.18);
//		Comida igrediente3 = new Comida(0.1); // Agora, não vou poder mais usar essa classe Comida, pois ela é abstrata
		
		System.out.println(convidado.getPeso());
		
		convidado.comer(igrediente1);
		convidado.comer(igrediente2);
//		convidado.comer(igrediente3);
		
		System.out.println(convidado.getPeso());
		
		Sorvete sobremesa = new Sorvete(0.4);
		convidado.comer(sobremesa);
		
		System.out.println(convidado.getPeso());
	}
}
