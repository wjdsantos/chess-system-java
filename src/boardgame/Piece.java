package boardgame;

public abstract class Piece {

	protected Position position;
	
	//Associa��o
	private Board board;

	//Construtor com fields
	public Piece(Board board) {
		this.board = board;
		position = null;  //Foi colocado manualmente 'position' como nulo pq a pe�a n�o ter� posi��o inicial no tabuleiro
	}

	protected Board getBoard() {  //Foi o tirado o setBoard pq n�o queremos que o tabuleiro seja alterado por aqui
		return board;
	}
	
	public abstract boolean[][] possibleMoves();
	
	public boolean possibleMove(Position position) {  //M�todo gancho - m�todo padr�o de um m�todp que depende de um m�toddo abstrato
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	public boolean isThereAnyPossibleMove() { //
		boolean[][] mat = possibleMoves();  //Implemta��o padr�o concreta que depende de um m�todo abstrato
		for (int i=0; i<mat.length; i++) {
			for (int j=0; j<mat.length; j++) {
				if (mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
}
