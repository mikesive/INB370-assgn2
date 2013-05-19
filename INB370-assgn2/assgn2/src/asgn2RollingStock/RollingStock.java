package asgn2RollingStock;

/**Creates a rolling stock carriage
 * 
 * @author Wayne Maxwell
 *
 */
public abstract class RollingStock {
	
	Integer grossWeight;
	
	/**Constructor intialises the rolling stocks weight
	 * 
	 * @param grossWeight
	 */
	public RollingStock(Integer grossWeight){
		this.grossWeight = grossWeight;
	}
	
	/**Gets rolling stocks weight
	 * 
	 * @return weight of rolling stock
	 */
	public Integer getGrossWeight(){
		return this.grossWeight;
	}
	
	@Override
	public abstract String toString();
	

}
