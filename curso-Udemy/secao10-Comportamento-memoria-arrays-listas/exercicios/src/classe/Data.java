package classe;

public class Data {

	int dia;
	int mes;
	int ano;
	String mesNome;
	
	Data(int diaInicial, int mesInicial, int anoInicial) {
		dia = diaInicial;
		mes = mesInicial;
		ano = anoInicial;
	}
	
	Data() {
		dia = 1;
		mes = 1;
		ano = 2024;
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
		return String.format("%d/%d/%d\n", dia, mes, ano);
	}
	
	// As boas práticas indicam que é melhor retornar uma String, como está em obterDataFormatada2
	// Do que retornar em print, como está aqui abaixo.
	void obterDataFormatada3() {
		System.out.printf("%d/%d/%d\n", dia, mes, ano);
	}
}
