/**
 * 
 */
package asgn2GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author hogan
 *
 */
public class DumbGrapicsExample extends JFrame implements ActionListener {

	private static final long serialVersionUID = -7031008862559936404L;
	public static final int WIDTH = 300;
	public static final int HEIGHT = 200;

	private JPanel btmPanel;
	private Canvas drawPanel;
	 
	/**
	 * @param arg0
	 * @throws HeadlessException
	 */
	public DumbGrapicsExample(String arg0) throws HeadlessException {
		super(arg0);
		createGUI();
	}
	
	private void createGUI() {
		setSize(WIDTH, HEIGHT);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLayout(new BorderLayout());

	    drawPanel = new Canvas();
	    drawPanel.setBackground(Color.LIGHT_GRAY);
	    
	    add(drawPanel,BorderLayout.CENTER);

	    btmPanel = new JPanel();
	    btmPanel.setBackground(Color.LIGHT_GRAY);
        btmPanel.setLayout(new FlowLayout());

	    JButton loadButton = new JButton("Rect");
	    loadButton.setBackground(Color.WHITE);
	    loadButton.addActionListener(this);
	    btmPanel.add(loadButton);

	    JButton unLoadButton = new JButton("Square");
	    unLoadButton.setBackground(Color.WHITE);
	    unLoadButton.addActionListener(this);
	    btmPanel.add(unLoadButton);

	    JButton findButton = new JButton("String");
	    findButton.setBackground(Color.WHITE);
	    findButton.addActionListener(this);
	    btmPanel.add(findButton);

	    this.getContentPane().add(btmPanel, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
	  String buttonString = e.getActionCommand();

	  if (buttonString.equals("Rect")) {
		 drawPanel.figure=Canvas.RECTANGLE;
	     drawPanel.repaint();
	  } else if (buttonString.equals("Square")) {
		 drawPanel.figure=Canvas.SQUARE;
		 drawPanel.repaint();
	  } else if (buttonString.equals("String")) {
		 drawPanel.figure=Canvas.STRING;
		 drawPanel.repaint();
	  } else {
	     System.err.println("Unexpected Error");
	  }
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DumbGrapicsExample gui = new DumbGrapicsExample("DumbGraphicsExample");
	    gui.setVisible(true);

	}
}
