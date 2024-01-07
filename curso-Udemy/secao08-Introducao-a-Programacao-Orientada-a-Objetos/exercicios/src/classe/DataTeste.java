package classe;

public class DataTeste {

	public static void main(String[] args) {
		
		Data data1 = new Data();
		data1.dia = 01;
		data1.mes = 04;
		data1.ano = 2024;
		
		var data2 = new Data();
		data2.dia = 27;
		data2.mes = 11;
		data2.ano = 2024;
		
		System.out.printf("%d/%d/%d\n", data1.dia, data1.mes, data1.ano);
		System.out.printf("%d/%d/%d", data2.dia, data2.mes, data2.ano);
	}
}
