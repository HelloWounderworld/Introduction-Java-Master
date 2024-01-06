package controle;

public class SwitchSemBreak {

	public static void main(String[] args) {
		
		String faixa = "branca";
		
		switch(faixa.toLowerCase()) {
		case "preta":
			System.out.println("Sei o Bassai-Dai...");
		case "marrom":
			System.out.println("Sei o Tekki Shodan");
		case "roxa":
			System.out.println("Sei o Heian Godan");
		case "verde":
			System.out.println("Sei o Heian Yodan");
		case "laranja":
			System.out.println("Sei o Heian Sandan");
		case "vermelha":
			System.out.println("Sei o Heian Nidan");
		case "amarela":
			System.out.println("Sei o Heian Shodan");
		default:
			System.out.println("Sei porra nenhuma! Só apanhei e me lasquei!");
		}
		
		System.out.println("Fim!");
		
		int idade = 3;
		
		switch(idade) {
		case 3:
			System.out.println("Tu é o Terence Tao! Sabe teoria analítica dos números!");
		case 2:
			System.out.println("Sabe falar!");
		case 1:
			System.out.println("Sabe andar!");
		case 0:
			System.out.println("Sabe respirar!");
		}
	}
}
