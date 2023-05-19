package classes

trait Animal {
	String nome
	abstract void pular()
	void falar() {
		println "Animal" + nome + " falando.."
	}
}
