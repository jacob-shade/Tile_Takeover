import java.util.*;
import java.io.*;

//graphics packages
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI {
	/**
	 * Frame for the GUI
	 */
	private JFrame f;

	/**
	 * Current simulation
	 */
	private GroceryStore store = null;

	/**
	 * The panel containing the store display.
	 */
	private JPanel displayPanel = null;

	/**
	 * The panel containing the step, reset, and play buttons.
	 */
	private JPanel buttonPanel = null;
	
	private JPanel scorePanel = null;

	/**
	 * Whether or not a simulation is currently playing with the play button (i.e.
	 * automatically playing).
	 */
	//private boolean playing = false;

	/**
	 * How wide to make the buttons representing a person.
	 */
	private final int BUTTON_WIDTH = 80;

	/**
	 * The seed to use for the random number generator associated with the grocery
	 * store simulation.
	 */

	/**
	 * How tall to make the buttons representing a person.
	 */
	private final int BUTTON_HEIGHT = 80;

	/**
	 * How tall to make the buttons representing a person.
	 */
	private final int MAX_TILE_DISPLAY = 49;

	/**
	 * Load up the GUI!
	 * 
	 */
	public GUI() {
		f = new JFrame("Tile Take Over");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(720, 720);
		f.getContentPane().setLayout(new FlowLayout());

		makeMenu();
		Play();

		f.setVisible(true);
	}

	/**
	 * Makes the menu for the simulation.
	 */
	public void makeMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Game Menu");

		// exit option
		JMenuItem play = new JMenuItem("play");
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				resetStore();
			}
		});
		menu.add(play);
		
		JMenuItem toturial = new JMenuItem("toturial");
		toturial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		menu.add(toturial);
		
		JMenuItem reset = new JMenuItem("reset");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				resetStore();
			}
		});
		menu.add(reset);
		
		menuBar.add(menu);
		f.setJMenuBar(menuBar);
	}

	/**
	 * Makes the buttons for the store grid.
	 */
	public void makeStorePanel() {
		if (store == null)
			return;
		if (displayPanel != null)
			f.remove(displayPanel);

		displayPanel = new JPanel();
		displayPanel.setLayout(new GridLayout(7, 7));

		// add store grid
		for (int p = 0; p < MAX_TILE_DISPLAY; p++) {
			PersonButton b = new PersonButton(p);
			b.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
			b.setMargin(new Insets(0, 0, 0, 0));
			b.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
			b.setFocusPainted(false);
			b.setContentAreaFilled(true);
			b.setBackground(Color.CYAN);
			if (p == 0 || p == 1 || p == 5 || p == 6 || p == 7 || p == 13 || p == 35 || p == 41 || p == 42 || p == 43
					|| p == 47 || p == 48) {
				b.setBackground(Color.yellow);
			}
			if (p == 24) {
				b.setBackground(Color.red);
			}
			displayPanel.add(b);
		}
		f.add(displayPanel, 0);
		f.revalidate();
	}

	public void updateStorePanel(String string) {
		if (store == null)
			return;
		if (displayPanel != null)
			f.remove(displayPanel);

		displayPanel = new JPanel();
		displayPanel.setLayout(new GridLayout(7, 7));

		// add store grid
		for (int l = 0; l < MAX_TILE_DISPLAY; l++) {
			PersonButton b = new PersonButton(l);
			b.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
			b.setMargin(new Insets(0, 0, 0, 0));
			b.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
			b.setFocusPainted(false);
			b.setContentAreaFilled(true);
			b.setBackground(Color.CYAN);
			// if((&& (l == 0 || l == 1 || l == 5 || l == 6) || (p == 1 && (l == 0 || l ==
			// 6)) || (p == 5 && (l == 0 || l == 6)) || (p == 6 && (l == 0 || l == 1 || l ==
			// 5 || l == 6)))) {
			// b.setBackground(Color.green);
			// }
			// if(p == 3 && l == 3) {
			// b.setBackground(Color.red);
			displayPanel.add(b);
		}
		f.add(displayPanel, 0);
		f.revalidate();
	}

	/**
	 * Makes the panel containing the step, reset, and play buttons.
	 */
	public void makeBottomButtons() {
		if (store == null)
			return;
		if (buttonPanel != null)
			f.remove(buttonPanel);

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(2, 3));

		JButton n = new JButton(" ");
		n.setEnabled(false);
		buttonPanel.add(n);

		JButton up = new JButton("up");
		up.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				up();
			}
		});
		buttonPanel.add(up);

		JButton a = new JButton(" ");
		a.setEnabled(false);
		buttonPanel.add(a);

		JButton left = new JButton("left");
		left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				left();
			}
		});
		buttonPanel.add(left);

		JButton down = new JButton("down");
		down.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				down();
			}
		});
		buttonPanel.add(down);

		JButton right = new JButton("right");
		right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				right();
			}
		});
		buttonPanel.add(right);
		// step button
		/*JButton Play = new JButton("Play");
		Play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Play();
			}
		});
		buttonPanel.add(Play);

		// reset button
		JButton Tutorial = new JButton("Tutorial");
		buttonPanel.add(Tutorial);

		// play button
		JButton Reset = new JButton("Reset");
		buttonPanel.add(Reset);*/

		/*play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// toggle playing and not playing
				playing = !playing;
				// buttonPanel.getComponent(0).setEnabled(!playing);
				// buttonPanel.getComponent(1).setEnabled(!playing);
				((JButton) buttonPanel.getComponent(8)).setText((playing ? "Stop" : "Play"));

				// if playing, kick off a timer to drop dots and step them
				if (playing) {
					new javax.swing.Timer(200, new ActionListener() {
						public void actionPerformed(ActionEvent event) {
							// someone hit the stop button
							if (!playing) {
								((javax.swing.Timer) event.getSource()).stop();
								return;
							} else {
								step();
							}
						}
					}).start();
				}
			}
		});
		buttonPanel.add(play);*/

		f.add(buttonPanel, 1);
		f.revalidate();
	}
	/**
	 * Calls the step button on the simulation and updates the GUI to display the
	 * result.
	 * 
	 * @return whether or not the simulation was able to step
	 */
	
	public void up() {

	}

	public void left() {
	}

	public void down() {

	}

	public void right() {

	}

	public void step() {

	}

	public void Play() {
		resetStore();
	}
	public void makeScore() {
		if (store == null)
			return;
		if (scorePanel != null)
			f.remove(scorePanel);
		
		scorePanel = new JPanel();
		scorePanel.setLayout(new GridLayout(2, 1));
		
		JButton player1 = new JButton("player 1 score: 0");
		//player1.setEnabled(false);
		scorePanel.add(player1);
		
		JButton player2 = new JButton("player 2 score: 0");
		//player2.setEnabled(false);
		scorePanel.add(player2);
		
		f.add(scorePanel, 2);
		f.revalidate();
	}
	
	/**
	 * Load a new simulation.
	 */
	public void resetStore() {
		store = new GroceryStore();
		makeStorePanel();
		makeBottomButtons();
		makeScore();
		
	}

	/**
	 * A main method to run the simulation with GUI.
	 * 
	 * @param args
	 *            [0] = the seed for the store's random number generator
	 */
	public static void main(String[] args) {
		new GUI();
	}

	/**
	 * Inner class representing an arrow (will display if this line is the
	 * "smallest" based on the priority queue.
	 */

	/**
	 * Inner class representing a single person in line.
	 */
	class PersonButton extends JButton {
		/**
		 * Place in line.
		 */
		private int place;

		/**
		 * Set the text to whatever the grid thinks it should be.
		 * 
		 * @param line
		 *            what line the person is in
		 * @param place
		 *            what spot in line the person is in
		 */
		public PersonButton(int place) {
			super("");
			this.place = place;
			update();
		}

		/**
		 * Update the text to reflect the current state of the simulation for this
		 * location.
		 */
		public void update() {
			// int numItems = store.getPersonItems(line, place);
			// System.out.println(numItems);
			if (this.place == 0) {
				setText(" 1 ");
			} else if (this.place == 48) {
				setText(" 2 ");
			} else
				setText("");
		}
	}
}