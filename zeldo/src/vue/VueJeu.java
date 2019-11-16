package vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.Control;
import model.Case;

public class VueJeu extends JPanel {

	private KeyListener keyListener;
	private VueMenuStart vueStart;
	private String playerDecision = "nothing";
	private JButton exitBtn;

	public VueJeu() {
		
		this.setLayout(null);
		this.setBackground(Color.BLUE);
		this.setBackground(new Color(147, 117, 56));


		this.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {

				switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
					playerDecision = Control.verifierPlayerDecision("moveUp");
					break;
				case KeyEvent.VK_DOWN:
					playerDecision = Control.verifierPlayerDecision("moveDown");
					break;
				case KeyEvent.VK_RIGHT:
					playerDecision = Control.verifierPlayerDecision("moveRight");
					break;
				case KeyEvent.VK_LEFT:
					playerDecision = Control.verifierPlayerDecision("moveLeft");
					break;
					
				case KeyEvent.VK_ESCAPE:
					vueStart = new VueMenuStart(); //revenir sur le menu start avec escape
					exitJeu();
					break;

				case KeyEvent.VK_Z:
					playerDecision = Control.verifierPlayerDecision("attack");
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
		this.setFocusable(true); // important pour le bon fonctionnement
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		paintBoard(g);
		
		// # 
		playerDecision = Control.action(this.playerDecision);
		
		try {
			Thread.sleep(32); // ms
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		repaint();

	}

	public void paintBoard(Graphics g) {
		Case[][] board = Control.board.getBoard();
		for (int i = 0; i < Control.board.getNbCaseHorizontal() ; i++) {
			for (int j = 0; j <Control.board.getNbCaseVertical() ; j++) {
				ImageIcon decor = new ImageIcon(board[i][j].getDecor().getImageURL());
				Image imgD = decor.getImage();
				g.drawImage(imgD, (i-1) * Control.getTailleCase(), (j-1) * Control.getTailleCase(), Control.getTailleCase()*3,
						Control.getTailleCase() *3, null); // x,y,largueur, hauteur,null
				
				ImageIcon unit = new ImageIcon(board[i][j].getUnit().getImageURL());
				Image imgU = unit.getImage();
				g.drawImage(imgU, (i-1) * Control.getTailleCase(), (j-1) * Control.getTailleCase(), Control.getTailleCase() * 3,
						Control.getTailleCase() * 3, null); // x,y,largueur, hauteur,null
			}
		}

	}
	
	private void exitJeu() {
		Principale.getFrame().setContentPane(vueStart);
		Principale.getFrame().pack();
		this.updateUI();
		vueStart.requestFocus();
		
	}
}
