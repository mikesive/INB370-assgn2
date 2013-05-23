package asgn2GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
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

	public BufferedImage image;
	
	public GUIGraphics(int CarriageType) {
		try {
			if (CarriageType == LOCOMOTIVE) {
				image = ImageIO.read(new File("Locomotive.jpg"));
			}
			else if (CarriageType == FREIGHTCAR) {
				image = ImageIO.read(new File("FreightCar.jpg"));
			}
			else if (CarriageType == PASSENGERCAR) {
				image = ImageIO.read(new File("PassengerCar.jpg"));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
	}
	
}
