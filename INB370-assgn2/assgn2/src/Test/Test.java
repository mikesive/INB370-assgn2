package Test;

import asgn2Exceptions.TrainException;
import asgn2RollingStock.FreightCar;
import asgn2RollingStock.Locomotive;
import asgn2RollingStock.RollingStock;

public class Test {

	/**
	 * @param args
	 * @throws TrainException 
	 */
	public static void main(String[] args) throws TrainException {
		RollingStock freightTest = new FreightCar(100, "G");
		System.out.println(freightTest);
		
		RollingStock locomotiveTest = new Locomotive(100, "01E");
		System.out.println(locomotiveTest);
		

	}

}
