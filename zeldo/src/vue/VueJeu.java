package vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
				ImageIcon decor = new ImageIcon(board[i][j].getDecors().getImageURL());
				Image imgD = decor.getImage();
				g.drawImage(imgD,i*30,j*30,60*3,60*3,null); //x,y,largueur, hauteur,null	
				ImageIcon unit = new ImageIcon(board[i][j].getDecors().getImageURL());
				Image imgU = unit.getImage();
				g.drawImage(imgU,i*30,j*30,60*3,60*3,null); //x,y,largueur, hauteur,null	
			}
		}
		
	}
}
