package fundamentos;

import java.util.Scanner;

public class Wrapper {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		// byte
		Byte b = 100; // byte
		Short s = 1000; // short
		Integer i = 10000; // int
		Integer j = Integer.parseInt("1000");
		Integer p = Integer.parseInt(entrada.nextLine());
		Long l = 100000L; // long
		
		System.out.println(b.byteValue());
		System.out.println(s.toString());
		System.out.println(j);
		System.out.println(p);
		System.out.println(p * 3);
		System.out.println(l / 3);
		System.out.println(l / 3.0);
		
		entrada.close();
		
		Float f = 123.10F; // float
		System.out.println(f);
		
		Double d = 1234.5678; // double
		System.out.println(d);
		
		Boolean bo = Boolean.parseBoolean("true"); //boolean
		System.out.println(bo);
//		System.out.println(bo.toUpperCase()); // vai dar errado
		System.out.println(bo.toString().toUpperCase());
		
		boolean bu = Boolean.parseBoolean("true");
		System.out.println(bu);
//		System.out.println(bu.toString().toUpperCase()); // Vai dar errado
		System.out.println(("" + bu).toUpperCase());
		
		Character c = '#'; // chr
		System.out.println(c.toString());
		System.out.println(c + "...");
	}
}
