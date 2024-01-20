package oo.composicao;

public class Item {

	String nome;
	int quantidade;
	double preco;
	Compra compra; // Estabelecendo uma relação bidirecional entre Compra e Item
	
	Item(String nome, int quantidade, double preco) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
	}
}
