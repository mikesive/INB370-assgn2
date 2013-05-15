package asgn2RollingStock;

import asgn2Exceptions.TrainException;

public class FreightCar extends RollingStock {
	
	String goodsType;
	
	/**Constructors sets up the weight and type of goods carried by the train
	 * @param grossWeight
	 * @param goodsType
	 * @throws TrainException if weight is entered as negative or goods are not right type
	 */
	public FreightCar(Integer grossWeight, String goodsType)
		throws TrainException {
		
		super(grossWeight);
		
		//Tests if weight is negitive
		if (grossWeight <= 0) {
			throw new TrainException("Weight must be positive");
		}
		
		//Tests valid goods type is entered
		if(!goodsType.equals("G") && !goodsType.equals("R") && !goodsType.equals("D")){
			throw new TrainException("Goods type must be G, R or D");
		}
		
		this.goodsType = goodsType;
	}
	
	/**Gets the type of goods the train carries
	 * @return The type of goods the train carries
	 */
	public String goodsType(){
		return this.goodsType;
	}
	
	/**Returns a description of the rollingstock
	 * @return string description
	 */
	@Override
	public String toString(){
		return "Freight ("+ this.goodsType +")";
	}
}
