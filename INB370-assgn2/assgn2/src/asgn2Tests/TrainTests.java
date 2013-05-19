package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import asgn2Exceptions.TrainException;
import asgn2RollingStock.FreightCar;
import asgn2RollingStock.Locomotive;
import asgn2RollingStock.PassengerCar;
import asgn2Train.DepartingTrain;

public class TrainTests {

	private DepartingTrain testTrain = new DepartingTrain();

	@Test
	/**Test firstCarriage returns null if no carriage
	 * 
	 */
	public void testFirstCarriageReturnsNullIfNoCarriage() {
		assertEquals(null, testTrain.firstCarriage());
	}

	@Test
	/**Tests first Carriage returns carriage if there is carriage
	 * 
	 * @throws TrainException
	 */
	public void testFirstCarriageRetrunsCarraige() throws TrainException {
		testTrain.addCarriage(new Locomotive(100, "4E"));
		assertEquals(true, testTrain.firstCarriage() instanceof Locomotive);
	}

	@Test
	/**Test that nextCarriage work if called without firstCarriage
	 * 
	 * @throws TrainException
	 */
	public void testNextCarriageReturnsCarriageIfCalledFirst()
			throws TrainException {
		testTrain.addCarriage(new Locomotive(100, "4E"));
		testTrain.addCarriage(new PassengerCar(100, 10));
		assertEquals(true, testTrain.nextCarriage() instanceof Locomotive);
	}

	@Test
	/**Test that nextCarriage work if called with firstCarriage
	 * 
	 * @throws TrainException
	 */
	public void testNextCarriageReturnsCarriageIfFirstCarriageCalled()
			throws TrainException {
		testTrain.addCarriage(new Locomotive(100, "4E"));
		testTrain.addCarriage(new PassengerCar(100, 10));
		testTrain.firstCarriage();
		assertEquals(true, testTrain.nextCarriage() instanceof PassengerCar);
	}

	@Test
	/**Test that nextCarriage work if called Twice
	 * 
	 * @throws TrainException
	 */
	public void testNextCarriageReturnsCarriageIfCalledTwice()
			throws TrainException {
		testTrain.addCarriage(new Locomotive(100, "4E"));
		testTrain.addCarriage(new PassengerCar(100, 10));
		assertEquals(true, testTrain.nextCarriage() instanceof Locomotive);
		assertEquals(true, testTrain.nextCarriage() instanceof PassengerCar);
	}

	@Test
	/**Test that nextCarriage returns null in no next carriage
	 * 
	 * @throws TrainException
	 */
	public void testNextCarriageReturnsCarriageNullIfNoMoreCarraiges()
			throws TrainException {
		testTrain.addCarriage(new Locomotive(100, "4E"));
		testTrain.addCarriage(new PassengerCar(100, 10));
		testTrain.nextCarriage();
		testTrain.nextCarriage();
		assertEquals(null, testTrain.nextCarriage());
	}

	@Test
	/**Test that nextCarriage returns first carriage after it works though whole Train
	 * 
	 * @throws TrainException
	 */
	public void testNextCarriageReturnsStartsAgainAfterLastCarriage()
			throws TrainException {
		testTrain.addCarriage(new Locomotive(100, "4E"));
		testTrain.addCarriage(new PassengerCar(100, 10));
		testTrain.nextCarriage();
		testTrain.nextCarriage();
		testTrain.nextCarriage();
		assertEquals(true, testTrain.nextCarriage() instanceof Locomotive);
	}

	@Test
	/**Test that nextCarriage returns null if no carriages added
	 * 
	 * @throws TrainException
	 */
	public void testNextCarriageReturnsNullIfNoCarriages()
			throws TrainException {
		assertEquals(null, testTrain.nextCarriage());
	}

	@Test
	/**Test method board Boards Passengers
	 * 
	 * @throws TrainException
	 */
	public void testBoardBoardsPassengers() throws TrainException {
		testTrain.addCarriage(new Locomotive(100, "4E"));
		testTrain.addCarriage(new PassengerCar(100, 10));
		testTrain.addCarriage(new PassengerCar(100, 10));
		testTrain.board(15);
		assertEquals(15, (int) testTrain.numberOnBoard());
	}

	@Test
	/**Test method board returns excess Passengers
	 * 
	 * @throws TrainException
	 */
	public void testBoardReturnsExcessPassengers() throws TrainException {
		testTrain.addCarriage(new Locomotive(100, "4E"));
		testTrain.addCarriage(new PassengerCar(100, 10));
		testTrain.addCarriage(new PassengerCar(100, 10));
		assertEquals(10, (int) testTrain.board(30));
	}

	@Test(expected = TrainException.class)
	/**Test method board throws exception if passengers negative
	 * 
	 * @throws TrainException
	 */
	public void testBoardThrowsExceptionIfPassengersNegative()
			throws TrainException {
		testTrain.addCarriage(new Locomotive(100, "4E"));
		testTrain.addCarriage(new PassengerCar(100, 10));
		testTrain.addCarriage(new PassengerCar(100, 10));
		testTrain.board(-10);
	}

	@Test
	/**Test numberOnBoard method works with more then 0 passengers
	 * 
	 * @throws TrainException
	 */
	public void testNumberOnboardReturnsCurrentNumber() throws TrainException {
		testTrain.addCarriage(new Locomotive(100, "4E"));
		testTrain.addCarriage(new PassengerCar(100, 10));
		testTrain.addCarriage(new PassengerCar(100, 10));
		testTrain.board(15);
		assertEquals(15, (int) testTrain.numberOnBoard());
	}

	@Test
	/**Test numberOnBoard method works with 0 passengers
	 * 
	 * @throws TrainException
	 */
	public void testNumberOnboardReturnsZeroPassengers() throws TrainException {
		testTrain.addCarriage(new Locomotive(100, "4E"));
		testTrain.addCarriage(new PassengerCar(100, 10));
		testTrain.addCarriage(new PassengerCar(100, 10));
		;
		assertEquals(0, (int) testTrain.numberOnBoard());
	}

	@Test
	/**Test numberOfSeats returns the correct number of seats
	 * 
	 * @throws TrainException
	 */
	public void testNumberOfSeatsReturnsSeats() throws TrainException {
		testTrain.addCarriage(new Locomotive(100, "4E"));
		testTrain.addCarriage(new PassengerCar(100, 10));
		testTrain.addCarriage(new PassengerCar(100, 10));
		;
		assertEquals(20, (int) testTrain.numberOfSeats());
	}

	@Test
	/**Test numberOfSeats returns the correct number of seats if there are no seats
	 * 
	 * @throws TrainException
	 */
	public void testNumberOfSeatsReturnsZeroSeats() throws TrainException {
		testTrain.addCarriage(new Locomotive(100, "4E"));
		assertEquals(0, (int) testTrain.numberOfSeats());
	}

	@Test
	/**Tests trainCanMove returns true if pulling power enough
	 * 
	 * @throws TrainException
	 */
	public void testTrainCanMoveReturnsTrue() throws TrainException {
		testTrain.addCarriage(new Locomotive(100, "4E"));
		testTrain.addCarriage(new PassengerCar(50, 10));
		assertEquals(true, testTrain.trainCanMove());
	}

	@Test
	/**Tests trainCanMove returns true if power exactly matches weight
	 * 
	 * @throws TrainException
	 */
	public void testTrainCanMoveReturnsTrueForExactWeight()
			throws TrainException {
		testTrain.addCarriage(new Locomotive(100, "4E"));
		testTrain.addCarriage(new PassengerCar(300, 10));
		assertEquals(true, testTrain.trainCanMove());
	}

	@Test
	/**Tests trainCanMove returns false if to heavy
	 * 
	 * @throws TrainException
	 */
	public void testTrainCanMoveReturnsFalseIfToHeavy() throws TrainException {
		testTrain.addCarriage(new Locomotive(100, "4E"));
		testTrain.addCarriage(new PassengerCar(500, 10));
		assertEquals(false, testTrain.trainCanMove());
	}

	@Test(expected = TrainException.class)
	/**Test addCarriage throws exception if 2 Locomotives
	 * 
	 * @throws TrainException
	 */
	public void testAddCarriageThrowsExceptionIfTwoLocomotives()
			throws TrainException {
		testTrain.addCarriage(new Locomotive(100, "4E"));
		testTrain.addCarriage(new Locomotive(100, "4E"));
	}

	@Test(expected = TrainException.class)
	/**Test addCarriage throws exception if PassengerCar behind FreightCar
	 * 
	 * @throws TrainException
	 */
	public void testAddCarriageThrowsExceptionIfPassengerCarBehindFreight()
			throws TrainException {
		testTrain.addCarriage(new Locomotive(100, "4E"));
		testTrain.addCarriage(new FreightCar(100, "R"));
		testTrain.addCarriage(new PassengerCar(100, 10));
	}

	@Test(expected = TrainException.class)
	/**Test addCarriage throws exception if First Carriage not Locomotive
	 * 
	 * @throws TrainException
	 */
	public void testAddCarriageThrowsExceptionIfFirstCarriageNotLocomotive()
			throws TrainException {
		testTrain.addCarriage(new FreightCar(100, "R"));
	}

	@Test(expected = TrainException.class)
	/**Test addCarriage throws exception if passengers are onboard
	 * 
	 * @throws TrainException
	 */
	public void testAddCarriageThrowsExceptionIfPassengersOnboard()
			throws TrainException {
		testTrain.addCarriage(new Locomotive(100, "4E"));
		testTrain.addCarriage(new PassengerCar(100, 10));
		testTrain.board(5);
		testTrain.addCarriage(new PassengerCar(100, 10));
	}

	@Test
	/**Test addCarriage works correctly
	 * 
	 * @throws TrainException
	 */
	public void testAddCarriageWorksCorrectly() throws TrainException {
		testTrain.addCarriage(new Locomotive(100, "4E"));
		assertEquals(true, testTrain.nextCarriage() instanceof Locomotive);
	}

	@Test(expected = TrainException.class)
	/**Test removeCarriage throws exception if passengers onbaord
	 * 
	 * @throws TrainException
	 */
	public void testRemoveCarriagesThrowsExceptionIfPassengersOnboard()
			throws TrainException {
		testTrain.addCarriage(new Locomotive(100, "4E"));
		testTrain.addCarriage(new PassengerCar(100, 10));
		testTrain.board(5);
		testTrain.removeCarriage();
	}

	@Test(expected = TrainException.class)
	/**Test removeCarriage throws exception there are no carriages
	 * 
	 * @throws TrainException
	 */
	public void testRemoveCarriagesThrowsExceptionIfNoCarriages()
			throws TrainException {
		testTrain.removeCarriage();
	}

	@Test
	/**Test removeCarriage works correctly and removes last carriage
	 * 
	 * @throws TrainException
	 */
	public void testRemoveCarriagesWorksCorrectly() throws TrainException {
		testTrain.addCarriage(new Locomotive(100, "4E"));
		testTrain.addCarriage(new PassengerCar(100, 10));
		testTrain.removeCarriage();
		testTrain.nextCarriage();
		assertEquals(null, testTrain.nextCarriage());
	}

	@Test
	/**Test DepartingTrain to string renders correctly
	 * 
	 * @throws TrainException
	 */
	public void testDepartingTrainToString() throws TrainException {
		testTrain.addCarriage(new Locomotive(100, "4E"));
		testTrain.addCarriage(new PassengerCar(100, 10));
		testTrain.addCarriage(new PassengerCar(100, 10));
		assertEquals("Loco(4E)-Passenger(0/10)-Passenger(0/10)",
				testTrain.toString());
	}

}
