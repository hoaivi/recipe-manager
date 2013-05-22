package psu.team1.common;

/**
 * @author Steve
 */
public class IngredientItem {
	private String ingredientName;
	private double quantity;
	private Unit unit;

	/**
	 * @param ingredientName
	 * @param quantity
	 * @param unit
	 */
	public IngredientItem(String ingredientName, double quantity, Unit unit) {
		this.ingredientName = ingredientName;
		this.quantity = quantity;
		this.unit = unit;
	}

	/**
	 * @return the ingredientName
	 */
	public String getIngredientName() {
		return ingredientName;
	}

	/**
	 * @return the quantity
	 */
	public double getQuantity() {
		return quantity;
	}

	/**
	 * @return the quantityUnit
	 */
	public Unit getUnit() {
		return unit;
	}

}
