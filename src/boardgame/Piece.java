package boardgame;

public class Piece {

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
}
