import java.awt.Color;
import javax.swing.JButton;

@SuppressWarnings("serial")
class Tile extends JButton {
	
	
	
	/**
	 * Person: boolean flag indicates whether or not there is a player on the tile
	 * Platform: boolean flag indicates whether or not the tile is classified as a platform
	 * color: will hold the current color for the time in the GUI
	 * player: string that will indicates the player's name (player 1 or PLayer 2)
	 */
	private boolean person;
	private boolean platform;
	private Color color;
	private String player;

	
	
	/**
	 * constructor for the tile object, that will populate the board
	 */
	public Tile() {
		this.person = false;
		this.platform = false;
		this.color = Color.cyan;
		this.player = null;
	}

	
	
	/**
	 * returns whether or not the tile is a platform
	 * @return boolean field platform
	 */
	public boolean getPlatform() {
		return platform;
	}

	
	
	/**
	 * sets the platform variable of the tile
	 * @param platform: replaces the current value of platform
	 */
	public void setPlatform(boolean platform) {
		this.platform = platform;
	}
	
	
	
	/**
	 * returns whether or not there is a player on the tile
	 * @return boolean field person
	 */
	public boolean getPerson() {
		return person;
	}
	
	
	
	/**
	 * sets the person flag of the tile
	 * @param person: new value to replace the current person value
	 */
	public void setPerson(boolean person) {
		this.person = person;
	}
	
	
	
	/**
	 * returns the color of the tile
	 * @return color field 
	 */
	public Color getColor() {
		return color;
	}
	
	
	
	/**
	 * sets the color of the tile
	 * @param color: color to replace the current tile color
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	
	
	/**
	 * returns the name of the player
	 * @return player field
	 */
	public String getPlayer() {
		return player;
	}
	
	
	
	/**
	 * sets the name of the player on the tile
	 * @param player: string name of the player to be placed on the tile
	 */
	public void setPlayer(String player) {
		this.player = player;
	}
}