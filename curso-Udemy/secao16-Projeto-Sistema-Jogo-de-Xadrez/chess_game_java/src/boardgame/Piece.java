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
