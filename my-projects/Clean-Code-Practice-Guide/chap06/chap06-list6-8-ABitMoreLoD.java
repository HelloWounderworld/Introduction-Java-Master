// https://www.dio.me/articles/vc-conhece-a-lei-de-demeter

// Na linguagem matematica. Temos uma relacao de equivalencia transitiva, mas que sempre o primeiro se relaciona com o terceiro por um intermedio.

// A ~ B e B ~ C => A ~ B ~ C. A conclusao certa, matematicamente, seria A ~ C, mas a Lei de Demeter, meio que esta dizendo que A se relaciona com C de forma indireta.

public class Cliente {
    private List<Pedido> pedidos;
  
  
    public Cliente(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
  
  
    public int getQuantidadeTotalItens() {
        int quantidadeTotal = 0;
        for (Pedido pedido : pedidos) {
            quantidadeTotal += pedido.getQuantidadeTotalItens();
        }
        return quantidadeTotal;
    }
}

public class Pedido {
    private List<ItemPedido> itens;
  
  
    public Pedido(List<ItemPedido> itens) {
        this.itens = itens;
    }
  
  
    public int getQuantidadeTotalItens() {
        int quantidadeTotal = 0;
        for (ItemPedido item : itens) {
            quantidadeTotal += item.getQuantidade();
        }
        return quantidadeTotal;
    }
}

public class Cliente {
    private String nome;
    private List<Pedido> pedidos;
  
  
    public Cliente(String nome, List<Pedido> pedidos) {
        this.nome = nome;
        this.pedidos = pedidos;
    }
  
  
    public int getQuantidadeTotalItens() {
        int quantidadeTotal = 0;
        for (Pedido pedido : pedidos) {
            quantidadeTotal += pedido.getQuantidadeTotalItens();
        }
        return quantidadeTotal;
    }
  
  
    public String getNome() {
        return nome;
    }
}
