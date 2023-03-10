# Seção 16: Projeto - Sistema Jogo de Xadrez:

## Aula 01 - Visão geral do capítulo Sistema Jogo de Xadrez e Aula 02 - Material de apoio do capítulo:
MATERIAL DE APOIO DO CAPÍTULO

Seja muito bem-vindo(a) ao capítulo Projeto: Sistema jogo de xadrez!

Aqui você pode baixar o material de apoio usado nas aulas do capítulo, para que você possa aproveitar ao máximo as aulas sem precisar ficar anotando muito.

Grande abraço e bons estudos! Nelio.

Recursos para esta aula

    10-projeto-sistema-xadrez.pdf

Seguir o projeto feito pelo professor

    https://github.com/acenelio/chess-system-design 

## Aula 03 - Criando projeto e repositório Git:
Já foi criado.

Nome do projeto: chess_game_java

## Aula 04 - Primeira classe - Position:
Vamos criar uma primeira classe chamado Position.

Para essa classe vamos usar os conceitos como encapsulação, contrutor e toString.

No caso, vamos criar a classe Position dentro do diretório boardgame. Daí, dentro do arquivo Position.java, vamos fazer o seguinte

    package boardgame;

    public class Position {

        private int row;
        private int column;
        
        public Position(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getColumn() {
            return column;
        }

        public void setColumn(int column) {
            this.column = column;
        }
        
        @Override
        public String toString() {
            return row + ", " +column;
        }
    }

Daí, no arquivo Program.java vamos colocar o seguinte para verificar se até agora está tudo indo bem

    package application;

    import boardgame.Position;

    public class Program {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            
            Position pos = new Position(3, 5);
            System.out.println(pos);
        }

    }

No caso, no console deverá ser exibido as posições que foi colocado.

Visto que está sendo exibido corretamente, vamos salvar as alterações feita até agora.

## Aula 05 - Começando a implementar Board e Piece:
Vamos agora criar as classes Piece e Board, ambos dentro do diretório boardgame, que serão as peças e o tabuleiro.

Para esse assunto, será usado os conceitos de associação, encapsulação (access modifiers) e Matrix.

Agora, no arquivo Piece.java, vamos colocar o seguinte

    package boardgame;

    public class Piece {

        protected Position position;
        private Board board;
        
        public Piece(Board board) {
            this.board = board;
            // Para indicar a posição inicial de uma peça recém criada
            // Vc poderia não colocar nada, pois assim a linguagem Java
            // Automaticamente assimilaria que o position é nulo.
            position = null;
        }

        // Vamos deixar ele protected
        // Somente classes dentro do pacote e subclasses poderão acessar esse get.
        // Isso restringirá que as peças são de uso dentro, apenas, da camada tabuleiro
        protected Board getBoard() {
            return board;
        }
        
    }

Agora, no Board.java vamos fazer o seguinte

    package boardgame;

    public class Board {

        private int rows;
        private int columns;
        // Forma de declarar uma matriz.
        private Piece[][] piece;
        
        public Board(int rows, int columns) {
            this.rows = rows;
            this.columns = columns;
            piece = new Piece[rows][columns];
        }

        public int getRows() {
            return rows;
        }

        public void setRows(int rows) {
            this.rows = rows;
        }

        public int getColumns() {
            return columns;
        }

        public void setColumns(int columns) {
            this.columns = columns;
        }
        
    }

Agora, em Program.java vamos colocar o seguinte para ver se toda a implementação realizada até agora está pronta

    package application;

    import boardgame.Board;

    public class Program {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            
            Board board = new Board(8, 8);
        }

    }

Bom, por hora não vamos poder imprimir o tabuleiro, pois não foi implementado algo do tipo ainda.

## Aula 06 - Camada Chess e imprimindo o tabuleiro:

## Aula 07 - Colocando peças no tabuleiro:

## Aula 08 - BoardException e programação defensiva:

## Aula 09 - ChessException e ChessPosition:

## Aula 10 - Pequena melhoria na impressão do tabuleiro:

## Aula 11 - Movendo peças:

## Aula 12 - Tratando exceções e limpando a tela:

## Aula 13 - Movimentos possíveis de uma peça:

## Aula 14 - Implementando movimentos possíveis da Torre:

## Aula 15 - Imprimindo os movimentos possíveis:

## Aula 16 - Implementando os movimentos possíveis do Rei:

## Aula 17 - Trocando de jogador a cada turno:

## Aula 18 - Manipulando peças capturadas:

## Aula 19 - Lógica de xeque - PARTE 1:

## Aula 20 - Lógica de xeque - PARTE 2:

## Aula 21 - Lógica de xequemate:

## Aula 22 - Contagem de movimentos das peças:

## Aula 23 - Peão:

## Aula 24 - Bispo:

## Aula 25 - Cavalo:

## Aula 26 - Rainha:

## Aula 27 - Jogada especial Roque - PARTE 1:

## Aula 28 - Jogada especial Roque - PARTE 2:

## Aula 29 - Jogada especial en passant - PARTE 1:

## Aula 30 - Jogada especial en passant - PARTE 2:

## Aula 31 - Jogada especial promoção:

## Aula 32 - Atualização de compliance:

## Aula 33 - Dando um tratamento melhor para promoção:
