package classe;

public class Data {

	int dia;
	int mes;
	int ano;
	String mesNome;
	
	// Basicamente, a palara this ele é uma sintaxe de que possibilita chamar um construtor
	// dentro de um outro construtor, usando this como um método.
	// Ou, vc pode usar o this para referenciar um objeto atual, como foi feito no construtor
	// explícito Data.
	
//	Data(int diaInicial, int mesInicial, int anoInicial) {
//		dia = diaInicial;
//		mes = mesInicial;
//		ano = anoInicial;
//	}
	
	Data(int dia, int mes, int ano) {
		this.dia = dia; // this, aqui está apontando para o atributo definido na classe Data, dia. Serviu para distinguir entre o "dia" que foi passado como argumento e o "dia" do atributo que foi definido
		this.mes = mes;
		this.ano = ano;
	}
	
	Data() {
//		dia = 1;
//		mes = 1;
//		ano = 2024;
		// Uma outra maneira de usar o this para fazer o que foi feito acima
		this(1,1,2024);
	}
	
	String obterDataFormatada() {
		switch(mes) {
		case 1:
			return String.format("%d de Janeiro de %d", dia, ano);
		case 2:
			return String.format("%d de Fevereiro de %d", dia, ano);
		case 3:
			return String.format("%d de Março de %d", dia, ano);
		case 4:
			return String.format("%d de Abril de %d", dia, ano);
		case 5:
			return String.format("%d de Maio de %d", dia, ano);
		case 6:
			return String.format("%d de Junho de %d", dia, ano);
		case 7:
			return String.format("%d de Julho de %d", dia, ano);
		case 8:
			return String.format("%d de Agosto de %d", dia, ano);
		case 9:
			return String.format("%d de Setembro de %d", dia, ano);
		case 10:
			return String.format("%d de Outubro de %d", dia, ano);
		case 11:
			return String.format("%d de Novembro de %d", dia, ano);
		default:
			return String.format("%d de Dezembro de %d", dia, ano);
		}
	}
	
	String obterDataFormatada2() {
		// Aqui eu poderia até usar o this, mas como não está tendo conflito de nome
		// o Java é o inteligente o suficiente para se referir aos atributos definidos
		// nessa classe Data
		return String.format("%d/%d/%d\n", dia, mes, ano);
	}
	
	// As boas práticas indicam que é melhor retornar uma String, como está em obterDataFormatada2
	// Do que retornar em print, como está aqui abaixo.
	void obterDataFormatada3() {
		System.out.printf("%d/%d/%d\n", dia, mes, ano);
		System.out.println();
		System.out.println(this.obterDataFormatada2());
	}
	
//	static void teste() {
//		// Dentro de um método estático, a sentença this é inválida
//		this.dia = 3;
//	}
}
