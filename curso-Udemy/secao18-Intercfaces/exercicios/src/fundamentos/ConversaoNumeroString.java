package fundamentos;

public class ConversaoNumeroString {

	public static void main(String[] args) {
		Integer num1 = 10000;
		System.out.println(num1);
		System.out.println(num1.toString());
		System.out.println(num1.toString().length());
		
		int num2 = 10000;
		System.out.println(num2);
		System.out.println(Integer.toString(num2));
		System.out.println(Integer.toString(num2).length());
		
		System.out.println(("" + num1).length());
		System.out.println(("" + num2).length());
		
		// Para outros wrappers do tipo primitivo numérico, temos esse recurso do toString tbm
	}
}
