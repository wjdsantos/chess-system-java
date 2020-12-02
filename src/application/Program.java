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

		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		List<ChessPiece> captured = new ArrayList<>();
		
		while (!chessMatch.getCheckMate()) {
			try {
				UI.clearScreen();
				//UI.printBoard(chessMatch.getPieces());
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
				
				ChessPiece capturedpPiece = chessMatch.performChessMove(source, target);
				
				if (capturedpPiece != null) {
					captured.add(capturedpPiece);
				}
				
				if (chessMatch.getPromoted() != null) { //Se nessa partida o getPromoted for diferente de nulo, significa
					System.out.print("Enter piece for promotion (B/N/R/Q): ");  //que uma pe�a foi promovida, ent�o pergunto
					String type = sc.nextLine().toUpperCase(); 								// por qual pe�a ser� substituida
					while (!type.equals("B") && !type.equals("N") && !type.equals("R") && !type.equals("Q")) {
						System.out.print("Invalid value! Enter piece for promotion (B/N/R/Q): ");  //A entrada foi inv�lida - digitando novamente
						type = sc.nextLine().toUpperCase(); 
					}
					chessMatch.replacedPromotedPiece(type);						
				}
			}
			catch (ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			
			
		}
		UI.clearScreen();
		UI.printMatch(chessMatch, captured);
	}
}