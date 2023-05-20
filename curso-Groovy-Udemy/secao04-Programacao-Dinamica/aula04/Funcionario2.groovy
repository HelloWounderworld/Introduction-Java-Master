package classes

import groovy.transform.EqualsAndHashCode

// Da mesma forma para ToString, para EqualsAndHashCode temos tbm include e exclude
@EqualsAndHashCode
class Funcionario2 {
	String nome
	Integer idade
	Double salario
	// Se isso fosse no Java, estaríamos criando a seguinte quantidade de código abaixo.
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((idade == null) ? 0 : idade.hashCode());
//		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
//		result = prime * result + ((salario == null) ? 0 : salario.hashCode());
//		return result;
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Funcionario2 other = (Funcionario2) obj;
//		if (idade == null) {
//			if (other.idade != null)
//				return false;
//		} else if (!idade.equals(other.idade))
//			return false;
//		if (nome == null) {
//			if (other.nome != null)
//				return false;
//		} else if (!nome.equals(other.nome))
//			return false;
//		if (salario == null) {
//			if (other.salario != null)
//				return false;
//		} else if (!salario.equals(other.salario))
//			return false;
//		return true;
//	}

}
