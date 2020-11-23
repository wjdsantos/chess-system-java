package boardgame;

public class Piece {

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
}
