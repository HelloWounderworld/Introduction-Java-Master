package oo.polimorfismo;

public class Jantar {

	public static void main(String[] args) {
		
		Pessoa convidado = new Pessoa(99.6);
		
		Arroz igrediente1 = new Arroz(0.25);
		Feijao igrediente2 = new Feijao(0.18);
		
		System.out.println(convidado.getPeso());
		
		convidado.comer(igrediente1);
		convidado.comer(igrediente2);
		
		System.out.println(convidado.getPeso());
		
		Sorvete sobremesa = new Sorvete(0.4);
		convidado.comer(sobremesa);
		
		System.out.println(convidado.getPeso());
	}
}
