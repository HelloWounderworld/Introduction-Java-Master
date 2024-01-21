package classe;

public class DataTeste {

	public static void main(String[] args) {
		
		Data data1 = new Data();
		data1.dia = 01;
		data1.mes = 04;
		data1.ano = 2024;
		System.out.println(data1.obterDataFormatada());
		System.out.print(data1.obterDataFormatada2());
		data1.obterDataFormatada3();
		
		System.out.println();
		
		var data2 = new Data();
		data2.dia = 27;
		data2.mes = 11;
		data2.ano = 2024;
		System.out.println(data2.obterDataFormatada());
		System.out.print(data2.obterDataFormatada2());
		data2.obterDataFormatada3();
		
		System.out.println();
		
		Data data3 = new Data(01, 04, 2024);
		System.out.println(data3.obterDataFormatada());
		System.out.print(data3.obterDataFormatada2());
		data3.obterDataFormatada3();
		
		System.out.println();
		
		Data data4 = new Data();
		System.out.println(data4.obterDataFormatada());
		System.out.print(data4.obterDataFormatada2());
		data4.obterDataFormatada3();
		
//		System.out.printf("%d/%d/%d\n", data1.dia, data1.mes, data1.ano);
//		System.out.printf("%d/%d/%d\n", data2.dia, data2.mes, data2.ano);
//		System.out.printf("%d de %s de %d\n", data1.dia, data1.mesNome, data1.ano);
//		System.out.printf("%d de %s de %d", data2.dia, data2.mesNome, data2.ano);
	}
}
