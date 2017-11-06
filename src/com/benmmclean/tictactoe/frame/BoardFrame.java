package com.benmmclean.tictactoe.frame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.benmmclean.tictactoe.board.Board;

public class BoardFrame extends JFrame{
	private static final long serialVersionUID = -8031516708089120873L;
	
	Board b;
	JPanel bPanel;
	JButton[][] bButton;
	
	BoardFrameInterface bfi;
	
	public BoardFrame(Board b, BoardFrameInterface bfi){
		this.b = b;
		this.bfi = bfi;
		
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
		this.setTitle("TicTacToe");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		bPanel = new JPanel();
		bPanel.setLayout(new GridLayout(b.getWidth(),b.getHeight()));
		
		bButton = new JButton[b.getHeight()][b.getWidth()];
		
		for(int y = 0; y < b.getHeight(); y++){
			for(int x = 0; x < b.getWidth(); x++){
				JButton jb = new JButton();
				
				bButton[y][x] = (JButton) bPanel.add(jb);
				
				render(x,y);
				
				final int fx = x;
				final int fy = y;
				jb.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
						bfi.placed(fx, fy);
						render(fx,fy);
					}
				});
			}
		}
		
		this.add(bPanel);
	}
	
	private void render(int x, int y){
		JButton jb = bButton[y][x];
		
		if(b.get(x, y) == null){return;}
		
		switch(b.get(x, y)){
		case X:
			jb.setText("X");
			break;
		case O:
			jb.setText("O");
			break;
		case N:
			jb.setText("");
			break;
		}
	}

}
