package stickcode;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Window extends Canvas {

	private static final long serialVersionUID = -9002890860531122083L;

	public Window(int width,int height, String title,Game game) {
		JFrame frame = new JFrame(title);
		Dimension d = new Dimension(width,height);
		frame.setPreferredSize(d); // change later
		frame.setMaximumSize(d); // change later
		frame.setMinimumSize(d);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(game);
		frame.setVisible(true);
		game.start();
	}
	
}
