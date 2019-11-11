package vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import control.Control;
import model.Case;

public class VueJeu extends JPanel {
	
	private KeyListener keyListener;
	private String playerDecision;
	private JButton exitBtn;
	

	public VueJeu() {
		this.setLayout(null);
		this.setBackground(Color.BLUE);
		
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
					playerDecision = "moveUp";
					break;
				case KeyEvent.VK_DOWN:
					playerDecision = "moveDown";

					break;

				case KeyEvent.VK_RIGHT:
					playerDecision = "moveRight";

					break;
				case KeyEvent.VK_LEFT:
					playerDecision = "moveLeft";

					break;
				case KeyEvent.VK_ESCAPE:
					System.exit(0);
					break;
				default:
					;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyTyped(KeyEvent e) {

			}

		});
		this.setFocusable(true);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		paintBoard(g);
		try {
			Thread.sleep(1000); //ms
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		repaint();


	}
	
	public void paintBoard(Graphics g) {
		Case[][] board = Control.board.getBoard();
		for(int i=0; i<board[0].length;i++) {
			for(int j=0;j<board.length;j++) {
				ImageIcon decor = new ImageIcon(board[i][j].getDecor().getImageURL());
				Image imgD = decor.getImage();
				g.drawImage(imgD,i*Control.getTailleCase(),j*Control.getTailleCase(),Control.getTailleCase()*3,Control.getTailleCase()*3,null); //x,y,largueur, hauteur,null	
				ImageIcon unit = new ImageIcon(board[i][j].getDecor().getImageURL());
				Image imgU = unit.getImage();
				g.drawImage(imgU,i*Control.getTailleCase(),j*Control.getTailleCase(),Control.getTailleCase()*3,Control.getTailleCase()*3,null); //x,y,largueur, hauteur,null	
			}
		}
		
	}
}
