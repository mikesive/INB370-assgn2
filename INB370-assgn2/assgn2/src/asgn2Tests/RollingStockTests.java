package asgn2Tests;

import static org.junit.Assert.*;

/**Tests FreightCar.java, PassengerCar.java, Locomotive.java, RollingStock.java
 * 
 * @author Michael Sive
 *
 */

import org.junit.Test;

import asgn2Exceptions.TrainException;
import asgn2RollingStock.FreightCar;
import asgn2RollingStock.Locomotive;
import asgn2RollingStock.PassengerCar;

/**
 * 
 * @author Michael Sive
 *
 */
public class RollingStockTests {

	PassengerCar testPassengerCar;
	Locomotive testLocomotive;
	FreightCar testFreightCar;

	@Test
	/**Tests Passenger Car constructor with valid parameters
	 * 
	 * @throws TrainException
	 */
	public void PassengerCarValidConstructor() throws TrainException {
		try {
			testPassengerCar = new PassengerCar(30, 100);

		} catch (TrainException e) {
			fail(e.getMessage());
		}
	}

	@Test(expected = TrainException.class)
	/**Tests Passenger Car constructor throws exception if weight is zero
	 * 
	 * @throws TrainException
	 */
	public void PassengerCarWeightZero() throws TrainException {
		testPassengerCar = new PassengerCar(0, 100);
	}

	@Test(expected = TrainException.class)
	/**Tests Passenger Car constructor throws exception if weight is negative
	 * 
	 * @throws TrainException
	 */
	public void PassengerCarWeightNegative() throws TrainException {
		testPassengerCar = new PassengerCar(-1, 100);
	}

	@Test(expected = TrainException.class)
	/**Tests Passenger Car constructor throws exception if seats are negative
	 * 
	 * @throws TrainException
	 */
	public void PassengerCarSeatsNegative() throws TrainException {
		testPassengerCar = new PassengerCar(100, -1);
	}

	@Test
	/**Tests method numberOfSeats returns number of seats
	 * 
	 * @throws TrainException
	 */
	public void getNumberOfSeats() throws TrainException {
		testPassengerCar = new PassengerCar(100, 100);
		int seats = testPassengerCar.numberOfSeats();
		assertEquals(seats, 100);
	}

	@Test
	/**Tests method board adds passengers to numberOnBoard
	 * 
	 * @throws TrainException
	 */
	public void boardPassengers() throws TrainException {
		testPassengerCar = new PassengerCar(100, 100);
		testPassengerCar.board(25);
		int seats = testPassengerCar.numberOnBoard();
		assertEquals(seats, 25);
	}

	@Test
	/**Tests board doesn't throw exception given zero
	 * 
	 * @throws TrainException
	 */
	public void boardPassengersZero() throws TrainException {
		testPassengerCar = new PassengerCar(100, 100);
		testPassengerCar.board(0);
	}

	@Test(expected = TrainException.class)
	/**Tests board throws exception given a negative
	 * 
	 * @throws TrainException
	 */
	public void boardPassengersNegative() throws TrainException {
		testPassengerCar = new PassengerCar(100, 100);
		testPassengerCar.board(-3);
	}

	@Test
	/**Tests board returns excess passengers
	 * 
	 * @throws TrainException
	 */
	public void boardPassengersOverflow() throws TrainException {
		testPassengerCar = new PassengerCar(100, 100);
		int passengersLeft = testPassengerCar.board(125);
		assertEquals(passengersLeft, 25);
	}

	@Test
	/**Tests method alight does not throw exception given zero
	 * 
	 * @throws TrainException
	 */
	public void alightPassengersZero() throws TrainException {
		testPassengerCar = new PassengerCar(100, 100);
		testPassengerCar.board(98);
		testPassengerCar.alight(0);
	}

	@Test(expected = TrainException.class)
	/**Tests method alight throws exception given negative
	 * 
	 * @throws TrainException
	 */
	public void alightPassengersNegative() throws TrainException {
		testPassengerCar = new PassengerCar(100, 100);
		testPassengerCar.board(98);
		testPassengerCar.alight(-3);
	}

	@Test(expected = TrainException.class)
	/**Tests alight throws exception if passengers to alight is larger than numberOnBoard
	 * 
	 * @throws TrainException
	 */
	public void alightPassengersOverflow() throws TrainException {
		testPassengerCar = new PassengerCar(100, 100);
		testPassengerCar.board(98);
		testPassengerCar.alight(100);
	}

	@Test
	/**Tests alight removes given passengers
	 * 
	 * @throws TrainException
	 */
	public void alightPassengersValid() throws TrainException {
		testPassengerCar = new PassengerCar(100, 100);
		testPassengerCar.board(98);
		testPassengerCar.alight(26);
		int onBoard = testPassengerCar.numberOnBoard();
		assertEquals(onBoard, 72);
	}

	@Test
	/**Tests that Passenger Car toString is overridden
	 * 
	 * @throws TrainException
	 */
	public void alightPassengersToString() throws TrainException {
		testPassengerCar = new PassengerCar(100, 100);
		testPassengerCar.board(98);
		testPassengerCar.alight(26);
		String string = testPassengerCar.toString();
		assertEquals(string, "Passenger(72/100)");
	}

	@Test
	/**Tests Freight Car constructor with valid constructor
	 * 
	 * @throws TrainException
	 */
	public void FreightCarValidConstructor() throws TrainException {
		try {
			testFreightCar = new FreightCar(100, "G");

		} catch (TrainException e) {
			fail(e.getMessage());
		}
	}

	@Test(expected = TrainException.class)
	/**Tests Freight Car constructor throws exception given zero weight
	 * 
	 * @throws TrainException
	 */
	public void FreightCarWeightZero() throws TrainException {
		testFreightCar = new FreightCar(0, "G");
	}

	@Test(expected = TrainException.class)
	/**Tests Freight Car constructor throws exception given negative weight
	 * 
	 * @throws TrainException
	 */
	public void FreightCarWeightNegative() throws TrainException {
		testFreightCar = new FreightCar(-1, "G");
	}

	@Test(expected = TrainException.class)
	/**Tests Freight Car constructor throws exception with invalid goods
	 * 
	 * @throws TrainException
	 */
	public void FreightCarGoodsInvalid() throws TrainException {
		testFreightCar = new FreightCar(300, "K");
	}

	@Test
	/**Tests method goodsType returns correct string
	 * 
	 * @throws TrainException
	 */
	public void FreightCarGoodsType() throws TrainException {
		testFreightCar = new FreightCar(100, "G");
		assertEquals("G", testFreightCar.goodsType());
	}

	@Test
	/**Tests Freight Car toString is overridden
	 * 
	 * @throws TrainException
	 */
	public void FreightCarToString() throws TrainException {
		testFreightCar = new FreightCar(100, "G");
		assertEquals(testFreightCar.toString(), "Freight(G)");
	}

	@Test
	/**Tests Locomotive constructor with valid parameters
	 * 
	 * @throws TrainException
	 */
	public void LocomotiveValidConstructor() throws TrainException {
		try {
			testLocomotive = new Locomotive(100, "2E");

		} catch (TrainException e) {
			fail(e.getMessage());
		}
	}

	@Test(expected = TrainException.class)
	/**Tests Locomotive constructor throws exception given weight zero
	 * 
	 * @throws TrainException
	 */
	public void LocomotiveWeightZero() throws TrainException {
		testLocomotive = new Locomotive(0, "G");
	}

	@Test(expected = TrainException.class)
	/**Tests Locomotive constructor throws exception given negative weight
	 * 
	 * @throws TrainException
	 */
	public void LocomotiveWeightNegative() throws TrainException {
		testLocomotive = new Locomotive(-1, "G");
	}

	@Test(expected = TrainException.class)
	/**Tests Locomotive constructor throws exception given invalid classification letter
	 * 
	 * @throws TrainException
	 */
	public void LocomotiveInvalidClassificationLetter() throws TrainException {
		testLocomotive = new Locomotive(198, "9K");
	}

	@Test(expected = TrainException.class)
	/**Tests Locomotive constructor throws exception given invalid classification number
	 * 
	 * @throws TrainException
	 */
	public void LocomotiveInvalidClassificationNumber() throws TrainException {
		testLocomotive = new Locomotive(198, "10E");
	}

	@Test(expected = TrainException.class)
	/**Tests Locomotive constructor throws exception given invalid classification string
	 * 
	 * @throws TrainException
	 */
	public void LocomotiveInvalidClassification() throws TrainException {
		testLocomotive = new Locomotive(198, "test");
	}

	@Test
	/**Tests method power returns correct engine power
	 * 
	 * @throws TrainException
	 */
	public void LocomotiveGetPower() throws TrainException {
		testLocomotive = new Locomotive(100, "5E");
		int power = testLocomotive.power();
		assertEquals(power, 500);
	}

	@Test
	/**Tests Locomotive toString is overridden
	 * 
	 * @throws TrainException
	 */
	public void LocomotiveToString() throws TrainException {
		testLocomotive = new Locomotive(400, "3E");
		assertEquals(testLocomotive.toString(), "Loco(3E)");
	}

}
