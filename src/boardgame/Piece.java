package boardgame;

public abstract class Piece {

	protected Position position;
	
	//Associação
	private Board board;

	//Construtor com fields
	public Piece(Board board) {
		this.board = board;
		position = null;  //Foi colocado manualmente 'position' como nulo pq a peça não terá posição inicial no tabuleiro
	}

	protected Board getBoard() {  //Foi o tirado o setBoard pq não queremos que o tabuleiro seja alterado por aqui
		return board;
	}
	
	public abstract boolean[][] possibleMoves();
	
	public boolean possibleMove(Position position) {  //Método gancho - método padrão de um métodp que depende de um métoddo abstrato
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	public boolean isThereAnyPossibleMove() { //
		boolean[][] mat = possibleMoves();  //Implemtação padrão concreta que depende de um método abstrato
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
