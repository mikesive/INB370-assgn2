package asgn2RollingStock;

public abstract class RollingStock {
	
	Integer grossWeight;
	
	public RollingStock(Integer grossWeight){
		this.grossWeight = grossWeight;
	}
	
	public Integer getGrossWeight(){
		return this.grossWeight;
	}
	
	@Override
	public abstract String toString();
	

}
