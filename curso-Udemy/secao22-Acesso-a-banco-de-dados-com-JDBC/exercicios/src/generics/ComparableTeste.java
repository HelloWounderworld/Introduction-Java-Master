package generics;

import java.util.TreeSet;

public class ComparableTeste {

	public static void main(String[] args) {
		
		TreeSet<Integer> nums = new TreeSet<>();
		
		nums.add(10);
		nums.add(1);
		nums.add(2);
		nums.add(3);
		nums.add(4);
		nums.add(5);
		nums.add(6);
		nums.add(9);
		nums.add(8);
		nums.add(123);
		nums.add(0);
		
		// Note que, as ordens aleatórias que foram add's serão printados em ordem crescente
		for(Integer n: nums) {
			System.out.println(n);
		}
	}
}
