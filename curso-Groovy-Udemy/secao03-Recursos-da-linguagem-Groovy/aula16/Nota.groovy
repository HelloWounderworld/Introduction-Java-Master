package classes

class Nota {
	Integer itens
	Double valor
	
	Nota plus(Nota nota) {
		println "plus"
		Nota novo = new Nota()
		println this.valor + " - " + this.itens
		println nota.valor + " - " + nota.itens
		novo.itens = + this.itens + nota.itens
		novo.valor = + this.valor + nota.valor
		println "Quem � o novo.itens: " + novo.itens
		println "Quem � o novo.valor: " + novo.valor
		novo
	}
	
	Nota next() {
		println "next"
		this.itens += 1
		this.valor += 2
		this
	}
}
