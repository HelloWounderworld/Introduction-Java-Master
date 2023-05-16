package classes

class Venda {
	// Note que, já podemos estabelecer um valor padrão, caso não seja fornecido nada
	// nos argumentos abaixo. A lógica é o mesmo que foi estudado no JavaScript.
	double vender (double valor, int taxa = 10) {
		double rs = valor * taxa / 100
		rs
	}
}
