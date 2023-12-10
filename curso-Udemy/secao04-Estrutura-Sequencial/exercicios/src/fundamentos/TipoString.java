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
	}
}
