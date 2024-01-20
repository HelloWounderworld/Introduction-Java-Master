package classe;

public class AreaCirc {

	double raio;
//	double pi;
//	final double pi = 3.14;
	final static double PI = 3.1415;
	
	AreaCirc(double raioInicial) {
//		pi = 3.14;
		raio = raioInicial;
	}
	
	double area() {
		return PI * Math.pow(raio, 2);
	}
	
	// Agora, consigo acessar esse método sem a necessidade de colocar um constutor "new"
	static double area(double raio) {
		return PI * Math.pow(raio, 2);
	}
}
