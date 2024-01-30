package lambdas;

// nome de uma classe extends Object = é mesma coisa de não fazer nada.
// por isso, que, visto que a classe não herdou ninguém, tanto faz ter o
// construtor super ou não.

public class Produto extends Object {

	final String nome;
	final double preco;
	final double desconto;
	
	public Produto(String nome, double preco, double desconto) {
		this.nome = nome;
		this.preco = preco;
		this.desconto = desconto;
	}

	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", preco=" + preco + ", desconto=" + desconto + "]";
	}
}
