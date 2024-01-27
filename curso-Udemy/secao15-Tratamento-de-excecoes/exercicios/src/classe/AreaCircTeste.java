package classe;

public class AreaCircTeste {

	public static void main(String[] args) {
		
		// Note que, estando double pi, na classe AreaCirc, conseguimos alterar o valor dela
		AreaCirc a1 = new AreaCirc(10);
//		a1.pi = 10;
		System.out.println("Raio: " + a1.raio);
//		System.out.println("PI: " + a1.pi);
		System.out.println(a1.area());
		
		AreaCirc a2 = new AreaCirc(5);
//		a2.pi = 5;
		System.out.println("Raio: " + a2.raio);
//		System.out.println("PI: " + a2.pi);
		System.out.println(a2.area());
		
		// Agora, com static double pi, na classe AreaCirc.
		// Como prova disso, note que, a última vez que alterei o valor de pi
		// foi em a2.pi = 5.
		// Se printarmos o a3.pi, iremos ver que ela terá o mesmo valor da última alteração
		// sem mesmo ter tido a necessidade de definirmos um valor para ela.
		AreaCirc a3 = new AreaCirc(5);
		System.out.println("Raio: " + a3.raio);
//		System.out.println("PI: " + a3.pi); // Quando o atributo de uma classe está em itálico é indicativo de que ela é estático
		System.out.println(a3.area());
		
		// Visto que a constante ficou estático, conseguimos acessar ela sem instanciar a classe
//		System.out.println(AreaCirc.pi);
		
		// Transformei o atributo pi em uma constante. Agora, somente, consigo vizualizar ela
		System.out.println(AreaCirc.PI);
		System.out.println((Math.PI));
		
		// Acessando o método estático "area" definido na classe AreaCirc
		double a4 = AreaCirc.area(3);
//		System.out.println("Raio: " + a4.raio); // dará errado
//		System.out.println("PI: " + a3.pi); // Quando o atributo de uma classe está em itálico é indicativo de que ela é estático
//		System.out.println(a4.area()); // dará errado
		System.out.println(a4);
		System.out.println(AreaCirc.area(10));
	}
}
