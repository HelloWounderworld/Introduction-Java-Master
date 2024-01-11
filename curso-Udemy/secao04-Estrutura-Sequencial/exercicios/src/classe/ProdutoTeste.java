package classe;

public class ProdutoTeste {

	public static void main(String[] args) {
		
		// Note que não tive a necessidade de importar a classe Produto
		// Isso seria pelo motivo dessa classe estar no mesmo pacote de ProdutoTeste
		
		// Aqui instanciando uma classe
//		Produto p1 = new Produto();
		Produto p1 = new Produto("Notebook");
//		p1.nome = "Notebook";
		p1.preco = 4356.89;
		p1.desconto = 0.25;
		
		// declaração de uma variável dentro da classe
		var p2 = new Produto();
//		var p2 = new Produto("Caneta Preta");
		p2.nome = "Caneta Preta";
		p2.preco = 12.56;
		p2.desconto = 0.29;
		
		Produto p3 = new Produto("MacBook", 24999.99);
		p3.desconto = 0.25;
		
//		Produto p4 = new Produto("IMac", 24999.99, 0.15);
		
		System.out.println(p1.nome);
		System.out.println(p2.nome);
		System.out.println(p3.nome);
//		System.out.println(p4.nome);
		
//		double precoFinal1 = p1.preco * (1-p1.desconto);
//		double precoFinal2 = p2.preco * (1-p2.desconto);
		double precoFinal1 = p1.precoComDesconto();
		double precoFinal2 = p2.precoComDesconto();
		double precoFinal3 = p2.precoComDesconto(0.2);
		double precoFinal4 = p3.precoComDesconto();
		double precoFinal5 = p3.precoComDesconto();
		double mediaCarrinho = (precoFinal1 + precoFinal2 + precoFinal4 + precoFinal5) / 4;
		System.out.println(precoFinal1);
		System.out.println(precoFinal2);
		System.out.println(precoFinal3);
		System.out.println(precoFinal4);
		System.out.println(precoFinal5);
		System.out.println(mediaCarrinho);
		
		System.out.printf("Média do carrinho = R$%.2f.", mediaCarrinho);
		System.out.println();
		System.out.println();
		
		System.out.println("Produto com o desconto definido pela classe: 0.25");
		var p5 = new Produto("Iphone", 9998.99);
		double precoFinal6 = p5.precoComDesconto();
		System.out.println("Desconto que sofreu: " + p5.desconto);
		System.out.println(precoFinal6);
		System.out.println();
		
		System.out.println("Me aproveitando do static que foi definido em desconto");
		Produto.desconto = 0.28;
		var p6 = new Produto("Notebook Gamer Dell G16", 10000.0);
		double precoFinal7 = p6.precoComDesconto();
		System.out.println("Desconto que sofreu: " + p6.desconto);
		System.out.println(precoFinal7);
		System.out.println();
		
		var p7 = new Produto("Notebook Gamer Dell G16", 10000.0);
		double precoFinal8 = p7.precoComDesconto();
		System.out.println("Desconto que sofreu: " + p7.desconto);
		System.out.println(precoFinal8);
		System.out.println();
		
		var p8 = new Produto("Notebook Gamer Dell Alienware", 20000.00);
		double precoFinal9 = p8.precoComDesconto();
		System.out.println("Desconto que sofreu: " + p8.desconto);
		System.out.println(precoFinal9);
		
	}
}
