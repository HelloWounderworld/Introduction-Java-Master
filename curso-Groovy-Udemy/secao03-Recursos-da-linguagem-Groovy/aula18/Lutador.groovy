package classes

trait Lutador {
	String arma
	abstract void correr()
	void lutar() {
		println "Lutador " + arma + " lutando..."
	}
}
