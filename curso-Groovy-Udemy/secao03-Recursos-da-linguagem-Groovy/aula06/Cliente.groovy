package classes

class Cliente {
	// Se liberte de usar public para classes e m�todos
	// Se liberte de usar private para os atributos
	String nome
	Date data
	Integer somar(Integer v1, Integer v2) {
		// Voc� n�o precisa colocar o return, pois ele fica impl�cito
		v1 + v2
		// Outra alternativa de fazer � abaixo
		// Mas como a inten��o do groovy � sempre reduzir o c�digo
		// ent�o o formato acima � o suficiente
//		int temp = v1 + v2
//		temp
	}
	
	// N�o � necess�rio criar os get's e os set's para os atributos acima, visto que, por padr�o, s�o private.
	
}
