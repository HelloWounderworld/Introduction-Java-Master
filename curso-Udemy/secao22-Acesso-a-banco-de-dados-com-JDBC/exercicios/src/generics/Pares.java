package generics;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

public class Pares<C extends Number, V> {

//	private final Set<Par<C, V>> itens = new HashSet<>();
	// LinkedHashSet - Garante a ordem de inclusão
	private final Set<Par<C, V>> itens = new LinkedHashSet<>();
	
	// Usar a sintaxe return dentro do void, junto com uma condicional
	// faz, simplesmente, sair do método
	public void adicionar(C chave, V valor) {
		if(chave == null) return;
		
		Par<C, V> novoPar = new Par<C, V>(chave, valor);
		
		if(itens.contains(novoPar)) {
			itens.remove(novoPar);
		}
		
		itens.add(novoPar);
	}
	
	public V getValor(C chave) {
		if(chave == null) return null;
		
		Optional<Par<C, V>> parOpcional = itens.stream()
											.filter(par -> chave.equals(par.getChave()))
											.findFirst();
		return parOpcional.isPresent() ? parOpcional.get().getValor() : null;
	}
}
