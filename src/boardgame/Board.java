package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces; //Matrix de pe�as
	
	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1) {	//Programa��o defensiva
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

//	public void setRows(int rows) {  //Retirado para n�o deixar alterar a quantidade linhas
//		this.rows = rows;			 //Programa��o defensiva
//	}

	public int getColumns() {
		return columns;
	}

//	public void setColumns(int columns) {  //Retirado para n�o deixar alterar a quantidade colunas
//		this.columns = columns;			   //Programa��o defensiva
//	}
	
	public Piece piece(int row, int column) {
		if (!positionExists(row, column)) {  //Programa��o defensiva
			throw new BoardException("Position not on the board");
		}
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		if (!positionExists(position)) {  //Programa��o defensiva
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if (thereIsAPiece(position)) {
			throw new BoardException("There is alredy a piece on position " + position);  //Programa��o defensiva
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
		if (!positionExists(position)) {  //Programa��o defensiva
			throw new BoardException("Position not on the board");
		}
		return piece(position) != null;
	}
}
