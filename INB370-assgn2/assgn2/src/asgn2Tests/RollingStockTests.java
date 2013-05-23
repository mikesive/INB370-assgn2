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

public class RollingStockTests {

	@Test
	/**Tests Passenger Car constructor with valid parameters
	 * 
	 * @throws TrainException
	 */
	public void PassengerCarValidConstructor() throws TrainException {
		try {
			PassengerCar testCar = new PassengerCar(30, 100);
			
		}
		catch (TrainException e) {
			fail(e.getMessage());
		}
	}
	
	@Test (expected=TrainException.class)
	/**Tests Passenger Car constructor throws exception if weight is zero
	 * 
	 * @throws TrainException
	 */
	public void PassengerCarWeightZero() throws TrainException {
		PassengerCar testCar = new PassengerCar(0, 100);
	}
	
	@Test (expected=TrainException.class)
	/**Tests Passenger Car constructor throws exception if weight is negative
	 * 
	 * @throws TrainException
	 */
	public void PassengerCarWeightNegative() throws TrainException {
		PassengerCar testCar = new PassengerCar(-1, 100);
	}
	
	@Test (expected=TrainException.class)
	/**Tests Passenger Car constructor throws exception if seats are negative
	 * 
	 * @throws TrainException
	 */
	public void PassengerCarSeatsNegative() throws TrainException {
		PassengerCar testCar = new PassengerCar(100, -1);
	}
	
	@Test
	/**Tests method numberOfSeats returns number of seats
	 * 
	 * @throws TrainException
	 */
	public void getNumberOfSeats() throws TrainException {
		PassengerCar testCar = new PassengerCar(100, 100);
		int seats = testCar.numberOfSeats();
		assertEquals(seats, 100);
	}
	
	@Test
	/**Tests method board adds passengers to numberOnBoard
	 * 
	 * @throws TrainException
	 */
	public void boardPassengers() throws TrainException {
		PassengerCar testCar = new PassengerCar(100, 100);
		testCar.board(25);
		int seats = testCar.numberOnBoard();
		assertEquals(seats, 25);
	}
	
	@Test
	/**Tests board doesn't throw exception given zero
	 * 
	 * @throws TrainException
	 */
	public void boardPassengersZero() throws TrainException {
		PassengerCar testCar = new PassengerCar(100, 100);
		testCar.board(0);
	}
	
	@Test (expected = TrainException.class)
	/**Tests board throws exception given a negative
	 * 
	 * @throws TrainException
	 */
	public void boardPassengersNegative() throws TrainException {
		PassengerCar testCar = new PassengerCar(100, 100);
		testCar.board(-3);
	}
	
	@Test
	/**Tests board returns excess passengers
	 * 
	 * @throws TrainException
	 */
	public void boardPassengersOverflow() throws TrainException {
		PassengerCar testCar = new PassengerCar(100, 100);
		int passengersLeft = testCar.board(125);
		assertEquals(passengersLeft, 25);
	}
	
	@Test
	/**Tests method alight does not throw exception given zero
	 * 
	 * @throws TrainException
	 */
	public void alightPassengersZero() throws TrainException {
		PassengerCar testCar = new PassengerCar(100, 100);
		testCar.board(98);
		testCar.alight(0);
	}
	
	@Test (expected=TrainException.class)
	/**Tests method alight throws exception given negative
	 * 
	 * @throws TrainException
	 */
	public void alightPassengersNegative() throws TrainException {
		PassengerCar testCar = new PassengerCar(100, 100);
		testCar.board(98);
		testCar.alight(-3);
	}
	
	@Test (expected=TrainException.class)
	/**Tests alight throws exception if passengers to alight is larger than numberOnBoard
	 * 
	 * @throws TrainException
	 */
	public void alightPassengersOverflow() throws TrainException {
		PassengerCar testCar = new PassengerCar(100, 100);
		testCar.board(98);
		testCar.alight(100);
	}
	
	@Test
	/**Tests alight removes given passengers
	 * 
	 * @throws TrainException
	 */
	public void alightPassengersValid() throws TrainException {
		PassengerCar testCar = new PassengerCar(100, 100);
		testCar.board(98);
		testCar.alight(26);
		int onBoard = testCar.numberOnBoard();
		assertEquals(onBoard, 72);
	}
	
	@Test
	/**Tests that Passenger Car toString is overridden
	 * 
	 * @throws TrainException
	 */
	public void alightPassengersToString() throws TrainException {
		PassengerCar testCar = new PassengerCar(100, 100);
		testCar.board(98);
		testCar.alight(26);
		String string = testCar.toString();
		assertEquals(string, "Passenger(72/100)");
	}
	
	@Test
	/**Tests Freight Car constructor with valid constructor
	 * 
	 * @throws TrainException
	 */
	public void FreightCarValidConstructor() throws TrainException {
		try {
			FreightCar testCar = new FreightCar(100, "G");
			
		}
		catch (TrainException e) {
			fail(e.getMessage());
		}
	}
	
	@Test (expected=TrainException.class)
	/**Tests Freight Car constructor throws exception given zero weight
	 * 
	 * @throws TrainException
	 */
	public void FreightCarWeightZero() throws TrainException {
		FreightCar testCar = new FreightCar(0, "G");
	}
	
	@Test (expected=TrainException.class)
	/**Tests Freight Car constructor throws exception given negative weight
	 * 
	 * @throws TrainException
	 */
	public void FreightCarWeightNegative() throws TrainException {
		FreightCar testCar = new FreightCar(-1, "G");
	}
	
	@Test (expected=TrainException.class)
	/**Tests Freight Car constructor throws exception with invalid goods
	 * 
	 * @throws TrainException
	 */
	public void FreightCarGoodsInvalid() throws TrainException {
		FreightCar testCar = new FreightCar(300, "K");
	}
	
	@Test
	/**Tests method goodsType returns correct string
	 * 
	 * @throws TrainException
	 */
	public void FreightCarGoodsType() throws TrainException {
		FreightCar testCar = new FreightCar(100, "G");
		assertEquals("G", testCar.goodsType());
	}
	
	@Test
	/**Tests Freight Car toString is overridden
	 * 
	 * @throws TrainException
	 */
	public void FreightCarToString() throws TrainException {
		FreightCar testCar = new FreightCar(100, "G");
		assertEquals(testCar.toString(), "Freight(G)");
	}
	
	@Test
	/**Tests Locomotive constructor with valid parameters
	 * 
	 * @throws TrainException
	 */
	public void LocomotiveValidConstructor() throws TrainException {
		try {
			Locomotive testCar = new Locomotive(100, "2E");
			
		}
		catch (TrainException e) {
			fail(e.getMessage());
		}
	}
	
	@Test (expected=TrainException.class)
	/**Tests Locomotive constructor throws exception given weight zero
	 * 
	 * @throws TrainException
	 */
	public void LocomotiveWeightZero() throws TrainException {
		Locomotive testCar = new Locomotive(0, "G");
	}
	
	@Test (expected=TrainException.class)
	/**Tests Locomotive constructor throws exception given negative weight
	 * 
	 * @throws TrainException
	 */
	public void LocomotiveWeightNegative() throws TrainException {
		Locomotive testCar = new Locomotive(-1, "G");
	}
	
	@Test (expected=TrainException.class)
	/**Tests Locomotive constructor throws exception given invalid classification letter
	 * 
	 * @throws TrainException
	 */
	public void LocomotiveInvalidClassificationLetter() throws TrainException {
		Locomotive testCar = new Locomotive(198, "9K");
	}
	
	@Test (expected=TrainException.class)
	/**Tests Locomotive constructor throws exception given invalid classification number
	 * 
	 * @throws TrainException
	 */
	public void LocomotiveInvalidClassificationNumber() throws TrainException {
		Locomotive testCar = new Locomotive(198, "10E");
	}
	
	@Test (expected=TrainException.class)
	/**Tests Locomotive constructor throws exception given invalid classification string
	 * 
	 * @throws TrainException
	 */
	public void LocomotiveInvalidClassification() throws TrainException {
		Locomotive testCar = new Locomotive(198, "test");
	}
	
	@Test
	/**Tests method power returns correct engine power
	 * 
	 * @throws TrainException
	 */
	public void LocomotiveGetPower() throws TrainException {
		Locomotive testCar = new Locomotive(100, "5E");
		int power = testCar.power();
		assertEquals(power, 500);
	}
	
	@Test
	/**Tests Locomotive toString is overridden
	 * 
	 * @throws TrainException
	 */
	public void LocomotiveToString() throws TrainException {
		Locomotive testCar = new Locomotive(400, "3E");
		assertEquals(testCar.toString(), "Loco(3E)");
	}

}
