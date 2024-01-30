package excecao.personalizadaA;

// @SuppressWarnings("serial") = Tô dizendo que não quero serializar
@SuppressWarnings("serial")
public class NumeroForaDoIntervaloException extends RuntimeException {

	private String nomeDoAtributo;
	
	public NumeroForaDoIntervaloException(String nomeDoAtributo) {
		this.nomeDoAtributo = nomeDoAtributo;
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return String.format("O atributo '%s' está fora do intervalo.", nomeDoAtributo);
	}
}
