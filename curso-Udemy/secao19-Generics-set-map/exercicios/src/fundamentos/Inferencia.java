package fundamentos;

public class Inferencia {

	public static void main(String[] args) {
		
		double a = 4.5; //declaracao da variavel e inicializacao da mesma
		System.out.println(a);
		
		a = 12;
		System.out.println(a);
		
//		a = "... ";
		
		var b = 4.5;
		System.out.println(b);
		
		var c = "Texto";
		System.out.println(c);
		
		c= "Outro texto";
		System.out.println(c);
		
//		c = 4.5;
		
		double d; // variavel foi declarada
		d = 123.65; // variavel foi inicializada
		System.out.println(d); // variavel foi usada
		
//		var e; // Não é possível declarar uma variavel usando o var
//		e = 123.65;
		var e = 123.65;
		System.out.println(e);
		
		var f = 12;
//		f = 12.01;
		System.out.println(f);
	}
}
