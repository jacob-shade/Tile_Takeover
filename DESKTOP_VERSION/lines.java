import java.awt.Color;

public class lines {
	private String[] lines = new String[17];
	private GroceryStore<TileButton>[] tboard = new GroceryStore[17];

	public lines() {
		this.lines = lines;
		this.tboard = tboard;
		GroceryStore<TileButton> temp1= new GroceryStore<TileButton>();
		for(int i = 0; i < 4; i++) {
			tboard[i] = temp1;
		}
		GroceryStore<TileButton> temp21= new GroceryStore<TileButton>();
		((TileButton) temp21.getBoard()[8]).setColor(Color.YELLOW);
		((TileButton) temp21.getBoard()[35]).setColor(Color.CYAN);
		tboard[4] = temp21;
		GroceryStore<TileButton> temp2= new GroceryStore<TileButton>();
		((TileButton) temp2.getBoard()[8]).setColor(Color.YELLOW);
		((TileButton) temp2.getBoard()[35]).setColor(Color.CYAN);
		temp2.down(temp2);
		tboard[5] = temp2;
		GroceryStore<TileButton> temp3= new GroceryStore<TileButton>();
		temp3.down(temp3);
		((TileButton) temp3.getBoard()[8]).setColor(Color.YELLOW);
		((TileButton) temp3.getBoard()[35]).setColor(Color.CYAN);
		((TileButton) temp3.getBoard()[8]).setPlatform(true);
		temp3.right(temp3);
		tboard[6] = temp3;
		GroceryStore<TileButton> temp4= new GroceryStore<TileButton>();
		temp4.right(temp4);
		((TileButton) temp4.getBoard()[8]).setColor(Color.YELLOW);
		((TileButton) temp4.getBoard()[35]).setColor(Color.CYAN);
		tboard[7] = temp4;
		GroceryStore<TileButton> temp5= new GroceryStore<TileButton>();
		((TileButton)temp5.getBoard()[1]).setPerson(true);
		((TileButton)temp5.getBoard()[1]).setPlayer("player 2");
		((TileButton)temp5.getBoard()[48]).setPlayer("");
		temp5.right(temp5);
		((TileButton)temp5.getBoard()[0]).setPlayer("player 1 ->");
		tboard[8] = temp5;
		tboard[9] = temp1;
		GroceryStore<TileButton> temp6= new GroceryStore<TileButton>();
		temp6.right(temp6);
		tboard[10] = temp6;
		GroceryStore<TileButton> temp7= new GroceryStore<TileButton>();
		temp7.right(temp7);
		temp7.right(temp7);
		tboard[11] = temp7;
		GroceryStore<TileButton> temp8= new GroceryStore<TileButton>();
		((TileButton)temp8.getBoard()[5]).setColor(Color.CYAN);
		((TileButton)temp8.getBoard()[5]).setPlatform(false);
		((TileButton)temp8.getBoard()[6]).setColor(Color.CYAN);
		((TileButton)temp8.getBoard()[6]).setPlatform(false);
		((TileButton)temp8.getBoard()[20]).setColor(Color.YELLOW);
		((TileButton)temp8.getBoard()[27]).setColor(Color.YELLOW);
		tboard[12] = temp8;
		GroceryStore<TileButton> temp9= new GroceryStore<TileButton>();
		((TileButton)temp9.getBoard()[5]).setColor(Color.CYAN);
		((TileButton)temp9.getBoard()[5]).setPlatform(false);
		((TileButton)temp9.getBoard()[6]).setColor(Color.CYAN);
		((TileButton)temp9.getBoard()[6]).setPlatform(false);
		((TileButton)temp9.getBoard()[20]).setColor(Color.YELLOW);
		((TileButton)temp9.getBoard()[27]).setColor(Color.YELLOW);
		temp9.right(temp9);
		tboard[13] = temp9;
		GroceryStore<TileButton> temp10= new GroceryStore<TileButton>();
		((TileButton)temp10.getBoard()[5]).setColor(Color.CYAN);
		((TileButton)temp10.getBoard()[5]).setPlatform(false);
		((TileButton)temp10.getBoard()[6]).setColor(Color.CYAN);
		((TileButton)temp10.getBoard()[6]).setPlatform(false);
		((TileButton)temp10.getBoard()[20]).setColor(Color.YELLOW);
		((TileButton)temp10.getBoard()[27]).setColor(Color.YELLOW);
		temp10.right(temp10);
		temp10.right(temp10);
		tboard[14] = temp10;
		GroceryStore<TileButton> temp11= new GroceryStore<TileButton>();
		((TileButton)temp11.getBoard()[7]).setColor(Color.CYAN);
		((TileButton)temp11.getBoard()[0]).setPlayer("");
		((TileButton)temp11.getBoard()[21]).setColor(Color.YELLOW);
		((TileButton)temp11.getBoard()[21]).setPlayer("player 1 ->");
		((TileButton)temp11.getBoard()[13]).setColor(Color.CYAN);
		((TileButton)temp11.getBoard()[25]).setColor(Color.YELLOW);
		tboard[15] = temp11;
		String s1 = "Thanks for play Tile Take Over this is the toturial.";
		String s2 = "It is a game with 12 platform (Yellow) on a 7x7 board and this demo supports game play for 2 players.";
		String s3 = "The goal for the player is to reach the center red tile.";
		String s4 = "There are 2 movements option for each player: a walk and a slide.";
		String s5 = "The player can walk to any adjacent platform as much as they want for their turn.";
		String s6 = "a player can not walk to a platform with other player, tile will turn orange due to invalid move.";
		String s7 = "The player can slide until reaching the border or another tile, and their turn is over.";
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


	public GroceryStore<TileButton>[] getTboard() {
		return tboard;
	}

	public String[] getLines() {
		return lines;
	}

}
