package asgn2RollingStock;

import asgn2Exceptions.TrainException;

/**Creates a rolling stock train of type Passenger Car
 * 
 * @author Wayne Maxwell
 *
 */
public class PassengerCar extends RollingStock {

	Integer numberOfSeats;
	Integer passengersOnboard;

	/**
	 * Constructor sets up the weight and number of seats on train
	 * 
	 * @param grossWeight
	 * @param goodsType
	 * @throws TrainException
	 *             if weight is entered as negative,or 0 and if negative seats
	 *             entered
	 */
	public PassengerCar(Integer grossWeight, Integer numberOfSeats)
			throws TrainException {
		super(grossWeight);

		// Checks gross weight is not negative or 0
		if (grossWeight <= 0) {
			throw new TrainException("Weight must be positive");
		}

		// Checks seats is not negative
		if (numberOfSeats < 0) {
			throw new TrainException(
					"Number of seats cant be negitive, must be positive");
		}

		this.passengersOnboard = 0;
		this.numberOfSeats = numberOfSeats;
	}

	/**
	 * boards passengers on train sets the number of passengers on train and
	 * returns number of passengers train could not load
	 * 
	 * @param newPassengers
	 * @return passengers who could not board train
	 * @throws TrainException
	 *             if boarding passengers is negative
	 */
	public Integer board(Integer newPassengers) throws TrainException {

		Integer remainingPassengers = 0;

		// Checks passengers are not negative
		if (newPassengers < 0) {
			throw new TrainException("New passengers cannot be negitive");
		}

		// if more available seats then passengers boarding
		if (newPassengers <= this.numberOfSeats - this.passengersOnboard) {
			remainingPassengers = 0;
			this.passengersOnboard = this.passengersOnboard + newPassengers;
			// calculate passengers unable to board
		} else {
			remainingPassengers = newPassengers
					- (this.numberOfSeats - this.passengersOnboard);
			this.passengersOnboard = this.numberOfSeats;
		}
		return remainingPassengers;
	}

	/**
	 * Removes passengers from the train
	 * 
	 * @param departingPassenger
	 * @throws TrainException
	 *             departing passengers is negative or more departing passengers
	 *             then are on train
	 */
	public void alight(Integer departingPassenger) throws TrainException {

		// Tests the departing passengers is not negative
		if (departingPassenger < 0) {
			throw new TrainException("Departing Passengers can not be negitive");
		}

		// Tests more passengers the on the train can be unboarded
		if (departingPassenger > this.passengersOnboard) {
			throw new TrainException(
					"can not unboard more passengers than are on train");
		}

		this.passengersOnboard = this.passengersOnboard - departingPassenger;
	}

	/**Gets the number or people on board
	 * 
	 * @return number of people on board train
	 */
	public Integer numberOnBoard() {
		return this.passengersOnboard;
	}

	/**Gets number of seats on train
	 * 
	 * @return number of seats on train
	 */
	public Integer numberOfSeats() {
		return this.numberOfSeats;
	}

	/**
	 * Returns a description of the rollingstock
	 * 
	 * @return string description
	 */
	@Override
	public String toString() {
		return "Passenger(" + this.passengersOnboard + "/" + this.numberOfSeats
				+ ")";
	}

}
