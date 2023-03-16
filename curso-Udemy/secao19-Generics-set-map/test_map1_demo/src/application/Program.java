package application;

import java.util.Map;
import java.util.TreeMap;

public class Program {
	
	public static void main(String[] args) {
		
		// <String, String> indica a chave vai ser um String e o valor um String tbm associado à chave.
		Map<String, String> cookies = new TreeMap<>();
		
		cookies.put("username", "maria");
		cookies.put("email", "maria@gmail.com");
		cookies.put("phone", "99771122");
		
		System.out.println(cookies);
		
		cookies.remove("email");
		System.out.println(cookies);
		
		cookies.put("phone", "99771133");
		System.out.println(cookies);
		
		System.out.println("Contains 'phone' key: " + cookies.containsKey("phone"));
		System.out.println("Phone number: " + cookies.get("phone"));
		System.out.println("Email: " + cookies.get("email"));
		System.out.println("Size: " + cookies.size());
		
		System.out.println("ALL COOKIES:");
		for (String key : cookies.keySet()) {
			System.out.println(key + ": " + cookies.get(key));
		}
	}
}
