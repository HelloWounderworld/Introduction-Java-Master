package classes

import groovy.transform.ToString

//@ToString(excludes=["idade"])
//@ToString(includeNames=true)
//@ToString(includeNames=true, excludes = "salario, idade")
@ToString
class Funcionario {
	String nome
	Integer idade
	Double salario
	// Se estivéssemos no Java, teríamos que gerar o toString como abaixo
	// donde se enquadra na prática Dry.
//	@Override
//	public String toString() {
//		return "Funcionario [nome=" + nome + ", idade=" + idade + ", salario=" + salario + "]";
//	}
	// No Groovy isso não é necessário pois temos o @ToString que nos permite
    // realizar o mesmo processo do código acima, mas em apenas uma linha
    // Bastaria chamar o @ToString antes da classe Funcionario e só.

}
