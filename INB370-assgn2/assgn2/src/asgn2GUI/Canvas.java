package asgn2GUI;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Canvas extends JPanel {
	public static final int LOCOMOTIVE=0;
	public static final int PASSENGERCAR=1;
	public static final int FREIGHTCAR=2;
	public int figure=0; 
	
	public Canvas(){ 
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); 
		switch(this.figure) {
		case LOCOMOTIVE:
		  g.setColor(Color.BLUE);
		  g.drawRect(20, 20, 200, 100);
		  g.fillRect(20, 20, 200, 100);
		  break; 
		case PASSENGERCAR:
			g.setColor(Color.RED);
			  g.drawRect(20, 20, 200, 100);
			  g.fillRect(20, 20, 200, 100);
		  break;
		case FREIGHTCAR:
			g.setColor(Color.GRAY);
			  g.drawRect(20, 20, 200, 100);
			  g.fillRect(20, 20, 200, 100);
		  break;
		}
	}

}
