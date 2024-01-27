package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class Reduce1 {

	public static void main(String[] args) {
		
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		BinaryOperator<Integer> soma = (ac, n) -> ac + n;
		
		int total1 = nums.stream()
			.reduce(soma)
			.get();
		System.out.println(total1);
		
		int total2 = nums.parallelStream()
				.reduce(soma)
				.get();
		System.out.println(total1);
		
		Integer total3 = nums.parallelStream()
			.reduce(100, soma);
		System.out.println(total3);
		
		Integer total4 = nums.stream()
				.reduce(100, soma);
		System.out.println(total4);
		
		// Resultado foi um Opcional<Integer>...
		nums.stream()
			.filter(n -> n > 5)
			.reduce(soma)
			.ifPresent(System.out::println);
		
		// NullPointerException
//		Integer a = null;
//		int b = a;
	}
}
