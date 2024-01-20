package fundamentos;

public class NotacaoPonto {

	public static void main(String[] args) {
		
//		double a = 2.3;
		String s = "Bom dia X";
		
		System.out.println(s.toUpperCase());
		System.out.println(s); // Note que, o método "toUpperCase()" aplicado, não foi permanente
		
		s = s.toUpperCase();
		System.out.println(s);
		
		System.out.println(s.replace("X", "WounderWorld!"));
		System.out.println(s);
		
		s = s.replace("X", "WounderWorld!");
		System.out.println(s);
		
		s = s.concat("?????");
		System.out.println(s);
		
		System.out.println("Leo".toUpperCase());
		
		String x = "Leo".toUpperCase();
		System.out.println(x);
		
		String y = "Bom dia X"
				.replace("X", "Lupin")
				.toUpperCase()
				.concat("!!!");
		System.out.println(y);
		
		// Tipos primitivos não tem o operador "."
		int a = 3;
		System.out.println(a);
	}
}
