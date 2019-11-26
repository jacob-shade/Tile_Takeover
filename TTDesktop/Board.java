import java.awt.Color;

public class Board<T> {
	
	/**
	 * board: object array that will hold all of the tile objects
	 * turn: boolean flag that will indicate which player has the current turn
	 * p1score, p2score: will hold the round scores of each player 
	 * 
	 */
	private Object board[];
	private boolean turn;
	private int p1score = 0;
	private int p2score = 0;

	
	
	/**
	 * constructs the board, and places the platforms in the appropriate locations on the board
	 * Initializes the round scores for each player
	 * sets the color of each tile
	 * places the players on their starting positions on the board
	 */
	public Board() {
		this.board = new Object[49];
		this.turn = true;
		this.p1score = 0;
		this.p2score = 0;
		for (int i = 0; i < 49; i++) {
			Tile x = new Tile();
			if (i == 0 || i == 1 || i == 5 || i == 6 || i == 7 || i == 13 || i == 35 || i == 41 || i == 42 || i == 43
					|| i == 47 || i == 48) {
				x.setPlatform(true);
				x.setColor(Color.YELLOW);
			}
			if (i == 0) {
				x.setPlayer("player 1");
				x.setPerson(true);
			} else if (i == 48) {
				x.setPlayer("player 2");
				x.setPerson(true);
			} else {
				x.setPlayer("");
				if (i == 24) {
					x.setColor(Color.red);
				}
			}
			board[i] = x;
		}
	}

	
	
	/**
	 * Returns the board that is in use
	 * @return board field
	 */
	public Object[] getBoard() {
		return board;
	}

	
	
	/**
	 * updates a board to a new board
	 * @param board: new board to replace the current board in use
	 */
	public void setBoard(Object[] board) {
		this.board = board;
	}
	
	
	/**
	 * returns boolean flag indicating which player is in turn
	 * @return turn: turn field
	 */
	public boolean getTurn() {
		return turn;
	}

	
	/**
	 * sets the turn field 
	 * @param turn: updated turn value
	 */
	public void setTurn(boolean turn) {
		this.turn = turn;
	}

	
	/**
	 * conducts the right direction movement of a player
	 * moves the player rightward with a walk or slide depending on the location of other tiles
	 * updates the colors of the tiles and platforms
	 * @param board2 board that will be the updated version of the board
	 * @return the updated board
	 */
	public Object[] right(Board<Tile> board2) {
		Object[] temp = new Object[49];
		Board<Tile> mason = board2;
		int x1 = -1;
		if (mason.turn == true) {
			x1 = findplayer1(mason);
		} else {
			x1 = findplayer2(mason);
		}
		boolean walk = false;
		if (x1 == 6 || x1 == 13 || x1 == 20 || x1 == 27 || x1 == 34 || x1 == 41 || x1 == 48) {
			((Tile) mason.board[x1]).setColor(Color.ORANGE);
			temp = copy(mason);
			return temp;
		} else if (((Tile) mason.board[x1 + 1]).getPlatform() == true) {
			if (((Tile) mason.board[x1 + 1]).getPerson() == true) {
				((Tile) mason.board[x1]).setColor(Color.ORANGE);
				temp = copy(mason);
				return temp;
			}
			walk = true;
		}
		Tile y = new Tile();
		if (walk == true) {
			((Tile) mason.getBoard()[x1]).setColor(Color.YELLOW);
			y = (Tile) mason.board[x1];
			mason.board[x1] = mason.board[x1 + 1];
			mason.board[x1 + 1] = y;
		} else {
			int z = findnext(x1, mason);
			((Tile) mason.getBoard()[x1]).setColor(Color.YELLOW);
			y = (Tile) mason.board[x1];
			mason.board[x1] = mason.board[z];
			mason.board[z] = y;
			mason.setTurn(!(mason.getTurn()));
		}
		temp = copy(mason);
		return temp;
	}
	/**
	 * finds the platform immediately to the right of the player's current location
	 * @param xn: current player's location
	 * @param mason: current board the player resides on
	 * @return the location of the found tile
	 */
	private int findnext(int xn, Board<Tile> mason) {
		int xn1 = xn;
		if (xn1 == 5 || xn1 == 12 || xn1 == 19 || xn1 == 26 || xn1 == 33 || xn1 == 40 || xn1 == 47) {
			xn1++;
			return xn1;
		}
		while (((Tile) mason.board[xn1 + 1]).getPlatform() == false) {
			xn1++;
			if (xn1 == 6 || xn1 == 13 || xn1 == 20 || xn1 == 27 || xn1 == 34 || xn1 == 41 || xn1 == 48) {
				break;
			}
		}
		return xn1;
	}

	
	
	/**
	 * conducts a deep copy of the board
	 * @param board2 board that will have its values copied
	 * @return a copy of board2
	 */
	private Object[] copy(Board<Tile> board2) {
		Object[] current = new Object[49];
		for (int i = 0; i < 49; i++) {
			current[i] = board2.getBoard()[i];
		}
		return current;
	}

	
	
	/**
	 * used to find player 2's current location
	 * @param board2: board that player 2 currently resides on 
	 * @return the location of player 2
	 */
	public int findplayer2(Board<Tile> board2) {
		int x = -1;
		for (int i = 0; i < 49; i++) {
			if ((((Tile) board2.board[i]).getPlayer().equals("player 2"))) {
				x = i;
			}
		}
		return x;
	}

	
	/**
	 * used to find player 1's current location
	 * @param board2: board that player 1 currently resides on 
	 * @return the location of player 1
	 */
	public int findplayer1(Board<Tile> board2) {
		int x = -1;
		for (int i = 0; i < 49; i++) {
			if ((((Tile) board2.board[i]).getPlayer().equals("player 1"))) {
				x = i;
			}
		}
		return x;
	}
	/**
	 * conducts the left direction movement of a player
	 * moves the player leftward with a walk or slide depending on the location of other tiles
	 * updates the colors of the tiles and platforms
	 * @param board2 board that will be the updated version of the board
	 * @return the updated board
	 */
	public Object[] left(Board<Tile> board2) {
		Object[] temp = new Object[49];
		Board<Tile> mason = board2;
		int x2 = -1;
		if (mason.turn == true) {
			x2 = findplayer1(mason);
		} else {
			x2 = findplayer2(mason);
		}
		boolean walk = false;
		if (x2 == 0 || x2 == 7 || x2 == 14 || x2 == 21 || x2 == 28 || x2 == 35 || x2 == 42) {
			((Tile) mason.board[x2]).setColor(Color.ORANGE);
			temp = copy(mason);
			return temp;
		} else if (((Tile) mason.board[x2 - 1]).getPlatform() == true) {
			if (((Tile) mason.board[x2 - 1]).getPerson() == true) {
				((Tile) mason.board[x2]).setColor(Color.ORANGE);
				temp = copy(mason);
				return temp;
			}
			walk = true;
		}
		Tile y = new Tile();
		if (walk == true) {
			((Tile) mason.getBoard()[x2]).setColor(Color.YELLOW);
			y = (Tile) mason.board[x2];
			mason.board[x2] = mason.board[x2 - 1];
			mason.board[x2 - 1] = y;
		} else {
			int z = findprev(x2, mason);
			((Tile) mason.getBoard()[x2]).setColor(Color.YELLOW);
			y = (Tile) mason.board[x2];
			mason.board[x2] = mason.board[z];
			mason.board[z] = y;
			mason.setTurn(!(mason.getTurn()));
		}
		temp = copy(mason);
		return temp;
	}
	/**
	 * finds the platform immediately to the left of the player's current location
	 * @param xp: current player's location
	 * @param mason: current board the player resides on
	 * @return the location of the found tile
	 */
	private int findprev(int xp, Board<Tile> mason) {
		int xp2 = xp;
		if (xp2 == 1 || xp2 == 8 || xp2 == 15 || xp2 == 22 || xp2 == 29 || xp2 == 36 || xp2 == 43) {
			xp2--;
			return xp2;
		}
		while (((Tile) mason.board[xp2 - 1]).getPlatform() == false) {
			xp2--;
			if (xp2 == 0 || xp2 == 7 || xp2 == 14 || xp2 == 21 || xp2 == 28 || xp2 == 35 || xp2 == 42) {
				break;
			}
		}
		return xp2;
	}
	/**
	 * conducts the up direction movement of a player
	 * moves the player upward with a walk or slide depending on the location of other tiles
	 * updates the colors of the tiles and platforms
	 * @param board2 board that will be the updated version of the board
	 * @return the updated board
	 */
	public Object[] up(Board<Tile> board2) {
		Object[] temp = new Object[49];
		Board<Tile> mason = board2;
		int x3 = -1;
		if (mason.turn == true) {
			x3 = findplayer1(mason);
		} else {
			x3 = findplayer2(mason);
		}
		// System.out.println(x);
		boolean walk = false;
		if (x3 == 0 || x3 == 1 || x3 == 2 || x3 == 3 || x3 == 4 || x3 == 5 || x3 == 6) {
			((Tile) mason.board[x3]).setColor(Color.ORANGE);
			temp = copy(mason);
			return temp;
		} else if (((Tile) mason.board[x3 - 7]).getPlatform() == true) {
			if (((Tile) mason.board[x3 - 7]).getPerson() == true) {
				((Tile) mason.board[x3]).setColor(Color.ORANGE);
				temp = copy(mason);
				return temp;
			}
			walk = true;
		}
		Tile y = new Tile();
		if (walk == true) {
			((Tile) mason.getBoard()[x3]).setColor(Color.YELLOW);
			y = (Tile) mason.board[x3];
			mason.board[x3] = mason.board[x3 - 7];
			mason.board[x3 - 7] = y;
		} else {
			int z = findupper(x3, mason);
			((Tile) mason.getBoard()[x3]).setColor(Color.YELLOW);
			y = (Tile) mason.board[x3];
			mason.board[x3] = mason.board[z];
			mason.board[z] = y;
			mason.setTurn(!(mason.getTurn()));
		}
		temp = copy(mason);
		return temp;
	}
	
	
	
	/**
	 * finds the tile platform that is above the player's current platform
	 * @param xu: current location of the player
	 * @param mason board that player resides on
	 * @return the location of the tile platform that was found  
	 */
	private int findupper(int xu, Board<Tile> mason) {
		int xu3 = xu;
		if (xu3 == 7 || xu3 == 8 || xu3 == 9 || xu3 == 10 || xu3 == 11 || xu3 == 12 || xu3 == 13) {
			xu3 = xu3 - 7;
			return xu3;
		}
		while (((Tile) mason.board[xu3 - 7]).getPlatform() == false) {
			xu3 = xu3 - 7;
			if (xu3 < 7) {
				break;
			}
		}
		return xu3;
	}
	/**
	 * conducts the down direction movement of a player
	 * moves the player downward with a walk or slide depending on the location of other tiles
	 * updates the colors of the tiles and platforms
	 * @param board2 board that will be the updated version of the board
	 * @return the updated board
	 */
	public Object[] down(Board<Tile> board2) {
		Object[] temp = new Object[49];
		Board<Tile> mason = board2;
		int x4 = -1;
		if (mason.turn == true) {
			x4 = findplayer1(mason);
		} else {
			x4 = findplayer2(mason);
		}
		boolean walk = false;
		if (x4 == 42 || x4 == 43 || x4 == 44 || x4 == 45 || x4 == 46 || x4 == 47 || x4 == 48) {
			((Tile) mason.board[x4]).setColor(Color.ORANGE);
			temp = copy(mason);
			return temp;
		} else if (((Tile) mason.board[x4 + 7]).getPlatform() == true) {
			if (((Tile) mason.board[x4 + 7]).getPerson() == true) {
				((Tile) mason.board[x4]).setColor(Color.ORANGE);
				temp = copy(mason);
				return temp;
			}
			walk = true;
		}
		Tile y = new Tile();
		if (walk == true) {
			((Tile) mason.getBoard()[x4]).setColor(Color.YELLOW);
			y = (Tile) mason.board[x4];
			mason.board[x4] = mason.board[x4 + 7];
			mason.board[x4 + 7] = y;
		} else {
			int z = findbelow(x4, mason);
			((Tile) mason.getBoard()[x4]).setColor(Color.YELLOW);
			y = (Tile) mason.board[x4];
			mason.board[x4] = mason.board[z];
			mason.board[z] = y;
			mason.setTurn(!(mason.getTurn()));
		}
		temp = copy(mason);
		return temp;
	}

	/**
	 * finds the tile platform that is below the player's current platform
	 * @param xb: current location of the player
	 * @param mason board that player resides on
	 * @return the location of the tile platform that was found  
	 */
	private int findbelow(int xb, Board<Tile> mason) {
		int xb4 = xb;
		if (xb4 == 35 || xb4 == 36 || xb4 == 37 || xb4 == 38 || xb4 == 39 || xb4 == 40 || xb4 == 41) {
			xb4 = xb4 + 7;
			return xb4;
		}
		while (((Tile) mason.board[xb4 + 7]).getPlatform() == false) {
			xb4 = xb4 + 7;
			if (xb4 > 41) {
				break;
			}
		}
		return xb4;
	}
	
	
	/**
	 * returns the player that is located on the winning tile
	 * @param board2: board to be be checked
	 * @return player's name that is on the winning tile
	 */
	public String win(Board<Tile> board2) {
		String x = ((Tile) board2.board[24]).getPlayer();
		return x;
	}

	
	
	/**
	 * returns the value of player 2's round score
	 * @return p2score parameter
	 */
	public int getP2score() {
		return p2score;
	}

	
	/**
	 * updates the score of player 2
	 * @param p2score: the new p2score to replace the current
	 */
	public void setP2score(int p2score) {
		this.p2score = p2score;
	}
	
	
	
	/**
	 * returns the value of player 1's round score
	 * @return p1score parameter
	 */
	public int getP1score() {
		return p1score;
	}
	
	
	
	/**
	 * updates the score of player 1
	 * @param p1score: the new p1score to replace the current
	 */
	public void setP1score(int p1score) {
		this.p1score = p1score;
	}
	

}
