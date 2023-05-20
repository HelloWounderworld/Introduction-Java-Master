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
	// Se estiv�ssemos no Java, ter�amos que gerar o toString como abaixo
	// donde se enquadra na pr�tica Dry.
//	@Override
//	public String toString() {
//		return "Funcionario [nome=" + nome + ", idade=" + idade + ", salario=" + salario + "]";
//	}
	// No Groovy isso n�o � necess�rio pois temos o @ToString que nos permite
    // realizar o mesmo processo do c�digo acima, mas em apenas uma linha
    // Bastaria chamar o @ToString antes da classe Funcionario e s�.

}
