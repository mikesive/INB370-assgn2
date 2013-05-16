package asgn2RollingStock;

import asgn2Exceptions.TrainException;

public class Locomotive extends RollingStock {

	String classification;
	Integer pullingPower;

	public Locomotive(Integer grossWeight, String classification)
			throws TrainException {
		super(grossWeight);

		// Checks string Length
		if (classification.length() > 2) {
			throw new TrainException(
					"Classification must be a number between 1 & 9 "
							+ "followed by E, D or S");
		}

		Integer powerClass;
		String powerStringReference;
		String engineType;

		engineType = classification.substring(1);// Split the engine type from
													// String

		powerStringReference = classification.substring(0, 1);// Split the power
																// class from
																// String

		try {
			powerClass = Integer.parseInt(powerStringReference);// convert power
																// class to int
		} catch (NumberFormatException nFE) {
			throw new TrainException(
					"First Character must be number between 1 & 9");
		}

		// Checks power is not 0
		if (powerClass <= 0) {
			throw new TrainException("pulling power must be between 1 & 9");
		}

		// checks correct engine type
		if (!engineType.equals("E") && !engineType.equals("D")
				&& !engineType.equals("S")) {
			throw new TrainException("Engine Type must be E, D, or S");
		}

		// checks not 0 or negative weight
		if (grossWeight <= 0) {
			throw new TrainException("Weight must be positive");
		}

		pullingPower = powerClass * 100;
		this.classification = classification;

	}

	public Integer power() {

		return pullingPower;

	}
	
	/**Returns a description of the rollingstock
	 * @return string description
	 */
	@Override
	public String toString() {
		return "Loco(" + this.classification + ")";
	}
}
