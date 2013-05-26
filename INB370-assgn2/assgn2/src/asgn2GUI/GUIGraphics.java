package asgn2GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GUIGraphics extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2269823114650466576L;

	public static final int LOCOMOTIVE = 0;
	public static final int PASSENGERCAR = 1;
	public static final int FREIGHTCAR = 2;

	private BufferedImage image;

	public GUIGraphics() {
		try {
			image = ImageIO.read(new File("FreightCar.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (image != null) {

			int x = (getWidth() - image.getWidth()) / 2;
			int y = (getHeight() - image.getHeight()) / 2;

			g.drawImage(image, x, y, this);

		}
	}
}
