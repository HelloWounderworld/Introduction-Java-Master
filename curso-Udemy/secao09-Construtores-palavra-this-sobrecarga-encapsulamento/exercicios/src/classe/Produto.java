package classe;

public class Produto {

	String nome;
	double preco;
	double desconto;
	
	// Posso criar quantos construtores que eu quiser.
	
	// Tornei o construtor explícito da classe Produto
	// Ou seja, preciso passar alguma parâmetro String
	// Sempre que eu instanciar a classe, Produto p = new Produto("blabla");
	Produto(String nomeInicial) {
		nome = nomeInicial;
	}
	
	Produto(String nomeInicial, double precoInicial) {
		nome = nomeInicial;
		preco = precoInicial;
	}
	
	Produto(String nomeInicial, double precoInicial, double descontoInicial) {
		nome = nomeInicial;
		preco = precoInicial;
		desconto = descontoInicial;
	}
	
	// Possibilitei que o construtor seja feita de forma implícita
	// Ou seja, consigo instanciar Produto p = new Produto();
	Produto() {
		
	}
	
	// Transformei o construtor num método que não retorna nada...
	// Mas isso não está errado conceitualmente.
	void Produto() {
		
	}
	
	double precoComDesconto() {
		return preco * (1-desconto);
	}
	
	// Se o gerente adicionar mais um desconto?
	double precoComDesconto(double descontoGerente) {
		return preco * (1-desconto +descontoGerente);
	}
}
