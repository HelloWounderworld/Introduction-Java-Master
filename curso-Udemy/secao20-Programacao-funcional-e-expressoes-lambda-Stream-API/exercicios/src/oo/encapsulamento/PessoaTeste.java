package oo.encapsulamento;

public class PessoaTeste {

	public static void main(String[] args) {
		
//		Pessoa p1 = new Pessoa();
		Pessoa p1 = new Pessoa("Leonardo", "Teramatsu", -30); // Depois que tornei idade private e tornei a instanciação explícita
		System.out.println(p1.getIdade()); // Agora, tornei a idade private
		System.out.println();
		// visto que o atributo "idade" está como public
//		p1.idade = -30; // alterar - visto que a idade está public
		p1.setIdade(40); // Visto que a idade está private, então criei um método que é public que possibilita a sua alteração
		
//		System.out.println(p1.idade); // ler - visto que a idade está public
		System.out.println(p1.getNome());
		System.out.println(p1.getIdade()); // Agora, tornei a idade private
		System.out.println(p1.toString());
		System.out.println();
		
		p1.setIdade(27);
		p1.setNome("Takashi");
		System.out.println(p1.getNome());
		System.out.println(p1.getIdade());
		System.out.println(p1.toString());
		
		// Note que, com getter e setter, conseguimos tornar o atributo de uma classe private
		// Assim, nos dando mais flexibidade do que permitir ou não de realizar sobre esses atributos
		// Isso nos possibilita controlar o nível de manipulação que podemos ter sobre um atributo private ou protected
	}
}
