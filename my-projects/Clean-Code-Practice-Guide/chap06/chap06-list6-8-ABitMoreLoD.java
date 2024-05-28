// https://www.dio.me/articles/vc-conhece-a-lei-de-demeter

// Na linguagem matematica. Temos uma relacao de equivalencia transitiva, mas que sempre o primeiro se relaciona com o terceiro por um intermedio.

// A ~ B e B ~ C => A ~ B ~ C. A conclusao certa, matematicamente, seria A ~ C, mas a Lei de Demeter, meio que esta dizendo que A se relaciona com C de forma indireta.

// Lembrando que essa regra so se aplica a objetos. Para estrutura de dados a Lei de Demeter nao se aplica, pois a ideia da estrutura de dados e, de fato, expor as funcoes

// Saber ocultar as estruturas internas de um objeto, o raciocinio e muito parecido com o Padrao DAO, quando vc encapsula as funcoes ou codigos que esteja
// diretamente ligado a infra-estrutura. Assim, dividindo entre codigos que de regra de negocio com codigos de infra estrutura e tornando mais facil a manutencao

// Ou seja, na medida do possivel, quando se e objeto, use a Lei de Demeter, que seria ocultar o maximo possivel de detalhes do que e feito na funcao dentro do objeto
// ela precisa estar oculta e nao exposta. Em outras palavras, a funcao/metodo que e exposta por um objeto, dentro dela, esta sendo encadeado uma series de passo a passo
// algo que nao precisa ficar exposto e encapsulado em um unico metodo (Acho que, agora, fez sentido em usar apenas um ponto para o objeto, em vez de mais do que isso).

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
