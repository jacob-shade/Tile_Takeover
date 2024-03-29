
//graphics packages
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI {
	private JFrame f;
	private JPanel displayPanel = null;
	private JPanel buttonPanel = null;
	private JPanel scorePanel = null;
	private final int BUTTON_WIDTH = 80;
	private final int BUTTON_HEIGHT = 80;
	private final int MAX_TILE_DISPLAY = 49;
	private Board<Tile> board = new Board<Tile>();
	private Board<Tile> boardcopy = board;

	public GUI() {
		f = new JFrame("Tile Takeover");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(720, 720);
		f.getContentPane().setLayout(new FlowLayout());
		makeMenu();
		reset();
		f.setVisible(true);
	}

	public void makeMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Game Menu");
		JMenuItem play = new JMenuItem("Start Over");
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				resetStore();
			}
		});
		menu.add(play);
		JMenuItem toturial = new JMenuItem("Tutorial");
		toturial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				tutorial();
			}
		});
		menu.add(toturial);
		JMenuItem reset = new JMenuItem("Reset");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				reset();
			}
		});
		menu.add(reset);

		menuBar.add(menu);
		f.setJMenuBar(menuBar);
	}

	protected void reset() {
		makeStorePanel();
		makeBottomButtons();
		makeScore();
	}

	protected void tutorial() {
		new TGUI();
	}

	public void makeStorePanel() {
		if (displayPanel != null)
			f.remove(displayPanel);
		displayPanel = new JPanel();
		displayPanel.setLayout(new GridLayout(7, 7));
		board = new Board<Tile>();
		for (int p = 0; p < MAX_TILE_DISPLAY; p++) {
			Tile b = (Tile) (board.getBoard())[p];
			b.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
			b.setMargin(new Insets(0, 0, 0, 0));
			b.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
			b.setFocusPainted(false);
			b.setContentAreaFilled(true);
			b.setText(b.getPlayer());
			b.setBackground(b.getColor());
			b.setOpaque(true);
			displayPanel.add(b);
		}
		f.add(displayPanel, 0);
		f.revalidate();
	}

	public void update() {
		if (displayPanel != null)
			f.remove(displayPanel);
		displayPanel = new JPanel();
		displayPanel.setLayout(new GridLayout(7, 7));
		for (int p = 0; p < MAX_TILE_DISPLAY; p++) {
			Tile b = (Tile) (board.getBoard())[p];
			b.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
			b.setMargin(new Insets(0, 0, 0, 0));
			b.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
			b.setFocusPainted(false);
			b.setContentAreaFilled(true);
			b.setText(b.getPlayer());
			b.setBackground(b.getColor());
			b.setOpaque(true);
			displayPanel.add(b);
		}
		f.add(displayPanel, 0);
		f.revalidate();
		makeScore();
	}

	public void makeBottomButtons() {
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
		f.add(buttonPanel, 1);
		f.revalidate();
	}

	public void up() {
		board.setBoard(board.up(board));
		update();
		scoreup();
	}

	public void left() {
		board.setBoard(board.left(board));
		update();
		scoreup();
	}

	public void down() {
		board.setBoard(board.down(board));
		update();
		scoreup();

	}

	public void right() {
		board.setBoard(board.right(board));
		update();
		scoreup();
	}

	public void Play() {
		resetStore();
	}

	private void scoreup() {
		String winner = null;
		int x = board.getP1score();
		int y = board.getP2score();
		winner = board.win(board);
		if(winner == "player 1") {
			x++;
			board.setP1score(x);
			board.setBoard(boardcopy.getBoard());
			board.setTurn(boardcopy.getTurn());
			update();
		}else if(winner == "player 2") {
			y++;
			board.setP2score(y);
			board.setBoard(boardcopy.getBoard());
			board.setTurn(boardcopy.getTurn());
			update();
		}
	}
	
	public void makeScore() {
		if (scorePanel != null)
			f.remove(scorePanel);

		scorePanel = new JPanel();
		scorePanel.setLayout(new GridLayout(2, 1));

		JButton player1 = new JButton("player 1 score: " + board.getP1score() );
		scorePanel.add(player1);

		JButton player2 = new JButton("player 2 score: " + board.getP2score() );
		scorePanel.add(player2);

		f.add(scorePanel, 2);
		f.revalidate();
	}

	public void resetStore() {
		int x = board.getP1score();
		int y = board.getP2score();
		makeStorePanel();
		board.setP1score(x);
		board.setP2score(y);
		makeBottomButtons();
		makeScore();
	}

	public static void main(String[] args) {
		new GUI();
	}

	public Board<Tile> getBoard() {
		return board;
	}

	public void setBoard(Board<Tile> board) {
		this.board = board;
	}

}