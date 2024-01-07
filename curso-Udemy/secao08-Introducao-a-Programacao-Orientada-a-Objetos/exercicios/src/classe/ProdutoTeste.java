package classe;

public class ProdutoTeste {

	public static void main(String[] args) {
		
		// Note que não tive a necessidade de importar a classe Produto
		// Isso seria pelo motivo dessa classe estar no mesmo pacote de ProdutoTeste
		
		// Aqui instanciando uma classe
		Produto p1 = new Produto();
		p1.nome = "Notebook";
		p1.preco = 4356.89;
		p1.desconto = 0.25;
		
		// declaração de uma variável dentro da classe
		var p2 = new Produto();
		p2.nome = "Caneta Preta";
		p2.preco = 12.56;
		p2.desconto = 0.29;
		
		System.out.println(p1.nome);
		System.out.println(p2.nome);
		
//		double precoFinal1 = p1.preco * (1-p1.desconto);
//		double precoFinal2 = p2.preco * (1-p2.desconto);
		double precoFinal1 = p1.precoComDesconto();
		double precoFinal2 = p2.precoComDesconto();
		double precoFinal3 = p2.precoComDesconto(0.2);
		double mediaCarrinho = (precoFinal1 + precoFinal2 + precoFinal3) / 3;
		System.out.println(precoFinal1);
		System.out.println(precoFinal2);
		System.out.println(precoFinal3);
		System.out.println(mediaCarrinho);
		
		System.out.printf("Média do carrinho = R$%.2f.", mediaCarrinho);
	}
}
