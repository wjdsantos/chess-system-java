package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {

	public Bishop(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "B";
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position p = new Position(0, 0);
		
		//NorthWest NW - Verificando as posi��es a NW da pe�a
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() - 1, p.getColumn() - 1);;
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {  //Se houver mais uma posi��o em NW e for uma pe�a oponente
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//NorthEast - Verificando as posi��es a NE da pe�a
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() - 1, p.getColumn() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {  //Se houver mais uma posi��o a esquerda e for uma pe�a oponente
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//SouthWest SW - Verificando as posi��es a SW da pe�a
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() + 1, p.getColumn() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {  //Se houver mais uma posi��o a direita e for uma pe�a oponente
			mat[p.getRow()][p.getColumn()] = true;
		}

		//SouthEast - Verificando as posi��es SE da pe�a
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() + 1, p.getColumn() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {  //Se houver mais uma posi��o abaixo e for uma pe�a oponente
			mat[p.getRow()][p.getColumn()] = true;
		}

		return mat;
	}
}
