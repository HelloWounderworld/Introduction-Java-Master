package streams;

public class MediaTeste {

	public static void main(String[] args) {
		
//		Media m1 = new Media();
//		m1.adicionar(8.3);
//		m1.adicionar(6.7);
		
//		System.out.println(m1.getValor());
		
		Media m1 = new Media().adicionar(8.3).adicionar(6.7);
		Media m2 = new Media().adicionar(6.9).adicionar(9.8);
		
		System.err.println(m1.getValor());
		System.err.println(m2.getValor());
		
		System.out.println(Media.combinar(m1, m2).getValor());
	}
}
