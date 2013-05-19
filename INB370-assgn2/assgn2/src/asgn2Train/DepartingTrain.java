package asgn2Train;

import java.util.ArrayList;

import asgn2Exceptions.TrainException;
import asgn2RollingStock.FreightCar;
import asgn2RollingStock.PassengerCar;
import asgn2RollingStock.Locomotive;
import asgn2RollingStock.RollingStock;

public class DepartingTrain {
	private ArrayList<RollingStock> trainCarriages;
	private int currentCarriageIndex;
	private final int first = 0;
	
	
	private int lastCarriage() {
		return trainCarriages.size() - 1;
	}

	public DepartingTrain() {
		this.trainCarriages = new ArrayList<RollingStock>();
	}
	
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
	
	public Integer numberOnBoard() {
		int totalPassengers = 0;
		for (RollingStock i : trainCarriages) {
			if(i instanceof PassengerCar) {
				totalPassengers += ((PassengerCar) i).numberOnBoard();
			}
		}
		return totalPassengers;
	}
	
	public Integer numberOfSeats() {
		int totalSeats = 0;
		for (RollingStock i : trainCarriages) {
			if(i instanceof PassengerCar) {
				totalSeats += ((PassengerCar) i).numberOfSeats();
			}
		}
		return totalSeats;
	}
	
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
	public String toString() {
		String carriageList = new String();
		
		for (RollingStock i : trainCarriages) {
			carriageList += "-"+i.toString();
		}
		return carriageList.substring(1);
	}
}
