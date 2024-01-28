package generics;

import java.util.Arrays;
import java.util.List;

public class ListaUtilTeste {

	public static void main(String[] args) {
		// O método getUltimo1, não é um método genérico
		List<String> langs = Arrays.asList("JS", "Python", "Java", "PHP", "C++");
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);
		
		// Como prova disso, note que, tive que fazer o casting explícito
		String ultimaLinguagemA = (String) ListaUtil.getUltimo1(langs);
		System.out.println(ultimaLinguagemA);
		
		Integer ultimoNumeroA = (Integer) ListaUtil.getUltimo1(nums);
		System.out.println(ultimoNumeroA);
		
		System.out.println();
		
		// getUltimo2 - método genérico
		String ultimaLinguagemB = ListaUtil.getUltimo2(langs);
		System.out.println(ultimaLinguagemB);
		
//		Integer ultimoNumeroB = ListaUtil.getUltimo2(nums);
		// Uma forma de tornar explícito
		Integer ultimoNumeroB = ListaUtil.<Integer>getUltimo2(nums);
		System.out.println(ultimoNumeroB);
	}
}
