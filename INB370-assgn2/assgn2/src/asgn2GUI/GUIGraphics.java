package asgn2GUI;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GUIGraphics extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2269823114650466576L;

	public static final int LOCOMOTIVE = 0;
	public static final int PASSENGERCAR = 1;
	public static final int FREIGHTCAR = 2;
	public int figure = 0;

	public GUIGraphics() {
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		switch (this.figure) {
		case 0: {
			g.setColor(Color.YELLOW);
			g.drawRect(20, 20, 200, 100);
			g.fillRect(20, 20, 200, 100);
			break;
		}
		case 1: {
			g.setColor(Color.RED);
			g.drawRect(20, 20, 200, 100);
			g.fillRect(20, 20, 200, 100);
			break;
		}
		case 2: {
			g.setColor(Color.BLACK);
			g.drawRect(20, 20, 200, 100);
			g.fillRect(20, 20, 200, 100);
			break;
		}
		}
	}
}
