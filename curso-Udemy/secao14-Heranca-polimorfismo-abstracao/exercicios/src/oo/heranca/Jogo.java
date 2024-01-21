package oo.heranca;

public class Jogo {

	public static void main(String[] args) {
		
//		Jogador j1 = new Jogador();
//		j1.x = 10;
//		j1.y = 10;
		
//		Monstro j1 = new Monstro();
//		j1.x = 10;
//		j1.y = 10;
		
		Monstro monstro = new Monstro();
		monstro.x = 10;
		monstro.y = 10;
		
//		Jogador j2 = new Jogador();
//		j2.x = 10;
//		j2.y = 11;
//		j2.y = 12; // Não vão conseguir atacar entre j1 e j2
		
//		Heroi j2 = new Heroi();
//		j2.x = 10;
//		j2.y = 11;
//		j2.y = 12; // Não vão conseguir atacar entre j1 e j2
		
		Heroi heroi = new Heroi(10, 11);
//		heroi.x = 10;
//		heroi.y = 11;
		
		// Condição if era "norte".equalsIgnoreCase(direcao)
//		j1.andar("norte");
//		j1.andar("norte");
//		j1.andar("norte");
//		j1.andar("norte");
		
//		j1.andar(Direcao.NORTE);
//		j1.andar(Direcao.LESTE);
//		j1.andar(Direcao.NORTE);
//		j1.andar(Direcao.OESTE);
		
		System.out.println("Vida dos jogadores:");
		System.out.println("Monstro tem => " + monstro.vida);
		System.out.println("Heroi tem => " + heroi.vida);
		
		System.out.println();
		
		monstro.atacar(heroi);
		heroi.atacar(monstro);
		
		monstro.atacar(heroi);
		heroi.atacar(monstro);
		
		monstro.andar(Direcao.NORTE);
		monstro.atacar(heroi);
		heroi.atacar(monstro);
		
		System.out.println("Vida dos jogadores:");
		System.out.println("Monstro tem => " + monstro.vida);
		System.out.println("Heroi tem => " + heroi.vida);
		
		System.out.println();
		
		System.out.println(monstro.x);
		System.out.println(monstro.y);
	}
}
