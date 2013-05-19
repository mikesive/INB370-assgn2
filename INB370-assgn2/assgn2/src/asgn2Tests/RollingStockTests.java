package asgn2Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import asgn2Exceptions.TrainException;
import asgn2RollingStock.FreightCar;
import asgn2RollingStock.Locomotive;
import asgn2RollingStock.PassengerCar;

public class RollingStockTests {

	@Test
	public void PassengerCarValidConstructor() throws TrainException {
		try {
			PassengerCar testCar = new PassengerCar(30, 100);
			
		}
		catch (TrainException e) {
			fail(e.getMessage());
		}
	}
	
	@Test (expected=TrainException.class)
	public void PassengerCarWeightZero() throws TrainException {
		PassengerCar testCar = new PassengerCar(0, 100);
	}
	
	@Test (expected=TrainException.class)
	public void PassengerCarWeightNegative() throws TrainException {
		PassengerCar testCar = new PassengerCar(-1, 100);
	}
	
	@Test (expected=TrainException.class)
	public void PassengerCarSeatsNegative() throws TrainException {
		PassengerCar testCar = new PassengerCar(100, -1);
	}
	
	@Test
	public void getNumberOfSeats() throws TrainException {
		PassengerCar testCar = new PassengerCar(100, 100);
		int seats = testCar.numberOfSeats();
		assertEquals(seats, 100);
	}
	
	@Test
	public void boardPassengers() throws TrainException {
		PassengerCar testCar = new PassengerCar(100, 100);
		testCar.board(25);
		int seats = testCar.numberOnBoard();
		assertEquals(seats, 25);
	}
	
	@Test
	public void boardPassengersZero() throws TrainException {
		PassengerCar testCar = new PassengerCar(100, 100);
		testCar.board(0);
	}
	
	@Test (expected = TrainException.class)
	public void boardPassengersNegative() throws TrainException {
		PassengerCar testCar = new PassengerCar(100, 100);
		testCar.board(-3);
	}
	
	@Test
	public void boardPassengersOverflow() throws TrainException {
		PassengerCar testCar = new PassengerCar(100, 100);
		int passengersLeft = testCar.board(125);
		assertEquals(passengersLeft, 25);
	}
	
	@Test
	public void alightPassengersZero() throws TrainException {
		PassengerCar testCar = new PassengerCar(100, 100);
		testCar.board(98);
		testCar.alight(0);
	}
	
	@Test (expected=TrainException.class)
	public void alightPassengersNegative() throws TrainException {
		PassengerCar testCar = new PassengerCar(100, 100);
		testCar.board(98);
		testCar.alight(-3);
	}
	
	@Test (expected=TrainException.class)
	public void alightPassengersOverflow() throws TrainException {
		PassengerCar testCar = new PassengerCar(100, 100);
		testCar.board(98);
		testCar.alight(100);
	}
	
	@Test
	public void alightPassengersValid() throws TrainException {
		PassengerCar testCar = new PassengerCar(100, 100);
		testCar.board(98);
		testCar.alight(26);
		int onBoard = testCar.numberOnBoard();
		assertEquals(onBoard, 72);
	}
	
	public void alightPassengersToString() throws TrainException {
		PassengerCar testCar = new PassengerCar(100, 100);
		testCar.board(98);
		testCar.alight(26);
		String string = testCar.toString();
		assertEquals(string, "Passenger(72/100)");
	}
	
	@Test
	public void FreightCarValidConstructor() throws TrainException {
		try {
			FreightCar testCar = new FreightCar(100, "G");
			
		}
		catch (TrainException e) {
			fail(e.getMessage());
		}
	}
	
	@Test (expected=TrainException.class)
	public void FreightCarWeightZero() throws TrainException {
		FreightCar testCar = new FreightCar(0, "G");
	}
	
	@Test (expected=TrainException.class)
	public void FreightCarWeightNegative() throws TrainException {
		FreightCar testCar = new FreightCar(-1, "G");
	}
	
	@Test (expected=TrainException.class)
	public void FreightCarGoodsInvalid() throws TrainException {
		FreightCar testCar = new FreightCar(300, "K");
	}
	
	@Test
	public void FreightCarGoodsType() throws TrainException {
		FreightCar testCar = new FreightCar(100, "G");
		assertEquals("G", testCar.goodsType());
	}
	
	@Test
	public void FreightCarToString() throws TrainException {
		FreightCar testCar = new FreightCar(100, "G");
		assertEquals(testCar.toString(), "Freight(G)");
	}
	
	@Test
	public void LocomotiveValidConstructor() throws TrainException {
		try {
			Locomotive testCar = new Locomotive(100, "2E");
			
		}
		catch (TrainException e) {
			fail(e.getMessage());
		}
	}
	
	@Test (expected=TrainException.class)
	public void LocomotiveWeightZero() throws TrainException {
		Locomotive testCar = new Locomotive(0, "G");
	}
	
	@Test (expected=TrainException.class)
	public void LocomotiveWeightNegative() throws TrainException {
		Locomotive testCar = new Locomotive(-1, "G");
	}
	
	@Test (expected=TrainException.class)
	public void LocomotiveInvalidClassificationLetter() throws TrainException {
		Locomotive testCar = new Locomotive(198, "9K");
	}
	
	@Test (expected=TrainException.class)
	public void LocomotiveInvalidClassificationNumber() throws TrainException {
		Locomotive testCar = new Locomotive(198, "10E");
	}
	
	@Test (expected=TrainException.class)
	public void LocomotiveInvalidClassification() throws TrainException {
		Locomotive testCar = new Locomotive(198, "test");
	}
	
	@Test
	public void LocomotiveGetPower() throws TrainException {
		Locomotive testCar = new Locomotive(100, "5E");
		int power = testCar.power();
		assertEquals(power, 500);
	}
	
	@Test
	public void LocomotiveToString() throws TrainException {
		Locomotive testCar = new Locomotive(400, "3E");
		assertEquals(testCar.toString(), "Loco(3E)");
	}

}
