package teste.umpraum;

import infra.DAO;
import modelo.umpraum.Assento;
import modelo.umpraum.Cliente;

public class NovoClienteAssento1 {

	public static void main(String[] args) {
		
		Assento assento = new Assento("23L");
		Cliente cliente = new Cliente("Gohan", assento);
		
		DAO<Object> dao = new DAO<>();
		
		dao.abrirT()
			.incluir(assento)
			.incluir(cliente)
			.fecharT()
			.fechar();
		
		// Dará um problema
//		dao.abrirT()
//			.incluir(cliente)
//			.fecharT()
//			.fechar();
//		dao.abrirT()
//			.incluir(assento)
//			.fecharT()
//			.fechar();
	}
}
