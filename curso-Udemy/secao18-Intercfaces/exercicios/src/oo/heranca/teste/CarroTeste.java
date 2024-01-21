package oo.heranca.teste;

import oo.heranca.desafio.Carro;
import oo.heranca.desafio.Civic;
import oo.heranca.desafio.Ferrari;

public class CarroTeste {

	public static void main(String[] args) {
		
		Carro c1 = new Civic();
		
		System.out.println("Carro normal");
		c1.acelerar();
		System.out.println(c1);
		
		c1.acelerar();
		System.out.println(c1);
		
		c1.acelerar();
		System.out.println(c1);
		
		System.out.println();
		
		Civic c2 = new Civic();
		
		System.out.println("Civic");
		c2.acelerar();
		System.out.println(c2);
		
		c2.acelerar();
		System.out.println(c2);
		
		c2.acelerar();
		System.out.println(c2);
		
		System.out.println();
		
		// Visto que o Ferrari está herdando do Carro
		// A forma como será instanciado, pode ser
		// Ferrari c3 = new Ferrari();
		Carro c3 = new Ferrari();
		
		// Mas não podemos fazer a instanciação
//		 Ferrari c3 = new Carro();
		// Pois seria como um pai estivesse herdando a genética do seu filho, sendo que é ao contrário.
		
		System.out.println("Ferrari");
		c3.acelerar();
		System.out.println(c3);
		
		c3.acelerar();
		System.out.println(c3);
		
		c3.acelerar();
		System.out.println(c3);
		
		System.out.println();
		
		Ferrari c4 = new Ferrari(200);
		
		// Mas não podemos fazer a instanciação
//		 Ferrari c3 = new Carro();
		// Pois seria como um pai estivesse herdando a genética do seu filho, sendo que é ao contrário.
		
		System.out.println("Ferrari");
		System.out.println("Velocidade máxima definida: " + c4.VELOCIDADE_MAXIMA);
		c4.acelerar();
		System.out.println(c4);
		
		c4.acelerar();
		System.out.println(c4);
		
		c4.acelerar();
		System.out.println(c4);
		
		c4.acelerar();
		System.out.println(c4);
		
		c4.acelerar();
		System.out.println(c4);
		
		c4.acelerar();
		System.out.println(c4);
		
		c4.acelerar();
		System.out.println(c4);
		
		c4.acelerar();
		System.out.println(c4);
		
		c4.acelerar();
		System.out.println(c4);
		
		c4.acelerar();
		System.out.println(c4);
		
		c4.acelerar();
		System.out.println(c4);
		
		c4.acelerar();
		System.out.println(c4);
		
		c4.acelerar();
		System.out.println(c4);
		
		c4.acelerar();
		System.out.println(c4);
		
		c4.acelerar();
		System.out.println(c4);
		
		c4.acelerar();
		System.out.println(c4);
		
		System.out.println();
		
		Ferrari c5 = new Ferrari(400);
		
		// Mas não podemos fazer a instanciação
//		 Ferrari c3 = new Carro();
		// Pois seria como um pai estivesse herdando a genética do seu filho, sendo que é ao contrário.
		
		System.out.println("Ferrari");
		System.out.println("Velocidade máxima definida: " + c5.VELOCIDADE_MAXIMA);
		
		c5.acelerar();
		System.out.println(c5);
		
		c5.acelerar();
		System.out.println(c5);
		
		System.out.println("Ativar o modo turbo!!!!");
		c5.ligarTurbo();
		c5.ligarAr();
		
		c5.acelerar();
		System.out.println(c5);
		
		System.out.println("Velocidade do ar do carro");
		System.out.println(c5.velocidadeDoAr());
		
		c5.acelerar();
		System.out.println(c5);
		
		c5.desligarAr();
		
		c5.acelerar();
		System.out.println(c5);
		
		c5.acelerar();
		System.out.println(c5);
		
		System.out.println("Desliga o modo turbo!!");
		c5.desligarTurbo();
		
		c5.acelerar();
		System.out.println(c5);
		
		c5.acelerar();
		System.out.println(c5);
		
		c5.acelerar();
		System.out.println(c5);
	}
}
