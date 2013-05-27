package asgn2GUI;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import asgn2Exceptions.TrainException;
import asgn2RollingStock.FreightCar;
import asgn2RollingStock.Locomotive;
import asgn2RollingStock.PassengerCar;
import asgn2RollingStock.RollingStock;
import asgn2Train.DepartingTrain;

public class GamePanel extends JFrame implements ActionListener {

	/**
	 * This class creates a Graphical User Interface to build a train consisting
	 * of different carriage types, and to board passengers.
	 * 
	 * @author Wayne Maxwell
	 * @author Michael Sive
	 */
	private static final long serialVersionUID = 1L;

	// gui components
	private JPanel locomotivePanel;
	private JPanel passengerCarPanel;
	private JPanel freightCarPanel;
	private JPanel boardingPanel;
	private JPanel imagePanel;
	private JButton submitLocomotive;
	private JButton submitPassengerCar;
	private JButton submitFreightCar;
	private JButton submitBoardPassengers;
	private JButton resetTrain;
	private JButton removeCarriage;
	private JLabel locomotiveWeightLabel;
	private JLabel locomotiveEngineType;
	private JLabel locomotiveEnginePower;
	private JLabel passengerCarWeightLabel;
	private JLabel passengerCarSeatsLabel;
	private JLabel freightCarWeightLabel;
	private JLabel freightTypeLabel;
	private JLabel numberOfPassengersLabel;
	private JLabel passengersVsSeatsLabel;
	private JLabel leftOverPassengersLabel;
	private JLabel canTrainMoveLabel;
	private JTextField locomotiveWeightField;
	private JTextField locomotivePowerField;
	private JTextField passengerCarWeightField;
	private JTextField passengerCarSeatsField;
	private JTextField freightCarWeightField;
	private JTextField numberOfPassengersField;
	private JComboBox locomotiveEngineTypeSelect;
	private JComboBox freightTypeSelect;
	private JTextArea displayText;
	private JScrollPane textTrainConfiguration;
	private JScrollPane graphicalTrainConfiguration;
	private DepartingTrain train;
	private final int ELECTRIC = 0;
	private final int DIESEL = 1;
	private final int STEAM = 2;
	private final int GENERAL = 0;
	private final int REFRIGERATED = 1;
	private final int DANGEROUS = 2;
	private final String DANGEROUSSTRING = "D";
	private final String GENERALSTRING = "G";
	private final String REFRIGERATEDSTRING = "R";
	private final String ELECTRICSTRING = "E";
	private final String DIESELSTRING = "D";
	private final String STEAMSTRING = "S";
	private ArrayList<Canvas> canvasArray;

	/**
	 * Constructor setup interface and initialize the game
	 * 
	 */
	public GamePanel() {
		super("Train Configuration");
		initializeComponents();
	}

	/**
	 * Constructs the GUI interface with its various components
	 * 
	 */
	private void initializeComponents() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);

		// setup text display
		displayText = new JTextArea();
		displayText.setEditable(false);
		displayText.setLineWrap(true);
		displayText.setFont(new Font("Arial", Font.BOLD, 14));
		displayText.setBorder(BorderFactory.createEtchedBorder());
		textTrainConfiguration = new JScrollPane(displayText);
		textTrainConfiguration.setSize(750, 150);
		textTrainConfiguration.setLocation(3, 180);

		// setup graphical display
		imagePanel = new JPanel(new FlowLayout());
		graphicalTrainConfiguration = new JScrollPane(imagePanel);
		graphicalTrainConfiguration.setSize(750, 170);
		graphicalTrainConfiguration.setLocation(3, 3);

		// set up frame controls
		resetTrain = new JButton("Reset Train");
		resetTrain.addActionListener(this);
		resetTrain.setSize(200, 30);
		resetTrain.setLocation(547, 331);
		removeCarriage = new JButton("Remove Carriage");
		removeCarriage.addActionListener(this);
		removeCarriage.setSize(200, 30);
		removeCarriage.setLocation(342, 331);
		canTrainMoveLabel = new JLabel("Train Can Move:");
		canTrainMoveLabel.setBounds(100, 331, 200, 30);

		// setup boarding Panel
		boardingPanel = new JPanel(null);
		boardingPanel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "Board Passengers"));
		boardingPanel.setLocation(750, 0);
		boardingPanel.setSize(239, 365);

		// boarding panel components
		submitBoardPassengers = new JButton("Board");
		submitBoardPassengers.addActionListener(this);
		submitBoardPassengers.setSize(100, 30);
		submitBoardPassengers.setLocation(70, 20);
		passengersVsSeatsLabel = new JLabel("Passengers/Seats: 0/0");
		passengersVsSeatsLabel.setBounds(20, 55, 200, 30);
		leftOverPassengersLabel = new JLabel("Passengers Left Over: 0");
		leftOverPassengersLabel.setBounds(20, 90, 200, 30);
		numberOfPassengersLabel = new JLabel("Number To Board");
		numberOfPassengersLabel.setBounds(20, 125, 100, 30);
		numberOfPassengersField = new JTextField(1);
		numberOfPassengersField.setBounds(125, 125, 100, 30);

		// add boarding panel items
		boardingPanel.add(submitBoardPassengers);
		boardingPanel.add(passengersVsSeatsLabel);
		boardingPanel.add(leftOverPassengersLabel);
		boardingPanel.add(numberOfPassengersLabel);
		boardingPanel.add(numberOfPassengersField);

		// setup locomotive Panel
		locomotivePanel = new JPanel(null);
		locomotivePanel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "Locomotive"));
		locomotivePanel.setLocation(0, 366);
		locomotivePanel.setSize(326, 200);

		// locomotive panel components
		submitLocomotive = new JButton("Submit Locomotive");
		submitLocomotive.addActionListener(this);
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
		locomotiveEngineTypeSelect = new JComboBox();
		locomotiveEngineTypeSelect.addItem("Electric");
		locomotiveEngineTypeSelect.addItem("Diesel");
		locomotiveEngineTypeSelect.addItem("Steam");
		locomotiveEngineTypeSelect.setBounds(150, 125, 113, 30);

		// add locomotive panel items
		locomotivePanel.add(submitLocomotive);
		locomotivePanel.add(locomotiveWeightLabel);
		locomotivePanel.add(locomotiveWeightField);
		locomotivePanel.add(locomotiveEnginePower);
		locomotivePanel.add(locomotivePowerField);
		locomotivePanel.add(locomotiveEngineType);
		locomotivePanel.add(locomotiveEngineTypeSelect);

		// Set up passenger car panel
		passengerCarPanel = new JPanel(null);
		passengerCarPanel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "Passenger Car"));
		passengerCarPanel.setLocation(332, 366);
		passengerCarPanel.setSize(326, 200);

		// passenger car panel components
		submitPassengerCar = new JButton("Submit Passenger Car");
		submitPassengerCar.addActionListener(this);
		submitPassengerCar.setSize(200, 30);
		submitPassengerCar.setLocation(63, 20);
		passengerCarWeightLabel = new JLabel("Weight");
		passengerCarWeightLabel.setBounds(63, 55, 100, 30);
		passengerCarWeightField = new JTextField(20);
		passengerCarWeightField.setBounds(150, 55, 113, 30);
		passengerCarSeatsLabel = new JLabel("Number Of Seats");
		passengerCarSeatsLabel.setBounds(63, 90, 100, 30);
		passengerCarSeatsField = new JTextField(1);
		passengerCarSeatsField.setBounds(163, 90, 100, 30);

		// add passenger car panel items
		passengerCarPanel.add(submitPassengerCar);
		passengerCarPanel.add(passengerCarWeightLabel);
		passengerCarPanel.add(passengerCarWeightField);
		passengerCarPanel.add(passengerCarSeatsLabel);
		passengerCarPanel.add(passengerCarSeatsField);

		// Set up freight car panel
		freightCarPanel = new JPanel(null);
		freightCarPanel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "Freight Car"));
		freightCarPanel.setLocation(664, 366);
		freightCarPanel.setSize(326, 200);

		// freight car panel components
		submitFreightCar = new JButton("Submit Freight Car");
		submitFreightCar.addActionListener(this);
		submitFreightCar.setSize(200, 30);
		submitFreightCar.setLocation(63, 20);
		freightCarWeightLabel = new JLabel("Weight");
		freightCarWeightLabel.setBounds(63, 55, 100, 30);
		freightCarWeightField = new JTextField(20);
		freightCarWeightField.setBounds(150, 55, 113, 30);
		freightTypeLabel = new JLabel("Frieght Type");
		freightTypeLabel.setBounds(63, 90, 100, 30);
		freightTypeSelect = new JComboBox();
		freightTypeSelect.addItem("General Goods");
		freightTypeSelect.addItem("Refrigerated Goods");
		freightTypeSelect.addItem("Dangerous Materials");
		freightTypeSelect.setBounds(143, 90, 120, 30);

		freightCarPanel.add(submitFreightCar);
		freightCarPanel.add(freightCarWeightLabel);
		freightCarPanel.add(freightCarWeightField);
		freightCarPanel.add(freightTypeLabel);
		freightCarPanel.add(freightTypeSelect);

		// add panel components
		add(locomotivePanel);
		add(passengerCarPanel);
		add(freightCarPanel);
		add(boardingPanel);
		add(removeCarriage);
		add(resetTrain);
		add(canTrainMoveLabel);
		add(textTrainConfiguration);
		add(graphicalTrainConfiguration);

		// Display the window.
		setPreferredSize(new Dimension(1000, 600));
		setLocation(new Point(100, 50));
		pack();
		setVisible(true);
		newGame();
	}

	/**
	 * Sets up default text in panels, initializes train object, greys out
	 * panels.
	 * 
	 */
	private void newGame() {
		train = new DepartingTrain();
		displayText.setText("");
		passengersVsSeatsLabel.setText("Passengers/Seats: 0/0");
		leftOverPassengersLabel.setText("Passengers Left Over: 0");
		canTrainMoveLabel.setText("Train Can Move:");
		freightCarWeightField.setText("");
		locomotiveWeightField.setText("");
		passengerCarWeightField.setText("");
		passengerCarSeatsField.setText("");
		locomotivePowerField.setText("");
		numberOfPassengersField.setText("");
		locomotiveEngineTypeSelect.setSelectedIndex(ELECTRIC);
		freightTypeSelect.setSelectedIndex(GENERAL);
		canvasArray = new ArrayList<Canvas>();
		setPanelState(boardingPanel, false);
		evaluatePanelStates();
	}

	/**
	 * Sets all components in a given panel to a given state.
	 * 
	 * @param panel
	 * @param enabled
	 */
	private void setPanelState(JPanel panel, Boolean enabled) {
		Component[] components = panel.getComponents();
		for (Component c : components) {
			c.setEnabled(enabled);// enables or disables panel components
		}
	}

	/**
	 * Attempts one of every action. If an exception is thrown, the action
	 * button is greyed out in the GamePanel, to prevent the user from being
	 * able to cause exceptions. The action is always reversed if it is
	 * successful.
	 * 
	 */
	private void evaluatePanelStates() {
		// Sets locomotivePanel state
		setPanelState(locomotivePanel, train.firstCarriage() == null);

		// Attempts to add and remove passenger car
		try {
			train.addCarriage(new PassengerCar(100, 100));
			train.removeCarriage();
			setPanelState(passengerCarPanel, true);
		}

		catch (Exception e) {
			setPanelState(passengerCarPanel, false);
		}

		// Attempts to add and remove freight car
		try {
			train.addCarriage(new FreightCar(100, GENERALSTRING));
			train.removeCarriage();
			setPanelState(freightCarPanel, true);
		}

		catch (Exception e) {
			setPanelState(freightCarPanel, false);
		}

		// Enables or disables removeCarriage as necessary
		if (train.firstCarriage() instanceof RollingStock
				&& train.numberOnBoard() == 0) {
			removeCarriage.setEnabled(true);
		} else {
			removeCarriage.setEnabled(false);
		}
	}

	/**
	 * Action Listener for each button in the GamePanel.
	 * 
	 */
	public void actionPerformed(ActionEvent evt) {
		Object src = evt.getSource();
		try {
			if (src == resetTrain) {
				newGame();
			} else if (src == submitLocomotive) {
				addLocomotive(
						Integer.parseInt(locomotiveWeightField.getText()),
						getLocomotiveString());
			} else if (src == submitFreightCar) {
				addFreightCar(
						Integer.parseInt(freightCarWeightField.getText()),
						getFreightString());
			} else if (src == submitPassengerCar) {
				addPassengerCar(
						Integer.parseInt(passengerCarWeightField.getText()),
						Integer.parseInt(passengerCarSeatsField.getText()));
			} else if (src == submitBoardPassengers) {
				boardPassengers(Integer.parseInt(numberOfPassengersField
						.getText()));
			} else if (src == removeCarriage) {
				removeCarriage();
			}

			// actions to perform regardless of button pushed
			evaluatePanelStates();
			rePaintImagePanel();

			if (train.firstCarriage() != null) {
				displayText.append("Train Configuration: " + train.toString()
						+ "\n");
				canTrainMoveLabel.setText(trainCanMove());
			}

			if (train.firstCarriage() == null) {
				canTrainMoveLabel.setText("Train Can Move: ");
			}

		} catch (IllegalArgumentException e) {
			displayText.append("Please submit attributes for the carriage.\n");
		}
	}

	/**
	 * Returns the first letter of the locomotive type selected in the dropdown
	 * menu
	 * 
	 * @return string corresponding to dropdown option selected in
	 *         locomotiveEngineTypeSelect
	 */
	private String getLocomotiveString() {

		if (locomotiveEngineTypeSelect.getSelectedIndex() == ELECTRIC) {
			return String.format(locomotivePowerField.getText()
					+ ELECTRICSTRING);
		} else if (locomotiveEngineTypeSelect.getSelectedIndex() == DIESEL) {
			return String.format(locomotivePowerField.getText() + DIESELSTRING);
		} else if (locomotiveEngineTypeSelect.getSelectedIndex() == STEAM) {
			return String.format(locomotivePowerField.getText() + STEAMSTRING);
		}

		return null;
	}

	/**
	 * Returns the first letter of the freight type selected in the dropdown
	 * menu
	 * 
	 * @return string corresponding to dropdown option selected in
	 *         freightTypeSelect
	 */
	private String getFreightString() {

		if (freightTypeSelect.getSelectedIndex() == GENERAL) {
			return GENERALSTRING;
		} else if (freightTypeSelect.getSelectedIndex() == REFRIGERATED) {
			return REFRIGERATEDSTRING;
		} else if (freightTypeSelect.getSelectedIndex() == DANGEROUS) {
			return DANGEROUSSTRING;
		}

		return null;
	}

	/**
	 * Adds a passenger car with the given parameters to the train array with
	 * its corresponding graphic
	 * 
	 * @param grossWeight
	 *            of the carriage
	 * @param classification
	 *            of locomotive
	 */
	private void addLocomotive(Integer grossWeight, String classification) {
		try {
			train.addCarriage(new Locomotive(grossWeight, classification));
			canvasArray.add(addImage(Canvas.LOCOMOTIVE));// add graphic

		} catch (TrainException e) {
			displayText.append(e.getMessage() + "\n");
		}
	}

	/**
	 * Adds a passenger car with the given parameters to the train array with
	 * its corresponding graphic
	 * 
	 * @param grossWeight
	 *            of the carriage
	 * @param numberOfSeats
	 *            on board the carriage
	 */
	private void addPassengerCar(Integer grossWeight, Integer numberOfSeats) {
		try {
			train.addCarriage(new PassengerCar(grossWeight, numberOfSeats));

			if (train.numberOfSeats() > 0) {
				setPanelState(boardingPanel, true);// enable boarding panel if
			}
			canvasArray.add(addImage(Canvas.PASSENGERCAR));// add graphic
		} catch (TrainException e) {
			displayText.append(e.getMessage() + "\n");
		}
	}

	/**
	 * Adds a freight car with the given parameters to the train array with its
	 * corresponding graphic
	 * 
	 * @param grossWeight
	 *            of the carriage
	 * @param goodsType
	 *            that the carriage will hold
	 */
	private void addFreightCar(Integer grossWeight, String goodsType) {
		try {
			train.addCarriage(new FreightCar(grossWeight, goodsType));
			canvasArray.add(addImage(Canvas.FREIGHTCAR));// add graphic

		} catch (TrainException e) {
			displayText.append(e.getMessage() + "\n");
		}
	}

	/**
	 * Removes the last carriage in the array from the train
	 * 
	 */
	private void removeCarriage() {
		try {
			train.removeCarriage();
			canvasArray.remove(canvasArray.size() - 1);// remove
		} catch (TrainException e) {
			displayText.append(e.getMessage() + "\n");
		}
	}

	/**
	 * Checks to see whether the total weight of the train is more than the
	 * locomotive engine power
	 * 
	 * @return true if train can move, false if not
	 */
	private String trainCanMove() {
		if (train.trainCanMove()) {
			return "Train Can Move: Yes";
		} else if (!train.trainCanMove()) {
			return "Train Can Move: No";
		}
		return null;
	}

	/**
	 * Boards a given number of passengers to the passenger cars on the train
	 * 
	 * @param passengers
	 *            to board
	 */
	private void boardPassengers(int passengers) {
		try {
			int leftOver;
			leftOver = train.board(passengers);
			leftOverPassengersLabel
					.setText("Passengers Left Over: " + leftOver);
			passengersVsSeatsLabel.setText("Passengers/Seats: "
					+ train.numberOnBoard() + "/" + train.numberOfSeats());
			if (leftOver > 0 || train.numberOfSeats() == train.numberOnBoard()) {
				setPanelState(boardingPanel, false);// disables boarding panel								
			}
		} catch (TrainException e) {
			displayText.append(e.getMessage() + "\n");
		}
	}

	/**
	 * Creates a Canvas object containing a drawing responding to a given
	 * carriage type
	 * 
	 * @param type
	 *            of carriage to draw
	 * @return Canvas object
	 */
	private Canvas addImage(int type) {
		Canvas guiImage = new Canvas();

		if (type == Canvas.LOCOMOTIVE) {
			guiImage.figure = Canvas.LOCOMOTIVE;
		} else if (type == Canvas.PASSENGERCAR) {
			guiImage.figure = Canvas.PASSENGERCAR;
		} else {
			guiImage.figure = Canvas.FREIGHTCAR;
		}
		guiImage.setPreferredSize(new Dimension(100, 50));
		return guiImage;
	}

	/**
	 * Updates components in the JPanel containing the graphical display
	 * 
	 */
	private void rePaintImagePanel() {
		imagePanel.removeAll();
		for (Canvas c : canvasArray) {
			imagePanel.add(c);
			c.repaint();
		}
		imagePanel.revalidate();
		imagePanel.repaint();
	}

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new GamePanel();

	}
}
