package com.benmmclean.tictactoe;

import com.benmmclean.tictactoe.ai.AIInterface;
import com.benmmclean.tictactoe.ai.MinimaxAI;
import com.benmmclean.tictactoe.board.Board;
import com.benmmclean.tictactoe.frame.BoardFrame;
import com.benmmclean.tictactoe.frame.IBoardFrameInterface;

public class Main {

	public static void main(String[] args) {
		Board b = new Board();
		
		AIInterface ai = new MinimaxAI(b);
		
		BoardFrame f = new BoardFrame(b, new IBoardFrameInterface(ai,b));
		f.setVisible(true);
	}

}
