package generics;

// Normalmente é colocado <T>, uma letra
public class Caixa<TIPO> {

	private TIPO coisa;
	
	public void aguardar(TIPO coisa) {
		this.coisa = coisa;
	}
	
	public TIPO abrir() {
		return coisa;
	}
}
