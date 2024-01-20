package oo.heranca;

public class Jogo {

	public static void main(String[] args) {
		
		Jogador j1= new Jogador();
		j1.x = 10;
		j1.y = 20;
		
		// Condição if era "norte".equalsIgnoreCase(direcao)
//		j1.andar("norte");
//		j1.andar("norte");
//		j1.andar("norte");
//		j1.andar("norte");
		
		j1.andar(Direcao.NORTE);
		j1.andar(Direcao.LESTE);
		j1.andar(Direcao.NORTE);
		j1.andar(Direcao.OESTE);
		
		System.out.println(j1.x);
		System.out.println(j1.y);
	}
}
