package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece {

	public Queen(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "Q";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position p = new Position(0, 0);

		// above - Verificando as posições acima da peça
		p.setValues(position.getRow() - 1, position.getColumn());
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) { // Se houver mais uma posição acima e for uma
																		// peça oponente
			mat[p.getRow()][p.getColumn()] = true;
		}

		// left - Verificando as posições a esquerda da peça
		p.setValues(position.getRow(), position.getColumn() - 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) { // Se houver mais uma posição a esquerda e for
																		// uma peça oponente
			mat[p.getRow()][p.getColumn()] = true;
		}

		// right - Verificando as posições a direita da peça
		p.setValues(position.getRow(), position.getColumn() + 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setColumn(p.getColumn() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) { // Se houver mais uma posição a direita e for uma
																		// peça oponente
			mat[p.getRow()][p.getColumn()] = true;
		}

		// below - Verificando as posições abaixo da peça
		p.setValues(position.getRow() + 1, position.getColumn());
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setRow(p.getRow() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) { // Se houver mais uma posição abaixo e for uma
																		// peça oponente
			mat[p.getRow()][p.getColumn()] = true;
		}

		// NorthWest NW - Verificando as posições a NW da peça
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() - 1, p.getColumn() - 1);
			;
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) { // Se houver mais uma posição em NW e for uma
																		// peça oponente
			mat[p.getRow()][p.getColumn()] = true;
		}

		// NorthEast - Verificando as posições a NE da peça
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() - 1, p.getColumn() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) { // Se houver mais uma posição a esquerda e for
																		// uma peça oponente
			mat[p.getRow()][p.getColumn()] = true;
		}

		// SouthWest SW - Verificando as posições a SW da peça
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() + 1, p.getColumn() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) { // Se houver mais uma posição a direita e for uma
																		// peça oponente
			mat[p.getRow()][p.getColumn()] = true;
		}

		// SouthEast - Verificando as posições SE da peça
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() + 1, p.getColumn() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) { // Se houver mais uma posição abaixo e for uma
																		// peça oponente
			mat[p.getRow()][p.getColumn()] = true;
		}
		return mat;
	}
}
