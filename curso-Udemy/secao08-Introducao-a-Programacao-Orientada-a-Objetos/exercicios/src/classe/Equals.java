package classe;

import java.util.Date;

public class Equals {

	public static void main(String[] args) {
		
		Usuario u1 = new Usuario();
		u1.nome = "Pedro Silva";
		u1.email = "pedro.silva@ezemail.com.br";
		
		Usuario u2 = new Usuario();
		u2.nome = "Pedro Silva";
		u2.email = "pedro.silva@ezemail.com.br";
		
		// Objetos distintos na memória - false
		System.out.println(u1 == u2);
		
		// Fará exatamente a mesma coisa de cima - false
//		System.out.println(u1.equals(u2));
//		System.out.println(u2.equals(u1));
		
		// Agora que defini o método equals dentro da classe Usuario - true
		System.out.println(u1.equals(u2));
		System.out.println(u2.equals(u1));
		
		// Tornando o método equals da classe Usuario mais robusto
		// Note que, coloquei uma classe nada haver com o que o equals
		// avalia na classe Usuário
		System.out.println(u1.equals(new Date()));
		System.out.println(u2.equals(new Date()));
	}
}
