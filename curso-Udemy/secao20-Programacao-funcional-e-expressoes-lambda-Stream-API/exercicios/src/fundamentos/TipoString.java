package fundamentos;

public class TipoString {

	public static void main(String[] args) {
		System.out.println("Olá pessoal");
		System.out.println("Olá pessoal".charAt(0));
		System.out.println("Olá pessoal".charAt(1));
		System.out.println("Olá pessoal".charAt(2));
		System.out.println("Olá pessoal".charAt(3));
		System.out.println("Olá pessoal".charAt(4));
		System.out.println("Olá pessoal".charAt(5));
		
		String s = "Hello WounderWorld";
		s = s.toUpperCase();
		s = "Good Morning";
		System.out.println(s.concat("!!!"));
		System.out.println(s + "!!!");
		System.out.println(s.startsWith("Good"));
		System.out.println(s.startsWith("good"));
		System.out.println(s.toLowerCase().startsWith("good"));
		System.out.println(s.endsWith("Morning"));
		System.out.println(s.endsWith("morning"));
		System.out.println(s.toLowerCase().endsWith("Morning"));
		System.out.println(s.equals("good morning"));
		System.out.println(s.equalsIgnoreCase("good morning"));
		
		var nome = "Leonardo";
		var sobrenome = "Teramatsu";
		var idade = 27;
		var salario = 3000.00;
		
		System.out.println("Nome: " + nome + "\nSobrenome: " + sobrenome + "\nIdade: " + idade + "\nSalario: " + salario);
		System.out.printf("O senhor %s %s tem %d anos e ganha R$ %.2f.", nome, sobrenome, idade, salario);
		
		String frase = String.format("\nO senhor %s %s tem %d anos e ganha R$ %.2f.", nome, sobrenome, idade, salario);
		System.out.println(frase);
		
		String original = "abcde FGHIJ ABC abc DEFG   ";
	    String s01 = original.toLowerCase();
	    String s02 = original.toUpperCase();
	    String s03 = original.trim();
	    String s04 = original.substring(2);
	    String s05 = original.substring(2, 9);
	    String s06 = original.replace('a', 'x');
	    String s07 = original.replace("abc", "xy");
	    int i = original.indexOf("bc");
	    int j = original.lastIndexOf("bc");
	    System.out.println("Original: -" + original + "-");
	    System.out.println("toLowerCase: -" + s01 + "-");
	    System.out.println("toUpperCase: -" + s02 + "-");
	    System.out.println("trim: -" + s03 + "-");
	    System.out.println("substring(2): -" + s04 + "-");
	    System.out.println("substring(2, 9): -" + s05 + "-");
	    System.out.println("replace('a', 'x'): -" + s06 + "-");
	    System.out.println("replace('abc', 'xy'): -" + s07 + "-");
	    System.out.println("Index of 'bc': " + i);
	    System.out.println("Last index of 'bc': " + j);
	    
	    s = "potato apple lemon";
	    String[] vect = s.split(" ");
	    String word1 = vect[0];
	    String word2 = vect[1];
	    String word3 = vect[2];
	}
}
