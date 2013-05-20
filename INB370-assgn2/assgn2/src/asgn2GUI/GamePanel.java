package asgn2GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class GamePanel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//gui components
	private JPanel locomotivePanel;
	private JPanel passengerCarPanel;
	private JPanel frieghtCarPanel;
	private JButton submitLocomotive;
	private JLabel locomotiveWeightLabel;
	private JLabel locomotiveEngineType;
	private JLabel locomotiveEnginePower;
	private JTextField locomotiveWeightField;
	private JTextField locomotivePowerField;

	public GamePanel() {
		super("Train Configuration");
		
		initializeComponents();
		
	}
		private void initializeComponents(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);

		// setup locomotive Panel
		locomotivePanel = new JPanel(null);
		locomotivePanel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "Locomotive"));
		locomotivePanel.setLocation(0, 366);
		locomotivePanel.setSize(326, 200);

		//locomotive panel components
		submitLocomotive = new JButton("Submit Locomotive");
		submitLocomotive.setSize(200, 30);
		submitLocomotive.setLocation(63, 20);
		locomotiveWeightLabel = new JLabel("Weight");
		locomotiveWeightLabel.setBounds(63, 55, 100, 30);
		locomotiveWeightField = new JTextField(20);
		locomotiveWeightField.setBounds(150, 55, 113, 30);
		locomotiveEnginePower = new JLabel("Engine Power");
		locomotiveEnginePower.setBounds(63, 90, 100, 30);
		locomotivePowerField = new JTextField(1);
		locomotivePowerField.setBounds(150, 90, 113, 30);
		locomotiveEngineType = new JLabel("Engine Type");
		locomotiveEngineType.setBounds(63, 125, 100, 30);
		
		
		
		
		
		locomotivePanel.add(submitLocomotive);
		locomotivePanel.add(locomotiveWeightLabel);
		locomotivePanel.add(locomotiveWeightField);
		locomotivePanel.add(locomotiveEnginePower);
		locomotivePanel.add(locomotivePowerField);
		locomotivePanel.add(locomotiveEngineType);
		
		

		// Set up passenger car panel
		passengerCarPanel = new JPanel(null);
		passengerCarPanel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "Passenger Car"));
		passengerCarPanel.setLocation(332, 366);
		passengerCarPanel.setSize(326, 200);

		// setup submit passenger car button
		JButton submitPassengerCar = new JButton("Submit Passenger Car");
		submitPassengerCar.setSize(200, 30);

		passengerCarPanel.add(submitPassengerCar);

		// Set up freight car panel
		frieghtCarPanel = new JPanel(null);
		frieghtCarPanel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "Freight Car"));
		frieghtCarPanel.setLocation(664, 366);
		frieghtCarPanel.setSize(326, 200);

		// setup submit freight car button
		JButton submitFreightCar = new JButton("Submit Freight Car");
		submitFreightCar.setSize(200, 30);

		frieghtCarPanel.add(submitFreightCar);

		add(locomotivePanel);
		add(passengerCarPanel);
		add(frieghtCarPanel);

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
