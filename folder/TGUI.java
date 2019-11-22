import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TGUI {
	private JFrame ft;
	private JPanel displayPanel = null;
	private JPanel buttonPanel = null;
	private JPanel commentPanel = null;
	private final int BUTTON_WIDTH = 80;
	private final int BUTTON_HEIGHT = 80;
	private final int MAX_TILE_DISPLAY = 49;
	//private GroceryStore<TileButton> board = new GroceryStore<TileButton>();
	private lines l = new lines();
	private int counter = 0;
	private int walkc = 4;
	
	public TGUI() {
		ft = new JFrame("Tutorial");
		ft.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ft.setSize(720, 720);
		ft.getContentPane().setLayout(new FlowLayout());
		reset();
		ft.setVisible(true);
	}
	
	protected void reset() {
		makeTPanel(l.getTboard()[0]);
		makeTButtons();
		makeTComment();
	}
	
	private void makeTComment() {
		if (commentPanel != null)
			ft.remove(commentPanel);
		commentPanel = new JPanel();
		commentPanel.setLayout(new GridLayout(1, 1));
		TileButton text = new TileButton();
		text.setPreferredSize(new Dimension(700, 100));
		text.setText(l.getLines()[0]);
		text.setHorizontalAlignment(SwingConstants.CENTER);

		commentPanel.add(text);
		
		ft.add(commentPanel, 2);
		ft.revalidate();
	}

	public void makeTPanel(GroceryStore<TileButton> groceryStore) {
		if (displayPanel != null)
			ft.remove(displayPanel);
		displayPanel = new JPanel();
		displayPanel.setLayout(new GridLayout(7, 7));
		for (int p = 0; p < MAX_TILE_DISPLAY; p++) {
			TileButton b = (TileButton) groceryStore.getBoard()[p];
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
		ft.add(displayPanel, 0);
		ft.revalidate();
	}
	
	public void makeTButtons() {
		if (buttonPanel != null)
			ft.remove(buttonPanel);

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 2));

		JButton n = new JButton(" <-");
		n.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				n();
			}
		});
		buttonPanel.add(n);
		
		JButton m = new JButton(" ->");
		m.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				m();
			}
		});
		if(counter == 0) {
			n.setEnabled(false);
		}else if(counter == 15) {
			m.setEnabled(false);
		}
		buttonPanel.add(m);
		ft.add(buttonPanel, 1);
		ft.revalidate();
	}

	protected void m() {
		counter++;
		if (counter == 4) {
			walkc = 4;
			new javax.swing.Timer(400, new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					if (counter != 4) {
						((javax.swing.Timer) event.getSource()).stop();
						return;
					} else {
						step();
					}
				}
				private void step() {
					walkc++;
					String temp = (l.getLines())[walkc];
					updateComment(temp);
					makeTButtons();
					makeTPanel((l.getTboard())[walkc]);
					if(walkc >= 7) {
						walkc -= 4;
					}
				}
			}).start();
		}else if(counter == 5) {
			counter = 8;
		}else if(counter == 9) {
			walkc = 9;
			new javax.swing.Timer(400, new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					if (counter != 9) {
						((javax.swing.Timer) event.getSource()).stop();
						return;
					} else {
						step();
					}
				}
				private void step() {
					walkc++;
					String temp = (l.getLines())[walkc];
					updateComment(temp);
					makeTButtons();
					makeTPanel((l.getTboard())[walkc]);
					if(walkc >= 14) {
						walkc -= 6;
					}
				}
			}).start();
		}else if(counter == 10) {
			counter = 15;
		}
		String temp = (l.getLines())[counter];
		updateComment(temp);
		makeTButtons();
		makeTPanel((l.getTboard())[counter]);
	}

	private void updateComment(String temp) {
		if (commentPanel != null)
			ft.remove(commentPanel);
		commentPanel = new JPanel();
		commentPanel.setLayout(new GridLayout(1, 1));
		TileButton text = new TileButton();
		text.setPreferredSize(new Dimension(700, 100));
		text.setText(temp);
		text.setHorizontalAlignment(SwingConstants.CENTER);
		commentPanel.add(text);
		ft.add(commentPanel, 2);
		ft.revalidate();
		
	}

	protected void n() {
		counter--;
		if(counter == 7) {
			counter = 4;
		}else if(counter == 14) {
			counter = 9;
		}
		if (counter == 4) {
			walkc = 4;
			new javax.swing.Timer(400, new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					if (counter != 4) {
						((javax.swing.Timer) event.getSource()).stop();
						return;
					} else {
						step();
					}
				}
				private void step() {
					walkc++;
					String temp = (l.getLines())[walkc];
					updateComment(temp);
					makeTButtons();
					makeTPanel((l.getTboard())[walkc]);
					if(walkc >= 7) {
						walkc -= 4;
					}
				}
			}).start();
		}
		if(counter == 9) {
			walkc = 9;
			new javax.swing.Timer(400, new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					if (counter != 9) {
						((javax.swing.Timer) event.getSource()).stop();
						return;
					} else {
						step();
					}
				}
				private void step() {
					walkc++;
					String temp = (l.getLines())[walkc];
					updateComment(temp);
					makeTButtons();
					makeTPanel((l.getTboard())[walkc]);
					if(walkc >= 14) {
						walkc -= 6;
					}
				}
			}).start();
		}
		String temp = (l.getLines()[counter]);
		updateComment(temp);
		makeTButtons();
		makeTPanel((l.getTboard())[counter]);
	}
}
