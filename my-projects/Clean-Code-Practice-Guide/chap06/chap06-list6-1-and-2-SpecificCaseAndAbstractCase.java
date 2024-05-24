// Objetos e Estrutura de Dados

// Basicamente, a primeira, public class Point, a finalidade dessa classe esta muito especificada.
// Ja o segundo, public interface Point, ela os torna mais abstrato, ou seja, o grau de generalidade dela e mais alta.
// O grau de generalidade mais alta nos fornece mais flexibilidade para manipularmos os metodos da forma como bem entender sem que ela
// perca a essencia do seu mecanismo.

// Basicamente, o que seria abstrair algum conceito, seria em pegar um caso concreto e verificar os mecanismos fundamentais que sustenta ela
// de maneira que, esse mesmo mecanismo possa ser aplicado em outras maneiras. Ou seja, isso e equivalente a conseguir verificar ate que ponto
// podemos aumentar o grau da sua generalidade.

// 抽象的にするのはいわゆるそのコンセプトの一般性の制度をどれだけ精度よく把握できるかにある。

// Caso concreto - Exposicao da sua implementacao
public class Point {
    public double x;
    public double y;
}

// Caso abstrato - Esconde completamente
public interface Point {
    double getX();
    double getY();
    void setCartesian(double x, double y);
    double getR();
    double getTheta();
    void setPolar(double r, double theta);
}
