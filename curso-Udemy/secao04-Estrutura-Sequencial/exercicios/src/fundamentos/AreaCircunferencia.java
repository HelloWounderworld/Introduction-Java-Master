package fundamentos;

public class AreaCircunferencia {

	public static void main(String[] args) {
		double raio = 3.4;
//		final double pi = 3.14159;
		final double PI = 3.14159;
		
//		pi = 1;
//		double area = pi * raio * raio;
		double area = PI * raio * raio;
		
		System.out.println(area);
		
		raio = 10;
		area = PI * raio * raio;
		
		System.out.println("Area = " + area + "m2.");
	}
}
