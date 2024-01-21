package oo.polimorfismo;

public class Comida {
	
	// Polimorfando as classes Arroz, Feijao e Sorvete
	// Para conseguirmos criar um único método comer na classe Pessoa!!
	// Polimorfismo é como se fizessemos uma generalização de um conjunto de classe para uma única classe.
	// Como na prática, vimos que criamos uma única classe, Comida, e nela, relacionamos um conjunto de
	// subclasses Arroz, Feijao e Sorvete - as subcategorias
	// No caso, a categoria, Comida, tem uma estrutura fundamental
	// cuja estrutura, está presente nas outras três categorias.
	// Logo, podemos considerar esse grau de generalidade para uma única categoria
	// de forma que resulte nas outras três subcategorias que tenha as mesmas estruturas
	// diferindo somente nos seus valores e mais algumas outras estruturas que é única de cada
	// subcategorias.

	private double peso;
	
	public Comida(double peso) {
		setPeso(peso);
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		if(peso >= 0) {
			this.peso = peso;
		}
	}
}
