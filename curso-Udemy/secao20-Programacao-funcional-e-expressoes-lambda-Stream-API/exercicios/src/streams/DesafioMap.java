package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class DesafioMap {

	public static void main(String[] args) {
		
		Consumer<String> println = System.out::println;
		
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		/*
		 * 1. Número para string binaria... 6 => "110"
		 * 2. Inverter a string... "110" => "011"
		 * 3. Converter de volta para inteiro => "011" => 3
		 * 
		 * Integer.
		 */
		
//		nums.stream()
//			.map(m -> Integer.toBinaryString(m))
//			.forEach(println);
//		
//		System.out.println();
//		
//		nums.stream()
//			.map(m -> Integer.toBinaryString(m))
//			.map(m -> new StringBuilder(m).reverse().toString())
//			.forEach(println);
//		
//		System.out.println();
//		
//		nums.stream()
//			.map(m -> Integer.toBinaryString(m))
//			.map(m -> new StringBuilder(m).reverse().toString())
//			.map(m -> Integer.parseInt(m, 2))
//			.map(m -> m.toString())
//			.forEach(println);
		
		UnaryOperator<String> inverter = m -> new StringBuilder(m).reverse().toString();
		Function<String, Integer> binarioParaInt = n -> Integer.parseInt(n, 2);
		
		nums.stream()
			.map(Integer::toBinaryString)
			.map(inverter)
			.map(binarioParaInt)
			.map(m -> m.toString())
			.forEach(println);
		
//		System.out.println(Integer.toBinaryString(6));
	}
}
