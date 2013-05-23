package asgn2Train;

import java.util.ArrayList;

import asgn2Exceptions.TrainException;
import asgn2RollingStock.FreightCar;
import asgn2RollingStock.PassengerCar;
import asgn2RollingStock.Locomotive;
import asgn2RollingStock.RollingStock;

/**Creates a train which can consist of zero, one or more RollingStock carriages
 * 
 * @author Michael Sive
 *
 */

public class DepartingTrain {
	private ArrayList<RollingStock> trainCarriages;
	private int currentCarriageIndex;
	private final int first = 0;
	
	/**Returns last carriage array index
	 * 
	 * @return index of last carriage as integer
	 */
	private int lastCarriage() {
		return trainCarriages.size() - 1;
	}

	/**Initializes array of RollingStock objects
	 * 
	 */
	public DepartingTrain() {
		this.trainCarriages = new ArrayList<RollingStock>();
	}
	
	/**Returns the first carriage in the train
	 * 
	 * @return first RollingStock in array
	 */
	public RollingStock firstCarriage () {
		currentCarriageIndex = 0;
		if (trainCarriages.isEmpty()) {
			return null;
		}
		else {
			currentCarriageIndex = 1;//needs to proceed to next index for nextCarraige
			return trainCarriages.get(currentCarriageIndex-1);//added -1 to reference right
		}
		
	}
	
	/**Returns the next carriage in the train after the one returned
	 * by the immediately preceding call to either this method or method firstCarriage.
	 * 
	 * @return RollingStock
	 */
	public RollingStock nextCarriage() {
		if (trainCarriages.isEmpty() || currentCarriageIndex > lastCarriage()) {
			currentCarriageIndex = 0;
			return null;
		} //If statement needed extra test to ensure next carriage does not go out of bounds
		else {
			currentCarriageIndex++;
			return trainCarriages.get(currentCarriageIndex-1);//added -1 to reference right
		}
	}
	
	/**Boards given number of passengers onto train
	 * 
	 * @param newPassengers
	 * @return Passengers left over if train is full
	 * @throws TrainException
	 */
	public Integer board(int newPassengers) throws TrainException {
		
		if(newPassengers<0){
			throw new TrainException("Cannot have negitive Pasengers");//Added in exception
		}
		
		for (RollingStock i : trainCarriages) {
			if(i instanceof PassengerCar) {
				newPassengers = ((PassengerCar) i).board(newPassengers);
			}
			if (newPassengers == 0) {
				break;
			}
		}
		return newPassengers;
	}
	
	/**Gets the total number of passengers on board the train
	 * 
	 * @return the number of passengers on board
	 */
	public Integer numberOnBoard() {
		int totalPassengers = 0;
		for (RollingStock i : trainCarriages) {
			if(i instanceof PassengerCar) {
				totalPassengers += ((PassengerCar) i).numberOnBoard();
			}
		}
		return totalPassengers;
	}
	
	/**Gets the total number of seats on the train
	 * 
	 * @return the number of seats on the train
	 */
	public Integer numberOfSeats() {
		int totalSeats = 0;
		for (RollingStock i : trainCarriages) {
			if(i instanceof PassengerCar) {
				totalSeats += ((PassengerCar) i).numberOfSeats();
			}
		}
		return totalSeats;
	}
	
	/**Checks to see whether or not the trains weight exceeds its pulling power
	 * 
	 * @return true if weight <= pulling power
	 */
	public Boolean trainCanMove() {
		int totalWeight = 0;
		int totalPower = ((Locomotive) trainCarriages.get(first)).power();
		
		for (RollingStock i : trainCarriages) {
			totalWeight += i.getGrossWeight();
		}
		
		if (totalPower >= totalWeight || trainCarriages.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**Adds a given RollingStock to the array
	 * 
	 * @param newCarriage
	 * @throws TrainException
	 */
	public void addCarriage(RollingStock newCarriage) throws TrainException {
		if (newCarriage instanceof Locomotive && !trainCarriages.isEmpty()) {
			throw new TrainException("Can only have one Locomotive, at the front of the train.");
		}
		if (newCarriage instanceof PassengerCar && trainCarriages.get(lastCarriage()) instanceof FreightCar) {
			throw new TrainException ("Passenger Car cannot be behind a Freight Car.");
		}
		if (((newCarriage instanceof PassengerCar) || (newCarriage instanceof FreightCar)) && trainCarriages.isEmpty()) {
			throw new TrainException ("First carriage must be a locomotive.");
		}
		if (numberOnBoard() > 0) {
			throw new TrainException("Cannot add carriages whilst there are passengers on board.");
		}
		
		trainCarriages.add(newCarriage);
	}
	
	/**Removes the last RollingStock from the array
	 * 
	 * @throws TrainException
	 */
	public void removeCarriage() throws TrainException {
		if (numberOnBoard() > 0) {
			throw new TrainException("Cannot remove carriages whilst there are passengers on board.");
		}
		if (trainCarriages.isEmpty()) {
			throw new TrainException("There are no carriages to remove.");
		}
		
		trainCarriages.remove(lastCarriage());
	}
	
	@Override
	/**Returns a human-readable description of the entire train.
	 * 
	 */
	public String toString() {
		String carriageList = new String();
		
		for (RollingStock i : trainCarriages) {
			carriageList += "-"+i.toString();
		}
		return carriageList.substring(1);
	}
}
