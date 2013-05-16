package Test;

import asgn2Exceptions.TrainException;
import asgn2RollingStock.FreightCar;
import asgn2RollingStock.Locomotive;
import asgn2RollingStock.PassengerCar;
import asgn2Train.DepartingTrain;


public class Test {

	/**
	 * @param args
	 * @throws TrainException 
	 */
	public static void main(String[] args) throws TrainException {
		FreightCar freightTest = new FreightCar(100, "G");
		System.out.println(freightTest);
		
		Locomotive locomotiveTest = new Locomotive(100, "1E");
		System.out.println(locomotiveTest);
		
		PassengerCar passengerTest = new PassengerCar(100, 5);
		System.out.println(passengerTest);
		passengerTest.board(3);
		System.out.println(passengerTest);
		passengerTest.alight(2);
		System.out.println(passengerTest);
		System.out.println(passengerTest.board(6));
		System.out.println(passengerTest);
		
		DepartingTrain testTrain = new DepartingTrain();
		testTrain.addCarriage(new Locomotive(100, "5E"));
		testTrain.addCarriage(new PassengerCar(100, 200));
		testTrain.addCarriage(freightTest);
		System.out.println(testTrain);
	}

}