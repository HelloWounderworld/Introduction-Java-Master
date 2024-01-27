package oo.encapsulamento.casaB;

import oo.encapsulamento.casaA.Ana;

public class Julia {

	Ana sogra = new Ana();
	
	void testeAcessos() {
		
		// Uma subclasse, não precisa instanciar a classe pai para acessar
		// os atributos da classe pai. Basta, apenas, chamar os atributos
		
//		System.out.println(sogra.segredo); // Não é possível acessar 
//		System.out.println(sogra.facoDentroDeCasa); // Não é possível acessar
//		System.out.println(sogra.formaDeFalar); // Não é possível acessar, que é estranho, visto que é protected. Motivo disso é que estou instanciando a classe Ana. Visto que o Pedro é herdado da Ana, então, não precisa instanciar
//		System.out.println(formaDeFalar); // Note que, por conta da Julia não ser herdeira da Ana, então não conseguimos ter visibilidade do protected
		System.out.println(sogra.todosSabem);
//		System.out.println(todosSabem); // Até para algo public, a Julia não tem transparência da Ana.
	}
}
