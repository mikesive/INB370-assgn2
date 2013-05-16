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
			return trainCarriages.get(currentCarriageIndex);
		}
		
	}
	
	public RollingStock nextCarriage() {
		if (trainCarriages.isEmpty()) {
			currentCarriageIndex = 0;
			return null;
		}
		else {
			currentCarriageIndex++;
			return trainCarriages.get(currentCarriageIndex);
		}
	}
	
	
	public Integer board(int newPassengers) throws TrainException {
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
			throw new TrainException ("Passenger Car cannot be behing Freight Car.");
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
