package fundamentos;

public class Temperatura {

	public static void main(String[] args) {
		//(ºF - 32) / 9 = ºC / 5
		final double CONSTANTEDECONVERSAO = 5.0 / 9.0;
		final double TEMPERATURAINICIALFAHRENHEIT = 32.0;
		double fahrenheit = 78.0;
		
		double celsius = (fahrenheit - TEMPERATURAINICIALFAHRENHEIT) * CONSTANTEDECONVERSAO;
		
		System.out.println("O resultado é "+ celsius + "ºC.");
		
		fahrenheit = 150.0;
		celsius = (fahrenheit - TEMPERATURAINICIALFAHRENHEIT) * CONSTANTEDECONVERSAO;
		
		System.out.println("O resultado é "+ celsius + "ºC.");
	}
}
