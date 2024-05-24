// Antissimetria data/objeto

// Os objetos usam abstracoes para esconder seus dados, e expoem as funcoes que operam em tais dados.
// As estruturas de dados expoem seus dados e nao possuem funcoes significativas.
// Reflita essas duas definicoes conflitantes acima e o que poderia causar de uma serie de implicacoes.

// Note que, a maneira como foi codado a classe Geometry, se colocarmos uma funcao perimeter() dentro dela
// as classes shape nao seriam afetadas. Assim como quaisquer outras classes que dependessem delas!
// Por outro lado, se adicionassemos uma nova classe shape, teremos de alterar todas as funcoes em Geometry.

public class shapeProcedimental {
    public class Square {
        public Point topLeft;
        public double side;
    }
    
    public class Rectangle {
        public Point topLeft;
        public double height;
        public double width;
    }
    
    public class Circle {
        public Point center;
        public double radius;
    }

    public class Triangle {
        public Point topLeft;
        public double height;
        public double width;
    }
    
    public class Geometry {
        public final double PI = 3.141592653589793;
    
        public double area(Object shape) throws NoSuchShapeException {
            if(shape instanceof Square) {
                Square s = (Square) shape;
                return s.side * s.side;
            } else if (shape instanceof Rectangle) {
                Rectangle r = (Rectangle) shape;
                return r.height * r.width;
            } else if (shape instanceof Circle) {
                Circle c = (Circle) shape;
                return PI * c.radius * c.radius;
            } else if (shape instanceof Triangle) {
                Triangle t = (Triangle) shape;
                return t.height * t.width / 2;
            }
    
            throw new NoSuchShapeException();
        }
    }
}
