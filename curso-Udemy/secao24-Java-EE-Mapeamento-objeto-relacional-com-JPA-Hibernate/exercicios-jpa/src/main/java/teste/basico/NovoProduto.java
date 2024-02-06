package teste.basico;

import infra.DAO;
import modelo.basico.Produto;

public class NovoProduto {

	public static void main(String[] args) {
		
//		Produto produto = new Produto("Caneta", 7.45);
//		
//		DAO<Produto> dao = new DAO<>(Produto.class);
//		dao.abrirT().incluir(produto).fecharT();
		
//		Produto produto2 = new Produto("Notebook", 22000.00);
//		
//		DAO<Produto> dao2 = new DAO<>(Produto.class);
//		dao2.incluirAtomico(produto2).fechar();
		
		Produto produto3 = new Produto("Monitor 27 polegadas", 1498.59);
		
		DAO<Produto> dao3 = new DAO<>(Produto.class);
		dao3.incluirAtomico(produto3).fechar();
		
		System.out.println("ID do produto: " + produto3.getId());
	}
}
