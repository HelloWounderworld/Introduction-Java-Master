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
        private Piece[][] pieces;
        
        public Board(int rows, int columns) {
            this.rows = rows;
            this.columns = columns;
            pieces = new Piece[rows][columns];
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
Nessa aula vamos criar os seguintes métodos

- Board.Piece(row, column)

- Board.Piece(position)

E a enumeração

- Chess.Color

As classes

- Chess.ChessPiece [public]

- Chess.ChessMatch [public]

- ChessConsole.UI

Utilizaremos os seguintes conceitos de orientação à objeto

- Enumerations

- Encapsulations

- Inheritance

- Downcasting

- Static members

- Layers pattern

Na estrutura de dado, vamos usar

- Matriz

Bom, começando no arquivo Board.java vamos definir o método seguinte

    package boardgame;

    public class Board {

        private int rows;
        private int columns;
        // Forma de declarar uma matriz.
        private Piece[][] pieces;
        
        public Board(int rows, int columns) {
            this.rows = rows;
            this.columns = columns;
            pieces = new Piece[rows][columns];
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
        
        public Piece piece(int row, int column) {
            return pieces[row][column];
        }
        
        public Piece piece(Position position) {
            return pieces[position.getRow()][position.getColumn()];
        }
    }

Vamos agora criar uma enumeração chess com o nome Color. E no arquivo Color.java vamos colocar o seguinte

    package chess;

    public enum Color {
        BLACK,
        WHITE;
    }

Dentro do diretório chess vamos criar uma classe ChessPiece. Dentro do arquivo ChessPiece vamos colocar o seguinte

    package chess;

    import boardgame.Board;
    import boardgame.Piece;

    public class ChessPiece extends Piece {

        private Color color;

        public ChessPiece(Board board, Color color) {
            super(board);
            this.color = color;
        }

        public Color getColor() {
            return color;
        }
        
    }

Agora, vamos criar a classe ChessMatch dentro do diretório chess e dentro do arquivo ChessMatch.java, colocamos o seguinte. Basicamente, essa classe será o nosso coração do sistema, pois nela que irá residir toda a regra de xadrez

    package chess;

    import boardgame.Board;

    public class ChessMatch {

        private Board board;
        
        public ChessMatch() {
            board = new Board(8, 8);
        }
        
        public ChessPiece[][] getPieces() {
            ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
            for (int i=0; i < board.getRows(); i++) {
                for (int j=0; j < board.getColumns(); j++) {
                    mat[i][j] = (ChessPiece) board.piece(i, j);
                }
            }
            return mat;
        }
    }

Agora, no arquivo Program.java, vamos realizar o seguinte para impressão do tabuleiro

    package application;

    import chess.ChessMatch;

    public class Program {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            
            ChessMatch chessMatch = new ChessMatch();
            UI.printBoard(chessMatch.getPieces());
        }

    }

Agora, só falta criarmos a classe UI dentro do diretório application

    package application;

    import chess.ChessPiece;

    public class UI {

        public static void printBoard(ChessPiece[][] pieces) {
            for (int i=0; i < pieces.length; i++) {
                System.out.print((8-i) + " ");
                for (int j=0; j < pieces.length; j++) {
                    printPiece(pieces[i][j]);
                }
                System.out.println();
            }
            System.out.println("  a b c d e f g h");
        }
        
        private static void printPiece(ChessPiece piece) {
            if (piece == null) {
                System.out.print("-");
            } else {
                System.out.print(piece);
            }
            
            System.out.print(" ");
        }
    }

Agora, só precisa rodar para ver se será printado no console a imagem do tabuleiro.

## Aula 07 - Colocando peças no tabuleiro:
Bom, nessa aula vamos colocar as peças no tabuleiro.

Nos métodos vamos criar os seguinte

- Board.PlacePice(piece, position)

- ChessMatch.InitialSetup

Nas classes vamos colocar o seguinte

- Rook, King [public]

No conceito de orientação à objetos será usado o seguinte

- Inheritance

- Overriding

- Polymorphism (toString)

Vamos começando primeiro por criar o método PlacePiece na classe Board. Então, no arquivo Board.java, vamos fazer o seguinte

    package boardgame;

    public class Board {

        private int rows;
        private int columns;
        // Forma de declarar uma matriz.
        private Piece[][] pieces;
        
        public Board(int rows, int columns) {
            this.rows = rows;
            this.columns = columns;
            pieces = new Piece[rows][columns];
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
        
        public Piece piece(int row, int column) {
            return pieces[row][column];
        }
        
        public Piece piece(Position position) {
            return pieces[position.getRow()][position.getColumn()];
        }
        
        public void placePiece(Piece piece, Position position) {
            pieces[position.getRow()][position.getColumn()] = piece;
            piece.position = position;
        }
    }

Agora, vamos criar as classes Rook e King, ambas dentro do diretório chess.pieces. Dentro do arquivo Rook.java vamos colocar o seguinte

    package chess.pieces;

    import boardgame.Board;
    import chess.ChessPiece;
    import chess.Color;

    public class Rook extends ChessPiece {

        public Rook(Board board, Color color) {
            super(board, color);
            // TODO Auto-generated constructor stub
        }

        @Override
        public String toString() {
            return "R";
        }
    }

Agora, no arquivo King.java vamos realizar o seguinte

    package chess.pieces;

    import boardgame.Board;
    import chess.ChessPiece;
    import chess.Color;

    public class King extends ChessPiece {

        public King(Board board, Color color) {
            super(board, color);
            // TODO Auto-generated constructor stub
        }
        
        @Override
        public String toString() {
            return "K";
        }
    }

Agora, resta criarmos o outro método no arquivo ChessMatch.java

    package chess;

    import boardgame.Board;
    import boardgame.Position;
    import chess.pieces.King;
    import chess.pieces.Rook;

    public class ChessMatch {

        private Board board;
        
        public ChessMatch() {
            board = new Board(8, 8);
            initialSetup();
        }
        
        public ChessPiece[][] getPieces() {
            ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
            for (int i=0; i < board.getRows(); i++) {
                for (int j=0; j < board.getColumns(); j++) {
                    mat[i][j] = (ChessPiece) board.piece(i, j);
                }
            }
            return mat;
        }
        
        private void initialSetup() {
            board.placePiece(new Rook(board, Color.WHITE), new Position(2, 1));
            board.placePiece(new King(board, Color.BLACK), new Position(0, 4));
            board.placePiece(new King(board, Color.WHITE), new Position(7, 4));
        }
    }

Feito isso, ao rodarmos a aplicação, vamos ver que na coordenada que colocamos da posição, estará a Torre localizada em "R", analogamente para os dois reis que definimos.

## Aula 08 - BoardException e programação defensiva:
Vamos implementar nesse projeto uma classe BoardException e adotar a prática de programação defensiva.

As classes que iremos criar

- BoardException [public]

Métodos que criaremos

- PositionExists na classe Board

- ThereIsAPiece na classe Board

Implementação que faremos

- Programação defensiva nos métodos Board

Conceito de Orientação à objetos que será realizada

- Exceptions

- Constructors

Vamos começando por criar a classe BoardException. No caso, dentro diretório boardgame, vamos criar o arquivo BoardException.java e dentro dela vamos colocar o seguinte

    package boardgame;

    public class BoardException extends RuntimeException {

        private static final long serialVersionUID = 1L;
        
        public BoardException(String msg) {
            super(msg);
        }
    }

Agora, na classe Board.java vamos colocar o método positionExists

    package boardgame;

    public class Board {

        private int rows;
        private int columns;
        // Forma de declarar uma matriz.
        private Piece[][] pieces;
        
        public Board(int rows, int columns) {
            this.rows = rows;
            this.columns = columns;
            pieces = new Piece[rows][columns];
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
        
        public Piece piece(int row, int column) {
            return pieces[row][column];
        }
        
        public Piece piece(Position position) {
            return pieces[position.getRow()][position.getColumn()];
        }
        
        public void placePiece(Piece piece, Position position) {
            pieces[position.getRow()][position.getColumn()] = piece;
            piece.position = position;
        }
        
        private boolean positionExists(int row, int column) {
            return row >= 0 && row < rows && column >= 0 && column < columns;
        }
        
        public boolean positionExists(Position position) {
            return positionExists(position.getRow(), position.getColumn());
        }
    }

Na mesma classe, agora, vamos implementar o método thereIsAPiece

    package boardgame;

    public class Board {

        private int rows;
        private int columns;
        // Forma de declarar uma matriz.
        private Piece[][] pieces;
        
        public Board(int rows, int columns) {
            this.rows = rows;
            this.columns = columns;
            pieces = new Piece[rows][columns];
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
        
        public Piece piece(int row, int column) {
            return pieces[row][column];
        }
        
        public Piece piece(Position position) {
            return pieces[position.getRow()][position.getColumn()];
        }
        
        public void placePiece(Piece piece, Position position) {
            pieces[position.getRow()][position.getColumn()] = piece;
            piece.position = position;
        }
        
        private boolean positionExists(int row, int column) {
            return row >= 0 && row < rows && column >= 0 && column < columns;
        }
        
        public boolean positionExists(Position position) {
            return positionExists(position.getRow(), position.getColumn());
        }
        
        public boolean thereIsAPiece(Position position) {
            return piece(position) != null;
        }
    }

Falta, agora, implementarmos a programação defensiva na classe Board, no caso, no construtor Board vamos colocar a condição de que não existe uma matriz com linha ou coluna nula

    package boardgame;

    public class Board {

        private int rows;
        private int columns;
        // Forma de declarar uma matriz.
        private Piece[][] pieces;
        
        public Board(int rows, int columns) {
            if (rows < 1 || columns < 1) {
                throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
            }
            this.rows = rows;
            this.columns = columns;
            pieces = new Piece[rows][columns];
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
        
        public Piece piece(int row, int column) {
            return pieces[row][column];
        }
        
        public Piece piece(Position position) {
            return pieces[position.getRow()][position.getColumn()];
        }
        
        public void placePiece(Piece piece, Position position) {
            pieces[position.getRow()][position.getColumn()] = piece;
            piece.position = position;
        }
        
        private boolean positionExists(int row, int column) {
            return row >= 0 && row < rows && column >= 0 && column < columns;
        }
        
        public boolean positionExists(Position position) {
            return positionExists(position.getRow(), position.getColumn());
        }
        
        public boolean thereIsAPiece(Position position) {
            return piece(position) != null;
        }
    }

Outra implementação que vamos fazer de programação defensiva, será o seguinte, tirar o setRows e setColumns, pois não vamos querer ter uma via manual que permita alterar a quantidade linhas e colunas

    package boardgame;

    public class Board {

        private int rows;
        private int columns;
        // Forma de declarar uma matriz.
        private Piece[][] pieces;
        
        public Board(int rows, int columns) {
            if (rows < 1 || columns < 1) {
                throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
            }
            this.rows = rows;
            this.columns = columns;
            pieces = new Piece[rows][columns];
        }

        public int getRows() {
            return rows;
        }

        public int getColumns() {
            return columns;
        }
        
        public Piece piece(int row, int column) {
            return pieces[row][column];
        }
        
        public Piece piece(Position position) {
            return pieces[position.getRow()][position.getColumn()];
        }
        
        public void placePiece(Piece piece, Position position) {
            pieces[position.getRow()][position.getColumn()] = piece;
            piece.position = position;
        }
        
        private boolean positionExists(int row, int column) {
            return row >= 0 && row < rows && column >= 0 && column < columns;
        }
        
        public boolean positionExists(Position position) {
            return positionExists(position.getRow(), position.getColumn());
        }
        
        public boolean thereIsAPiece(Position position) {
            return piece(position) != null;
        }
    }

Outra implementação que de programação defensiva será em Piece piece que confere a existência da posição ou não

    package boardgame;

    public class Board {

        private int rows;
        private int columns;
        // Forma de declarar uma matriz.
        private Piece[][] pieces;
        
        public Board(int rows, int columns) {
            if (rows < 1 || columns < 1) {
                throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
            }
            this.rows = rows;
            this.columns = columns;
            pieces = new Piece[rows][columns];
        }

        public int getRows() {
            return rows;
        }

        public int getColumns() {
            return columns;
        }
        
        public Piece piece(int row, int column) {
            if (!positionExists(row, column)) {
                throw new BoardException("Position not on the board");
            }
            return pieces[row][column];
        }
        
        public Piece piece(Position position) {
            if (!positionExists(position)) {
                throw new BoardException("Position not on the board");
            }
            return pieces[position.getRow()][position.getColumn()];
        }
        
        public void placePiece(Piece piece, Position position) {
            pieces[position.getRow()][position.getColumn()] = piece;
            piece.position = position;
        }
        
        private boolean positionExists(int row, int column) {
            return row >= 0 && row < rows && column >= 0 && column < columns;
        }
        
        public boolean positionExists(Position position) {
            return positionExists(position.getRow(), position.getColumn());
        }
        
        public boolean thereIsAPiece(Position position) {
            return piece(position) != null;
        }
    }

Outra implementação que vamos fazer de programação defensiva vai ser no placePiece e thereIsAPice que confere se a peça onde vc irá querer colocar já está ou não ocupado por uma outra peça e confere se essa posição existe ou não, respectivamente

    package boardgame;

    public class Board {

        private int rows;
        private int columns;
        // Forma de declarar uma matriz.
        private Piece[][] pieces;
        
        public Board(int rows, int columns) {
            if (rows < 1 || columns < 1) {
                throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
            }
            this.rows = rows;
            this.columns = columns;
            pieces = new Piece[rows][columns];
        }

        public int getRows() {
            return rows;
        }

        public int getColumns() {
            return columns;
        }
        
        public Piece piece(int row, int column) {
            if (!positionExists(row, column)) {
                throw new BoardException("Position not on the board");
            }
            return pieces[row][column];
        }
        
        public Piece piece(Position position) {
            if (!positionExists(position)) {
                throw new BoardException("Position not on the board");
            }
            return pieces[position.getRow()][position.getColumn()];
        }
        
        public void placePiece(Piece piece, Position position) {
            if (thereIsAPiece(position)) {
                throw new BoardException("There is already a piece on position " + position);
            }
            pieces[position.getRow()][position.getColumn()] = piece;
            piece.position = position;
        }
        
        private boolean positionExists(int row, int column) {
            return row >= 0 && row < rows && column >= 0 && column < columns;
        }
        
        public boolean positionExists(Position position) {
            return positionExists(position.getRow(), position.getColumn());
        }
        
        public boolean thereIsAPiece(Position position) {
            if (!positionExists(position)) {
                throw new BoardException("Position not on the board");
            }
            return piece(position) != null;
        }
    }

Para testarmos isso, bastaria ir na classe ChessMatch e no initialSetup colocar alguma posição que não existe dentro do tabileiro e rodar o programa com isso.

## Aula 09 - ChessException e ChessPosition:
O que vamos fazer nessa aula?

Criaremos as seguintes classes

- ChessException [public]

- ChessPosition [public]

Refatorar o método ChessMatch.initialSetup

Conceito de orientação ao objetos que vamos usar

- Exceptions

- Encapsulation

- Constructors (a string must be informed to the exception)

- Overriding

- Static members

- Layers pattern

Vamos começar criando as classes ChessException e ChessPosition, ambas dentro do diretório chess. Daí, dentro da classe ChessException.java vamos colocar o seguinte

    package chess;

    public class ChessException extends RuntimeException {

        private static final long serialVersionUID = 1L;
        
        public ChessException(String msg) {
            super(msg);
        }
    }

Agora, na classe ChessPosition.java, vamos colocar o seguinte

    package chess;

    import boardgame.Position;

    public class ChessPosition {

        private char column;
        private int row;
        
        public ChessPosition(char column, int row) {
            if (column < 'a' || column > 'h' || row < 1 || row > 8) {
                throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 to h8.");
            }
            this.column = column;
            this.row = row;
        }

        public char getColumn() {
            return column;
        }

        public int getRow() {
            return row;
        }
        
        protected Position toPosition() {
            return new Position(8 - row, column - 'a');
        }
        
        protected static ChessPosition fromPosition(Position position) {
            return new ChessPosition((char) ('a' - position.getColumn()), 8 - position.getRow());
        }
        
        @Override
        public String toString() {
            // String vazio "" para forçar ao compilador a entender que temos uma concatenação de strings
            return "" + column + row;
        }
    }

Agora, na classe ChessMatch.java no método initialSetup vamos realizar uma refatoração criando um novo método placeNewPiece que será usado dentro desse método initialSetup

    package chess;

    import boardgame.Board;
    import chess.pieces.King;
    import chess.pieces.Rook;

    public class ChessMatch {

        private Board board;
        
        public ChessMatch() {
            board = new Board(8, 8);
            initialSetup();
        }
        
        public ChessPiece[][] getPieces() {
            ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
            for (int i=0; i < board.getRows(); i++) {
                for (int j=0; j < board.getColumns(); j++) {
                    mat[i][j] = (ChessPiece) board.piece(i, j);
                }
            }
            return mat;
        }
        
        private void placeNewPiece(char column, int row, ChessPiece piece) {
            board.placePiece(piece, new ChessPosition(column, row).toPosition());
        }
        
        private void initialSetup() {
            placeNewPiece('b', 6, new Rook(board, Color.WHITE));
            placeNewPiece('e', 8, new King(board, Color.BLACK));
            placeNewPiece('e', 1, new King(board, Color.WHITE));
        }
    }

Agora, está no formato em que colocamos os comandos de coordenada na linguagem de xadrez.

## Aula 10 - Pequena melhoria na impressão do tabuleiro:
Vamos realizar uma pequena melhoria na impressão do tabuleiro.

No caso, vamos colocar cores para as peças.

Color in terminal

- Windows: Git Bash

- Mac: Google "psx terminal color"

Checklist

- Place more pieces on the board

- Distinguish piece colors in UI.PrintPiece method

Bom, na classe UI, vamos colocar o seguinte código

    package application;

    import chess.ChessPiece;

    public class UI {
        
        // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

        public static final String ANSI_RESET = "\u001B[0m";
        public static final String ANSI_BLACK = "\u001B[30m";
        public static final String ANSI_RED = "\u001B[31m";
        public static final String ANSI_GREEN = "\u001B[32m";
        public static final String ANSI_YELLOW = "\u001B[33m";
        public static final String ANSI_BLUE = "\u001B[34m";
        public static final String ANSI_PURPLE = "\u001B[35m";
        public static final String ANSI_CYAN = "\u001B[36m";
        public static final String ANSI_WHITE = "\u001B[37m";

        public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
        public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
        public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
        public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
        public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
        public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
        public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
        public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

        public static void printBoard(ChessPiece[][] pieces) {
            for (int i=0; i < pieces.length; i++) {
                System.out.print((8-i) + " ");
                for (int j=0; j < pieces.length; j++) {
                    printPiece(pieces[i][j]);
                }
                System.out.println();
            }
            System.out.println("  a b c d e f g h");
        }
        
        private static void printPiece(ChessPiece piece) {
            if (piece == null) {
                System.out.print("-");
            } else {
                System.out.print(piece);
            }
            
            System.out.print(" ");
        }
    }

Não se preocupe se vc se perguntou que teria que saber o foi colocado no código acima de cor. Não, não precisa. Eu mesmo só peguei do stackoverflow e cópiei e colei.

Agora, na mesma classe UI, vamos refatorar o método printpPiece para fazer com que as peças sejam distinguidas entre cores pretas e brancas

    package application;

    import chess.ChessPiece;
    import chess.Color;

    public class UI {
        
        // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

        public static final String ANSI_RESET = "\u001B[0m";
        public static final String ANSI_BLACK = "\u001B[30m";
        public static final String ANSI_RED = "\u001B[31m";
        public static final String ANSI_GREEN = "\u001B[32m";
        public static final String ANSI_YELLOW = "\u001B[33m";
        public static final String ANSI_BLUE = "\u001B[34m";
        public static final String ANSI_PURPLE = "\u001B[35m";
        public static final String ANSI_CYAN = "\u001B[36m";
        public static final String ANSI_WHITE = "\u001B[37m";

        public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
        public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
        public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
        public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
        public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
        public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
        public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
        public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

        public static void printBoard(ChessPiece[][] pieces) {
            for (int i=0; i < pieces.length; i++) {
                System.out.print((8-i) + " ");
                for (int j=0; j < pieces.length; j++) {
                    printPiece(pieces[i][j]);
                }
                System.out.println();
            }
            System.out.println("  a b c d e f g h");
        }
        
        private static void printPiece(ChessPiece piece) {
            if (piece == null) {
                System.out.print("-");
            } else {
                if (piece.getColor() == Color.WHITE) {
                    System.out.print(ANSI_WHITE + piece + ANSI_RESET);
                }
                else {
                    System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
                }
            }
            
            System.out.print(" ");
        }
    }

Agora, vamos colocar mais peças na classe ChessMatch.java, então realizemos da seguinte forma

    package chess;

    import boardgame.Board;
    import chess.pieces.King;
    import chess.pieces.Rook;

    public class ChessMatch {

        private Board board;
        
        public ChessMatch() {
            board = new Board(8, 8);
            initialSetup();
        }
        
        public ChessPiece[][] getPieces() {
            ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
            for (int i=0; i < board.getRows(); i++) {
                for (int j=0; j < board.getColumns(); j++) {
                    mat[i][j] = (ChessPiece) board.piece(i, j);
                }
            }
            return mat;
        }
        
        private void placeNewPiece(char column, int row, ChessPiece piece) {
            board.placePiece(piece, new ChessPosition(column, row).toPosition());
        }
        
        private void initialSetup() {
            placeNewPiece('c', 1, new Rook(board, Color.WHITE));
            placeNewPiece('c', 2, new Rook(board, Color.WHITE));
            placeNewPiece('d', 2, new Rook(board, Color.WHITE));
            placeNewPiece('e', 2, new Rook(board, Color.WHITE));
            placeNewPiece('e', 1, new Rook(board, Color.WHITE));
            placeNewPiece('d', 1, new King(board, Color.WHITE));

            placeNewPiece('c', 7, new Rook(board, Color.BLACK));
            placeNewPiece('c', 8, new Rook(board, Color.BLACK));
            placeNewPiece('d', 7, new Rook(board, Color.BLACK));
            placeNewPiece('e', 7, new Rook(board, Color.BLACK));
            placeNewPiece('e', 8, new Rook(board, Color.BLACK));
            placeNewPiece('d', 8, new King(board, Color.BLACK));
        }
    }

Agora, só precisamos rodar o programa para ver se toda a implementação que realizamos até agora está tudo funcionando. Para isso, vamos ter que entrar na pasta bin do nosso projeto e dentro dela clicar com o mouse direito e selecionar "Git Bash Here". Isso irá abrir um terminal e nela bastaria digitar "java application/Program". Assim, será exibido todas as aplicações com cores que foram implementado no nosso projeto.

De agora em diante, vamos prosseguir com o curso por essa via.

## Aula 11 - Movendo peças:
Vamos, agora, criar códigos que permite o movimento das peças.

Métodos que vamos criar nessa aula

- RemovePiece na classe Board

- ReadChessPosition na classe UI

- PerformChessPosition na classe ChessMatch
    - MakeMove na classe ChessMatch

    - ValidadeSourcePosition na classe ChessMatch

Vamos escrever uma lógica básica em Program.cs

Conceitos de orientação à objetos que serão usados

- Exceptions

- Encapsulation

Vamos començando pela classe Board.java, nela iremos colocar o método RemovePiece

    package boardgame;

    public class Board {

        private int rows;
        private int columns;
        // Forma de declarar uma matriz.
        private Piece[][] pieces;
        
        public Board(int rows, int columns) {
            if (rows < 1 || columns < 1) {
                throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
            }
            this.rows = rows;
            this.columns = columns;
            pieces = new Piece[rows][columns];
        }

        public int getRows() {
            return rows;
        }

        public int getColumns() {
            return columns;
        }
        
        public Piece piece(int row, int column) {
            if (!positionExists(row, column)) {
                throw new BoardException("Position not on the board");
            }
            return pieces[row][column];
        }
        
        public Piece piece(Position position) {
            if (!positionExists(position)) {
                throw new BoardException("Position not on the board");
            }
            return pieces[position.getRow()][position.getColumn()];
        }
        
        public void placePiece(Piece piece, Position position) {
            if (thereIsAPiece(position)) {
                throw new BoardException("There is already a piece on position " + position);
            }
            pieces[position.getRow()][position.getColumn()] = piece;
            piece.position = position;
        }
        
        public Piece removePiece(Position position) {
            if (!positionExists(position)) {
                throw new BoardException("Position not on the board");
            }
            if (piece(position) == null) {
                return null;
            }
            Piece aux = piece(position);
            aux.position = null;
            pieces[position.getRow()][position.getColumn()] = null;
            
            return aux;
        }
        
        private boolean positionExists(int row, int column) {
            return row >= 0 && row < rows && column >= 0 && column < columns;
        }
        
        public boolean positionExists(Position position) {
            return positionExists(position.getRow(), position.getColumn());
        }
        
        public boolean thereIsAPiece(Position position) {
            if (!positionExists(position)) {
                throw new BoardException("Position not on the board");
            }
            return piece(position) != null;
        }
    }

Agora, na classe UI vamos criar o método readChessPosition, então coloquemos o seguinte

    package application;

    import java.util.InputMismatchException;
    import java.util.Scanner;

    import chess.ChessPiece;
    import chess.ChessPosition;
    import chess.Color;

    public class UI {
        
        // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

        public static final String ANSI_RESET = "\u001B[0m";
        public static final String ANSI_BLACK = "\u001B[30m";
        public static final String ANSI_RED = "\u001B[31m";
        public static final String ANSI_GREEN = "\u001B[32m";
        public static final String ANSI_YELLOW = "\u001B[33m";
        public static final String ANSI_BLUE = "\u001B[34m";
        public static final String ANSI_PURPLE = "\u001B[35m";
        public static final String ANSI_CYAN = "\u001B[36m";
        public static final String ANSI_WHITE = "\u001B[37m";

        public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
        public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
        public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
        public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
        public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
        public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
        public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
        public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
        
        public static ChessPosition readChessPosition(Scanner sc) {
            try {
                String s = sc.nextLine();
                char column = s.charAt(0);
                int row = Integer.parseInt(s.substring(1));
                return new ChessPosition(column, row);
            }
            catch (RuntimeException e) {
                throw new InputMismatchException("Error reading ChessPosition. Valid values are from a1 to h8.");
            }
        }

        public static void printBoard(ChessPiece[][] pieces) {
            for (int i=0; i < pieces.length; i++) {
                System.out.print((8-i) + " ");
                for (int j=0; j < pieces.length; j++) {
                    printPiece(pieces[i][j]);
                }
                System.out.println();
            }
            System.out.println("  a b c d e f g h");
        }
        
        private static void printPiece(ChessPiece piece) {
            if (piece == null) {
                System.out.print("-");
            } else {
                if (piece.getColor() == Color.WHITE) {
                    System.out.print(ANSI_WHITE + piece + ANSI_RESET);
                }
                else {
                    System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
                }
            }
            
            System.out.print(" ");
        }
    }

Agora, na classe ChessMatch, vamos criar o método PerformChessMove, validateSourcePosition e makeMove então vamos colocar o seguinte

    package chess;

    import boardgame.Board;
    import boardgame.Piece;
    import boardgame.Position;
    import chess.pieces.King;
    import chess.pieces.Rook;

    public class ChessMatch {

        private Board board;
        
        public ChessMatch() {
            board = new Board(8, 8);
            initialSetup();
        }
        
        public ChessPiece[][] getPieces() {
            ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
            for (int i=0; i < board.getRows(); i++) {
                for (int j=0; j < board.getColumns(); j++) {
                    mat[i][j] = (ChessPiece) board.piece(i, j);
                }
            }
            return mat;
        }
        
        public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
            Position source = sourcePosition.toPosition();
            Position target = targetPosition.toPosition();
            validateSourcePosition(source);
            Piece capturedPiece = makeMove(source, target);
            return (ChessPiece) capturedPiece;
        }
        
        private Piece makeMove(Position source, Position target) {
            Piece p = board.removePiece(source);
            Piece capturedPiece = board.removePiece(target);
            board.placePiece(p, target);
            return capturedPiece;
        }
        
        private void validateSourcePosition(Position position) {
            if (!board.thereIsAPiece(position)) {
                throw new ChessException("There is no piece on source position");
            }
        }
        
        private void placeNewPiece(char column, int row, ChessPiece piece) {
            board.placePiece(piece, new ChessPosition(column, row).toPosition());
        }
        
        private void initialSetup() {
            placeNewPiece('c', 1, new Rook(board, Color.WHITE));
            placeNewPiece('c', 2, new Rook(board, Color.WHITE));
            placeNewPiece('d', 2, new Rook(board, Color.WHITE));
            placeNewPiece('e', 2, new Rook(board, Color.WHITE));
            placeNewPiece('e', 1, new Rook(board, Color.WHITE));
            placeNewPiece('d', 1, new King(board, Color.WHITE));

            placeNewPiece('c', 7, new Rook(board, Color.BLACK));
            placeNewPiece('c', 8, new Rook(board, Color.BLACK));
            placeNewPiece('d', 7, new Rook(board, Color.BLACK));
            placeNewPiece('e', 7, new Rook(board, Color.BLACK));
            placeNewPiece('e', 8, new Rook(board, Color.BLACK));
            placeNewPiece('d', 8, new King(board, Color.BLACK));
        }
    }

Agora, vamos testar se ele está rodando direito. No caso, no arquivo Program.java vamos implementar o seguinte

    package application;

    import java.util.Scanner;

    import chess.ChessMatch;
    import chess.ChessPiece;
    import chess.ChessPosition;

    public class Program {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            
            Scanner sc = new Scanner(System.in);
            ChessMatch chessMatch = new ChessMatch();
            
            while (true) {
                UI.printBoard(chessMatch.getPieces());
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(sc);
                
                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(sc);
                
                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
            }

        }

    }

Agora, basta rodar no terminal. Como um experimento, no source vc pode colocar o "c2" para indicar a Torre e o destino target colocar "c5". Daí vc verá que a torre foi movida. Em seguida, colcar "c3" para "c4" para verificar se haverá algum erro retornando, pois estamos tentando mover uma peça que nem existe nessa posição. Note que, quando dá algum erro, até a aplicação pelo terminal termina, ou seja, saindo do loop while.

## Aula 12 - Tratando exceções e limpando a tela:
Bom, vamos fazer uma limpeza de tela, no sentido de que quando rodamos o projeto pelo terminal, cada vez que realizamos algum comando nela os comandos anteriores ainda ficam exibidos. Isso, de certa forma, polui a tela. Então vamos limpar cada vez que realizamos algum comando novo.

Para isso, vamos colocar na classe UI o seguinte método chamado clearScreen

    package application;

    import java.util.InputMismatchException;
    import java.util.Scanner;

    import chess.ChessPiece;
    import chess.ChessPosition;
    import chess.Color;

    public class UI {
        
        // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

        public static final String ANSI_RESET = "\u001B[0m";
        public static final String ANSI_BLACK = "\u001B[30m";
        public static final String ANSI_RED = "\u001B[31m";
        public static final String ANSI_GREEN = "\u001B[32m";
        public static final String ANSI_YELLOW = "\u001B[33m";
        public static final String ANSI_BLUE = "\u001B[34m";
        public static final String ANSI_PURPLE = "\u001B[35m";
        public static final String ANSI_CYAN = "\u001B[36m";
        public static final String ANSI_WHITE = "\u001B[37m";

        public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
        public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
        public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
        public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
        public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
        public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
        public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
        public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
        
        // https://stackoverflow.com/questions/2979383/java-clear-the-console 
        public static void clearScreen() {   
            System.out.print("\033[H\033[2J");   
            System.out.flush();   
        }
        
        public static ChessPosition readChessPosition(Scanner sc) {
            try {
                String s = sc.nextLine();
                char column = s.charAt(0);
                int row = Integer.parseInt(s.substring(1));
                return new ChessPosition(column, row);
            }
            catch (RuntimeException e) {
                throw new InputMismatchException("Error reading ChessPosition. Valid values are from a1 to h8.");
            }
        }

        public static void printBoard(ChessPiece[][] pieces) {
            for (int i=0; i < pieces.length; i++) {
                System.out.print((8-i) + " ");
                for (int j=0; j < pieces.length; j++) {
                    printPiece(pieces[i][j]);
                }
                System.out.println();
            }
            System.out.println("  a b c d e f g h");
        }
        
        private static void printPiece(ChessPiece piece) {
            if (piece == null) {
                System.out.print("-");
            } else {
                if (piece.getColor() == Color.WHITE) {
                    System.out.print(ANSI_WHITE + piece + ANSI_RESET);
                }
                else {
                    System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
                }
            }
            
            System.out.print(" ");
        }
    }

Agora, na aplicação vamos chamar esse método. No caso, no arquivo Program.java vamos colocar o seguinte

    package application;

    import java.util.Scanner;

    import chess.ChessMatch;
    import chess.ChessPiece;
    import chess.ChessPosition;

    public class Program {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            
            Scanner sc = new Scanner(System.in);
            ChessMatch chessMatch = new ChessMatch();
            
            while (true) {
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces());
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(sc);
                
                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(sc);
                
                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
            }

        }

    }

Agora, vamos tratar as excessões, ChessException e InputMismatchException. No caso, no arquivo de aplicação, Program.java, vamos realizar o seguinte

    package application;

    import java.util.InputMismatchException;
    import java.util.Scanner;

    import chess.ChessException;
    import chess.ChessMatch;
    import chess.ChessPiece;
    import chess.ChessPosition;

    public class Program {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            
            Scanner sc = new Scanner(System.in);
            ChessMatch chessMatch = new ChessMatch();
            
            while (true) {
                try {
                    UI.clearScreen();
                    UI.printBoard(chessMatch.getPieces());
                    System.out.println();
                    System.out.print("Source: ");
                    ChessPosition source = UI.readChessPosition(sc);
                    
                    System.out.println();
                    System.out.print("Target: ");
                    ChessPosition target = UI.readChessPosition(sc);
                    
                    ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
                }
                catch (ChessException e ) {
                    System.out.println(e.getMessage());
                    sc.nextLine();
                }
                catch (InputMismatchException e ) {
                    System.out.println(e.getMessage());
                    sc.nextLine();
                }
            }

        }

    }

Feito isso, vamos rodar o projeto para verificar se está tudo de acordo.

Note que, agora, o tratamento desse erro aqui está permitindo com que mesmo que ocorra algum erro de posição ou de movimento de peça inexistente, não saia do laço while.

## Aula 13 - Movimentos possíveis de uma peça:
Bom, vamos ver as regras de movimento de cada peça.

No caso, esse conceito foi estudado na faculdade na linguagem python, que são exploração de booleanos em matriz de posições que vc pode ir ou não.

Para isso nos métodos vamos colocar o seguinte

- Na classe Piece
    - PossibleMoves [abstract]

    - PossibleMove

    - isThereAnyPossibleMove

- Atualização via método ValidadeSourcePosition na classe ChessMatch

Vamos realizar uma implementação básica de PossibleMove para Torre e Rei.

Os conceitos de orientação à objetos que vamos usar serão os seguinte

- Abstract Method / class

- Exceptions

Vamos começando as implementações na classe Piece.java

    package boardgame;

    public abstract class Piece {

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
        
        public abstract boolean[][] possibleMoves();
        
        // Hook Methods
        public boolean possibleMove(Position position) {
            return possibleMoves()[position.getRow()][position.getColumn()];
        }
        
        public boolean isThereAnyPossibleMove() {
            boolean[][] mat = possibleMoves();
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat.length; j ++) {
                    if (mat[i][j]) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

Lembrando que, como a classe Piece.java é uma subclasse da classe ChessPiece e a classe Piece é abastrata, a classe ChessPiece precisa ser abstrata tbm.

Vamos, agora, realizar uma implementação básica da Torre e do Rei. Então no arquivo Piece.java vamos fazer o seguinte:

- Para o Rei

    package chess.pieces;

    import boardgame.Board;
    import chess.ChessPiece;
    import chess.Color;

    public class King extends ChessPiece {

        public King(Board board, Color color) {
            super(board, color);
            // TODO Auto-generated constructor stub
        }
        
        @Override
        public String toString() {
            return "K";
        }

        @Override
        public boolean[][] possibleMoves() {
            boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
            return mat;
        }
    }

- Para a Torre

    package chess.pieces;

    import boardgame.Board;
    import chess.ChessPiece;
    import chess.Color;

    public class Rook extends ChessPiece {

        public Rook(Board board, Color color) {
            super(board, color);
            // TODO Auto-generated constructor stub
        }

        @Override
        public String toString() {
            return "R";
        }
        
        @Override
        public boolean[][] possibleMoves() {
            boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
            return mat;
        }
    }

Agora, vamos ter que realizar a atualização pelo método validateSourcePosition na classe ChessMatch. No caso, vamos ter que colocar o seguinte

    package chess;

    import boardgame.Board;
    import boardgame.Piece;
    import boardgame.Position;
    import chess.pieces.King;
    import chess.pieces.Rook;

    public class ChessMatch {

        private Board board;
        
        public ChessMatch() {
            board = new Board(8, 8);
            initialSetup();
        }
        
        public ChessPiece[][] getPieces() {
            ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
            for (int i=0; i < board.getRows(); i++) {
                for (int j=0; j < board.getColumns(); j++) {
                    mat[i][j] = (ChessPiece) board.piece(i, j);
                }
            }
            return mat;
        }
        
        public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
            Position source = sourcePosition.toPosition();
            Position target = targetPosition.toPosition();
            validateSourcePosition(source);
            Piece capturedPiece = makeMove(source, target);
            return (ChessPiece) capturedPiece;
        }
        
        private Piece makeMove(Position source, Position target) {
            Piece p = board.removePiece(source);
            Piece capturedPiece = board.removePiece(target);
            board.placePiece(p, target);
            return capturedPiece;
        }
        
        private void validateSourcePosition(Position position) {
            if (!board.thereIsAPiece(position)) {
                throw new ChessException("There is no piece on source position");
            }
            if (!board.piece(position).isThereAnyPossibleMove()) {
                throw new ChessException("There is no possible moves for the chosen piece");
            }
        }
        
        private void placeNewPiece(char column, int row, ChessPiece piece) {
            board.placePiece(piece, new ChessPosition(column, row).toPosition());
        }
        
        private void initialSetup() {
            placeNewPiece('c', 1, new Rook(board, Color.WHITE));
            placeNewPiece('c', 2, new Rook(board, Color.WHITE));
            placeNewPiece('d', 2, new Rook(board, Color.WHITE));
            placeNewPiece('e', 2, new Rook(board, Color.WHITE));
            placeNewPiece('e', 1, new Rook(board, Color.WHITE));
            placeNewPiece('d', 1, new King(board, Color.WHITE));

            placeNewPiece('c', 7, new Rook(board, Color.BLACK));
            placeNewPiece('c', 8, new Rook(board, Color.BLACK));
            placeNewPiece('d', 7, new Rook(board, Color.BLACK));
            placeNewPiece('e', 7, new Rook(board, Color.BLACK));
            placeNewPiece('e', 8, new Rook(board, Color.BLACK));
            placeNewPiece('d', 8, new King(board, Color.BLACK));
        }
    }

Agora, vamos rodar o programa para ver se ela está funcionando muito bem.

Por hora, para todas as peças, estamos condicionando de que ele não tem nenhum outro movimento possível. Logo, não será nem um pouco estranho se realizarmos algum movimento, que mesmo válido, aparecer a msg de que não será possível tal movimento, pois ainda será necessário implementar a lógica de como cada peça ela pode se mexer.

## Aula 14 - Implementando movimentos possíveis da Torre:
Vamos implementar a lógica de movimento da Torre.

Vamos implementar os seguintes métodos

- IsThereOpponentPiece(position) [protected] na classe ChessPiece

- PossibleMoves na classe Rook

- ValidateTargetPosition na classe ChessMatch

Os conceitos de orientação à objetos que vamos usar serão os seguintes

- Polymorphism

- Encapsulation / access modifiers [protected]

- Exceptions

Bom, vamos começar pela classe ChessPiece e iremos implementar o método isThereOpponentPiece

    package chess;

    import boardgame.Board;
    import boardgame.Piece;
    import boardgame.Position;

    public abstract class ChessPiece extends Piece {

        private Color color;

        public ChessPiece(Board board, Color color) {
            super(board);
            this.color = color;
        }

        public Color getColor() {
            return color;
        }
        
        protected boolean isThereOpponentPiece(Position position) {
            ChessPiece p = (ChessPiece) getBoard().piece(position);
            return p != null && p.getColor() != color;
        }
    }

Agora, na classe Position.java vamos precisar colocar setValues para depois usarmos na classe Torre

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
        
        public void setValues(int row, int column) {
            this.row = row;
            this.column = column;
        }
        
        @Override
        public String toString() {
            return row + ", " +column;
        }
    }

Agora, vamos implementar movimentos possíveis da Torre. Então, coloquemos o seguinte, na classe Torre

    package chess.pieces;

    import boardgame.Board;
    import boardgame.Position;
    import chess.ChessPiece;
    import chess.Color;

    public class Rook extends ChessPiece {

        public Rook(Board board, Color color) {
            super(board, color);
            // TODO Auto-generated constructor stub
        }

        @Override
        public String toString() {
            return "R";
        }
        
        @Override
        public boolean[][] possibleMoves() {
            boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
            
            Position p = new Position(0, 0);
            
            // above
            p.setValues(position.getRow() - 1, position.getColumn());
            while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
                p.setRow(p.getRow() - 1);
            }
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            
            // left
            p.setValues(position.getRow(), position.getColumn() - 1);
            while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
                p.setColumn(p.getColumn() - 1);
            }
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            
            // Right
            p.setValues(position.getRow(), position.getColumn() + 1);
            while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
                p.setColumn(p.getColumn() + 1);
            }
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            
            // below
            p.setValues(position.getRow() + 1, position.getColumn());
            while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
                p.setRow(p.getRow() + 1);
            }
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            
            return mat;
        }
    }

Agora, falta criarmos na classe ChessMatch o método validateTargetPosition que servirá se estamos fazendo certo ou não as posições possíveis de uma peça

    package chess;

    import boardgame.Board;
    import boardgame.Piece;
    import boardgame.Position;
    import chess.pieces.King;
    import chess.pieces.Rook;

    public class ChessMatch {

        private Board board;
        
        public ChessMatch() {
            board = new Board(8, 8);
            initialSetup();
        }
        
        public ChessPiece[][] getPieces() {
            ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
            for (int i=0; i < board.getRows(); i++) {
                for (int j=0; j < board.getColumns(); j++) {
                    mat[i][j] = (ChessPiece) board.piece(i, j);
                }
            }
            return mat;
        }
        
        public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
            Position source = sourcePosition.toPosition();
            Position target = targetPosition.toPosition();
            validateSourcePosition(source);
            validateTargetPosition(source, target);
            Piece capturedPiece = makeMove(source, target);
            return (ChessPiece) capturedPiece;
        }
        
        private Piece makeMove(Position source, Position target) {
            Piece p = board.removePiece(source);
            Piece capturedPiece = board.removePiece(target);
            board.placePiece(p, target);
            return capturedPiece;
        }
        
        private void validateSourcePosition(Position position) {
            if (!board.thereIsAPiece(position)) {
                throw new ChessException("There is no piece on source position");
            }
            if (!board.piece(position).isThereAnyPossibleMove()) {
                throw new ChessException("There is no possible moves for the chosen piece");
            }
        }
        
        private void validateTargetPosition(Position source, Position target) {
            if (!board.piece(source).possibleMove(target)) {
                throw new ChessException("The chosen piece can't move to target position");
            }
        }
        
        private void placeNewPiece(char column, int row, ChessPiece piece) {
            board.placePiece(piece, new ChessPosition(column, row).toPosition());
        }
        
        private void initialSetup() {
            placeNewPiece('c', 1, new Rook(board, Color.WHITE));
            placeNewPiece('c', 2, new Rook(board, Color.WHITE));
            placeNewPiece('d', 2, new Rook(board, Color.WHITE));
            placeNewPiece('e', 2, new Rook(board, Color.WHITE));
            placeNewPiece('e', 1, new Rook(board, Color.WHITE));
            placeNewPiece('d', 1, new King(board, Color.WHITE));

            placeNewPiece('c', 7, new Rook(board, Color.BLACK));
            placeNewPiece('c', 8, new Rook(board, Color.BLACK));
            placeNewPiece('d', 7, new Rook(board, Color.BLACK));
            placeNewPiece('e', 7, new Rook(board, Color.BLACK));
            placeNewPiece('e', 8, new Rook(board, Color.BLACK));
            placeNewPiece('d', 8, new King(board, Color.BLACK));
        }
    }

Agora, vamos testar a nossa aplicação rodando-a.

## Aula 15 - Imprimindo os movimentos possíveis:
Agora, vamos aprender a imprimir os movimentos possíveis de uma peça. Ou seja, quando escolhermos alguma peça que queremos mover, vamos saber quais áreas ele tem de disponíveis para se mover.

Os métodos que vamos colocar serão o seguintes

- PossibleMoves na classe ChessMatch

- PrintBoard na classe UI

Refatorar a lógica de programação principal.

Conceitos de Orientação à objetos que vamos utilizar será

- Overloading

Começando na classe ChessMatch, vamos criar o método possibleMoves

    package chess;

    import boardgame.Board;
    import boardgame.Piece;
    import boardgame.Position;
    import chess.pieces.King;
    import chess.pieces.Rook;

    public class ChessMatch {

        private Board board;
        
        public ChessMatch() {
            board = new Board(8, 8);
            initialSetup();
        }
        
        public ChessPiece[][] getPieces() {
            ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
            for (int i=0; i < board.getRows(); i++) {
                for (int j=0; j < board.getColumns(); j++) {
                    mat[i][j] = (ChessPiece) board.piece(i, j);
                }
            }
            return mat;
        }
        
        public boolean[][] possibleMoves(ChessPosition sourcePosition) {
            Position position = sourcePosition.toPosition();
            validateSourcePosition(position);
            return board.piece(position).possibleMoves();
        }
        
        public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
            Position source = sourcePosition.toPosition();
            Position target = targetPosition.toPosition();
            validateSourcePosition(source);
            validateTargetPosition(source, target);
            Piece capturedPiece = makeMove(source, target);
            return (ChessPiece) capturedPiece;
        }
        
        private Piece makeMove(Position source, Position target) {
            Piece p = board.removePiece(source);
            Piece capturedPiece = board.removePiece(target);
            board.placePiece(p, target);
            return capturedPiece;
        }
        
        private void validateSourcePosition(Position position) {
            if (!board.thereIsAPiece(position)) {
                throw new ChessException("There is no piece on source position");
            }
            if (!board.piece(position).isThereAnyPossibleMove()) {
                throw new ChessException("There is no possible moves for the chosen piece");
            }
        }
        
        private void validateTargetPosition(Position source, Position target) {
            if (!board.piece(source).possibleMove(target)) {
                throw new ChessException("The chosen piece can't move to target position");
            }
        }
        
        private void placeNewPiece(char column, int row, ChessPiece piece) {
            board.placePiece(piece, new ChessPosition(column, row).toPosition());
        }
        
        private void initialSetup() {
            placeNewPiece('c', 1, new Rook(board, Color.WHITE));
            placeNewPiece('c', 2, new Rook(board, Color.WHITE));
            placeNewPiece('d', 2, new Rook(board, Color.WHITE));
            placeNewPiece('e', 2, new Rook(board, Color.WHITE));
            placeNewPiece('e', 1, new Rook(board, Color.WHITE));
            placeNewPiece('d', 1, new King(board, Color.WHITE));

            placeNewPiece('c', 7, new Rook(board, Color.BLACK));
            placeNewPiece('c', 8, new Rook(board, Color.BLACK));
            placeNewPiece('d', 7, new Rook(board, Color.BLACK));
            placeNewPiece('e', 7, new Rook(board, Color.BLACK));
            placeNewPiece('e', 8, new Rook(board, Color.BLACK));
            placeNewPiece('d', 8, new King(board, Color.BLACK));
        }
    }

Agora, na aplicação, no arquivo Program.java, vamos implementar a seguinte lógica

    package application;

    import java.util.InputMismatchException;
    import java.util.Scanner;

    import chess.ChessException;
    import chess.ChessMatch;
    import chess.ChessPiece;
    import chess.ChessPosition;

    public class Program {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            
            Scanner sc = new Scanner(System.in);
            ChessMatch chessMatch = new ChessMatch();
            
            while (true) {
                try {
                    UI.clearScreen();
                    UI.printBoard(chessMatch.getPieces());
                    System.out.println();
                    System.out.print("Source: ");
                    ChessPosition source = UI.readChessPosition(sc);
                    
                    boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                    UI.clearScreen();
                    UI.printBoard(chessMatch.getPieces(), possibleMoves);
                    
                    System.out.println();
                    System.out.print("Target: ");
                    ChessPosition target = UI.readChessPosition(sc);
                    
                    ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
                }
                catch (ChessException e ) {
                    System.out.println(e.getMessage());
                    sc.nextLine();
                }
                catch (InputMismatchException e ) {
                    System.out.println(e.getMessage());
                    sc.nextLine();
                }
            }

        }

    }

Agora, na classe UI vamos fazer uma sobreposição do método PrintBoard da seguinte forma

    package application;

    import java.util.InputMismatchException;
    import java.util.Scanner;

    import chess.ChessPiece;
    import chess.ChessPosition;
    import chess.Color;

    public class UI {
        
        // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

        public static final String ANSI_RESET = "\u001B[0m";
        public static final String ANSI_BLACK = "\u001B[30m";
        public static final String ANSI_RED = "\u001B[31m";
        public static final String ANSI_GREEN = "\u001B[32m";
        public static final String ANSI_YELLOW = "\u001B[33m";
        public static final String ANSI_BLUE = "\u001B[34m";
        public static final String ANSI_PURPLE = "\u001B[35m";
        public static final String ANSI_CYAN = "\u001B[36m";
        public static final String ANSI_WHITE = "\u001B[37m";

        public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
        public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
        public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
        public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
        public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
        public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
        public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
        public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
        
        // https://stackoverflow.com/questions/2979383/java-clear-the-console 
        public static void clearScreen() {   
            System.out.print("\033[H\033[2J");   
            System.out.flush();   
        }
        
        public static ChessPosition readChessPosition(Scanner sc) {
            try {
                String s = sc.nextLine();
                char column = s.charAt(0);
                int row = Integer.parseInt(s.substring(1));
                return new ChessPosition(column, row);
            }
            catch (RuntimeException e) {
                throw new InputMismatchException("Error reading ChessPosition. Valid values are from a1 to h8.");
            }
        }

        public static void printBoard(ChessPiece[][] pieces) {
            for (int i=0; i < pieces.length; i++) {
                System.out.print((8-i) + " ");
                for (int j=0; j < pieces.length; j++) {
                    printPiece(pieces[i][j], false);
                }
                System.out.println();
            }
            System.out.println("  a b c d e f g h");
        }
        
        public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {
            for (int i=0; i < pieces.length; i++) {
                System.out.print((8-i) + " ");
                for (int j=0; j < pieces.length; j++) {
                    printPiece(pieces[i][j], possibleMoves[i][j]);
                }
                System.out.println();
            }
            System.out.println("  a b c d e f g h");
        }
        
        private static void printPiece(ChessPiece piece, boolean background) {
            if (background) {
                System.out.print(ANSI_BLUE_BACKGROUND);
            }
            if (piece == null) {
                System.out.print("-" + ANSI_RESET);
            } else {
                if (piece.getColor() == Color.WHITE) {
                    System.out.print(ANSI_WHITE + piece + ANSI_RESET);
                }
                else {
                    System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
                }
            }
            
            System.out.print(" ");
        }
    }

Agora, vamos rodar esse projeto para verificarmos se ela está funcionando muito bem.

## Aula 16 - Implementando os movimentos possíveis do Rei:
Vamos, agora, implementar os movimentos possíveis do Rei.

Realizaremos a seguinte implementação/criação dos métodos

- CanMove na classe King [private]

- Implementação do método PossibleMoves na classe King

Conceitos de orientação à objetos que vamos usar serão os seguintes

- Encapsulation

- Polymorphism

Na classe King, vamos colocar os métodos canMove e implementar o método PossibleMoves

    package chess.pieces;

    import boardgame.Board;
    import boardgame.Position;
    import chess.ChessPiece;
    import chess.Color;

    public class King extends ChessPiece {

        public King(Board board, Color color) {
            super(board, color);
            // TODO Auto-generated constructor stub
        }
        
        @Override
        public String toString() {
            return "K";
        }
        
        private boolean canMove(Position position) {
            ChessPiece p = (ChessPiece) getBoard().piece(position);
            return p == null || p.getColor() != getColor();
        }

        @Override
        public boolean[][] possibleMoves() {
            boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
            
            Position p = new Position(0, 0);
            
            // above
            p.setValues(position.getRow() - 1, position.getColumn());
            if (getBoard().positionExists(p) && canMove(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            
            // below
            p.setValues(position.getRow() + 1, position.getColumn());
            if (getBoard().positionExists(p) && canMove(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            
            // left
            p.setValues(position.getRow(), position.getColumn() - 1);
            if (getBoard().positionExists(p) && canMove(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            
            // right
            p.setValues(position.getRow(), position.getColumn() + 1);
            if (getBoard().positionExists(p) && canMove(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            
            // nw
            p.setValues(position.getRow() - 1, position.getColumn() - 1);
            if (getBoard().positionExists(p) && canMove(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            
            // ne
            p.setValues(position.getRow() - 1, position.getColumn() + 1);
            if (getBoard().positionExists(p) && canMove(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            
            // sw
            p.setValues(position.getRow() + 1, position.getColumn() - 1);
            if (getBoard().positionExists(p) && canMove(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            
            // se
            p.setValues(position.getRow() + 1, position.getColumn() + 1);
            if (getBoard().positionExists(p) && canMove(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            
            return mat;
        }
    }

Agora, vamos testar novamente se está tudo funcionando como queremos.

## Aula 17 - Trocando de jogador a cada turno:
Vamos, agora, trocar de jogador a cada turno.

Os métodos que vamos implementar/criar são os seguintes

- Na classe ChessMatch vamos implementar/criar os seguintes métodos
    - Properties Turn, CurrentPlayer [private set]

    - Method NextTurn [private]

    - Update PerformChessMove

    - Update ValidateSourcePosition

- PrintMatch na classe UI

Conceitos de orientação à objetos que serão usados

- Encapsulation

- Exceptions

Bom, começamos na classe ChessMatch vamos realizar as implementações/criações necessárias

    package chess;

    import boardgame.Board;
    import boardgame.Piece;
    import boardgame.Position;
    import chess.pieces.King;
    import chess.pieces.Rook;

    public class ChessMatch {

        private int turn;
        private Color currentPlayer;
        private Board board;
        
        public ChessMatch() {
            board = new Board(8, 8);
            turn = 1;
            currentPlayer = Color.WHITE;
            initialSetup();
        }
        
        public int getTurn() {
            return turn;
        }
        
        public Color getCurrentPlayer() {
            return currentPlayer;
        }
        
        public ChessPiece[][] getPieces() {
            ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
            for (int i=0; i < board.getRows(); i++) {
                for (int j=0; j < board.getColumns(); j++) {
                    mat[i][j] = (ChessPiece) board.piece(i, j);
                }
            }
            return mat;
        }
        
        public boolean[][] possibleMoves(ChessPosition sourcePosition) {
            Position position = sourcePosition.toPosition();
            validateSourcePosition(position);
            return board.piece(position).possibleMoves();
        }
        
        public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
            Position source = sourcePosition.toPosition();
            Position target = targetPosition.toPosition();
            validateSourcePosition(source);
            validateTargetPosition(source, target);
            Piece capturedPiece = makeMove(source, target);
            nextTurn();
            return (ChessPiece) capturedPiece;
        }
        
        private Piece makeMove(Position source, Position target) {
            Piece p = board.removePiece(source);
            Piece capturedPiece = board.removePiece(target);
            board.placePiece(p, target);
            return capturedPiece;
        }
        
        private void validateSourcePosition(Position position) {
            if (!board.thereIsAPiece(position)) {
                throw new ChessException("There is no piece on source position");
            }
            if (currentPlayer != ((ChessPiece)board.piece(position)).getColor()) {
                throw new ChessException("The chosen piece is not yours");
            }
            if (!board.piece(position).isThereAnyPossibleMove()) {
                throw new ChessException("There is no possible moves for the chosen piece");
            }
        }
        
        private void validateTargetPosition(Position source, Position target) {
            if (!board.piece(source).possibleMove(target)) {
                throw new ChessException("The chosen piece can't move to target position");
            }
        }
        
        private void nextTurn() {
            turn++;
            currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
        }
        
        private void placeNewPiece(char column, int row, ChessPiece piece) {
            board.placePiece(piece, new ChessPosition(column, row).toPosition());
        }
        
        private void initialSetup() {
            placeNewPiece('c', 1, new Rook(board, Color.WHITE));
            placeNewPiece('c', 2, new Rook(board, Color.WHITE));
            placeNewPiece('d', 2, new Rook(board, Color.WHITE));
            placeNewPiece('e', 2, new Rook(board, Color.WHITE));
            placeNewPiece('e', 1, new Rook(board, Color.WHITE));
            placeNewPiece('d', 1, new King(board, Color.WHITE));

            placeNewPiece('c', 7, new Rook(board, Color.BLACK));
            placeNewPiece('c', 8, new Rook(board, Color.BLACK));
            placeNewPiece('d', 7, new Rook(board, Color.BLACK));
            placeNewPiece('e', 7, new Rook(board, Color.BLACK));
            placeNewPiece('e', 8, new Rook(board, Color.BLACK));
            placeNewPiece('d', 8, new King(board, Color.BLACK));
        }
    }

Agora, na classe UI, vamos criar o método que exibe qual será o jogador que deve fazer a jogada

    package application;

    import java.util.InputMismatchException;
    import java.util.Scanner;

    import chess.ChessMatch;
    import chess.ChessPiece;
    import chess.ChessPosition;
    import chess.Color;

    public class UI {
        
        // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

        public static final String ANSI_RESET = "\u001B[0m";
        public static final String ANSI_BLACK = "\u001B[30m";
        public static final String ANSI_RED = "\u001B[31m";
        public static final String ANSI_GREEN = "\u001B[32m";
        public static final String ANSI_YELLOW = "\u001B[33m";
        public static final String ANSI_BLUE = "\u001B[34m";
        public static final String ANSI_PURPLE = "\u001B[35m";
        public static final String ANSI_CYAN = "\u001B[36m";
        public static final String ANSI_WHITE = "\u001B[37m";

        public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
        public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
        public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
        public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
        public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
        public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
        public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
        public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
        
        // https://stackoverflow.com/questions/2979383/java-clear-the-console 
        public static void clearScreen() {   
            System.out.print("\033[H\033[2J");   
            System.out.flush();   
        }
        
        public static ChessPosition readChessPosition(Scanner sc) {
            try {
                String s = sc.nextLine();
                char column = s.charAt(0);
                int row = Integer.parseInt(s.substring(1));
                return new ChessPosition(column, row);
            }
            catch (RuntimeException e) {
                throw new InputMismatchException("Error reading ChessPosition. Valid values are from a1 to h8.");
            }
        }
        
        public static void printMatch(ChessMatch chessMatch) {
            printBoard(chessMatch.getPieces());
            System.out.println();
            System.out.println("Turn : " + chessMatch.getTurn());
            System.out.println("Waiting player: " + chessMatch.getCurrentPlayer());
        }

        public static void printBoard(ChessPiece[][] pieces) {
            for (int i=0; i < pieces.length; i++) {
                System.out.print((8-i) + " ");
                for (int j=0; j < pieces.length; j++) {
                    printPiece(pieces[i][j], false);
                }
                System.out.println();
            }
            System.out.println("  a b c d e f g h");
        }
        
        public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {
            for (int i=0; i < pieces.length; i++) {
                System.out.print((8-i) + " ");
                for (int j=0; j < pieces.length; j++) {
                    printPiece(pieces[i][j], possibleMoves[i][j]);
                }
                System.out.println();
            }
            System.out.println("  a b c d e f g h");
        }
        
        private static void printPiece(ChessPiece piece, boolean background) {
            if (background) {
                System.out.print(ANSI_BLUE_BACKGROUND);
            }
            if (piece == null) {
                System.out.print("-" + ANSI_RESET);
            } else {
                if (piece.getColor() == Color.WHITE) {
                    System.out.print(ANSI_WHITE + piece + ANSI_RESET);
                }
                else {
                    System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
                }
            }
            
            System.out.print(" ");
        }
    }

Agora, vamos realizar a aplicação disso. No caso, no arquivo Program.java vamos realizar o seguinte

    package application;

    import java.util.InputMismatchException;
    import java.util.Scanner;

    import chess.ChessException;
    import chess.ChessMatch;
    import chess.ChessPiece;
    import chess.ChessPosition;

    public class Program {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            
            Scanner sc = new Scanner(System.in);
            ChessMatch chessMatch = new ChessMatch();
            
            while (true) {
                try {
                    UI.clearScreen();
                    UI.printMatch(chessMatch);
                    System.out.println();
                    System.out.print("Source: ");
                    ChessPosition source = UI.readChessPosition(sc);
                    
                    boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                    UI.clearScreen();
                    UI.printBoard(chessMatch.getPieces(), possibleMoves);
                    
                    System.out.println();
                    System.out.print("Target: ");
                    ChessPosition target = UI.readChessPosition(sc);
                    
                    ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
                }
                catch (ChessException e ) {
                    System.out.println(e.getMessage());
                    sc.nextLine();
                }
                catch (InputMismatchException e ) {
                    System.out.println(e.getMessage());
                    sc.nextLine();
                }
            }

        }

    }

Agora, vamos rodar o programa para ver se as alterações que fizemos estão correspondendo o que queremos.

## Aula 18 - Manipulando peças capturadas:
Vamos realizar a manipulação das peças capturadas.

Os métodos que vamos implementar/criar são

- PrintCapturePieces na classe UI

- PrintMatch na classe UI

- Criação de uma lista em ChessMatch: _piecesOnTheBoard, _capturedPiece
    - Update Constructor

    - Update PlaceNewPiece

    - Update MakeMove

Vamos melhorar a lógica de programação das atualizações.

Conceitos de Orientação à objetos que vamos usar

- Encapsulation

- Constructors

Conceitos de Estrutura de Dados que vamos usar

- Lista

Vamos, agora, na classe UI para realizar as implementações/criações que mencionamos acima

    package application;

    import java.util.Arrays;
    import java.util.InputMismatchException;
    import java.util.List;
    import java.util.Scanner;
    import java.util.stream.Collectors;

    import chess.ChessMatch;
    import chess.ChessPiece;
    import chess.ChessPosition;
    import chess.Color;

    public class UI {
        
        // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

        public static final String ANSI_RESET = "\u001B[0m";
        public static final String ANSI_BLACK = "\u001B[30m";
        public static final String ANSI_RED = "\u001B[31m";
        public static final String ANSI_GREEN = "\u001B[32m";
        public static final String ANSI_YELLOW = "\u001B[33m";
        public static final String ANSI_BLUE = "\u001B[34m";
        public static final String ANSI_PURPLE = "\u001B[35m";
        public static final String ANSI_CYAN = "\u001B[36m";
        public static final String ANSI_WHITE = "\u001B[37m";

        public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
        public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
        public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
        public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
        public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
        public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
        public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
        public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
        
        // https://stackoverflow.com/questions/2979383/java-clear-the-console 
        public static void clearScreen() {   
            System.out.print("\033[H\033[2J");   
            System.out.flush();   
        }
        
        public static ChessPosition readChessPosition(Scanner sc) {
            try {
                String s = sc.nextLine();
                char column = s.charAt(0);
                int row = Integer.parseInt(s.substring(1));
                return new ChessPosition(column, row);
            }
            catch (RuntimeException e) {
                throw new InputMismatchException("Error reading ChessPosition. Valid values are from a1 to h8.");
            }
        }
        
        public static void printMatch(ChessMatch chessMatch) {
            printBoard(chessMatch.getPieces());
            System.out.println();
            System.out.println("Turn : " + chessMatch.getTurn());
            System.out.println("Waiting player: " + chessMatch.getCurrentPlayer());
        }

        public static void printBoard(ChessPiece[][] pieces) {
            for (int i=0; i < pieces.length; i++) {
                System.out.print((8-i) + " ");
                for (int j=0; j < pieces.length; j++) {
                    printPiece(pieces[i][j], false);
                }
                System.out.println();
            }
            System.out.println("  a b c d e f g h");
        }
        
        public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {
            for (int i=0; i < pieces.length; i++) {
                System.out.print((8-i) + " ");
                for (int j=0; j < pieces.length; j++) {
                    printPiece(pieces[i][j], possibleMoves[i][j]);
                }
                System.out.println();
            }
            System.out.println("  a b c d e f g h");
        }
        
        private static void printPiece(ChessPiece piece, boolean background) {
            if (background) {
                System.out.print(ANSI_BLUE_BACKGROUND);
            }
            if (piece == null) {
                System.out.print("-" + ANSI_RESET);
            } else {
                if (piece.getColor() == Color.WHITE) {
                    System.out.print(ANSI_WHITE + piece + ANSI_RESET);
                }
                else {
                    System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
                }
            }
            
            System.out.print(" ");
        }
        
        public static void printCapturedPieces(List<ChessPiece> captured) {
            List<ChessPiece> white = captured.stream().filter(x -> x.getColor() == Color.WHITE).collect(Collectors.toList());
            List<ChessPiece> black = captured.stream().filter(x -> x.getColor() == Color.BLACK).collect(Collectors.toList());
            System.out.println("Captured pieces:");
            System.out.print("White: ");
            System.out.print(ANSI_WHITE);
            System.out.println(Arrays.toString(white.toArray()));
            System.out.print(ANSI_RESET);
            System.out.print("Black: ");
            System.out.print(ANSI_YELLOW);
            System.out.println(Arrays.toString(black.toArray()));
            System.out.print(ANSI_RESET);
        }
    }

Agora, na aplicação, Program.java, vamos realizar o seguinte, pois precisamos criar essa lista captured do método printCapturedPieces da classe UI

    package application;

    import java.util.ArrayList;
    import java.util.InputMismatchException;
    import java.util.List;
    import java.util.Scanner;

    import chess.ChessException;
    import chess.ChessMatch;
    import chess.ChessPiece;
    import chess.ChessPosition;

    public class Program {

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            
            Scanner sc = new Scanner(System.in);
            ChessMatch chessMatch = new ChessMatch();
            List<ChessPiece> captured = new ArrayList<>();
            
            while (true) {
                try {
                    UI.clearScreen();
                    UI.printMatch(chessMatch, captured);
                    System.out.println();
                    System.out.print("Source: ");
                    ChessPosition source = UI.readChessPosition(sc);
                    
                    boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                    UI.clearScreen();
                    UI.printBoard(chessMatch.getPieces(), possibleMoves);
                    
                    System.out.println();
                    System.out.print("Target: ");
                    ChessPosition target = UI.readChessPosition(sc);
                    
                    ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
                    
                    if (capturedPiece != null) {
                        captured.add(capturedPiece);
                    }
                }
                catch (ChessException e ) {
                    System.out.println(e.getMessage());
                    sc.nextLine();
                }
                catch (InputMismatchException e ) {
                    System.out.println(e.getMessage());
                    sc.nextLine();
                }
            }

        }

    }

Agora, vamos ter que melhorar o printMatch da classe UI

    package application;

    import java.util.Arrays;
    import java.util.InputMismatchException;
    import java.util.List;
    import java.util.Scanner;
    import java.util.stream.Collectors;

    import chess.ChessMatch;
    import chess.ChessPiece;
    import chess.ChessPosition;
    import chess.Color;

    public class UI {
        
        // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

        public static final String ANSI_RESET = "\u001B[0m";
        public static final String ANSI_BLACK = "\u001B[30m";
        public static final String ANSI_RED = "\u001B[31m";
        public static final String ANSI_GREEN = "\u001B[32m";
        public static final String ANSI_YELLOW = "\u001B[33m";
        public static final String ANSI_BLUE = "\u001B[34m";
        public static final String ANSI_PURPLE = "\u001B[35m";
        public static final String ANSI_CYAN = "\u001B[36m";
        public static final String ANSI_WHITE = "\u001B[37m";

        public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
        public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
        public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
        public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
        public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
        public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
        public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
        public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
        
        // https://stackoverflow.com/questions/2979383/java-clear-the-console 
        public static void clearScreen() {   
            System.out.print("\033[H\033[2J");   
            System.out.flush();   
        }
        
        public static ChessPosition readChessPosition(Scanner sc) {
            try {
                String s = sc.nextLine();
                char column = s.charAt(0);
                int row = Integer.parseInt(s.substring(1));
                return new ChessPosition(column, row);
            }
            catch (RuntimeException e) {
                throw new InputMismatchException("Error reading ChessPosition. Valid values are from a1 to h8.");
            }
        }
        
        public static void printMatch(ChessMatch chessMatch, List<ChessPiece> captured) {
            printBoard(chessMatch.getPieces());
            System.out.println();
            printCapturedPieces(captured);
            System.out.println();
            System.out.println("Turn : " + chessMatch.getTurn());
            System.out.println("Waiting player: " + chessMatch.getCurrentPlayer());
        }

        public static void printBoard(ChessPiece[][] pieces) {
            for (int i=0; i < pieces.length; i++) {
                System.out.print((8-i) + " ");
                for (int j=0; j < pieces.length; j++) {
                    printPiece(pieces[i][j], false);
                }
                System.out.println();
            }
            System.out.println("  a b c d e f g h");
        }
        
        public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {
            for (int i=0; i < pieces.length; i++) {
                System.out.print((8-i) + " ");
                for (int j=0; j < pieces.length; j++) {
                    printPiece(pieces[i][j], possibleMoves[i][j]);
                }
                System.out.println();
            }
            System.out.println("  a b c d e f g h");
        }
        
        private static void printPiece(ChessPiece piece, boolean background) {
            if (background) {
                System.out.print(ANSI_BLUE_BACKGROUND);
            }
            if (piece == null) {
                System.out.print("-" + ANSI_RESET);
            } else {
                if (piece.getColor() == Color.WHITE) {
                    System.out.print(ANSI_WHITE + piece + ANSI_RESET);
                }
                else {
                    System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
                }
            }
            
            System.out.print(" ");
        }
        
        public static void printCapturedPieces(List<ChessPiece> captured) {
            List<ChessPiece> white = captured.stream().filter(x -> x.getColor() == Color.WHITE).collect(Collectors.toList());
            List<ChessPiece> black = captured.stream().filter(x -> x.getColor() == Color.BLACK).collect(Collectors.toList());
            System.out.println("Captured pieces:");
            System.out.print("White: ");
            System.out.print(ANSI_WHITE);
            System.out.println(Arrays.toString(white.toArray()));
            System.out.print(ANSI_RESET);
            System.out.print("Black: ");
            System.out.print(ANSI_YELLOW);
            System.out.println(Arrays.toString(black.toArray()));
            System.out.print(ANSI_RESET);
        }
    }

Agora, vamos verificar se o programa está funcionando corretamente, rodando pelo terminal. Note que, agora, é exibido uma lista vazia de peças preças e brancas que foram capturadas.

Agora, falta colocarmos algum controle de peças capturadas. No caso, na classe ChessMatch vamos realizar o seguinte

    package chess;

    import java.util.ArrayList;
    import java.util.List;

    import boardgame.Board;
    import boardgame.Piece;
    import boardgame.Position;
    import chess.pieces.King;
    import chess.pieces.Rook;

    public class ChessMatch {

        private int turn;
        private Color currentPlayer;
        private Board board;
        
        private List<Piece> piecesOnTheBoard = new ArrayList<>();
        private List<Piece> capturedPieces = new ArrayList<>();
        
        public ChessMatch() {
            board = new Board(8, 8);
            turn = 1;
            currentPlayer = Color.WHITE;
            initialSetup();
        }
        
        public int getTurn() {
            return turn;
        }
        
        public Color getCurrentPlayer() {
            return currentPlayer;
        }
        
        public ChessPiece[][] getPieces() {
            ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
            for (int i=0; i < board.getRows(); i++) {
                for (int j=0; j < board.getColumns(); j++) {
                    mat[i][j] = (ChessPiece) board.piece(i, j);
                }
            }
            return mat;
        }
        
        public boolean[][] possibleMoves(ChessPosition sourcePosition) {
            Position position = sourcePosition.toPosition();
            validateSourcePosition(position);
            return board.piece(position).possibleMoves();
        }
        
        public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
            Position source = sourcePosition.toPosition();
            Position target = targetPosition.toPosition();
            validateSourcePosition(source);
            validateTargetPosition(source, target);
            Piece capturedPiece = makeMove(source, target);
            nextTurn();
            return (ChessPiece) capturedPiece;
        }
        
        private Piece makeMove(Position source, Position target) {
            Piece p = board.removePiece(source);
            Piece capturedPiece = board.removePiece(target);
            board.placePiece(p, target);
            
            if (capturedPiece != null) {
                piecesOnTheBoard.remove(capturedPiece);
                capturedPieces.add(capturedPiece);
            }
            
            return capturedPiece;
        }
        
        private void validateSourcePosition(Position position) {
            if (!board.thereIsAPiece(position)) {
                throw new ChessException("There is no piece on source position");
            }
            if (currentPlayer != ((ChessPiece)board.piece(position)).getColor()) {
                throw new ChessException("The chosen piece is not yours");
            }
            if (!board.piece(position).isThereAnyPossibleMove()) {
                throw new ChessException("There is no possible moves for the chosen piece");
            }
        }
        
        private void validateTargetPosition(Position source, Position target) {
            if (!board.piece(source).possibleMove(target)) {
                throw new ChessException("The chosen piece can't move to target position");
            }
        }
        
        private void nextTurn() {
            turn++;
            currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
        }
        
        private void placeNewPiece(char column, int row, ChessPiece piece) {
            board.placePiece(piece, new ChessPosition(column, row).toPosition());
            piecesOnTheBoard.add(piece);
        }
        
        private void initialSetup() {
            placeNewPiece('c', 1, new Rook(board, Color.WHITE));
            placeNewPiece('c', 2, new Rook(board, Color.WHITE));
            placeNewPiece('d', 2, new Rook(board, Color.WHITE));
            placeNewPiece('e', 2, new Rook(board, Color.WHITE));
            placeNewPiece('e', 1, new Rook(board, Color.WHITE));
            placeNewPiece('d', 1, new King(board, Color.WHITE));

            placeNewPiece('c', 7, new Rook(board, Color.BLACK));
            placeNewPiece('c', 8, new Rook(board, Color.BLACK));
            placeNewPiece('d', 7, new Rook(board, Color.BLACK));
            placeNewPiece('e', 7, new Rook(board, Color.BLACK));
            placeNewPiece('e', 8, new Rook(board, Color.BLACK));
            placeNewPiece('d', 8, new King(board, Color.BLACK));
        }
    }

Agora, vamos testar se estamos conseguindo capturar direito ou não as peças.

## Aula 19 e 20 - Lógica de xeque - PARTE 1 e 2:
Vamos implementar a lógica de Xeque, que é quando o Rei está sob ameaça. Vale lembrar que vc não pode se colocar em xeque tbm.

Métodos que serão implementado/criado/refatorado

- ChessPosition na classe ChessPiece, property [get]

- Na classe ChessMatch:
    - Method UndoMove

    - Property Check [private set]

    - Method Opponent [private]

    - Method King(color) [private]

    - Method TestCheck

    - Update PerformChessMove

- Update PrintMatch na classe UI.

Vamos começar pela classe ChessPiece, criaremos o getChessPosition

    package chess;

    import boardgame.Board;
    import boardgame.Piece;
    import boardgame.Position;

    public abstract class ChessPiece extends Piece {

        private Color color;

        public ChessPiece(Board board, Color color) {
            super(board);
            this.color = color;
        }

        public Color getColor() {
            return color;
        }
        
        public ChessPosition getChessPosition() {
            return ChessPosition.fromPosition(position);
        }
        
        protected boolean isThereOpponentPiece(Position position) {
            ChessPiece p = (ChessPiece) getBoard().piece(position);
            return p != null && p.getColor() != color;
        }
    }

Agora, na classe ChessMatch, vamos realizar as tarefas que foi listada acima

    package chess;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.stream.Collectors;

    import boardgame.Board;
    import boardgame.Piece;
    import boardgame.Position;
    import chess.pieces.King;
    import chess.pieces.Rook;

    public class ChessMatch {

        private int turn;
        private Color currentPlayer;
        private Board board;
        private boolean check;
        
        private List<Piece> piecesOnTheBoard = new ArrayList<>();
        private List<Piece> capturedPieces = new ArrayList<>();
        
        public ChessMatch() {
            board = new Board(8, 8);
            turn = 1;
            currentPlayer = Color.WHITE;
            // Se vai colocar check como false é opcional, pois o programa
            // não definido nada de valor para check, ele, por padrão, define como false
            //check = false;
            initialSetup();
        }
        
        public int getTurn() {
            return turn;
        }
        
        public Color getCurrentPlayer() {
            return currentPlayer;
        }
        
        public boolean getCheck() {
            return check;
        }
        
        public ChessPiece[][] getPieces() {
            ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
            for (int i=0; i < board.getRows(); i++) {
                for (int j=0; j < board.getColumns(); j++) {
                    mat[i][j] = (ChessPiece) board.piece(i, j);
                }
            }
            return mat;
        }
        
        public boolean[][] possibleMoves(ChessPosition sourcePosition) {
            Position position = sourcePosition.toPosition();
            validateSourcePosition(position);
            return board.piece(position).possibleMoves();
        }
        
        public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
            Position source = sourcePosition.toPosition();
            Position target = targetPosition.toPosition();
            validateSourcePosition(source);
            validateTargetPosition(source, target);
            Piece capturedPiece = makeMove(source, target);
            
            if(testCheck(currentPlayer)) {
                undoMove(source, target, capturedPiece);
                throw new ChessException("You can't put yourself in check");
            }
            
            check = (testCheck(opponent(currentPlayer))) ? true : false;
            
            nextTurn();
            return (ChessPiece) capturedPiece;
        }
        
        private Piece makeMove(Position source, Position target) {
            Piece p = board.removePiece(source);
            Piece capturedPiece = board.removePiece(target);
            board.placePiece(p, target);
            
            if (capturedPiece != null) {
                piecesOnTheBoard.remove(capturedPiece);
                capturedPieces.add(capturedPiece);
            }
            
            return capturedPiece;
        }
        
        private void undoMove(Position source, Position target, Piece capturedPiece) {
            Piece p = board.removePiece(target);
            board.placePiece(p, source);
            
            if (capturedPiece != null) {
                board.placePiece(capturedPiece, target);
                capturedPieces.remove(capturedPiece);
                piecesOnTheBoard.add(capturedPiece);
            }
        }
        
        private void validateSourcePosition(Position position) {
            if (!board.thereIsAPiece(position)) {
                throw new ChessException("There is no piece on source position");
            }
            if (currentPlayer != ((ChessPiece)board.piece(position)).getColor()) {
                throw new ChessException("The chosen piece is not yours");
            }
            if (!board.piece(position).isThereAnyPossibleMove()) {
                throw new ChessException("There is no possible moves for the chosen piece");
            }
        }
        
        private void validateTargetPosition(Position source, Position target) {
            if (!board.piece(source).possibleMove(target)) {
                throw new ChessException("The chosen piece can't move to target position");
            }
        }
        
        private void nextTurn() {
            turn++;
            currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
        }
        
        private Color opponent(Color color) {
            return (color == Color.WHITE) ? Color.BLACK : Color.WHITE;
        }
        
        private ChessPiece king(Color color) {
            List<Piece> list = piecesOnTheBoard.stream().filter(x -> ((ChessPiece)x).getColor() == color).collect(Collectors.toList());
            for (Piece p : list) {
                if (p instanceof King) {
                    return (ChessPiece)p;
                }
            }
            throw new IllegalStateException("There is no " + color + " king on the board");
        }
        
        private boolean testCheck(Color color) {
            Position kingPosition = king(color).getChessPosition().toPosition();
            List<Piece> opponentPieces = piecesOnTheBoard.stream().filter(x -> ((ChessPiece)x).getColor() == opponent(color)).collect(Collectors.toList());
            for (Piece p : opponentPieces) {
                boolean[][] mat = p.possibleMoves();
                if (mat[kingPosition.getRow()][kingPosition.getColumn()]) {
                    return true;
                }
            }
            return false;
        }
        
        private void placeNewPiece(char column, int row, ChessPiece piece) {
            board.placePiece(piece, new ChessPosition(column, row).toPosition());
            piecesOnTheBoard.add(piece);
        }
        
        private void initialSetup() {
            placeNewPiece('c', 1, new Rook(board, Color.WHITE));
            placeNewPiece('c', 2, new Rook(board, Color.WHITE));
            placeNewPiece('d', 2, new Rook(board, Color.WHITE));
            placeNewPiece('e', 2, new Rook(board, Color.WHITE));
            placeNewPiece('e', 1, new Rook(board, Color.WHITE));
            placeNewPiece('d', 1, new King(board, Color.WHITE));

            placeNewPiece('c', 7, new Rook(board, Color.BLACK));
            placeNewPiece('c', 8, new Rook(board, Color.BLACK));
            placeNewPiece('d', 7, new Rook(board, Color.BLACK));
            placeNewPiece('e', 7, new Rook(board, Color.BLACK));
            placeNewPiece('e', 8, new Rook(board, Color.BLACK));
            placeNewPiece('d', 8, new King(board, Color.BLACK));
        }
    }

Agora, falta refatorar o método printMatch da classe UI

    package application;

    import java.util.Arrays;
    import java.util.InputMismatchException;
    import java.util.List;
    import java.util.Scanner;
    import java.util.stream.Collectors;

    import chess.ChessMatch;
    import chess.ChessPiece;
    import chess.ChessPosition;
    import chess.Color;

    public class UI {
        
        // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

        public static final String ANSI_RESET = "\u001B[0m";
        public static final String ANSI_BLACK = "\u001B[30m";
        public static final String ANSI_RED = "\u001B[31m";
        public static final String ANSI_GREEN = "\u001B[32m";
        public static final String ANSI_YELLOW = "\u001B[33m";
        public static final String ANSI_BLUE = "\u001B[34m";
        public static final String ANSI_PURPLE = "\u001B[35m";
        public static final String ANSI_CYAN = "\u001B[36m";
        public static final String ANSI_WHITE = "\u001B[37m";

        public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
        public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
        public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
        public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
        public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
        public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
        public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
        public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
        
        // https://stackoverflow.com/questions/2979383/java-clear-the-console 
        public static void clearScreen() {   
            System.out.print("\033[H\033[2J");   
            System.out.flush();   
        }
        
        public static ChessPosition readChessPosition(Scanner sc) {
            try {
                String s = sc.nextLine();
                char column = s.charAt(0);
                int row = Integer.parseInt(s.substring(1));
                return new ChessPosition(column, row);
            }
            catch (RuntimeException e) {
                throw new InputMismatchException("Error reading ChessPosition. Valid values are from a1 to h8.");
            }
        }
        
        public static void printMatch(ChessMatch chessMatch, List<ChessPiece> captured) {
            printBoard(chessMatch.getPieces());
            System.out.println();
            printCapturedPieces(captured);
            System.out.println();
            System.out.println("Turn : " + chessMatch.getTurn());
            System.out.println("Waiting player: " + chessMatch.getCurrentPlayer());
            if (chessMatch.getCheck()) {
                System.out.println("CHECK!");
            }
        }

        public static void printBoard(ChessPiece[][] pieces) {
            for (int i=0; i < pieces.length; i++) {
                System.out.print((8-i) + " ");
                for (int j=0; j < pieces.length; j++) {
                    printPiece(pieces[i][j], false);
                }
                System.out.println();
            }
            System.out.println("  a b c d e f g h");
        }
        
        public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {
            for (int i=0; i < pieces.length; i++) {
                System.out.print((8-i) + " ");
                for (int j=0; j < pieces.length; j++) {
                    printPiece(pieces[i][j], possibleMoves[i][j]);
                }
                System.out.println();
            }
            System.out.println("  a b c d e f g h");
        }
        
        private static void printPiece(ChessPiece piece, boolean background) {
            if (background) {
                System.out.print(ANSI_BLUE_BACKGROUND);
            }
            if (piece == null) {
                System.out.print("-" + ANSI_RESET);
            } else {
                if (piece.getColor() == Color.WHITE) {
                    System.out.print(ANSI_WHITE + piece + ANSI_RESET);
                }
                else {
                    System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
                }
            }
            
            System.out.print(" ");
        }
        
        public static void printCapturedPieces(List<ChessPiece> captured) {
            List<ChessPiece> white = captured.stream().filter(x -> x.getColor() == Color.WHITE).collect(Collectors.toList());
            List<ChessPiece> black = captured.stream().filter(x -> x.getColor() == Color.BLACK).collect(Collectors.toList());
            System.out.println("Captured pieces:");
            System.out.print("White: ");
            System.out.print(ANSI_WHITE);
            System.out.println(Arrays.toString(white.toArray()));
            System.out.print(ANSI_RESET);
            System.out.print("Black: ");
            System.out.print(ANSI_YELLOW);
            System.out.println(Arrays.toString(black.toArray()));
            System.out.print(ANSI_RESET);
        }
    }

Feito isso, agora, vamos testar se o programa está ou não funcionando corretamente.

Bom, teve um erro que foi necessário refatorar algum método da classe ChessPosition.

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
