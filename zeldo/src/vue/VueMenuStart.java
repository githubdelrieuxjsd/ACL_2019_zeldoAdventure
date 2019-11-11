package vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VueMenuStart extends JPanel {

	private JLabel titreJeuLbl;
	private JButton playBtn;
	private JButton exitBtn;
	private VueJeu jeuPane;

	public VueMenuStart() {
		this.setLayout(null); // poser element n'importe ou
		this.setBackground(Color.GREEN);
		
		ajout();
	}

	private void ajout() {
		jeuPane= new VueJeu();
		titreJeuLbl = new JLabel("Zeldo Adventure");
		playBtn = new JButton("Start");
		exitBtn = new JButton("Exit");
		
		titreJeuLbl.setBounds(250,250,300,70); //x,y,largeur,hauteur
		titreJeuLbl.setFont(new Font("Segoe Script",Font.BOLD, 30)); //taille
		this.add(titreJeuLbl);
		
		playBtn.setBounds(250,350,300,70);
		playBtn.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				startJeu();
			}
		}); 
		this.add(playBtn);		
		
		exitBtn.setBounds(700,10,90,50);
		exitBtn.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setBackground(Color.RED);
				exitJeu();
			}
		}); 
		this.add(exitBtn);	
	}
	
	private void startJeu() {
		remove();
		Principale.getFrame().setContentPane(jeuPane); //donner panneau jeu dans principale frame
		Principale.getFrame().pack();
		this.updateUI(); //update principale frame
		jeuPane.requestFocus(); // important pour focus le clavier
		
	}
	
	private void exitJeu() {
		remove();
		System.exit(0);
	}
	
	private void remove() {
		remove(titreJeuLbl);
		remove(playBtn);
		remove(exitBtn);
	}
	
	
}
