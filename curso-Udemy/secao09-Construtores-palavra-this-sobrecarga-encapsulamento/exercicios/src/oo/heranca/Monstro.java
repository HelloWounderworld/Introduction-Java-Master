package oo.heranca;

public class Monstro extends Jogador {

	// Herença - Estou herdando as qualidades do Jogador
	public Monstro() {
//		super(0, 0);
		this(0, 0);
	}
	
	public Monstro(int x, int y) {
		super(x, y);
	}
}
