package classe;

public class Usuario {

	String nome;
	String email;
	
	public boolean equals(Object obj) {
		if(obj instanceof Usuario) {
			Usuario outro = (Usuario) obj;
			
			boolean nomeIgual = outro.nome == this.nome;
			boolean emailIgual = outro.email == this.email;
			
			return nomeIgual && emailIgual;
		} else {
			return false;
		}
	}
	
//	public boolean equals(Object obj) {
//		Usuario outro = (Usuario) obj;
//		
//		boolean nomeIgual = outro.nome == this.nome;
//		boolean emailIgual = outro.email == this.email;
//		
//		return nomeIgual && emailIgual;
//	}
	
	// O hashcode será abordado em outra aula! - Faz mais sentido aborda-la depois de visto
	// sobre collections - Set, List, Map, Queue e Stack
}
