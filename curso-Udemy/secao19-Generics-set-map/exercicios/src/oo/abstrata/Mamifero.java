package oo.abstrata;

public abstract class Mamifero extends Animal {
	
	// Nessa classe abstrata que herdou a classe abstrata, Animal, não precisa implementar o método
	// abstrado que foi definido na classe Animal. Isso não significa que não seja impossível implementar

//	@Override
//	public String mover() {
//		return "Usando as patas";
//	}
	
	// Caso quisermos que um método não seja mais sobrescrito nas subclasses, então, bastaríamos
	// colocar "final" nesse método, apontando que aqui é o ponto final dela.
	// Que é diferente dos métodos abstratos, que, quando tornam um método concreto, é necessário
	// que sejam sobrescritos.
	
//	@Override
//	public final String mover() {
//		return "Saindo do lugar";
//	}
	
	public abstract String mamar();
}
