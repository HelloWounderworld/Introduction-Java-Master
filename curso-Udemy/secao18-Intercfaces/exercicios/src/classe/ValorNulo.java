package classe;

public class ValorNulo {

	public static void main(String[] args) {
		
		// Simulando o problema NullPointerException
		
		String s1 = "";
		System.out.println(s1.concat("!!!!!"));
		
		Data d1 = Math.random() > 0.5 ? new Data() : null;
		
		if (d1 != null) {
			d1.mes = 3;
			System.out.println((d1.obterDataFormatada2()));
		}
		
		// Vai dar ruim
		String s2 = null;
		
		if(s2 != null) {
			System.out.println(s2.concat("??????"));
		}

	}
}
