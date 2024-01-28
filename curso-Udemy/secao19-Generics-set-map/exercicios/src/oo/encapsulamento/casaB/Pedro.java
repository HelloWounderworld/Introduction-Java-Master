package oo.encapsulamento.casaB;

import oo.encapsulamento.casaA.Ana;

public class Pedro extends Ana {

	Ana mae = new Ana();
	
	void testeAcessos() {
		
		// Uma subclasse, não precisa instanciar a classe pai para acessar
		// os atributos da classe pai. Basta, apenas, chamar os atributos
		
//		System.out.println(mae.segredo); // Não é possível acessar 
//		System.out.println(mae.facoDentroDeCasa); // Não é possível acessar
//		System.out.println(mae.formaDeFalar); // Não é possível acessar, que é estranho, visto que é protected. Motivo disso é que estou instanciando a classe Ana. Visto que o Pedro é herdado da Ana, então, não precisa instanciar
		System.out.println(formaDeFalar);
		System.out.println(mae.todosSabem);
		System.out.println(todosSabem);
	}
}
