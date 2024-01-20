package fundamentos;

import java.util.Scanner;

public class TipoStringEqual {

	public static void main(String[] args) {
		System.out.println("2" == "2");
		
		String s1 = new String("2");
		System.out.println("2" == s1);
		System.out.println("2".equals(s1));
		
		Scanner entrada = new Scanner(System.in);
		
		// next() ele tira os espaços em branco. O nextLine(), que não tira.
		String s2 = entrada.next();
		System.out.println(s2);
		System.out.println("2" == s2.trim()); // A real é que nem precisa de trim, porque o next() faz esse trabalho tbm
		System.out.println("2".equals(s2.trim()));
		
		entrada.close();
	}
}
