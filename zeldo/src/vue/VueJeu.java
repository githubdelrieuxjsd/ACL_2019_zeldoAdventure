package vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class VueJeu extends JPanel {
	
	private KeyListener keyListener;
	private String playerDecision;
	private JButton exitBtn;
	

	public VueJeu() {
		this.setLayout(null);
		this.setBackground(Color.BLUE);
		
		exitBtn = new JButton("Exit");
		exitBtn.setBounds(700,10,90,50);
		exitBtn.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				}
		}); 
		this.add(exitBtn);	
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		try {
			Thread.sleep(1000); //ms
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		repaint();


	}
	
	public void paintBoard() {
		
	}
}
