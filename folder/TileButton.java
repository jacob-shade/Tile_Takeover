import java.awt.Color;
import javax.swing.JButton;

@SuppressWarnings("serial")
class TileButton extends JButton {
	private boolean person;
	private boolean platform;
	private Color color;
	private String player;

	public TileButton() {
		this.person = false;
		this.platform = false;
		this.color = Color.cyan;
		this.player = null;
	}

	public boolean getPlatform() {
		return platform;
	}

	public void setPlatform(boolean platform) {
		this.platform = platform;
	}

	public boolean getPerson() {
		return person;
	}

	public void setPerson(boolean person) {
		this.person = person;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}
}