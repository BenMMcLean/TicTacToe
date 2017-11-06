package com.benmmclean.tictactoe.frame;

import javax.swing.JOptionPane;

import com.benmmclean.tictactoe.ai.AIInterface;
import com.benmmclean.tictactoe.board.Board;
import com.benmmclean.tictactoe.board.Piece;

public class IBoardFrameInterface implements BoardFrameInterface{
	
	AIInterface ai;
	Board b;

	public IBoardFrameInterface(AIInterface ai, Board b) {
		super();
		this.ai = ai;
		this.b = b;
	}

	@Override
	public void placed(int x, int y) {
		if(b.get(x, y) == Piece.N){
			b.set(x, y, Piece.X);
			
			Piece winner = b.hasWon();
			if(winner != Piece.N){
				JOptionPane.showMessageDialog(null, ((winner == Piece.O) ? "O" : "X") + " is the winner!");
				return;
			}
			
			ai.run();
			
			winner = b.hasWon();
			if(winner != Piece.N){
				JOptionPane.showMessageDialog(null, ((winner == Piece.O) ? "O" : "X") + " is the winner!");
				return;
			}
		}
	}

}
