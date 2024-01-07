package classe;

public class Produto {

	String nome;
	double preco;
	double desconto;
	
	double precoComDesconto() {
		return preco * (1-desconto);
	}
	
	// Se o gerente adicionar mais um desconto?
	double precoComDesconto(double descontoGerente) {
		return preco * (1-desconto +descontoGerente);
	}
}
