package fundamentos;

public class ConversaoTipoPrimitivoNumerico {

	public static void main(String[] args) {
		
		double a = 1; // conversao implicita
		System.out.println(a);
		
		float b = (float) 1.0; // conversao explicita (CAST)
		float b2 = (float) 1.12324546;
		float b3 = (float) 1.123245464654561515555555;
		double b4 = 1.123245464654561515555555;
		System.out.println(b);
		System.out.println(b2);
		System.out.println(b3);
		System.out.println(b4);
		
		int c = 4;
		byte d = (byte) c;
		System.out.println(c);
		System.out.println(d);
		
		int c1 = 130;
		byte d1 = (byte) c1;
		System.out.println(c1);
		System.out.println(d1);
		
		double e = 1;
		int f = (int) e;
		System.out.println(e);
		System.out.println(f);
		
		double e1 = 1.99999;
		int f1 = (int) e1;
		System.out.println(e1);
		System.out.println(f1);
	}
}
