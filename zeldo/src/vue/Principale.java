	package vue;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import control.Control;

// Version 1.1.2 Operationnelle

public class Principale {

	private static JFrame frame;

	private static VueMenuStart start;

	public static void main(String[] args) {
		
		frame = new JFrame();
		start = new VueMenuStart();

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int gamescreenHeight = (int) (screenSize.height*0.8)+80 - (int) (screenSize.height*0.8)%80;		
		int gamescreenWidth = (int) (screenSize.width*0.8)+80 - (int) (screenSize.width*0.8)%80;
		
		Control.getInstance().initPlateau(gamescreenWidth,gamescreenHeight);
		Control.getInstance().placerHero();
		// Control is an illusion
		
		frame.setPreferredSize(new Dimension(gamescreenWidth, gamescreenHeight));
		frame.setLocation(10, 10);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ferme la fenetre = ferme la console
		frame.setUndecorated(true); // enleve la barre reduire agrandir fermer et empeche le resize

		frame.setContentPane(start);

		frame.setVisible(true); // voir la fenetre
		frame.pack(); // ca MARCHE

	}

	public static JFrame getFrame() { // attention au object
		return frame;
	}

}
