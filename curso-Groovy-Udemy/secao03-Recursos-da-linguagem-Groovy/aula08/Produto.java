package classes;

public class Produto {
	
	private String nome;
	private double valor;
	
	public Produto(String nome, double valor) {
		super();
		this.nome = nome;
		this.valor = valor;
	}

	public String getNome() {
		System.out.println("getNome");
		return nome;
	}

	public void setNome(String nome) {
		System.out.println("setNome");
		this.nome = nome;
	}

	public double getValor() {
		System.out.println("getValor");
		return valor;
	}

	public void setValor(double valor) {
		System.out.println("setValor");
		this.valor = valor;
	}
	
}
