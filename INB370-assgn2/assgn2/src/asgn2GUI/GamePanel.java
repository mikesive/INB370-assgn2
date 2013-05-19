package asgn2GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GamePanel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel locomotivePanel;
	private JPanel passengerCarpanel;
	private JPanel frieghtCarpanel;
	
	public GamePanel(){
        super("Train Configuration");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        locomotivePanel = new JPanel(new BorderLayout());
        locomotivePanel.setBorder(BorderFactory.createLineBorder(Color.black));        
        locomotivePanel.setLayout(new FlowLayout());
        //locomotivePanel.setLocation(100, 100);

        add(locomotivePanel,BorderLayout.SOUTH);
        
        // Display the window.
        setPreferredSize(new Dimension(1000, 600));
        setLocation(new Point(100, 50));
        pack();
        setVisible(true);
	}
	
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        new GamePanel();

    }
}
