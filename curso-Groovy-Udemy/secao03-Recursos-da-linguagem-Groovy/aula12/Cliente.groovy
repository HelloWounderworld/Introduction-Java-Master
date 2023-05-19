package classes

class Cliente {
	// Se liberte de usar public para classes e métodos
	// Se liberte de usar private para os atributos
	String nome
	Date data
	Integer somar(Integer v1, Integer v2) {
		// Você não precisa colocar o return, pois ele fica implícito
		v1 + v2
		// Outra alternativa de fazer é abaixo
		// Mas como a intenção do groovy é sempre reduzir o código
		// então o formato acima é o suficiente
//		int temp = v1 + v2
//		temp
	}
	
	// Não é necessário criar os get's e os set's para os atributos acima, visto que, por padrão, são private.
	
}
