package excecao.personalizadaB;

//@SuppressWarnings("serial") = Tô dizendo que não quero serializar
@SuppressWarnings("serial")
public class StringVaziaException extends Exception {

	private String nomeDoAtributo;
	
	public StringVaziaException(String nomeDoAtributo) {
		this.nomeDoAtributo = nomeDoAtributo;
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return String.format("O atributo '%s' está vazio", nomeDoAtributo);
	}
}
