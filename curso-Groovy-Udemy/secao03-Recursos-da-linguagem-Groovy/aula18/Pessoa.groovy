package classes

class Pessoa implements Animal, Lutador {
	
	void pular() {
		println "pessoa " + nome + " pulando..."
//		falar()
	}

	void correr() {
		println "pessoa " + nome + " correndo..."
//		lutar()
	}

}
