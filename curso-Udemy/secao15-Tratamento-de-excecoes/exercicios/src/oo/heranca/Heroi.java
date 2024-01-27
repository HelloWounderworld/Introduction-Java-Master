package oo.heranca;

public class Heroi extends Jogador {
	
	// Quando vc herda de uma classe, o "super" é o que te permite acessar os atributos da classe pai
	// e até colocar valores nela.
	// Assim, como serve, também, para acessar os métodos da classe pai
	
	// Ativando a genética recebida do pai.
	// Essa é a maneira de uma classe herdada
	// ser instanciada de forma explícita
	public Heroi(int x, int y) {
		super(x, y);
	}

	// Herença - Estou herdando as qualidades do Jogador
	// Se eu quiser usar o método que já existe dentro da classe pai sem alterar nada?
	public boolean atacar(Jogador oponente) {
		// só com a forma abaixo consigo repetir o mesmo método da classe pai
//		return super.atacar(oponente);
		
		// Caso eu queira modificar a forma de ataque de forma mais suscinta
		// sem a necessidade de montar toda uma estrutura como no método, atacar, de baixo?
		// Aqui estou repetindo o ataque três vezes causando 30 de danos.
		boolean ataque1 = super.atacar(oponente);
		boolean ataque2 = super.atacar(oponente);
		boolean ataque3 = super.atacar(oponente);
		
		return ataque1 || ataque2 || ataque3;
	}
	
	// Posso definir o mesmo método que existe na classe pai, mas com alguma alteração
//	boolean atacar(Jogador oponente) {
//		
//		int deltaX = Math.abs(x - oponente.x);
//		int deltaY = Math.abs(y - oponente.y);
//		
//		if(deltaX == 0 && deltaY == 1) {
//			oponente.vida -= 20;
//			return true;
//		} else if(deltaX == 1 && deltaY == 0) {
//			oponente.vida -= 20;
//			return true;
//		} else {
//			return false;
//		}
//	}
}
