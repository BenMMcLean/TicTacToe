package com.benmmclean.tictactoe.board;

public class Board {
	
	Piece[][] pieces;
	int width,height,winNum;
	
	public Board(){
		this(3,3,3);
	}
	
	public Board(int width, int height, int winNum){
		pieces = new Piece[this.height=height][this.width=width];
		this.winNum = winNum;
		
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				pieces[y][x] = Piece.N;
			}
		}
	}
	
	public Piece get(int x, int y){
		if(x >= width || y >= height){
			return Piece.N;
		}
		
		return pieces[y][x];
	}
	
	public Piece set(int x, int y, Piece v){
		if(x >= width || y >= height){
			return Piece.X;
		}
		
		Piece p = pieces[y][x];
		pieces[y][x] = v;
		return p;
	}
	
	public boolean isEmpty(int x, int y){
		return get(x,y) == Piece.X;
	}
	
	public Piece hasWon(){
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				Piece s = get(x,y);
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
