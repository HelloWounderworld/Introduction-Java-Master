// Utilizando, agora, o polimorfismo, vemos que conseguimos inverter o cenario

// Agora, se adicionarmos uma nova forma, nenhuma das funcoes existentes serao afetadas
// mas se eu adicionar uma nova funcao, todas as classes shapes deverao ser alteradas

// Basicamente, comparando com o list6-5, queremos mostrar a dicotomia totalmente oposta existentes entre Objetos e Estruturas de Dados

// O codigo procedural (usado em estrutura de dados) facilita a adicao de novas funcoes sem precisar alterar as estruturas de dados existentes.
// O codigo orientado a objetos (OO), por outro lado, facilita a adicao de novas classes sem precisar alterar as funcoes existentes.

// O codigo procedural dificulta a adicao de novas estruturas de dados, pois todas as funcoes teriam de ser alteradas.
// O codigo OO dificulta a adicao de novas funcoes, pois todas as classes teriam de ser alteradas.

public class PolymorphicShape {

    public class Square implements Shape {
        private Point topLeft;
        private double side;

        public double area() {
            return side*side;
        }
    }

    public class Rectangle implements Shape {
        private Point topLeft;
        private double height;
        private double width;

        public double area() {
            return height * width;
        }
    }

    public class Circle implements Shape {
        private Point center;

        private double radius;
        public final double PI = 3.141592653589793;

        public double area() {
            return PI * radius * radius;
        }
    }
}
