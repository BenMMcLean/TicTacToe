package com.benmmclean.tictactoe.board;

public class Board {
	
	//A grid of every piece
	Piece[][] pieces;
	//The width, height, and row size required for winning
	int width,height,winNum;
	
	//Default game config
	public Board(){
		this(3,3,3);
	}
	
	public Board(int width, int height, int winNum){
		pieces = new Piece[this.height=height][this.width=width];
		this.winNum = winNum;
		
		//Populate the board
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				pieces[y][x] = Piece.N;
			}
		}
	}
	
	//Return the piece at a position
	public Piece get(int x, int y){
		if(x >= width || y >= height){
			return Piece.N;
		}
		
		return pieces[y][x];
	}
	
	//Set the piece at a position
	public Piece set(int x, int y, Piece v){
		if(x >= width || y >= height){
			return Piece.X;
		}
		
		Piece p = pieces[y][x];
		pieces[y][x] = v;
		return p;
	}
	
	//Check if a position is empty
	public boolean isEmpty(int x, int y){
		return get(x,y) == Piece.X;
	}
	
	//Check if someone has won
	public Piece hasWon(){
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				//Get the starting piece
				Piece s = get(x,y);
				if(s == Piece.N){
					continue;
				}
				//Check horizontal, vertical, and diagonal to see if filled with same piece as starting piece
				boolean b1 = false, b2 = false, b3 = false;
				for(int i = 1; i < winNum; i++){
					if(get(x+i,y)!= s){b1=true;}
					if(get(x,y+i)!=s){b2=true;}
					if(get(x+i,y+i)!=s){b3=true;}
				}
				
				if(!b1||!b2||!b3){
					return s;
				}
			}
		}
		
		return Piece.N;
	}
	
	//Check if the board is full
	public boolean isTied(){
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				if(get(x,y) != Piece.N){
					return false;
				}
			}
		}
		return true;
	}

	public Piece[][] getPieces() {
		return pieces;
	}

	public void setPieces(Piece[][] pieces) {
		this.pieces = pieces;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWinNum() {
		return winNum;
	}

	public void setWinNum(int winNum) {
		this.winNum = winNum;
	}
}
