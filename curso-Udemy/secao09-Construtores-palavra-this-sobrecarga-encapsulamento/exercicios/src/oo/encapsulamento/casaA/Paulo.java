package oo.encapsulamento.casaA;

public class Paulo {
	
	Ana esposa = new Ana();

	void testeAcessos() {
		// Note que, tirando o segredo, podemos acessar os outros três atributos
		// Visto que o Paulo está dentro do mesmo pacote e nível da classe Ana
//		System.out.println(esposa.segredo); // Essa não consigo acessar
		System.out.println(esposa.facoDentroDeCasa);
		System.out.println(esposa.formaDeFalar);
		System.out.println(esposa.todosSabem);
	}
}
