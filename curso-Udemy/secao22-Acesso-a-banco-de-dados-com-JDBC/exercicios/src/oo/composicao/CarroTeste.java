package oo.composicao;

public class CarroTeste {

	public static void main(String[] args) {
		
		// Relacao um para um
		// Um carro tem motor e um motor tem um carro
		// Relacao unidirecional - injetora
		
		Carro c1 = new Carro();
		System.out.println("O carro está ligado: " + c1.estaLigado());
		
		c1.ligar();
		System.out.println("O carro está ligado: " + c1.estaLigado());
		
		System.out.println("Quantos giros o motor está rodando: " + c1.motor.giros()); // Note que, através do atributo definido na classe Carro, estou acessando o método da classe Motor
		
		c1.acelerar();
		c1.acelerar();
		c1.acelerar();
		c1.acelerar();
		
		System.out.println("Quantos giros o motor está rodando: " + c1.motor.giros());
		
		c1.frear();
		c1.frear();
		c1.frear();
		c1.frear();
		c1.frear();
		c1.frear();
		c1.frear();
		
		// Faltou Encapsulamento!!!!
		c1.motor.fatorInjecao = -30;
		
		System.out.println("Quantos giros o motor está rodando: " + c1.motor.giros());
		
		// Depois que estabeleci uma relação bidirecional, por ter instanciado a classe Carro no Motor
		// Uma boa prática, só fizemos uma relação bidirecional - bijetora - biunívoca
		// se uma relação precisa de correspondência mútua
		System.out.println("Quantos giros o motor está rodando: " + c1.motor.carro.motor.carro.motor.giros());
	}
}
