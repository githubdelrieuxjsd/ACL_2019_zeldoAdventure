package vue;

import java.awt.Dimension;

import javax.swing.JFrame;

import control.Control;

public class Principale {

	private static JFrame frame;

	private static VueMenuStart start;

	public static void main(String[] args) {

		frame = new JFrame();
		start = new VueMenuStart();

		Control.initPlateau(800, 800);
		frame.setPreferredSize(new Dimension(800, 800));
		frame.setLocation(10, 20);

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
