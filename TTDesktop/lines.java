import java.awt.Color;

public class lines {
	private String[] lines = new String[17];
	private Board<Tile>[] tboard = new Board[17];

	public lines() {
		this.lines = lines;
		this.tboard = tboard;
		Board<Tile> temp1= new Board<Tile>();
		for(int i = 0; i < 4; i++) {
			tboard[i] = temp1;
		}
		Board<Tile> temp21= new Board<Tile>();
		((Tile) temp21.getBoard()[8]).setColor(Color.YELLOW);
		((Tile) temp21.getBoard()[35]).setColor(Color.CYAN);
		tboard[4] = temp21;
		Board<Tile> temp2= new Board<Tile>();
		((Tile) temp2.getBoard()[8]).setColor(Color.YELLOW);
		((Tile) temp2.getBoard()[35]).setColor(Color.CYAN);
		temp2.down(temp2);
		tboard[5] = temp2;
		Board<Tile> temp3= new Board<Tile>();
		temp3.down(temp3);
		((Tile) temp3.getBoard()[8]).setColor(Color.YELLOW);
		((Tile) temp3.getBoard()[35]).setColor(Color.CYAN);
		((Tile) temp3.getBoard()[8]).setPlatform(true);
		temp3.right(temp3);
		tboard[6] = temp3;
		Board<Tile> temp4= new Board<Tile>();
		temp4.right(temp4);
		((Tile) temp4.getBoard()[8]).setColor(Color.YELLOW);
		((Tile) temp4.getBoard()[35]).setColor(Color.CYAN);
		tboard[7] = temp4;
		Board<Tile> temp5= new Board<Tile>();
		((Tile)temp5.getBoard()[1]).setPerson(true);
		((Tile)temp5.getBoard()[1]).setPlayer("player 2");
		((Tile)temp5.getBoard()[48]).setPlayer("");
		temp5.right(temp5);
		((Tile)temp5.getBoard()[0]).setPlayer("player 1 ->");
		tboard[8] = temp5;
		tboard[9] = temp1;
		Board<Tile> temp6= new Board<Tile>();
		temp6.right(temp6);
		tboard[10] = temp6;
		Board<Tile> temp7= new Board<Tile>();
		temp7.right(temp7);
		temp7.right(temp7);
		tboard[11] = temp7;
		Board<Tile> temp8= new Board<Tile>();
		((Tile)temp8.getBoard()[5]).setColor(Color.CYAN);
		((Tile)temp8.getBoard()[5]).setPlatform(false);
		((Tile)temp8.getBoard()[6]).setColor(Color.CYAN);
		((Tile)temp8.getBoard()[6]).setPlatform(false);
		((Tile)temp8.getBoard()[20]).setColor(Color.YELLOW);
		((Tile)temp8.getBoard()[27]).setColor(Color.YELLOW);
		tboard[12] = temp8;
		Board<Tile> temp9= new Board<Tile>();
		((Tile)temp9.getBoard()[5]).setColor(Color.CYAN);
		((Tile)temp9.getBoard()[5]).setPlatform(false);
		((Tile)temp9.getBoard()[6]).setColor(Color.CYAN);
		((Tile)temp9.getBoard()[6]).setPlatform(false);
		((Tile)temp9.getBoard()[20]).setColor(Color.YELLOW);
		((Tile)temp9.getBoard()[27]).setColor(Color.YELLOW);
		temp9.right(temp9);
		tboard[13] = temp9;
		Board<Tile> temp10= new Board<Tile>();
		((Tile)temp10.getBoard()[5]).setColor(Color.CYAN);
		((Tile)temp10.getBoard()[5]).setPlatform(false);
		((Tile)temp10.getBoard()[6]).setColor(Color.CYAN);
		((Tile)temp10.getBoard()[6]).setPlatform(false);
		((Tile)temp10.getBoard()[20]).setColor(Color.YELLOW);
		((Tile)temp10.getBoard()[27]).setColor(Color.YELLOW);
		temp10.right(temp10);
		temp10.right(temp10);
		tboard[14] = temp10;
		Board<Tile> temp11= new Board<Tile>();
		((Tile)temp11.getBoard()[7]).setColor(Color.CYAN);
		((Tile)temp11.getBoard()[0]).setPlayer("");
		((Tile)temp11.getBoard()[21]).setColor(Color.YELLOW);
		((Tile)temp11.getBoard()[21]).setPlayer("player 1 ->");
		((Tile)temp11.getBoard()[13]).setColor(Color.CYAN);
		((Tile)temp11.getBoard()[25]).setColor(Color.YELLOW);
		tboard[15] = temp11;
		String s1 = "Thanks for play Tile Takeover this is the tutorial.";
		String s2 = "It is a game with 12 platform (Yellow) on a 7x7 board and this demo supports game play for 2 players.";
		String s3 = "The goal for the player is to reach the center red tile.";
		String s4 = "There are 2 movements option for each player: a walk and a slide.";
		String s5 = "The player can walk to any adjacent platform as much as they want for their turn.";
		String s6 = "A player can not walk to a platform with another player on it, tile will turn orange due to an invalid move.";
		String s7 = "The player can slide until reaching the border or another tile, then their turn is over.";
		String s8 = " the first player to slide to center tile wins.";
		lines[0] = s1;
		lines[1] = s2;
		lines[2] = s3;
		lines[3] = s4;
		lines[4] = s5;
		lines[5] = s5;
		lines[6] = s5;
		lines[7] = s5;
		lines[8] = s6;
		lines[9] = s7;
		lines[10] = s7;
		lines[11] = s7;
		lines[12] = s7;
		lines[13] = s7;
		lines[14] = s7;
		lines[15] = s8;
	}


	public Board<Tile>[] getTboard() {
		return tboard;
	}

	public String[] getLines() {
		return lines;
	}

}
