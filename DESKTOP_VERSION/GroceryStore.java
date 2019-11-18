import java.awt.Color;

public class GroceryStore<T> {
	private Object board[];
	private boolean turn;
	private int p1score = 0;
	private int p2score = 0;

	public GroceryStore() {
		this.board = new Object[49];
		this.turn = true;
		this.p1score = 0;
		this.p2score = 0;
		for (int i = 0; i < 49; i++) {
			TileButton x = new TileButton();
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

	public Object[] getBoard() {
		return board;
	}

	public void setBoard(Object[] board) {
		this.board = board;
	}
	public boolean getTurn() {
		return turn;
	}

	public void setTurn(boolean turn) {
		this.turn = turn;
	}

	public Object[] right(GroceryStore<TileButton> board2) {
		Object[] temp = new Object[49];
		GroceryStore<TileButton> mason = board2;
		int x1 = -1;
		if (mason.turn == true) {
			x1 = findplayer1(mason);
		} else {
			x1 = findplayer2(mason);
		}
		boolean walk = false;
		if (x1 == 6 || x1 == 13 || x1 == 20 || x1 == 27 || x1 == 34 || x1 == 41 || x1 == 48) {
			((TileButton) mason.board[x1]).setColor(Color.ORANGE);
			temp = copy(mason);
			return temp;
		} else if (((TileButton) mason.board[x1 + 1]).getPlatform() == true) {
			if (((TileButton) mason.board[x1 + 1]).getPerson() == true) {
				((TileButton) mason.board[x1]).setColor(Color.ORANGE);
				temp = copy(mason);
				return temp;
			}
			walk = true;
		}
		TileButton y = new TileButton();
		if (walk == true) {
			((TileButton) mason.getBoard()[x1]).setColor(Color.YELLOW);
			y = (TileButton) mason.board[x1];
			mason.board[x1] = mason.board[x1 + 1];
			mason.board[x1 + 1] = y;
		} else {
			int z = findnext(x1, mason);
			((TileButton) mason.getBoard()[x1]).setColor(Color.YELLOW);
			y = (TileButton) mason.board[x1];
			mason.board[x1] = mason.board[z];
			mason.board[z] = y;
			mason.setTurn(!(mason.getTurn()));
		}
		temp = copy(mason);
		return temp;
	}

	private int findnext(int xn, GroceryStore<TileButton> mason) {
		int xn1 = xn;
		if (xn1 == 5 || xn1 == 12 || xn1 == 19 || xn1 == 26 || xn1 == 33 || xn1 == 40 || xn1 == 47) {
			xn1++;
			return xn1;
		}
		while (((TileButton) mason.board[xn1 + 1]).getPlatform() == false) {
			xn1++;
			if (xn1 == 6 || xn1 == 13 || xn1 == 20 || xn1 == 27 || xn1 == 34 || xn1 == 41 || xn1 == 48) {
				break;
			}
		}
		return xn1;
	}

	private Object[] copy(GroceryStore<TileButton> board2) {
		Object[] current = new Object[49];
		for (int i = 0; i < 49; i++) {
			current[i] = board2.getBoard()[i];
		}
		return current;
	}

	private int findplayer2(GroceryStore<TileButton> board2) {
		int x = -1;
		for (int i = 0; i < 49; i++) {
			if ((((TileButton) board2.board[i]).getPlayer().equals("player 2"))) {
				x = i;
			}
		}
		return x;
	}

	private int findplayer1(GroceryStore<TileButton> board2) {
		int x = -1;
		for (int i = 0; i < 49; i++) {
			if ((((TileButton) board2.board[i]).getPlayer().equals("player 1"))) {
				x = i;
			}
		}
		return x;
	}

	public Object[] left(GroceryStore<TileButton> board2) {
		Object[] temp = new Object[49];
		GroceryStore<TileButton> mason = board2;
		int x2 = -1;
		if (mason.turn == true) {
			x2 = findplayer1(mason);
		} else {
			x2 = findplayer2(mason);
		}
		boolean walk = false;
		if (x2 == 0 || x2 == 7 || x2 == 14 || x2 == 21 || x2 == 28 || x2 == 35 || x2 == 42) {
			((TileButton) mason.board[x2]).setColor(Color.ORANGE);
			temp = copy(mason);
			return temp;
		} else if (((TileButton) mason.board[x2 - 1]).getPlatform() == true) {
			if (((TileButton) mason.board[x2 - 1]).getPerson() == true) {
				((TileButton) mason.board[x2]).setColor(Color.ORANGE);
				temp = copy(mason);
				return temp;
			}
			walk = true;
		}
		TileButton y = new TileButton();
		if (walk == true) {
			((TileButton) mason.getBoard()[x2]).setColor(Color.YELLOW);
			y = (TileButton) mason.board[x2];
			mason.board[x2] = mason.board[x2 - 1];
			mason.board[x2 - 1] = y;
		} else {
			int z = findprev(x2, mason);
			((TileButton) mason.getBoard()[x2]).setColor(Color.YELLOW);
			y = (TileButton) mason.board[x2];
			mason.board[x2] = mason.board[z];
			mason.board[z] = y;
			mason.setTurn(!(mason.getTurn()));
		}
		temp = copy(mason);
		return temp;
	}

	private int findprev(int xp, GroceryStore<TileButton> mason) {
		int xp2 = xp;
		if (xp2 == 1 || xp2 == 8 || xp2 == 15 || xp2 == 22 || xp2 == 29 || xp2 == 36 || xp2 == 43) {
			xp2--;
			return xp2;
		}
		while (((TileButton) mason.board[xp2 - 1]).getPlatform() == false) {
			xp2--;
			if (xp2 == 0 || xp2 == 7 || xp2 == 14 || xp2 == 21 || xp2 == 28 || xp2 == 35 || xp2 == 42) {
				break;
			}
		}
		return xp2;
	}

	public Object[] up(GroceryStore<TileButton> board2) {
		Object[] temp = new Object[49];
		GroceryStore<TileButton> mason = board2;
		int x3 = -1;
		if (mason.turn == true) {
			x3 = findplayer1(mason);
		} else {
			x3 = findplayer2(mason);
		}
		// System.out.println(x);
		boolean walk = false;
		if (x3 == 0 || x3 == 1 || x3 == 2 || x3 == 3 || x3 == 4 || x3 == 5 || x3 == 6) {
			((TileButton) mason.board[x3]).setColor(Color.ORANGE);
			temp = copy(mason);
			return temp;
		} else if (((TileButton) mason.board[x3 - 7]).getPlatform() == true) {
			if (((TileButton) mason.board[x3 - 7]).getPerson() == true) {
				((TileButton) mason.board[x3]).setColor(Color.ORANGE);
				temp = copy(mason);
				return temp;
			}
			walk = true;
		}
		TileButton y = new TileButton();
		if (walk == true) {
			((TileButton) mason.getBoard()[x3]).setColor(Color.YELLOW);
			y = (TileButton) mason.board[x3];
			mason.board[x3] = mason.board[x3 - 7];
			mason.board[x3 - 7] = y;
		} else {
			int z = findupper(x3, mason);
			((TileButton) mason.getBoard()[x3]).setColor(Color.YELLOW);
			y = (TileButton) mason.board[x3];
			mason.board[x3] = mason.board[z];
			mason.board[z] = y;
			mason.setTurn(!(mason.getTurn()));
		}
		temp = copy(mason);
		return temp;
	}

	private int findupper(int xu, GroceryStore<TileButton> mason) {
		int xu3 = xu;
		if (xu3 == 7 || xu3 == 8 || xu3 == 9 || xu3 == 10 || xu3 == 11 || xu3 == 12 || xu3 == 13) {
			xu3 = xu3 - 7;
			return xu3;
		}
		while (((TileButton) mason.board[xu3 - 7]).getPlatform() == false) {
			xu3 = xu3 - 7;
			if (xu3 < 7) {
				break;
			}
		}
		return xu3;
	}

	public Object[] down(GroceryStore<TileButton> board2) {
		Object[] temp = new Object[49];
		GroceryStore<TileButton> mason = board2;
		int x4 = -1;
		if (mason.turn == true) {
			x4 = findplayer1(mason);
		} else {
			x4 = findplayer2(mason);
		}
		boolean walk = false;
		if (x4 == 42 || x4 == 43 || x4 == 44 || x4 == 45 || x4 == 46 || x4 == 47 || x4 == 48) {
			((TileButton) mason.board[x4]).setColor(Color.ORANGE);
			temp = copy(mason);
			return temp;
		} else if (((TileButton) mason.board[x4 + 7]).getPlatform() == true) {
			if (((TileButton) mason.board[x4 + 7]).getPerson() == true) {
				((TileButton) mason.board[x4]).setColor(Color.ORANGE);
				temp = copy(mason);
				return temp;
			}
			walk = true;
		}
		TileButton y = new TileButton();
		if (walk == true) {
			((TileButton) mason.getBoard()[x4]).setColor(Color.YELLOW);
			y = (TileButton) mason.board[x4];
			mason.board[x4] = mason.board[x4 + 7];
			mason.board[x4 + 7] = y;
		} else {
			int z = findbelow(x4, mason);
			((TileButton) mason.getBoard()[x4]).setColor(Color.YELLOW);
			y = (TileButton) mason.board[x4];
			mason.board[x4] = mason.board[z];
			mason.board[z] = y;
			mason.setTurn(!(mason.getTurn()));
		}
		temp = copy(mason);
		return temp;
	}

	private int findbelow(int xb, GroceryStore<TileButton> mason) {
		int xb4 = xb;
		if (xb4 == 35 || xb4 == 36 || xb4 == 37 || xb4 == 38 || xb4 == 39 || xb4 == 40 || xb4 == 41) {
			xb4 = xb4 + 7;
			return xb4;
		}
		while (((TileButton) mason.board[xb4 + 7]).getPlatform() == false) {
			xb4 = xb4 + 7;
			if (xb4 > 41) {
				break;
			}
		}
		return xb4;
	}

	public String win(GroceryStore<TileButton> board2) {
		String x = ((TileButton) board2.board[24]).getPlayer();
		return x;
	}

	public int getP2score() {
		return p2score;
	}

	public void setP2score(int p2score) {
		this.p2score = p2score;
	}

	public int getP1score() {
		return p1score;
	}

	public void setP1score(int p1score) {
		this.p1score = p1score;
	}
}
