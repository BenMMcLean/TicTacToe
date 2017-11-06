package com.benmmclean.tictactoe.frame;

import javax.swing.JOptionPane;

import com.benmmclean.tictactoe.ai.AIInterface;
import com.benmmclean.tictactoe.board.Board;
import com.benmmclean.tictactoe.board.Piece;

//Implementation of BoardFrameInterface
public class IBoardFrameInterface implements BoardFrameInterface{
	
	//An instance of AI
	AIInterface ai;
	//The board
	Board b;

	public IBoardFrameInterface(AIInterface ai, Board b) {
		super();
		this.ai = ai;
		this.b = b;
	}

	@Override
	public void placed(int x, int y) {
		//Check if the clicked position is empty
		if(b.get(x, y) == Piece.N){
			//Place the user piece
			b.set(x, y, Piece.X);
			
			//Check if someone won
			Piece winner = b.hasWon();
			if(winner != Piece.N){
				JOptionPane.showMessageDialog(null, ((winner == Piece.O) ? "O" : "X") + " is the winner!");
				return;
			}
			
			//Run the AI
			ai.run();
			
			//Check if someone won
			winner = b.hasWon();
			if(winner != Piece.N){
				JOptionPane.showMessageDialog(null, ((winner == Piece.O) ? "O" : "X") + " is the winner!");
				return;
			}
		}
	}

}
