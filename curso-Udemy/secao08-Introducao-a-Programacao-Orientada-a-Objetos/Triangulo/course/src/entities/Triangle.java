package entities;

public class Triangle {

	public double a;
	public double b;
	public double c;

	// Motivo de ser public double, é porque vai retornar um double
	// Não será necessário colocar os parâmetros a, b e c dentro desse método
	// pois elas já residem dentro dessa classe
	public double area() {
		double p = (a + b + c) / 2.0;
		return Math.sqrt(p * (p - a) * (p - b) * (p - c));
	}
}
