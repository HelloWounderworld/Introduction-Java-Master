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
