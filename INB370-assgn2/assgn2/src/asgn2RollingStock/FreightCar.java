package asgn2RollingStock;

import asgn2Exceptions.TrainException;

public class FreightCar extends RollingStock {
	
	String goodsType;
	
	public FreightCar(Integer grossWeight, String goodsType)
		throws TrainException {
		
		super(grossWeight);
		
		if (grossWeight<=0){
			throw new TrainException("Weight must be positive");
		}
		
		if(!goodsType.equals("G") && !goodsType.equals("G") && !goodsType.equals("G")){
			throw new TrainException("Goods type must be G, R or D");
		}
		
		this.goodsType = goodsType;
	}
	
	public String goodsType(){
		return this.goodsType;
	}
	
	@Override
	public String toString(){
		return "Freight ("+ this.goodsType +")";
	}
	
	

}
