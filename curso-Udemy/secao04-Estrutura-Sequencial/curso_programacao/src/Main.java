import java.util.Scanner;

import java.util.Locale;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//		System.out.println("Hello WounderWorld!");
//		System.out.print("Hello WounderWorld!");
//		System.out.println("Hello WounderWorld!");
//
//		int y = 32;
//		System.out.print(y);
//		System.out.println(y);
//
//		double x = 10.35464161;
//		System.out.print(x);
//    	System.out.println(x);
//		System.out.printf("%.2f%n", x);
//    	System.out.printf("%.4f%n", x);
//		// Locale.setDefault(Locale.US);
//		System.out.printf("%.2f%n", x);
//    	System.out.printf("%.4f%n", x);
//		System.out.println("RESULTADO = "+ x + " METROS");
//		System.out.printf("RESULTADO = %f metros %n", x);
//		System.out.printf("RESULTADO = %.2f metros %n", x);
//
//		String nome = "Leonardo";
//		int idade = 26;
//		double renda = 2400.45646;
//		System.out.printf("%s tem %d anos e ganha R$ %.2f reais%n", nome, idade, renda);
//
//		String product1 = "Computer";
//		String product2 = "Office desk";
//
//		int age = 30;
//		int code = 5290;
//		char gender = 'F';
//
//		double price1 = 2100.0;
//		double price2 = 650.50;
//		double measure = 53.234567;
//
//		System.out.printf("Products:%n%s, which price is $ %.2f%n%s, which price is $ %.2f%n%nRecord: %d years old, code %d and gender: %s%n%nMeasure with eight decimal places: %.8f%nRouded (three decimal places): %.3f%n", product1, price1, product2, price2, age, code, gender, measure, measure);
//		Locale.setDefault(Locale.US);
//		System.out.printf("US decimal point: %.3f", measure);

		Scanner sc = new Scanner(System.in);

//		String x ;
//		x = sc.next();
//		double x;
//	    x = sc.nextDouble();
//		char x;
//	    x = sc.next().charAt(0);
		String x;
		int y;
		double z;
		x = sc.next();
		y = sc.nextInt();
		z = sc.nextDouble();

//		System.out.println("Você digitou: " + x);
		System.out.println("Você digitou: ");
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);

		sc.close();
	}

}
